package com.study.model;

import lombok.Data;

@Data
public class Movie {
    private int id;
    private String nameRu;
    private String nameEn;
    private int releaseYear;
    private String description;
    private double rating;
    private double price;
    private String picturePath;
}
