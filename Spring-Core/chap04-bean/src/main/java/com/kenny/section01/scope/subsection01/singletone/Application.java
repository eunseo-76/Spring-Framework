package com.kenny.section01.scope.subsection01.singletone;

import com.kenny.common.Product;
import com.kenny.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // ioc 컨테이너의 4가지 객체 꺼내기
        /* 슈퍼에 상품이 진열되어 있다. */
        // 메소드의 이름이 bean의 이름 (대문자 -> 소문자)
        Product carpBread = applicationContext.getBean("carpBread", Product.class);
        Product milk = applicationContext.getBean("milk", Product.class);
        Product water = applicationContext.getBean("water", Product.class);

        /* 한 손님이 쇼핑 카트를 꺼내 상품을 카트에 담는다. */
        ShoppingCart cart = applicationContext.getBean("cart", ShoppingCart.class);
        cart.addItem(carpBread);
        cart.addItem(milk);

        System.out.println("cart에 담긴 상품 : " + cart.getItem());

        /* 다른 손님이 쇼핑 카트를 꺼내 상품을 카트에 담는다. */
        ShoppingCart cart2 = applicationContext.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2에 담긴 상품: " + cart2.getItem()); // 이미 담긴 다른 값에 water를 추가한 결과가 나옴
        // 기본적으로 bean이 관리되는 스코프는 singleton = 오직 하나의 객체만 만들어서 관리한다
        /* Bean의 기본 스코프는 singleton 이다.
        * singleton 스코프를 갖는 bean은 애플리케이션 내에서 유일한 인스턴스를 갖는다. */
    }

}
