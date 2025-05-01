package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Cliente;

public class OperacionesCliente {
	
	/*
	 * En esta clase estarán todas las operaciones de la base de datos relacionadas con los clientes
	 */
	
	// Metodo para Iniciar Sesion
	
	public static boolean iniciarSesion(Cliente c) {
		boolean sesionIniciada = false;
		
		String nombre = c.getNombreUsuario();
		String clave = c.getContraseña();
		
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
		String clave = c.getContraseña();
		
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

}
