package entity;

import jakarta.persistence.*;

@Entity

public class Etudiant extends Personnee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

    public Etudiant(String firstName, String lastName,String adress,String numtele, Niveau niveau,Groupe groupe) {
        super(firstName,lastName,adress,numtele);
        this.niveau = niveau;
        this.groupe = groupe;
    }

    public Etudiant() {
        super();
    }
    public Long getId()
    {
        return this.id;
    }
    public String getNiveau() {
        return niveau.getNomNiveau();
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public String getGroupe() {
        return groupe.getNomGroupe();
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }






}
