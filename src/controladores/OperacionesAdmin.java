package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelos.Administrador;

public class OperacionesAdmin {
	
	/*
	 * En esta clase se desarrollarán todos los métodos para las operaciones de la base de datos de Administrador
	 */
	
	// Metodo para iniciar sesion
	
	public static boolean iniciarSesion(Administrador a) {
		boolean logueado = false;
		
		String nombre = a.getNombreAdmin();
		String clave = a.getContraseña();
		
		String sql = "SELECT * FROM administrador WHERE nombre_admin = ? AND contrasena = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setString(2, clave);
			
			logueado = ps.executeQuery().next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return logueado;
	}

}
