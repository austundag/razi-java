package com.supmount.razi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supmount.razi.dao.LanguageDAO;
import com.supmount.razi.model.Language;

@RestController
@SpringBootApplication
public class RaziApplication {

	@Autowired
	private LanguageDAO languageDAO;

	@RequestMapping("/")
	String home() {
		List<Language> languages = languageDAO.list();
		return languages.get(0).toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(RaziApplication.class, args);
	}
}
