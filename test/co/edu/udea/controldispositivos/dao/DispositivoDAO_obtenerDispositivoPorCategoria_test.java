package co.edu.udea.controldispositivos.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.controldispositivos.daoi.IDispositivoDAO;
import co.edu.udea.controldispositivos.dominio.Dispositivo;


public class DispositivoDAO_obtenerDispositivoPorCategoria_test {

	IDispositivoDAO dispositivoDAO;
	
	@Before
	public void setUp() throws Exception {
		dispositivoDAO = new DispositivoDAO();
	}

	@Test
	public void obtenerDispositivosPorCategoria() {
		int idCategoriaDispositivo = 1;
		
		ArrayList<Dispositivo> dispositivos = null;
		try{
			dispositivos = dispositivoDAO.obtenerDispositivosPorCategoria(idCategoriaDispositivo);
		}catch(Exception e){
			fail();
		}
		
		ArrayList<Dispositivo> listaVacia = new ArrayList<Dispositivo>();
		
		assertNotEquals(listaVacia, dispositivos);
	}

}
