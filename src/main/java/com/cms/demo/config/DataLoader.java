package com.cms.demo.config;

import com.cms.demo.model.Role;
import com.cms.demo.model.RoleType;
import com.cms.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            Role userRole = new Role();
            userRole.setName(RoleType.ROLE_USER);
            Role adminRole = new Role();
            adminRole.setName(RoleType.ROLE_ADMIN);

            roleRepository.saveAll(Arrays.asList(userRole, adminRole));
        }
    }
}
