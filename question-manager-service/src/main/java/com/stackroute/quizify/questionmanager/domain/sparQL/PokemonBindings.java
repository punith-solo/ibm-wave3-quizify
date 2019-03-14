package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonBindings {

    private Pokemon pokemon;
    private PokemonLabel pokemonLabel;
    private PokedexNumber pokedexNumber;

    @Override
    public String toString() {
        return "PresidentBindings [pokemon=" + pokemon + ", pokemonLabel=" + pokemonLabel + ", pokedexNumber=" + pokedexNumber + "]";
    }

}
