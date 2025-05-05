package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Cliente;
import modelos.Producto;

public class OperacionesCliente {
	
	/*
	 * En esta clase estarán todas las operaciones de la base de datos relacionadas con los clientes
	 */
	
	// Metodo para Iniciar Sesion
	
	public static boolean iniciarSesion(Cliente c) {
		boolean sesionIniciada = false;
		
		String nombre = c.getNombreUsuario();
		String clave = c.getClave();
		
		String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setString(2, clave);
			
			sesionIniciada = ps.executeQuery().next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return sesionIniciada;
	}
	
	// Metodo para registrar a un nuevo usuario
	
	public static boolean registrarUsuario(Cliente c) {
		boolean registrado = false;
		
		String correo = c.getCorreo();
		String nombre = c.getNombreUsuario();
		String telefono = c.getTelefono();
		String clave = c.getClave();
		
		String sql = "INSERT INTO usuarios (nombre_usuario, correo, contrasena, telefono) VALUES (?, ?, ?, ?)";
		
		if(usuarioExiste(nombre)) {
			registrado = false;
		}else {
			try {
				Connection conn = Conexion.obtener();
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, nombre);
				ps.setString(2, correo);
				ps.setString(3, clave);
				ps.setString(4, telefono);
				
				ps.executeUpdate();
				
				registrado = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return registrado;
	}
	
	// Metodo para comprobar si un usuario existe
	
	public static boolean usuarioExiste(String nombre) {
		boolean existe = false;
		String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ?";

		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nombre);
			ResultSet rs = ps.executeQuery();
			
			existe = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return existe;
	}
	
	// Obtener todos los productos de una determinada categoria
	
	public static List<Producto> obtenerProductos(String categoria){
		List<Producto> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM productos WHERE categoria = ? OR LOWER(nombre) LIKE ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, categoria);
			ps.setString(2, "%"+categoria+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Producto p = new Producto();
				
				p.setId(rs.getInt("id"));
				p.setCategoria(rs.getString("categoria"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setPrecioUnitario(rs.getDouble("precio_unitario"));
				p.setStock(rs.getInt("stock"));
				p.setIVA(rs.getInt("IVA"));
				p.setDescuento(rs.getInt("descuento"));
				p.setRutaImagen(rs.getString("imagen_url"));
				p.setPromedioValoracion(0.00);
				
				lista.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	// Obtener datos de un usuario segun su nombre y contraseña
	
	public static Cliente obtenerCliente(String nombre, String contraseña) {
		Cliente cliente = new Cliente();
		
		String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setString(2, contraseña);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cliente = new Cliente(rs.getString("correo"), rs.getString("nombre_usuario"), rs.getString("telefono"), rs.getString("contrasena"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return cliente;
	}

}
