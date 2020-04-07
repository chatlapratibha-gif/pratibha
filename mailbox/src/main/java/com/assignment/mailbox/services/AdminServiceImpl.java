package com.assignment.mailbox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.assignment.mailbox.dao.AdminDao;
import com.assignment.mailbox.dao.UserDao;
import com.assignment.mailbox.model.Admin;

@Service
@Component
public class AdminServiceImpl  implements AdminService
{
     @Autowired
	private AdminDao adminDao;

	/*
	 * @Autowired private UserDao userDao;
	 */
	@Override
	public boolean login(Admin admin) {

             
	Optional<Admin>	 a =adminDao.findById(admin.getUsername());
	Admin ad = a.get();
	
	if(ad.getPassword().equals(admin.getPassword()))
	{
		return true;
	}
		
		return false;
	}

	
}

