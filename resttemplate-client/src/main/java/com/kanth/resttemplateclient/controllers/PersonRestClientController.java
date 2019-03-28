package com.kanth.resttemplateclient.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;

import com.kanth.resttemplateserver.bo.Person;
import com.kanth.resttemplateserver.exceptions.ResourceNotFoundException;

/**
 * 
 * @author ramakanth.b
 *
 */
@RestController
@RequestMapping(path = "/api/client/Person")
public class PersonRestClientController {

	private static final String BASEURL = "http://localhost:9181/api/Person/person";

	@Autowired
	private RestTemplate restservice;

	@GetMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getPersonList() {
		String uri = BASEURL;
		ResponseEntity<Person[]> response = restservice.getForEntity(uri, Person[].class);
		return Arrays.asList(response.getBody());

	}

	@GetMapping(path = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getPerson(@PathVariable("id") String id) {
		String url = BASEURL + "/" + id;
		ResponseEntity<Person> response = restservice.getForEntity(url, Person.class);
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			throw new ResourceNotFoundException();
		}
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	}

	@PostMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> insertPerson(@RequestBody Person person) {
		String url = BASEURL;
		ResponseEntity<Person> response = restservice.postForEntity(url, person, Person.class);
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			throw new ResourceNotFoundException();
		}
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	}

	@DeleteMapping(path = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deletePerson(@PathVariable("id") String id) {
		String url = BASEURL + "/" + id;
		try {
			restservice.delete(url);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	@PatchMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		String url = BASEURL;
		ResponseEntity<Person> response = restservice.exchange(url, HttpMethod.PATCH, new HttpEntity<>(person),
				Person.class);
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			throw new ResourceNotFoundException();
		}
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);

	}

	@PutMapping(path = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> changePersonDetails(@RequestBody Person person, @PathVariable("id") String id) {
		String url = BASEURL + "/" + id;
		ResponseEntity<Person> response = restservice.exchange(url, HttpMethod.PUT, new HttpEntity<>(person),
				Person.class);
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			throw new ResourceNotFoundException();
		}
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);

	}

}
