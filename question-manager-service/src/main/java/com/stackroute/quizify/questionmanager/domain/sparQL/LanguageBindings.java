package com.stackroute.quizify.questionmanager.domain.sparQL;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageBindings {

	private LangCountry itemLabel_en;
	private Language official_language;


	@Override
	public String toString() {
		return "LanguageBindings [itemLabel_en=" + itemLabel_en + ", official_language=" + official_language + "]";
	}

}
