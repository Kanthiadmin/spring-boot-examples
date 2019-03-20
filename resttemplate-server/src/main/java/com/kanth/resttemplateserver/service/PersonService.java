package com.kanth.resttemplateserver.service;

import java.util.List;
import java.util.Optional;

import com.kanth.resttemplateserver.bo.Person;

public interface PersonService {

	/**
	 * Get all the Person details 
	 * @return
	 */
	public List<Person> getAllPersonList();

	/**
	 * Get the Unique Person based on ID
	 * @param id
	 * @return
	 */
	public Optional<Person> getPersonDetail(String id);

	public boolean updatePerson(Person person);

	public boolean insertPerson(Person person);

	public boolean deletePerson(String id);

	public boolean changePersonDetails(Person person);

}
