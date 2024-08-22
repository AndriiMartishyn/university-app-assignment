DROP TABLE IF EXISTS employees_departments;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees
(
    id         BIGINT CONSTRAINT PK_employees PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    salary     NUMERIC      NOT NULL,
    degree     varchar(255) NOT NULL DEFAULT 'ASSISTANT'
);

CREATE TABLE IF NOT EXISTS departments
(
    id              BIGINT CONSTRAINT PK_departments PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    department_head_id BIGINT,
    FOREIGN KEY (department_head_id) REFERENCES employees (id)
);

CREATE TABLE employees_departments
(
    employee_id   BIGINT,
    department_id BIGINT,
    PRIMARY KEY (employee_id, department_id),
    FOREIGN KEY (employee_id) REFERENCES employees (id),
    FOREIGN KEY (department_id) REFERENCES departments (id)
);
