package com.apap.be.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apap.be.model.BookModel;

@Repository
public interface Book extends JpaRepository<BookModel, Long> {

	Optional<BookModel> findById(long id);
	
	@Query(value = "SELECT\n" + 
			"	bk.id,\n" + 
			"    bk.id_jenis_buku,\n" + 
			"    bk.judul,\n" + 
			"    bk.penerbit,\n" + 
			"    bk.pengarang,\n" + 
			"	(\n" + 
			"        bk.jumlah - (select count(*) from peminjaman_buku pb where pb.id_buku = bk.id and status <> 1 and status <> 4)\n" + 
			"    ) as jumlah\n" + 
			"from buku bk", nativeQuery = true)
    public List<BookModel> GetAllBook();

}
