package modelos;

public class Administrador {
	
	private int id;
	private String nombreAdmin, clave;
	
	
	public Administrador() {
		
	}

	public Administrador(String nombreAdmin, String clave) {
		super();
		this.nombreAdmin = nombreAdmin;
		this.clave = clave;
	}

	public Administrador(int id, String nombreAdmin, String clave) {
		super();
		this.id = id;
		this.nombreAdmin = nombreAdmin;
		this.clave = clave;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nombreAdmin=" + nombreAdmin + ", clave=" + clave + "]";
	}
	
	

}
