package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static String url = "jdbc:mysql://127.0.0.1:3306/sql7776134?serverTimezone=Europe/Madrid&useSSL=false&allowPublicKeyRetrieval=true";
	private static String controllerName = "com.mysql.cj.jdbc.Driver";
	private static String username = "root";
	private static String password = "root";

	private static Connection cnx = null;

	public static Connection obtener() throws SQLException {
		if (cnx == null || cnx.isClosed()) {
			try {
				Class.forName(controllerName);
				cnx = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				throw new SQLException("Driver not found", e);
			}
		}
		return cnx;
	}

	public static void cerrar() throws SQLException {
		if (cnx != null) {
			cnx.close();
		}
	}

}
