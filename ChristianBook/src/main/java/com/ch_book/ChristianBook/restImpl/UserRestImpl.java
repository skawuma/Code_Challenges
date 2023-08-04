package com.ch_book.ChristianBook.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ch_book.ChristianBook.exceptions.GlobalExeptionHandler;
import com.ch_book.ChristianBook.rest.UserRest;
import com.ch_book.ChristianBook.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
@ComponentScan
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

     try{
        return userService.signUp(requestMap);

     }catch(Exception ex){

        ex.printStackTrace();
     }

       return GlobalExeptionHandler.getResponseEntity(GlobalExeptionHandler.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    

    	 @PostConstruct
	public void intitRoleAndUser() {
		userService.initRoleAndUser();
		
	}
}
