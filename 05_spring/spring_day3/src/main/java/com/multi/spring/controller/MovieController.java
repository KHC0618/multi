package com.multi.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.spring.model.dto.MovieDTO;

@Controller
public class MovieController {
	
	@RequestMapping("movie")
	public void movie(MovieDTO movieDTO, Model model) {
		model.addAttribute("result", movieDTO);
	}
}
