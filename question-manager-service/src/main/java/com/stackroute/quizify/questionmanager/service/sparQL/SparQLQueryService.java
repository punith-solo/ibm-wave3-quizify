package com.stackroute.quizify.questionmanager.service.sparQL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.stackroute.quizify.questionmanager.domain.sparQL.LanguageMain;
import com.stackroute.quizify.questionmanager.domain.sparQL.Main;
import com.stackroute.quizify.questionmanager.domain.sparQL.PokemonMain;
import com.stackroute.quizify.questionmanager.domain.sparQL.PresidentMain;

import java.io.IOException;

public interface SparQLQueryService {
	
	public Main capitals(Main main) throws JsonParseException, JsonMappingException, IOException;

	public PresidentMain presidents(PresidentMain presidentMain) throws JsonParseException, JsonMappingException, IOException;

	public LanguageMain languages(LanguageMain languageMain) throws JsonParseException, JsonMappingException, IOException;

	public PokemonMain pokemons(PokemonMain pokemonMain) throws IOException;

}
