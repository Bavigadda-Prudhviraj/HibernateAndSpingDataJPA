package com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.services.impl;

import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.entites.Employee;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.repositries.EmployeeRepo;
import com.prudhviraj.hibernateAndJpa.oneToOneAndOneToManyRelationMapping.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public Employee createNewEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isEmpty()){
            log.error("Employee object is null");
        }
        return employee.orElse(null);
    }
}
