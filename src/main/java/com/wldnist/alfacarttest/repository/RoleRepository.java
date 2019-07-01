package com.wldnist.alfacarttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wldnist.alfacarttest.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
