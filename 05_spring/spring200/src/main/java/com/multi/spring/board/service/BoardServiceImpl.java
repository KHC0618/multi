package com.multi.spring.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.board.model.dao.BoardDAO;
import com.multi.spring.board.model.dto.BoardDTO;

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
        int result = boardDAO.insertBoard(sqlSession, boardDTO);
        if(result <= 0) {
            throw new Exception("게시글 작성에 실패하였습니다.");
        }
    }

    @Override
    public List<BoardDTO> selectList() throws Exception {
        return boardDAO.selectList(sqlSession);
    }

    @Override
    public BoardDTO selectBoard(int bbsId) throws Exception {
        return boardDAO.selectOne(sqlSession, bbsId);
    }

    @Override
    public void deleteBoard(int bbsId) throws Exception {
        int result = boardDAO.deleteBoard(sqlSession, bbsId);
        if(result <= 0) {
            throw new Exception("게시글 삭제에 실패하였습니다.");
        }
    }

    @Override
    public void updateBoard(BoardDTO boardDTO) throws Exception {
        int result = boardDAO.updateBoard(sqlSession, boardDTO);
        if(result <= 0) {
            throw new Exception("게시글 수정에 실패하였습니다.");
        }
    }
}