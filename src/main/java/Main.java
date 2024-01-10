import entity.Etudiant;
import entity.Groupe;
import entity.Niveau;
import entity.Paiement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Groupe g = new Groupe("ga");
        Niveau n = new Niveau("a1","scqscqdc");

        Etudiant e = new Etudiant();
        e.setFirstName("oussama");
        e.setLastName("bouchnaif");
        e.setGroupe(g);
        e.setNiveau(n);
        Paiement p = new Paiement(17,"pypal",e);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(n);
        em.persist(g);
        em.persist(e);
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
