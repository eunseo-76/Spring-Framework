package com.kenny.section02.initdestroy.subsection01.java;

import com.kenny.common.Beverage;
import com.kenny.common.Bread;
import com.kenny.common.Product;
import com.kenny.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration  // 설정 관련 클래스 - ioc 컨테이너의 메타데이터. 4개의 객체가 ioc 컨테이너 안에 생성됨
public class ContextConfiguration {

    // bean 등록
    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 1000);
    }

    @Bean
    @Scope("prototype") // default 값인 singleton에서 prototype으로 변경
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner() {
        return new Owner();
    }
    // Owner 타입을 bean으로 등록하는데, ioc 컨테이너가 이 객체를 만들고 난 후, 초기화 할 작업이 있다면 initMethod에 적는다.
    // 이 객체가 소멸될 때 제거해야하는 리소스가 있다면 코드를 정의해놓고 destroyMethod 에 적는다.
}
