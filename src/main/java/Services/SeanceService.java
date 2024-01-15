package Services;

import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

public class SeanceService {

    private EntityManagerFactory  emf;


    public SeanceService()
    {

        this.emf = Persistence.createEntityManagerFactory("default");

    }

    public List<Seance> getAllSeance()
    {
        EntityManager e = emf.createEntityManager();
        try {
            return e.createQuery("select n from Seance n",Seance.class).getResultList();
        }finally {
            e.close();
        }
    }
    public Seance getSeanceById( long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Seance s = em.createQuery("SELECT n FROM Seance n WHERE n.id = :id", Seance.class).setParameter("id", id).getSingleResult();
            return  s;
        } finally {
            em.close();
        }
    }
    public void createSeance(Long idGroupe, Long idSalle , Long idFormateur, LocalDateTime dateDebut, LocalDateTime dateFin)
    {
        EntityManager e = emf.createEntityManager();
        try {
            e.getTransaction().begin();

            Groupe g = e.find(Groupe.class,idGroupe);
            Formateur f = e.find(Formateur.class,idFormateur);
            Salle s = e.find(Salle.class,idSalle);
            if(g != null && f != null && s != null)
            {
                Seance seance = new Seance();
                seance.setSalle(s);
                seance.setFormateur(f);
                seance.setGroupe(g);
                seance.setDateDebut(dateDebut);
                seance.setDateFin(dateFin);
                e.persist(seance);
                e.getTransaction().commit();
            }else
            {
                e.getTransaction().rollback();
            }


        }finally {
            e.close();
        }
    }
    public void updateSeance(Long idSeance,Long idGroupe, Long idSalle , Long idFormateur, LocalDateTime dateDebut, LocalDateTime dateFin)
    {
        EntityManager e = emf.createEntityManager();
        try {
            e.getTransaction().begin();
            Groupe g = e.find(Groupe.class,idGroupe);
            Formateur f = e.find(Formateur.class,idFormateur);
            Salle s = e.find(Salle.class,idSalle);
            Seance seance = e.find(Seance.class,idSeance);

            if(g != null && f != null && s != null)
            {
                seance.setSalle(s);
                seance.setFormateur(f);
                seance.setGroupe(g);
                seance.setDateDebut(dateDebut);
                seance.setDateFin(dateFin);
                e.persist(seance);
                e.getTransaction().commit();
            }else
            {
                e.getTransaction().rollback();
            }
        }finally {
            e.close();
        }
    }

    public void delete(Long id)
    {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Seance seance = em.find(Seance.class, id);
            if (seance != null) {
                em.remove(seance);
                em.getTransaction().commit();
                System.out.println("seance supprimé avec succès !");
            } else {

                System.out.println("seance non trouvé avec l'ID : " + id);
            }

        } finally {
            em.close();
        }
    }





}
