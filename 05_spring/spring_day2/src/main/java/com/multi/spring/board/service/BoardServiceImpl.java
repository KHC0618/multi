package com.multi.spring.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.board.model.dao.BoardDAO;
import com.multi.spring.board.model.dto.BoardDTO;
import com.multi.spring.member.model.dto.MemberDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
private final BoardDAO boardDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		
		int result = boardDAO.insertBoard(sqlSession, boardDTO);
		
		if(result < 0) {
			throw new Exception("게시글 작성에 실패하였습니다.");
		}
	}

	@Override
	public List<BoardDTO> selectList() throws Exception {
		// TODO Auto-generated method stub
		List<BoardDTO> list = boardDAO.selectList(sqlSession);
		
		return list;
	}

	@Override
	public BoardDTO selectBoard(int no) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectOne(sqlSession, no);
	}

}
