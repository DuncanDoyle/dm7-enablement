package com.redhat.dm7.demo.ruleunits.chained;

import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.DataSource;
import org.kie.api.runtime.rule.RuleUnitExecutor;

import com.redhat.dm7.demo.ruleunits.chained.model.Person;
import com.redhat.dm7.demo.ruleunits.chained.units.OrchestrationUnit;

public class Main {

	public static void main(String[] args) {

		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.newKieClasspathContainer();

		Person mario = new Person("Mario", 42);
		Person sofia = new Person("Sofia", 4);
		
		Person duncan = new Person("Duncan", 38);
		Person jason = new Person("Jason", 7);
		

		KieBase kieBase = kieContainer.getKieBase("units");

		RuleUnitExecutor executor = RuleUnitExecutor.create().bind(kieBase);
		
		executor.getKieSession().addEventListener(new LoggingAgendaEventListener());

		// Bind the collection from which we will retrieve the offeres.
		Set<Person> filteredAdults = new HashSet<Person>();
		
		executor.bindVariable("filteredAdults", filteredAdults);

		// Create DataSources.
		DataSource<Person> persons = DataSource.create(mario, sofia, duncan, jason);

		// Interesting, if we bind a Person (Object) to a variable that's defined in the Unit as a DataSource, the engine does not give rais
		// an error.
		executor.bindVariable("persons", persons);
		
		executor.run(OrchestrationUnit.class);

		// Dispose the executor
		executor.dispose();
		
		System.out.println("Filtered adults: ");
		for (Person nextFilteredAdult: filteredAdults) {
			System.out.println("- " + nextFilteredAdult.getName());
		}
		
	}

}