package com.stackroute.quizify.questionmanager.service.sparQL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hp.hpl.jena.query.*;
import com.stackroute.quizify.questionmanager.domain.sparQL.LanguageMain;
import com.stackroute.quizify.questionmanager.domain.sparQL.Main;
import com.stackroute.quizify.questionmanager.domain.sparQL.PokemonMain;
import com.stackroute.quizify.questionmanager.domain.sparQL.PresidentMain;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class SparQLQueryServiceImpl implements SparQLQueryService {

	@Override
	public Main capitals(Main main) throws JsonParseException, JsonMappingException, IOException {

/*
		PREFIX  dbo:  <http://dbpedia.org/ontology/>
		PREFIX  dct:  <http://purl.org/dc/terms/>
		SELECT DISTINCT  *
		WHERE
		{ ?country  dct:subject  <http://dbpedia.org/resource/Category:Countries_in_Europe> ;
			dbo:capital  ?capital
		}
*/

		String sparqlQuery = "PREFIX  dbo:  <http://dbpedia.org/ontology/>\n"
				+ "PREFIX  dct:  <http://purl.org/dc/terms/>\n" + "\n" + "SELECT DISTINCT  *\n" + "WHERE\n"
				+ "  { ?country  dct:subject  <http://dbpedia.org/resource/Category:Countries_in_Asia> ;\n"
				+ "              dbo:capital  ?capital\n" + "  }";

		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
		ResultSet result = queryExecution.execSelect();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, result);
		String json = new String(outputStream.toByteArray()).replace("http://dbpedia.org/resource/", "")
				.replace(" \"type\": \"uri\" ,", "");
		ObjectMapper objectMapper = new ObjectMapper();
		main = objectMapper.readValue(json, Main.class);
		return main;
	}

	@Override
	public PresidentMain presidents(PresidentMain presidentMain) throws JsonParseException, JsonMappingException, IOException {
		String sparqlQuery = "PREFIX wikibase: <http://wikiba.se/ontology#>\n"
				+ "PREFIX wd: <http://www.wikidata.org/entity/>\n"
				+ "PREFIX wdt: <http://www.wikidata.org/prop/direct/>\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + "\n"
				+ "SELECT ?president ?cause ?dob ?dod WHERE {\n" + "   ?pid wdt:P39 wd:Q11696 .\n"
				+ "   ?pid wdt:P509 ?cid .\n" + "   ?pid wdt:P569 ?dob .\n" + "   ?pid wdt:P570 ?dod .\n" + "\n"
				+ "   OPTIONAL {\n" + "       ?pid rdfs:label ?president filter (lang(?president) = \"en\") .\n"
				+ "   }\n" + "   OPTIONAL {\n" + "       ?cid rdfs:label ?cause filter (lang(?cause) = \"en\") .\n"
				+ "   }\n" + "}";

		Query query = QueryFactory.create(sparqlQuery);

		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query);

		ResultSet result = queryExecution.execSelect();


		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, result);
		String json = new String(outputStream.toByteArray())
				.replace("\"type\": \"literal\" , \"xml:lang\": \"en\" , ", "")
				.replace("\"datatype\": \"http://www.w3.org/2001/XMLSchema#dateTime\" , \"type\": \"typed-literal\" , ",
						"")
				.replace("\n" + "  \"head\": {\n" + "    \"vars\": [ \"president\" , \"cause\" , \"dob\" , \"dod\" ]\n"
						+ "  } ,", "")
				.replace("T00:00:00Z", "");

		ObjectMapper objectMapper = new ObjectMapper();
		presidentMain = objectMapper.readValue(json, PresidentMain.class);
		return presidentMain;
	}

	@Override
	public LanguageMain languages(LanguageMain languageMain) throws JsonParseException, JsonMappingException, IOException {

		String sparqlQuery = "PREFIX wikibase: <http://wikiba.se/ontology#>\n"
				+ "PREFIX wd: <http://www.wikidata.org/entity/>\n"
				+ "PREFIX wdt: <http://www.wikidata.org/prop/direct/>\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + "\n"
				+ "SELECT DISTINCT ?itemLabel_en ?official_language WHERE {\n" +
				"  ?item wdt:P30 wd:Q46 ;\n" +
				"        wdt:P37 ?officiallanguage ;\n" +
				"        wdt:P31 wd:Q6256 .\n" +
				"  ?officiallanguage wdt:P424 ?langcode .\n" +
				"  ?item rdfs:label ?itemLabel_ol . FILTER(lang(?itemLabel_ol)=?langcode)\n" +
				"  ?item rdfs:label ?itemLabel_en . FILTER(lang(?itemLabel_en)='en')\n" +
				"  ?officiallanguage rdfs:label ?official_language . FILTER(lang(?official_language)='en')\n" +
				"}\n" +
				"";

		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query);
		ResultSet result = queryExecution.execSelect();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, result);
		String json = new String(outputStream.toByteArray())
				.replace(" \"type\": \"literal\" , \"xml:lang\": \"en\" ,", "")
				.replace("\"head\": {\n" +
						"    \"vars\": [ \"itemLabel_en\" , \"official_language\" ]\n" +
						"  } ,\n" +
						"  ", "");
		System.out.println(json);

		ObjectMapper objectMapper = new ObjectMapper();
		languageMain = objectMapper.readValue(json, LanguageMain.class);
		System.out.println(languageMain);

		return languageMain;
	}


	public PokemonMain pokemons(PokemonMain pokemonMain) throws IOException {
//	PREFIX wikibase: <http://wikiba.se/ontology#>
//PREFIX wd: <http://www.wikidata.org/entity/>
//PREFIX wdt: <http://www.wikidata.org/prop/direct/>
//PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
//PREFIX p: <http://www.wikidata.org/prop/>
//PREFIX ps: <http://www.wikidata.org/prop/statement/>
//PREFIX pq: <http://www.wikidata.org/prop/qualifier/>
//PREFIX bd: <http://www.bigdata.com/rdf#>
//SELECT DISTINCT ?pokemon ?pokemonLabel ?pokedexNumber
//WHERE
//{
//?pokemon wdt:P31/wdt:P279* wd:Q3966183 .
//    ?pokemon p:P1685 ?statement.
//    ?statement ps:P1685 ?pokedexNumber;
//              pq:P972 wd:Q20005020.
//    FILTER ( !isBLANK(?pokedexNumber) ) .
//    SERVICE wikibase:label { bd:serviceParam wikibase:language "[AUTO_LANGUAGE],en" }
//}
//ORDER BY (?pokedexNumber)
		String sparqlQuery ="PREFIX wikibase: <http://wikiba.se/ontology#>\n" +
				"PREFIX wd: <http://www.wikidata.org/entity/>\n" +
				"PREFIX wdt: <http://www.wikidata.org/prop/direct/>\n" +
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
				"PREFIX p: <http://www.wikidata.org/prop/>\n" +
				"PREFIX ps: <http://www.wikidata.org/prop/statement/>\n" +
				"PREFIX pq: <http://www.wikidata.org/prop/qualifier/>\n" +
				"PREFIX bd: <http://www.bigdata.com/rdf#>\n" +
				"SELECT DISTINCT ?pokemon ?pokemonLabel ?pokedexNumber\n" +
				"WHERE{\n" +
				"    ?pokemon wdt:P31/wdt:P279* wd:Q3966183 .\n" +
				"    ?pokemon p:P1685 ?statement.\n" +
				"    ?statement ps:P1685 ?pokedexNumber;\n" +
				"              pq:P972 wd:Q20005020.\n" +
				"    FILTER ( !isBLANK(?pokedexNumber) ) .\n" +
				"    SERVICE wikibase:label { bd:serviceParam wikibase:language \"[AUTO_LANGUAGE],en\" }\n" +
				"}\n" +
				"ORDER BY (?pokedexNumber)";
		Query query = QueryFactory.create(sparqlQuery);

		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query);

		ResultSet result = queryExecution.execSelect();


		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, result);
		String json = new String(outputStream.toByteArray())
				.replace(" \"type\": \"literal\" , \"xml:lang\": \"en\" ,", "")
				.replace("\"head\": {\n" +
						"    \"vars\": [ \"itemLabel_en\" , \"official_language\" ]\n" +
						"  } ,\n" +
						"  ", "");

		ObjectMapper objectMapper = new ObjectMapper();
		pokemonMain= objectMapper.readValue(json, PokemonMain.class);
		return pokemonMain;
	}
}
