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
   - Select the downloaded "Online Store.postman_collection" file.
   - The collection will be imported into your Postman workspace.

3. **Test the APIs:**
   - Explore the imported collection to view available requests.
   - Execute requests to interact with the Online Store Management System's APIs.
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
