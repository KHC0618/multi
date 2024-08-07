-- CONNECTION: url=jdbc:mysql://localhost:3306/
-- New script in localhost 2.
-- Connection Type: dev 
-- Url: jdbc:mysql://localhost:3306/
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 23.
-- Time: 오전 9:43:55


USE scott;

DROP TABLE MEMBER ;
CREATE TABLE member(
	no INT AUTO_INCREMENT PRIMARY KEY,
	id varchar(10) UNIQUE,
	pw varchar(100),
	name varchar(10),
	tel varchar(100),
	create_date timestamp DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO MEMBER
VALUES(NULL,'m01', '1', '리사', '010',NOW());
INSERT INTO MEMBER
VALUES(NULL,'2', '2', '주혁', '010',NOW());
INSERT INTO MEMBER
VALUES(NULL,'3', '3', '3', '010',NOW());
INSERT INTO MEMBER
VALUES(NULL,'4', '4', '4', '010',NOW());
INSERT INTO MEMBER
VALUES(NULL,'5', '5', '5', '010',NOW());
INSERT INTO MEMBER
VALUES(NULL,'888', '1', '리사', '010',CURRENT_TIMESTAMP);
COMMIT;

SELECT * FROM MEMBER;

ALTER TABLE MEMBER
MODIFY COLUMN tel VARCHAR(100);

DROP TABLE category;

CREATE TABLE CATEGORY(

  C_CODE INT PRIMARY KEY,
  C_NAME VARCHAR(30) CHECK(C_NAME IN('공통', '운동', '등산', '게임', '낚시', '요리', '기타'))  
);


INSERT INTO CATEGORY (C_CODE, C_NAME) VALUES(10, '공통');
INSERT INTO CATEGORY (C_CODE, C_NAME) VALUES(20, '운동');
INSERT INTO CATEGORY (C_CODE, C_NAME) VALUES(30, '요리');
INSERT INTO CATEGORY (C_CODE, C_NAME) VALUES(70, '기타');

COMMIT;

SELECT * FROM CATEGORY;

DROP TABLE BOARD CASCADE;

CREATE TABLE BOARD (
  NO INT PRIMARY KEY AUTO_INCREMENT,
  CATEGORY_CODE INT,
  TITLE VARCHAR(100),
  CONTENT TEXT NOT NULL,
  WRITER varchar(10) NOT NULL,
  COUNT INT DEFAULT 0 NOT NULL,
  CREATED_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
  MODIFIED_DATE DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  STATUS CHAR(1) DEFAULT 'Y',
  FOREIGN KEY (CATEGORY_CODE) REFERENCES CATEGORY(C_CODE),
  FOREIGN KEY (WRITER) REFERENCES MEMBER(ID)
);

INSERT INTO BOARD 
( CATEGORY_CODE, TITLE, CONTENT, WRITER) 
VALUES( 10, '게시글 1 ', '게시글1 CONTENT 입니다 ', 'm01');

INSERT INTO BOARD 
( CATEGORY_CODE, TITLE, CONTENT, WRITER) 
VALUES( 10, '게시글 2 ', '게시글2 CONTENT 입니다 ', 'm01');
INSERT INTO BOARD 
( CATEGORY_CODE, TITLE, CONTENT, WRITER) 
VALUES( 10, '게시글 3 ', '게시글3 CONTENT 입니다 ', '2');
INSERT INTO BOARD 
( CATEGORY_CODE, TITLE, CONTENT, WRITER) 
VALUES( 10, '게시글 4 ', '게시글4 CONTENT 입니다 ', '2');
INSERT INTO BOARD 
( CATEGORY_CODE, TITLE, CONTENT, WRITER) 

VALUES( 10, '게시글 5 ', '게시글5 CONTENT 입니다 ', '3');


SELECT * FROM BOARD;

DROP TABLE COMPANY;
CREATE TABLE COMPANY (
	ID VARCHAR(200) PRIMARY KEY,
	NAME VARCHAR(200),
	ADDR VARCHAR(200),
	TEL INT(11)
);

INSERT INTO COMPANY VALUES ('c100', 'GOOD', 'SEOUL', 011);

INSERT INTO COMPANY VALUES ('c200', 'JOA', 'BUSAN', 012);

INSERT INTO COMPANY VALUES ('c300', 'MARIA', 'ULSAN', 013);

INSERT INTO COMPANY VALUES ('c400', 'MY', 'KWANGJU', 014);

COMMIT;

DROP TABLE product;
CREATE TABLE PRODUCT (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(100),
    CONTENT VARCHAR(500),
    PRICE INT,
    COMPANY_ID VARCHAR(200) NOT NULL,
    IMG VARCHAR(255),
    CREATED_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    CREATED_PERSON VARCHAR (100),
  	MODIFIED_DATE DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  	MODIFIED_PERSON VARCHAR (100),
  	STATUS CHAR(1) DEFAULT 'Y',
  	FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY(ID)
);

DROP TABLE attachment ;
-- 첨부파일 테이블 생성
CREATE TABLE ATTACHMENT (
  ATTACHMENT_NO INT PRIMARY KEY AUTO_INCREMENT,
  REF_PRODUCT_NO INT NOT NULL,
  ORIGINAL_NAME VARCHAR(255) NOT NULL,
  SAVED_NAME VARCHAR(255) NOT NULL,
  SAVE_PATH VARCHAR(1000) NOT NULL,
  THUMBNAIL_PATH VARCHAR(255),
  STATUS VARCHAR(1) DEFAULT 'Y',
  CREATED_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
  CREATED_PERSON VARCHAR (100),
  MODIFIED_DATE DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  MODIFIED_PERSON VARCHAR (100),
  FOREIGN KEY (REF_PRODUCT_NO) REFERENCES PRODUCT(ID)  
);

SELECT * FROM attachment ;

INSERT INTO product (NAME, CONTENT, PRICE, COMPANY_ID, CREATED_PERSON)
VALUES ('testNAME', 'testCONTENT', 10000, 'c100', 'admin');

COMMIT;



 CREATE TABLE `book` (
 `id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(256) DEFAULT NULL,
 `url` varchar(256) DEFAULT NULL,
 `img` varchar(256) DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 insert into book values
 (null, 'naver', 'http://www.naver.com', 'naver.png'); 
 insert into book values
 (null,  'daum', 'http://www.daum.net', 'daum.png');
 insert into book values
 (null,  'google', 'http://www.google.com', 'google.png');


CREATE TABLE REPLY (
    ID int auto_increment primary key,
    ORIID int,
    CONTENT VARCHAR(500),
    WRITER VARCHAR (10) NOT NULL,
     FOREIGN KEY (ORIID) REFERENCES BOARD(NO),
     FOREIGN KEY (WRITER) REFERENCES MEMBER(ID)
);  

CREATE TABLE mymap (
    location VARCHAR(100),
    lat VARCHAR (100),
    lon VARCHAR (100)
);

insert into mymap values 
 ('coex', 37.512,127.0592);

insert into mymap values 
 ('tower', 37.5125,127.1025);

CREATE TABLE weather (
    id INT AUTO_INCREMENT PRIMARY KEY,
    temperature FLOAT,
    weather_condition VARCHAR(50),
    humidity INT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE member ;
DROP TABLE PRODUCT ;
DROP TABLE `ORDER` ;

-- 멤버테이블 생성
CREATE TABLE MEMBER(
MEM_NO INT AUTO_INCREMENT PRIMARY KEY,
ID VARCHAR(10) UNIQUE,
PW VARCHAR(10),
NAME VARCHAR(10),
TEL VARCHAR(11),
ADDRESS VARCHAR(50),
PERMISSION_CODE VARCHAR(8)
check (PERMISSION_CODE in ('CUSTOMER', 'SELLER', 'ADMIN'))
default 'CUSTOMER'
);


-- 상품테이블 생성
CREATE TABLE PRODUCT(
PRODUCT_NO INT auto_increment primary key,
PRODUCT_NAME VARCHAR(50) UNIQUE,
PRICE INT,
SEASON_CODE VARCHAR(6) check(SEASON_CODE in ('봄', '여름', '가을', '겨울')),
REGISTRANT_ID VARCHAR(20),
foreign key (REGISTRANT_ID) references member(ID)
);

SELECT d.DeptName, AVG(e.Salary) AS AvgSalary
FROM EMP e
INNER JOIN Dept d ON e.DeptID = d.DeptID
GROUP BY d.DeptName
HAVING AVG(e.Salary) >= 100000;


-- 주문테이블 생성
create table `ORDER`(
ORDER_NO int auto_increment primary key,
PRODUCT_NAME varchar(20),
QUANTITY INT,
ADDRESS varchar(50),
ORDER_TIME DATETIME default CURRENT_TIMESTAMP,
MEM_NO INT,
foreign key (PRODUCT_NAME) references PRODUCT(PRODUCT_NAME),
foreign key (MEM_NO) references MEMBER(MEM_NO)
);


-- 기본 관리자 생성
INSERT INTO member (id, pw, name, tel, address, PERMISSION_CODE)
VALUES('se', 'se', null, null, null, 'SELLER');

-- 기본 판매자 생성
INSERT INTO member (id, pw, name, tel, address, PERMISSION_CODE)
VALUES('ad', 'ad', null, null, null, 'ADMIN');

-- 기본 상품 생성
INSERT INTO product (PRODUCT_NAME, PRICE, SEASON_CODE, registrant_id) VALUES
('파라슈트 루즈 체크 셔츠', 25800, '봄', 'se'),
('경량 아노락 바람막이', 101400, '봄', 'se'),
('1989 맨투맨', 29900, '봄', 'se'),
('에센셜 가디건', 49000, '봄', 'se'),
('디페이스 미니멀 하프자켓', 89900, '봄', 'se'),
('어반 이중지 후드티', 44900, '봄', 'se'),
('퍼스트 와이드 슬랙스', 44900, '봄', 'se'),
('오버핏 반팔 셔츠', 34900, '여름', 'se'),
('퍼커링 시어 윈드 자켓', 64800, '여름', 'se'),
('미니멀 트레이닝 반바지', 22900, '여름', 'se'),
('스트래피 샌들', 52800, '여름', 'se'),
('로고 티셔츠 화이트', 34900, '여름', 'se'),
('온타임 반팔티', 16800, '여름', 'se'),
('마리루 오버로크 반팔티', 29800, '여름', 'se'),
('포켓 카고 반바지', 28900, '여름', 'se'),
('트위치 루즈핏 후드', 63200, '가을', 'se'),
('라글란 롱 슬리브', 36750, '가을', 'se'),
('울 트렌치 코트', 156700, '가을', 'se'),
('모베트 이선 긴팔티', 35800, '가을', 'se'),
('드라페 후드 청자켓', 59900, '가을', 'se'),
('베이직 푸퍼', 39900, '겨울', 'se'),
('에코 눕시 자켓', 399000, '겨울', 'se'),
('오버핏 니트 블루', 43000, '겨울', 'se'),
('라이딩 롱부츠', 90300, '겨울', 'se'),
('도미닉 쿠퍼 패딩', 59900, '겨울', 'se'),
('멜로우 라인 양털 패딩', 78000, '겨울', 'se');


select * from member;
select * from product;
select * from `order`;
