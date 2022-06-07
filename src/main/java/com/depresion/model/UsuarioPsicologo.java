/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.depresion.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 57304
 */
@Entity
@Table(name = "usuario_psicologo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioPsicologo.findAll", query = "SELECT u FROM UsuarioPsicologo u"),
    @NamedQuery(name = "UsuarioPsicologo.findByIdUsuarioPsicologo", query = "SELECT u FROM UsuarioPsicologo u WHERE u.idUsuarioPsicologo = :idUsuarioPsicologo"),
    @NamedQuery(name = "UsuarioPsicologo.findByNombre", query = "SELECT u FROM UsuarioPsicologo u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "UsuarioPsicologo.findByTipoDocumento", query = "SELECT u FROM UsuarioPsicologo u WHERE u.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "UsuarioPsicologo.findByNumeroDocumento", query = "SELECT u FROM UsuarioPsicologo u WHERE u.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "UsuarioPsicologo.findByEmail", query = "SELECT u FROM UsuarioPsicologo u WHERE u.email = :email"),
    @NamedQuery(name = "UsuarioPsicologo.findByUsuario", query = "SELECT u FROM UsuarioPsicologo u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "UsuarioPsicologo.findByClave", query = "SELECT u FROM UsuarioPsicologo u WHERE u.clave = :clave")})
public class UsuarioPsicologo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_psicologo")
    private Integer idUsuarioPsicologo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Column(name = "email")
    private String email;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "clave")
    private String clave;
    @OneToMany(mappedBy = "psicologo")
    private List<Cita> citas;

    public UsuarioPsicologo() {
    }

    public UsuarioPsicologo(Integer idUsuarioPsicologo) {
        this.idUsuarioPsicologo = idUsuarioPsicologo;
    }

    public UsuarioPsicologo(String nombre, String tipoDocumento, String numeroDocumento, String email, String usuario, String clave) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
    }
    
    

    public Integer getIdUsuarioPsicologo() {
        return idUsuarioPsicologo;
    }

    public void setIdUsuarioPsicologo(Integer idUsuarioPsicologo) {
        this.idUsuarioPsicologo = idUsuarioPsicologo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @XmlTransient
    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitaList(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioPsicologo != null ? idUsuarioPsicologo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPsicologo)) {
            return false;
        }
        UsuarioPsicologo other = (UsuarioPsicologo) object;
        if ((this.idUsuarioPsicologo == null && other.idUsuarioPsicologo != null) || (this.idUsuarioPsicologo != null && !this.idUsuarioPsicologo.equals(other.idUsuarioPsicologo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre + "\n TipoDocumento:" + tipoDocumento + "\n NumeroDocumento:" + numeroDocumento + "\n Email:" + email + "\n Usuario:" + usuario;
    }

    
    
}
