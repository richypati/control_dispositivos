package co.edu.udea.controldispositivos.dominio;

public class DispositivoXUsuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idDispositivoXUsuario;
	private Usuario usuario;
	private Dispositivo dispositivo;
	private String idAccesso;

	public DispositivoXUsuario() {
	}

	public DispositivoXUsuario(Usuario usuario, Dispositivo dispositivo,
			String idAccesso) {
		this.usuario = usuario;
		this.dispositivo = dispositivo;
		this.idAccesso = idAccesso;
	}

	public Integer getIdDispositivoXUsuario() {
		return this.idDispositivoXUsuario;
	}

	public void setIdDispositivoXUsuario(Integer idDispositivoXUsuario) {
		this.idDispositivoXUsuario = idDispositivoXUsuario;
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

	public String getIdAccesso() {
		return this.idAccesso;
	}

	public void setIdAccesso(String idAccesso) {
		this.idAccesso = idAccesso;
	}

}
