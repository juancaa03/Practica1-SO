/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Usuari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String correuElectronic;
    
    @OneToMany(mappedBy = "usuari")
    private List<Lloguer> lloguers;

    // Constructores
    public Usuari() {
        // Constructor por defecto
    }

    // Constructor con parámetros
    public Usuari(String nom, String correuElectronic) {
        this.nom = nom;
        this.correuElectronic = correuElectronic;
    }
}
