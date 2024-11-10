package org.gfg.two_ds.services;


import org.gfg.two_ds.personDB.Person;
import org.gfg.two_ds.personDB.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public boolean addPerson(Person person) {
        personRepository.save(person);
        return true;
    }
}
