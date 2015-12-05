package co.edu.udea.controldispositivos.daoi;

import java.util.ArrayList;

import co.edu.udea.controldispositivos.dominio.Dispositivo;

public interface IDispositivoDAO {

	public ArrayList<Dispositivo> obtenerDispositivosPorCategoria(int idCategoriaDispositivo);
}
