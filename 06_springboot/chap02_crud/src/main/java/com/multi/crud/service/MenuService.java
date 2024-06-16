package com.multi.crud.service;

import com.multi.crud.model.dao.MenuMapper;
import com.multi.crud.model.dto.CategoryDTO;
import com.multi.crud.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class MenuService { //괄호 안에서 test 만들기 create new test //ctrl+shift+t

    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper){
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu(){
        return menuMapper.findAllMenu();
    };

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    public boolean registMenu(MenuDTO menu) throws Exception{
        int result  = menuMapper.registMenu(menu);

        if(result < 0){
            throw new Exception("메뉴 등록 실패");
        }
        return result > 0 ? true :false;
    }

}
