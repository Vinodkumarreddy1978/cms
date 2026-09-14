package com.cms.demo.service;

import com.cms.demo.model.Complaint;
import com.cms.demo.model.User;
import com.cms.demo.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public List<Complaint> getUserComplaints(User user) {
        return complaintRepository.findByUser(user);
    }

    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints(){
        return complaintRepository.findAll();
    }

    public Complaint getComplaintById(Long id){
        return complaintRepository.findById(id).get();
    }
}
