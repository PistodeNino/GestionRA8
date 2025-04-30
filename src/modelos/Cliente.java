package modelos;

public class Cliente {
	
	private int id;
	private String correo;
	private String nombreUsuario;
	private String telefono;
	private String contraseña;
	
	public Cliente() {
		
	}

	public Cliente(String nombreUsuario, String contraseña) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public Cliente(String correo, String nombreUsuario, String telefono, String contraseña) {
		super();
		this.correo = correo;
		this.nombreUsuario = nombreUsuario;
		this.telefono = telefono;
		this.contraseña = contraseña;
	}

	public Cliente(int id, String correo, String nombreUsuario, String telefono, String contraseña) {
		super();
		this.id = id;
		this.correo = correo;
		this.nombreUsuario = nombreUsuario;
		this.telefono = telefono;
		this.contraseña = contraseña;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", correo=" + correo + ", nombreUsuario=" + nombreUsuario + ", telefono="
				+ telefono + ", contraseña=" + contraseña + "]";
	}
	
	

}
