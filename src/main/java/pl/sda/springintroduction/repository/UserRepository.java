package pl.sda.springintroduction.repository;

import pl.sda.springintroduction.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public User save(User user);

    public boolean existById(long userId);

    List<User> findAll();

    Optional<User> findById(long userId);
}