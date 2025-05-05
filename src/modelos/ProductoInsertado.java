package modelos;

public class ProductoInsertado {
	
	private int id, idUsuario, idProducto, cantidad;
	
	public ProductoInsertado() {
		
	}

	public ProductoInsertado(int idUsuario, int idProducto, int cantidad) {
		super();
		this.idUsuario = idUsuario;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public ProductoInsertado(int id, int idUsuario, int idProducto, int cantidad) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
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
		return "ProductoAñadido [id=" + id + ", idUsuario=" + idUsuario + ", idProducto=" + idProducto + ", cantidad="
				+ cantidad + "]";
	}
	
	

}
