package com.marcos.springBootCRUDdemo.dao;

import com.marcos.springBootCRUDdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO
{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        Query theQuery = entityManager.createQuery("from Employee");

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int employeeId)
    {
        Employee theEmployee = entityManager.find(Employee.class, employeeId);

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee)
    {
        Employee dbEmployee = entityManager.merge(theEmployee);

        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int employeeId)
    {
        Query theQuery = entityManager.createQuery("delete from Employee where id =: employeeId");

        theQuery.setParameter("employeeId", employeeId);

        theQuery.executeUpdate();
    }
}