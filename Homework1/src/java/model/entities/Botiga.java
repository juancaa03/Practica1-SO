/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;

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

    public Long getId() {
        return Id;
    }

    /*public void setId(Long Id) {
        this.Id = Id;
    }*/

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
    
    
}
