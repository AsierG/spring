spring-mvc-sample
============

This application is a web application example for practice.  It’s based on Spring 4 without web.xml, Spring MVC, Spring Data JPA, AOP, internationalization and Bootstrap 3.

Prerequisites
-------------
You will need to following tools in order to work with this project and code

* git 
* JDK 1.7+ 
* Maven 3.x+ 
* PostgreSQL
* An IDE of your choice.  (Eclipse, IntelliJ, Spring STS, Netbeans, etc.)

Getting Started
---------------
To run this project locally, perform the following steps.

* Clone project to your machine
* Import the project into your IDE using the maven pom.xml.  In spring STS suite this is done by importing an existing maven project
* Run the JUnit tests in the src/test/java folder.  If all pass you are good to go.
* The database is configured with postgreSQL. In the sample-config.properties file the database settings can be found and in the /sql/init database/postgresql.sql there is the database creation script. The database can be exchanged for any other desired one (remember to add the driver in the pom.xml) :
* The application can be launched with the following maven command: mvn tomcat7:run-war -Dmaven.tomcat.port=8080
