package com.jisoo.book.springboot.web.dto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        String name = "test";
        int amount = 10000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // assertThat은 assertj라는 테스트 검증 라이브러리의 검증 메서드
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
