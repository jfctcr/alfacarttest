package com.wldnist.alfacarttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wldnist.alfacarttest.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

}
