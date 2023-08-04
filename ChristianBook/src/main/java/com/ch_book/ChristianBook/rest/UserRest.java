package com.ch_book.ChristianBook.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(path="api/v1/user")
public interface UserRest {

    @PostMapping(path= "/signup")
    public ResponseEntity <String> signUp(@RequestBody(required =true)Map<String, String> requestMap);
    
    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap);
}
