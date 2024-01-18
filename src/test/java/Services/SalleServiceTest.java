package Services;

import entity.Salle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class SalleServiceTest {

    @InjectMocks
    private SalleService salleService;

    @Mock
    private EntityManagerFactory emf;

    @Mock
    private EntityManager em;

    @Mock
    private TypedQuery<Salle> query;

    @Mock
    private EntityTransaction transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllSalle() {
        // Arrange
        List<Salle> expectedSalles = new ArrayList<>();
        Salle salle1 = new Salle(/* Set the necessary properties */);
        Salle salle2 = new Salle(/* Set the necessary properties */);
        expectedSalles.add(salle1);
        expectedSalles.add(salle2);

        when(emf.createEntityManager()).thenReturn(em);
        when(em.createQuery("SELECT n FROM Salle n", Salle.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedSalles);

        // Act
        List<Salle> actualSalles = salleService.getAllSalle();

        // Assert
        assertEquals(expectedSalles, actualSalles);

        // Verify
        verify(emf).createEntityManager();
        verify(em).createQuery("SELECT n FROM Salle n", Salle.class);
        verify(query).getResultList();
        verify(em).close();
    }

    @Test
    void testGetSalleById() {
        // Arrange
        long salleId = 1L;
        Salle expectedSalle = new Salle("Salle A", 50); // Provide proper data for the constructor

        // Mocking behavior for createEntityManager
        when(emf.createEntityManager()).thenReturn(em);

        // Mocking behavior for createQuery
        when(em.createQuery("SELECT n FROM Salle n WHERE n.id = :id", Salle.class)).thenReturn(query);

        // Mocking behavior for setParameter
        when(query.setParameter("id", salleId)).thenReturn(query);

        // Mocking behavior for getResultList
        when(query.getResultList()).thenReturn(List.of(expectedSalle));

        // Act
        Salle actualSalle = salleService.getsalletById(salleId);

        // Assert
        assertEquals(expectedSalle, actualSalle);

        // Verify
        verify(emf).createEntityManager();
        verify(em).createQuery("SELECT n FROM Salle n WHERE n.id = :id", Salle.class);
        verify(query).setParameter("id", salleId);
        verify(query).getResultList();
        verify(em).close();
    }



    @Test
    void testCreateSalle() {
        // Arrange
        int capacite = 50;
        String nomSalle = "Salle A";

        // Mocking behavior for createEntityManager
        when(emf.createEntityManager()).thenReturn(em);

        // Mocking behavior for createNativeQuery
        when(em.createNativeQuery(anyString())).thenReturn(query);

        // Mocking behavior for getTransaction
        when(em.getTransaction()).thenReturn(transaction);

        // Mocking behavior for setParameter
        when(query.setParameter(anyInt(), any())).thenReturn(query);

        // Act
        salleService.cerateSalle(capacite, nomSalle);

        // Verify
        InOrder inOrder = inOrder(emf, em, transaction, query);
        inOrder.verify(emf).createEntityManager();
        inOrder.verify(em).getTransaction();
        inOrder.verify(transaction).begin();
        inOrder.verify(em).createNativeQuery(anyString());
        inOrder.verify(query).setParameter(1, nomSalle);
        inOrder.verify(query).setParameter(2, capacite);
        inOrder.verify(query).executeUpdate();
        inOrder.verify(transaction).commit();
        inOrder.verify(em).close();
    }


}
