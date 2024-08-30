package com.kenny.section03.properties.subsection01.properties;

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

        System.out.println("cart2에 담긴 상품: " + cart2.getItem());

        // 붕어빵, 딸기우유는 properties 에서 가져온 내용이다.
        // key 값을 찾을 수 없으면 default 값(붕어빵, 0)을 가져온다.
    }

}
