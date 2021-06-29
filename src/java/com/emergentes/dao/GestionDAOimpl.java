
package com.emergentes.dao;

import com.emergentes.modelo.Gestion;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class GestionDAOimpl extends ConexionDB implements GestionDAO{

    @Override
    public void insert(Gestion gestion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement
            ("insert into gestion (nombre_gestion) values (?)");
            ps.setString(1, gestion.getNombre_gestion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        } 
    }

    @Override
    public void update(Gestion gestion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement
            ("update gestion SET nombre_gestion = ? where id = ?");
            ps.setString(1, gestion.getNombre_gestion());
            ps.setInt(2, gestion.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM gestion WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Gestion getById(int id) throws Exception {
        Gestion u = new Gestion();
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM gestion WHERE id = ?");
            ps.setInt(1,id);            
            ResultSet rs = ps.executeQuery();            
            if (rs.next()){
                u.setId(rs.getInt("id"));
                u.setNombre_gestion(rs.getString("nombre_gestion"));
            }            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return u; 
    }

    @Override
    public List<Gestion> getAll() throws Exception {
        List<Gestion> lista = null;
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM gestion");
            ResultSet rs = ps.executeQuery();            
            lista = new ArrayList<Gestion>();
            while (rs.next()){
                Gestion u =  new Gestion();                
                u.setId(rs.getInt("id"));
                u.setNombre_gestion(rs.getString("nombre_gestion"));              
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
