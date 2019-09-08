### RESTful API
---
This project is a simple RESTful API with Java and Spring Tool Suite that can be tested using Postman. In this web 
service you can POST, GET, PUT and DELETE data from Users.

### Setup
---
* Clone the project
```
https://github.com/luizfvm/restful-api.git
```
* Import the project in your IDE
* Install MongoDB - [Instructions](https://docs.mongodb.com/v3.2/administration/install-community/)
* Create a new database - [Instructions](https://docs.mongodb.com/manual/tutorial/getting-started/)
```
Database name: database / Port: 27017
```
* Open the file application.properties in the project and modify the database name and port if necessary

:open_file_folder: src/main/resources/application.properties
* Run the project
* Test with Postman or whatever tool you may prefer

### Usage
---
#### User
| Method | Route | Description
| --- | --- | --- |
| GET | users/ | Find all users
| GET | users/{id} | Find a user by the id
| POST | user/ | Create a new user
| DELETE | user/{id} | Delete a user
| PUT | user/{id} | Update a user

### Built With
---
* [STS](https://spring.io/tools) - IDE
* [Maven](https://maven.apache.org) - Dependency Management
* [Tomcat](http://tomcat.apache.org) - Servlet Container
* [MongoDB](https://www.mongodb.com) - NoSQL Database

### License
---
* [MIT](https://choosealicense.com/licenses/mit/)