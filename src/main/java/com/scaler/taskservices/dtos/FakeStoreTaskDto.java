package com.scaler.taskservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreTaskDto {
    private Long id;
    private String titles;
    private double price;
    private String category;
    private String description;
    private String image;
}
