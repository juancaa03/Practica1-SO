/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Botiga {
    @SequenceGenerator(name="Botiga_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Botiga_Gen")
    @Id
    private Long Id;
    private String nom;
    private String adreca;
    
    @ManyToOne
    @JoinColumn(name = "videojoc_id")
    private Videojoc videojoc;

    public Botiga(){
        //Constructor per defecte
    }
    
    public Botiga(String nom, String adreca){
        this.nom = nom;
        this.adreca = adreca;
    }
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public Videojoc getVideojoc() {
        return videojoc;
    }

    public void setVideojoc(Videojoc videojoc) {
        this.videojoc = videojoc;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Botiga botiga = (Botiga) o;
        return Objects.equals(Id, botiga.Id) &&
                Objects.equals(nom, botiga.nom) &&
                Objects.equals(adreca, botiga.adreca) &&
                Objects.equals(videojoc, botiga.videojoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nom, adreca, videojoc);
    }
    
}
