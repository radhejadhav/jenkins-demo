package com.bootwithpgsql;

import com.bootwithpgsql.entities.Calculator;
import com.bootwithpgsql.entities.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@SpringBootTest
class BootwithpgsqlApplicationTests {


	Calculator calculator = new Calculator();

	@Test
	void contextLoads() {
	}

	@Test
	void testAddition(){

		int actual = calculator.add(2,2);

		int expect = 4;

		assertThat(actual).isEqualTo(expect);
	}

	@BeforeEach
	void setUp() {

		System.out.println("Setting Up ...");
	}
	@AfterEach
	void tearDown() {
		System.out.println("teared Down !");
	}
}
