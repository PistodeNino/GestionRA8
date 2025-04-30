package modelos;

public class DetalleCompra {
	
	private int id;
	private int idCompra;
	private int idProducto;
	private int cantidad;
	private double precioUnitario;
	
	public DetalleCompra() {
		
	}

	public DetalleCompra(int idCompra, int idProducto, int cantidad, double precioUnitario) {
		super();
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public DetalleCompra(int id, int idCompra, int idProducto, int cantidad, double precioUnitario) {
		super();
		this.id = id;
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
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

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "DetalleCompra [id=" + id + ", idCompra=" + idCompra + ", idProducto=" + idProducto + ", cantidad="
				+ cantidad + ", precioUnitario=" + precioUnitario + "]";
	}
	
	

}
