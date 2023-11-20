/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
/*
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;*/
//import jakarta.validation.constraints.NotNull;
//import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Videojoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String videoconsola;
    private boolean disponibilitat;
    private double preuLloguer;
    
    @OneToOne(mappedBy = "videojoc")
    private InfoVideojoc infoVideojoc;

    @OneToMany(mappedBy = "videojoc")
    private List<Lloguer> lloguers;

    // Constructores
    public Videojoc() {
        // Constructor por defecto
    }

    // Constructor con parámetros
    public Videojoc(String nom, String videoconsola, boolean disponibilitat, double preuLloguer) {
        this.nom = nom;
        this.videoconsola = videoconsola;
        this.disponibilitat = disponibilitat;
        this.preuLloguer = preuLloguer;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVideoconsola() {
        return videoconsola;
    }

    public void setVideoconsola(String videoconsola) {
        this.videoconsola = videoconsola;
    }

    public boolean isDisponibilitat() {
        return disponibilitat;
    }

    public void setDisponibilitat(boolean disponibilitat) {
        this.disponibilitat = disponibilitat;
    }

    public double getPreuLloguer() {
        return preuLloguer;
    }

    public void setPreuLloguer(double preuLloguer) {
        this.preuLloguer = preuLloguer;
    }
    
    
}
