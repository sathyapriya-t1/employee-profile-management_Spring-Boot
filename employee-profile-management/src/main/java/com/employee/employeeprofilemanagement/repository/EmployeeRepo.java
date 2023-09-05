package com.employee.employeeprofilemanagement.repository;

import com.employee.employeeprofilemanagement.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    Employee findByName(String eName);

}
