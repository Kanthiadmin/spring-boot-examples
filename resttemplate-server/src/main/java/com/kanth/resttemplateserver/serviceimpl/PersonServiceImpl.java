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
