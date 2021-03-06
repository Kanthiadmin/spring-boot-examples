package com.kanth.resttemplateserver.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanth.resttemplateserver.bo.Person;
import com.kanth.resttemplateserver.dao.PersonDao;
import com.kanth.resttemplateserver.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao persondao;

	@Override
	public List<Person> getAllPersonList() {
		return persondao.getAllPersonList();
	}

	@Override
	public Optional<Person> getPersonDetail(String id) {
		return persondao.getPersonDetail(id);
	}

	@Override
	public boolean updatePerson(Person person) {
		return persondao.updatePerson(person);
	}

	@Override
	public boolean insertPerson(Person person) {
		return persondao.insertPerson(person);
	}

	@Override
	public boolean deletePerson(String id) {
		return persondao.deletePerson(id);
	}

	@Override
	public boolean changePersonDetails(Person person, String id) {
		return persondao.changePersonDetails(person, id);
	}

}
