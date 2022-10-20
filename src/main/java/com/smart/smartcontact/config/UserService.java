package com.smart.smartcontact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.smartcontact.dao.UserRepo;
import com.smart.smartcontact.entites.User;

public class UserService implements UserDetailsService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // fetching user from database
		User user = userRepo.getUserByEmail(username);
        System.out.println("---------====---------//////////----------"+user);

		if (user == null) {
			throw new UsernameNotFoundException("Could not found user !!");
		}

		CustomUserDetails customUserDetails = new CustomUserDetails(user);

		return customUserDetails;
    }
    
}
