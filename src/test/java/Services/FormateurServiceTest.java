package Services;

import entity.Formateur;
import jakarta.persistence.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class FormateurServiceTest {

    @InjectMocks
    private FormateurService formateurService;

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
    void getAllFormateur() {
        List<Formateur> formateurs = new ArrayList<>();
        formateurs.add(new Formateur("John", "Doe", "", "", "john@example.com", "City1"));
        formateurs.add(new Formateur("Jane", "Smith", "", "", "jane@example.com", "City2"));

        TypedQuery<Formateur> query = mock(TypedQuery.class);
        when(em.createQuery(any(String.class), eq(Formateur.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(formateurs);

        List<Formateur> result = formateurService.getAllFormateur();

        assertNotNull(result);
        assertEquals(2, result.size());
    }



    @Test
    void cerateFormateur() {
        String nom = "John";
        String prenom = "Doe";
        String adresse = "123 Main St";
        String numero = "555-1234";
        String email = "john@example.com";
        String ville = "City1";

        formateurService.cerateFormateur(nom, prenom, adresse, numero, email, ville);

        verify(em).persist(any(Formateur.class));
        verify(transaction).commit();
    }

    @Test
    void updateFormateur() {
        long idFormateur = 1L;
        String nom = "NewName";
        String prenom = "NewPrenom";
        String adress = "NewAddress";
        String numero = "NewNumber";
        String email = "newemail@example.com";

        Formateur f = new Formateur();
        f.setId(idFormateur);


        when(em.find(Formateur.class, idFormateur)).thenReturn(f);


        formateurService.updateFormateur(idFormateur, nom, prenom, adress, numero, email);


        verify(em).persist(f);

        verify(transaction).begin();

        verify(transaction).commit();

        verify(em).close();


        assertEquals(nom, f.getNom());
        assertEquals(prenom, f.getPrenom());
        assertEquals(adress, f.getAdresse());
        assertEquals(numero, f.getNumeroTelephone());
        assertEquals(email, f.getEmail());

    }

    @Test
    void deleteFormateur() {
        long formateurId = 1L;

        Formateur formateurToDelete = new Formateur("John", "Doe", "", "", "john@example.com", "City1");
        when(em.find(Formateur.class, formateurId)).thenReturn(formateurToDelete);

        formateurService.deleteFormateur(formateurId);

        verify(em).remove(formateurToDelete);
        verify(transaction).commit();
    }
}
