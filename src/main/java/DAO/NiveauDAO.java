package DAO;

import entity.Niveau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
public class NiveauDAO {

    private EntityManagerFactory emf;

    public NiveauDAO() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public  List<Niveau> getAllNiveaux() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT n FROM Niveau n", Niveau.class).getResultList();
        } finally {
            em.close();
        }
    }
}
