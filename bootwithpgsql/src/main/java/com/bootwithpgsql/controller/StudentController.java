package com.bootwithpgsql.controller;

import com.bootwithpgsql.entities.Employee;
import com.bootwithpgsql.entities.Student;
import com.bootwithpgsql.services.StudentService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "https://editor.swagger.io/")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllStudent(){

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Student> students = this.service.getAllStudents();
            String str = mapper.writeValueAsString(students);
            JsonNode node = mapper.readTree(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for(String str1:node.findValuesAsText("name") ){
                sb.append(str1);
                sb.append("\n");
            }

            return ResponseEntity.status(HttpStatus.OK.value()).body(students);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") long id){
        try {
            return service.getStudentById(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getEmployee(@RequestBody Employee employee){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
