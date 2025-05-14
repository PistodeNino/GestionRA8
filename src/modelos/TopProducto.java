package modelos;

public class TopProducto {
	
	private String nombre;
	private int unidades;
	
	public TopProducto() {
		
	}

	public TopProducto(String nombre, int unidades) {
		super();
		this.nombre = nombre;
		this.unidades = unidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "TopProducto [nombre=" + nombre + ", unidades=" + unidades + "]";
	}
	
	

}
