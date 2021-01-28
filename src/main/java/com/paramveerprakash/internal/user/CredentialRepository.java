package com.paramveerprakash.internal.user;

import org.springframework.data.repository.CrudRepository;
import java.lang.String;
import com.paramveerprakash.internal.user.Credential;
import java.util.List;

public interface CredentialRepository extends CrudRepository<Credential, String>{
	
	List<Credential> findByUserName(String userName);

}
