
package com.lf.restfulapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lf.restfulapi.domain.User;
import com.lf.restfulapi.repository.UserRepository;

/**
 * DemoData class responsible for initial database load.
 */

@Configuration
public class DemoData implements CommandLineRunner {

	@Autowired
	private UserRepository userRep;

	@Override
	public void run(String... arg0) throws Exception {

		userRep.deleteAll();

		User user1 = new User(null, "user1", "user1@gmail.com");
		User user2 = new User(null, "user2", "user2@gmail.com");
		User user3 = new User(null, "user3", "user3@gmail.com");
		User user4 = new User(null, "user4", "user4@gmail.com");

		userRep.saveAll(Arrays.asList(user1, user2, user3, user4));

	}

}