package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Formateur extends Personnee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String ville;
    public Formateur(String nom, String prenom, String adresse, String numeroTelephone, String email,String ville) {
        super(nom,prenom,adresse,numeroTelephone);
        this.email = email;
        this.ville = ville;
    }
    public Formateur() {

    }


    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
