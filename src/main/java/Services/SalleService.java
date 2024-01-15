package Services;

import entity.Niveau;
import entity.Salle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class SalleService {

    private EntityManagerFactory emf;

    public SalleService() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public List<Salle> getAllSalle() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT n FROM Salle n", Salle.class).getResultList();
        } finally {
            em.close();
        }
    }
}
