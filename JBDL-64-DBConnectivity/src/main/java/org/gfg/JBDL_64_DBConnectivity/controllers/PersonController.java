package org.gfg.JBDL_64_DBConnectivity.controllers;

import org.gfg.JBDL_64_DBConnectivity.Person;
import org.gfg.JBDL_64_DBConnectivity.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController //combination of controller and responsebody
//@Controller
public class PersonController {

//    @ResponseBody
    @Autowired
    private PersonService personService;


    @GetMapping("/getPersons")
     public List<Person> getAllPerson()
     {
         return personService.getAllPerson();
     }

     @PostMapping("/addPerson")
    public ResponseEntity<Boolean> insertData(@RequestBody Person person) throws Exception {
        if (person.getName()==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            throw new Exception("Name should not be null");
        }
         return new ResponseEntity<>(personService.insertPerson(person),HttpStatus.OK);
     }


//     @PostMapping("/updatePerson")
//    public ResponseEntity<Boolean> updateData(@RequestBody Person person) throws SQLException {
//        if(person.getId()<1)
//        {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(personService.updatePerson(person),HttpStatus.OK);
//     }
    @PutMapping("/updatePerson")
//    public int updatePerson(@RequestParam("name") String name, @RequestParam("id") Integer id) throws Exception {
    public int updatePerson(@RequestParam("name") String name, @RequestParam("id") Integer id) throws Exception {
        if(id==null)
        {
            throw new Exception("ID should not be null");
        }
        return personService.updatePerson(name,id);
    }

     @PostMapping("/deletePerson")
    public ResponseEntity<Boolean> deleteData(@RequestBody Person person) throws SQLException{
         if(person.getId()<1)
         {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>(personService.deletePerson(person),HttpStatus.OK);
     }
}
