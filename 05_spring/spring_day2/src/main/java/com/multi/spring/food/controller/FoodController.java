package com.multi.spring.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.spring.food.model.dto.FoodDTO;

@Controller
@RequestMapping("/food")
public class FoodController {
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/food")
	public void foodMain() {
		
	}
	
	@GetMapping("/choice")
	public String foodChoice(FoodDTO foodDTO) {
		System.out.println(foodDTO);
		
		String like = foodDTO.getLike();
		String dislike = foodDTO.getDislike();
		
		String page = "redirect:/food";
		
		if(like.equals("라면")) {
			page = "/food/like";
		}
		
		if(dislike.equals("커피")) {
			page = "/food/dislike";
		}
		
		return page;
	}
		
	
}
