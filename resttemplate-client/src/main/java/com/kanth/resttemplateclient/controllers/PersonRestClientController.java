package com.kanth.resttemplateclient.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
                                                                                                                                                                                                                                                                                                
import com.kanth.resttemplateserver.bo.Person;

@RestController
@RequestMapping(path = "/api/client/Person")
public class PersonRestClientController {

	@Autowired
	private RestTemplate restservice;

	@GetMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getPersonList() {
		final String uri = "http://localhost:9181/api/Person/person";
		ResponseEntity<Person[]> response = restservice.getForEntity(uri, Person[].class);
		return Arrays.asList(response.getBody());

	}

}
