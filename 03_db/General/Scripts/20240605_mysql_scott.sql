-- CONNECTION: url=jdbc:mysql://localhost:3306/
-- New script in localhost 2.
-- Connection Type: dev 
-- Url: jdbc:mysql://localhost:3306/
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 6. 5.
-- Time: 오후 3:06:49
USE scott;

DROP TABLE bbs2;

CREATE TABLE bbs2 (
    bbsId INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    writer VARCHAR(100) NOT NULL,
    fileName VARCHAR(255),
    FOREIGN KEY (writer) REFERENCES member(id)
);


SELECT * FROM bbs2;