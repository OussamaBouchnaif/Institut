package Services;

import entity.Niveau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
public class NiveauService {
    private  static NiveauService ns = new NiveauService();
    private EntityManagerFactory emf;
    public static NiveauService GetNiveauService()
    {
        return ns;
    }
    private NiveauService() {
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
