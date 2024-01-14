package Services;

import entity.Etudiant;
import entity.Paiement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PaiementService {

    private static PaiementService ps = new PaiementService();

    private EntityManagerFactory emf;

    public PaiementService()
    {
        emf = Persistence.createEntityManagerFactory("default");
    }
    public static PaiementService getPaimentService()
    {
        return ps;
    }
    public void createPaiement(long idE,float montant,String methode)
    {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Etudiant e = em.find(Etudiant.class, idE);
            if (e != null) {
                Paiement p = new Paiement(montant, methode, e);
                em.persist(p);
                em.getTransaction().commit();
            } else {

                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

    }
}
