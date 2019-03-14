package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonLabel {
    private String value;

    @Override
    public String toString() {
        return "Dod [value=" + value + "]";
    }
}
