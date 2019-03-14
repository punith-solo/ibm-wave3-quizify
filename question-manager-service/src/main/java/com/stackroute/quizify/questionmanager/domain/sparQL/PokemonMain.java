package com.stackroute.quizify.questionmanager.domain.sparQL;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonMain {
    private PokemonResults results;

    @Override
    public String toString() {
        return "PokemonMain [results=" + results + "]";
    }
}
