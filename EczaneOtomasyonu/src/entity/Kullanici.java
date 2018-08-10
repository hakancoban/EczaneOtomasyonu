package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Kullanici")
public class Kullanici implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kullaniciId")
	private long kullaniciId;
	
	@Column(name="kullaniciAd")
	private String kullaniciAd;
	
	@Column(name="kullaniciSoyad")
	private String kullaniciSoyad;
	
	@Column(name="kullaniciSifre")
	private String kullaniciSifre;

	public long getKullaniciId() {
		return kullaniciId;
	}

	public void setKullaniciId(long kullaniciId) {
		this.kullaniciId = kullaniciId;
	}

	public String getKullaniciAd() {
		return kullaniciAd;
	}

	public void setKullaniciAd(String kullaniciAd) {
		this.kullaniciAd = kullaniciAd;
	}

	public String getKullaniciSoyad() {
		return kullaniciSoyad;
	}

	public void setKullaniciSoyad(String kullaniciSoyad) {
		this.kullaniciSoyad = kullaniciSoyad;
	}

	public String getKullaniciSifre() {
		return kullaniciSifre;
	}

	public void setKullaniciSifre(String kullaniciSifre) {
		this.kullaniciSifre = kullaniciSifre;
	}

	
	

}
