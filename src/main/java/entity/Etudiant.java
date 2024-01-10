package entity;

import jakarta.persistence.*;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String FirstName;
    private String LastName;
    @ManyToOne
    @JoinColumn(name = "niveau_id") // le nom de la colonne qui référence l'ID du niveau dans la table des étudiants
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "groupe_id") // le nom de la colonne qui référence l'ID du niveau dans la table des étudiants
    private Groupe groupe;

    public Etudiant(String firstName, String lastName, Niveau niveau) {
        FirstName = firstName;
        LastName = lastName;
        this.niveau = niveau;
    }

    public Etudiant() {

    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
