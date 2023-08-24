package com.maa.poke.data;

import com.maa.poke.data.cliente.PokemonClientApi;
import com.maa.poke.data.controllers.GenerateData;
import com.maa.poke.data.model.Pokemon;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.httpclient.HttpClientConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class, HttpClientConfiguration.class})

public class PokemonApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokemonApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(PokemonClientApi pokemonClientApi){
        return args -> {
            Pokemon pokemon = pokemonClientApi.getDataPokemon("blaziken");
            GenerateData data = new GenerateData(pokemon, pokemonClientApi);
            data.getInformation();

        };
    }

}
