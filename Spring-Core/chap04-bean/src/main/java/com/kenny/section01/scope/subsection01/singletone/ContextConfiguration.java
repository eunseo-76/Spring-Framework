package com.kenny.section01.scope.subsection01.singletone;

import com.kenny.common.Beverage;
import com.kenny.common.Bread;
import com.kenny.common.Product;
import com.kenny.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
