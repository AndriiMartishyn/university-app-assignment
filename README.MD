

## Table of Contents
- [Introduction](#introduction)
- [Functionality](#functionality)
- [Technologies](#technologies)
- [How to start](#setting-up-dev)


## Introduction
Test-assignment project with console interface for university, which consists of departments and employees.

## Technologies
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://openjdk.org/)
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)


## Functionality
The app should implement such commands:

1.  User Input: Who is head of department {department_name}
Answer: Head of {department_name} department is {head_of_department_name}

2.  User Input: Show {department_name} statistics.
Answer: assistans - {assistams_count}.
associate professors - {associate_professors_count}
professors -{professors_count}

3. User Input: Show the average salary for the department {department_name}.
Answer: The average salary of {department_name} is {average_salary}

4. User Input: Show count of employee for {department_name}.
Answer: {employee_count}

5. User Input: Global search by {template}.   
Example: Global search by van
Answer: Ivan Petrenko, Petro Ivanov


### Setting up Dev

First you need to pull the latest code. 

```shell
git clone https://github.com/AndriiMartishyn/university-app-assignment.git
cd university-app-assignment/
```
Then you will need to open IDE and use following command order to build jar archive.
```shell
mvn clean install
```

After that it is possible to run executable jar file with assignment.
```shell
java -jar target/university-app-0.0.1-SNAPSHOT.jar
```

