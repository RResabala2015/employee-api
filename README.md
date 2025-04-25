# Employee SpringBoot App

## Technologies

1. Java 17
2. Spring Boot v3.x.x
3. Spring Data JPA
4. H2 Database
5. Mysql Database
6. Maven
7. Docker
8. Kubernetes

## About The Project

This is an Employee Management application built with Spring Boot. It provides CRUD REST APIs for managing employee records, with support for pagination and sorting.

### Features:
1. **POST /api/v1/employees** - Create a new employee.
2. **GET /api/v1/employees** - Retrieve all employees (supports pagination and sorting).
3. **GET /api/v1/employees/{id}** - Retrieve a specific employee by ID.
4. **PUT /api/v1/employees/{id}** - Update an existing employee.
5. **DELETE /api/v1/employees/{id}** - Delete an employee.

## Project Repository

- [GitHub Repository](https://github.com/employee)

---

## Getting Started

### Cloning the Repository

Clone the repository and navigate to the project directory:

```bash
git clone https://github.com/RResabala2015/employee-api.git
cd employee-api
```

## Prerequisites & Installation
Ensure the following dependencies are installed:

JDK 17
Maven 3
H2 Database
Docker
Kubernetes (Minikube or Docker Desktop with Kubernetes enabled)

## Building the Application Locally

Run the following command from the project root directory:

```
mvn clean install
```

## Running the Application Locally
Run the JAR file using:
```bash
java -jar target/employee-0.0.1-SNAPSHOT.jar
```
After starting the application, you can access:

REST APIs: http://localhost:8080/api/v1/employees
H2 Console: http://localhost:8080/h2-console
(JDBC URL: jdbc:h2:mem:employeedb, username: sa, no password)

## Dockerizing the Application
Building the Docker Image
Run the following command:
```
docker build -t employee-app .
```

Running the Docker Container
After building, start a container using:

```
docker run -p 8080:8080 employee-app
```
Now your application will be accessible at http://localhost:8080.

## Deploying the Application on Kubernetes

Kubernetes Deployment Steps:
Ensure that you have Kubernetes set up locally using Minikube or
Docker Desktop with Kubernetes enabled.

Configure your Kubernetes deployment with deployment.yaml (already provided in the repository).

Apply the Kubernetes configuration:
```
kubectl apply -f deployment.yaml
```
Verify the deployment:
```
kubectl get pods
```
## Code Formatter
For maintaining code consistency, use a Java code formatter, such as:

IntelliJ IDEA built-in formatter

## To test these endpoints

Sample API Requests:

GET endpoint for all employees: 
http://localhost:8080/api/v1/employees


GET employees with pagination and sorting:
GET http://localhost:8080/api/v1/employees?offset=0&pageSize=5&sortBy=firstName&dir=ASC

GET endpoint : get employee by id:
http://localhost:8080/api/v1/employees/{id}

POST endpoint : Create an employee:
POST http://localhost:8080/api/v1/employees

```json

{
"firstName": "John",
"lastName": "Doe",
"email": "john.doe@example.com",
"phoneNo": "+1234567890",
"jobTitle": "Developer",
"department": "Engineering",
"dateOfJoining": "2023-05-15",
"employmentType": "Full-Time",
"emergencyContact": "+9876543210"
}
```

PUT endpoint: Update an employee by id

``` json
PUT http://localhost:8080/api/v1/employees/1
Content-Type: application/json

{
"firstName": "Jane",
"lastName": "Doe",
"email": "jane.doe@example.com",
"phoneNo": "+1234567890",
"jobTitle": "Senior Developer",
"department": "IT",
"dateOfJoining": "2023-05-15",
"employmentType": "Full-Time",
"emergencyContact": "+9876543210"
}
```

DELETE endpoint : Delete an employee by id 

``` json
DELETE http://localhost:8080/api/v1/employees/1
```