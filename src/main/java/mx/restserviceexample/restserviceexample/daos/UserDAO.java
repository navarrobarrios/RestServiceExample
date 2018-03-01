package mx.restserviceexample.restserviceexample.daos;

import java.util.List;

import mx.restserviceexample.restserviceexample.beans.User;
import mx.restserviceexample.restserviceexample.interfaces.IUserDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public User getUserById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        String query = "FROM User where username = '" + username+"'";
        List<User> users = entityManager.createQuery(query).getResultList();
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        if(user == null || user.getUsername() != null)
            return;
        User userToUpdate = getUserById(user.getId());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setName(user.getName());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setAge(user.getAge());
        entityManager.flush();
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }
}
