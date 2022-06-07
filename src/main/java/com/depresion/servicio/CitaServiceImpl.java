package com.depresion.servicio;

import com.depresion.dao.CitaDao;
import com.depresion.model.Cita;
import com.depresion.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaDao citaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cita> listarCitas() {
        return citaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    @Transactional
    public void eliminar(Cita cita) {
        citaDao.delete(cita);
    }

    @Override
    @Transactional(readOnly = true)
    public Cita citaFindById(Cita cita) {
        return citaDao.findById(cita.getIdCita()).orElse(null);
    }

    @Override
    public Cita buscarCitaByUsuario(Usuario usuario) {
        return citaDao.buscarCitaByUsuario(usuario);
    }
    
}
