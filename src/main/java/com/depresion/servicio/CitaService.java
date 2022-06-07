package com.depresion.servicio;

import com.depresion.model.Cita;
import com.depresion.model.Usuario;
import java.util.List;

public interface CitaService {
    
    public List<Cita> listarCitas();
    
    public Cita citaFindById(Cita cita);
    
    public void guardar(Cita cita);
        
    public void eliminar(Cita cita);
    
    public Cita buscarCitaByUsuario(Usuario usuario);
}
