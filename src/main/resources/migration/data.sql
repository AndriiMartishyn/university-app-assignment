INSERT INTO employees(id, first_name, last_name, salary, degree) VALUES (111, 'John', 'Johns', 1300, 'PROFESSOR');
INSERT INTO employees(id, first_name, last_name, salary) VALUES (222, 'Steve', 'Sork', 1345);
INSERT INTO employees(id, first_name, last_name, salary, degree) VALUES (333, 'Lucas', 'Happy', 1200, 'PROFESSOR');
INSERT INTO employees(id, first_name, last_name, salary, degree) VALUES (444, 'Shawn', 'Rey', 985, 'ASSOCIATE_PROFESSOR');
INSERT INTO employees(id, first_name, last_name, salary) VALUES (555, 'Donald', 'Sink', 2345);
INSERT INTO employees(id, first_name, last_name, salary, degree) VALUES (666, 'Mariia', 'Hopkins', 1800, 'PROFESSOR');
INSERT INTO employees(id, first_name, last_name, salary, degree) VALUES (777, 'Jefrey', 'Dammer', 1000, 'PROFESSOR');


INSERT INTO departments(id, name, department_head_id) VALUES (1, 'engineering', 333);
INSERT INTO departments(id, name, department_head_id) VALUES (2, 'physics', 777);
INSERT INTO departments(id, name, department_head_id) VALUES (3, 'computer science', 666);


INSERT INTO employees_departments(employee_id, department_id) VALUES (111, 1);
INSERT INTO employees_departments(employee_id, department_id) VALUES (222, 1);
INSERT INTO employees_departments(employee_id, department_id) VALUES (333, 1);
INSERT INTO employees_departments(employee_id, department_id) VALUES (444, 2);
INSERT INTO employees_departments(employee_id, department_id) VALUES (555, 2);
INSERT INTO employees_departments(employee_id, department_id) VALUES (666, 2);
INSERT INTO employees_departments(employee_id, department_id) VALUES (777, 3);
