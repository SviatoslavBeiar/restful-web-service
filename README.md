# User and Post Management API

This application provides a RESTful web service for managing users and their associated posts. It uses Spring Boot and JPA for database interactions and includes HATEOAS links to enhance API navigation.

## Features

- **User Management:**
  - Retrieve all users.
  - Retrieve a specific user by ID.
  - Create a new user.
  - Delete an existing user.

- **Post Management:**
  - Retrieve all posts for a specific user.
  - Retrieve a specific post for a user.
  - Create a new post for a user.

## Endpoints

### User Endpoints

- **Get All Users**
  - `GET /jpa/users`
  - Returns a list of all users.

- **Get User by ID**
  - `GET /jpa/users/{id}`
  - Returns a specific user by ID. Includes a HATEOAS link to retrieve all users.

- **Create User**
  - `POST /jpa/users`
  - Creates a new user. Returns a `201 Created` status with the location of the new user.

- **Delete User**
  - `DELETE /jpa/users/{id}`
  - Deletes a user by ID.

### Post Endpoints

- **Get Posts for User**
  - `GET /jpa/users/{id}/posts`
  - Returns all posts for a specific user by user ID.

- **Get Post by ID for User**
  - `GET /jpa/users/{userId}/posts/{postId}`
  - Returns a specific post for a user by post ID. Includes a HATEOAS link to the user's posts.

- **Create Post for User**
  - `POST /jpa/users/{id}/posts`
  - Creates a new post for a user. Returns a `201 Created` status with the location of the new post.

## Technologies Used

- **Spring Boot**: Framework for building the RESTful web service.
- **JPA**: Java Persistence API for data access and management.
- **HATEOAS**: Hypermedia As The Engine Of Application State for linking resources.
