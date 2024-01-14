package Services;

import entity.Etudiant;
import entity.Formateur;
import entity.Groupe;
import entity.Niveau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.List;

public class FormateurService {



    private EntityManagerFactory emf;
    public FormateurService()
    {

        emf = Persistence.createEntityManagerFactory("default");
    }

    public List<Formateur> getAllFormateur() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT n FROM Formateur n", Formateur.class).getResultList();
        } finally {
            em.close();
        }
    }
    public Formateur getFormateurById( long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Formateur formateur = em.createQuery("SELECT n FROM Formateur n WHERE n.id = :id", Formateur.class).setParameter("id", id).getSingleResult();
            return  formateur;
        } finally {
            em.close();
        }
    }
    public void cerateFormateur(String nom, String prenom, String adress,String numero,String email,String ville) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Formateur f = new Formateur(nom, prenom,adress,numero,email,ville);
            em.persist(f);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
    public void updateFormateur(long idFormateur , String nom, String prenom,String adress,String numero,String email ) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Formateur f = em.find(Formateur.class,idFormateur);
            if (f != null ) {
                f.setNom(nom);
                f.setPrenom(prenom);
                f.setAdresse(adress);
                f.setNumeroTelephone(numero);
                f.setAdresse(adress);
                f.setEmail(email);

                em.persist(f);
                em.getTransaction().commit();
            } else {

                em.getTransaction().rollback();
            }

        } finally {
            em.close();
        }
    }
    public void deleteFormateur(long id)
    {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Formateur FormateurToDelete = em.find(Formateur.class, id);
            if (FormateurToDelete != null) {
                em.remove(FormateurToDelete);
                em.getTransaction().commit();
                System.out.println("Formateur supprimé avec succès !");
            } else {

                System.out.println("Formateur non trouvé avec l'ID : " + id);
            }

        } finally {
            em.close();
        }
    }
}
