package org.gfg.JBDL_64_DBConnectivity.services;

import jakarta.transaction.Transactional;
import org.gfg.JBDL_64_DBConnectivity.CustomException;
import org.gfg.JBDL_64_DBConnectivity.Person;
import org.gfg.JBDL_64_DBConnectivity.model.MyPerson;
import org.gfg.JBDL_64_DBConnectivity.repositories.IPerson;
import org.gfg.JBDL_64_DBConnectivity.repositories.MyPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.gfg.JBDL_64_DBConnectivity.repositories.IPerson;
import java.sql.SQLException;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    @Qualifier("personRepository")
    private IPerson iPerson;



    @Autowired
    private MyPersonRepository myPersonRepository;

    public List<Person> getAllPerson() {
        return iPerson.getAllPerson();
    }

    @Transactional(rollbackOn = {CustomException.class})
    public boolean insertPerson(Person person) throws SQLException, CustomException {
//        return iPerson.insertPerson(person);
//        MyPerson myPerson = new MyPerson(person.getId(), person.getName());
        MyPerson myPerson = new MyPerson(person.getName());
        MyPerson p = myPersonRepository.save(myPerson);

        if(person.getName().equalsIgnoreCase("Laxman"))
        {
            throw new CustomException("Not valid");
        }
        return true;
    }

//    public boolean updatePerson(Person person) throws SQLException {
//        return personRepository.updatePerson(person);
//    }
//    public int updatePerson(String name, Integer id) {
public int updatePerson(String name, Integer id) {
    try {
        return iPerson.updatePerson(name,id);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    public boolean deletePerson(Person person) throws SQLException {
        return iPerson.deletePerson(person);
    }
}
