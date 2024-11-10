package org.gfg.JBDL_64_DBConnectivity.repositories;

import org.gfg.JBDL_64_DBConnectivity.Person;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface IPerson {
    List<Person> getAllPerson();
    void createTable() throws SQLException;
    boolean insertPerson(Person person) throws SQLException;
    int updatePerson(String name, Integer id) throws SQLException;

//    int updatePerson(String name, Integer id);

    boolean deletePerson(Person person) throws SQLException;
}
