package com.ch_book.ChristianBook.serviceImpl;

import java.util.HashSet;
import java.util.Locale.Category;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ch_book.ChristianBook.entity.Document;
import com.ch_book.ChristianBook.exceptions.GlobalExeptionHandler;
import com.ch_book.ChristianBook.repo.DocumentRepo;
import com.ch_book.ChristianBook.securityConfig.JwtFilter;
import com.ch_book.ChristianBook.service.DocumenrService;

@Service
public class DocumentServiceImpl implements DocumenrService{
    @Autowired
    DocumentRepo documentRepo;

    @Autowired
    JwtFilter jwtFilter;

    @Override
    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
 try {
            if (jwtFilter.isAdmin()) {
                
                   documentRepo.save(getDocumentFromMap(requestMap));
                    return GlobalExeptionHandler.getResponseEntity("Product Added Successfully.", HttpStatus.OK);
         
            } else
                return GlobalExeptionHandler.getResponseEntity(GlobalExeptionHandler.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return GlobalExeptionHandler.getResponseEntity(GlobalExeptionHandler.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

private Document getDocumentFromMap(Map<String, String> requestMap) {
      

      Document document = new Document();
       Set<String> set = new HashSet<>();
       set.add(requestMap.get("author"));
       document.setAuthor(set);
        document.setTitle(requestMap.get("description"));
        document.setPrice(Integer.parseInt(requestMap.get("price")));
        return document;
    }

    @Override
    public ResponseEntity<Document> getDocById(String sku) {
        try {
            return new ResponseEntity<>(documentRepo.getDocumentById(sku), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new Document(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
}
