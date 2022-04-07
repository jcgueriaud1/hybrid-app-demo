package com.example.application;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.Route;

import javax.servlet.http.HttpServletResponse;

@Route("error403")
public class AccessDenied403View extends Div implements HasErrorParameter<AccessDeniedException> {

	public AccessDenied403View() {
		add(new Span("AccessDenied403View"));
	}

	@Override
	public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<AccessDeniedException> parameter) {

		return HttpServletResponse.SC_FORBIDDEN;
	}
}
