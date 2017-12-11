package com.redhat.dm7.dmn;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNDecisionResult;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;

public class InsurancePricingDMNTest {

	@Test
	public void testInsurancePricingDMN() {
		KieServices kieServices = KieServices.Factory.get();

		KieContainer kieContainer = kieServices.newKieClasspathContainer();

		// DMN Runtime is part of a session.
		KieSession kieSession = kieContainer.newKieSession();

		/*
		 * Fetch the DMN Runtime. This method is generic on KieSession in order to support multiple runtime extensions like DMN and Bayes.
		 */
		DMNRuntime dmnRuntime = kieSession.getKieRuntime(DMNRuntime.class);
		
		String dmnModelNamespace = "http://www.trisotech.com/definitions/_bb8b9304-b29f-462e-9f88-03d0d868aec5";
		String dmnModelName = "Insurance Pricing";
		
		DMNModel dmnModel = dmnRuntime.getModel(dmnModelNamespace, dmnModelName);
		
		DMNContext dmnContext = dmnRuntime.newContext();
		dmnContext.set("Age", 23);
		dmnContext.set("had previous incidents", false);
		
		DMNResult dmnResult = dmnRuntime.evaluateAll(dmnModel, dmnContext);
		
		//  dmnResult.getDecisionResults()
		List<DMNDecisionResult> decisionResults = dmnResult.getDecisionResults();
		for (DMNDecisionResult nextResult: decisionResults) {
			System.out.println("Result name: '" + nextResult.getDecisionName() + "', value: '" + nextResult.getResult() + "'.");
		}
		
		DMNDecisionResult decisionResult = dmnResult.getDecisionResultByName("Insurance Total Price");
		//Assert that we have a result with the given name.
		assertThat(decisionResult, notNullValue());
		//Assert that the result has the correct value.
		assertThat(decisionResult.getResult(), is(BigDecimal.valueOf(2000)));
		
	}
	
}
