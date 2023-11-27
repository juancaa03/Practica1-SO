/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Entity
public class Lloguer {
    @SequenceGenerator(name="Lloguer_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Lloguer_Gen")
    @Id
    private Long id;
    
    private LocalDate dataInici;
    private LocalDate dataFi;

    @ManyToOne
    @JoinColumn(name = "videojoc_id", nullable = false)
    private Videojoc videojoc;

    @ManyToOne
    @JoinColumn(name = "usuari_id", nullable = false)
    private Usuari usuari;
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDate dataInici) {
        this.dataInici = dataInici;
    }

    public LocalDate getDataFi() {
        return dataFi;
    }

    public void setDataFi(LocalDate dataFi) {
        this.dataFi = dataFi;
    }

    public Videojoc getVideojoc() {
        return videojoc;
    }

    public void setVideojoc(Videojoc videojoc) {
        this.videojoc = videojoc;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lloguer lloguer = (Lloguer) o;
        return Objects.equals(id, lloguer.id) &&
                Objects.equals(dataInici, lloguer.dataInici) &&
                Objects.equals(dataFi, lloguer.dataFi) &&
                Objects.equals(videojoc, lloguer.videojoc) &&
                Objects.equals(usuari, lloguer.usuari);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataInici, dataFi, videojoc, usuari);
    }
    
    public long calcularDuracioAlquiler() {
    return ChronoUnit.DAYS.between(dataInici, dataFi);
    }
    
    public double calcularCostAlquiler() {
    long duracio = calcularDuracioAlquiler();
    return duracio * videojoc.getPreuLloguer();
    }
    
    public boolean estaActiu() {
    LocalDate avui = LocalDate.now();
    return avui.isAfter(dataInici) && avui.isBefore(dataFi.plusDays(1));
    }
    
    
}
