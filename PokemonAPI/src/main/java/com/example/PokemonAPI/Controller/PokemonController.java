package com.example.PokemonAPI.Controller;

import com.example.PokemonAPI.Model.Pokemon;
import com.example.PokemonAPI.Service.PokemonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> listar() {
        return pokemonService.obtenerTodos();
    }

    @PostMapping
    public Pokemon crear(@Valid @RequestBody Pokemon pokemon) {
        return pokemonService.crear(pokemon);
    }

    @GetMapping("/{id}")
    public Pokemon listarPorId(@PathVariable Long id) {
        return pokemonService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Pokemon actualizar(@PathVariable Long id, @Valid @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarCompleto(id, pokemon);
    }

    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(@PathVariable Long id, @Valid @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarParcial(id, pokemon);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pokemonService.eliminarPokemon(id);
    }

}