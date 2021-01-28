package com.paramveerprakash.internal.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paramveerprakash.internal.user.Credential;
import com.paramveerprakash.internal.user.CredentialService;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	CredentialService credService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if(credService.getCredByUserName(userName).isPresent()) {
			Credential cred = credService.getCredByUserName(userName).get();
			return new User(cred.getUserName(),cred.getPassword(), Collections.emptyList());
		}
		throw new UsernameNotFoundException("User not found");
	}

}
