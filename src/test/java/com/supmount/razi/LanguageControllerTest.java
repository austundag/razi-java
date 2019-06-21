package com.supmount.razi;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.supmount.razi.model.Language;

@SpringBootTest(classes = RaziApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class LanguageControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void listLanguages() {
		ParameterizedTypeReference<List<Language>> typeReference = new ParameterizedTypeReference<List<Language>>() {
		};
		ResponseEntity<List<Language>> entity = restTemplate.exchange("/languages", HttpMethod.GET, null,
				typeReference);
		List<Language> languages = entity.getBody();
		MatcherAssert.assertThat(languages.size(), Matchers.is(Matchers.equalTo(5)));
	}
}
