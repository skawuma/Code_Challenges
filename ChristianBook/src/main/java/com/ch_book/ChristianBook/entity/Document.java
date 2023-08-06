package com.ch_book.ChristianBook.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQuery(name = "Product.getProductById", query = "select new com.ch_book.ChristianBook.entity.Document(p.sku,p.author,p.title,p.price) from Document p where p.sku=:sku")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="document")
public class Document {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
    private String sku;
    private Set<String> author;
    private String title;
    private Integer price;
    
}
