package com.cms.demo.controller;

import com.cms.demo.model.Complaint;
import com.cms.demo.model.User;
import com.cms.demo.service.ComplaintService;
import com.cms.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String viewComplaints(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        List<Complaint> complaints = complaintService.getUserComplaints(user);
        model.addAttribute("complaints", complaints);
        return "redirect:/home";  // Returns home page with complaints
    }

    @GetMapping("/add")
    public String showAddComplaintForm(Model model) {
        model.addAttribute("complaint", new Complaint());
        return "add-complaint"; // Returns add complaint form
    }

    @PostMapping("/add")
    public String submitComplaint(@AuthenticationPrincipal UserDetails userDetails, 
                                  @ModelAttribute Complaint complaint) {
        // Ensure userDetails is not null
        if (userDetails == null) {
            return "redirect:/login";
        }
    
        User user = userService.findByUsername(userDetails.getUsername());
        
        if (user == null) {
            throw new RuntimeException("Authenticated user not found in the database.");
        }
        complaint.setUser(user);
        complaintService.saveComplaint(complaint);
        return "redirect:/home"; // Redirect to complaints page
    }
}
