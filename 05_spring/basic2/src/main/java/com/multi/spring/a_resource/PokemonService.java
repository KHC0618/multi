package com.multi.spring.a_resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {

	// 1. 필드 주입
//	@Resource(name = "charmander")
//	private Pokemon pokemon;
//	
//	public void pokemonAttack() {
//		// TODO Auto-generated method stub
//		
//		pokemon.attack();
//	}
	
	// 2. 생성자 주입 - 에러남
//	private Pokemon pokemon;
//	
//	@Resource(name = "charmander")
//	public PokemonService(Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
	
	// 3. 메소드 주입(setter 주입)
	private Pokemon pokemon;

	@Resource //(name = "charmander")
	@Qualifier("squirtle")
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		// TODO Auto-generated method stub
		
		pokemon.attack();
	}

}
