package repository;

import com.foriba.library.BaseRepository;

import entity.Kullanici;

public class KullaniciRepository extends BaseRepository<Kullanici>{
	public KullaniciRepository() {
		super(Kullanici.class);
	}
}
