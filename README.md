AIU Hotel Reservation REST API

Assignment 4 – Project Defense

Student: Aisha Mussina
Course: Object-Oriented Programming
University: Astana IT University

This project is a Hotel Reservation REST API developed using Java and Spring Boot with PostgreSQL as a database. The main goal of the project is to demonstrate object-oriented programming principles, REST architecture, JDBC database interaction, and clean layered system design. The system allows managing hotel guests and rooms, performing CRUD operations, and exchanging data in JSON format through REST endpoints.

The application follows layered architecture, where controllers handle HTTP requests, services contain business logic and validation, repositories perform JDBC database operations, and domain classes represent the core entities of the system. This separation improves maintainability and extensibility of the project.

Two main entities are implemented: GuestEntity and RoomEntity. Encapsulation is achieved using private fields with getters and setters, inheritance is demonstrated through Room, SingleRoom, and DoubleRoom classes, polymorphism is shown when different room types are processed via the base Room type, and abstraction is implemented through service and repository interfaces.

PostgreSQL is connected through JDBC using DataSource, Connection, PreparedStatement, and ResultSet. Two tables, guests and rooms, are created in the database. Full CRUD functionality is implemented for both entities. All database access logic is separated from business logic inside repository classes.

The REST API supports JSON request and response formats and provides endpoints for creating, reading, updating, and deleting guests and rooms. In addition, an in-memory Data Pool is implemented for guests, which supports searching, filtering, and sorting operations using Java Streams and Lambda expressions.

Custom exceptions such as GuestNotFoundException and InvalidGuestException are used to handle invalid input and missing data, while a global exception handler ensures application stability.

SOLID principles are applied, especially Dependency Inversion Principle. Service classes depend on the generic BaseJdbcRepository interface instead of concrete implementations, allowing repository implementations to be replaced without modifying service logic. This improves flexibility and testability.

Several Java language features are demonstrated in the project, including Generics in BaseJdbcRepository, Lambda Expressions in DataPool processing, and RTTI (Runtime Type Information) using instanceof checks during room creation.

Design patterns are also implemented. Factory Pattern is used in RoomFactory to create SingleRoom or DoubleRoom based on input type, and Builder Pattern is used in GuestBuilder to construct GuestEntity objects safely.

The project can be launched from IntelliJ IDEA after configuring PostgreSQL credentials in application.properties. REST endpoints can be tested via browser, Postman, or IntelliJ HTTP Client.

API Documentation & Testing (Swagger UI)
Swagger UI is integrated into this project to provide interactive REST API documentation and testing. After starting the application, Swagger UI is available at: http://localhost:8080/swagger-ui/index.html Swagger automatically scans all REST controllers and generates API documentation with live testing support for GET, POST, PUT and DELETE requests. It was used to verify CRUD operations and JSON responses during development and project defense.

Main REST endpoints include:

http://localhost:8080/jdbc/guests

http://localhost:8080/jdbc/rooms

Additional Data Pool endpoints include:

http://localhost:8080/api/guests/pool/refresh

http://localhost:8080/api/guests/pool/search?q=ai

http://localhost:8080/api/guests/pool/filter?minAge=20

http://localhost:8080/api/guests/pool/sort/age
localhost:8080

This project demonstrates complete backend architecture with OOP principles, JDBC database integration, RESTful API design, SOLID principles, modern Java features, and design patterns, and is fully ready for project defense.
