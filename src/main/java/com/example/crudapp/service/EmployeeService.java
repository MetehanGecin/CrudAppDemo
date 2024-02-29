package com.example.crudapp.service;


import com.example.crudapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getEmployees();

    void save(Employee theEmployee);

    Employee findById(int theId) throws Exception;

    void delete(Employee theEmployee);
}