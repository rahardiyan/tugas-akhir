package com.apap.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.be.model.BookPurchaseModel;

@Repository
public interface BookPurchase extends JpaRepository<BookPurchaseModel, Long> {

	

}
