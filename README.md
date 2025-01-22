# Microservices Architecture: User Service & Order Service 🚀

## Overview
This repository contains two microservices: **User Service** and **Order Service**. These services are designed to work together in a distributed architecture, where **User Service** handles user-related operations, and **Order Service** manages order management. Both services leverage Spring Boot, Feign Client for inter-service communication, Circuit Breaker for fault tolerance, and Resilience4j to gracefully handle failures.

## Technologies Used
- **Spring Boot**: For building robust and scalable backend services.
- **Feign**: To make REST API calls to other microservices.
- **Circuit Breaker**: To manage failures, retries, and fallback mechanisms.
- **Resilience4j**: For resilience and smooth degradation during system failures.
- **Spring Cloud**: For microservices-based architecture and service discovery.
- **Docker**: For containerization and ensuring consistent deployments.
- **Git**: For version control and collaboration.
- **OAuth2**: For secure user authentication.
- **Spring Security**: To secure endpoints and protect the services from unauthorized access.

## Project Structure
### User Service

## Endpoints 🌐
### User Service Endpoints
- **Get User Details**  
  **GET** `/api/user/{id}`  
  **Description**: Fetches details of a user by their ID.  
  **Request**: `{id}` of the user.  
  **Response**: JSON payload containing user information.

### Order Service Endpoints
- **Create Order**  
  **POST** `/order/create`  
  **Description**: Creates a new order.  
  **Request**: JSON payload with order details (ID, user ID, items, etc.)  
  **Response**: Confirmation of order creation.

- **Retrieve Order**  
  **GET** `/order/{id}`  
  **Description**: Retrieves order details by ID.  
  **Request**: `{id}` of the order.  
  **Response**: JSON payload containing order details.

- **Get User Info via Feign**  
  **GET** `/order/user`  
  **Description**: Fetches user information using Feign client.  
  **Request**: `?id={userId}`  
  **Response**: JSON payload with user details and the order confirmation message.

## Circuit Breaker & Fault Tolerance 🔄
### User Service Circuit Breaker Example:
```java
@CircuitBreaker(name = "userService", fallbackMethod = "fallbackMethod")
public String getUserById(String id) {
    return userServiceClient.getUserById(id);  // Call to UserService
}

public String fallbackMethod(String id, Throwable throwable) {
    return "Fallback: User service is currently unavailable. Please try again later.";
}
