package com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.controllers;

import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.entites.Department;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.entites.Employee;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.services.impl.DepartmentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
    DepartmentServiceImpl departmentService;
    DepartmentController(DepartmentServiceImpl departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/getDepartmentById/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }
    @PostMapping("/createNewDepartment")
    public Department createNewDepartment(@RequestBody Department department){
        return departmentService.createNewDepartment(department);
    }
    @PutMapping("/assignManagerToDepartment/{departmentId}/manager/{employeeId}")
    public Department assignManagerToDepartment(@PathVariable Long departmentId,
                                                @PathVariable Long employeeId){
        return departmentService.assignManagerToDepartment(departmentId,employeeId);

    }
    @GetMapping("/getDepartmentManagerByDepartmentId/{departmentId}")
    public Employee getDepartmentManagerByDepartmentId(@PathVariable Long departmentId){
        return departmentService.getDepartmentManagerByDepartmentId(departmentId);
    }

    @PutMapping("/assignWorkerToDepartment/{departmentId}/worker/{employeeId}")
    public Department assignWorkerToDepartment(@PathVariable Long departmentId,
                                                @PathVariable Long employeeId){
        return departmentService.assignWorkerToDepartment(departmentId,employeeId);

    }

    @PutMapping("/assignFreelancersToDepartment/{departmentId}/freelancers/{employeeId}")
    public Department assignFreelancersToDepartment(@PathVariable Long departmentId,
                                               @PathVariable Long employeeId){
        return departmentService.assignFreelancersToDepartment(departmentId,employeeId);

    }
}
