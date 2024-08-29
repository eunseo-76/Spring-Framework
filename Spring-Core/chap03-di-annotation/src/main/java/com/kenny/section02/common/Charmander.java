package com.kenny.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary    // @Autowired로 동일 타입의 여러 bean이 찾아진 경우 우선시 할 타입을 설정
public class Charmander implements Pokemon {
    @Override
    public void attack() {
        System.out.println("파이리 불꽃 공격");
    }
}