package com.lf.restfulapi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
		List<UserDTO> listUserDto = listUser.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		for (UserDTO userDto : listUserDto) {
			addHATEOAS(userDto);
		}
		return ResponseEntity.ok().body(listUserDto);
	}

	@ApiOperation(value = "Find a user by the id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userServ.findById(id);
		UserDTO userDto = new UserDTO(user);
		addHATEOAS(userDto);
		return ResponseEntity.ok().body(userDto);
	}

	@ApiOperation(value = "Create a new user")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody UserDTO obj) {
		User user = userDto.fromDTO(obj);
		user = userServ.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		addHATEOAS(obj);
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Delete a user")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userServ.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Update a user")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody UserDTO obj, @PathVariable String id) {
		User user = userDto.fromDTO(obj);
		user.setId(id);
		user = userServ.update(user);
		return ResponseEntity.noContent().build();
	}
	
	private void addHATEOAS(UserDTO obj) {
		obj.add(linkTo(methodOn(UserResource.class).findById(obj.getUserId())).withSelfRel());
	}

}
