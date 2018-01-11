package com.redhat.dm7.demo.ruleunits;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.rule.DataSource;
import org.kie.api.runtime.rule.RuleUnitExecutor;

import com.redhat.dm7.demo.ruleunits.model.Person;
import com.redhat.dm7.demo.ruleunits.unit.AdultUnit;

public class RuleUnitActiveMainSolution {

	public static void main(String[] args) throws Exception {

		//Create the KieServices, and KieContainer.
		KieServices kieServices = KieServices.Factory.get();

		KieContainer kieContainer = kieServices.newKieClasspathContainer();
		
		/*
		 * Get the KieBase.
		 */
		//KieBase kieBase = ...
		KieBase kieBase = kieContainer.getKieBase();
		
		/*
		 * Create a Person DataSource
		 */
		//DataSource<Person> dataStream = ...
		DataSource<Person> dataStream = DataSource.create();
		
		/*
		 * Create a RuleUnitExecutor and bind it to the KieBase.
		 */
		//RuleUnitExecutor executor = ...
		RuleUnitExecutor executor = RuleUnitExecutor.create().bind(kieBase);
		
		/*
		 * Bind the variables "adultAge" and "persons" to the executor.
		 */
		//executor...
		//executor...
		executor.bindVariable("adultAge", 18);
		executor.bindVariable("persons", dataStream);
		
		//Execute on a separate thread, as this is a blocking call.
		System.out.println("Starting RuleUnit executor");
		/*
		 * Create and start new Thread and execute the executor's runUntilHalt method with the AdultUnit.class.
		 */
		//new Thread( () -> ...).start();
		new Thread( () -> executor.runUntilHalt(AdultUnit.class)).start();
		
		//Insert data using intervals.
		Thread.sleep(2000);
		System.out.println("Inserting data.");
		dataStream.insert(new Person("Mario", 42));
		Thread.sleep(2000);
		System.out.println("Inserting data.");
		dataStream.insert(new Person("Sofia", 4));
		Thread.sleep(2000);
		System.out.println("Inserting data.");
		dataStream.insert(new Person("Duncan", 38));
		Thread.sleep(2000);
		System.out.println("Inserting data.");
		dataStream.insert(new Person("Jason", 7));
		
		System.out.println("Stopping RuleUnit executor.");
		/*
		 * Stop the executor.
		 */
		//executor...
		executor.halt();
	}
	
}
