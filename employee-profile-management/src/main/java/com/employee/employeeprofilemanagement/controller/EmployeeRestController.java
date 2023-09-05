package com.employee.employeeprofilemanagement.controller;

import com.employee.employeeprofilemanagement.data.Employee;
import com.employee.employeeprofilemanagement.service.EmployeeBusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees/")
public class EmployeeRestController {

    @Autowired
    EmployeeBusinessLogic employeeBusinessLogic;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeBusinessLogic.addEmployee(employee);
    }
    @PostMapping("employees/")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return employeeBusinessLogic.addEmployees(employees);
    }


    @GetMapping("{eId}/")
    public  Employee getEmployeeById(@PathVariable Integer eId){
        return employeeBusinessLogic.getEmployeeById(eId);
    }

    @GetMapping("{eName}/")
    public  Employee getEmployeeByName(@PathVariable String eName){
        return employeeBusinessLogic.findByName(eName);

    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeBusinessLogic.getEmployees();
    }

    @PutMapping("{eId}/")
    public Employee updateEmployeeById(@PathVariable Integer eId,@RequestBody Employee employee) throws Exception {
        return employeeBusinessLogic.updateEmployeeById(eId,employee);
    }

    @DeleteMapping("{eId}/")
    public void deleteEmployeeById(@PathVariable Integer eId){
        employeeBusinessLogic.deleteEmployeeById(eId);
    }
}