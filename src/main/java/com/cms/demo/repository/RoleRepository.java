package com.cms.demo.repository;

import com.cms.demo.model.Role;
import com.cms.demo.model.RoleType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleType roleType);
}