package pl.sda.springintroduction.repository;

import org.springframework.stereotype.Repository;
import pl.sda.springintroduction.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryListImpl implements UserRepository {

    private final List<User> users = new ArrayList<>();
    private long lastId = 0;

    @Override
    public User save(User user) {
        lastId += 1;
        user.setId(lastId);
        users.add(user);
        return user;
    }

    @Override
    public boolean existById(long userId) {
        return users.stream()
                .anyMatch(user -> userId == user.getId());
    }

    @Override
    public Optional<User> findById(long userId) {
        return users.stream()
                .filter(user -> userId == user.getId())
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}