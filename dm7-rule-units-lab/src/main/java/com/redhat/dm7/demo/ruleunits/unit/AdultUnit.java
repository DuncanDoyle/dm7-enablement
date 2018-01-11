package com.redhat.dm7.demo.ruleunits.unit;

import org.kie.api.runtime.rule.DataSource;
import org.kie.api.runtime.rule.RuleUnit;

import com.redhat.dm7.demo.ruleunits.model.Person;

public class AdultUnit implements RuleUnit {

	private int adultAge;
	
	private DataSource<Person> persons;
	
	
	public AdultUnit() {
	}
	
	public AdultUnit(DataSource<Person> persons, int adultAge) {
		this.persons = persons;
		this.adultAge = adultAge;
	}
	
	// A DataSource of Persons for this RuleUnit.
	public DataSource<Person> getPersons() {
		return persons;
	}
	
	// A global variable valid in this RuleUnit.
	public int getAdultAge() {
		return adultAge;
	}
	
	// --- lifecycle methods.	
	@Override
    public void onStart() {
        System.out.println(getName() + " started.");
    }

    @Override
    public void onEnd() {
        System.out.println(getName() + " ended.");
    }
	
	private String getName() {
		return "AdultUnit";
	}
}
