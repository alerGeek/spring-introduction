package pl.sda.springintroduction.service;

import pl.sda.springintroduction.model.User;

import java.util.List;

public interface UserService {

    public User create(User user);

    List<User> findAll();
}