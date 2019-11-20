### RESTful API
---
This project is a simple RESTful API with Java and Spring. In this web service you can POST, GET, PUT and DELETE data from Users.

![Screenshot](https://github.com/luizfvm/restful-api/tree/master/src/main/resources/static/images/restfulapi.PNG)

### Usage
---

luizfvm-restful-api.herokuapp.com/swagger-ui.html

#### User
| Method | Route | Description | Status code
| --- | --- | --- | :---: |
| GET | users/ | Find all users | 200
| GET | users/{id} | Find a user by the id | 200
| POST | user/ | Create a new user | 201
| DELETE | user/{id} | Delete a user | 204
| PUT | user/{id} | Update a user | 204

### Built With
---
* [Spring](https://spring.io) - Framework
* [Maven](https://maven.apache.org) - Dependency Management
* [Tomcat](http://tomcat.apache.org) - Servlet Container
* [MongoDB](https://www.mongodb.com) - NoSQL Database

### License
---
* [MIT](https://choosealicense.com/licenses/mit/)
