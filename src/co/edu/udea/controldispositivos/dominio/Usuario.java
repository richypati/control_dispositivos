package co.edu.udea.controldispositivos.dominio;

import java.util.HashSet;
import java.util.Set;

public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private String nombres;
	private String apellidos;
	private String password;
	private Set<DispositivoXUsuario> dispositivoXUsuarios = new HashSet<DispositivoXUsuario>(0);

	public Usuario() {
	}

	public Usuario(String email, String nombres, String apellidos,
			String password) {
		this.email = email;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.password = password;
	}

	public Usuario(String email, String nombres, String apellidos,
			String password, Set<DispositivoXUsuario> dispositivoXUsuarios) {
		this.email = email;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.password = password;
		this.dispositivoXUsuarios = dispositivoXUsuarios;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<DispositivoXUsuario> getDispositivoXUsuarios() {
		return this.dispositivoXUsuarios;
	}

	public void setDispositivoXUsuarios(Set<DispositivoXUsuario> dispositivoXUsuarios) {
		this.dispositivoXUsuarios = dispositivoXUsuarios;
	}

}
