package com.employeedetails.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeedetails.demo.model.Employee;
import com.employeedetails.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee postEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }
    public Employee getById(long id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
    public List<Employee> getAllEmployee()
    {
        return employeeRepo.findAll();
    }
    public boolean putDetails(Employee employee,long id)
    {
        if(this.getById(id)==null)
        {
            return false;
        }
        employeeRepo.save(employee);
        return true;
    }
    public boolean deleteDetails(long id)
    {
        if(this.getById(id)==null)
        {
            return false;
        }
        employeeRepo.deleteById(id);
        return true;
    }
}
