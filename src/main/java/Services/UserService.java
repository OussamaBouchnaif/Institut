package Services;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class UserService {

    private EntityManagerFactory emf;

    public UserService() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public User getUserById(Long userId) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(User.class, userId);
        } finally {
            em.close();
        }
    }
    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        } finally {
            em.close();
        }
    }
    public User getUserByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.Email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            // Handle exceptions (e.g., NoResultException for no matching user)
            return null;
        } finally {
            em.close();
        }
    }

    public User authenticateUser(String email, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.Email = :email AND u.password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            // Handle exceptions (e.g., NoResultException for invalid credentials)
            return null;
        } finally {
            em.close();
        }
    }

    public void createUser(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deleteUser(Long userId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void closeEntityManagerFactory() {
        emf.close();
    }
}
