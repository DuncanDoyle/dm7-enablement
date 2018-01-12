package com.redhat.dm7.demo.ruleunits.chained.model;

//Immutable
public class Adult {

	private final Person person;
	
	public Adult(final Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
	
}
