/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
//import java.util.Date;
import java.util.Objects;

@Entity
public class Lloguer implements Serializable{
    @SequenceGenerator(name="Lloguer_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Lloguer_Gen")
    @Id
    @Column(name = "id")
    private Long id;
    
    private Date dataInici;
    private Date dataFi;
    
    private double preuTotal;

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

    public Lloguer(Videojoc videojoc, Usuari usuari, Date dataInici, Date dataFi, double preuTotal) {
        this.videojoc = videojoc;
        this.usuari = usuari;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.preuTotal = preuTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
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

    public double getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(double preuTotal) {
        this.preuTotal = preuTotal;
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
    
}
