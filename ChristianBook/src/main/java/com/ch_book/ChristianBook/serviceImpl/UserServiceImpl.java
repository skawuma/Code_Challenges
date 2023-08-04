package com.ch_book.ChristianBook.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ch_book.ChristianBook.entity.User;
import com.ch_book.ChristianBook.exceptions.GlobalExeptionHandler;
import com.ch_book.ChristianBook.repo.UserRepo;
import com.ch_book.ChristianBook.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

        try {
            if (validateSignUpMap(requestMap)) {
                User user = userRepo.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(user)) {

                    userRepo.save(getUserFromMap(requestMap));
                    return GlobalExeptionHandler.getResponseEntity("Successfully Registered.", HttpStatus.OK);
                } else {
                    return GlobalExeptionHandler.getResponseEntity("Email already exits.", HttpStatus.BAD_REQUEST);
                }

            } else {
                return GlobalExeptionHandler.getResponseEntity(GlobalExeptionHandler.INVALID_DATA,
                        HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return GlobalExeptionHandler.getResponseEntity(GlobalExeptionHandler.SOMETHING_WENT_WRONG,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // creaate UserObject
    private User getUserFromMap(Map<String, String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(getEncodedPassword(requestMap.get("password")));
        user.setRole("User");
        return user;
    }

    // Method to Encode password so that its invisible to clients while getting
    // retrived in database tables
    private String getEncodedPassword(String password) {

        return passwordEncoder.encode(password);
    }

    // Check whether user satifies all fields inorder to signup
    private boolean validateSignUpMap(Map<String, String> requestMap) {

        if (requestMap.containsKey("name") && requestMap.containsKey("email") && requestMap.containsKey("password")) {
            return true;
        }
        return false;
    }
 //Create Predefined Roles For Default admin and user
    @Override
    public void initRoleAndUser() {
        User adminUser = new User();
        adminUser.setName("Administrator1");
        adminUser.setEmail("admin@gmail.com");
        adminUser.setPassword(getEncodedPassword("admin@pass"));
        adminUser.setRole("Admin");
        userRepo.save(adminUser);

        User emplUser = new User();

         emplUser.setName("Employee1");
        emplUser.setEmail("user@gmail.com");
        emplUser.setPassword(getEncodedPassword("user@pass"));
        emplUser.setRole("User");
        userRepo.save( emplUser);




    }

}
