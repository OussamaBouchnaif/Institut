import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Groupe g = new Groupe("ga");
        Niveau n = new Niveau("a1","scqscqdc");

        User u = new User("oussam","bouch","adress","654623","email","123");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
