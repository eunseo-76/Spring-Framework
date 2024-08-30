package com.kenny.section02.initdestroy.subsection01.java;

import com.kenny.common.Product;
import com.kenny.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 초기화(init)와 폐기(destroy)를 설정해본다.
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // ioc 컨테이너에서 bean을 생성한 후, 초기화할 때 initMethod로 설정한 내용이 출력된다.

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
        // 종료되었음에도 destroyMethod가 출력이 되지 않음.
        // ioc 컨테이너를 종료하는 내용이 따로 없이 프로그램이 종료되었기 때문.

        /* Spring 컨테이너 종료 전에 프로세스가 종료되어 destroyMethod 확인이 되지 않으므로
        * 컨테이너 종료 코드를 작성하여 확인한다. */
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
