package com.kenny.section02.annotation.subsection04.resource;

import com.kenny.section02.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

// 이 클래스를 bean으로 등록
@Service("pokemonServiceResource")
public class PokemonService {

    // @Resource : 자바 진영에서 제공하는 DI 어노테이션
    // @Autowired 와 달리 name 속성 값으로 의존성 주입을 할 수 있고, 필드 주입, 세터 주입 방식을 사용한다.
    // @Autowired는 타입을 기준으로 가져온다면, @Resource는 이름을 기준으로 가져온다.

    // 만약 List<Pokemon> 타입을 필드로 선언한다면 @Resource 라고만 어노테이션을 작성하면 된다.
    // -> 기본적으로는 name 속성으로 주입하지만, name 속성이 없을 경우 타입을 통해 의존성을 주입한다.

    //    @Resource(name = "pikachu")   // 필드 주입
    private Pokemon pokemon;

    @Resource(name = "pikachu") // 세터 주입
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
// pokemon을 의존하는 pokemonService 클래스
