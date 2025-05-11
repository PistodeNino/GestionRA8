package modelos;

import java.time.LocalDate;

public class Historial {
	
	private int id;
	private LocalDate fecha;
	private int productos;
	private double precio;
	
	public Historial() {
		
	}

	public Historial(int id, LocalDate fecha, int productos, double precio) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.productos = productos;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getProductos() {
		return productos;
	}

	public void setProductos(int productos) {
		this.productos = productos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Historial [id=" + id + ", fecha=" + fecha + ", productos=" + productos + ", precio=" + precio + "]";
	}
	
	

}
