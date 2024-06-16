package com.multi.crud.service;

import com.multi.crud.config.CrudApplication;
import com.multi.crud.config.MybatisConfig;
import com.multi.crud.model.dto.CategoryDTO;
import com.multi.crud.model.dto.MenuDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ContextConfiguration(classes = {CrudApplication.class, MybatisConfig.class})
@Transactional
class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void testInit(){assertNotNull(menuService);}

    @Test
    void findAllMenu() {
        //given //없음

        //when
        List<MenuDTO> menuList = menuService.findAllMenu();

        //then
        assertNotNull(menuList);
        menuList.forEach(menu -> System.out.println(menu)); //람다식 //하나씩 찍어보기
    }

    @Test
    public void 전체_카테고리_조회용_서비스메소드_테스트() {
        //given

        //when
        List<CategoryDTO> categoryList = menuService.findAllCategory();

        //then
        assertNotNull(categoryList);


    }

    @Test
    @Rollback//(value = true) //롤백 테스트: MenuServiceTest에 @Transactional
    public void 신규_메뉴_등록용_서비스_성공_테스트() throws Exception {
        //given
        MenuDTO menu = new MenuDTO();
        menu.setName("JunitTestMenu");
        menu.setPrice(10000);
        menu.setCategoryCode(1);
        menu.setOrderableStatus("Y");

        //when
        boolean result  = menuService.registMenu(menu);

        //then
        assertTrue(result); //true면 통과
    }

    @Test
    public void 신규_메뉴_등록용_서비스_실패_테스트() throws Exception {
        //given
        MenuDTO menu = new MenuDTO();
        menu.setName("JunitTestMenu");
        menu.setPrice(10000);
        menu.setCategoryCode(100000); //제약 조건에 위배 --> 에러 발생 --> 실패 테스트 성공
        menu.setOrderableStatus("Y");


        //then
        assertThrows(Exception.class, () -> menuService.registMenu(menu), "메뉴등록실패");
    }

}