package web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        log.info("User is successfully saved. User details: " + user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserById(Integer id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        return sessionFactory.getCurrentSession().get(User.class, name);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByNameAndPassword(String name, String password) {
        User userLogin = null;
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where name = :paramName");
        query.setParameter("paramName", name);
        List<User> users = query.getResultList();
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                userLogin = user;
            }
        }
        return userLogin;
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        log.info("User is successfully update. User details: " + user);
    }

    @Override
    public void deleteUser(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        if (user != null) {
            session.delete(user);
        }
        log.info("User is successfully delete. User details: " + user);
    }
}
