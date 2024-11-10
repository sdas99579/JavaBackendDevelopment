package org.gfg.JBDL_64_DBConnectivity.repositories;

import org.gfg.JBDL_64_DBConnectivity.model.MyPerson;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;


//public interface MyPersonRepository extends MongoRepository<MyPerson,Integer> {
public interface MyPersonRepository extends JpaRepository<MyPerson, Integer> {

}
