/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

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
    public Usuari(Long id, String nomUsuari, String contrasenya, String correu) {
        this.id = id;
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
    
    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuari usuari = (Usuari) o;
        return Objects.equals(id, usuari.id) &&
                Objects.equals(nomUsuari, usuari.nomUsuari) &&
                Objects.equals(contrasenya, usuari.contrasenya) &&
                Objects.equals(correu, usuari.correu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomUsuari, contrasenya, correu);
    }
}
