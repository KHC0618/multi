package com.multi.crud.model.dao;


import com.multi.crud.model.dto.CategoryDTO;
import com.multi.crud.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper { //괄호 안에서 test 만들기 create new test //ctrl+shift+t

    List<MenuDTO> findAllMenu();

    MenuDTO findMenuByCode(int code);

    List<CategoryDTO> findAllCategory();

    int registMenu(MenuDTO menu);

}
