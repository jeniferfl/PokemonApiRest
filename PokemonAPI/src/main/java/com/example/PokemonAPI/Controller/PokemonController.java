package com.example.PokemonAPI.Controller;

import com.example.PokemonAPI.Model.Pokemon;
import com.example.PokemonAPI.Service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/pokemones")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;


    @GetMapping
    public List<Pokemon> listar(){
        return pokemonService.obtenerTodos();
    }
    @PostMapping
    public Pokemon crear(@RequestBody Pokemon pokemon){
        return pokemonService.crear(pokemon);
    }
    @GetMapping("/{id}")
    public Pokemon listarPorId(@PathVariable Long id){
        return pokemonService.obtenerPorId(id);
    }




}
