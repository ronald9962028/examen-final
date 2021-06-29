package com.emergentes.dao;

import com.emergentes.modelo.Aula;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AulaDAOimpl extends ConexionDB implements AulaDAO{

    @Override
    public void insert(Aula aula) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement
            ("insert into aula (nombre_aula) values (?)");
            ps.setString(1, aula.getNombre_aula());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }     }

    @Override
    public void update(Aula aula) throws Exception {
    try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement
            ("update aula SET nombre_aula = ? where id = ?");
            ps.setString(1, aula.getNombre_aula());
            ps.setInt(2, aula.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM aula WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Aula getById(int id) throws Exception {
        Aula u = new Aula();
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM aula WHERE id = ?");
            ps.setInt(1,id);            
            ResultSet rs = ps.executeQuery();            
            if (rs.next()){
                u.setId(rs.getInt("id"));
                u.setNombre_aula(rs.getString("nombre_aula"));
            }            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return u;
    }

    @Override
    public List<Aula> getAll() throws Exception {
        List<Aula> lista = null;
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM aula");
            ResultSet rs = ps.executeQuery();            
            lista = new ArrayList<Aula>();
            while (rs.next()){
                Aula u =  new Aula();                
                u.setId(rs.getInt("id"));
                u.setNombre_aula(rs.getString("nombre_aula"));              
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
