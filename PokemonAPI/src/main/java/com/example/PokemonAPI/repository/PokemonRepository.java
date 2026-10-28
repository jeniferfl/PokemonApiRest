package com.example.PokemonAPI.repository;

import com.example.PokemonAPI.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

}
