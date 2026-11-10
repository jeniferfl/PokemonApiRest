package com.example.PokemonAPI.Service;

import com.example.PokemonAPI.Model.Pokemon;
import com.example.PokemonAPI.exception.ResourceNotFoundException;
import com.example.PokemonAPI.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    // Obtener todos los Pokémon
    public List<Pokemon> obtenerTodos() {
        return pokemonRepository.findAll();
    }

    // Obtener Pokémon por ID
    public Pokemon obtenerPorId(Long id) {
        return pokemonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontró el Pokémon con ID: " + id
                ));
    }

    // Crear Pokémon
    public Pokemon crear(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    // Actualizar completamente un Pokémon (PUT)
    public Pokemon actualizarCompleto(Long id, Pokemon pokemonActualizado) {
        return pokemonRepository.findById(id).map(pokemon -> {

            pokemon.setNombre(pokemonActualizado.getNombre());
            pokemon.setTipo(pokemonActualizado.getTipo());
            pokemon.setNivel(pokemonActualizado.getNivel());
            pokemon.setAtaque(pokemonActualizado.getAtaque());
            pokemon.setDefensa(pokemonActualizado.getDefensa());
            pokemon.setDescripcion(pokemonActualizado.getDescripcion());
            pokemon.setImagenUrl(pokemonActualizado.getImagenUrl());

            return pokemonRepository.save(pokemon);

        }).orElseThrow(() -> new ResourceNotFoundException(
                "No se encontró el Pokémon con ID: " + id
        ));
    }

    // Actualizar parcialmente un Pokémon (PATCH)
    public Pokemon actualizarParcial(Long id, Pokemon pokemonParcial) {
        return pokemonRepository.findById(id).map(pokemon -> {

            if (pokemonParcial.getNombre() != null)
                pokemon.setNombre(pokemonParcial.getNombre());

            if (pokemonParcial.getTipo() != null)
                pokemon.setTipo(pokemonParcial.getTipo());

            if (pokemonParcial.getNivel() != null)
                pokemon.setNivel(pokemonParcial.getNivel());

            if (pokemonParcial.getAtaque() != null)
                pokemon.setAtaque(pokemonParcial.getAtaque());

            if (pokemonParcial.getDefensa() != null)
                pokemon.setDefensa(pokemonParcial.getDefensa());

            if (pokemonParcial.getDescripcion() != null)
                pokemon.setDescripcion(pokemonParcial.getDescripcion());

            if (pokemonParcial.getImagenUrl() != null)
                pokemon.setImagenUrl(pokemonParcial.getImagenUrl());

            return pokemonRepository.save(pokemon);

        }).orElseThrow(() -> new ResourceNotFoundException(
                "No se encontró el Pokémon con ID: " + id
        ));
    }
    // Eliminar Pokémon por ID
    public void eliminarPokemon(Long id) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontró el Pokémon con ID: " + id
                ));

        pokemonRepository.delete(pokemon);
    }
}