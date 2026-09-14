package com.cms.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cms.demo.model.Complaint;
import com.cms.demo.model.User;
import com.cms.demo.service.ComplaintService;
import com.cms.demo.service.UserService;


@Controller
public class RedirectController {
    
    private UserService userService;
    private ComplaintService complaintService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setComplaintService(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }


    @GetMapping("/redirectAfterLogin")
    public String redirectAfterLogin(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin"; // ✅ Redirect admins to admin dashboard
        }
        return "redirect:/home"; // ✅ Redirect normal users to home page
    }

    // Home page - Shows complaints for the logged-in user
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails == null) {
            return "redirect:/login"; // Redirect if not authenticated
        }

        User user = userService.findByUsername(userDetails.getUsername());
        List<Complaint> complaints = complaintService.getUserComplaints(user);

        model.addAttribute("complaints", complaints);
        model.addAttribute("user", user);

        return "home"; // Updated home page to show complaints
    }
    
}
