# Online Course Registration Portal demo

Students shall login using credentials and shall view, register courses and see their profile

AngularJS used for frontend and MySQL for backend
Spring MVC 4 container runs on middleware and provide REST controllers for operations
Hibernate 4 is used for ORM to interact with backend

Pre-requisites
---------------

- MySQL database
- Tomcat 8 container 


How to build 
---------------

This is a maven artifact, It can be imported to eclipse as Maven Project and run as 'Maven Install' 
	
Alternatively, it can be run from CLI at root of src folder as 
	
```
	mvn clean install
```

How to test
---------------

src/main/resources/import.sql contains default data for User and courses . 

Use test/test or admin/admin for login

tomcat 8 container is used for testing
	

