package com.redhat.dm7.demo.ruleunits.chained;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAgendaEventListener extends DefaultAgendaEventListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAgendaEventListener.class);

	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		super.afterMatchFired(event);
		LOGGER.debug("After match fired: " + event.getMatch().getRule().getName());
	}
}