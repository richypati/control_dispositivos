package co.edu.udea.controldispositivos.logicai;

import org.hibernate.exception.ConstraintViolationException;


public interface IUsuarioService {

	public boolean esUsuarioValido(String email, String password);
	public void registrarUsuario(String usuarioJSON) throws ConstraintViolationException;
}
