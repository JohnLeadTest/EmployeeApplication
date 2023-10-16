package com.employee.EmployeeApplication.controller;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/employees")
    public List<Employee> findAllEmployees() {
        return  employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee findAnEmployees(@PathVariable int id) {
        return  employeeService.getAnEmployee(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public  void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "employees/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable  int id, @RequestBody Employee employee) {
        employeeService.updateEmployee((employee));
    }
}
