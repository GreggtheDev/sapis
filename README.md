# Sapis - Secure API with Spring Boot

## Overview
**Sapis** is a Spring Boot-based application that implements secure APIs using Spring Security. The project supports authentication, authorization, and role-based access control (RBAC) with JWT (JSON Web Token) integration.

### Features:
- Basic authentication with Spring Security
- Role-Based Access Control (RBAC) using `@PreAuthorize`
- JWT token-based authentication for securing APIs
- OAuth2 integration for future extensions
- In-memory authentication for testing purposes (can be replaced with a database)
- RESTful API structure

## Table of Contents
1. [Setup](#setup)
2. [Project Structure](#project-structure)
3. [Endpoints](#endpoints)
4. [JWT Authentication](#jwt-authentication)
5. [Role-Based Access Control](#role-based-access-control)
6. [Testing](#testing)
7. [Future Work](#future-work)

## Setup

### Prerequisites:
- JDK 11 or higher
- Maven
- Postman (optional for testing)

### Steps to Run the Application:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-repo/sapis.git
    ```

2. **Navigate to the project directory**:
    ```bash
    cd sapis
    ```

3. **Build the project using Maven**:
    ```bash
    mvn clean install
    ```

4. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

5. The application should now be running on `http://localhost:8080`.

## Project Structure

```
sapis/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sapis/
│   │   │           ├── controllers/
│   │   │           │   └── MyController.java
│   │   │           ├── models/
│   │   │           ├── services/
│   │   │           ├── security/
│   │   │           │   ├── SecurityConfig.java
│   │   │           │   ├── JwtTokenUtil.java
│   │   │           └── SapisApplication.java
│   └── test/
│       └── java/
│           └── com/
│               └── sapis/
│                   └── SapisApplicationTests.java
```

## Endpoints

### Public Endpoints
- `GET /api/public/**`: No authentication required.

### Protected Endpoints
- `GET /api/admin`: Only accessible by users with `ADMIN` role.
- `GET /api/user`: Only accessible by users with `USER` role.

## JWT Authentication

**Sapis** uses JWT tokens for authenticating users. The JWT tokens are generated upon successful login and should be passed in the `Authorization` header of subsequent requests as a Bearer token.

### Steps for JWT-based Authentication:
1. Login to get a JWT token.
2. Use the token in the `Authorization` header for secured endpoints:
    ```bash
    Authorization: Bearer <your-jwt-token>
    ```

## Role-Based Access Control

The application defines two roles: `ADMIN` and `USER`. Access to specific endpoints is controlled using the `@PreAuthorize` annotation in the controller.

### Example:
- Only users with the `ADMIN` role can access the `/api/admin` endpoint.
- Only users with the `USER` role can access the `/api/user` endpoint.

## Testing

You can use **Postman** or any other API client to test the secured endpoints.

### Example:

1. **Login to get a JWT token**.
2. Use the token in the Authorization header to access the secured endpoints.

## Future Work

- Implement OAuth2 for further external API integrations.
- Replace in-memory authentication with a database-backed authentication (e.g., using Spring Data JPA).
- Add unit and integration tests for JWT and security configurations.
- Implement token refresh functionality.

---

Feel free to modify the content to suit your project!
