package org.gfg.minor1.service;

import org.gfg.minor1.model.FilterStudent;
import org.gfg.minor1.model.Student;
import org.gfg.minor1.repository.StudentRepository;
import org.gfg.minor1.request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student createStudent(StudentCreateRequest studentCreateRequest) {

        List<Student> studentList = studentRepository.findByPhoneNo(studentCreateRequest.getPhoneNo());

        Student studentFromDb=null;
        if(studentList==null || studentList.isEmpty())
        {
            studentFromDb = studentRepository.save(studentCreateRequest.toStudent());
            return studentFromDb;
        }

        studentFromDb=studentList.get(0);
        return studentFromDb;
    }

    public List<Student> filter(FilterStudent filterStudent, String value) {
        switch (filterStudent){
            case NAME :
                return studentRepository.findByName(value);
            case PHONE_NO:
                return studentRepository.findByPhoneNo(value);
            case EMAIL:
                return studentRepository.findByEmail(value);
            default:
                return new ArrayList<>();
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
