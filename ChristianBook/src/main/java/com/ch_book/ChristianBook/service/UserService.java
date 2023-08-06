package com.ch_book.ChristianBook.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ch_book.ChristianBook.entity.JwtResponse;

public interface UserService {

    ResponseEntity<String> signUp(Map<String,String>requestMap);
    public void initRoleAndUser();
    ResponseEntity<String> login(Map<String, String> requestMap);

   public JwtResponse login1(Map<String, String> requestMap);
    
}
