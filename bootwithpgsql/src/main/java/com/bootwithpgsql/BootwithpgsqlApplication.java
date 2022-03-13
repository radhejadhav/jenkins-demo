package com.bootwithpgsql;

import com.bootwithpgsql.configurations.HibernateConfig;
import com.bootwithpgsql.daos.StudentDao;
import com.bootwithpgsql.entities.Demo1;
import com.bootwithpgsql.entities.Student;
import com.bootwithpgsql.services.StudentService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@SpringBootApplication
public class BootwithpgsqlApplication implements CommandLineRunner {

	@Autowired
	private StudentService service;

	public static void main(String[] args) {
		SpringApplication.run(BootwithpgsqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//
		Student student = new Student(1L,"payal","payal34@gmail.com");

		ObjectMapper mapper = new ObjectMapper();

//		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//		StudentService service = context.getBean("getStudentService",StudentService.class);

//		service.addStudents(student);
		List<Student> studentList = service.getAllStudents();


		String str = mapper.writeValueAsString(studentList);
		byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
		JsonNode jsonNode = mapper.readTree(bytes);

		System.out.println(jsonNode);

//		try {
//			InputStream is = new ByteArrayInputStream(bytes);
////			File newFile = new File("src/main/resources/static/hello.json");
////			newFile.createNewFile();
//			Path path = Paths.get("C:/Users/hp/Desktop/Postgresql/bootwithpgsql/src/main/resources/static/myfile.json").normalize();
//
//			Files.copy(is,path,StandardCopyOption.REPLACE_EXISTING);
//
//
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//		}
//
//		System.out.println(jsonNode.path("name"));


//		demo1.setName("radhe");
//		System.out.println(demo1.getName());
//
//		Demo1 demo2 = context.getBean("getDemo1",Demo1.class);
//
//		System.out.println(demo2.getName());

	}
}
