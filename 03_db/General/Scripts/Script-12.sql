-- CONNECTION: url=jdbc:mysql://localhost:3306/
-- New script in localhost 2.
-- Connection Type: dev 
-- Url: jdbc:mysql://localhost:3306/
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 21.
-- Time: 오후 3:19:38

CREATE DATABASE jsp;
USE jsp;
CREATE TABLE MEMBER (
    id varchar(100) NULL,
    name varchar(256) NULL,
    email varchar(100) NULL,
    address varchar(500) NULL
);



SELECT * FROM MEMBER;