package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelos.Producto;

public class OperacionesAdmin {
	
	/*
	 * En esta clase se desarrollarán todos los métodos para las operaciones de la base de datos de Administrador
	 */
	
	// Obtener la lista de productos de la tabla productos
	
	public static List<Producto> obtenerListaProductos(){
		List<Producto> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM productos";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Producto p = new Producto();
				
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setCategoria(rs.getString("categoria"));
				p.setPrecioUnitario(rs.getDouble("precio_unitario"));
				p.setStock(rs.getInt("stock"));
				p.setIVA(rs.getInt("iva"));
				p.setDescuento(rs.getInt("descuento"));
				p.setRutaImagen(rs.getString("imagen_url"));
				
				lista.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	// Eliminar un producto de la tabla
	
	public static void eliminarProducto(int id) {
		String sql = "DELETE FROM productos WHERE id = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Filtrar por nombre o categoria en la tabla
	
	public static List<Producto> buscarProducto(String filtro) {
		List<Producto> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM productos WHERE LOWER(nombre) LIKE ? OR LOWER(categoria) LIKE ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%"+filtro+"%");
			ps.setString(2, "%"+filtro+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Producto p = new Producto();
	            p.setId(rs.getInt("id"));
	            p.setNombre(rs.getString("nombre"));
	            p.setDescripcion(rs.getString("descripcion"));
	            p.setCategoria(rs.getString("categoria"));
	            p.setPrecioUnitario(rs.getDouble("precio_unitario"));
	            p.setStock(rs.getInt("stock"));
	            p.setIVA(rs.getInt("iva"));
	            p.setDescuento(rs.getInt("descuento"));
	            p.setRutaImagen(rs.getString("imagen_url"));
	            
	            lista.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	// Obtener un producto segun su ID
	
	public static Producto obtenerProducto(int id) {
		Producto p = new Producto();
		
		String sql = "SELECT * FROM productos WHERE id = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
	            p.setDescripcion(rs.getString("descripcion"));
	            p.setCategoria(rs.getString("categoria"));
	            p.setPrecioUnitario(rs.getDouble("precio_unitario"));
	            p.setStock(rs.getInt("stock"));
	            p.setIVA(rs.getInt("iva"));
	            p.setDescuento(rs.getInt("descuento"));
	            p.setRutaImagen(rs.getString("imagen_url"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return p;
	}
	
	// Actualizar producto segun su ID
	
	public static void actualizarProducto(Producto producto) {
		String sql = "UPDATE productos "
				+ "SET nombre = ?, descripcion = ?, categoria = ?, precio_unitario = ?, stock = ?, iva = ?, descuento = ?, imagen_url = ? "
				+ "WHERE id = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDescripcion());
			ps.setString(3, producto.getCategoria());
			ps.setDouble(4, producto.getPrecioUnitario());
			ps.setInt(5, producto.getStock());
			ps.setInt(6, producto.getIVA());
			ps.setInt(7, producto.getDescuento());
			ps.setString(8, producto.getRutaImagen());
			
			ps.setInt(9, producto.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
