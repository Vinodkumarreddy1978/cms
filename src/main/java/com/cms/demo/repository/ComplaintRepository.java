package com.cms.demo.repository;

import com.cms.demo.model.Complaint;
import com.cms.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByUser(User user); // Fetch complaints by user
}
