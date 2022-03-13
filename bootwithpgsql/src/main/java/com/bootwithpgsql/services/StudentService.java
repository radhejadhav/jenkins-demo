package com.bootwithpgsql.services;

import com.bootwithpgsql.daos.StudentDao;
import com.bootwithpgsql.entities.Demo1;
import com.bootwithpgsql.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;


    @Transactional
    public Student addStudents(Student student){
        return studentDao.addStudent(student);
    }

    public List<Student> getAllStudents(){
        return this.studentDao.getAllStudent();
    }

    public Student getStudentById(Long id){ return studentDao.getStudentById(id);}
}
