# Fetch - Backend

## Requirements-
JAVA version required - 17

## How to run the Spring boot application
Run the docker file. It has the JAVA version installed and it will run the jar which is already created.
### Following are the commands - 
#### docker build -t myapp .
#### docker run -p 8080:8080 myapp

The application will run on port 8080 and the app can be tested by hiting the GET/POST request

## Structure of the code
Java files are located in the src folder under the following packages:

controllers: Define the endpoints for the POST/GET requests

entities: Classes that map to POJO

models: Data Transfer Objects(DTO) for responses

services: Interfaces for services

servicesImpl: Actual business logic of the POST/GET requests which implements the interfaces and returns the response

repository: Interfaces for repository

repositoryImpl: Saving the receipt object in the in-memory database
