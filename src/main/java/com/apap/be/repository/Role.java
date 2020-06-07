package com.apap.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.be.model.RoleModel;

@Repository
public interface Role extends JpaRepository<RoleModel, Long> {
	static Object findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
