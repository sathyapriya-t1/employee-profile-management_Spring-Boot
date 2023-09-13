package com.employee.employeeprofilemanagement.service;

import com.employee.employeeprofilemanagement.data.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
 public interface EmployeeBusinessLogic {
        Employee addEmployee(Employee employee);

        List<Employee> addEmployees(List<Employee> employees);

        Employee getEmployeeById(int eId);

        List<Employee> getEmployees();

        Employee updateEmployeeById(int eId,Employee employee) throws Exception;

        ResponseEntity<Employee> deleteEmployeeById(int eId);

        Employee findByName(String eName);


    }


