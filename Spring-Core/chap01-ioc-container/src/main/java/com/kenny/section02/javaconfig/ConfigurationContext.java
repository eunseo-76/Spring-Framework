package com.kenny.section02.javaconfig;

import com.kenny.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 해당 클래스가 bean을 생성하는 설정 클래스임을 표기
@Configuration("configurationSection02")
public class ConfigurationContext {

    @Bean(name="member")    // bean의 이름을 설정하지 않으면 메소드 이름과 동일하게 됨 (이 경우 getMember)
    public MemberDTO getMember() {  // 메소드의 반환 타입이 'MemberDTO'
        return new MemberDTO(1, "user01", "pass01", "홍길동");
        // 모든 매개변수를 가지는 생성자
    }
}

// xml config와 동일한 내용
//
