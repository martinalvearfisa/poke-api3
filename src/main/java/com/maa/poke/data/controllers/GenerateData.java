package com.maa.poke.data.controllers;

import com.maa.poke.data.cliente.PokemonClientApi;
import com.maa.poke.data.model.Pokemon;
import com.maa.poke.data.model.Result;

import java.util.Optional;

public class GenerateData {

    private Pokemon pokemon;
    private PokemonClientApi pokemonClientApi;

    public GenerateData(Pokemon pokemon, PokemonClientApi pokemonClientApi){
        this.pokemon = pokemon;
        this.pokemonClientApi = pokemonClientApi;
    }

    public Optional<Result> getInformation(){
        if(pokemon != null){
            Result.ResultBuilder resultBuilder = Result.builder();
            resultBuilder.name(pokemon.getName());
            resultBuilder.height(pokemon.getHeight());
            resultBuilder.weight(pokemon.getWeight());
            //resultBuilder.description(pokemon.getDescriptions().stream().filter(p -> "ko".equals(p.getLanguage())).toString());
            resultBuilder.type(pokemon.getTypes());
            resultBuilder.stat(pokemon.getStats());

            System.out.println(resultBuilder);
            return Optional.of(resultBuilder.build());

        }
        return Optional.empty();
    }
}
