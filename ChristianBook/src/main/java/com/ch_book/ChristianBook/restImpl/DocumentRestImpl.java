package com.ch_book.ChristianBook.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ch_book.ChristianBook.entity.Document;
import com.ch_book.ChristianBook.exceptions.GlobalExeptionHandler;
import com.ch_book.ChristianBook.rest.DocumentRest;
import com.ch_book.ChristianBook.service.DocumenrService;

@RestController
@ComponentScan
public class DocumentRestImpl implements DocumentRest{

    @Autowired
    DocumenrService documentService;

    @Override
    public ResponseEntity<String> addNewDocument(Map<String, String> requestMap) {
       try {
            return  documentService.addNewProduct(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return GlobalExeptionHandler.getResponseEntity(GlobalExeptionHandler.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Document> getDocById(String sku) {
            try {
            return  documentService.getDocById(sku);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new Document(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
