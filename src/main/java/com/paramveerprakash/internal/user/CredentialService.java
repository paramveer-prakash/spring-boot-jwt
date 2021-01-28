package com.paramveerprakash.internal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredentialService {
	
	@Autowired
	CredentialRepository credRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void createCreds(Credential cred) {
		String encoded = passwordEncoder.encode(cred.getPassword());
		cred.setPassword(encoded);
		credRepo.save(cred);
	}
	
	public Optional<Credential> getCredByUserName(String userName) {
		return credRepo.findByUserName(userName).stream().findFirst();
	}

}
