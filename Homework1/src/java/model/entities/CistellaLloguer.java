/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class CistellaLloguer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Videojoc> videojocs;
    
    // Constructor por defecto
    public CistellaLloguer() {
    }

    // Constructor con argumentos
    public CistellaLloguer(List<Videojoc> videojocs) {
        this.videojocs = videojocs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Videojoc> getVideojocs() {
        return videojocs;
    }

    public void setVideojocs(List<Videojoc> videojocs) {
        this.videojocs = videojocs;
    }
    
    public void agregarVideojoc(Videojoc videojoc) {
    videojocs.add(videojoc);
    }
    
    public void eliminarVideojoc(Videojoc videojoc) {
    videojocs.remove(videojoc);
    }
    
    public void vaciarCistella() {
    videojocs.clear();
    }
    
    public double calcularTotalLloguer() {
    return videojocs.stream().mapToDouble(Videojoc::getPreuLloguer).sum();
    }
    
    
}
