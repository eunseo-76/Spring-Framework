package com.kenny.section02.annotation.subsection02.qualifier;

import com.kenny.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// 이 클래스를 bean으로 등록
@Service("pokemonServiceQualifier")
public class PokemonService {

    /* 1. 필드 주입의 경우 */
    // @Qualifier : 여러 개의 bean 객체 중 특정 bean 객체를 이름으로 지정하는 어노테이션
    // (@Primary와 같이 쓰인 경우 @Qualifier가 우선시된다.)
//    @Autowired  // bean 타입만 보고 가져온다. 여러 bean 객체가 있다면 뭘 가져올지 알 수 없다.
//    @Qualifier("pikachu")   // pikachu 라는 bean 이름을 주어 pickachu를 의존성 주입 한다.
    private Pokemon pokemon;

    /* 2. 생성자 주입의 경우 */
    // @Qualifer 어노테이션을 파라미터 앞에 작성한다.
    // 필드 주입과 동일하게 메소드 위에 @Qualifer에 작성하면 여러 개 파라미터 중 어떤 파라미터인지 알 수 없기 때문
    // (@Qualifier("pikachu") Pokemon pokemon, @Qualifier("xxxx") Pokemon pokemon) 이런 식으로 쓰기 위함
    @Autowired
    public PokemonService(@Qualifier("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
// pokemon을 의존하는 pokemonService 클래스