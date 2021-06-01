package com.marcos.springBootCRUDdemo.dao;

import com.marcos.springBootCRUDdemo.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDAOJpaImpl implements EmployeeDAO
{
    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        return null;
    }

    @Override
    public Employee findById(int employeeId)
    {
        return null;
    }

    @Override
    public void save(Employee theEmployee)
    {

    }

    @Override
    public void deleteById(int employeeId)
    {

    }
}
