/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Lloguer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "videojoc_id", nullable = false)
    private Videojoc videojoc;

    @ManyToOne
    @JoinColumn(name = "usuari_id", nullable = false)
    private Usuari usuari;

    private LocalDate dataInici;
    private LocalDate dataFi;
    
    // Constructores
    public Lloguer() {
        // Constructor por defecto
    }

    public Lloguer(Videojoc videojoc, Usuari usuari, LocalDate dataInici, LocalDate dataFi) {
        this.videojoc = videojoc;
        this.usuari = usuari;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
    }
}
