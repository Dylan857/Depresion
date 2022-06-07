package com.depresion.dao;

import com.depresion.model.Cita;
import com.depresion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaDao extends JpaRepository<Cita, Integer> {
    
    @Query("SELECT c FROM Cita c WHERE c.usuario = :usuario")
    public Cita buscarCitaByUsuario(@Param("usuario")Usuario usuario);
    
}
