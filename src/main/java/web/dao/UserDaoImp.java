package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

//    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }


    @Override
    //   @SuppressWarnings("unchecked")
    public List<User> allUsers() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from User").list();
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(user);
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(user);
        entityManager.remove(user);

    }

    @Override
    public void edit(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(user);
        user.setName(user.getName());
        user.setLastName(user.getLastName());
        user.setName(user.getEmail());
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(User.class, id);
        return entityManager.find(User.class, id);
    }
}