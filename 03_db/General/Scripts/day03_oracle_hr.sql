-- CONNECTION: url=jdbc:oracle:thin:@//localhost:1521/XE

-- New script in localhost 3.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 8.
-- Time: 오전 10:44:07

SELECT *
FROM EMPLOYEES ;

-- 기본 
--1. JOBS 테이블에서 JOB_TITLE의 정보만 출력되도록 하시오
SELECT JOB_TITLE 
FROM JOBS;
--2. DEPARTMENTS 테이블의 내용 전체를 출력하는 SELECT문을 작성하시오
SELECT *
FROM DEPARTMENTS ;
--3. EMPLOYEES 테이블에서 이름(FIRST_NAME, LAST_NAME), 이메일(EMAIL), 전화번호(PHONE_NUMBER), 고용일(HIRE_DATE)만 출력하시오
SELECT first_name, LAST_name, email, phone_number, hire_date
FROM EMPLOYEES ;
--4. EMPLOYEES 테이블에서 고용일(HIRE_DATE), 이름(FIRST_NAME, LAST_NAME), 월급(SALARY)를 출력하시오
SELECT HIRE_DATE, FIRST_NAME, LAST_NAME, SALARY 
FROM EMPLOYEES ;
--5. EMPLOYEES 테이블에서 월급(SALARY)이 9000 이상인 사람의 이름(FIRST_NAME, LAST_NAME)과 월급을 출력하시오
SELECT FIRST_NAME, LAST_NAME, SALARY 
FROM EMPLOYEES 
WHERE SALARY >= 9000;
--6. EMPLOYEES 테이블에서 월급(SALARY)이 7000 이상이면서 JOB_ID가 'FI_ACCOUNT'인 사람의 이름(FIRST_NAME, LAST_NAME)과 전화번호(PHONE_NUMBER)를 출력하시오
SELECT FIRST_NAME, LAST_NAME, PHONE_NUMBER  
FROM EMPLOYEES 
WHERE SALARY >= 7000 AND JOB_ID = 'FI_ACCOUNT';
--7. EMPLOYEES 테이블에서 이름, 연봉, 총수령액(보너스 포함), 실수령액(총 수령액에서 월급의 세금 3% 차감)을 출력하시오
SELECT FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME,
       SALARY * 12 AS 연봉,
       (SALARY + COALESCE(COMMISSION_PCT, 0) * SALARY) * 12 AS 총수령액,
       ((SALARY + COALESCE(COMMISSION_PCT, 0) * SALARY) * 12) - (SALARY * 12 * 0.03) AS 실수령액
FROM EMPLOYEES;
--8. EMPLOYEES 테이블에서 20년 이상 근속한 직원의 이름, 월급, 보너스를 출력하시오
SELECT FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME,
       SALARY,
       NVL(COMMISSION_PCT, 0) AS BONUS,
       ROUND(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) AS YY
FROM EMPLOYEES
WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12 >= 20;
--9. EMPLOYEES 테이블에서 고용일이 2005-01-01 ~ 2010-01-01 사이인 사원의 전체 내용을 출력하시오
SELECT *
FROM EMPLOYEES 
WHERE HIRE_DATE BETWEEN '2005-01-01' AND '2010-01-01';
--10. EMPLOYEES 테이블에서 FIRST_NAME 끝이 sa로 끝나는 사원의 전체 이름을 출력하시오
SELECT FIRST_NAME, LAST_NAME 
FROM EMPLOYEES 
WHERE FIRST_NAME LIKE '%sa';
--11. EMPLOYEES 테이블에서 전화번호 처음 3자리가 515가 아닌 사원의 이름, 전화번호를 출력하시오
SELECT FIRST_NAME, LAST_NAME, PHONE_NUMBER 
FROM EMPLOYEES 
WHERE PHONE_NUMBER NOT LIKE '515%';
--12. EMPLOYEES 테이블에서 DEPARTMENT_ID가 90 또는 60이고 고용일이 2005-01-01 ~ 2010-12-01이면서, 월급이 9000 이상인 사원의 전체 정보를 출력하시오
SELECT *
FROM EMPLOYEES 
WHERE DEPARTMENT_ID IN(90, 60)
	AND HIRE_DATE BETWEEN '2005-01-01' AND '2010-01-01'
	AND SALARY >= 9000;

-- 함수
   
-- 1. 직원의 이름과 이메일, 이메일 길이를 출력하시오
--		  직원명	    이메일		이메일길이
--	ex) 	홍길동 , hong  	  13
SELECT FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME,
	   EMAIL,
	   LENGTH(EMAIL)
FROM EMPLOYEES;

-- 2. 2001 AND 2005년에 고용된  직원명과 입사년도, 보너스 값을 출력하시오 
--	그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
SELECT FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME,
	   HIRE_DATE,
	   NVL(COMMISSION_PCT, 0) AS COMM
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN '2001-01-01' AND '2005-12-31';

-- 3. '515' 핸드폰 번호를 사용하지 않는 사람의 수를 출력하시오(뒤에 단위는 명을 붙이시오)
SELECT COUNT(*) AS "not515"
FROM EMPLOYEES
WHERE PHONE_NUMBER NOT LIKE '515%';
-- 4. 직원명과 입사년월을 2003년 6월 형태로 출력하시오
--	단, 아래와 같이 출력되도록 만들어 보시오
--	    EMP_NAME		HIRE_YY
--	ex) 리사		       1997년 3월

-- 5 . 부서코드가 50,90인 직원들 중에서 2004년도에 입사한 직원 조회
-- 120(EMPNO)	Matthew Weiss(ENAME)	50(DEPTID)	2004-07-18(HIRE_DATE)  형식으로 출력 

-- 6 . 직원명, 입사일, 오늘까지의 근무일수 조회 * 주말도 포함 , 소수점 아래는 버림

-- 7. 직원들의 입사일로부터 년도만 가지고 각 년도별 입사 인원수를 구하시오
--  아래의 년도에 입사한 인원수를 조회하시오. 마지막으로 전체직원수도 구하시오

--  => to_char, decode, sum 사용
--
--	-------------------------------------------------------------------------
--	 2001년   2002년   2003년   2004년   2005년   2006년   2007년 2008년 전체직원수
--	-------------------------------------------------------------------------

-- 8. 부서코드가 50이면 총무부, 60이면 기획부, 90이면 영업부로 처리하시오
--   단, 부서코드가 50, 60, 90 인 직원의 정보만 조회함
--  => case 사용
--   부서코드 기준 오름차순 정렬함.
