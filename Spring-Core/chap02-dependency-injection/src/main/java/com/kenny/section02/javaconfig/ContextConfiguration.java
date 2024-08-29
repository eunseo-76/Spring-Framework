package com.kenny.section02.javaconfig;

import com.kenny.common.Account;
import com.kenny.common.MemberDTO;
import com.kenny.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Member;

@Configuration
public class ContextConfiguration {
    @Bean
    // 반환형에 등록하고 싶은 타입
    public Account accountGenerator() {
        return new PersonalAccount(20, "110-234-567890");
    }
    // 메소드로 정의함

    /* bean 등록에 상용된 메소드를 호출하여 의존성 주입을 처리할 수 있다. */
    @Bean
    public MemberDTO memberGenerator() {
        /* 1. 생성자 주입 */
//        return new MemberDTO(1, "홍길동", "010-1234-5678", "hong@gmail.com", accountGenerator());
        // 의존성을 생성자로 주입했다.

        /* 2. setter 주입 */
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("홍길동");
        member.setPhone("010-1234-5678");
        member.setEmail("hong@gmail.com");
        member.setPersonalAccount(accountGenerator());
        return member;
    }

}
