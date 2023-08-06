package com.ch_book.ChristianBook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ch_book.ChristianBook.entity.Document;

public interface DocumentRepo extends JpaRepository<Document, String> {

Document getDocumentById(@Param("sku") String sku);
    
}
