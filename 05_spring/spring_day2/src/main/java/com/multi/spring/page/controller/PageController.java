package com.multi.spring.page.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.spring.page.model.dto.BbsDTO;
import com.multi.spring.page.model.dto.PageDTO;
import com.multi.spring.page.service.BbsService;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@Autowired
	BbsService bbsService;
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/bbsMain")
	public void pageMain() {
		
	}
	
	@GetMapping("/bbsAll")
	public void selectAll(PageDTO pageDTO, Model model) {
		pageDTO.setStartEnd(pageDTO.getPage());
		
		List<BbsDTO> list = bbsService.selectAll(pageDTO);
			
		int count = bbsService.selectCount();
		
		int pages = count / 10 + 1;
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pages", pages);
		
	}
	
	@GetMapping("/bbsAll2")
	public void selectAll2(PageDTO pageDTO, Model model) {
		pageDTO.setStartEnd(pageDTO.getPage());
		
		List<BbsDTO> list = bbsService.selectAll(pageDTO);
			
		int count = bbsService.selectCount();
		
		int pages = count / 10 + 1;
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pages", pages);
	}
	
	@GetMapping("/bbsList2")
	public void selectList2(PageDTO pageDTO, Model model) {
		pageDTO.setStartEnd(pageDTO.getPage());
		
		List<BbsDTO> list = bbsService.selectAll(pageDTO);
		
		model.addAttribute("list", list);
	}
}
	