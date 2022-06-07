package com.depresion.dao;

import com.depresion.model.UsuarioPsicologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioPsicologoDao extends JpaRepository<UsuarioPsicologo, Integer> {
    
    @Query("SELECT u FROM UsuarioPsicologo u WHERE u.usuario = :usuario")
    public UsuarioPsicologo buscarPorUsuario(@Param("usuario")String usuario);
    
    @Query("SELECT u FROM UsuarioPsicologo u WHERE u.numeroDocumento = :numeroDocumento")
    public UsuarioPsicologo buscarPorNumeroDocumento(@Param("numeroDocumento")String numeroDocumento);
    
    @Query("SELECT u FROM UsuarioPsicologo u WHERE u.email = :email")
    public UsuarioPsicologo buscarPorEmail(@Param("email")String email);
    
}
