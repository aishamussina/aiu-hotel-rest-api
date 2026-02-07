# AIU Hotel REST API

Assignment 4 

This project is a simple Hotel Reservation REST API created using Spring Boot.

The system allows to work with guests and rooms data stored in PostgreSQL database.
Data is returned in JSON format through REST endpoints.

## Technologies
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Project functionality
- Connects to PostgreSQL database
- Reads data from database
- Returns JSON responses
- Uses REST controllers
- Uses entities and repositories

## Endpoints

Guests:
- GET /api/guests

Rooms:
- GET /api/rooms

## How to run project
1. Open project in IntelliJ IDEA
2. Set database username and password in application.properties
3. Run HotelRestApiApplication
4. Open in browser:

http://localhost:8080/api/guests

---
## REST API Endpoints

### Guests (JDBC)

GET http://localhost:8080/jdbc/guests  
POST http://localhost:8080/jdbc/guests  
PUT http://localhost:8080/jdbc/guests/{id}  
DELETE http://localhost:8080/jdbc/guests/{id}

### Rooms (JDBC)

GET http://localhost:8080/jdbc/rooms  
POST http://localhost:8080/jdbc/rooms  
PUT http://localhost:8080/jdbc/rooms/{roomNumber}  
DELETE http://localhost:8080/jdbc/rooms/{roomNumber}

### Data Pool (Streams + Lambda)

GET http://localhost:8080/api/guests/pool/refresh  
GET http://localhost:8080/api/guests/pool  
GET http://localhost:8080/api/guests/pool/search?q=value  
GET http://localhost:8080/api/guests/pool/filter?minAge=20  
GET http://localhost:8080/api/guests/pool/sort/age


Student: Aisha Mussina  
Course: Object-Oriented Programming  
University: Astana IT University


http://localhost:8080/api/guests
http://localhost:8080/api/rooms

