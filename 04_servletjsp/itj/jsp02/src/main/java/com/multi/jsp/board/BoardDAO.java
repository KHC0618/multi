package com.multi.jsp.board;

import com.multi.jsp.common.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
    Connection con = null;
    DBConnectionMgr dbcp;

    public BoardDAO() {
        try {
            dbcp = DBConnectionMgr.getInstance();
            con = dbcp.getConnection();
            System.out.println(con);
        } catch (SQLException e) {
            System.out.println("에러 발생 !!");
        }
    }

    public int insert(BoardDTO boardDTO) {
        PreparedStatement ps = null;

        int result = 0;

        try {
            String sql = "insert into board ( CATEGORY_CODE, TITLE, CONTENT, WRITER) values (?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(boardDTO.getCategory()));
            ps.setString(2, boardDTO.getTitle());
            ps.setString(3, boardDTO.getContent());
            ps.setString(4, boardDTO.getWriter());

            System.out.println("3. sql문 생성 성공!!");

            result = ps.executeUpdate();
            System.out.println("4. SQL문 MySQL로 전송 성공!!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("insert 에러 발생함.");
        } finally {
            dbcp.freeConnection(con, ps);
        }

        return result;
    }

    public int delete(String no) {
        PreparedStatement ps = null;

        int result = 0;

        try {
            String sql = "delete from board where no = ?";
            ps = con.prepareStatement(sql); //
            ps.setInt(1, Integer.parseInt(no));
            System.out.println("3. sql문 생성 성공!!");

            result = ps.executeUpdate();
            System.out.println("4. SQL문 MySQL로 전송 성공!!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("delete 에러 발생함.");
        }finally {
            dbcp.freeConnection(con, ps);//반납
        }
        return result;
    }

    public int update(String no, String title, String content) {
        PreparedStatement ps = null;
        int result = 0;

        try {
            String sql = "update board set title = ?, content = ? where no = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setInt(3, Integer.parseInt(no));
            System.out.println("3. sql문 생성 성공.");

            result = ps.executeUpdate();
            System.out.println("4. SQL문 MySQL로 전송 성공.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("update 에러 발생.");
        } finally {
            dbcp.freeConnection(con, ps);
        }

        return result;
    }

    public ArrayList<BoardDTO> list() {
        ArrayList<BoardDTO> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from board";
            ps = con.prepareStatement(sql);
            System.out.println("3. sql문 생성 성공.");

            rs = ps.executeQuery();
            System.out.println("4. SQL문 MySQL로 전송 성공.");

            while(rs.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setNo(rs.getString(1));
                dto.setCategory(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setContent(rs.getString(4));
                dto.setWriter(rs.getString(5));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("list 에러 발생.");
        } finally {
            dbcp.freeConnection(con, ps, rs);
        }

        return list;
    }

    public ArrayList<BoardDTO> one(String writer) {
        ArrayList<BoardDTO> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from board where writer = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, writer);
            System.out.println("3. sql문 생성 성공.");

            rs = ps.executeQuery();
            System.out.println("4. SQL문 MySQL로 전송 성공.");

            while(rs.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setNo(rs.getString(1));
                dto.setCategory(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setContent(rs.getString(4));
                dto.setWriter(rs.getString(5));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("one 에러 발생.");
        } finally {
            dbcp.freeConnection(con, ps, rs);
        }

        return list;
    }



}
