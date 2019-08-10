### RESTful API
---
This project is a simple RESTful API with Java and Spring Tool Suite that can be tested using Postman. In this webservice you can POST, GET, PUT and DELETE data from Users.

### Setup
---
* Install Spring Tool Suite
* Import the project
* Install MongoDB - [Documentation](https://docs.mongodb.com/v3.2/administration/install-community/)
* Create a new database - [Documentation](https://docs.mongodb.com/manual/tutorial/getting-started/)
* Open the file application.properties in the project and modify the database name and port
* Run the project
* Test with Postman or whatever tool you may prefer

### Usage
---
#### Create a new user
* Select POST method
* Type the following endpoint
```
http://localhost:8080/users/
```
* Select Body > Raw > JSON and type
```
{
    "name": "New user",
    "email": "new.user@gmail.com"
}
```
* Click on Send
---
#### List all users
* Select GET method
* Type the following endpoint
```
http://localhost:8080/users/
```

* Click on Send

---
#### Update a user
* Select PUT method
* Type the following endpoint
```
http://localhost:8080/users/"user id you want to update"
```
* Select Body > Raw > JSON and type
```
{
    "name": "User new name",
    "email": "user-new-email@gmail.com"
}
```

* Click on Send
---
#### Delete a user
* Select DELETE method
* Type the following endpoint
```
http://localhost:8080/users/"user id you want to delete"
```
* Click on Send


### Built With
---
* [STS](https://spring.io/tools) - IDE
* [Maven](https://maven.apache.org) - Dependency Management
* [Tomcat](http://tomcat.apache.org) - Servlet Container
* [MongoDB](https://www.mongodb.com) - NoSQL Database

### License
---
* [MIT](https://choosealicense.com/licenses/mit/)