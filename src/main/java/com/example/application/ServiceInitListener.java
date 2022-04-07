package com.example.application;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceInitListener implements VaadinServiceInitListener {

	private final ViewAccessControl cmsViewAccessControl = new ViewAccessControl();

	private static final Log log = LogFactory.getLog(ServiceInitListener.class);

	@Override
	public void serviceInit(ServiceInitEvent event) {
		log.info("Service init listener called");
		event.getSource().addUIInitListener(uiInitEvent -> uiInitEvent.getUI().addBeforeEnterListener(cmsViewAccessControl));
	}

}
