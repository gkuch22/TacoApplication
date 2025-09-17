# Taco Cloud Application

A simple web application built with **Spring Boot**, **Spring MVC**, **Spring Data JPA**, and **Spring Security** for learning purposes. This app allows users to **register, login, create tacos, and view orders**.

----------

## Features

-   **User Authentication and Authorization**
    
    -   Registration and login with password encryption.
        
    -   Role-based access control: only authenticated users can design tacos and view orders.
        
-   **Taco Management**
    
    -   Users can create custom tacos by selecting ingredients.
        
    -   Tacos are saved in a relational database.
        
-   **Order Management**
    
    -   Users can view and manage their orders.
        
-   **H2 Database Console**
    
    -   Embedded H2 database for development and testing.
        
    -   Accessible via `/h2-console` (CSRF disabled and frame options configured).
        
-   **Security**
    
    -   CSRF protection enabled.
        
    -   Passwords encrypted using BCrypt.
        
    -   User session persists across pages.
        

----------

## Technologies Used

-   **Java 21**
    
-   **Spring Boot**
    
-   **Spring MVC & Thymeleaf**
    
-   **Spring Data JPA** with H2 database
    
-   **Spring Security**
