package com.redhat.dm7.oopath;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.redhat.dm7.oopath.model.Person;

public class Main {
	
	
	public static void main(String[] args) {
		
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.newKieClasspathContainer();
		
		KieSession kieSession = kieContainer.newKieSession();
		
		Person james = new Person("James", 71);
		Person duncan = new Person("Duncan", 38);
		Person alan = new Person("Alan", 36);
		Person jason = new Person("Jason", 7);
		Person sinead = new Person("Sinead", 3);
		Person jack = new Person("Jack", 4);
		Person amy = new Person("Amy", 2);
		
		james.addChild(duncan);
		james.addChild(alan);
		duncan.addChild(jason);
		duncan.addChild(sinead);
		alan.addChild(jack);
		alan.addChild(amy);
		
		kieSession.insert(james);
		kieSession.insert(duncan);
		kieSession.insert(alan);
		kieSession.insert(jason);
		kieSession.insert(sinead);
		kieSession.insert(jack);
		kieSession.insert(amy);
		
		kieSession.fireAllRules();
		
		kieSession.dispose();
	}

}
