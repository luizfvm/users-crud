package com.lf.restfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>RESTful API</h1> 
 * This project is a simple RESTful API with Java and Spring. 
 * In this web service you can POST, GET, PUT and DELETE data from Users.
 */

@SpringBootApplication
public class RestfulapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulapiApplication.class, args);
	}

}
