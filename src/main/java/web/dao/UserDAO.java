package web.dao;

import web.model.User;

import java.util.List;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User findById(int id);
    void save(User user);
    void update(User user);
    void deleteUser(int id);
}