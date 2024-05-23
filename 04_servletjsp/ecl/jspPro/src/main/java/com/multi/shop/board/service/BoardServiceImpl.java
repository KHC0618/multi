package com.multi.shop.board.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import static com.multi.shop.common.Template.getSqlSession;

import com.multi.shop.board.model.dao.BoardDAO;
import com.multi.shop.board.model.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDao = new BoardDAO();

	@Override
	public ArrayList<BoardDTO> selectList() throws Exception {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<BoardDTO> list = boardDao.selectList(sqlSession);
		sqlSession.close();
		
		
		return list;
	}

	@Override
	public BoardDTO selectBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession = getSqlSession();
		
		boardDao.updateCount(sqlSession, bno);
	    sqlSession.commit();
		
        BoardDTO board = boardDao.selectBoard(sqlSession, bno);
        sqlSession.close();
        
        return board;
	}

	@Override
	public int insertBoard(BoardDTO newBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

}
