 package com.mayur.SpringProject.entity;

// ------>>>>>>This is called as POJO(Plan Old Java Object )<<<<<<<<-------

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

 @Document(collection = "users")
@Data

public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @DBRef
    private List<JournalEntry> journalEntries=new ArrayList<>();
     private List<String> roles;

     public List<String> getRoles() {
         return roles;
     }

     public void setRoles(List<String> roles) {
         this.roles = roles;
     }
 }
