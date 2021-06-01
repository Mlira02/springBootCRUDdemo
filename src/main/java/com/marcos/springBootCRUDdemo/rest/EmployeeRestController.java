package com.marcos.springBootCRUDdemo.rest;

import com.marcos.springBootCRUDdemo.dao.EmployeeDAO;
import com.marcos.springBootCRUDdemo.entity.Employee;
import com.marcos.springBootCRUDdemo.service.EmployeeService;
import com.marcos.springBootCRUDdemo.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
//    fields

    private EmployeeService employeeService;

//    Constructor
    public EmployeeRestController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

//    Mappings
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null)
        {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        employeeService.save(theEmployee);

        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null)
        {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        System.out.println(tempEmployee);
        return "Deleted employee with id: " + employeeId;
    }
}