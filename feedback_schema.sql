DROP DATABASE IF EXISTS feedback_db;
create database feedback_db;
use feedback_db;
create table feedback (
id INT AUTO_INCREMENT,
email VARCHAR(200) DEFAULT NULL,
phone VARCHAR(200) DEFAULT NULL,
message VARCHAR(200) DEFAULT NULL,
PRIMARY KEY(id)
);