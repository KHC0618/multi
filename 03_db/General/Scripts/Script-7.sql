-- CONNECTION: url=jdbc:oracle:thin:@//localhost:1521/XE
-- New script in localhost.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 10.
-- Time: 오후 3:13:11

CREATE USER student IDENTIFIED BY student;
GRANT connect,resource TO student;