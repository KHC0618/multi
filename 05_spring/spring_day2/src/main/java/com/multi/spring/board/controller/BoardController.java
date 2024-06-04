package com.multi.spring.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.spring.board.model.dto.BoardDTO;
import com.multi.spring.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/bbs")
	public void boardBbs() {
		
	}
	
	@RequestMapping("/bbs_insert_form")
	public void boardInsertForm() {
		
	}
	
	@RequestMapping("/bbs_one_form")
	public void boardOneForm() {
		
	}
	
	@PostMapping("/insert")
	public String insertBoard(BoardDTO boardDTO, HttpSession session) throws Exception {
		
		System.out.println("insert ==> " + boardDTO);
		
		boardService.insertBoard(boardDTO);
		
		session.setAttribute("msg", "게시글 작성 성공");
		
		return "redirect:/board/bbs";
	}
	
	@GetMapping("/bbs_list")
	public void listBoard(Model model) throws Exception {
		
        List<BoardDTO> list = boardService.selectList();
        
        //System.out.println(list);
        
        model.addAttribute("list", list);
    }
	

	@GetMapping("/bbs_one")
    public void selectBoard(@RequestParam("no") int no, Model model) throws Exception {
        BoardDTO board = boardService.selectBoard(no);
        
        System.out.println(board);
        
        model.addAttribute("bag", board);
    }
}
