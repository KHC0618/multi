package com.multi.chap03security.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping(value ={"/", "/main"}) //루트로 들어올 때, main으로 들어올 때
    public String main(){

        return "main/main";
    }

    @PostMapping("/")
    public String redirectMain(){
        return "redirect:/";
    }
}
