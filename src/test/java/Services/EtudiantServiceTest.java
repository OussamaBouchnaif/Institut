package Services;

import entity.Etudiant;
import entity.Groupe;
import entity.Niveau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class EtudiantServiceTest {

    @InjectMocks
    private EtudiantService etudiantService;

    @Mock
    private EntityManagerFactory emf;

    @Mock
    private EntityManager em;

    @Mock
    private EntityTransaction transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);


        when(emf.createEntityManager()).thenReturn(em);


        when(em.getTransaction()).thenReturn(transaction);
    }

    @Test
    void getAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant("John", "Doe", "", "", new Niveau("Niveau1", ""), new Groupe("Groupe1")));
        etudiants.add(new Etudiant("Jane", "Smith", "", "", new Niveau("Niveau2", ""), new Groupe("Groupe2")));

        TypedQuery<Etudiant> query = mock(TypedQuery.class);
        when(em.createQuery(any(String.class), eq(Etudiant.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(etudiants);

        List<Etudiant> result = etudiantService.getAllEtudiants();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getEtudiantById() {
        long etudiantId = 1L;
        Etudiant etudiant = new Etudiant("John", "Doe", "", "", new Niveau("Niveau1", ""), new Groupe("Groupe1"));
        when(em.find(Etudiant.class, etudiantId)).thenReturn(etudiant);

        Etudiant result = etudiantService.getEtudiantById(etudiantId);

        assertNotNull(result);
        assertEquals("John", result.getNom());
        assertEquals("Doe", result.getPrenom());
    }

    @Test
    void createEtudiant() {
        long niveauId = 1L;
        long groupeId = 2L;
        String nom = "John";
        String prenom = "Doe";
        String adresse = "123 Main St";
        String numtele = "555-1234";

        Niveau niveau = new Niveau("Niveau1", "Description");
        Groupe groupe = new Groupe("Groupe1");

        when(em.find(Niveau.class, niveauId)).thenReturn(niveau);
        when(em.find(Groupe.class, groupeId)).thenReturn(groupe);

        etudiantService.createEtudiant(nom, prenom, niveauId, groupeId, adresse, numtele);

        verify(em).persist(any(Etudiant.class));
        verify(transaction).commit();
    }

    @Test
    void updateEtudiant() {
        long etudiantId = 1L;
        long niveauId = 2L;
        long groupeId = 3L;
        String nom = "UpdatedName";
        String prenom = "UpdatedFirstName";

        Etudiant existingEtudiant = new Etudiant("John", "Doe", "", "", new Niveau("Niveau1", ""), new Groupe("Groupe1"));
        when(em.find(Etudiant.class, etudiantId)).thenReturn(existingEtudiant);
        when(em.find(Niveau.class, niveauId)).thenReturn(new Niveau("UpdatedNiveau", ""));
        when(em.find(Groupe.class, groupeId)).thenReturn(new Groupe("UpdatedGroupe"));

        etudiantService.updateEtudiant(etudiantId, nom, prenom, niveauId, groupeId);

        verify(em).persist(existingEtudiant);
        verify(transaction).commit();
    }


    @Test
    void deleteEtudiant() {
        long etudiantId = 1L;

        Etudiant etudiantToDelete = new Etudiant("John", "Doe", "", "", new Niveau("Niveau1", ""), new Groupe("Groupe1"));
        when(em.find(Etudiant.class, etudiantId)).thenReturn(etudiantToDelete);

        etudiantService.deleteEtudiant(etudiantId);

        verify(em).remove(etudiantToDelete);
        verify(transaction).commit();
    }
}
