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
		//DMNRuntime dmnRuntime = ...
		
		
		/*
		 * Get the DMN Model from the runtime.
		 * The namespace of the model is: "http://www.trisotech.com/definitions/_bb8b9304-b29f-462e-9f88-03d0d868aec5"
		 * The name of the model is: "Insurance Pricing"
		 */
		//DMNModel dmnModel = ...
		
		
		/*
		 * Create a new DMN Context and set the input data "Age" and "had previous incidents".
		 */
		//DMNContext dmnContext = ...
		
		
		/*
		 * Retrieve the result by evaluating the DMN model
		 */
		//DMNResult dmnResult = ...
		
		
		/*
		 * Get the DMNDecisionResult "Insurance Total Price"
		 */
		//DMNDecisionResult decisionResult = ...
		
		
		//Assert the result
		
		
	}
	
}
