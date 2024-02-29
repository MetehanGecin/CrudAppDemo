package com.example.crudapp.repository;

import com.example.crudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
