package modelos;

import java.time.LocalDate;
import java.util.List;

public class Compra {
	
	// Clase que representa la compra total de un cliente
	
	private int id;
	private int idUsuario;
	private LocalDate fechaCompra;
	private double total;
	private String rutaFactura;
	private List<DetalleCompra> detalles;
	
	public Compra() {
		
	}

	public Compra(int idUsuario, LocalDate fechaCompra, double total, String rutaFactura) {
		super();
		this.idUsuario = idUsuario;
		this.fechaCompra = fechaCompra;
		this.total = total;
		this.rutaFactura = rutaFactura;
	}

	public Compra(int id, int idUsuario, LocalDate fechaCompra, double total, String rutaFactura) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.fechaCompra = fechaCompra;
		this.total = total;
		this.rutaFactura = rutaFactura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getRutaFactura() {
		return rutaFactura;
	}

	public void setRutaFactura(String rutaFactura) {
		this.rutaFactura = rutaFactura;
	}

	public List<DetalleCompra> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCompra> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", idUsuario=" + idUsuario + ", fechaCompra=" + fechaCompra + ", total=" + total
				+ ", rutaFactura=" + rutaFactura + "]";
	}
	
	

}
