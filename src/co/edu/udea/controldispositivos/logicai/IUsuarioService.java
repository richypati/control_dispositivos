package co.edu.udea.controldispositivos.logicai;

import org.hibernate.exception.ConstraintViolationException;

import co.edu.udea.controldispositivos.dominio.Usuario;


public interface IUsuarioService {

	public boolean esUsuarioValido(String email, String password);
	public void registrarUsuario(Usuario usuario) throws ConstraintViolationException;
}
