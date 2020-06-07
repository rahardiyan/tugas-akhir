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
@Table(name = "pengadaan_buku")
public class BookPurchaseModel implements Serializable {
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
	    private int jumlah;

	    @Column(name = "harga")
	    private int harga;
	    
	    @Column(name = "status")
	    private int statusPengadaan;

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

		public int getJumlah() {
			return jumlah;
		}

		public void setJumlah(int jumlah) {
			this.jumlah = jumlah;
		}

		public int getHarga() {
			return harga;
		}

		public void setHarga(int harga) {
			this.harga = harga;
		}

		public int getStatusPengadaan() {
			return statusPengadaan;
		}

		public void setStatusPengadaan(int statusPengadaan) {
			this.statusPengadaan = statusPengadaan;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    //@ManyToMany(cascade = CascadeType.ALL)
	    //@JoinTable(name= "user_pengadaanbuku",
	      //      joinColumns = @JoinColumn(name = "id_pengadaan", referencedColumnName = "id"),
	      //      inverseJoinColumns = @JoinColumn(name = "uuid", referencedColumnName = "uuid_user"))
	    //private Set<BookModel> pengadaanBuku_list;

}