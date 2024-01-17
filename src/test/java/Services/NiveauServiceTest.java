package Services;

import entity.Niveau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NiveauServiceTest {

    @InjectMocks
    private NiveauService niveauService;

    @Mock
    private EntityManagerFactory emf;

    @Mock
    private EntityManager em;

    @Mock
    private TypedQuery<Niveau> query;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllNiveaux() {

        List<Niveau> expectedNiveaux = new ArrayList<>();
        Niveau niveau1 = new Niveau("Première année", "Description 1");
        Niveau niveau2 = new Niveau("Licence 1", "Description 2");
        expectedNiveaux.add(niveau1);
        expectedNiveaux.add(niveau2);

        when(emf.createEntityManager()).thenReturn(em);
        when(em.createQuery("SELECT n FROM Niveau n", Niveau.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedNiveaux);


        List<Niveau> actualNiveaux = niveauService.getAllNiveaux();


        assertEquals(expectedNiveaux, actualNiveaux);


        verify(emf).createEntityManager();
        verify(em).createQuery("SELECT n FROM Niveau n", Niveau.class);
        verify(query).getResultList();
        verify(em).close();
    }
}
