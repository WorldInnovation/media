create table USERS
(
  USER_NAME VARCHAR(255) PRIMARY KEY,
  FULL_NAME VARCHAR(255) NOT NULL,
  EMAIL VARCHAR(255) UNIQUE NOT NULL
);