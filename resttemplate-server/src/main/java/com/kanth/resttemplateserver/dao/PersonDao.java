package com.kanth.resttemplateserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kanth.resttemplateserver.bo.Person;

@Repository
public class PersonDao extends BaseDao {

	private RowMapper<Person> personRowMapper = new BeanPropertyRowMapper<>(Person.class);

	public List<Person> getAllPersonList() {
		String sql = "select * from Person";
		return this.getJdbcTemplate().query(sql, personRowMapper);
	}

	public Optional<Person> getPersonDetail(String id) {
		String sql = "select * from Person where id=?";
		return this.queryforOptional(sql, new Object[] { id }, personRowMapper);
	}

	public boolean updatePerson(String id, Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertPerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePerson(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changePersonDetails(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

}
