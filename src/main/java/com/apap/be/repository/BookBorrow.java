package com.apap.be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.be.model.BookBorrowModel;

@Repository
public interface BookBorrow extends JpaRepository<BookBorrowModel, Long>{
	Optional<BookBorrowModel> findById(long id);

}
