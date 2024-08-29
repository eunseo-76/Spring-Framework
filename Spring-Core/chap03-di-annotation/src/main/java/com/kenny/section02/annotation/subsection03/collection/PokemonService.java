package com.kenny.section02.annotation.subsection03.collection;

import com.kenny.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

// 이 클래스를 bean으로 등록
@Service("pokemonServiceCollection")
public class PokemonService {

    /* 컬렉션 타입으로 의존성 주입을 받게 되면 해당 타입에 등록된 bean이 모두 주입된다. */
//    private List<Pokemon> pokemons;
//
//    // 생성자 주입
//    @Autowired
//    public PokemonService(List<Pokemon> pokemons) { // 리스트 타입을 받아와 초기화
//        this.pokemons = pokemons;
//    }
//
//    public void pokemonAttack() {
//        pokemons.forEach(Pokemon::attack);  // 리스트에 있는 attack을 하나씩 호출
//    }

    private Map<String, Pokemon> pokemons;

    public PokemonService(Map<String, Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void pokemonAttack() {
        pokemons.forEach((k, v) -> {
            System.out.println(k + " " + v);    // key: bean의 이름 / value: 해당 객체
            v.attack();
        });
    }
}
// pokemon을 의존하는 pokemonService 클래스