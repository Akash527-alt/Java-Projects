package repositories;

import java.util.List;

import models.User;

public interface UserRepository {

    public User addUser(User user);
    public User findById(Long id);
    public List<User> listAllUsers();

}
