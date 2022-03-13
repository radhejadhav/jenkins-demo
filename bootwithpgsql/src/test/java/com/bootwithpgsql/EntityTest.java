package com.bootwithpgsql;


import com.bootwithpgsql.entities.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@DisplayName("Entity Serialization")
public class EntityTest {

    @Test
    @DisplayName("when serialize object")
    public void whenSerializingObject() throws JsonProcessingException {
        Employee employe = new Employee();
        employe.setId("ABC123");
        employe.setName("Radhe");
        employe.setSalary(23233);

        String result = new ObjectMapper().writeValueAsString(employe);

        AssertionsForClassTypes.assertThat(result).contains("Radhe");
    }
}
