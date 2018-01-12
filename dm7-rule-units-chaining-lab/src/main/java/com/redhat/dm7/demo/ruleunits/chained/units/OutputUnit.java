package com.redhat.dm7.demo.ruleunits.chained.units;

import java.util.Set;

import org.kie.api.runtime.rule.DataSource;
import org.kie.api.runtime.rule.RuleUnit;

import com.redhat.dm7.demo.ruleunits.chained.model.Person;

public class OutputUnit implements RuleUnit {

	private Set<Person> filteredAdults;
	
	private DataSource<Person> persons;
	
	public OutputUnit() {
	}

	public Set<Person> getFilteredAdults() {
		return filteredAdults;
	}

	public void setFilteredAdults(Set<Person> filteredAdults) {
		this.filteredAdults = filteredAdults;
	}
	
	public DataSource<Person> getPersons() {
		return persons;
	}

	public void setPersons(DataSource<Person> persons) {
		this.persons = persons;
	}
	
}
