package com.study.model;

import lombok.Data;

@Data
public class Review {
    private int id;
    private  String nickName;
    private String comment;
    private int movieId;
}
