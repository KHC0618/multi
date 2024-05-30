package com.multi.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RestController
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
}
