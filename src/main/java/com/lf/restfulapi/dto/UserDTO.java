package com.lf.restfulapi.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lf.restfulapi.domain.User;


/**
 * UserDTO class responsible for carrying specific data between processes.
 */

@JsonPropertyOrder({ "id", "name", "email" })
@SpringBootApplication
public class UserDTO extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	@NotEmpty(message="Name cannot be null or empty")
	@Size(min = 4, max = 20, message = "Name must be between 4 and 20 characters")
	private String name;
	
	@NotEmpty(message="Email cannot be null or empty")
	@Email(message = "Email should be valid")
	private String email;

	public UserDTO() {
	}

	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
	
	@JsonProperty("id")
	public String getUserId() {
		return id;
	}

	public void setUserId(String id) {
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
		return new User(objDto.getUserId(), objDto.getName(), objDto.getEmail());
	}

}
