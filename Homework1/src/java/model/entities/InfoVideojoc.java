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
public class InfoVideojoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Videojoc videojoc;

    private String descripcio;
    private String tipus;
    //private String adrecaBotiga;
    
    @ElementCollection
    @CollectionTable(name = "adreces_botigues", joinColumns = @JoinColumn(name = "infovideojoc_id"))
    @Column(name = "adreca_botiga")
    private List<String> adrecesBotigues;
    
    // Constructores
    public InfoVideojoc() {
        // Constructor por defecto
    }

    public InfoVideojoc(String descripcio, String tipus, List<String> adrecesBotigues) {
        this.descripcio = descripcio;
        this.tipus = tipus;
        this.adrecesBotigues = adrecesBotigues;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public Videojoc getVideojoc() {
        return videojoc;
    }

    public void setVideojoc(Videojoc videojoc) {
        this.videojoc = videojoc;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public List<String> getAdrecesBotigues() {
        return adrecesBotigues;
    }

    public void setAdrecesBotigues(List<String> adrecesBotigues) {
        this.adrecesBotigues = adrecesBotigues;
    }
    
    
}
