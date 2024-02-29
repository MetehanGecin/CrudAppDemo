package com.example.crudapp.service;


import com.example.crudapp.entity.Employee;
import com.example.crudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public Employee findById(int theId) throws Exception {
        Optional<Employee> result=employeeRepository.findById(theId);
        Employee theEmployee= new Employee();
        if (result.isPresent()){
            theEmployee=result.get();
        }else {
            throw new Exception("Don't found employee id =" + theId);
        }
        return theEmployee;
    }

    @Override
    public void delete(Employee theEmployee) {
        employeeRepository.delete(theEmployee);
    }
}
