package com.depresion.servicio;

import com.depresion.dto.UsuarioDto;
import com.depresion.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {
    
    public Usuario guardarUsuario(UsuarioDto usuarioDto);
    
    public Usuario encontrarUsuario(String usuario);
    
    public List<Usuario> listarUsuarios();
    
    public Usuario guardarUsuarioAdmin(UsuarioDto usuarioDto);
    
    public Usuario encontrarUsuarioPorNumero(String numeroDocumento);
    
    public Usuario encontrarUsuarioPorEmail(String email);
}
