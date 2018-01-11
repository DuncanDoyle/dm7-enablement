package com.redhat.dm7.dmn;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNDecisionResult;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;

public class InsurancePricingDMNTestAnswer {

	@Test
	public void testInsurancePricingDMN() {
		KieServices kieServices = KieServices.Factory.get();

		KieContainer kieContainer = kieServices.newKieClasspathContainer();

		// DMN Runtime is part of a session.
		KieSession kieSession = kieContainer.newKieSession();

		/*
		 * Fetch the DMN Runtime. This method is generic on KieSession in order to support multiple runtime extensions like DMN and Bayes.
		 */
		//DMNRuntime dmnRuntime = ...
		DMNRuntime dmnRuntime = kieSession.getKieRuntime(DMNRuntime.class);
		
		/*
		 * Get the DMN Model from the runtime
		 */
		//DMNModel dmnModel = ...
		String dmnModelNamespace = "http://www.trisotech.com/definitions/_bb8b9304-b29f-462e-9f88-03d0d868aec5";
		String dmnModelName = "Insurance Pricing";
		
		DMNModel dmnModel = dmnRuntime.getModel(dmnModelNamespace, dmnModelName);
		
		/*
		 * Create a new DMN Context and set the input data "Age" and "had previous incidents".
		 */
		//DMNContext dmnContext = ...
		
		DMNContext dmnContext = dmnRuntime.newContext();
		dmnContext.set("Age", 23);
		dmnContext.set("had previous incidents", false);
		
		/*
		 * Retrieve the result by evaluating the DMN model
		 */
		//DMNResult
		DMNResult dmnResult = dmnRuntime.evaluateAll(dmnModel, dmnContext);
		
		
		
		/*
		 * Get the DMNDecisionResult "Insurance Total Price"
		 */
		//DMNDecisionResult decisionResult = ...
		DMNDecisionResult decisionResult = dmnResult.getDecisionResultByName("Insurance Total Price");
		
		
		//Assert the result
		assertThat(decisionResult, notNullValue());
		//Assert that the result has the correct value.
		assertThat(decisionResult.getResult(), is(BigDecimal.valueOf(2000)));
		
	}
	
}
