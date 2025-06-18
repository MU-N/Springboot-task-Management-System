# Spring Boot Task Manager

> A full-featured task management web application built with Spring Boot, Spring Security, and modern web technologies for educational purposes.

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue.svg)](https://www.postgresql.org/)

## 📚 Educational Purpose

This project is my **personal learning journey** to master modern Java web development technologies. Built for hands-on practice and skill development in:
- Spring Boot application architecture and best practices
- Spring Security implementation and configuration
- MVC pattern with Thymeleaf templating
- JPA/Hibernate ORM and database management
- User authentication and authorization systems
- RESTful web development and CRUD operations
- Maven dependency management and project structure

This represents my practical exploration of the Spring ecosystem and enterprise Java development patterns.

## 🛠️ Technology Stack

### Backend
- **Java 21** - Programming language
- **Spring Boot 3.5.0** - Application framework
- **Spring Security 6** - Authentication & authorization
- **Spring Data JPA** - Data persistence layer
- **Hibernate** - ORM framework
- **Maven** - Dependency management & build tool

### Frontend
- **Thymeleaf** - Server-side templating engine
- **Bootstrap 5.3.3** - CSS framework for responsive design
- **HTML5 & CSS3** - Markup and styling

### Database
- **PostgreSQL** - Primary database
- **Hibernate DDL** - Database schema management

### Development Tools
- **Spring Boot DevTools** - Hot reload during development
- **Lombok** - Reduces boilerplate code
- **Bean Validation** - Input validation

## 🌟 Features

### 🔐 User Management
- User registration with secure password hashing (BCrypt)
- Login/logout functionality
- Session management
- User authentication and authorization

### 📋 Task Management
- Create new tasks with title, description, due date, and status
- View all personal tasks in a responsive table
- Edit existing tasks
- Delete tasks
- Task ownership validation (users can only manage their own tasks)

### 🛡️ Security Features
- Secured endpoints with Spring Security
- Password encryption
- CSRF protection
- Session-based authentication
- Authorization checks for task operations

### 🎨 User Interface
- Responsive design with Bootstrap
- Clean and intuitive user interface
- Error handling with user-friendly messages
- Form validation feedback

## 🖼️ Preview




https://github.com/user-attachments/assets/170dcd2b-de03-4a73-bb5a-0003402dc13b




### 🎥 Demo Features
- ✅ **User Registration**: Secure account creation
- ✅ **User Login**: Session-based authentication
- ✅ **Task CRUD**: Create, Read, Update, Delete operations
- ✅ **Responsive Design**: Works on desktop and mobile
- ✅ **Security**: Only view/edit your own tasks
- ✅ **Validation**: Form validation with error messages

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- PostgreSQL database
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/MU-N/Springboot-task-Management-System.git
   cd Springboot-task-Management-System
   ```

2. **Set up PostgreSQL database**
   ```sql
   CREATE DATABASE taskmanager;
   CREATE USER postgres WITH PASSWORD '0000';
   GRANT ALL PRIVILEGES ON DATABASE taskmanager TO postgres;
   ```

3. **Configure database connection**
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
   Or using Maven:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application**
   Open your browser and navigate to: `http://localhost:8080`

### Quick Start
1. Register a new account
2. Login with your credentials
3. Start creating and managing your tasks!

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/nasser/taskmanagementapp/
│   │   ├── config/
│   │   │   └── SecurityConfig.java          # Spring Security configuration
│   │   ├── controller/
│   │   │   ├── TaskController.java          # Task management endpoints
│   │   │   ├── UserController.java          # User auth endpoints
│   │   │   └── ErrorController.java         # Global error handling
│   │   ├── entity/
│   │   │   ├── Task.java                    # Task entity/model
│   │   │   └── User.java                    # User entity/model
│   │   ├── repository/
│   │   │   ├── TaskRepository.java          # Task data access
│   │   │   └── UserRepository.java          # User data access
│   │   ├── service/
│   │   │   ├── TaskService.java             # Task business logic
│   │   │   └── UserService.java             # User business logic
│   │   └── TaskmanagementappApplication.java # Main application class
│   └── resources/
│       ├── templates/                        # Thymeleaf templates
│       │   ├── login.html
│       │   ├── register.html
│       │   ├── tasks.html
│       │   ├── task-form.html
│       │   └── error.html
│       └── application.properties            # Application configuration
└── test/                                     # Test classes
```

## 🏗️ Architecture

This project follows the **MVC (Model-View-Controller)** pattern with **layered architecture**:

- **Presentation Layer**: Controllers and Thymeleaf templates
- **Business Layer**: Service classes containing business logic
- **Data Access Layer**: Repository interfaces with Spring Data JPA
- **Database Layer**: PostgreSQL with JPA/Hibernate ORM

## 🔒 Security Features

- **Authentication**: Form-based login with session management
- **Authorization**: Role-based access control
- **Password Security**: BCrypt hashing
- **CSRF Protection**: Enabled by default
- **Data Access Control**: Users can only access their own tasks

## 🧪 My Learning Outcomes

Through building this project, I've gained hands-on experience with:

- ✅ Spring Boot application structure and auto-configuration
- ✅ Spring Security setup for authentication and authorization
- ✅ JPA/Hibernate entity relationships and database mapping
- ✅ RESTful controller design and HTTP methods
- ✅ Service layer architecture and business logic separation
- ✅ Thymeleaf templating engine and form data binding
- ✅ Spring Data JPA repositories and custom queries
- ✅ Session-based authentication and user management
- ✅ Input validation and error handling strategies
- ✅ Maven project management and dependency resolution


## 📝 About This Project

This is my **personal learning project** where I practice and experiment with Spring Boot technologies.

## 📧 Notes

This repository serves as:
- My coding practice and skill development
- Reference for Spring Boot patterns and implementations
- Documentation of my learning progress in Java enterprise development

---

> **Personal Learning Project**: Built to understand Spring Boot ecosystem and modern Java web development. Code may be experimental as I explore different approaches and learn best practices. 
