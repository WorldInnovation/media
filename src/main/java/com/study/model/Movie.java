package com.study.model;

import lombok.Data;

@Data
public class Movie {
    private int id;
    private String nameRu;
    private String nameEn;
    private int releaseYear;
    private String genre;
    private String desription;
    private double rating;
    private double price;
    private String picturePath;
}
