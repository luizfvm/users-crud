package com.lf.restfulapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lf.restfulapi.domain.User;

/**
 * UserDTO class responsible for carrying specific data between processes.
 */

@SpringBootApplication
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	@NotNull(message="Cannot be null")
	private String name;
	
	@NotNull(message="Cannot be null")
	private String email;

	public UserDTO() {
	}

	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
