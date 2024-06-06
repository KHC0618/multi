package com.multi.spring.board.service;

import java.util.List;

import com.multi.spring.board.model.dto.BoardDTO;


public interface BoardService {
    void insertBoard(BoardDTO boardDTO) throws Exception;
    List<BoardDTO> selectList() throws Exception;
    BoardDTO selectBoard(int bbsId) throws Exception;
    void deleteBoard(int bbsId) throws Exception;
    void updateBoard(BoardDTO boardDTO) throws Exception;
}