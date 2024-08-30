package com.kenny.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// owner bean 등록
@Component
public class Owner {
    @PostConstruct  //  initMethod와 같은 설정 어노테이션. 객체 생성(construct) 이후(post) 호출
    public void openShop() {
        System.out.println("사장님이 가게 문을 열었습니다. 이제 쇼핑을 하실 수 있습니다.");
    }

    @PreDestroy // destoryMethod와 같은 설정 어노테이션. 객체 소멸(destory) 이전(pre) 호출
    public void closeShop() {
        System.out.println("사장님이 가게 문을 닫았습니다. 이제 쇼핑을 하실 수 없습니다.");
    }
}
