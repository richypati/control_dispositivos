package co.edu.udea.controldispositivos.dominio;

public class DispositivoXUsuarioId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String usuarioEmail;
	private int idDispositivo;
	private String idAccesso;

	public DispositivoXUsuarioId() {
	}

	public DispositivoXUsuarioId(String usuarioEmail, int idDispositivo,
			String idAccesso) {
		this.usuarioEmail = usuarioEmail;
		this.idDispositivo = idDispositivo;
		this.idAccesso = idAccesso;
	}

	public String getUsuarioEmail() {
		return this.usuarioEmail;
	}

	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}

	public int getIdDispositivo() {
		return this.idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getIdAccesso() {
		return this.idAccesso;
	}

	public void setIdAccesso(String idAccesso) {
		this.idAccesso = idAccesso;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DispositivoXUsuarioId))
			return false;
		DispositivoXUsuarioId castOther = (DispositivoXUsuarioId) other;

		return ((this.getUsuarioEmail() == castOther.getUsuarioEmail()) || (this
				.getUsuarioEmail() != null
				&& castOther.getUsuarioEmail() != null && this
				.getUsuarioEmail().equals(castOther.getUsuarioEmail())))
				&& (this.getIdDispositivo() == castOther.getIdDispositivo())
				&& ((this.getIdAccesso() == castOther.getIdAccesso()) || (this
						.getIdAccesso() != null
						&& castOther.getIdAccesso() != null && this
						.getIdAccesso().equals(castOther.getIdAccesso())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getUsuarioEmail() == null ? 0 : this.getUsuarioEmail()
						.hashCode());
		result = 37 * result + this.getIdDispositivo();
		result = 37 * result
				+ (getIdAccesso() == null ? 0 : this.getIdAccesso().hashCode());
		return result;
	}

}
