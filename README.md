# Task Manager Application

This is a task manager application built with Java, Spring Boot, and Maven. It allows users to sign up, sign in, and manage their tasks.

## Features

- User Registration and Authentication
- Create, Read, Update, and Delete (CRUD) operations for tasks
- JWT-based authentication
- Task management for individual users

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Maven
- JPA/Hibernate
- H2 Database (for development)
- JWT (JSON Web Tokens)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Shubham-Mi/todo-list.git
    cd todo-list
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### API Endpoints

#### User Authentication

- **Sign Up**
    ```http
    POST /api/v1/signup
    Content-Type: application/json

    {
      "name": "Full name",
      "email": "email@example.com",
      "password": "password"
    }
    ```

- **Sign In**
    ```http
    POST /api/v1/signin
    Content-Type: application/json

    {
      "email": "email@example.com",
      "password": "password"
    }
    ```

#### Task Management

- **Get All Tasks**
    ```http
    GET /api/v1/tasks
    Authorization: Bearer <JWT_TOKEN>
    ```

- **Create Task**
    ```http
    POST /api/v1/tasks
    Authorization: Bearer <JWT_TOKEN>
    Content-Type: application/json

    {
      "title": "New Task",
      "description": "Task description",
      "status": "PENDING"
    }
    ```

- **Get Task by ID**
    ```http
    GET /api/v1/tasks/{taskId}
    Authorization: Bearer <JWT_TOKEN>
    ```

- **Update Task**
    ```http
    PUT /api/v1/tasks/{taskId}
    Authorization: Bearer <JWT_TOKEN>
    Content-Type: application/json

    {
      "title": "Updated Task",
      "description": "Updated description",
      "status": "COMPLETED"
    }
    ```

- **Delete Task**
    ```http
    DELETE /api/v1/tasks/{taskId}
    Authorization: Bearer <JWT_TOKEN>
    ```
