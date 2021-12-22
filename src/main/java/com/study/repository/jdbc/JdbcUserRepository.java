package com.study.repository.jdbc;

import com.study.model.User;
import com.study.repository.UserRepository;
import com.study.repository.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;

@Repository
@AllArgsConstructor
public class JdbcUserRepository implements UserRepository {
    private static final String SELECT_USER_BY_EMAIL =
            "SELECT user_name, full_name, email, password, user_role FROM users WHERE email=:email;";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserMapper userMapper = new UserMapper();

    @Override
    public User getUserByEmail(String email) {
        return namedParameterJdbcTemplate.queryForObject(SELECT_USER_BY_EMAIL, Collections.singletonMap("email", email), userMapper);
    }
}

