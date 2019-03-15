package com.kanth.resttemplateserver.service;

import java.util.List;

import com.kanth.resttemplateserver.bo.Person;

public interface PersonService {

	public List<Person> getAllPersonList();

	public Person getPersonDetail(String id);

	public boolean updatePerson(String id, Person person);

	public boolean insertPerson(Person person);

	public boolean deletePerson(String id);

	public boolean changePersonDetails(Person person);

}
