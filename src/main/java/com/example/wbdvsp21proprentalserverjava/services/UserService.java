package com.example.wbdvsp21proprentalserverjava.services;

import com.example.wbdvsp21proprentalserverjava.dtos.UserDTO;
import com.example.wbdvsp21proprentalserverjava.exceptions.users.UserDoesNotExistException;
import com.example.wbdvsp21proprentalserverjava.models.User;
import com.example.wbdvsp21proprentalserverjava.models.UserAuth;
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

    public User fetchUserByUsername(String username) {
        return repository.findUserByUserAuth_Username(username);
    }

    public List<User> fetchAllUsers() {
        return (List<User>) repository.findAll();
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    private User buildUpdatedUser(User user, UserDTO userDTO) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
        user.setUserType(userDTO.getUserType());
        UserAuth updatedAuth = user.getUserAuth();
        updatedAuth.setUsername(userDTO.getUsername());
        updatedAuth.setPwd(userDTO.getPwd());
        user.setUserAuth(updatedAuth);
        return user;
    }

    public User updateUser(UserDTO user, int userId) {
        Optional<User> toBeUpdated = this.repository.findById(userId);
        if (!toBeUpdated.isPresent()) {
            throw new UserDoesNotExistException("The user to be deleted does not exist!");
        }

        return this.repository.save(buildUpdatedUser(toBeUpdated.get(), user));
    }

    public User checkIfExistsAndAuthenticate(String username, String password) {
        User foundUser = this.fetchUserByUsername(username);
        if (foundUser != null) {
            if (foundUser.getUserAuth().getPwd().equals(password)) {
                return foundUser;
            }
        }
        return null;
    }

    public void deleteUser(int userId) {
        Optional<User> toBeDeleted = repository.findById(userId);
        if (!toBeDeleted.isPresent()) {
            throw new IllegalArgumentException("User to be deleted does not exist!");
        }
        repository.delete(toBeDeleted.get());
    }
}
