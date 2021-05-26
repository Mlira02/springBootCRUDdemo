package com.marcos.springBootCRUDdemo.service;

import com.marcos.springBootCRUDdemo.dao.EmployeeDAO;
import com.marcos.springBootCRUDdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int employeeId)
    {
        return employeeDAO.findById(employeeId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee)
    {
        employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int employeeId)
    {
        employeeDAO.deleteById(employeeId);
    }
}
