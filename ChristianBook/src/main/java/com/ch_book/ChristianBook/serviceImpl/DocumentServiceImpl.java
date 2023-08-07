package com.ch_book.ChristianBook.serviceImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale.Category;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ch_book.ChristianBook.entity.Document;
import com.ch_book.ChristianBook.exceptions.DocumentNotFountException;
import com.ch_book.ChristianBook.exceptions.GlobalExeptionHandler;
import com.ch_book.ChristianBook.exceptions.RecordAlreadyPresentException;
import com.ch_book.ChristianBook.repo.DocumentRepo;
import com.ch_book.ChristianBook.securityConfig.JwtFilter;
import com.ch_book.ChristianBook.service.DocumenrService;

@Service
public class DocumentServiceImpl implements DocumenrService {
    @Autowired
    DocumentRepo documentRepo;

    @Autowired
    JwtFilter jwtFilter;

    @Override
    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
        try {
            if (jwtFilter.isAdmin()) {

                documentRepo.save(getDocumentFromMap(requestMap));
                return GlobalExeptionHandler.getResponseEntity("Document Added Successfully.", HttpStatus.OK);

            } else
                return GlobalExeptionHandler.getResponseEntity(GlobalExeptionHandler.UNAUTHORIZED_ACCESS,
                        HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return GlobalExeptionHandler.getResponseEntity(GlobalExeptionHandler.SOMETHING_WENT_WRONG,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Document getDocumentFromMap(Map<String, String> requestMap) {

        Document document = new Document();
        document.setSku(requestMap.get("sku"));
        Set<String> set = new HashSet<>();  
        set.add(requestMap.get("author"));
        for (final String string : set) {
            System.out.println(string);
             document.setAuthor(set);
             System.out.println("Clean Out!!");
              System.out.println(string);
        }
               document.setTitle(requestMap.get("title"));
        document.setPrice(Integer.parseInt(requestMap.get("price")));
        return document;
    
    }

    @Override
    public ResponseEntity<Document> getDocById(String sku) {
        try {
            return new ResponseEntity<>(documentRepo.getDocumentBySku(sku), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new Document(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public Document viewDocument(String sku) {
        if (sku == null)
            throw new DocumentNotFountException("Enter a valid SKU");
        Optional<Document> document = documentRepo.findById(sku);
        if (!document.isPresent())
            throw new DocumentNotFountException("Enter a valid SKU");
        else
            return document.get();
    }

    @Override
    public ResponseEntity<Document> addDocument(Document document) {
        {
            Optional<Document> findById = documentRepo.findById(document.getSku());
            try {
            if (!findById.isPresent()) {
                documentRepo.save(document);
                return new ResponseEntity<>(document,HttpStatus.OK);
            } else
                throw new RecordAlreadyPresentException("Document with number: " + document.getSku() + " already present");
        }
            catch(RecordAlreadyPresentException e)
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

}
}
