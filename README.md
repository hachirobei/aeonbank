# AEON bank

<div align="center">
  <h1>AEON BANK</h1>
  <p><img src="https://img.icons8.com/fluency/96/000000/online-store.png" alt="Online Store Icon"/> <br /> <b>Library System</b></p>
</div>

# AEON Bank Backend Engineer technical assessment by Muhammad Hafizoddin

## Project Title
Library System API: A Spring Boot Application 

## Description
Library System API is a robust Spring Boot application designed to simplify the management of borrower and book through a set of RESTful APIs.


## Project Structure

### **Controllers**
- `HomeController`: Handles requests related to the home endpoint.
- `LibraryController`: Manages requests related to library operations such as adding, borrowing, and returning books.

### **Services**
- `BookServiceImpl`: Contains the core business logic for managing books, including adding, list, borrow and returns books from the library.
- `BorrowerServiceImpl`: Manages business operations related to borrowers and including registration.

### **Repositories**
- `BookRepository`: Interface for accessing book-related data from the database.
- `BorrowerRepository`: Interface for accessing borrower-related data from the database.

### **Configurations**
- `AuditorAwareImpl`: Configures auditing to track changes made to entities (e.g., creation and update timestamps).

### **DTOs (Data Transfer Objects)**
- `ApiResponse`: A standardized response object for all API responses.
- `BookDTO`: Data transfer object for book-related information, used when transferring data between layers.
- `BorrowerDTO`: Data transfer object for borrower-related information.

### **Entities**
- `BaseAudit`: A base entity class that adds auditing fields (createdAt, updatedAt) to all entities that extend it.
- `Book`: Represents a book entity in the system, with fields such as `id`, `isdn`, `title`, `author` and `isBorrowed`.
- `Borrower`: Represents a borrower entity in the system, with fields such as `id`, `name`, and `email`.

### **Exceptions**
- Custom exceptions for error handling:
  - `BookAlreadyBorrowedException`
  - `BookAlreadyExistsException`
  - `BookNotFoundException`
  - `BorrowerAlreadyExistsException`
  - `InvalidBookDetailsException`
- `GlobalExceptionHandler`: Centralized error handling mechanism for the application.

### **Initializer**
- `DataInitializer`: Seeds the database with initial data at startup.

## Getting Started

### Prerequisites
Before you begin, ensure you have the following installed on your local machine:
- **Java 17:** Ensure Java Development Kit (JDK) version 17 or higher is installed.
- **Maven:** Make sure Maven is installed to build and manage the project dependencies.
- **Lombok:** Install Lombok plugin for your IDE (if using) to enable annotation-based boilerplate code generation.
- **Postman:** Install Postman to test the APIs.
- **MySQL:** Ensure MySQL is installed and running.

## Usage

Please refer to the Swagger documentation for detailed information on how to use the APIs provided by this project.

### Swagger Documentation

Explore and interact with the APIs using Swagger UI. Access the API documentation via the following URL: [Swagger UI](http://localhost:8061/swagger-ui/index.html)

## Testing

### Manual Testing with Postman

1. **Download the Postman Collection:**
   - Download the "aeon.postman_collection" file from the project repository.

2. **Import Collection into Postman:**
   - Open Postman.
   - Click on the "Import" button in the top-left corner.
   - Select the downloaded "aeon.postman_collection" file.
   - The collection will be imported into your Postman workspace.

3. **Test the APIs:**
   - Explore the imported collection to view available requests.
   - Execute requests to interact with the Library System's APIs.
   - Verify responses to ensure the APIs function as expected.

### Automated Testing

1. **Ensure the Main Application is Running:**
   - Before running tests, make sure the application containers are up:
     ```bash
     docker-compose up -d
     ```

2. **Execute JUnit Tests in a Separate Container:**
   - Run the JUnit tests in an isolated Docker container to avoid affecting the main application:
     ```bash
     docker-compose run --rm test_service
     ```
   - This command triggers the test service defined in your `docker-compose.yml`, which is configured to run the JUnit tests in standalone mode.

### Continuous Integration

- **Integrate these tests into your CI/CD pipeline** to ensure consistent testing with each build. This practice helps maintain high standards of quality and reliability for application.
