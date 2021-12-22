package com.study.model;

import lombok.Data;

@Data
public class User {
    private String nickName;
    private String fullName;
    private String email;
    private String password;
    private UserRole userRole;
}
