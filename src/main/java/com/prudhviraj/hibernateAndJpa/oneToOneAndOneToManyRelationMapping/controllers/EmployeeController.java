package com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.controllers;

import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.entites.Employee;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.services.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/createNewEmployee")
    public Employee createNewEmployee(@RequestBody Employee employee){
        return  employeeService.createNewEmployee(employee);
    }
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return  employeeService.getEmployeeById(id);

    }
}
