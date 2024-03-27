package com.example.first_spring_boot_project.controller;

import com.example.first_spring_boot_project.model.Employee;
import com.example.first_spring_boot_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    //Field Injection
    @Autowired
    EmployeeService employeeService;

    //@Value annotation
    @Value("${app.check}")
    private String check;
    @GetMapping("/check")
    public String check() {
        return check;
    }

    @PostMapping("/add")  //add the employee and if already present then update
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/get")
    public ResponseEntity getEmployeeData(@RequestParam("id") long id) {

        Employee employee = employeeService.getEmployeeData(id);
        if (employee == null) {
            return new ResponseEntity<>("Employee doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity updateEmployeeById(@RequestParam("id") long id, @RequestParam("age") int age,
                                             @RequestParam("sal") int sal) {
        Employee employee = employeeService.updateEmployeeById(id, age, sal);
        if (employee == null) {
            return new ResponseEntity<>("Employee doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete")
    public String deleteEmployee(@RequestParam("id") long id) {
        return employeeService.deleteEmployee(id);
    }


}
