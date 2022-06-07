package com.depresion.servicio;

import com.depresion.dao.UsuarioDao;
import com.depresion.dto.UsuarioDto;
import com.depresion.model.Rol;
import com.depresion.model.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Override
    public Usuario encontrarUsuario(String usuario) {
        return usuarioDao.buscarPorUsuario(usuario);
    }
    
    @Override
    public Usuario guardarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario(usuarioDto.getNombre(), usuarioDto.getTipoDocumento(), usuarioDto.getNumeroDocumento(), 
                usuarioDto.getEmail(), usuarioDto.getUsuario(), bCryptPasswordEncoder.encode(usuarioDto.getClave()),Arrays.asList(new Rol("ROLE_USER")));
        return usuarioDao.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password incorrecto");
        }
        
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        
        for (Rol rol:usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getTipo()));
        }
        
        return new User(usuario.getUsuario(), usuario.getClave(), roles);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario guardarUsuarioAdmin(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario(usuarioDto.getNombre(), usuarioDto.getTipoDocumento(), usuarioDto.getNumeroDocumento(), 
                usuarioDto.getEmail(), usuarioDto.getUsuario(), bCryptPasswordEncoder.encode(usuarioDto.getClave()),Arrays.asList(new Rol("ROLE_ADMIN")));
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario encontrarUsuarioPorNumero(String numeroDocumento) {
        return usuarioDao.buscarPorNumeroDocumento(numeroDocumento);
    }

    @Override
    public Usuario encontrarUsuarioPorEmail(String email) {
        return usuarioDao.buscarPorEmail(email);
    }

    

    
    
}
