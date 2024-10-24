package com.chatterbox.controller;

import com.chatterbox.model.User;
import com.chatterbox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";  // This will serve the register.html
    }

    // Handle the registration form submission with POST
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        // Handle registration logic here
        return "redirect:/";  // Redirect to homepage after registration
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This should resolve to a login.html or login.jsp page in your templates
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        // Login logic
        return "redirect:/index"; // Redirect to another page on successful login
    }


    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
