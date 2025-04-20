package com.gestion.articles.service;


import com.gestion.articles.entities.User;
import com.gestion.articles.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser implements IServiceUser {

    private final UserRepository userRepository;

    public ServiceUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
