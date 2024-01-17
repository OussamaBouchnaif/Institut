package Services;

import entity.Groupe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GroupeServiceTest {

    @InjectMocks
    private GroupeService groupeService;

    @Mock
    private EntityManagerFactory emf;

    @Mock
    private EntityManager em;

    @Mock
    private TypedQuery<Groupe> query;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllGroupes() {

        List<Groupe> expectedGroupes = new ArrayList<>();
        when(emf.createEntityManager()).thenReturn(em);
        when(em.createQuery("SELECT g FROM Groupe g", Groupe.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedGroupes);


        List<Groupe> actualGroupes = groupeService.getAllGroupes();


        assertEquals(expectedGroupes, actualGroupes);


        verify(emf).createEntityManager();
        verify(em).createQuery("SELECT g FROM Groupe g", Groupe.class);
        verify(query).getResultList();
        verify(em).close();
    }

    @Test
    void testCreateGroupe() {
        // Arrange
        String nomGroupe = "TestGroup";
        LocalDateTime dateCreation = LocalDateTime.now();
        when(emf.createEntityManager()).thenReturn(em);
        jakarta.persistence.EntityTransaction transaction = Mockito.mock(jakarta.persistence.EntityTransaction.class);
        when(em.getTransaction()).thenReturn(transaction);


        groupeService.createGroupe(nomGroupe, dateCreation);

        // Verif
        InOrder inOrder = inOrder(emf, em, transaction);
        inOrder.verify(emf).createEntityManager();
        inOrder.verify(em).getTransaction();
        inOrder.verify(transaction).begin();
        inOrder.verify(em).persist(any(Groupe.class));
        inOrder.verify(transaction).commit();
        inOrder.verify(em).close();
    }

}
