package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float montant;
    private LocalDateTime datePaiement;
    private String methode;

    @ManyToOne
    @JoinColumn(name = "etudiant_id") // le nom de la colonne qui référence l'ID du niveau dans la table des étudiants
    private Etudiant etudiant;
    public Paiement()
    {

    }
    public Paiement(float montant, String methode, Etudiant etudiant) {

        this.montant = montant;
        this.datePaiement = LocalDateTime.now();
        this.methode = methode;
        this.etudiant = etudiant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
