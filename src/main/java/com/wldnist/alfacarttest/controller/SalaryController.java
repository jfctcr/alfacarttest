package com.wldnist.alfacarttest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wldnist.alfacarttest.exception.ResourceNotFoundException;
import com.wldnist.alfacarttest.model.Salary;
import com.wldnist.alfacarttest.repository.SalaryRepository;

@RestController
public class SalaryController {
	
	@Autowired
    private SalaryRepository salaryRepository;
		
	@GetMapping("/salary")
    public Page<Salary> getSalary(Pageable pageable) {
        return salaryRepository.findAll(pageable);
    }
	
	@PostMapping("/salary")
    public Salary createSalary(@Valid @RequestBody Salary salary) {
        return salaryRepository.save(salary);
    }
	
	@PutMapping("/salary/{salaryId}")
    public Salary updateSalary(@PathVariable Long salaryId, @Valid @RequestBody Salary salaryRequest) {
        return salaryRepository.findById(salaryId)
                .map(salary -> {
                	salary.setSalary(salaryRequest.getSalary());
                	salary.setEmployee_id(salaryRequest.getEmployee_id());
                    return salaryRepository.save(salary);
                }).orElseThrow(() -> new ResourceNotFoundException("Salary not found with id " + salaryId));
    }

    @DeleteMapping("/salary/{salaryId}")
    public ResponseEntity<?> deleteSalary(@PathVariable Long salaryId) {
        return salaryRepository.findById(salaryId)
                .map(salary -> {
                	salaryRepository.delete(salary);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Salary not found with id " + salaryId));
    }
}
