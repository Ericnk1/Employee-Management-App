package com.sda.recap.employeemanagementapp.controller;

import com.sda.recap.employeemanagementapp.exception.EmployeeNotFoundException;
import com.sda.recap.employeemanagementapp.model.Employee;
import com.sda.recap.employeemanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// @CrossOrigin(origins = "https://employee-management-app-ang.herokuapp.com/")
@RestController
@RequestMapping("https://employee-management-app-ang.herokuapp.com/")
public class EmployeeController {


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
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    /*@PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }*/

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
        Employee oldEmployee = getEmployee(id);
        if (oldEmployee != null) {
            employeeRepository.delete(oldEmployee);
            employeeRepository.save(newEmployee);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        if (getEmployee(id) == null){
            throw new EmployeeNotFoundException();
        }else {
            employeeRepository.deleteById(id);
        }
        /*employeeRepository.findById(id).ifPresent(employee -> {
            employeeRepository.delete(employee);
        });*/
    }
}
