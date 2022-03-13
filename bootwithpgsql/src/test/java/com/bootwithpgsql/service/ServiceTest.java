package com.bootwithpgsql.service;

import com.bootwithpgsql.daos.StudentDao;
import com.bootwithpgsql.entities.Student;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ServiceTest {

    @InjectMocks
    Student student;

    @Mock
    StudentDao studentDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    Student student1 = new Student(1L,"radhe","abc@gmail.com");
    Student student2 = new Student(3L,"Rohan","xyz@gmail.com");

    @Test
    void getAllStudent() {

        List<Student> list = new ArrayList<Student>();


        list.add(student1);
        list.add(student2);

        when(studentDao.getAllStudent()).thenReturn(list);

        List<Student> studentList = studentDao.getAllStudent();

        assertEquals(2,studentList.size());

        verify(studentDao,times(1)).getAllStudent();
    }
}
