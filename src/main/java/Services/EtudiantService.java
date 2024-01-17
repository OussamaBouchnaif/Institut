package Services;

import entity.Etudiant;
import entity.Groupe;
import entity.Niveau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EtudiantService {

    private EntityManagerFactory emf;

    public EtudiantService() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public List<Etudiant> getAllEtudiants() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM Etudiant e", Etudiant.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Etudiant getEtudiantById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Etudiant.class, id);
        } finally {
            em.close();
        }
    }

    public void createEtudiant(String nom, String prenom, long niveauId, long groupeId, String adress, String numtele) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Niveau niveau = em.find(Niveau.class, niveauId);
            Groupe groupe = em.find(Groupe.class, groupeId);

            if (niveau != null && groupe != null) {
                Etudiant etudiant = new Etudiant(nom, adress, numtele, prenom, niveau, groupe);

                em.persist(etudiant);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }

        } finally {
            em.close();
        }
    }

    public void updateEtudiant(long idEtudiant, String nom, String prenom, long niveauId, long groupeId) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Etudiant etudiant = em.find(Etudiant.class, idEtudiant);
            Niveau niveau = em.find(Niveau.class, niveauId);
            Groupe groupe = em.find(Groupe.class, groupeId);

            if (etudiant != null && niveau != null && groupe != null) {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setNiveau(niveau);
                etudiant.setGroupe(groupe);

                em.persist(etudiant); // Ensure to persist changes
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }

        } finally {
            em.close();
        }
    }



    public void deleteEtudiant(long id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Etudiant etudiantToDelete = em.find(Etudiant.class, id);
            if (etudiantToDelete != null) {
                em.remove(etudiantToDelete);
                em.getTransaction().commit();
                System.out.println("Étudiant supprimé avec succès !");
            } else {
                System.out.println("Étudiant non trouvé avec l'ID : " + id);
            }

        } finally {
            em.close();
        }
    }
}
