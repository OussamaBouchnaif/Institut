package Services;

import entity.Groupe;
import entity.Niveau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class GroupeService {
    private  static GroupeService gs = new GroupeService();
    private EntityManagerFactory emf;

    public GroupeService() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public List<Groupe> getAllGroupe() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT n FROM Groupe n", Groupe.class).getResultList();
        } finally {
            em.close();
        }
    }
}
