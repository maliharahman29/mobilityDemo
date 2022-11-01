# Allane mobility group - demo project (Spring Boot/Gradle)
> This is a simple RESTful web application written in Java/Gradle/Spring Boot/PostgreSQL for back-end.
This project is intended to be a demonstration of how a REST API can be structured and designed using Spring Boot/Actuator and Spring Data.

## Requirement

1. JDK 1.8+ 
2. Gradle 7.5+
3. PostgreSQL
4. Spring Boot 2.7.1


## Installation

To run this application, first need to install couple of packages: jdk 1.8 and gradle.

```sh
$ sudo apt-get install openjdk-8-jre
$ brew install gradle
$ docker run --name postgre-0 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=1234 -p 5432:5432 -v /data:/var/lib/postgresql/data -d postgres
```

## Usage

The relevant endpoints for this application are POST ``/api/v1/customers`` to create customer, 
POST ``/api/v1/vehicles`` to create vehicles and POST ``/api/v1/contracts/overview`` to create contracts with existing customers and vehicles.
All endpoints have the basic CRUD actions. For example, to view all contracts, one can navigate to:

```sh
/api/v1/contracts/overview
```

Which should return the following JSON: 

```sh
{
    "content": [
        {
            "contractNumber": 1,
            "name": "test name",
            "vehicle": "BMW X3 (2022)",
            "price": "15.000.00"
        }
    ],
}
```

For testing all the CRUD actions, I recommend using Postman.
