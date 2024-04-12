package com.employeedetails.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.employeedetails.demo.model.Employee;
import com.employeedetails.demo.service.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
        Employee e=employeeService.postEmployee(employee);
        return new ResponseEntity<>(e,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> list=employeeService.getAllEmployee();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable long id) {
        Employee employee=employeeService.getById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> putEmployee(@PathVariable long id, @RequestBody Employee employee) {
        if(employeeService.putDetails(employee, id))
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long id)
    {
        if(employeeService.deleteDetails(id))
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
