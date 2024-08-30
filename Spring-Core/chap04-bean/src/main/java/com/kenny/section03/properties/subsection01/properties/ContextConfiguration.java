package com.kenny.section03.properties.subsection01.properties;

import com.kenny.common.Beverage;
import com.kenny.common.Bread;
import com.kenny.common.Product;
import com.kenny.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

// 분리된 properties 파일에 있는 key 값을 value 어노테이션을 이용해 꺼내오자.
// 그리고 필요한 변수에 넣어보자.
// value 어노테이션을 이용해 필드에 값을 넣을 수도 있고, 매개변수로 넣을 수도 있다.
// 만약 value 값이 없다면, default 값이 나오게 할 수 있다.

@Configuration  // 설정 관련 클래스 - ioc 컨테이너의 메타데이터. 4개의 객체가 ioc 컨테이너 안에 생성됨
// resource 폴더 하위 경로를 기술하여 읽어올 properties 파일을 설정
@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    // ${key} 를 이용해 value를 가져와 해당 변수에 value를 삽입한다. (이 경우는 팥붕)
    // key 값을 찾지 못했을 경우 삽입하기 위해 default 값을 콜론 : 뒤에 적는다. (이 경우 붕어빵)
    // 치환자 문법을 사용할 때는 공백 없이 사용한다.
    // @Value는 lombok이 아니라 spring 에서 import!

    /* 필드에 읽어온 값 주입
    * 치환자 문법(placeholder) 을 이용하여 properties에 저장된 키 값을 입력하면 value에 해당하는 값이 가져와서 주입된다.
    * 양 옆에 공백이 있을 경우 값을 읽어오지 못하므로 주의한다.
    * 뒤에 : 을 사용하여 해당 key 값이 없을 경우의 대체 값을 작성할 수 있다. */
    @Value("${bread.carpbread.name:붕어빵}")
    private String name;

    @Value("${bread.carpbread.price:0}")    // nam, pric 이런 식으로 바꾸면 properties에서 해당하는 값이 없으므로 디폴트 값을 넣는다.
    private int price;

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    // milk 라는 bean을 등록하면서, value 어노테이션을 사용해 치환자 문법을 사용한다.
    @Bean
    public Product milk(@Value("${beverage.milk.name}") String name,
                        @Value("${beverage.milk.price:0}") int price,
                        @Value("${beverage.milk.capacity:0}") int capacity) {
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
}
