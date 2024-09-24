package com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.services;

import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.entites.Department;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.entites.Employee;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    public Department createNewDepartment(Department department);
    public Department getDepartmentById(Long id);
    public Department assignManagerToDepartment(Long departmentId, Long employeeId);
    public Employee getDepartmentManagerByDepartmentId(Long  departmentId);
}
