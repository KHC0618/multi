-- CONNECTION: url=jdbc:mysql://localhost:3306/
-- New script in localhost 2.
-- Connection Type: dev 
-- Url: jdbc:mysql://localhost:3306/
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 10.
-- Time: 오전 11:01:24

USE scott;

DROP TABLE MEMBER;
CREATE TABLE MEMBER (
	NO INT AUTO_INCREMENT PRIMARY KEY,
	ID varchar(10),
	pw varchar(10),
	name varchar(10),
	tel varchar(10),
	create_date timestamp
);

INSERT INTO MEMBER
VALUES (NULL, 'm01', 1, '리사', '010', NOW());

COMMIT;

SELECT * FROM `member` ;