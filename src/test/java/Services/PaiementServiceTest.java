package Services;

import entity.Etudiant;
import entity.Paiement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PaiementServiceTest {

    @InjectMocks
    private PaiementService paiementService;

    @Mock
    private EntityManagerFactory emf;

    @Mock
    private EntityManager em;

    @Mock
    private TypedQuery<Paiement> query;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPaimentService() {
        // Arrange
        List<Paiement> expectedPaiements = new ArrayList<>();
        Paiement paiement1 = new Paiement();
        Paiement paiement2 = new Paiement();
        expectedPaiements.add(paiement1);
        expectedPaiements.add(paiement2);

        when(emf.createEntityManager()).thenReturn(em);
        when(em.createQuery("SELECT p FROM Paiement p", Paiement.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedPaiements);

        List<Paiement> actualPaiements = paiementService.getPaimentService();

        assertEquals(expectedPaiements, actualPaiements);

        verify(emf).createEntityManager();
        verify(em).createQuery("SELECT p FROM Paiement p", Paiement.class);
        verify(query).getResultList();
        verify(em).close();
    }

    @Test
    void testCreatePaiement() {

        long etudiantId = 1L;
        float montant = 100.0f;
        String methode = "Credit Card";

        Etudiant etudiant = new Etudiant();

        when(emf.createEntityManager()).thenReturn(em);
        jakarta.persistence.EntityTransaction transaction = Mockito.mock(jakarta.persistence.EntityTransaction.class);
        when(em.getTransaction()).thenReturn(transaction);
        when(em.find(Etudiant.class, etudiantId)).thenReturn(etudiant);


        paiementService.createPaiement(etudiantId, montant, methode);


        InOrder inOrder = inOrder(emf, em, transaction);
        inOrder.verify(emf).createEntityManager();
        inOrder.verify(em).getTransaction();
        inOrder.verify(transaction).begin();
        inOrder.verify(em).find(Etudiant.class, etudiantId);
        ArgumentCaptor<Paiement> paiementCaptor = ArgumentCaptor.forClass(Paiement.class);
        inOrder.verify(em).persist(paiementCaptor.capture());
        inOrder.verify(transaction).commit();
        inOrder.verify(em).close();


        Paiement createdPaiement = paiementCaptor.getValue();
        assertEquals(montant, createdPaiement.getMontant());
        assertEquals(methode, createdPaiement.getMethode());
        assertEquals(etudiant, createdPaiement.getEtudiant());
        assertNotNull(createdPaiement.getDatePaiement());
    }
}
