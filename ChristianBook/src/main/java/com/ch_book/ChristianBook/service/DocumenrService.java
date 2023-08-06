package com.ch_book.ChristianBook.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ch_book.ChristianBook.entity.Document;

public interface DocumenrService {

    ResponseEntity<String> addNewProduct(Map<String, String> requestMap);

    ResponseEntity<Document> getDocById(String sku);
    



}
