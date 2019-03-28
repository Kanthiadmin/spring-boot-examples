package com.kanth.resttemplateserver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanth.resttemplateserver.bo.Person;
import com.kanth.resttemplateserver.exceptions.ResourceNotFoundException;
import com.kanth.resttemplateserver.service.PersonService;

/**
 * 
 * @author ramakanth.b
 *
 */
@RestController
@RequestMapping(path = "/api/Person")
public class PersonRestController {

	@Autowired
	private PersonService personService;

	@GetMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getPersonList() {
		return personService.getAllPersonList();

	}

	@GetMapping(path = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getPerson(@PathVariable("id") String id) {
		Optional<Person> person = personService.getPersonDetail(id);
		if (person.isPresent()) {
			return new ResponseEntity<>(person, HttpStatus.OK);
		}
		throw new ResourceNotFoundException();
	}

	@PatchMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updatePerson(@RequestBody Person person) {
		boolean flag = personService.updatePerson(person);
		if (flag) {
			return new ResponseEntity<>(person, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException();
		}

	}

	@PutMapping(path = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> changePersonDetails(@RequestBody Person person, @PathVariable("id") String id) {
		boolean flag = personService.changePersonDetails(person, id);
		if (flag) {
			return new ResponseEntity<>(person, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException();
		}

	}

	@PostMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertPerson(@RequestBody Person person) {
		boolean flag = personService.insertPerson(person);
		if (flag) {
			return new ResponseEntity<>(person, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException();
		}

	}

	@DeleteMapping(path = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deletePerson(@PathVariable("id") String id) {
		boolean flag = personService.deletePerson(id);
		if (flag) {
			return ResponseEntity.ok("resource deleted");
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
