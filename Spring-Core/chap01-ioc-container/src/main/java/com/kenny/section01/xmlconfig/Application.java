package com.kenny.section01.xmlconfig;

import com.kenny.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        // ico 컨테이너에 등록한 bean 객체가 생성되었는지 확인
        MemberDTO member1 = (MemberDTO) applicationContext.getBean("member");    // bean id : 이름만 알려주기(type 명시 불가. 반환 타입이 object라 다운 캐스팅 필요
        MemberDTO member2 = applicationContext.getBean(MemberDTO.class); // 클래스 메타 정보(이런 타입의 bean이 있는지)
        MemberDTO member3 = applicationContext.getBean("member", MemberDTO.class);  // 가장 정확하게 해당 bean의 이름, 타입 전달

        System.out.println(member3);

        // application context는 스프링 ico 컨테이너이다.
        // xml configuration metadata를 통해 ioc 컨테이너를 생성하고, 생성한 컨테이너로 bean 객체를 확인한다.
        // 직접 new MemberDTO 이렇게 하지 않고 ioc 컨테이너가 xml configuration metadata를 기반으로 객체를 만든다.
    }
}
