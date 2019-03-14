package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageMain {
    private LanguageResults results;

    @Override
    public String toString() {
        return "LanguageMain [results=" + results + "]";
    }
}
