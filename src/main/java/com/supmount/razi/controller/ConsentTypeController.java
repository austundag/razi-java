package com.supmount.razi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supmount.razi.model.ConsentType;

@RestController
@RequestMapping(value = "/consent-types")
public class ConsentTypeController {

	@RequestMapping(method = RequestMethod.GET)
	public List<ConsentType> listConsentTypes() {
		return new ArrayList<ConsentType>();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ConsentType getConsentType() {
		return new ConsentType();
	}

}
