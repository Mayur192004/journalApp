package com.mayur.SpringProject.services;

import com.mayur.SpringProject.entity.JournalEntry;
import com.mayur.SpringProject.entity.User;
import com.mayur.SpringProject.repository.JournalEntryRepository;
import com.mayur.SpringProject.repository.UserRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// controller ---> service ----> repository
 @Component
 @Slf4j
 public class UserService {

    @Autowired
    private UserRepository userRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public  void saveNewUser(User user){
        userRepository.save(user);
    }

    public  void saveEntry(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
    }
    public  List<User> getAllEntries(){
        return userRepository.findAll();
    }
    public Optional< User> getEntryById(ObjectId id){
        return userRepository.findById(id);
    }
    public  void deleteEntryById(ObjectId id){
        userRepository.deleteById(id);
    }
    public User findByUserName( String userName) {
        return userRepository.findByUserName(userName);
    }
}


