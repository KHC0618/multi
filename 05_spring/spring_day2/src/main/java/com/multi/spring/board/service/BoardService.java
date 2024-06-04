package com.multi.spring.board.service;

import java.util.List;

import com.multi.spring.board.model.dto.BoardDTO;
import com.multi.spring.member.model.dto.MemberDTO;

public interface BoardService {

	void insertBoard(BoardDTO boardDTO) throws Exception ;

	List<BoardDTO> selectList() throws Exception ;

	BoardDTO selectBoard(int no) throws Exception ;

}
