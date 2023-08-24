package com.maa.poke.data.model;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Result {
    private String name;
    private int height;
    private int weight;
    private String description;
    private List<Pokemon.Types> type;
    private List<Pokemon.Damage_relations> weakness;
    private List<Pokemon.Stats> stat;

    public static class ResultBuilder{
        @Override
        public String toString() {
            String tipos = "";
            String basePoints = "";
            for (Pokemon.Types tipo : type) {
                tipos = tipos.concat(tipo.getType().getName() + " ");
            }
            for (Pokemon.Stats stat : stat){
                basePoints = basePoints.concat("\t" + stat.getStat().getName() + " -> ");
                int valor = stat.getBase_stat()/10;
                for(int i = 0;i<valor;i++){
                    basePoints = basePoints.concat("*");
                }
                basePoints = basePoints.concat("\n");
            }
            return "Pokedex\n" +
                    "---------------------------------------------------------"+
                    "\nNombre: '" + name + '\'' +
                    "\nHeight: " + height + "m"+
                    "\nWeight: " + weight + "kg"+
                    "\nDescription: "+ description +
                    "\nType: "+tipos+
                    "\nWeakness: "+weakness+
                    "\nBase Points: \n" + basePoints;
        }
    }


}
