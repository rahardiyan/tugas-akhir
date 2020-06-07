package com.apap.be.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "peminjaman_buku")
public class BookBorrowModel implements Serializable {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @NotNull
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @NotNull
	    @Column(name = "tanggal_peminjaman", nullable = false)
	    @JsonFormat(pattern= "dd-MM-yyyy")
	    private Date tanggalPeminjaman;
	    
	    @NotNull
	    @Column(name = "tanggal_pengembalian", nullable = false)
	    @JsonFormat(pattern= "dd-MM-yyyy")
	    private Date tanggalPengembalian;
	    
	  
	    @Column(name = "status")
	    private int statusPeminjaman;
	    
	    @Column(name = "id_buku")
	    private int idBuku;
	    
	    @NotNull
	    @Size(max = 200)
	    @Column(name = "uuid_user", nullable = false)
	    private String uuid_user;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Date getTanggalPeminjaman() {
			return tanggalPeminjaman;
		}

		public void setTanggalPeminjaman(Date tanggalPeminjaman) {
			this.tanggalPeminjaman = tanggalPeminjaman;
		}

		public Date getTanggalPengembalian() {
			return tanggalPengembalian;
		}

		public void setTanggalPengembalian(Date tanggalPengembalian) {
			this.tanggalPengembalian = tanggalPengembalian;
		}

		public int getStatusPeminjaman() {
			return statusPeminjaman;
		}

		public void setStatusPeminjaman(int statusPeminjaman) {
			this.statusPeminjaman = statusPeminjaman;
		}

		public int getIdBuku() {
			return idBuku;
		}

		public void setIdBuku(int idBuku) {
			this.idBuku = idBuku;
		}

		public String getUuid_user() {
			return uuid_user;
		}

		public void setUuid_user(String uuid_user) {
			this.uuid_user = uuid_user;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		

	   // @ManyToMany(cascade = CascadeType.ALL)
	    //@JoinTable(name= "user_peminjamanbuku",
	    //        joinColumns = @JoinColumn(name = "id_peminjaman", referencedColumnName = "id"),
	    //        inverseJoinColumns = @JoinColumn(name = "uuid", referencedColumnName = "uuid_user"))
	    //private Set<BookModel> peminjamanBuku_list;
	    
	    
}