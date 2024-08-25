package com.techeazy.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techeazy.studentmanagement.entity.UserPrincipal;
import com.techeazy.studentmanagement.entity.Users;
import com.techeazy.studentmanagement.repository.UserRepo;
@Service
public  class MyUserDetailsService implements UserDetailsService {
	   
	  @Autowired
	    private UserRepo userRepo;


	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Users user = userRepo.findByUserName(username);
	        if (user == null) {
	            System.out.println("User Not Found");
	            throw new UsernameNotFoundException("user not found");
	        }
	        
	        return new UserPrincipal(user);
	    }
}
