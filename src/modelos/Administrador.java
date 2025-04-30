package modelos;

public class Administrador {
	
	private int id;
	private String nombreAdmin;
	private String contraseña;
	
	public Administrador() {
		
	}

	public Administrador(String nombreAdmin, String contraseña) {
		super();
		this.nombreAdmin = nombreAdmin;
		this.contraseña = contraseña;
	}

	public Administrador(int id, String nombreAdmin, String contraseña) {
		super();
		this.id = id;
		this.nombreAdmin = nombreAdmin;
		this.contraseña = contraseña;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreAdmin() {
		return nombreAdmin;
	}

	public void setNombreAdmin(String nombreAdmin) {
		this.nombreAdmin = nombreAdmin;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nombreAdmin=" + nombreAdmin + ", contraseña=" + contraseña + "]";
	}
	
	

}
