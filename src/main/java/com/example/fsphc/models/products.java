package com.example.fsphc.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class products {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private category category;
    private String image;
}
