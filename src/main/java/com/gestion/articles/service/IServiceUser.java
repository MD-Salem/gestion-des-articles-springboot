package com.gestion.articles.service;

import com.gestion.articles.entities.User;

public interface IServiceUser {
    public User createUser(User user);
    public User findUserByUsername(String username);
    public User updateUser(User user);
    public void deleteUser(User user);
}
