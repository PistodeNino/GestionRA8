package modelos;

public class DetallePedido {
	
	private int id;
	private int idPedido;
	private int idProducto;
	private int cantidad;
	
	public DetallePedido() {
		
	}

	public DetallePedido(int idPedido, int idProducto, int cantidad) {
		super();
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public DetallePedido(int id, int idPedido, int idProducto, int cantidad) {
		super();
		this.id = id;
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", idPedido=" + idPedido + ", idProducto=" + idProducto + ", cantidad="
				+ cantidad + "]";
	}
	
	

}
