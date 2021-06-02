package com.marcos.springBootCRUDdemo.dao;

import com.marcos.springBootCRUDdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
