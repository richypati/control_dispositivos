package co.edu.udea.controldispositivos.logica;

import org.hibernate.exception.ConstraintViolationException;

import com.google.gson.Gson;

import co.edu.udea.controldispositivos.dao.UsuarioDAO;
import co.edu.udea.controldispositivos.daoi.IUsuarioDAO;
import co.edu.udea.controldispositivos.dominio.Usuario;
import co.edu.udea.controldispositivos.logicai.IUsuarioService;

public class UsuarioService implements IUsuarioService{

	IUsuarioDAO usuarioDAO;
	Gson gson;
	
	@Override
	public boolean esUsuarioValido(String email, String password) {
		
		boolean esUsuarioValido = false;
		
		usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.obtenerUsuarioPorEmail(email);
		if (null != usuario){
			if (usuario.getPassword().equals(password)){
				esUsuarioValido = true;
			}else{
				esUsuarioValido = false;
			}
		}
		return esUsuarioValido;
	}

	@Override
	public void registrarUsuario(String usuarioJSON) throws ConstraintViolationException{
		
		gson = new Gson();
		Usuario usuario = gson.fromJson(usuarioJSON, Usuario.class);
		usuarioDAO.crearUsuario(usuario);
	}

	
}
