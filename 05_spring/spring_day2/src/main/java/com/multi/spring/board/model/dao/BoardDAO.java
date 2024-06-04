package com.multi.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.board.model.dto.BoardDTO;
import com.multi.spring.member.model.dto.MemberDTO;

@Repository
public class BoardDAO {

	public int insertBoard(SqlSessionTemplate sqlSession, BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert("boardMapper.insertBoard", boardDTO);
	}

	public List<BoardDTO> selectList(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.selectList");
	}

	public BoardDTO selectOne(SqlSessionTemplate sqlSession, int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.selectBoard", no);
	}

}
