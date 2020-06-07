package com.apap.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.be.model.BookTypeModel;

public interface BookType extends JpaRepository<BookTypeModel, Long>{

}
