package com.SmartContactManager.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.SmartContactManager.config.CustomUserDetails;
import com.SmartContactManager.dao.UserRepository;
import com.SmartContactManager.entities.User;

public class UserDetailsServiceimpl implements UserDetailsService {
	@Autowired
	private UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userrepo.getUserByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("Could not found user");
		}
		CustomUserDetails cud=new CustomUserDetails(user);
		return cud;
	}

}
