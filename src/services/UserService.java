package services;

import java.util.List;

import models.User;

public interface UserService {

    public User addUser(User user);
    public User findById(Long id);
    public List<User> listAllUsers();
}
