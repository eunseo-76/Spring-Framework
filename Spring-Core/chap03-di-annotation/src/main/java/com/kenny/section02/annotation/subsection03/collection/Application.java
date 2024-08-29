package com.kenny.section02.annotation.subsection03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // ioc 컨테이너 생성 - section02 하위의 클래스들을 컴포넌트 스캐닝 하겠다. common의 피카츄, 파이리, 꼬부기가 bean으로 등록된다.
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.kenny.section02");

        PokemonService pokemonService = applicationContext.getBean("pokemonServiceCollection", PokemonService.class);
        pokemonService.pokemonAttack();
        // pokemon 타입의 bean이 셋이므로 어떤 포켓몬인지 명시해주지 않으면 bean 생성 자체가 실패한다.
        // @Autowired는 타입 기준으로 bean을 찾는다. 그런데 pokemon 타입 bean이 셋이나 되므로 무엇을 찾을지 알 수 없다.
        // 이런 경우 @Primary 로 우선순위를 정해준다.
    }
}
