package com.Forage.Employee.test;

import org.junit.jupiter.api.Test;
import com.Forage.EmployeeProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EmployeeControllerTest.class)
public class EmployeeControllerTest {  

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetEmployeeById() throws Exception {
        mockMvc.perform(get("/employees/{id}", 1))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    public void testGetEmployeeByIdNotFound() throws Exception {
        mockMvc.perform(get("/employees/{id}", 999))
               .andExpect(status().isNotFound());
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee newEmployee = new Employee(1, "Jane", "deo","janeDeo@mail.com","Developer");
        mockMvc.perform(post("/employees")
               .contentType(MediaType.APPLICATION_JSON)
               .content(asJsonString(newEmployee)))
               .andExpect(status().isCreated());
    }

    @Test
    public void testAddEmployeeBadRequest() throws Exception {
        Employee invalidEmployee = new Employee(null, "", "", null, null);
        mockMvc.perform(post("/employees")
               .contentType(MediaType.APPLICATION_JSON)
               .content(asJsonString(invalidEmployee)))
               .andExpect(status().isBadRequest());
    }

    // Utility method to convert an object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
