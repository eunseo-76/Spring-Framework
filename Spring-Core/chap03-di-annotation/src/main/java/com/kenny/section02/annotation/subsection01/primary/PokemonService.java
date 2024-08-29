package com.kenny.section02.annotation.subsection01.primary;

import com.kenny.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 이 클래스를 bean으로 등록
@Service("pokemonServicePrimary")
public class PokemonService {

    private Pokemon pokemon;

    // 생성자 주입
    @Autowired
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
// pokemon을 의존하는 pokemonService 클래스