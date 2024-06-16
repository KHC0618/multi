package com.multi.crud.controller;

import com.multi.crud.model.dto.CategoryDTO;
import com.multi.crud.model.dto.MenuDTO;
import com.multi.crud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController { //괄호 안에서 test 만들기 create new test //ctrl+shift+t

    private final MenuService menuService;
    private final MessageSource messageSource;

    @Autowired
    public  MenuController(MenuService menuService, MessageSource messageSource){
        this.menuService = menuService;
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public ModelAndView findMenuList(ModelAndView mv){

        List<MenuDTO> menuList = menuService.findAllMenu();
        menuList.forEach((menu -> System.out.println("menu = " + menu)));

        mv.addObject("menuList", menuList);
        mv.setViewName("menu/list");


        return mv;
    }

    @GetMapping(value="category", produces = "application/json; charset=UTF-8") //produces 반환할 타입 지정 --> 이미지/미디어 타입 지정할 때도 사용
    @ResponseBody //json 형태로 반환할 때 (위의 contorller 사용하고 있음)
    public List<CategoryDTO> findAllCategory(){
        return menuService.findAllCategory();
    }

    @GetMapping("regist")
    public void registPage(){}

    @PostMapping("regist")
    public ModelAndView registMenu(ModelAndView mv, MenuDTO newMenu, RedirectAttributes rttr, Locale locale) throws Exception {
        menuService.registMenu(newMenu);
        mv.setViewName("redirect:/menu/list");
        //rttr.addFlashAttribute("successMessage","신규메뉴 등록에 성공하셨습니다.");
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMenu", null,locale)); //messages/message_[브라우저에서 설정된 언어].properties 뜸

        return mv;
    }

}
