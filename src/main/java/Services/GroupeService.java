package Services;

import entity.Groupe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDateTime;
import java.util.List;

public class GroupeService {

    private static final GroupeService gs = new GroupeService();
    private EntityManagerFactory emf;

    public GroupeService() {
        this.emf = emf;
    }

    public static GroupeService getInstance() {
        return gs;
    }

    public List<Groupe> getAllGroupes() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT g FROM Groupe g", Groupe.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void createGroupe(String nomGroupe, LocalDateTime dateCreation) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Groupe groupe = new Groupe(nomGroupe);
            em.persist(groupe);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
