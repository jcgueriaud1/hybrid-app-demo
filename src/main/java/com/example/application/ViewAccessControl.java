package com.example.application;

import com.example.application.views.helloworld.HelloWorldView;
import com.vaadin.flow.component.internal.JavaScriptBootstrapUI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.router.NotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ViewAccessControl implements BeforeEnterListener {

	private static final Log log = LogFactory.getLog(ViewAccessControl.class);

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		Class<?> navigationTarget = event.getNavigationTarget();

		log.info("beforeEnter 1 ");
		if (navigationTarget != null) {
			log.info("beforeEnter 2 " + navigationTarget);
		} else {
			//We should never get here as long as we have something mapped to "".
			// go to AccessDenied page
			log.warn("navigationTarget was null.");
			event.rerouteToError(NotFoundException.class);
		}

	}

}
