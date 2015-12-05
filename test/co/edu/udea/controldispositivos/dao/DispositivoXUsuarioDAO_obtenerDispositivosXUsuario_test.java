package co.edu.udea.controldispositivos.dao;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.controldispositivos.daoi.IDispositivoXUsuarioDAO;
import co.edu.udea.controldispositivos.dominio.DispositivoXUsuario;

public class DispositivoXUsuarioDAO_obtenerDispositivosXUsuario_test {

	IDispositivoXUsuarioDAO dispositivoXUsuarioDAO;
	
	@Before
	public void setUp() throws Exception {
		dispositivoXUsuarioDAO = new DispositivoXUsuarioDAO();
	}

	@Test
	public void test() {

		String emailUsuario="a@a.com";
		
		ArrayList<DispositivoXUsuario> dispositivosXUsuario = null;
		try{
			dispositivosXUsuario = dispositivoXUsuarioDAO.obtenerDispositivosXUsuario(emailUsuario);
		}catch(Exception e){
			fail();
		}
		
		ArrayList<DispositivoXUsuario> listaVacia = new ArrayList<DispositivoXUsuario>();
		
		assertNotEquals(listaVacia, dispositivosXUsuario);
	}

}
