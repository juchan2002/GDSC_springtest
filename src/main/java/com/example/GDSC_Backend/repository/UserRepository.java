package com.example.GDSC_Backend.repository;

import com.example.GDSC_Backend.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong(1);

    public User save(User user){
        if (user.getId() == null){
            user.setId((nextId.getAndIncrement()));
        }
        users.add(user);
        return user;
    }

    public Optional<User> findById(Long id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public List<User> findAll(){
        return new ArrayList<>(users);
    }

    public void deleteById(long id){
        users.removeIf(user -> user.getId().equals(id));
    }
}
