package com.exampl.controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampl.repository.AdminRepository;
import entity.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public AdminController(AdminRepository adminRepository, BCryptPasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }


//        @GetMapping("/register")
//    public String showAdminRegisterForm(Model model) {
//        model.addAttribute("admin", new Admin());
//        return "admin-register";
//    }

//    @PostMapping("/register")
//    public String registerAdmin(@ModelAttribute Admin admin) {
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//        admin.setRole("ROLE_ADMIN");
//        adminRepository.save(admin);
//        return "redirect:/login";
//    }
    
//    JSON .....
    
    @GetMapping("/")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    
        @PostMapping("/")
        public String registerAdmin(@RequestBody Admin admin) {
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            admin.setRole("ROLE_ADMIN");
            adminRepository.save(admin);
            return "Admin '" + admin.getUsername() + "' registered successfully!";
        
        }
    }


