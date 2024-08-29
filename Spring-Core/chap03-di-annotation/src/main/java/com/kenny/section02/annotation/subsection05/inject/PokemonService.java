package com.kenny.section02.annotation.subsection05.inject;

import com.kenny.section02.common.Pokemon;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Service;

// 이 클래스를 bean으로 등록
@Service("pokemonServiceInject")
public class PokemonService {

    // @Inject : 자바 진영에서 제공하는 DI 어노테이션
    // @Autowired 스프링 어노테이션과 유사하게 타입을 통해 의존성 주입을 하며,
    // @Named를 통해 bean 이름을 명시할 수 있다.
    // 필드, 생성자, 세터 주입 방식이 가능하다.

//    @Inject
//    @Named("pikachu")   // @Autowired 에서 @Qualifer로 구체화해주는 것과 동일
    private Pokemon pokemon;

    // 다른 주입 방법 추가 (github 참고)

    public void pokemonAttack() {
        pokemon.attack();
    }
}
// pokemon을 의존하는 pokemonService 클래스
