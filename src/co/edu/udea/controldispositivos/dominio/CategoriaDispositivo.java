package co.edu.udea.controldispositivos.dominio;

import java.util.HashSet;
import java.util.Set;

public class CategoriaDispositivo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idCategoriaDispositivo;
	private String nombreCategoria;
	private Set<Dispositivo> dispositivos = new HashSet<Dispositivo>(0);

	public CategoriaDispositivo() {
	}

	public CategoriaDispositivo(int idCategoriaDispositivo,
			String nombreCategoria) {
		this.idCategoriaDispositivo = idCategoriaDispositivo;
		this.nombreCategoria = nombreCategoria;
	}

	public CategoriaDispositivo(int idCategoriaDispositivo,
			String nombreCategoria, Set<Dispositivo> dispositivos) {
		this.idCategoriaDispositivo = idCategoriaDispositivo;
		this.nombreCategoria = nombreCategoria;
		this.dispositivos = dispositivos;
	}

	public int getIdCategoriaDispositivo() {
		return this.idCategoriaDispositivo;
	}

	public void setIdCategoriaDispositivo(int idCategoriaDispositivo) {
		this.idCategoriaDispositivo = idCategoriaDispositivo;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Set<Dispositivo> getDispositivos() {
		return this.dispositivos;
	}

	public void setDispositivos(Set<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

}