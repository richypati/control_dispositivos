package co.edu.udea.controldispositivos.dominio;

import java.util.HashSet;
import java.util.Set;

public class Dispositivo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idDispositivo;
	private CategoriaDispositivo categoriaDispositivo;
	private String nombreDispositivo;
	private String estado;
	private String urlImagen;
	private Set<DispositivoXUsuario> dispositivoXUsuarios = new HashSet<DispositivoXUsuario>(0);

	public Dispositivo() {
	}

	public Dispositivo(CategoriaDispositivo categoriaDispositivo,
			String nombreDispositivo) {
		this.categoriaDispositivo = categoriaDispositivo;
		this.nombreDispositivo = nombreDispositivo;
	}

	public Dispositivo(CategoriaDispositivo categoriaDispositivo,
			String nombreDispositivo, String estado, String urlImagen,
			Set<DispositivoXUsuario> dispositivoXUsuarios) {
		this.categoriaDispositivo = categoriaDispositivo;
		this.nombreDispositivo = nombreDispositivo;
		this.estado = estado;
		this.urlImagen = urlImagen;
		this.dispositivoXUsuarios = dispositivoXUsuarios;
	}

	public Integer getIdDispositivo() {
		return this.idDispositivo;
	}

	public void setIdDispositivo(Integer idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public CategoriaDispositivo getCategoriaDispositivo() {
		return this.categoriaDispositivo;
	}

	public void setCategoriaDispositivo(
			CategoriaDispositivo categoriaDispositivo) {
		this.categoriaDispositivo = categoriaDispositivo;
	}

	public String getNombreDispositivo() {
		return this.nombreDispositivo;
	}

	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Set<DispositivoXUsuario> getDispositivoXUsuarios() {
		return this.dispositivoXUsuarios;
	}

	public void setDispositivoXUsuarios(Set<DispositivoXUsuario> dispositivoXUsuarios) {
		this.dispositivoXUsuarios = dispositivoXUsuarios;
	}

}
