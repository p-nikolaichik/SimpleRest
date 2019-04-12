CREATE TABLE IF NOT EXISTS employees(
  employee_id SERIAL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL ,
  last_name VARCHAR(50) NOT NULL ,
  department_id VARCHAR NOT NULL ,
  job_title VARCHAR(50) NOT NULL ,
  gender VARCHAR(6) NOT NULL ,
  date_of_birth VARCHAR(10) NOT NULL
);