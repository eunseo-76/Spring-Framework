package com.kenny.section03.proxy.subsection01.dynamic;

import com.kenny.section03.proxy.common.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 직접 proxy 객체를 만들어보자.
public class Handler implements InvocationHandler {

    /* 타겟 오브젝트*/
    private final Student student;

    public Handler(Student student) {
        this.student = student;
    }

    // invocation handler가 반드시 구현해야 하는 메소드
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 타겟 메소드 호출 전
        System.out.println("===== 공부가 너무 하고 싶습니다 =====");
        // 메소드와 전달 인자 출력
        System.out.println("호출 대상 메소드 : " + method);
        for(Object arg : args) {
            System.out.println("전달 인자 : " + arg);
        }

        method.invoke(student, args);   // 타겟 메소드 호출

        // 타겟 메소드 호출 후
        System.out.println("===== 공부를 마치고 수면 학습을 시작합니다 =====");

        return proxy;

    }
}

// 개념을 이해하려는 목적이므로 코드가 너무 어렵다고 좌절하지 말자~.~