/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class RebutLloguer implements Serializable{
    @SequenceGenerator(name="RebutLloguer_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RebutLloguer_Gen")
    @Id
    @Column(name = "id")
    private Long id;
    
    private double preuTotal;
    private Date dataAlquiler;
    private Date dataRetorn;

    @ManyToOne
    private Usuari usuari; 
    
    public RebutLloguer() {
        
    }
    
    public RebutLloguer(Long id, Date dataAlquiler, Date dataRetorn, double preuTotal) {
        this.id = id;
        this.dataAlquiler = dataAlquiler;
        this.dataRetorn = dataRetorn;
        this.preuTotal = preuTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(double preuTotal) {
        this.preuTotal = preuTotal;
    }

    public Date getDataAlquiler() {
        return dataAlquiler;
    }

    public void setDataAlquiler(Date dataAlquiler) {
        this.dataAlquiler = dataAlquiler;
    }

    public Date getDataRetorn() {
        return dataRetorn;
    }

    public void setDataRetorn(Date dataRetorn) {
        this.dataRetorn = dataRetorn;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.preuTotal) ^ (Double.doubleToLongBits(this.preuTotal) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.dataAlquiler);
        hash = 47 * hash + Objects.hashCode(this.dataRetorn);
        hash = 47 * hash + Objects.hashCode(this.usuari);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RebutLloguer other = (RebutLloguer) obj;
        if (Double.doubleToLongBits(this.preuTotal) != Double.doubleToLongBits(other.preuTotal)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataAlquiler, other.dataAlquiler)) {
            return false;
        }
        if (!Objects.equals(this.dataRetorn, other.dataRetorn)) {
            return false;
        }
        return Objects.equals(this.usuari, other.usuari);
    }
 
    
}
