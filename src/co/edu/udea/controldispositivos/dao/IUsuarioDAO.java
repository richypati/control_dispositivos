package co.edu.udea.controldispositivos.dao;

import co.edu.udea.controldispositivos.dominio.Usuario;

public interface IUsuarioDAO {

	public Usuario obtenerUsuarioPorEmail(String email);
	public void crearUsuario(Usuario usuario);
}
