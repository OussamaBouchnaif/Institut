package Services;

import entity.Etudiant;
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
    public Salle getsalletById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Salle> result = em.createQuery("SELECT n FROM Salle n WHERE n.id = :id", Salle.class)
                    .setParameter("id", id)
                    .getResultList();

            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }
    public void cerateSalle(int capacite,String nomSalle ){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.createNativeQuery("INSERT INTO Salle (NOMSALLE, CAPACITE) VALUES (?, ?)").setParameter(1,nomSalle).setParameter(2,capacite).executeUpdate();

            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
    public void updateSalle(long id, String nomSalle, int capacite) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.createNativeQuery("UPDATE Salle SET NOMSALLE = ?, CAPACITE = ? WHERE id = ?")
                    .setParameter(1, nomSalle)
                    .setParameter(2, capacite)
                    .setParameter(3, id)
                    .executeUpdate();

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public void deleteSalle(long id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.createNativeQuery("DELETE FROM Salle WHERE id = ?")
                    .setParameter(1, id)
                    .executeUpdate();

            em.getTransaction().commit();
            System.out.println("Salle supprimée avec succès !");
        } finally {
            em.close();
        }
    }

}
