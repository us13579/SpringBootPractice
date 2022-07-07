package com.jisoo.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

// springbootTest와 JUnit 사이에 연결자 역할을 한다
@RunWith(SpringRunner.class)
// Web 에 집중할 수 있는 어노테이션
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // 웹 API 테스트할 때 사용
    // 스프링 MVC 테스트의 시작점
    // 이 클래스를 통해 GET, POST에 대한 API 테스트가 가능
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";

        // get 요청
        // isOk -> 200 인지 아닌지 검증
        // mvc.perform 결과를 검증
        // hello 값이 맞는지 검증
        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    public void hello_dto_return() throws Exception{
        String name = "hello";
        int amount = 10000;

        // param : API 테스트할 때 사용될 요청 파라미터를 설정
        // String 값만 가능
        // jsonPath는 JSON 응답값을 필드별로 검증할 수 있는 메서드
        // $를 기준으로 필드명을 명시
        // $.name , $.amount
        mvc.perform(get("/hello/dto").param("name",name).param("amount", String.valueOf(amount))).andExpect(status().isOk()).andExpect(jsonPath("$.name",is(name))).andExpect(jsonPath("$.amount",is(amount)));
    }

}
