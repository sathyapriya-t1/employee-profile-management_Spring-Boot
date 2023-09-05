package com.employee.employeeprofilemanagement.controller;

import com.employee.employeeprofilemanagement.data.Employee;
import com.employee.employeeprofilemanagement.service.EmployeeBusinessLogicImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeRestController.class)
@ExtendWith(MockitoExtension.class)
class EmployeeRestControllerTest {

    @InjectMocks
    private EmployeeRestController employeeControllerMock;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeBusinessLogicImpl employeeBusinessLogicMock;

    @Test
    void addEmployee() throws Exception {
        //Given
        Employee employee = new Employee(1,"sathya","Female",12345);
        //When
        when(employeeBusinessLogicMock.addEmployee(employee)).thenReturn(employee);


        mockMvc.perform(post("/employees/").content(new ObjectMapper().writeValueAsString(employee)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(employeeBusinessLogicMock).addEmployee(employee);

    }
    @Test
    void getEmployeeEmployeeByIdTest() throws Exception {
        int eId = 1;
        Employee employee = new Employee(1,"sathya","Female",12345);
        when(employeeBusinessLogicMock.getEmployeeById(1)).thenReturn(employee);

        mockMvc.perform(get("/employees/{eId}/")).andExpect(status().isOk()).andExpect(jsonPath("$.eId")
                .value(employee.getId())).andExpect(jsonPath("$.eName")
                .value(employee.getName())).andExpect(jsonPath("$.eGender")
                .value(employee.getGender())).andExpect(jsonPath("$.eContactNumber")
                .value(employee.getContactNumber()));


    }





}