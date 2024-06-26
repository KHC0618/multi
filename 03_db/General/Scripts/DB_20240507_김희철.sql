-- CONNECTION: url=jdbc:mysql://localhost:3306/

-- New script in localhost.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 8.
-- Time: 오전 9:10:07

USE scott;

DROP TABLE member_test ;

CREATE TABLE MEMBER_TEST (
    USER_NO INT AUTO_INCREMENT COMMENT '회원번호',
    USER_ID VARCHAR(50) PRIMARY KEY COMMENT '회원아이디',
    USER_PWD VARCHAR(100) NOT NULL COMMENT '회원비밀번호',
    PNO VARCHAR(13) NOT NULL COMMENT '주민등록번호',
    GENDER CHAR(1) CHECK (GENDER IN ('남', '여')) COMMENT '성별',
    PHONE VARCHAR(15) COMMENT '연락처',
    ADDRESS VARCHAR(255) COMMENT '주소',
    STATUS CHAR(1) NOT NULL CHECK (STATUS IN ('Y', 'N')) COMMENT '탈퇴여부',
    UNIQUE (USER_NO),
    UNIQUE (PNO)
);

INSERT INTO MEMBER_TEST (USER_ID, USER_PWD, PNO, GENDER, PHONE, ADDRESS, STATUS)
VALUES ('user1', 'password1', '1234567890123', '남', '010-1234-5678', '서울특별시', 'N');

INSERT INTO MEMBER_TEST (USER_ID, USER_PWD, PNO, GENDER, PHONE, ADDRESS, STATUS)
VALUES ('user2', 'password2', '2345678901234', '여', '010-2345-6789', '부산광역시', 'N');

INSERT INTO MEMBER_TEST (USER_ID, USER_PWD, PNO, GENDER, PHONE, ADDRESS, STATUS)
VALUES ('user3', 'password3', '3456789012345', '남', '010-3456-7890', '대구광역시', 'Y');

COMMIT;

CREATE TABLE movie (
	id VARCHAR(10),
	title VARCHAR(10),
	content VARCHAR(10),
	actor VARCHAR(10)
);

INSERT INTO movie
VALUES ('m1', '블랙아담', '액션', '드웨인존슨');

INSERT INTO movie
VALUES ('m2', '리멤버', '드라마', '남주혁');
	
INSERT INTO movie
VALUES ('m3', '자백', '스릴러', '소지섭');

COMMIT;

SELECT * FROM movie;

SELECT * 
FROM movie 
WHERE id = 'm1';

UPDATE movie 
SET content = '스릴러'
WHERE id = 'm1';

SELECT * 
FROM movie
WHERE id = 'm1';

DELETE 
FROM movie
WHERE id = 'm1';

SELECT * 
FROM movie;

COMMIT;

CREATE TABLE place (
	id VARCHAR(10),
	name VARCHAR(10),
	addr VARCHAR(10),
	tel VARCHAR(10)
);

INSERT INTO place
VALUES ('p1', 'cgv', '강남구 삼성동', '02-555');

INSERT INTO place
VALUES ('p2', 'megabox', '강남구 역삼동', '02-666');

INSERT INTO place
VALUES ('p3', 'lotte', '강남구 대치동', '02-777');

COMMIT;

SELECT * FROM place;

SELECT *
FROM place
WHERE name = 'cgv';

UPDATE place 
SET tel = '02-888'
WHERE name = 'lotte';

SELECT *
FROM place
WHERE name = 'lotte';

DELETE
FROM place
WHERE id = 'p3';

DELETE 
FROM movie;

DELETE 
FROM place;

DROP TABLE movie;

DROP TABLE place;

SELECT * FROM place;
SELECT * FROM movie;
