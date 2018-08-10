package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adminId")
	private long adminId;
	
	@Column(name = "adminAd")
	private String adminAd;
	
	@Column(name = "adminSoyad")
	private String adminSoyad;
	
	@Column(name = "adminSifre")
	private String adminSifre;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminAd() {
		return adminAd;
	}

	public void setAdminAd(String adminAd) {
		this.adminAd = adminAd;
	}

	public String getAdminSoyad() {
		return adminSoyad;
	}

	public void setAdminSoyad(String adminSoyad) {
		this.adminSoyad = adminSoyad;
	}

	public String getAdminSifre() {
		return adminSifre;
	}

	public void setAdminSifre(String adminSifre) {
		this.adminSifre = adminSifre;
	}

	
	

}
