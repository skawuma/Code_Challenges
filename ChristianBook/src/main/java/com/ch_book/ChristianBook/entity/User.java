package com.ch_book.ChristianBook.entity;

import java.io.Serializable;

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


@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=:email")


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class User  implements Serializable{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String role;


    
}
