package com.marcos.springBootCRUDdemo.dao;

import com.marcos.springBootCRUDdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
    public List<Employee> findAll();
}
