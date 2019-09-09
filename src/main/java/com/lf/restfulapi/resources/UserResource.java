package com.lf.restfulapi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lf.restfulapi.domain.User;
import com.lf.restfulapi.dto.UserDTO;
import com.lf.restfulapi.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * UserResource class responsible for implementing HTTP methods.
 */

@Api(value="User Management System")
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userServ;

	@Autowired
	private UserDTO userDto;

	/**
	 * HTTP GET method to retrieve a representation of resources.
	 * 
	 * @return HTTP 200 response code
	 */
	
	@ApiOperation(value = "Find all users")
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> listUser = userServ.findAll();
		List<UserDTO> listDto = listUser.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	/**
	 * HTTP GET method to retrieve a representation of a resource.
	 * 
	 * @param id  the user id
	 * @return HTTP 200 response code
	 */

	@ApiOperation(value = "Find a user by the id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userServ.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}

	/**
	 * HTTP POST method to create new resources.
	 * 
	 * @param objDto  UserDTO object
	 * @return HTTP 201 response code
	 */

	@ApiOperation(value = "Create a new user")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody UserDTO objDto) {
		User obj = userDto.fromDTO(objDto);
		obj = userServ.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * HTTP DELETE method to delete a resource.
	 * 
	 * @param id  the user id
	 * @return HTTP 204 response code
	 */

	@ApiOperation(value = "Delete a user")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userServ.delete(id);
		return ResponseEntity.noContent().build();
	}

	/**
	 * HTTP PUT method to update a known resource.
	 * 
	 * @param objDto  UserDTO object
	 * @param id  the user id
	 * @return HTTP 204 response code
	 */

	@ApiOperation(value = "Update a user")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = userDto.fromDTO(objDto);
		obj.setId(id);
		obj = userServ.update(obj);
		return ResponseEntity.noContent().build();
	}

}
