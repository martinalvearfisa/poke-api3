package com.maa.poke.data.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class Pokemon {

    private int id;
    private String name;
    private int height;
    private int weight;
    private List<Descriptions> descriptions;
    private List<Types> types;
    private List<Stats> stats;
    private TypeInfo typeInfo ;

    @Builder
    @Getter
    public static class Descriptions{
        private String description;
        private Language language;
    }

    @Builder
    @Setter
    public static class Language{
        private String name;
        private String url;
    }

    @Builder
    @Getter
    public static class Types{
        private int slot;
        private Type type;
    }
    @Builder
    @Getter
    @Setter
    public static class Type{
        private String name;
        private String url;
    }
    @Builder
    @Getter
    @Setter
    public static class TypeInfo {
        private int id;
    }
    @Builder
    @Getter
    @Setter
    public static class Damage_relations{
        private List<Double_damage_from> double_damage_from;
    }
    @Builder
    @Getter
    @Setter
    public static class Double_damage_from{
        private String name;
        private String url;
    }

    @Builder
    @Getter
    public static class Stats{
        private int base_stat;
        private int effort;
        private Stat stat;
    }
    @Builder
    @Getter
    @Setter
    public static class Stat{
        private String name;
        private String url;
    }
}
