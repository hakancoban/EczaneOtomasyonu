package repository;

import com.foriba.library.BaseRepository;

import entity.Admin;


public class AdminRepository extends BaseRepository<Admin> {
	public AdminRepository() {
		super(Admin.class);
	}
}
