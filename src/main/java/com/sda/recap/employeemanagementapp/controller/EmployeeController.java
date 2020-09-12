package com.sda.recap.employeemanagementapp.controller;

import com.sda.recap.employeemanagementapp.model.Employee;
import com.sda.recap.employeemanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * /api/v1/employees
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    /**
     *
     * @return
     * list of employees
     */

    @Autowired
    EmployeeRepository employeeRepository;

    /*@Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }*/

    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();

    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeRepository.findById(id).get();
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeRepository.findById(id).ifPresent(employee -> {
            employeeRepository.delete(employee);
        });
    }

    public void restoreEmployeeById(Long id) {
        employeeRepository.findById(id).ifPresent(employee -> {

        });
    }
}
