package com.ch_book.ChristianBook.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch_book.ChristianBook.entity.Document;

@RequestMapping(path="api/v1/product")
public interface DocumentRest {

@PostMapping(path = "/add")
    ResponseEntity<String> addNewDocument(@RequestBody Map<String, String> requestMap);  

@GetMapping(path = "/getById/{id}")
    ResponseEntity<Document> getDocById(@PathVariable String sku);

}