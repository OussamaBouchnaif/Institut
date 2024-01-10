package entity;

import jakarta.persistence.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String NomGroupe;
    private LocalDateTime dateCreation;
    @OneToMany(mappedBy = "groupe")
    private List<Etudiant> membres;
    public Groupe()
    {

    }
    public Groupe(String nomGroupe) {

        this.NomGroupe = nomGroupe;
        this.dateCreation = LocalDateTime.now();
        this.membres = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomGroupe() {
        return NomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        NomGroupe = nomGroupe;
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
