package com.redhat.dm7.demo.ruleunits;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.rule.DataSource;
import org.kie.api.runtime.rule.RuleUnit;
import org.kie.api.runtime.rule.RuleUnitExecutor;

import com.redhat.dm7.demo.ruleunits.model.Person;
import com.redhat.dm7.demo.ruleunits.unit.AdultUnit;
import com.redhat.dm7.demo.ruleunits.unit.AdultUnitWithUnitVar;

public class RuleUnitPassiveMainSolution {

	public static void main(String[] args) {
		
		//Create the KieServices, and KieContainer.
		KieServices kieServices = KieServices.Factory.get();
		
		KieContainer kieContainer = kieServices.newKieClasspathContainer();
		
		/*
		 * Get the KieBase.
		 */
		//KieBase kieBase = ...
		KieBase kieBase = kieContainer.getKieBase();
		
		//Run RuleUnit Explicitly
		runRuleUnitExplicit(kieBase);
		
		//Run RuleUnit Implicitly
		runRuleUnitImplicit(kieBase);
		
		//Run RuleUnit Implicitly with UnitVar
		runRuleUnitImplicitWithUnitVar(kieBase);
	}
	
	
	private static void runRuleUnitExplicit(KieBase kieBase) {
		System.out.println("Run RuleUnit Explicitly");
		/*
		 * Create the RuleUnitExecutor and bind it to the KieBase.
		 */
		//RuleUnitExecutor executor = ...
		RuleUnitExecutor executor = RuleUnitExecutor.create().bind(kieBase);
		
		/*
		 * Create a new Person DataSource that includes 4 persons with different ages. 2 adults and 2 non-adults.
		 */
		//DataSource<Person> persons = ... 
		DataSource<Person> persons = DataSource.create(new Person("Mario", 42), new Person("Sofia", 4),
														new Person("Duncan", 38), new Person("Sinead", 3));
		
		/*
		 * Create a new AdultUnit ruleUnit with the datasource and adult-age of 18.
		 */
		//RuleUnit adultUnit = ...
		RuleUnit adultUnit = new AdultUnit(persons, 18);
		
		/*
		 * Run the executor with the RuleUnit
		 */
		//executor...
		executor.run(adultUnit);
		
		System.out.println("\n");
	}
	
	private static void runRuleUnitImplicit(KieBase kieBase) {
		System.out.println("Run RuleUnit Implicitly");
		/*
		 * Create the RuleUnitExecutor and bind it to the KieBase.
		 */
		//RuleUnitExecutor executor = ...
		RuleUnitExecutor executor = RuleUnitExecutor.create().bind(kieBase);
		
		/*
		 * Bind the variables "adultAge" and "persons" (which is a DataSource).
		 */
		//executor...
		//executor...
		executor.bindVariable("adultAge", 18);
		executor.bindVariable("persons", DataSource.create(new Person("Mario", 42),
													new Person("Sofia", 4),
													new Person("Duncan", 38),
													new Person("Sinead", 3)));
		
		/*
		 * Implicitly run the AdultUnit class on the executor.
		 */
		//executor...
		executor.run(AdultUnit.class);
		System.out.println("\n");
	}
	
	private static void runRuleUnitImplicitWithUnitVar(KieBase kieBase) {
		System.out.println("Run RuleUnit Implicitly with UnitVar");
		/*
		 * Create the RuleUnitExecutor and bind it to the KieBase.
		 */
		//RuleUnitExecutor executor = ...
		RuleUnitExecutor executor = RuleUnitExecutor.create().bind(kieBase);
		/*
		 * Bind the variables "minAge" and "data" (which is a DataSource).
		 */
		//executor...
		//executor...
		executor.bindVariable("minAge", 18);
		executor.bindVariable("data", DataSource.create(new Person("Mario", 42),
										new Person("Sofia", 4),
										new Person("Duncan", 38),
										new Person("Sinead", 3)));
		
		/*
		 * Run the AdultUnitWithUnitVar RuleUnit class.
		 */
		//executor...
		executor.run(AdultUnitWithUnitVar.class);
		
		
		System.out.println("\n");
	}
	
}
