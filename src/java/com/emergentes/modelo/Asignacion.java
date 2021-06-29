
package com.emergentes.modelo;

public class Asignacion {
    private int id;
    private int aula_id;
    private int gestion_id;
    private int materia_id;
    private String au_aula;
    private String des_gestion;
    private String des_materia;

    public Asignacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAula_id() {
        return aula_id;
    }

    public void setAula_id(int aula_id) {
        this.aula_id = aula_id;
    }

    public int getGestion_id() {
        return gestion_id;
    }

    public void setGestion_id(int gestion_id) {
        this.gestion_id = gestion_id;
    }

    public int getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(int materia_id) {
        this.materia_id = materia_id;
    }

    public String getAu_aula() {
        return au_aula;
    }

    public void setAu_aula(String au_aula) {
        this.au_aula = au_aula;
    }

    public String getDes_gestion() {
        return des_gestion;
    }

    public void setDes_gestion(String des_gestion) {
        this.des_gestion = des_gestion;
    }

    public String getDes_materia() {
        return des_materia;
    }

    public void setDes_materia(String des_materia) {
        this.des_materia = des_materia;
    }

    @Override
    public String toString() {
        return "asignacion{" + "id=" + id + ", aula_id=" + aula_id + ", gestion_id=" + gestion_id + ", materia_id=" + materia_id + ", au_aula=" + au_aula + ", des_gestion=" + des_gestion + ", des_materia=" + des_materia + '}';
    }
    
    
}
