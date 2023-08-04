package com.ch_book.ChristianBook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ch_book.ChristianBook.entity.User;

public interface UserRepo  extends JpaRepository<User,Integer>{

    User findByEmailId(@Param ("email") String email);


    
}
