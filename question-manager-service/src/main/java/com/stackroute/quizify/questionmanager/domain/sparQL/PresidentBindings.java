package com.stackroute.quizify.questionmanager.domain.sparQL;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresidentBindings {

	private President president;
	private DeathCause cause;
	private Dob dob;
	private Dod dod;

	@Override
	public String toString() {
		return "PresidentBindings [president=" + president + ", cause=" + cause + ", dob=" + dob + ", dod=" + dod + "]";
	}

}
