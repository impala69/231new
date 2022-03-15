package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    public UserDAOImpl() {
    }

    @PersistenceContext
    private EntityManager entityManger;

    public List<User> index() {
        return entityManger.createQuery("FROM User ", User.class).getResultList();
    }

    @Transactional
    public User findById(int id) {
        return entityManger.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManger.persist(user);
    }

    @Transactional
    public void update(User user) {

        entityManger.merge(user);

    }

    @Transactional
    public void deleteUser(int id) {
        User nUser = entityManger.find(User.class, id);
        entityManger.remove(entityManger.merge(nUser));
    }

}