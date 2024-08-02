package com.scaler.taskservices.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String username;
    private String password;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}
