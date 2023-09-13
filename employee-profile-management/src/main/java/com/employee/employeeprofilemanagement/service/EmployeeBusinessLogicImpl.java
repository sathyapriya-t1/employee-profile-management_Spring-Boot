package com.employee.employeeprofilemanagement.service;

import com.employee.employeeprofilemanagement.data.Employee;
import com.employee.employeeprofilemanagement.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeBusinessLogicImpl implements EmployeeBusinessLogic {
    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> addEmployees(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public Employee getEmployeeById(int eId) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(eId);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateEmployeeById(int eId,Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(eId);
        Employee emp = optionalEmployee.get();
        if(optionalEmployee.isPresent()){
            employeeRepo.deleteById(optionalEmployee.get().getId());
            emp.setId(employee.getId());
            emp.setName(employee.getName());
            emp.setContactNumber(employee.getContactNumber());
            emp.setGender(employee.getGender());
            return employeeRepo.save(emp);
        }
        else{
            return employeeRepo.save(employee);

        }

    }

    @Override
    public ResponseEntity<Employee> deleteEmployeeById(int eId) {
        employeeRepo.deleteById(eId);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }

    @Override
    public Employee findByName(String eName) {
        return employeeRepo.findByName(eName);
    }


}
