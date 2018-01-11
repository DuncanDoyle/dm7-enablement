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

public class RuleUnitPassiveMain {

	public static void main(String[] args) {
		
		//Create the KieServices, and KieContainer.
		KieServices kieServices = KieServices.Factory.get();
		
		KieContainer kieContainer = kieServices.newKieClasspathContainer();
		
		/*
		 * Get the KieBase.
		 */
		//KieBase kieBase = ...
		
		
		//Run RuleUnit Explicitly
		//runRuleUnitExplicit(kieBase);
		
		//Run RuleUnit Implicitly
		//runRuleUnitImplicit(kieBase);
		
		//Run RuleUnit Implicitly with UnitVar
		//runRuleUnitImplicitWithUnitVar(kieBase);
	}
	
	
	private static void runRuleUnitExplicit(KieBase kieBase) {
		System.out.println("Run RuleUnit Explicitly");
		/*
		 * Create the RuleUnitExecutor and bind it to the KieBase.
		 */
		//RuleUnitExecutor executor = ...
		
		
		/*
		 * Create a new Person DataSource that includes 4 persons with different ages. 2 adults and 2 non-adults.
		 */
		//DataSource<Person> persons = ... 
		
		
		/*
		 * Create a new AdultUnit ruleUnit with the datasource and adult-age of 18.
		 */
		//RuleUnit adultUnit = ...
		
		
		/*
		 * Run the executor with the RuleUnit
		 */
		//executor...
	
		
		System.out.println("\n");
	}
	
	private static void runRuleUnitImplicit(KieBase kieBase) {
		System.out.println("Run RuleUnit Implicitly");
		/*
		 * Create the RuleUnitExecutor and bind it to the KieBase.
		 */
		//RuleUnitExecutor executor = ...
		
		
		/*
		 * Bind the variables "adultAge" and "persons" (which is a DataSource).
		 */
		//executor...
		//executor...
		
		
		/*
		 * Implicitly run the AdultUnit class on the executor.
		 */
		//executor...
		
		System.out.println("\n");
	}
	
	private static void runRuleUnitImplicitWithUnitVar(KieBase kieBase) {
		System.out.println("Run RuleUnit Implicitly with UnitVar");
		/*
		 * Create the RuleUnitExecutor and bind it to the KieBase.
		 */
		//RuleUnitExecutor executor = ...
		
		
		/*
		 * Bind the variables "minAge" and "data" (which is a DataSource).
		 */
		//executor...
		//executor...
				
		/*
		 * Run the AdultUnitWithUnitVar RuleUnit class.
		 */
		//executor...
		
		
		System.out.println("\n");
	}
	
}
