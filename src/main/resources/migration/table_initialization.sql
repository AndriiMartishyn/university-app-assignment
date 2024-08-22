CREATE TABLE department(
                       id BIGINT CONSTRAINT PK_broker PRIMARY KEY,
                       name VARCHAR(255) CONSTRAINT UQ_broker_username UNIQUE NOT NULL,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL
);

CREATE TABLE sales_group(
                            id BIGINT CONSTRAINT PK_sales_group PRIMARY KEY,
                            name VARCHAR(255) CONSTRAINT UQ_sales_group_name UNIQUE NOT NULL,
                            transaction_type VARCHAR(255) NOT NULL,
                            max_transaction_amount NUMERIC NOT NULL
);

CREATE TABLE broker_sales_group(
                                   broker_id BIGINT,
                                   sales_group_id BIGINT,
                                   CONSTRAINT PK_broker_sales_group PRIMARY KEY (broker_id, sales_group_id),
                                   CONSTRAINT FK_broker_sales_group_broker FOREIGN KEY (broker_id) REFERENCES broker(id),
                                   CONSTRAINT FK_broker_sales_group_sales_group FOREIGN KEY (sales_group_id) REFERENCES sales_group(id)
);