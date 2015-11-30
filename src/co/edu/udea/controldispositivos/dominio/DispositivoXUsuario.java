package co.edu.udea.controldispositivos.dominio;

public class DispositivoXUsuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private DispositivoXUsuarioId id;
	private Usuario usuario;
	private Dispositivo dispositivo;

	public DispositivoXUsuario() {
	}

	public DispositivoXUsuario(DispositivoXUsuarioId id, Usuario usuario,
			Dispositivo dispositivo) {
		this.id = id;
		this.usuario = usuario;
		this.dispositivo = dispositivo;
	}

	public DispositivoXUsuarioId getId() {
		return this.id;
	}

	public void setId(DispositivoXUsuarioId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Dispositivo getDispositivo() {
		return this.dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

}
