package com.emergentes.modelo;

public class Materia {
    private int id;
    private String nombre_materia;

    public Materia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombre_materia=" + nombre_materia + '}';
    }
    
    
}
