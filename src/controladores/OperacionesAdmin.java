package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modelos.Cliente;
import modelos.DetalleCompra;
import modelos.Producto;
import modelos.TopProducto;

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
	
	public static boolean eliminarProducto(int id) {
		String sql = "DELETE FROM productos WHERE id = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int filas = ps.executeUpdate();
			return filas > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
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
	
	// Insertar una venta 
	
	public static boolean insertarVentaDesdeCompra(DetalleCompra detalle) {
		boolean insertado = false;
		
		String sql = "INSERT INTO ventas (producto_id, unidades_compradas) VALUES (?, ?)";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, detalle.getIdProducto());
			ps.setInt(2, detalle.getCantidad());
			
			int filas = ps.executeUpdate();
			
			if(filas > 0) {
				insertado = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return insertado;
	}
	
	// Calcular ganancias totales
	
	public static double calcularGananciasTotales() {
		double ganancias = 0.00D;
		
		String sql = "SELECT"
				+ "            SUM("
				+ "                (p.precio_unitario * (1 + p.iva / 100) * (1 - p.descuento / 100)) * v.unidades_compradas"
				+ "            ) AS ganancias_totales\r\n"
				+ "        FROM ventas v"
				+ "        JOIN productos p ON v.producto_id = p.id";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ganancias = rs.getDouble("ganancias_totales");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ganancias;
	}
	
	// Calcular total de clientes
	
	public static int calcularClientes() {
		int clientes = 0;
		
		String sql = "SELECT COUNT(*) AS total_clientes FROM usuarios WHERE rol = 'cliente'";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				clientes = rs.getInt("total_clientes");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	// Obtener top de productos mas vendidos
	
	public static List<TopProducto> obtenerTop(){
		List<TopProducto> lista = new ArrayList<>();
		
		String sql = "SELECT p.nombre, SUM(v.unidades_compradas) AS total_vendido "
				+ "FROM ventas v "
				+ "JOIN productos p ON v.producto_id = p.id "
				+ "GROUP BY v.producto_id "
				+ "ORDER BY total_vendido DESC LIMIT 3";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				TopProducto p = new TopProducto();
				p.setNombre(rs.getString("nombre"));
				p.setUnidades(rs.getInt("total_vendido"));
				lista.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	// Obtener las categorias mas vendidas
	
	public static Map<String, Integer> obtenerCategorias(){
		Map<String, Integer> mapa = new HashMap<>();
		
		String sql = "SELECT p.categoria, SUM(v.unidades_compradas) AS total_vendido "
				+ "FROM ventas v "
				+ "JOIN productos p ON v.producto_id = p.id "
				+ "GROUP BY p.categoria "
				+ "ORDER BY total_vendido DESC";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String categoria = rs.getString("categoria");
				int total = rs.getInt("total_vendido");
				
				mapa.put(categoria, total);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return mapa;
	}
	
	// Obtener las ganancias por dias
	
	public static Map<LocalDate, Double> obtenerGananciasDiarias(){
		Map<LocalDate, Double> mapa = new HashMap<>();
		
		String sql = "SELECT DATE(v.fecha) AS dia, SUM(p.precio_unitario * (1 + p.iva / 100) * (1 - p.descuento / 100) * v.unidades_compradas) AS total_ganado FROM ventas v JOIN productos p ON v.producto_id = p.id WHERE v.fecha >= CURDATE() - INTERVAL 30 DAY GROUP BY dia ORDER BY dia ASC";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				LocalDate fecha = rs.getDate("dia").toLocalDate();
				double total = rs.getDouble("total_ganado");
				mapa.put(fecha, total);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return mapa;
	}
	
	// Obtener todas las categorias
	
	public static Set<String> obtenerListaCategorias(){
		Set<String> lista = new HashSet<>();
		
		String sql = "SELECT categoria FROM productos";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				lista.add(rs.getString("categoria"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	// Insertar un producto en la tabla
	
	public static boolean insertarProducto(Producto p) {
		boolean insertado = false;
		
		String sql = "INSERT INTO productos (nombre, descripcion, categoria, precio_unitario, stock, iva, descuento, imagen_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getDescripcion());
			ps.setString(3, p.getCategoria());
			ps.setDouble(4, p.getPrecioUnitario());
			ps.setInt(5, p.getStock());
			ps.setInt(6, p.getIVA());
			ps.setInt(7, p.getDescuento());
			ps.setString(8, p.getRutaImagen());
			
			if(ps.executeUpdate() == 1) {
				insertado = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return insertado;
	}
	
	// Obtener lista de usuarios
	
	public static List<Cliente> obtenerListaUsuarios(){
		List<Cliente> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM usuarios WHERE rol NOT LIKE 'admin'";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setCorreo(rs.getString("correo"));
				c.setNombreUsuario(rs.getString("nombre_usuario"));
				c.setTelefono(rs.getString("telefono"));
				c.setClave(rs.getString("contrasena"));
				c.setRol(rs.getString("rol"));
				
				lista.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	// Eliminar cliente segun su id
	
	public static boolean eliminarCliente(int id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int filas = ps.executeUpdate();
			return filas > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	// Obtener cliente segun su id
	
	public static Cliente obtenerCliente(int id) {
		Cliente c = new Cliente();
		
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setCorreo(rs.getString("correo"));
				c.setNombreUsuario(rs.getString("nombre_usuario"));
				c.setTelefono(rs.getString("telefono"));
				c.setClave(rs.getString("contrasena"));
				c.setRol(rs.getString("rol"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return c;
	}
	
	// Actualizar cliente
	
	public static void actualizarCliente(Cliente cliente) {
		String sql = "UPDATE usuarios SET nombre_usuario = ?, correo = ?, contrasena = ?, telefono = ?, rol = ? WHERE id = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, cliente.getNombreUsuario());
			ps.setString(2, cliente.getCorreo());
			ps.setString(3, cliente.getClave());
			ps.setString(4, cliente.getTelefono());
			ps.setString(5, cliente.getRol());
			ps.setInt(6, cliente.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
