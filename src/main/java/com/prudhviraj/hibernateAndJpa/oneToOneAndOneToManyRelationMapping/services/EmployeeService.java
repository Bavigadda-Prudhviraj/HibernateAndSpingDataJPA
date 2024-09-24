package com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.services;

import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.entites.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    public Employee createNewEmployee(Employee employee);
    public Employee getEmployeeById(Long id);
}
