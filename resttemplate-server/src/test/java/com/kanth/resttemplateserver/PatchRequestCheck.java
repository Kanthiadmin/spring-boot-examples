package com.kanth.resttemplateserver;

import org.springframework.stereotype.Component;

import com.kanth.resttemplateserver.bo.Person;

@Component
public class PatchRequestCheck {

	public Person getPersonBean(){
		Person person=new Person();
		person.setId("abc");
		person.setName("James");
		return person;
	}
	
	
}
