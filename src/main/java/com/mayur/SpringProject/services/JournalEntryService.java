package com.mayur.SpringProject.services;

import com.mayur.SpringProject.entity.JournalEntry;
import com.mayur.SpringProject.entity.User;
import com.mayur.SpringProject.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// controller ---> service ----> repository
 @Component
 @Slf4j
 public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    //Transactional Annotatiaon helps us to acheive atomicity that is the entire task will either be performed
//    fully or not performed
    @Transactional
    public  void saveEntry(JournalEntry journalEntry, String userName){
        try{
            User user = userService.findByUserName(userName);
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
//            user.setUserName(null);
            userService.saveEntry(user);
        }
        catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occured while saving journal entry",e);
        }
    }
    public  void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
    public  List<JournalEntry> getAllEntries(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> getEntryById(ObjectId id){
        return journalEntryRepository.findById(id);
    }
    public  void deleteEntryById(ObjectId id, String userName){
        User user=userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user); //user k entry se remove
        journalEntryRepository.deleteById(id);
    }



}


