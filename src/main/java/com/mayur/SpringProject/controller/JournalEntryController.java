//package com.mayur.SpringProject.controller;
//
//import com.mayur.SpringProject.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//    private Map<ObjectId, JournalEntry> journalEntries=new HashMap<>();
//
//    @GetMapping("/abc")
//    public List<JournalEntry> getJournalEntries(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry journalEntry){
//        journalEntries.put(journalEntry.getId(), journalEntry);
//        return true;
//    }
//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntry(@PathVariable ObjectId myId){
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteEntry(@PathVariable Long myId){
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("id/{myId}")
//    public JournalEntry updateEntry(@PathVariable String myId, @RequestBody JournalEntry journalEntry){
//        journalEntries.put(myId, journalEntry);
//        return journalEntries.get(myId);
//
//    }
//
//
//}
