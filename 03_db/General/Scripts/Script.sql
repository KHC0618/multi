-- CONNECTION: url=jdbc:oracle:thin:@//localhost:1521/XE
-- New script in localhost.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 13.
-- Time: 오후 5:27:24

CREATE USER test IDENTIFIED BY test;

GRANT CONNECT, resource, dba TO test;