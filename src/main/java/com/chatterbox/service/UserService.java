package com.chatterbox.service;

import com.chatterbox.model.User;
import com.chatterbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get user by ID
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Return null if user not found
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update an existing user
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(userDetails.getUsername());
            user.setPasswordHash(userDetails.getPasswordHash());
            // Update other fields as necessary
            return userRepository.save(user);
        }
        return null; // Return null if user not found
    }

    // Delete a user by ID
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true; // User deleted successfully
        }
        return false; // User not found
    }
}
