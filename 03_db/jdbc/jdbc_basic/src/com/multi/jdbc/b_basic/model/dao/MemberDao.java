package com.multi.jdbc.b_basic.model.dao;

import com.multi.jdbc.b_basic.model.dto.MemberDto;

import java.sql.*;

public class MemberDao {

    public void insert(MemberDto dto) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. 드라이버 설정 성공..");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "tiger";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공." + con);

            // 오토커밋을 false로 설정
            con.setAutoCommit(false);
            System.out.println("3. 오토 커밋 설정 비활성화.");

            // sql문 만들기, prepareStatement 준비된 문장
            String sql = "insert into MEMBER values (?, ?, ?, ?, sysdate)";
            ps = con.prepareStatement(sql);
            // ? 에 입력할 순서대로 매핑시키기
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getPw());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getTel());
            System.out.println("4. sql문 객체 생성 성공.");
            int result = ps.executeUpdate();    // ps. 객체 실행, 쿼리 실행, 쿼리 실행 후 반환값 받아주기


            System.out.println("5. sql문 전송 성공, 결과1 >> " + result);
            // 트랜잭션 커밋
            if (result >= 1) {
                System.out.println("데이터 입력 완료");
                con.commit();
                System.out.println("6. 트랜잭션 커밋 완료.");
            }
            // Query가 제대로 실행되지 않은 경우
            else {
                System.out.println("데이터 입력 실패");
                con.rollback();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            if (con != null) {
                try {
                    con.rollback(); // 예외 발생 시 롤백
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("트랜잭션 롤백.");
            }

        } finally {
            try {
                ps.close(); // 먼저닫기
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                e.printStackTrace();
            }
        }
    }

    public void insert(String id, String pw, String name, String tel) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. 드라이버 설정 성공..");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "tiger";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공." + con);

            // 오토커밋을 false로 설정
            con.setAutoCommit(false);
            System.out.println("3. 오토 커밋 설정 비활성화.");

            // sql문 만들기, prepareStatement 준비된 문장
            String sql = "insert into MEMBER values (?, ?, ?, ?, sysdate)";
            ps = con.prepareStatement(sql);
            // ? 에 입력할 순서대로 매핑시키기
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, pw);
            ps.setString(3, name);
            ps.setString(4, tel);
            System.out.println("4. sql문 객체 생성 성공.");
            int result = ps.executeUpdate();    // ps. 객체 실행, 쿼리 실행, 쿼리 실행 후 반환값 받아주기


            System.out.println("5. sql문 전송 성공, 결과1 >> " + result);

            // 트랜잭션 커밋
            if (result >= 1) {
                System.out.println("데이터 입력 완료");
                con.commit();
                System.out.println("6. 트랜잭션 커밋 완료.");

            }
            // Query가 제대로 실행되지 않은 경우
            else {
                System.out.println("데이터 입력 실패");
                con.rollback();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            if (con != null) {
                try {
                    con.rollback(); // 예외 발생 시 롤백
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("트랜잭션 롤백.");
            }

        } finally {
            try {
                ps.close(); // 먼저닫기
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                e.printStackTrace();
            }
        }
    }

    // 탈퇴
    public void delete(String id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. 드라이버 설정 성공..");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "tiger";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공." + con);

            // 오토커밋을 false로 설정
            con.setAutoCommit(false);
            System.out.println("3. 오토 커밋 설정 비활성화.");

            // sql문 만들기, prepareStatement 준비된 문장 자동으로 ; 들어가니까 따로 안적어줘도 됨
            String sql = "delete from MEMBER where ID = ?";
            ps = con.prepareStatement(sql);
            // ? 에 입력할 순서대로 매핑시키기
            ps.setInt(1, Integer.parseInt(id));
            System.out.println("4. sql문 객체 생성 성공.");
            int result = ps.executeUpdate();    // ps. 객체 실행, 쿼리 실행, 쿼리 실행 후 반환값 받아주기


            System.out.println("5. sql문 전송 성공, 결과1 >> " + result);

            // 트랜잭션 커밋
            if (result >= 1) {
                System.out.println("데이터 입력 완료");
                con.commit();
                System.out.println("6. 트랜잭션 커밋 완료.");

            }
            // Query가 제대로 실행되지 않은 경우
            else {
                System.out.println("데이터 입력 실패");
                con.rollback();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            if (con != null) {
                try {
                    con.rollback(); // 예외 발생 시 롤백
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("트랜잭션 롤백.");
            }

        } finally {
            try {
                ps.close(); // 먼저닫기
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                e.printStackTrace();
            }
        }
    }

    public MemberDto selectOne(String id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDto memberDto = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. 드라이버 설정 성공..");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "tiger";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공." + con);

            // 오토커밋을 false로 설정
            con.setAutoCommit(false);
            System.out.println("3. 오토 커밋 설정 비활성화.");

            // sql문 만들기, prepareStatement 준비된 문장
            String sql = "SELECT * FROM MEMBER WHERE ID = ?";
            ps = con.prepareStatement(sql);
            // ? 에 입력할 순서대로 매핑시키기
            ps.setInt(1, Integer.parseInt(id));

            System.out.println("4. sql문 객체 생성 성공.");
            rs = ps.executeQuery();    // ps. 객체 실행, 쿼리 실행, 쿼리 실행 후 반환값 받아주기

            // https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm
            if(rs.next()) {
                memberDto = new MemberDto();
                memberDto.setId(rs.getInt("ID"));
                memberDto.setPw(rs.getString("PW"));
                memberDto.setName(rs.getString("NAME"));
                memberDto.setTel(rs.getString("TEL"));
                memberDto.setCreateDate(rs.getDate("CREAT_DATE"));
            }
            System.out.println("5. sql문 전송 성공, 결과1 >> " + rs);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            if (con != null) {
                try {
                    con.rollback(); // 예외 발생 시 롤백
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("트랜잭션 롤백.");
            }

        } finally {
            try {
                ps.close(); // 먼저닫기
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                e.printStackTrace();
            }
        }
        return memberDto;
    }

    public MemberDto login(MemberDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDto rsDto = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. 드라이버 설정 성공..");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "tiger";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공." + con);

            // 오토커밋을 false로 설정
            con.setAutoCommit(false);
            System.out.println("3. 오토 커밋 설정 비활성화.");

            // sql문 만들기, prepareStatement 준비된 문장
            String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PW = ?";
            ps = con.prepareStatement(sql);
            // ? 에 입력할 순서대로 매핑시키기
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getPw());

            System.out.println("4. sql문 객체 생성 성공.");
            rs = ps.executeQuery();    // ps. 객체 실행, 쿼리 실행, 쿼리 실행 후 반환값 받아주기

            // https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm
            if(rs.next()) {
                rsDto = new MemberDto();
                rsDto.setId(rs.getInt("ID"));
                rsDto.setPw(rs.getString("PW"));
                rsDto.setName(rs.getString("NAME"));
                rsDto.setTel(rs.getString("TEL"));
                rsDto.setCreateDate(rs.getDate("CREAT_DATE"));
            }
            System.out.println("5. sql문 전송 성공, 결과1 >> " + rs);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            if (con != null) {
                try {
                    con.rollback(); // 예외 발생 시 롤백
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("트랜잭션 롤백.");
            }

        } finally {
            try {
                ps.close(); // 먼저닫기
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                e.printStackTrace();
            }
        }

        return rsDto;
    }
}
