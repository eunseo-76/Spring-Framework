package com.kenny.section02.annotation.subsection02;

import com.kenny.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// 이 클래스를 bean으로 등록
@Service("pokemonServiceQualifier")
public class PokemonService {
    // 필드 주입
    // @Qualifier : 여러 개의 bean 객체 중 특정 bean 객체를 이름으로 지정하는 어노테이션
    // (@Primary와 같이 쓰인 경우 @Qualifier가 우선시된다.)
    @Autowired  // bean 타입만 보고 가져온다. 여러 bean 객체가 있다면 뭘 가져올지 알 수 없다.
    @Qualifier("pikachu")   // pikachu 라는 bean 이름을 주어 pickachu를 의존성 주입 한다.
    private Pokemon pokemon;

    // 생성자 주입
//    @Autowired
//    public PokemonService(Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
// pokemon을 의존하는 pokemonService 클래스