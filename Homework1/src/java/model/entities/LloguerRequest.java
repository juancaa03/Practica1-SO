/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;


public class LloguerRequest {
    private Videojoc videojoc;
    private Usuari usuari;

    public LloguerRequest() {
    }

    
    public LloguerRequest(Videojoc videojoc, Usuari usuari) {
        this.videojoc = videojoc;
        this.usuari = usuari;
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
}
