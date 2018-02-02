# Docs App - Documentation Application

Docs App is an open source content management system project majorly focused on project documentation purposes. This is a complete web application build for maintaing the project documentation. This project is developed on spring framework. 

## Key Concepts

1. Spring Boot
2. Spring Security
3. Spring MVC
4. Thymeleaf
5. Hibernate
6. JPA

## Project Requirements
- JDK-7
- Postgresql 9.5 and above.
- tomcat7 (used during development).

## Eclipse run instructions
 - Before running the application please run the Database Script File (docs-app-DB-Script.sql) in your database.
 - If you face any problems while running the applicaiton on tomcat7 server, try this procedure.
   - Go to project properties -> Project Facets. uncheck the Dynamic Web Module checkbox. 
   - To the right, you can find the Runtimes tab. Go to Runtimes tab and check the tomcat7 checkbox and click apply.
   - check the Dynamic Web Module checkbox and click apply.
   - You can run the application on tomcat7 now.
