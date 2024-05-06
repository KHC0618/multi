-- CONNECTION: url=jdbc:oracle:thin:@//localhost:1521/XE
-- New script in localhost 6.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 3.
-- Time: 오후 5:09:49

CREATE USER mouse IDENTIFIED BY 1111;

GRANT CONNECT TO mouse;

CREATE TABLE TEST
	(ID varchar2(100));