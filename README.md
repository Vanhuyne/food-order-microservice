# Spring Boot Microservices Project

## Architecture Overview

This project demonstrates a microservices architecture using Spring Boot and Spring Cloud. The system is composed of several interconnected services that work together to provide a scalable and maintainable application.

![Architecture Diagram](./screenshot/architecture.png)

## Key Components

1. API Gateway
2. Eureka Service Discovery
3. User Service
4. Restaurant Service
5. Order Service
6. Notification Service
7. Frontend (Angular)

- **API Gateway**: Acts as a single entry point for all client requests, routing them to appropriate services.
- **Eureka Service Discovery**: Allows services to find and communicate with each other without hard-coding hostname and port.
- **User Service**: Manages user accounts and authentication.
- **Restaurant Service**: Handles restaurant information and menus.
- **Order Service**: Processes and manages customer orders.
- **Notification Service**: Sends notifications to users about their orders.
- **Frontend**: Angular-based user interface for customers to interact with the system.

[Include instructions on how to set up and run the project]

## Technologies Used

- Spring Boot
- Spring Cloud (Eureka,Feign)
- Angular (Frontend)
- MySQL (Database)
- Docker (Containerization)

