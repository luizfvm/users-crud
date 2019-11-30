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

	public List<User> findAll() {
		return userRep.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRep.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Id not found"));
	}

	public User insert(User obj) {
		return userRep.insert(obj);
	}

	public void delete(String id) {
		try {
		findById(id);
		userRep.deleteById(id);
		}
		catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Id not found");
		}
	}

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

	private void updateData(User obj, User newObj) {
		obj.setName(newObj.getName());
		obj.setEmail(newObj.getEmail());
	}

}
