package co.edu.udea.controldispositivos.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.controldispositivos.daoi.ICategoriaDispositivoDAO;
import co.edu.udea.controldispositivos.dominio.CategoriaDispositivo;

public class CategoriaDispositivoDAO_obtenerCategoriasDispositivo_test {

	ICategoriaDispositivoDAO categoriaDispositivoDAO;
	
	@Before
	public void setUp() throws Exception {
		categoriaDispositivoDAO = new CategoriaDispositivoDAO();
	}

	@Test
	public void obtieneCategoriasDeDispositivos() {
		
		ArrayList<CategoriaDispositivo> categoriasDispositivos = null;
		categoriasDispositivos = categoriaDispositivoDAO.obtenerCategoriasDispositivo();
		
		assertNotNull(categoriasDispositivos);
	}

}
