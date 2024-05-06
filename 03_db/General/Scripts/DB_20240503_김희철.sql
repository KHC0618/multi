-- CONNECTION: url=jdbc:oracle:thin:@//localhost:1521/XE
-- New script in localhost.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 3.
-- Time: 오후 5:02:31

CREATE USER computer IDENTIFIED BY 1234;

GRANT CONNECT, resource, dba TO computer;

------------------------------------------
-- computer/1234로 연결
CREATE USER mouse IDENTIFIED BY 1111;

GRANT CONNECT TO mouse;

------------------------------------------
-- mouse/1111로 연결
CREATE USER keyboard IDENTIFIED BY 1234; -- SQL Error [1031] [42000]: ORA-01031: insufficient privileges

------------------------------------------
-- system/oracle로 다시 연결
REVOKE resource FROM computer;

------------------------------------------
-- computer/1234로 다시 연결
CREATE TABLE TEST
	(ID varchar2(100)); -- SQL Error [1950] [42000]: ORA-01950: no privileges on tablespace 'SYSTEM'

------------------------------------------
-- system/oracle로 다시 연결
-- 연결을 해제하고 DROP 해야함.
DROP USER computer; -- SQL Error [1940] [42000]: ORA-01940: cannot drop a user that is currently connected
DROP USER mouse; -- SQL Error [1940] [42000]: ORA-01940: cannot drop a user that is currently connected
