package com.emergentes.dao;

import com.emergentes.modelo.Asignacion;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AsignacionDAOimpl extends ConexionDB implements AsignacionDAO{

    @Override
    public void insert(Asignacion asignacion) throws Exception {
        try {
            this.conectar();
            String sql = "insert into asignacion (id_aula, id_gestion, id_materia) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, asignacion.getAula_id());
            ps.setInt(2, asignacion.getGestion_id());
            ps.setInt(3, asignacion.getMateria_id());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Asignacion asignacion) throws Exception {
        try {
            this.conectar();
            String sql = "update asignacion set id_aula = ?, id_gestion = ?, id_materia = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, asignacion.getAula_id());
            ps.setInt(2, asignacion.getGestion_id());
            ps.setInt(3, asignacion.getMateria_id());
            ps.setInt(4, asignacion.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from asignacion where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Asignacion getById(int id) throws Exception {
        Asignacion asignacion = new Asignacion();
        try {
            this.conectar();
            String sql = "select * from asignacion where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                asignacion.setId(rs.getInt("id"));
                asignacion.setAula_id(rs.getInt("id_aula"));
                asignacion.setGestion_id(rs.getInt("id_gestion"));
                asignacion.setMateria_id(rs.getInt("id_materia"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return asignacion;
    }

    @Override
    public List<Asignacion> getAll() throws Exception {
        List<Asignacion> lista = null;
        try {
            this.conectar();
            String sql = "select a.*, au.nombre_aula as nombre_aula, g.nombre_gestion as nombre_gestion, m.nombre_materia as nombre_materia from asignacion a LEFT JOIN aula au ON a.id_aula = au.id LEFT JOIN gestion g ON a.id_gestion = g.id LEFT JOIN materia m ON a.id_materia=m.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Asignacion>();
            while (rs.next()) {
                Asignacion asignacion = new Asignacion();
                
                asignacion.setId(rs.getInt("id")); 
                
                asignacion.setAula_id(rs.getInt("id_aula"));                
                asignacion.setGestion_id(rs.getInt("id_gestion"));
                asignacion.setMateria_id(rs.getInt("id_materia")); 
                
                asignacion.setAu_aula(rs.getString("nombre_aula"));
                asignacion.setDes_gestion(rs.getString("nombre_gestion"));
                asignacion.setDes_materia(rs.getString("nombre_materia"));
                
             
                lista.add(asignacion);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
