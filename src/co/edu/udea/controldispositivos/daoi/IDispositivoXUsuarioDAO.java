package co.edu.udea.controldispositivos.daoi;

import java.util.ArrayList;

import co.edu.udea.controldispositivos.dominio.DispositivoXUsuario;

public interface IDispositivoXUsuarioDAO {

	public ArrayList<DispositivoXUsuario> obtenerDispositivosXUsuario(String emailUsuario);
	public void asignarDispositivoAUsuario(DispositivoXUsuario dispositivoXUsuario);
}
