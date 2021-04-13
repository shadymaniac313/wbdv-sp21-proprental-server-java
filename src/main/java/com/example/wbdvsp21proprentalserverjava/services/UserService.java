package com.example.wbdvsp21proprentalserverjava.services;

import com.example.wbdvsp21proprentalserverjava.models.User;
import com.example.wbdvsp21proprentalserverjava.repositiories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User fetchUserById(int userId) {
        return repository.findById(userId).get();
    }

    public List<User> fetchAllUsers() {
        return (List<User>) repository.findAll();
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(int userId) {
        Optional<User> toBeDeleted  = repository.findById(userId);
        if(!toBeDeleted.isPresent())
                throw new IllegalArgumentException("User to be deleted does not exist!");
        repository.delete(toBeDeleted.get());
    }
}
