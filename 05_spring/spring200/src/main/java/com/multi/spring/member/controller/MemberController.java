package com.multi.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.multi.spring.member.model.dto.MemberDTO;
import com.multi.spring.member.service.MemberService;

@SessionAttributes("loginUser")	// Model에 Attribute 추가할때 자동으로 설정된 키값을 세션에 등록 시키는 기능
@Controller
@RequestMapping("/member")
public class MemberController {
	private final MemberService memberService;
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/main")
	public String main() {
		return "/home";
	}
	
	@RequestMapping("/member")
	public void memberMain() {
		
	}
	
	@RequestMapping("/insert_form")
	public void insertForm() {
		
	}
	
	@RequestMapping("/delete_form")
	public void deleteForm() {
		
	}
	
	@RequestMapping("/update_form")
	public void updateForm() {
		
	}
	
	@RequestMapping("/one_form")
	public void oneForm() {
		
	}
	
	@RequestMapping("/one")
	public void memberOne() {
		
	}
	
	@RequestMapping("/enrollForm")
	public String enrollForm() {
		return "member/enroll_form";
	}
	
	@PostMapping("/insert")
	public String insertMember(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		System.out.println("insert ==> " + memberDTO);
		
		memberService.insertMember(memberDTO);
		
		session.setAttribute("msg", "회원가입성공");
		
		return "redirect:/member/member";
	}

	@GetMapping("/list")
	public void listMembers(Model model) throws Exception {
		
        List<MemberDTO> list = memberService.selectList();
        
        model.addAttribute("list", list);
    }
	
	@GetMapping("/delete")
    public String deleteMember(String id, HttpSession session) throws Exception {
		
        memberService.deleteMember(id);
        
        session.setAttribute("msg", "회원삭제성공");
        
        return "redirect:/member/member";
    }
	
	@PostMapping("/update")
	public String updateMember(MemberDTO memberDTO, HttpSession session) throws Exception {
        memberService.updateMember(memberDTO);
        
        session.setAttribute("msg", "회원정보수정성공");
        
        return "redirect:/member/member";
    }
	
	@GetMapping("/one")
    public void selectMember(String id, Model model) throws Exception {
        MemberDTO member = memberService.selectMember(id);
        
        model.addAttribute("dto", member);
    }
	
//	@PostMapping("/login")
//	public String loginMember(MemberDTO memberDTO, HttpSession session) {
//		
//		System.out.println("login ==> " + memberDTO);
//		
//		try {
//			MemberDTO dto = memberService.loginMember(memberDTO);
//			session.setAttribute("loginUser", dto);
//			
//			return "redirect:/";
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "common/errorPage";
//		}
//	}
//	
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
	
	@PostMapping("/login")
	public String loginMember(MemberDTO memberDTO, Model model) {
		
		System.out.println("login ==> " + memberDTO);
		
		try {
			MemberDTO dto = memberService.loginMember(memberDTO);
			model.addAttribute("loginUser", dto);
			return "redirect:/";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "common/errorPage";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();	//현재 SessionAttributes 에 의해 저장된 오브젝트를 제거
		return "redirect:/";
	}
}