package com.supmount.razi;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.supmount.razi.dao.LanguageDAO;
import com.supmount.razi.model.Language;

@SpringBootTest(classes = RaziApplication.class)
public class LanguageDAOTest {

	@Autowired
	private LanguageDAO languageDAO;

	@Test
	public void validateTest() {
		Language language = languageDAO.get("en");

		MatcherAssert.assertThat(language.getName(), Matchers.is(Matchers.equalTo("English")));
	}

}
