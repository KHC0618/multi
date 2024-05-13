package com.multi.jdbc.member.model.dao;

import com.multi.jdbc.common.DBConnectionMgr;
import com.multi.jdbc.member.model.dto.MemberDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
    Connection con = null;
    DBConnectionMgr dbcp;

    public MemberDao() {
        try {
            dbcp = DBConnectionMgr.getInstance();
            con = dbcp.getConnection();
            con.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public MemberDao(MemberDto memberDto) {
    }


    public int insert(MemberDto memberDto) {
        int result = 0;
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO MEMBER VLAUES(null, ?, ?, ?, ?, now())";
            ps = con.prepareStatement(sql);
            ps.setString(1, memberDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }

    public int delete(String id) {
        int result = 0;
        PreparedStatement ps = null;

        try {
            String sql = "DELETE FROM member WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);

            result = ps.executeUpdate();

            if(result > 0) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;
    }

    public int update(MemberDto memberDto) {
        int result = 0;



        return result;
    }

    public MemberDto selectOne(String id) {
        MemberDto rsDto = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            String sql = "select * from member where id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if(rs.next()) {
                rsDto = new MemberDto();
                rsDto.setId(rs.getString("id"));
                rsDto.setId(rs.getString("pw"));
                rsDto.setId(rs.getString("name"));
                rsDto.setId(rs.getString("tel"));
            }
        } catch (SQLException e) {
            System.out.println("에러 발생");
        } finally {
            dbcp.freeConnection(con, ps, rs);
        }

        return rsDto;
    }

    public ArrayList<MemberDto> list() {
        ArrayList<MemberDto> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select * from member";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {

                MemberDto memberDto = new MemberDto();
                memberDto.setId(rs.getString("id"));
                memberDto.setPw(rs.getString("pw"));
                memberDto.setName(rs.getString("name"));
                memberDto.setTel(rs.getString("tel"));

                list.add(memberDto);
            }
        } catch (SQLException e) {
            System.out.println("에러 발생");
        } finally {
            dbcp.freeConnection(con, ps, rs);
        }

        return list;
    }
}
