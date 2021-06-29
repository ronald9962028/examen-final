
package com.emergentes.dao;

import com.emergentes.modelo.Asignacion;
import java.util.List;

public interface AsignacionDAO {
    public void insert(Asignacion asignacion) throws Exception;
    public void update(Asignacion asignacion) throws Exception;
    public void delete(int id) throws Exception;
    public Asignacion getById(int id) throws Exception;
    public List<Asignacion> getAll() throws Exception;
}
