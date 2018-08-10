package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ilac")
public class Ilac implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ilacId")
	private long ilacId;
	
	@Column(name="ilacAd")
	private String ilacAd;
	
	@Column(name="ilacAciklama")
	private String ilacAciklama;
	
	@Column(name="ilacFiyat")
	private int ilacFiyat;
	
	@ManyToOne @JoinColumn(name="musteriId")
	Musteri musteri;

	public long getIlacId() {
		return ilacId;
	}

	public void setIlacId(long ilacId) {
		this.ilacId = ilacId;
	}

	public String getIlacAd() {
		return ilacAd;
	}

	public void setIlacAd(String ilacAd) {
		this.ilacAd = ilacAd;
	}

	public String getIlacAciklama() {
		return ilacAciklama;
	}

	public void setIlacAciklama(String ilacAciklama) {
		this.ilacAciklama = ilacAciklama;
	}

	public int getIlacFiyat() {
		return ilacFiyat;
	}

	public void setIlacFiyat(Integer ilacFiyat) {
		this.ilacFiyat = ilacFiyat;
	}

	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}

	
	
	
}
