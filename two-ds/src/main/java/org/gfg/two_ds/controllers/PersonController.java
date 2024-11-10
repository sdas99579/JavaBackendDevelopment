package org.gfg.two_ds.controllers;

import org.gfg.two_ds.personDB.Person;
import org.gfg.two_ds.personDB.PersonRepository;
import org.gfg.two_ds.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/addPerson")
    public boolean insertData(@RequestBody Person person) throws Exception {

        return personService.addPerson(person);
    }
}
