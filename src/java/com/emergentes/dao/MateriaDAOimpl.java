package com.emergentes.dao;

import com.emergentes.modelo.Materia;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAOimpl extends ConexionDB implements MateriaDAO{

    @Override
    public void insert(Materia materia) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement
            ("insert into materia (nombre_materia) values (?)");
            ps.setString(1, materia.getNombre_materia());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Materia materia) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement
            ("update materia SET nombre_materia = ? where id = ?");
            ps.setString(1, materia.getNombre_materia());
            ps.setInt(2, materia.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM materia WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Materia getById(int id) throws Exception {
        Materia u = new Materia();
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM materia WHERE id = ?");
            ps.setInt(1,id);            
            ResultSet rs = ps.executeQuery();            
            if (rs.next()){
                u.setId(rs.getInt("id"));
                u.setNombre_materia(rs.getString("nombre_materia"));
            }            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return u;

    }

    @Override
    public List<Materia> getAll() throws Exception {
        List<Materia> lista = null;
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM materia");
            ResultSet rs = ps.executeQuery();            
            lista = new ArrayList<Materia>();
            while (rs.next()){
                Materia u =  new Materia();                
                u.setId(rs.getInt("id"));
                u.setNombre_materia(rs.getString("nombre_materia"));              
                lista.add(u);
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
