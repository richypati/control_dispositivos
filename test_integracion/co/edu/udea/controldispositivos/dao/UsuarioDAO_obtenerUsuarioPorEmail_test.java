package co.edu.udea.controldispositivos.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.controldispositivos.dominio.Usuario;

public class UsuarioDAO_obtenerUsuarioPorEmail_test {

	IUsuarioDAO usuarioDAO;
	
	@Before
	public void setUp() throws Exception {
		usuarioDAO = new UsuarioDAO();
	}

	@Test
	public void encuentraUsuarioPorEmail() {
		String email="a@a.com";

		Usuario usuario = usuarioDAO.obtenerUsuarioPorEmail(email);
		
		assertNotNull(usuario);
	}

}
