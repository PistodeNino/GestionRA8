package modelos;

public class Cliente {
	
	private int id;
	private String correo, nombreUsuario, telefono, clave;
	
	
	public Cliente() {
		
	}

	public Cliente(String nombreUsuario, String clave) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}

	public Cliente(String correo, String nombreUsuario, String telefono, String clave) {
		super();
		this.correo = correo;
		this.nombreUsuario = nombreUsuario;
		this.telefono = telefono;
		this.clave = clave;
	}

	public Cliente(int id, String correo, String nombreUsuario, String telefono, String clave) {
		super();
		this.id = id;
		this.correo = correo;
		this.nombreUsuario = nombreUsuario;
		this.telefono = telefono;
		this.clave = clave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", correo=" + correo + ", nombreUsuario=" + nombreUsuario + ", telefono="
				+ telefono + ", clave=" + clave + "]";
	}
	
	

}
