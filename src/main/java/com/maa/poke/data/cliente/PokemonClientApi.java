package com.maa.poke.data.cliente;

import com.maa.poke.data.model.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "pokemonApi", url = "https://pokeapi.co/api/v2")

public interface PokemonClientApi {
    @GetMapping("/pokemon/{pokemon}")
    Pokemon getDataPokemon(@PathVariable String pokemon);

    @GetMapping("/type/{pokemon}")
    Pokemon.TypeInfo getWeaknessesPokemon(@PathVariable String pokemon);



}
