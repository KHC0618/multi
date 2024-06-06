package com.multi.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.board.model.dto.BoardDTO;

@Repository
public class BoardDAO {

    public int insertBoard(SqlSessionTemplate sqlSession, BoardDTO boardDTO) {
        return sqlSession.insert("boardMapper.insertBoard", boardDTO);
    }

    public List<BoardDTO> selectList(SqlSessionTemplate sqlSession) {
        return sqlSession.selectList("boardMapper.selectList");
    }

    public BoardDTO selectOne(SqlSessionTemplate sqlSession, int bbsId) {
        return sqlSession.selectOne("boardMapper.selectBoard", bbsId);
    }

    public int deleteBoard(SqlSessionTemplate sqlSession, int bbsId) {
        return sqlSession.delete("boardMapper.deleteBoard", bbsId);
    }

    public int updateBoard(SqlSessionTemplate sqlSession, BoardDTO boardDTO) {
        return sqlSession.update("boardMapper.updateBoard", boardDTO);
    }
}
