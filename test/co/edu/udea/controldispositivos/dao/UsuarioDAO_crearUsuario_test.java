package co.edu.udea.controldispositivos.dao;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;

import co.edu.udea.controldispositivos.daoi.IUsuarioDAO;
import co.edu.udea.controldispositivos.dominio.Usuario;

public class UsuarioDAO_crearUsuario_test {

	IUsuarioDAO usuarioDAO;
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
	@Before
	public void setUp() throws Exception {
		usuarioDAO = new UsuarioDAO();
	}

	@Test(expected=ConstraintViolationException.class)
	public void usuarioExiste() {

		Usuario usuario = new Usuario();
		usuario.setEmail("a@a.com");
		usuario.setNombres("a");
		usuario.setApellidos("b");
		usuario.setPassword("12345");
		
		try{
			usuarioDAO.crearUsuario(usuario);
		}catch(ConstraintViolationException e){
			throw e;
		}
	}
	
	@Test
	public void usuarioRegsitrado() {

		Usuario usuario = new Usuario();
		usuario.setEmail("1@undominio.com");
		usuario.setNombres("UnNombre");
		usuario.setApellidos("Dos Apellidos");
		usuario.setPassword("MiPass");
		
		try{
			usuarioDAO.crearUsuario(usuario);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

}
