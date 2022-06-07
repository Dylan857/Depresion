package com.depresion.servicio;

import com.depresion.dto.UsuarioDto;
import com.depresion.dto.UsuarioPsicologoDto;
import com.depresion.model.Usuario;
import com.depresion.model.UsuarioPsicologo;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioPsicologoService {
    
    public UsuarioPsicologo guardarUsuario(UsuarioPsicologoDto usuarioPsicologoDto);
        
    public List<UsuarioPsicologo> listarUsuarios();
    
    public UsuarioPsicologo encontrarUsuario(String usuario);
    
    public UsuarioPsicologo encontrarUsuarioPorNumero(String numeroDocumento);
    
    public UsuarioPsicologo encontrarUsuarioPorEmail(String email);
    
}
