package com.jisoo.book.web;

import com.jisoo.book.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
@RestController
public class HelloController {

    // GET 요청을 받는다
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // @RequestParam() -> 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    // 외부에서 name이라는 값을 가져왔기 때문에 사용 -> 이것을 String name에 저장
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
