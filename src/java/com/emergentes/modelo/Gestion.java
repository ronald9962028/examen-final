
package com.emergentes.modelo;

public class Gestion {
    private int id;
    private String nombre_gestion;

    public Gestion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_gestion() {
        return nombre_gestion;
    }

    public void setNombre_gestion(String nombre_gestion) {
        this.nombre_gestion = nombre_gestion;
    }

    @Override
    public String toString() {
        return "Gestion{" + "id=" + id + ", nombre_gestion=" + nombre_gestion + '}';
    }
    
    
    
}
