# CINEMA APPLICATION

Cinema application is the web-application using user authentication, registration for users, 
role access to specific resources, information receiving from the user, field values validation 
from user and data transfer objects in response, having CRUD functionality of entities as user, 
cinema hall, movie, ticket, movie session, order, shopping cart to execute according user request.
Implementing the following functionality:

POST: /register - all
GET: /cinema-halls - user/admin
POST: /cinema-halls - admin
GET: /movies - user/admin
POST: /movies - admin
GET: /movie-sessions/available - user/admin
GET: /movie-sessions/{id} - user/admin
POST: /movie-sessions - admin
PUT: /movie-sessions/{id} - admin
DELETE: /movie-sessions/{id} - admin
GET: /orders - user
POST: /orders/complete - user
PUT: /shopping-carts/movie-sessions - user
GET: /shopping-carts/by-user - user
GET: /users/by-email - admin

## Installing
1. Install [IntelliJ IDEA Ultimate](https://www.jetbrains.com/ru-ru/idea/download)
    - fork cinema-app project;
   
2. Install [MySgl DB](https://dev.mysql.com/doc/refman/8.0/en/installing.html)
    - creating a [new MySQL Connection](https://dev.mysql.com/doc/workbench/en/wb-getting-started-tutorial-create-connection.html)
3. Input values(login, password, url to DB) to src/main/resources/db.properties for connecting 
   with MySql DB;
4. Install [Tomcat](https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.50/bin/)
    - add Tomcat configuration

5. Run Tomcat.

## Technologies, tools


- Java 11
- Hibernate
- Spring Web
- Spring Security
- MySQL
- Maven
- Tomcat
