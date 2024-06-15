package com.multi.spring.board.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.multi.spring.board.model.dto.BoardDTO;
import com.multi.spring.board.service.BoardService;

@SessionAttributes("loginUser")
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/write")
    public void write() {
    	
    }

    @PostMapping("/write")
    public String writePost(BoardDTO board, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
    	
    	String root = request.getSession().getServletContext().getRealPath("resources");
		
		System.out.println("root : " + root);
		
		String filePath = root + "\\uploadFiles";
		
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
    	
        if (!file.isEmpty()) {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            file.transferTo(new File(filePath + "\\" + fileName));
            board.setFileName(fileName);
        }
        
        board.setWriter("test0604");
        
        boardService.insertBoard(board);
        return "redirect:/board/bbs";
    }

    @GetMapping("/bbs")
    public void bbs(Model model) throws Exception {
        List<BoardDTO> boardList = boardService.selectList();
        
        model.addAttribute("list", boardList);
    }

    @GetMapping("/board/view/{bbsId}")
    public void view(@PathVariable("bbsId") int bbsId, Model model) throws Exception {
        BoardDTO board = boardService.selectBoard(bbsId);
        model.addAttribute("board", board);
    }

    @GetMapping("/delete/{bbsId}")
    public String delete(@PathVariable("bbsId") int bbsId) throws Exception {
        boardService.deleteBoard(bbsId);
        return "redirect:/board/bbs";
    }

    @GetMapping("/update/{bbsId}")
    public String update(@PathVariable("bbsId") int bbsId, Model model) throws Exception {
        BoardDTO board = boardService.selectBoard(bbsId);
        model.addAttribute("board", board);
        return "update";
    }

    @PostMapping("/update")
    public String updatePost(BoardDTO board, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
    	
    	String root = request.getSession().getServletContext().getRealPath("resources");
		
		System.out.println("root : " + root);
		
		String filePath = root + "\\uploadFiles";
		
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
    	
        if (!file.isEmpty()) {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            file.transferTo(new File(filePath + "\\" + fileName));
            board.setFileName(fileName);
        }
        boardService.updateBoard(board);
        return "redirect:/board/bbs";
    }
}













