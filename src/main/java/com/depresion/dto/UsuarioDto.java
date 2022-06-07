package com.depresion.dto;


public class UsuarioDto {

    private Integer idUsuario;

    private String nombre;

    private String tipoDocumento;

    private String numeroDocumento;

    private String email;

    private String usuario;

    private String clave;

    public UsuarioDto() {

    }

    public UsuarioDto(Integer idUsuario, String nombre, String tipoDocumento, String numeroDocumento, String email, String usuario, String clave) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
    }

    public UsuarioDto(String nombre, String tipoDocumento, String numeroDocumento, String email, String usuario, String clave) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
    }

    public UsuarioDto(String usuario) {
        this.usuario = usuario;
    }

	public Integer getIdUsuario() {
		return idUsuario;
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
    
    
    
}
