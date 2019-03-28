package com.kanth.resttemplateserver.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.lang.Nullable;
/**
 * 
 * @author ramakanth.b
 *
 */

@Resource
public class BaseDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public <T> Optional<T> queryforOptional(String sql, @Nullable Object[] args, RowMapper<T> rowMapper) {

		try {
			List<T> results = this.jdbcTemplate.query(sql, args, new RowMapperResultSetExtractor<>(rowMapper, 1));
			return Optional.ofNullable(results).orElse(Collections.emptyList()).stream().findFirst();
		} catch (DataAccessException e) {
			return Optional.empty();
		}

	}

}
