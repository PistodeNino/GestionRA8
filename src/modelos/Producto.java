package modelos;

import java.util.Random;

public class Producto {

	private int id, stock, IVA, descuento;
	private String categoria, nombre, descripcion, rutaImagen;
	private double precioUnitario, promedioValoracion;

	public Producto() {

	}

	/*public Producto(String categoria, String nombre, String descripcion, double precioUnitario, int stock, int iVA,
			int descuento, String rutaImagen) {
		super();
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
		IVA = iVA;
		this.descuento = descuento;
		this.rutaImagen = rutaImagen;
		this.promedioValoracion = new Random().nextDouble(1, 6);
	}*/
	
	public Producto(String nombre, String descripcion, String categoria,double precioUnitario, int stock, int iva, int descuento, String rutaImagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
		this.IVA = iva;
		this.descuento = descuento;
		this.rutaImagen = rutaImagen;
	}

	public Producto(int id, String nombre, String descripcion, String categoria,double precioUnitario, int stock, int iva, int descuento, String rutaImagen) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
		this.IVA = iva;
		this.descuento = descuento;
		this.rutaImagen = rutaImagen;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIVA() {
		return IVA;
	}

	public void setIVA(int iVA) {
		IVA = iVA;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public double getPromedioValoracion() {
		return promedioValoracion;
	}

	public void setPromedioValoracion(double promedioValoracion) {
		this.promedioValoracion = promedioValoracion;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", categoria=" + categoria + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precioUnitario=" + precioUnitario + ", stock=" + stock + ", IVA=" + IVA + ", descuento="
				+ descuento + ", rutaImagen=" + rutaImagen + ", promedioValoracion=" + promedioValoracion + "]";
	}

}
