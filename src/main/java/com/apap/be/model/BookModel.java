package com.apap.be.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "buku")
public class BookModel implements Serializable {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @NotNull
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @NotNull
	    @Size(max = 200)
	    @Column(name = "judul", nullable = false)
	    private String judul;

	    @NotNull
	    @Size(max = 200)
	    @Column(name = "pengarang", nullable = false)
	    private String pengarang;
	    
	    @NotNull
	    @Size(max = 200)
	    @Column(name = "penerbit", nullable = false)
	    private String penerbit;
	    
	  
	    
	    @Column(name = "jumlah")
	    private int jumlahBuku;

	    @Column(name = "id_jenis_buku")
	    private int idJenisBuku;


	    public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getJudul() {
			return judul;
		}

		public void setJudul(String judul) {
			this.judul = judul;
		}

		public String getPengarang() {
			return pengarang;
		}

		public void setPengarang(String pengarang) {
			this.pengarang = pengarang;
		}

		public String getPenerbit() {
			return penerbit;
		}

		public void setPenerbit(String penerbit) {
			this.penerbit = penerbit;
		}

		public int getJumlahBuku() {
			return jumlahBuku;
		}

		public void setJumlahBuku(int jumlahBuku) {
			this.jumlahBuku = jumlahBuku;
		}

		public int getIdJenisBuku() {
			return idJenisBuku;
		}

		public void setIdJenisBuku(int idJenisBuku) {
			this.idJenisBuku = idJenisBuku;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	   
	    
}