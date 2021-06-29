
package com.emergentes.modelo;

public class Aula {
    private int id;
    private String nombre_aula;

    public Aula() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_aula() {
        return nombre_aula;
    }

    public void setNombre_aula(String nombre_aula) {
        this.nombre_aula = nombre_aula;
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", nombre_aula=" + nombre_aula + '}';
    }
    
    
}
