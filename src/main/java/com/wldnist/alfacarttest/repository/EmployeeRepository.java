package com.wldnist.alfacarttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wldnist.alfacarttest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
