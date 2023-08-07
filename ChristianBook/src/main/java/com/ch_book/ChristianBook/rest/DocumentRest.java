package com.ch_book.ChristianBook.rest;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ch_book.ChristianBook.entity.Document;

@RequestMapping(path="api/v1/document")
public interface DocumentRest {

  @PostMapping(path = "/addDoc")
    ResponseEntity<Document> addNewDoc(@RequestBody Document document);    

@PostMapping(path = "/add")
    ResponseEntity<String> addNewDocument(@RequestBody Map<String, String> requestMap);  

@GetMapping(path = "/getById/{id}")
    ResponseEntity<Document> getDocById(@PathVariable String sku);

@GetMapping(path = "/search")
public ResponseEntity<Document> viewDoc(@RequestParam String sku);

}