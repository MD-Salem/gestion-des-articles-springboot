# Articles Management System

A Spring Boot application for managing articles with JWT authentication.

## Installation & Running Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

### Backend Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/MD-Salem/gestion-des-articles-springboot.git
   cd articles
   ```

2. **Database Setup**
   - Create a MySQL database named `articles_db`
   - Update `src/main/resources/application.properties` with your database credentials

3. **Build & Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   The backend API will be available at `http://localhost:8080`

### Frontend Setup

1. **Clone the Frontend Repository**
   ```bash
   git clone https://github.com/medsaddemhamdi/articles-frontend.git
   cd articles-frontend
   ```

2. Follow the setup instructions in the frontend repository's README

## API Documentation

Once the application is running, you can access the API documentation at:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- API Docs: `http://localhost:8080/v3/api-docs`

## Features

- Article management (CRUD operations)
- Author management
- User authentication with JWT
- Role-based access control
- RESTful API endpoints
- Swagger documentation