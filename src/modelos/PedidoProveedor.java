package modelos;

import java.time.LocalDate;

public class PedidoProveedor {
	
	private int id;
	private int idAdministrador;
	private boolean realizado;
	private LocalDate fechaPedido;
	
	public PedidoProveedor() {
		
	}

	public PedidoProveedor(int idAdministrador, boolean realizado, LocalDate fechaPedido) {
		super();
		this.idAdministrador = idAdministrador;
		this.realizado = realizado;
		this.fechaPedido = fechaPedido;
	}

	public PedidoProveedor(int id, int idAdministrador, boolean realizado, LocalDate fechaPedido) {
		super();
		this.id = id;
		this.idAdministrador = idAdministrador;
		this.realizado = realizado;
		this.fechaPedido = fechaPedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	@Override
	public String toString() {
		return "PedidoProveedor [id=" + id + ", idAdministrador=" + idAdministrador + ", realizado=" + realizado
				+ ", fechaPedido=" + fechaPedido + "]";
	}
	
	

}
