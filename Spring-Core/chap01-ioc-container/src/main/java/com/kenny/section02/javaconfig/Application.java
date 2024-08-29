package com.kenny.section02.javaconfig;

import com.kenny.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

// xml이 아니라 자바 파일로 metadata 만들기
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContext.class);
        // 메타 정보를 기반으로 ioc 컨테이너 생성 (등록한 bean이 생성된다)

        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println(member);
    }
}
