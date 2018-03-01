package mx.restserviceexample.restserviceexample.interfaces;

import mx.restserviceexample.restserviceexample.beans.User;

import java.util.List;

public interface IUserDAO {

    List<User> getAllUsers();

    User getUserById(Integer id);

    User getUserByUsername(String username);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
