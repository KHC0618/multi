-- CONNECTION: url=jdbc:oracle:thin:@//localhost:1521/XE
-- New script in localhost 5.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 3.
-- Time: 오후 3:28:50

CREATE TABLE TEST
	(ID varchar2(100));	-- ORA-01031: insufficient PRIVILEGES : 권한 부족 에러
	
	
DROP TABLE TEST;