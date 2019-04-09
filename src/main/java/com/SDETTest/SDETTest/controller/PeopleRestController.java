package com.SDETTest.SDETTest.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.SDETTest.SDETTest.model.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleRestController {

    List<Person> people;
    ApplicationContext context;
    Person[] filePeople;
    

    public PeopleRestController() {
        people = new ArrayList<Person>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream file;
        try {
            ClassPathResource resource = new ClassPathResource("com/SDETTEST/SDETTEST/data/people.json");
            file = resource.getInputStream();
            filePeople = objectMapper.readValue(file, Person[].class);
            people = Arrays.asList(filePeople);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
   

 
    @RequestMapping(value = "/getPeople", method = RequestMethod.GET)
    public List<Person> getPeople(@RequestParam(value = "fromId") int fromId, @RequestParam(value = "toId") int toId) {
        List<Person> result = people.stream().filter(x -> x.getId() >= fromId && x.getId() <= toId).collect(Collectors.toList());
        return result;

    }

    @RequestMapping(value = "/getPersonByEmail/{email}", method = RequestMethod.GET)
    public List<Person> getPersonByEmail(@PathVariable(value = "email") String email) {
        return people.stream().filter(x -> x.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
    }
 
    @RequestMapping(value = "/getPerson", method = RequestMethod.GET)
    public List<Person> getPerson(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        List<Person> result = people.stream().filter(x -> x.getFirstName().equalsIgnoreCase(firstName) && x.getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toList());
        return result;
    }
 
    @RequestMapping(value = "/getPersonByState/{state}", method = RequestMethod.GET)
    public List<Person> getPersonByState(@PathVariable(value = "state") String state) {
        List<Person> peopleByState = people.stream().filter(x -> x.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());

        return peopleByState;
    }
 
   
}