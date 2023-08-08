package com.ch_book.ChristianBook.entity;

import java.io.Serializable;
import java.util.Set;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQuery(name = "Document.getDocumentBySku", query = "select new com.ch_book.ChristianBook.entity.Document(p.sku,p.author,p.title,p.price) from Document p where p.sku=:sku")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="document")
public class Document implements Serializable {

    @Id
    private String sku;
    private String  author;
    private String title;
    private Integer price;
    
}
