package com.supmount.razi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supmount.razi.dao.LanguageDAO;
import com.supmount.razi.model.Language;

@RestController
@RequestMapping(value = "/languages")
public class LanguageController {

	@Autowired
	private LanguageDAO languageDAO;

	@RequestMapping(method = RequestMethod.GET)
	public List<Language> listLanguages() {
		return languageDAO.list();
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public Language getLanguage(@PathVariable String code) {
		return languageDAO.get(code);
	}

}
