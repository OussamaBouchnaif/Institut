package Services;

import entity.Etudiant;
import entity.Groupe;
import entity.Niveau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EtudiantService {
    private EntityManagerFactory emf;
    public EtudiantService() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public List<Etudiant> getAllEtudiants() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT n FROM Etudiant n", Etudiant.class).getResultList();
        } finally {
            em.close();
        }
    }
    public void ajouterEtudiant(String nom, String prenom, long niveauId,long groupeId) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            Niveau niveau = em.find(Niveau.class, niveauId);
            Groupe groupe = em.find(Groupe.class, groupeId);

            if (niveau != null) {
                Etudiant etudiant = new Etudiant(nom, prenom,niveau,groupe);

                em.persist(etudiant);
                em.getTransaction().commit();
            } else {
                // Gérer le cas où le niveau avec l'ID spécifié n'a pas été trouvé
                em.getTransaction().rollback();
            }

        } finally {
            em.close();
        }
    }
}
