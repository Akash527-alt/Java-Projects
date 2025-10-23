package service;

import java.util.List;

import exception.UserNotFoundException;
import models.User;
import repositories.UserRepository;
import repositories.UserRepositoryImpl;
import services.UserService;


public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }


    @Override
    public User addUser(User user) {
        User newUser = userRepo.addUser(user);

        return newUser;
    }

    @Override
    public User findById(Long id) {
        User u = userRepo.findById(id);
        if(u == null) {
            throw new UserNotFoundException("user with given id is not available" + id);
        }
        return u;
    }

    @Override
    public List<User> listAllUsers() {
        // TODO Auto-generated method stub
        return userRepo.listAllUsers();
    }


}
