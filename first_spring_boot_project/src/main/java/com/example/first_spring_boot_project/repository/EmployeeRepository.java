package com.example.first_spring_boot_project.repository;

import com.example.first_spring_boot_project.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    Map<Long, Employee> employeeMap = new HashMap<>();

    public String addEmployee(Employee employee) {
        if (employeeMap.containsKey(employee.getEmpId())) {
            Employee savedEmployee=employeeMap.get(employee.getEmpId());
            savedEmployee.setEmpName(employee.getEmpName());
            savedEmployee.setEmpAge(employee.getEmpAge());
            savedEmployee.setEmpSalary(employee.getEmpSalary());
            return "Employee data updated";
        }
        employeeMap.put(employee.getEmpId(), employee);
        return "Employee data added successfully";
    }

    public Employee getEmployeData(long id) {
        if (!employeeMap.containsKey(id)) {
            throw new RuntimeException("Employee doesn't exist");
        }
        return employeeMap.get(id);
    }

    public Employee updateEmployeeById(long id, int age, int salary) {
        if (!employeeMap.containsKey(id)) {
            throw new RuntimeException("Employee doesn't exist");
        }
        Employee employee = employeeMap.get(id);
        employee.setEmpAge(age);
        employee.setEmpSalary(salary);
        return employee;
    }

    public String deleteEmployee(long id) {
        if(!employeeMap.containsKey(id)){
            return "Employee data is not present";
        }
        employeeMap.remove(id);
        return "Employee data deleted successfully";
    }
}
