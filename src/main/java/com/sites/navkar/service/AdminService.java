package com.sites.navkar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sites.navkar.entity.Admin;
import com.sites.navkar.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;

	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

}
