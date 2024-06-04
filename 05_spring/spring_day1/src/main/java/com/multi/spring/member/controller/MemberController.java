package com.multi.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.spring.member.model.dao.MemberDAO;
import com.multi.spring.member.model.dto.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired	// bean scanning을 통해 해당 인터페이스를 구현한 클래스(구현체) 중, 
				// @component + 기능(@Service, @Repository)으로 등록되어 있는 bean을 찾아서 자동으로 주입(DI) 해준다.
//	MemberDAO memberDAO;
	
	private final MemberDAO memberDAO;
	//--------------------------------------------------------- //@Autowired
	public MemberController(MemberDAO memberDAO) {
		 this.memberDAO = memberDAO; 
	} 	
	
	@RequestMapping("/insert")	// @RequestMapping handlerMapping에 등록
	public void insert(@ModelAttribute MemberDTO memberDTO) {	// 커맨드 객체, command
					// @ModelAttribute 생략 가능(커맨드 객체에 생성자와 setter가 작성되어 있어야 함)
		System.out.println(memberDTO);
		memberDAO.insert(memberDTO);
		
		//return "insert";	// viewResolver에 의해 앞뒤로 경로와 확장자를 붙여서 클라이언트에 보여줄 수 있게 처리됨
	}
	
	@RequestMapping("/member")
	public void member() {
		
	}
	
	@RequestMapping("/login")
	public String login(MemberDTO memberDTO) {
		System.out.println(memberDTO);
		
		int result = 0; // 0 or 1 결과값 에따라
		if (result == 1) {
			return "ok";
		} else {
			return "redirect:member";
		}
		
	}
	
	@RequestMapping("/delete")
	// public void delete(String id) {	// @RequestParam을 생략하려면 매개변수명과 파라미터명을 동일하게 줘야한다.
	public void delete(@RequestParam("id") String writer) {
		System.out.println("받은 아이디는 : " + writer);
	}
	
}
