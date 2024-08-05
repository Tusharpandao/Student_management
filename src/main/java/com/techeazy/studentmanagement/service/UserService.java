package com.techeazy.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.studentmanagement.entity.Users;
import com.techeazy.studentmanagement.repository.UserRepo;

@Service
public class UserService {
	  @Autowired
	    private UserRepo repo;

	    public Users findByUserName(String username) {
	        return repo.findByUserName(username);
	    }

}
