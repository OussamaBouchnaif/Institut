package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
}
