package com.kenny.section03.proxy.subsection02.cglib;

import com.kenny.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    /* Target Object로 class 타입 사용 가능 */
    // 인터페이스가 아니라 클래스 (Student -> ohgiraffersStudent 로 변경)
    private final OhgiraffersStudent ohgiraffersStudent;
    public Handler(OhgiraffersStudent ohgiraffersStudent) {
        this.ohgiraffersStudent = ohgiraffersStudent;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 타겟 메소드 호출 전
        System.out.println("===== 공부가 너무 하고 싶습니다 =====");
        // 메소드와 전달 인자 출력
        System.out.println("호출 대상 메소드 : " + method);
        for(Object arg : args) {
            System.out.println("전달 인자 : " + arg);
        }

        method.invoke(ohgiraffersStudent, args);   // 타겟 메소드 호출

        // 타겟 메소드 호출 후
        System.out.println("===== 공부를 마치고 수면 학습을 시작합니다 =====");

        return proxy;
    }
}
