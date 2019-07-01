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
import com.wldnist.alfacarttest.model.Role;
import com.wldnist.alfacarttest.repository.RoleRepository;

@RestController
public class RoleController {
	
	@Autowired
    private RoleRepository roleRepository;
	
	@GetMapping("/role")
    public Page<Role> getRole(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }
	
	@PostMapping("/role")
    public Role createRole(@Valid @RequestBody Role role) {
        return roleRepository.save(role);
    }
	
	@PutMapping("/role/{roleId}")
    public Role updateRole(@PathVariable Long roleId, @Valid @RequestBody Role roleRequest) {
        return roleRepository.findById(roleId)
                .map(role -> {
                    role.setRole_name(roleRequest.getRole_name());
                    return roleRepository.save(role);
                }).orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + roleId));
    }

    @DeleteMapping("/role/{roleId}")
    public ResponseEntity<?> deleteRole(@PathVariable Long roleId) {
        return roleRepository.findById(roleId)
                .map(role -> {
                    roleRepository.delete(role);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + roleId));
    }
}
