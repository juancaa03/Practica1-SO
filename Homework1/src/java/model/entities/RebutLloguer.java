/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RebutLloguer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuari usuari; // Usuario asociado al recibo

    @ManyToOne
    private CistellaLloguer cistella; // Cesta asociada al recibo

    private double preuTotal;
    private LocalDateTime dataAlquiler;
    private LocalDateTime dataRetorn;
}
