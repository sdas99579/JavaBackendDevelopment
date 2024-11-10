package org.gfg.minor1.controller;


import org.gfg.minor1.exception.TxnException;
import org.gfg.minor1.model.*;
import org.gfg.minor1.request.BookCreateRequest;
import org.gfg.minor1.request.StudentCreateRequest;
import org.gfg.minor1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentCreateRequest studentCreateRequest) throws TxnException {
        //validation can be here
        if(studentCreateRequest.getPhoneNo()==null || StringUtils.isEmpty(studentCreateRequest.getPhoneNo()))
        {
            throw new TxnException("Student Phone number cannot be null");
        }
        return studentService.createStudent(studentCreateRequest);
    }


    @GetMapping("/filter")
    public List<Student> filter(@RequestParam(value = "filterStudent", required = false) FilterStudent filterStudent,
                             @RequestParam(value = "value", required = false) String value){
        if(filterStudent==null || value==null)
            return studentService.getAllStudents();
        return studentService.filter(filterStudent,value);
    }
}
