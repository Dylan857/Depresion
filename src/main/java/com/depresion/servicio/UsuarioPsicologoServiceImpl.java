package com.depresion.servicio;

import com.depresion.dao.UsuarioDao;
import com.depresion.dao.UsuarioPsicologoDao;
import com.depresion.dto.UsuarioDto;
import com.depresion.dto.UsuarioPsicologoDto;
import com.depresion.model.Rol;
import com.depresion.model.Usuario;
import com.depresion.model.UsuarioPsicologo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioPsicologoServiceImpl implements UsuarioPsicologoService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioPsicologoDao usuarioPsicologoDao;

    @Override
    public UsuarioPsicologo guardarUsuario(UsuarioPsicologoDto usuarioPsicologoDto) {
        UsuarioPsicologo usuarioPsicologo = new UsuarioPsicologo(usuarioPsicologoDto.getNombre(), usuarioPsicologoDto.getTipoDocumento(), usuarioPsicologoDto.getNumeroDocumento(), usuarioPsicologoDto.getEmail(), usuarioPsicologoDto.getUsuario(), bCryptPasswordEncoder.encode(usuarioPsicologoDto.getClave()));
        return usuarioPsicologoDao.save(usuarioPsicologo);
    }

    @Override
    public List<UsuarioPsicologo> listarUsuarios() {
        return usuarioPsicologoDao.findAll();
    }

    @Override
    public UsuarioPsicologo encontrarUsuario(String usuario) {
        return usuarioPsicologoDao.buscarPorUsuario(usuario);
    }

    @Override
    public UsuarioPsicologo encontrarUsuarioPorNumero(String numeroDocumento) {
        return usuarioPsicologoDao.buscarPorNumeroDocumento(numeroDocumento);
    }

    @Override
    public UsuarioPsicologo encontrarUsuarioPorEmail(String email) {
        return usuarioPsicologoDao.buscarPorEmail(email);
    }

}
