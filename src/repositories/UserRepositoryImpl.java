package repositories;

import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new  ArrayList<>();
    private Long userId = 1L;



    @Override
    public User addUser(User user) {
        if(user.getId() == null) {
            user.setId(userId);
            userId++;
        }
        users.add(user);
        return user;
    }

    @Override
    public User findById(Long id) {

        for(User user : users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }



    @Override
    public List<User> listAllUsers() {

        return users;
    }


}
