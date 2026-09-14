package com.cms.demo.controller;

import com.cms.demo.dto.UserDto;
import com.cms.demo.model.Complaint;
import com.cms.demo.model.User;
import com.cms.demo.service.ComplaintService;
import com.cms.demo.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
@Secured("ROLE_ADMIN") // Ensures only admins can access
public class AdminController {

    private final UserService userService;
    private final ComplaintService complaintService;

    public AdminController(UserService userService, ComplaintService complaintService) {
        this.userService = userService;
        this.complaintService = complaintService;
    }

    @GetMapping("")
    public String selectionPage() {
        return "admin";
    }
    

    // Load the admin dashboard with all users and complaints
    @GetMapping("/dashboard")
    public String viewAdminDashboard(Model model) {
        List<UserDto> users = userService.findAllUsers();
        List<Complaint> complaints = complaintService.getAllComplaints();

        model.addAttribute("users", users);
        model.addAttribute("complaints", complaints);

        return "admin-dashboard";
    }

    // Handle complaint status update
    @PostMapping("/update-complaint-status")
    public String updateComplaintStatus(@RequestParam("complaintId") Long complaintId,
                                        @RequestParam("status") String status) {
        Complaint complaint = complaintService.getComplaintById(complaintId);
        if (complaint != null) {
            complaint.setStatus(status);
            complaintService.saveComplaint(complaint);
        }
        return "redirect:/admin/dashboard";
    }
}
