package com.multi.spring.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.multi.spring.book.model.dao.BookDAO;
import com.multi.spring.book.model.dto.BookDTO;

@SessionAttributes("loginUser")
@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookDAO dao;
	
	@GetMapping("/book")
	public void bookMain() {
		
	}
		
	@GetMapping("/list")
	public void bookList(Model model) {
		List<BookDTO> list = dao.list();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/one")
	public void bookOne(String id, Model model) {
		BookDTO bookDTO = dao.one(id);
		
		model.addAttribute("dto", bookDTO);
	}
	
	@PostMapping("/insert")
    public String insert(BookDTO book) {
        int result = dao.insert(book);
        
        if(result < 0) {
        	return "redirect:/common/error";
        }
        
        return "redirect:/book/list";
    }
	
	@RequestMapping("/delete")
    public String delete(String id) {
        int result = dao.delete(id);
        
        if(result < 0) {
        	return "redirect:/common/error";
        }
        
        return "redirect:/book/list";
    }
}
