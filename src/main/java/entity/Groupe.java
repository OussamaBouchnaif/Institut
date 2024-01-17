package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomGroupe; // changed from NomGroupe to nomGroupe

    private LocalDateTime dateCreation;

    @OneToMany(mappedBy = "groupe")
    private List<Etudiant> membres;

    public Groupe() {
        this.dateCreation = LocalDateTime.now();
        this.membres = new ArrayList<>();
    }

    public Groupe(String nomGroupe) {
        this();
        this.nomGroupe = nomGroupe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Etudiant> getMembres() {
        return membres;
    }

    public void setMembres(List<Etudiant> membres) {
        this.membres = membres;
    }
}
