package com.employee.employeeprofilemanagement.service;

import com.employee.employeeprofilemanagement.data.Employee;
import com.employee.employeeprofilemanagement.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeBusinessLogicImplTest {

    @InjectMocks
    private EmployeeBusinessLogicImpl employeeBusinessLogicMock;

    @Mock
    private EmployeeRepo employeeRepo;


    @Test
    void getEmployeeByIdTest(){
        //Given
        Employee employee = new Employee(1,"sathya","Female",12345);
        when(employeeRepo.findById(1)).thenReturn(Optional.of(employee));
        //When
        Employee employee1 = employeeBusinessLogicMock.getEmployeeById(1);
        //then
        assertEquals(1,employee1.getId());
        assertEquals(employee,employee1);
        //Verify
        verify(employeeRepo).findById(1);

    }

    @Test
    void addEmployeeTest(){
        //Given
        Employee employee = new Employee(1,"sathya","Female",12345);
        when(employeeRepo.save(employee)).thenReturn(employee);
        //When
        Employee employee1 = employeeBusinessLogicMock.addEmployee(employee);
        //Then
        assertNotNull(employee1);
        assertEquals(employee1.getName(),"sathya");
        assertEquals(employee1.getId(),1);
        //Verify
        verify(employeeRepo).save(employee);

    }




    @Test
    void getEmployeesTest(){
        //Given
        Employee employeeOne = new Employee(1,"sathya","Female",12345);
        Employee employeeTwo = new Employee(1,"sathya","Female",12345);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employeeOne);
        employeeList.add(employeeTwo);
        when(employeeRepo.findAll()).thenReturn(employeeList);
        //When
        List<Employee> employeeList2 = employeeBusinessLogicMock.getEmployees();
        //Then
        assertEquals(2,employeeList2.size());
        //Verify
        verify(employeeRepo).findAll();

    }

    @Test
    void updateEmployeeTest() {
        //Given
        Employee employee = new Employee(1, "sathya", "Female", 12345);
        when(employeeRepo.findById(1)).thenReturn(Optional.of(employee));
        employee.setName("Priya");
        //when
        Employee employee1 = employeeBusinessLogicMock.updateEmployeeById(1, employee);
        //Then
        assertEquals("Priya", employee1.getName());
        verify(employeeRepo).findById(1);


    }

    @Test
    void deleteEmployeeTest(){
        //Given
        Employee employee = new Employee(1, "sathya", "Female", 12345);
        //When
        doNothing().when(employeeRepo).deleteById(1);
        String result = employeeBusinessLogicMock.deleteEmployeeById(1);
        assertEquals(result,"successfully deleted");
        verify(employeeRepo).deleteById(1);




    }




}