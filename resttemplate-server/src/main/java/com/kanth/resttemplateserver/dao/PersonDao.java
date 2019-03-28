package com.kanth.resttemplateserver.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kanth.resttemplateserver.bo.Person;
import com.kanth.resttemplateserver.bo.SqlParaBean;
import com.kanth.resttemplateserver.util.SqlUtils;

@Repository
public class PersonDao extends BaseDao {

	Logger logger = LoggerFactory.getLogger(PersonDao.class);
	private RowMapper<Person> personRowMapper = new BeanPropertyRowMapper<>(Person.class);

	public List<Person> getAllPersonList() {
		String sql = "select * from Person";
		return this.getJdbcTemplate().query(sql, personRowMapper);
	}

	public Optional<Person> getPersonDetail(String id) {
		String sql = "select * from Person where id=?";
		return this.queryforOptional(sql, new Object[] { id }, personRowMapper);
	}

	public boolean updatePerson(Person person) {
		SqlParaBean sqlbean = null;
		try {
			sqlbean = SqlUtils.getQueryonBeanValues(person);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		return this.getJdbcTemplate().update(sqlbean.getSqlquery(), sqlbean.getParams()) > 0;
	}

	public boolean insertPerson(Person person) {
		String sql = "insert into Person (age,mobileno,name,id) values(?,?,?,?)";
		return this.getJdbcTemplate().update(sql, person.getAge(), person.getMobileno(), person.getName(),
				person.getId()) > 0;
	}

	public boolean deletePerson(String id) {
		String sql = "delete from  Person where id=?";
		return this.getJdbcTemplate().update(sql, id) > 0;
	}

	public boolean changePersonDetails(Person person, String id) {
		String sql = "update Person set age=? , mobileno=? , name=? , id=?  where id=?";
		return this.getJdbcTemplate().update(sql, person.getAge(), person.getMobileno(), person.getName(),
				person.getId(), id) > 0;
	}

}
