package com.example.first_spring_boot_project.service;

import com.example.first_spring_boot_project.model.Employee;
import com.example.first_spring_boot_project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    //Constructor Injection
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public String addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    public Employee getEmployeeData(long id) {

        return employeeRepository.getEmployeData(id);
    }

    public Employee updateEmployeeById(long id, int age, int salary) {
        return employeeRepository.updateEmployeeById(id, age, salary);
    }

    public String deleteEmployee(long id) {
        return employeeRepository.deleteEmployee(id);
    }
}
