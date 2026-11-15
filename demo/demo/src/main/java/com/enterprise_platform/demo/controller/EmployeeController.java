package com.enterprise_platform.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>(List.of(
        new Employee(1, "Asha Rao", "Developer", "IT"),
        new Employee(2, "Ravi Kumar", "Designer", "Design"),
        new Employee(3, "Mina Shah", "Manager", "Operations")
    ));

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody EmployeeRequest request) {
        Employee employee = new Employee(
            employees.size() + 1,
            request.name(),
            request.role(),
            request.department()
        );

        employees.add(employee);
        return employee;
    }

    public record Employee(int id, String name, String role, String department) {
    }

    public record EmployeeRequest(String name, String role, String department) {
    }
}