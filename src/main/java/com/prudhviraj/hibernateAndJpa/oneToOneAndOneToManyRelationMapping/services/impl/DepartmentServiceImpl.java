package com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.services.impl;

import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.entites.Department;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.entites.Employee;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.repositries.DepartmentRepo;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.repositries.EmployeeRepo;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Department createNewDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id).orElseThrow(()->new RuntimeException("Department doesn't exist with provided id : "+ id));
    }
    @Override
    public Department assignManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<Department> department = departmentRepo.findById(departmentId);
        Optional<Employee> employee = employeeRepo.findById(employeeId);
        return department.flatMap(department1 ->
                employee.map(employee1 -> {
                    department1.setManager(employee1);
                    return departmentRepo.save(department1);
                })).orElse(null);


    }

    @Override
    public Employee getDepartmentManagerByDepartmentId(Long departmentId) {
        Department department = departmentRepo.findById(departmentId).orElse(null);

        return employeeRepo.findById(department.getManager().getId()).orElse(null);
    }
}
