package co.edu.udea.controldispositivos.logica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioService_esUsuarioValido_Test {

	IUsuarioService usuarioService;
	
	@Before
	public void setUp() throws Exception {
		usuarioService =  new UsuarioService();
	}

	@Test
	public void usuarioValido() {
		
		boolean esUsuarioValido;
		
		String email="a@a.com";
		String password="1234";
		
		esUsuarioValido = usuarioService.esUsuarioValido(email, password);
		
		assertTrue(esUsuarioValido);
	}
	
	@Test
	public void usuarioNoValidoPorEmail() {
		
		boolean esUsuarioValido;
		
		String email="-";
		String password="1234";
		
		esUsuarioValido = usuarioService.esUsuarioValido(email, password);
		
		assertFalse(esUsuarioValido);
	}
	
	@Test
	public void usuarioNoValidoPorPassword() {
		
		boolean esUsuarioValido;
		
		String email="a@a.com";
		String password="-";
		
		esUsuarioValido = usuarioService.esUsuarioValido(email, password);
		
		assertFalse(esUsuarioValido);
	}

}