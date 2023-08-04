package com.ch_book.ChristianBook.securityConfig;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ch_book.ChristianBook.repo.UserRepo;



@Service
public class CustomerUserDetailsService implements UserDetailsService{


    @Autowired
    UserRepo userRepo;


    private com.ch_book.ChristianBook.entity.User userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        userDetail = userRepo.findByEmailId(username);
        if (!Objects.isNull(userDetail))
            return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
        else
            throw new UsernameNotFoundException("User not found.");
    }

   public  com.ch_book.ChristianBook.entity.User userDetail(){

    return userDetail;
   }
}
