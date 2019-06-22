package com.supmount.razi;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import com.supmount.razi.dao.LanguageDAO;
import com.supmount.razi.model.Language;

@SpringBootTest(classes = RaziApplication.class)
@TestPropertySource(locations = "classpath:test.properties")
public class LanguageDAOTest {

	@Autowired
	private LanguageDAO languageDAO;

	@Test
	public void validateTest() {
		JdbcTemplate jdbcTemplate = languageDAO.getJdbcTemplate();

		jdbcTemplate.execute("delete from consent_type_text");
		jdbcTemplate.execute("delete from consent_type");
		jdbcTemplate.execute("delete from language");

		{
			languageDAO.create("en", "English", "English");
			Language language = languageDAO.get("en");
			MatcherAssert.assertThat(language.getName(), Matchers.is(Matchers.equalTo("English")));
			MatcherAssert.assertThat(language.getNativeName(), Matchers.is(Matchers.equalTo("English")));
		}

		{
			languageDAO.create("fr", "French", "Le français");
			Language language = languageDAO.get("fr");
			MatcherAssert.assertThat(language.getName(), Matchers.is(Matchers.equalTo("French")));
			MatcherAssert.assertThat(language.getNativeName(), Matchers.is(Matchers.equalTo("Le français")));
		}

		{
			List<Language> languages = languageDAO.list();
			MatcherAssert.assertThat(languages.size(), Matchers.is(Matchers.equalTo(2)));

			MatcherAssert.assertThat(languages.get(0).getName(), Matchers.is(Matchers.equalTo("English")));
			MatcherAssert.assertThat(languages.get(1).getName(), Matchers.is(Matchers.equalTo("French")));
		}
	}

}
