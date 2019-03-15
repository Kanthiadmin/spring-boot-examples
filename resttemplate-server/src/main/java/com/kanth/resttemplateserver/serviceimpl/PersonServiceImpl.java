package com.kanth.resttemplateserver.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanth.resttemplateserver.bo.Person;
import com.kanth.resttemplateserver.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public List<Person> getAllPersonList() {
		return null;
	}

	@Override
	public Person getPersonDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePerson(String id, Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertPerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePersonDetails(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

}
