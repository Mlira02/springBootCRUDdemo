package com.marcos.springBootCRUDdemo.rest;

import com.marcos.springBootCRUDdemo.dao.EmployeeDAO;
import com.marcos.springBootCRUDdemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
//    fields
    private EmployeeDAO employeeDAO;

//    Constructor
    public EmployeeRestController(EmployeeDAO theEmployeeDAO)
    {
        employeeDAO = theEmployeeDAO;
    }

//    Mappings
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }

    @GetMapping("/employees/{employeeId}")

}
