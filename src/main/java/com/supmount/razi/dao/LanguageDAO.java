package com.supmount.razi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.supmount.razi.model.Language;

@Repository
public class LanguageDAO {

	private static class LanguageMapper implements RowMapper<Language> {
		@Override
		public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
			Language language = new Language();

			language.setCode(rs.getString("code"));
			language.setName(rs.getString("name"));
			language.setNativeName(rs.getString("native_name"));

			return language;
		}
	}

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void create(String code, String name, String nativeName) {
		String SQL = "insert into language (code, name, native_name) values (?, ?, ?)";
		jdbcTemplate.update(SQL, code, name, nativeName);
		System.out.println("Created Record Name = " + name + " Native name = " + nativeName);
		return;
	}

	public Language get(String code) {
		String SQL = "select * from language where code = ?";
		Language language = jdbcTemplate.queryForObject(SQL, new Object[] { code }, new LanguageMapper());
		return language;
	}

	public List<Language> list() {
		String SQL = "select * from language";
		List<Language> languages = jdbcTemplate.query(SQL, new LanguageMapper());
		return languages;
	}

	public void delete(String code) {
		String SQL = "delete from language where code = ?";
		jdbcTemplate.update(SQL, code);
		System.out.println("Deleted Record with code = " + code);
		return;
	}

	public void update(String code, String name, String nativeName) {
		String SQL = "update language set name = ?, native_name = ? where code = ?";
		jdbcTemplate.update(SQL, code, name, nativeName);
		System.out.println("Updated Record with code = " + code);
		return;
	}

}
