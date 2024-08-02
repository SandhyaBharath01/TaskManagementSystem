package com.scaler.taskservices.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Task extends BaseModel {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Long priority;

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference
@ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
