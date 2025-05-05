package modelos;

public class Valoracion {
	
	private int id, idProducto, estrellas;
	
	public Valoracion() {
		
	}

	public Valoracion(int idProducto, int estrellas) {
		super();
		this.idProducto = idProducto;
		this.estrellas = estrellas;
	}

	public Valoracion(int id, int idProducto, int estrellas) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.estrellas = estrellas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", idProducto=" + idProducto + ", estrellas=" + estrellas + "]";
	}
	
	

}
