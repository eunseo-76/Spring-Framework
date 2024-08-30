package com.kenny.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // ioc 컨테이너 생성 (베이스 패키지 하위를 훑어 어노테이션 기반으로 스캐닝)
        // 클래스명 기반으로 bean 이름 등록됨
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.kenny.section01.aop");

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        System.out.println("========= selectMembers ==========");
        System.out.println(memberService.selectMembers());
        System.out.println("========= selectMember ==========");
        System.out.println(memberService.selectMember(1L)); // 1L -> 3L 변경 시 after throwing exception 발생도 확인 가능

        // 핵심 관점의 기능 : selectMembers, selectMember
        // 이런 기능이 수행되었음에 대한 기록을 남긴다(logging).

        // 핵심 기능이 동작할 때, 부가적인 코드를 aop를 통해 삽입하고자 한다.
        // 이를 위해 핵심 기능에 대한 부분을 point-cut으로 잡는다 (나는 이런 상황에 대해 부가 코드를 삽입하고 싶다.)
        // @pointcut을 대상으로 하여, 해당 핵심 기능이 수행되기 전에 @Before 로그를 출력한다.

        // targetObject : MemberService
        // aop 설정을 하게 되면, MemberService를 감싸는 proxy 객체가 만들어짐.
        // proxy 객체가 @before advice를 먼저 동작시키도 targetObejct를 동작하게 한다.
    }
}
