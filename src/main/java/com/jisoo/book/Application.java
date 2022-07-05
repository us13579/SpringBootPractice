package com.jisoo.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// springbootapplication이 스프링부트 자동설정, 스프링 bean 읽기 생성 모두 자동
// springbootapplication이 있는 위치부터 설정을 읽어가므로 맨위에 있어야 한다
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장서버 실행 ( 내장 WAS ) -> 톰캣 설치 x, jar 파일로 실행가능
        // 언제나 같은 환경에서 스프링 부트 배포
        SpringApplication.run(Application.class, args);
    }
}
