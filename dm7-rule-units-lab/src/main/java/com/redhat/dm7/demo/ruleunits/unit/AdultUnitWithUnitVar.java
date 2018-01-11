package com.redhat.dm7.demo.ruleunits.unit;

import org.kie.api.definition.rule.UnitVar;
import org.kie.api.runtime.rule.DataSource;
import org.kie.api.runtime.rule.RuleUnit;

import com.redhat.dm7.demo.ruleunits.model.Person;

public class AdultUnitWithUnitVar implements RuleUnit {

	@UnitVar("minAge")
	private int adultAge;
	
	@UnitVar("data")
	private DataSource<Person> persons;
	
	public AdultUnitWithUnitVar() {
	}
	
	public AdultUnitWithUnitVar(DataSource<Person> persons, int adultAge) {
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
