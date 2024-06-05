package com.multi.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@RequestMapping("/main")
	public String main() {
		return "/home";
	}
	
	@GetMapping("/bbs")
	public void bbsList() {
		
	}
	
	@GetMapping("/write")
	public void bbsWrite() {
		
	}
}
