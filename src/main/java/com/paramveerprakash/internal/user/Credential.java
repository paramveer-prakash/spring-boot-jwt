package com.paramveerprakash.internal.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Credential {
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	@Column(unique = true)
	private String userName;
	private String password;
	
	public Credential(){
		
	}
	
	public Credential(String userName, String password) {
		this.userName=userName;
		this.password=password;
	}

}
