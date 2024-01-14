package Services;

import entity.Etudiant;
import entity.Groupe;
import entity.Niveau;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.List;
@ApplicationScoped
public class EtudiantService {


    private EntityManagerFactory emf ;
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
    public Etudiant getEtudiantById( long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Etudiant e = em.createQuery("SELECT n FROM Etudiant n WHERE n.id = :id", Etudiant.class).setParameter("id", id).getSingleResult();
            return  e;
        } finally {
            em.close();
        }
    }
    public void cerateEtudiant(String nom, String prenom, long niveauId,long groupeId,String adress,String numtele) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            Niveau niveau = em.find(Niveau.class, niveauId);
            Groupe groupe = em.find(Groupe.class, groupeId);

            if (niveau != null && groupe != null) {
                Etudiant etudiant = new Etudiant(nom,adress,numtele ,prenom,niveau,groupe);

                em.persist(etudiant);
                em.getTransaction().commit();
            } else {

                em.getTransaction().rollback();
            }

        } finally {
            em.close();
        }
    }
    public void updateEtudiant(long idEtudiant , String nom, String prenom, long niveauId,long groupeId) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Etudiant etudiant = em.find(Etudiant.class,idEtudiant);
            Niveau niveau = em.find(Niveau.class,niveauId);
            Groupe groupe = em.find(Groupe.class,groupeId);

            if (etudiant != null ) {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setNiveau(niveau);
                etudiant.setGroupe(groupe);

                em.persist(etudiant);
                em.getTransaction().commit();
            } else {

                em.getTransaction().rollback();
            }

        } finally {
            em.close();
        }
    }
    public void deleteEtudiant(long id)
    {
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
