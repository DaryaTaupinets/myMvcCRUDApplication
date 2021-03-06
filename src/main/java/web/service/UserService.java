package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    //create
    void addUser(User user);

    //read
    List<User> getAllUsers();

    User getUserById(Integer id);

    User getUserByName(String name);

    User getUserByNameAndPassword(String name, String password);

    //update
    void updateUser(User user);

    //delete
    void deleteUser(Integer id);
}
