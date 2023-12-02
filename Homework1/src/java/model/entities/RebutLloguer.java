/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class RebutLloguer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Usuari usuari; // Usuario asociado al recibo

    @ManyToOne
    private CistellaLloguer cistella; // Cesta asociada al recibo

    private double preuTotal;
    private LocalDateTime dataAlquiler;
    private LocalDateTime dataRetorn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public CistellaLloguer getCistella() {
        return cistella;
    }

    public void setCistella(CistellaLloguer cistella) {
        this.cistella = cistella;
    }

    public double getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(double preuTotal) {
        this.preuTotal = preuTotal;
    }

    public LocalDateTime getDataAlquiler() {
        return dataAlquiler;
    }

    public void setDataAlquiler(LocalDateTime dataAlquiler) {
        this.dataAlquiler = dataAlquiler;
    }

    public LocalDateTime getDataRetorn() {
        return dataRetorn;
    }

    public void setDataRetorn(LocalDateTime dataRetorn) {
        this.dataRetorn = dataRetorn;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RebutLloguer that = (RebutLloguer) o;
        return Double.compare(that.preuTotal, preuTotal) == 0 &&
                Objects.equals(usuari, that.usuari) &&
                Objects.equals(cistella, that.cistella) &&
                Objects.equals(dataAlquiler, that.dataAlquiler) &&
                Objects.equals(dataRetorn, that.dataRetorn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuari, cistella, preuTotal, dataAlquiler, dataRetorn);
    }
    
    
}
