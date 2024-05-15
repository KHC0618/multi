-- CONNECTION: url=jdbc:oracle:thin:@//localhost:1521/XE


-- New script in localhost 6.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 15.
-- Time: 오전 8:45:19


SELECT A.user_id , B.HIGH_SCORE , C.COIN_COUNT , A.SIGNUP_DATE , A.DEL_ACC , A.DELETE_ACC_DATE 
FROM USERS A
LEFT JOIN "RECORD" B ON A.USER_ID = B.USER_ID 
LEFT JOIN COIN_INVT C ON A.USER_ID = C.USER_ID ;


SELECT * FROM BOARD ;