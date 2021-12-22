package com.study.repository;

import com.study.model.User;

public interface UserRepository {
    User getUserByEmail(String email);
}
