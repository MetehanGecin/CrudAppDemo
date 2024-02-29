package com.example.crudapp.controller;

import com.example.crudapp.entity.Employee;
import com.example.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

@GetMapping("/list")
    public String listEmployee(Model theModel){

        List<Employee> employeeList=employeeService.getEmployees();

        theModel.addAttribute( "employee" ,employeeList);
        return "employee-list";

    }

@GetMapping("/showFromForAdd")
    public String showFromForAdd(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute( "employee",theEmployee);
        return "employee-from";
    }

@PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";

    }

    @GetMapping("/showFromForUpdate")
    public String showFromForUpdate(@RequestParam("employeeId") int theId,Model theModel) throws Exception {
            Employee theEmployee=employeeService.findById(theId);
            theModel.addAttribute("employee" , theEmployee);
            return "employee-from";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId,Model theModel) throws Exception {
        Employee theEmployee = employeeService.findById(theId);
        employeeService.delete(theEmployee);
        return "redirect:/employees/list";
    }
}
