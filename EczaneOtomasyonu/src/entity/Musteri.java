package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Musteri")
public class Musteri implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="musteriId")
	private long musteriId;
	
	@Column(name="musteriAd")
	private String musteriAd;
	
	@Column(name="musteriSoyad")
	private String musteriSoyad;
	
	@OneToMany(mappedBy="musteri",cascade = CascadeType.ALL)
	private List<Ilac> musteriIlacList;

	public long getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(long musteriId) {
		this.musteriId = musteriId;
	}

	public String getMusteriAd() {
		return musteriAd;
	}

	public void setMusteriAd(String musteriAd) {
		this.musteriAd = musteriAd;
	}

	public String getMusteriSoyad() {
		return musteriSoyad;
	}

	public void setMusteriSoyad(String musteriSoyad) {
		this.musteriSoyad = musteriSoyad;
	}

	public List<Ilac> getMusteriIlacList() {
		return musteriIlacList;
	}

	public void setMusteriIlacList(List<Ilac> musteriIlacList) {
		this.musteriIlacList = musteriIlacList;
	}
	
	
			
}
