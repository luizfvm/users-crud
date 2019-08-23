package com.lf.restfulapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lf.restfulapi.domain.User;
import com.lf.restfulapi.repository.UserRepository;
import com.lf.restfulapi.services.exception.ObjectNotFoundException;

/**
 * UserService class responsible for managing User objects.
 */

@Service
public class UserService {

	@Autowired
	private UserRepository userRep;

	/**
	 * Find all users
	 * 
	 * @return users list
	 */

	public List<User> findAll() {
		return userRep.findAll();
	}

	/**
	 * Find a user by the id
	 * 
	 * @param id  the user id
	 * @return the user searched. If the id is null, throw ObjectNotFoundException
	 */

	public User findById(String id) {
		Optional<User> user = userRep.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Id not found"));
	}

	/**
	 * Create a new user
	 * 
	 * @param obj  User object
	 * @return new user
	 */

	public User insert(User obj) {
		return userRep.insert(obj);
	}

	/**
	 * Delete a user
	 * 
	 * @param id  the user id
	 */

	public void delete(String id) {
		try {
		findById(id);
		userRep.deleteById(id);
		}
		catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Id not found");
		}
	}

	/**
	 * Update a user
	 * 
	 * @param obj  User object
	 * @return user updated
	 */

	public User update(User obj) {
		try {
		User user = findById(obj.getId());
		updateData(user, obj);
		return userRep.save(user);
		}
		catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Id not found");
		}
	}

	/**
	 * Update a user
	 * 
	 * @param user User object
	 * @param obj  new User object with updated fields
	 */

	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
	}

}
