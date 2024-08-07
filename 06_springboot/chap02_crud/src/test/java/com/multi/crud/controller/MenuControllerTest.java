package com.multi.crud.controller;

import com.multi.crud.config.CrudApplication;
import com.multi.crud.config.MybatisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//1. 수동 세팅
@SpringBootTest
@ContextConfiguration(classes = {CrudApplication.class, MybatisConfig.class, ContextConfiguration.class})
@Transactional
@AutoConfigureMockMvc //2. 자동 세팅 시 추가
class MenuControllerTest {
    /*
     *  Mock : 사전적 의미로 테스트를 위해 만든 모영, 테스트를 위해 실제 객체와 비슷 한 모의 객체를 만드는 것을 의미
     *  MockMvc : 서블릿 컨테이너를 모킹 한 객체이다.
     *
     *   *순서고려 해서 작성안해도 된다. 순서 상관없이 동작
     * @BeforeAll : 단위테스트 시작시 한번만 동작 , static 으로 작성 (공통적으로 사용 되는것을 싱글톤으로 먼저 생성할때 )
     * @BoforeEach : 매단위 테스트 전에 동작, 4 버전에는 @Before
     *
     * @AfterEach
     * @AfterAll
     * */

    //의존성 주입
    @Autowired
    private  MenuController menuController;

    @Autowired //2. 자동 세팅
    private MockMvc mockMvc;

//    @BeforeEach //1. 수동 세팅
//    public void setup(){mockMvc = MockMvcBuilders.standaloneSetup(menuController).build();
//    }


    @Test
    public void testInit(){
        assertNotNull(menuController);
        assertNotNull(mockMvc);
    }
    /*
     *
              MockMvcRequestBuilders
              요청 데이터를 설정할 때 사용할 static 메서드
              MockMvcResultMatchers
              실행 결과를 검증할 때 사용할 static 메서드
              MockMvcResultHandlers
              실행 결과를 로그 등으로 출력할 때 사용할 static 메서드
              *
              * * MockMvcResultMatcher 객체가 제공하는 메소드
               * 응답 상태 코드 검증
               * isOk() 응답 상태 코드가 정상적인 처리(200)인지 확인
               * isNotFount()   응답 상태 코드가 404 Not Found인지 확인
               * isMethodNotAllowed()   응답 상태 코드가 메소드 불일치(405)인지 확인
               * isInternalServerError()    응답 상태 코드가 예외발생(500)인지 확인
               * is(int status) 몇 번 응답 상태 코드가 설정되었는지 확인 ex) is(200), is(404)
          *
          * */
    @Test
    void 전체_메뉴_조회_컨트롤러_테스트() throws Exception {
        // perform() :  MockMvc가 제공하는 메서드로, 브라우저에서 서버에 URL 요청을 하듯 컨트롤러를 실행
        mockMvc.perform(MockMvcRequestBuilders.get("/menu/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.forwardedUrl("menu/list")) //포워딩 경로일때
                .andExpect(MockMvcResultMatchers.view().name("menu/list")) //ModelAndView
                .andDo(MockMvcResultHandlers.print());
                // andDo() : 추가로 실행할 메소드를 실행할 때 (이 경우 콘솔 출력)
    }

    @Test
    public void 전체_카테고리_조회용_컨트롤러_테스트_동작_확인() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/menu/category"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    @Rollback(true)
    public void 신규_메뉴_등록용_컨트롤러_테스트() throws Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();//  폼에서 넘어올 값을 미리 작성
        params.add("name", "테스트메뉴");
        params.add("price", "40000");
        params.add("categoryCode", "5");
        params.add("orderableStatus", "Y");


        mockMvc.perform(MockMvcRequestBuilders.post("/menu/regist").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/menu/list"))
                .andExpect(MockMvcResultMatchers.flash().attribute("successMessage", "신규메뉴 등록에 성공하셨습니다.")) //value --> MenuController랑 일치해야 함
                .andDo(MockMvcResultHandlers.print());
    }

}