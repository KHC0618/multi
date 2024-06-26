-- CONNECTION: url=jdbc:mysql://localhost:3306/
-- New script in localhost 2.
-- Connection Type: dev 
-- Url: jdbc:mysql://localhost:3306/
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 6. 24.
-- Time: 오전 2:09:47


CREATE DATABASE seoulsoul;

USE seoulsoul;

-- USERS 테이블 생성
CREATE TABLE USERS (
	user_no INT AUTO_INCREMENT PRIMARY KEY,
	user_id VARCHAR(20) NOT NULL UNIQUE,
	user_pw VARCHAR(20) NOT NULL,
	nickname VARCHAR(20) NOT NULL UNIQUE,
	phone VARCHAR(11),
	email VARCHAR(30),
	blacklist_status CHAR(1) NOT NULL DEFAULT 'N' CHECK (blacklist_status IN ('Y', 'N')),
	created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- USER_ROLE 테이블 생성
CREATE TABLE USER_ROLE (
	user_no INT NOT NULL,
	authority_code INT NOT NULL DEFAULT 200,
	PRIMARY KEY (user_no, authority_code),
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (authority_code) REFERENCES USER_AUTHORITY(authority_code)
);

-- USER_AUTHORITY테이블 생성
CREATE TABLE USER_AUTHORITY(
	authority_code INT PRIMARY KEY,
	authority_name VARCHAR(20) NOT NULL,
	authority_desc TEXT
);

-- USER_SOUL 테이블 생성
CREATE TABLE USER_SOUL (
	user_no INT NOT NULL,
	location_code INT NOT NULL,
	soul_exp INT NOT NULL DEFAULT 0,
	PRIMARY KEY (user_no, location_code),
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (location_code) REFERENCES LOCATION(location_code)
);

-- USER_PROFILE 테이블 생성
CREATE TABLE USER_PROFILE (
	user_no INT NOT NULL,
	profile_content TEXT,
	profile_pic_name VARCHAR(255) DEFAULT '기본프로필사진이름.jpg',
	PRIMARY KEY (user_no),
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE
);





-- LOCATION 테이블 생성
CREATE TABLE LOCATION (
	location_code INT PRIMARY KEY,
	location_name VARCHAR(10) NOT NULL
);

-- SL_BOARD 테이블 생성
CREATE TABLE SL_BOARD (
	soul_log_no INT AUTO_INCREMENT PRIMARY KEY,
	location_code INT NOT NULL,
	category_code INT NOT NULL,
	title VARCHAR(50) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	writer INT NOT NULL,
	views INT NOT NULL DEFAULT 0,
	created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modified_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (location_code) REFERENCES LOCATION(location_code),
	FOREIGN KEY (category_code) REFERENCES SL_CATEGORY(category_code),
	FOREIGN KEY (writer) REFERENCES USERS(user_no) ON DELETE CASCADE
);

-- SL_CATEGORY 테이블 생성
CREATE TABLE SL_CATEGORY (
	category_code INT PRIMARY KEY,
	category_name VARCHAR(20) NOT NULL
);

-- SL_FILES 테이블 생성
CREATE TABLE SL_FILES (
	file_no INT AUTO_INCREMENT PRIMARY KEY,
	soul_log_no INT NOT NULL,
	original_name VARCHAR(500) NOT NULL,
	saved_name VARCHAR(500) NOT NULL,
	FOREIGN KEY (soul_log_no) REFERENCES SL_BOARD(soul_log_no) ON DELETE CASCADE
);

-- SL_LIKE 테이블 생성
CREATE TABLE SL_LIKE (
	user_no INT NOT NULL,
	soul_log_no INT NOT NULL,
	liked_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (user_no, soul_log_no),
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (soul_log_no) REFERENCES SL_BOARD(soul_log_no) ON DELETE CASCADE
);

-- SL_REPLY 테이블 생성
CREATE TABLE SL_REPLY (
	reply_no INT AUTO_INCREMENT PRIMARY KEY,
	soul_log_no INT NOT NULL,
	content VARCHAR(200) NOT NULL,
	writer INT NOT NULL,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (soul_log_no) REFERENCES SL_BOARD(soul_log_no) ON DELETE CASCADE,
	FOREIGN KEY (writer) REFERENCES USERS(user_no) ON DELETE CASCADE
);

-- SL_REPORT 테이블 생성
CREATE TABLE SL_REPORT (
	report_no INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	reason VARCHAR(500) NOT NULL,
	reporter INT NOT NULL,
	reported_soul_log INT NOT NULL,
	created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (reporter) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (reported_soul_log) REFERENCES SL_BOARD(soul_log_no) ON DELETE CASCADE
);





-- ACH_LOCA 테이블 생성
CREATE TABLE ACH_LOCA (
	ach_no INT AUTO_INCREMENT PRIMARY KEY,
	location_code INT NOT NULL,
	`count` INT NOT NULL,
	title VARCHAR(20) NOT NULL,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (location_code) REFERENCES LOCATION(location_code)
);

-- ACH_CATE 테이블 생성
CREATE TABLE ACH_CATE (
	ach_no INT AUTO_INCREMENT PRIMARY KEY,
	category_code INT NOT NULL,
	`count` INT NOT NULL,
	title VARCHAR(20) NOT NULL,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (category_code) REFERENCES SL_CATEGORY(category_code)
);

-- ACH_LOCA_ICONS 테이블 생성
CREATE TABLE ACH_LOCA_ICONS (
	icon_no INT AUTO_INCREMENT PRIMARY KEY,
	ach_no INT NOT NULL,
	original_name VARCHAR(255) NOT NULL,
	saved_name VARCHAR(255) NOT NULL,
	FOREIGN KEY (ach_no) REFERENCES ACH_LOCA(ach_no) ON DELETE CASCADE
);

-- ACH_CATE_ICONS 테이블 생성
CREATE TABLE ACH_CATE_ICONS (
	icon_no INT AUTO_INCREMENT PRIMARY KEY,
	ach_no INT NOT NULL,
	original_name VARCHAR(255) NOT NULL,
	saved_name VARCHAR(255) NOT NULL,
	FOREIGN KEY (ach_no) REFERENCES ACH_CATE(ach_no) ON DELETE CASCADE
);

-- ACH_LOCA_GET 테이블 생성
CREATE TABLE ACH_LOCA_GET (
	user_no INT NOT NULL,
	ach_no INT NOT NULL,
	status CHAR(1) DEFAULT 'N' CHECK (status IN ('Y', 'N')),
	PRIMARY KEY (user_no, ach_no),
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (ach_no) REFERENCES ACH_LOCA(ach_no)
);

-- ACH_CATE_GET 테이블 생성
CREATE TABLE ACH_CATE_GET (
	user_no INT NOT NULL,
	ach_no INT NOT NULL,
	status CHAR(1) DEFAULT 'N' CHECK (status IN ('Y', 'N')),
	PRIMARY KEY (user_no, ach_no),
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (ach_no) REFERENCES ACH_CATE(ach_no)
);

-- ACH_LOCA_COUNT 테이블 생성
CREATE TABLE ACH_LOCA_COUNT (
	user_no INT NOT NULL,
	ach_no INT NOT NULL,
	`count` INT DEFAULT 0,
	PRIMARY KEY (user_no, ach_no),
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (ach_no) REFERENCES ACH_LOCA(ach_no)
);

-- ACH_CATE_COUNT 테이블 생성
CREATE TABLE ACH_CATE_COUNT (
	user_no INT NOT NULL,
	ach_no INT NOT NULL,
	`count` INT DEFAULT 0,
	PRIMARY KEY (user_no, ach_no),
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (ach_no) REFERENCES ACH_CATE(ach_no)
);

-- AD_REPORT_REPLY 테이블 생성
CREATE TABLE AD_REPORT_REPLY (
	reply_no INT AUTO_INCREMENT PRIMARY KEY,
	report_no INT NOT NULL,
	content VARCHAR(200) NOT NULL,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (report_no) REFERENCES SL_REPORT(report_no) ON DELETE CASCADE
);





-- CS_QUESTION 테이블 생성
CREATE TABLE CS_QUESTION (
	question_no INT AUTO_INCREMENT PRIMARY KEY,
	category_code INT NOT NULL,
	title VARCHAR(50) NOT NULL,
	content TEXT NOT NULL,
	writer INT NOT NULL,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	is_answered CHAR(1) DEFAULT 'N',
	views INT DEFAULT 0,
	FOREIGN KEY (category_code) REFERENCES CS_CATEGORY(category_code),
	FOREIGN KEY (writer) REFERENCES USERS(user_no) ON DELETE CASCADE
);

-- CS_CATEGORY 테이블 생성
CREATE TABLE CS_CATEGORY (
	category_code INT PRIMARY KEY,
	category_name VARCHAR(20) NOT NULL
);

-- CS_QUESTION_FILES 테이블 생성
CREATE TABLE CS_QUESTION_FILES (
	file_no INT AUTO_INCREMENT PRIMARY KEY,
	question_no INT NOT NULL,
	original_file_name VARCHAR(255) NOT NULL,
	stored_file_name VARCHAR(255) NOT NULL,
	file_path VARCHAR(255) NOT NULL,
	FOREIGN KEY (question_no) REFERENCES CS_QUESTION(question_no) ON DELETE CASCADE
);

-- CS_ANSWER 테이블 생성
CREATE TABLE CS_ANSWER (
	answer_no INT AUTO_INCREMENT PRIMARY KEY,
	question_no INT NOT NULL,
	content TEXT NOT NULL,
	writer INT NOT NULL,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (question_no) REFERENCES CS_QUESTION(question_no) ON DELETE CASCADE,
	FOREIGN KEY (writer) REFERENCES USERS(user_no) ON DELETE CASCADE
);





-- REC_BOARD 테이블 생성
CREATE TABLE REC_BOARD (
	recommendation_no INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	content TEXT NOT NULL,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	views INT NOT NULL
);

-- EVENT 테이블 생성
CREATE TABLE EVENT (
	event_no INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	content TEXT NOT NULL,
	start_date DATETIME NOT NULL,
	end_date DATETIME NOT NULL,
	views INT NOT NULL,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- EVENT_FILES 테이블 생성
CREATE TABLE EVENT_FILES (
	files_no INT AUTO_INCREMENT PRIMARY KEY,
	event_no INT NOT NULL,
	original_name VARCHAR(255) NOT NULL,
	saved_name VARCHAR(255) NOT NULL,
	FOREIGN KEY (event_no) REFERENCES EVENT(event_no) ON DELETE CASCADE
);

-- EVENT_REPLY 테이블 생성
CREATE TABLE EVENT_REPLY (
	reply_no INT AUTO_INCREMENT PRIMARY KEY,
	user_no INT NOT NULL,
	event_no INT NOT NULL,
	content TEXT NOT NULL,
	
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (event_no) REFERENCES EVENT(event_no) ON DELETE CASCADE
);

-- REC_FILES 테이블 생성
CREATE TABLE REC_FILES (
	files_no INT AUTO_INCREMENT PRIMARY KEY,
	recommendation_no INT NOT NULL,
	original_name VARCHAR(255) NOT NULL,
	saved_name VARCHAR(255) NOT NULL,
	FOREIGN KEY (recommendation_no) REFERENCES REC_BOARD(recommendation_no) ON DELETE CASCADE
);

-- REC_HEARTBTN 테이블 생성
CREATE TABLE REC_HEARTBTN (
	user_no INT NOT NULL,
	recommendation_no INT NOT NULL,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (user_no, recommendation_no),
	FOREIGN KEY (user_no) REFERENCES USERS(user_no) ON DELETE CASCADE,
	FOREIGN KEY (recommendation_no) REFERENCES REC_BOARD(recommendation_no) ON DELETE CASCADE
);




INSERT INTO location VALUES (10, '테스트지역');
INSERT INTO sl_category  VALUES (10, '테스트카테고리');


ALTER TABLE ACH_LOCA CHANGE `count` max_count INT;
ALTER TABLE ach_cate CHANGE `count` max_count INT;
ALTER TABLE ach_loca_count CHANGE `count` cur_count INT;
ALTER TABLE ach_cate_count CHANGE `count` cur_count INT;

DELETE FROM ach_loca  WHERE ach_no = 15;
DELETE FROM ach_loca  WHERE ach_no = 16;

INSERT INTO LOCATION (location_code , location_name)
VALUES
  (101, '강남구'),
  (102, '강동구'),
  (103, '강북구'),
  (104, '강서구'),
  (105, '관악구'),
  (106, '광진구'),
  (107, '구로구'),
  (108, '금천구'),
  (109, '노원구'),
  (110, '도봉구'),
  (111, '동대문구'),
  (112, '동작구'),
  (113, '마포구'),
  (114, '서대문구'),
  (115, '서초구'),
  (116, '성동구'),
  (117, '성북구'),
  (118, '송파구'),
  (119, '양천구'),
  (120, '영등포구'),
  (121, '용산구'),
  (122, '은평구'),
  (123, '종로구'),
  (124, '중구'),
  (125, '중랑구');
 
 
 INSERT INTO SL_CATEGORY (category_code , category_name)
VALUES
  (100, '영화'),
  (200, '연극'),
  (300, '뮤지컬'),
  (400, '콘서트'),
  (500, '전시'),
  (600, '축제'),
  (700, '팝업'),
  (800, '체험'),
  (900, '기타');
 
 COMMIT;

SELECT * FROM ach_loca_count;