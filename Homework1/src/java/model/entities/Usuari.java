/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Usuari {
    @SequenceGenerator(name="Usuari_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Usuari_Gen")
    @Id
    private Long id;

    private String nomUsuari, contrasenya, correu;
    
    @OneToMany(mappedBy = "usuari")
    private List<Lloguer> lloguers;

    // Constructores
    public Usuari() {
        // Constructor por defecto
    }

    // Constructor con parámetros
    public Usuari(String nomUsuari, String contrasenya, String correu) {
        this.nomUsuari = nomUsuari;
        this.contrasenya = contrasenya;
        this.correu = correu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public List<Lloguer> getLloguers() {
        return lloguers;
    }

    public void setLloguers(List<Lloguer> lloguers) {
        this.lloguers = lloguers;
    }
    
    
}
