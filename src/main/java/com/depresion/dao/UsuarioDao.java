package com.depresion.dao;

import com.depresion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
    public Usuario findByUsuario(String usuario);
    
    @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario")
    public Usuario buscarPorUsuario(@Param("usuario")String usuario);
    
    @Query("SELECT u FROM Usuario u WHERE u.numeroDocumento = :numeroDocumento")
    public Usuario buscarPorNumeroDocumento(@Param("numeroDocumento")String numeroDocumento);
    
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario buscarPorEmail(@Param("email")String email);
}
