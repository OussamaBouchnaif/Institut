package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Niveau {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomNiveau; // Nom du niveau (par exemple, "Première année", "Licence 1", etc.)

    private String description;
    public Niveau(){

    }
    public Niveau( String nomNiveau, String description) {

        this.nomNiveau = nomNiveau;
        this.description = description;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomNiveau() {
        return nomNiveau;
    }

    public void setNomNiveau(String nomNiveau) {
        this.nomNiveau = nomNiveau;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
