package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageResults {
	
	private List<LanguageBindings> bindings;


	@Override
	public String toString() {
		return "LanguageResults [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}
