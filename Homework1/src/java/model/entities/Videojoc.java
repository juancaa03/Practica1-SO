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
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Videojoc implements Serializable{
    @SequenceGenerator(name="Videojoc_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Videojoc_Gen")
    @Id
    @Column(name = "id")
    private Long id;

    private String nom;
    private String videoconsola;
    private boolean disponibilitat;
    private double preuLloguer;
    private String descripcio;
    private String tipus;
    private String adrecaBotigues;

    @OneToMany(mappedBy = "videojoc")
    private List<Lloguer> lloguers;

    @ManyToMany(mappedBy = "videojocs")
    private List<Botiga> botigues;
        
    // Constructores
    public Videojoc() {
        // Constructor por defecto
    }

    // Constructor con parámetros
    public Videojoc(String nom, String videoconsola, boolean disponibilitat, double preuLloguer, String descripcio, String tipus, String adrecaBotigues) {
        this.nom = nom;
        this.videoconsola = videoconsola;
        this.disponibilitat = disponibilitat;
        this.preuLloguer = preuLloguer;
        this.tipus = tipus;
        this.descripcio = descripcio;
        this.adrecaBotigues = adrecaBotigues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videojoc videojoc = (Videojoc) o;
        return disponibilitat == videojoc.disponibilitat &&
                Double.compare(videojoc.preuLloguer, preuLloguer) == 0 &&
                Objects.equals(id, videojoc.id) &&
                Objects.equals(nom, videojoc.nom) &&
                Objects.equals(videoconsola, videojoc.videoconsola) &&
                Objects.equals(descripcio, videojoc.descripcio) &&
                Objects.equals(tipus, videojoc.tipus) &&
                Objects.equals(adrecaBotigues, videojoc.adrecaBotigues);
    }
    
    public List<Botiga> getBotigues() {
        return botigues;
    }

    public void setBotigues(List<Botiga> botigues) {
        this.botigues = botigues;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues);
    }
}
