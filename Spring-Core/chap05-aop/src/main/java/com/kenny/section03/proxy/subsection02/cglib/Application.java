package com.kenny.section03.proxy.subsection02.cglib;

import com.kenny.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.Enhancer;

public class Application {
    public static void main(String[] args) {
        OhgiraffersStudent ohgiraffersStudent = new OhgiraffersStudent();
        Handler handler = new Handler(ohgiraffersStudent);

        OhgiraffersStudent proxy
                = (OhgiraffersStudent) Enhancer.create(OhgiraffersStudent.class, handler);

        proxy.study(20);
    }
}


// AOP 는 프록시라는 대리인을 이용해 구현한다.
// 원래 호출하고 싶은 기능이 있는 객체를 T.O 라고 한다.
// T.O를 호출하면서 공통적인 전처리, 후처리 기능을 수행하고 싶다. 이럴 때 AOP를 한다.
// T.O와 전처리, 후처리 기능을 감싸는 프록시를 사용한다.
// 프록시를 만드는 방법은 두 가지가 있다.