package Services;

import entity.Etudiant;
import entity.Groupe;
import entity.Paiement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PaiementService {

    private static PaiementService ps = new PaiementService();

    private EntityManagerFactory emf;

    public PaiementService()
    {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public List<Paiement> getPaimentService() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Paiement p", Paiement.class).getResultList();
        } finally {
            em.close();
        }
    }


    public List<Paiement> getAllPaiement()
    {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT g FROM Paiement g ", Paiement.class).getResultList();
        } finally {
            em.close();
        }
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
