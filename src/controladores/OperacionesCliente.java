package controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import modelos.Cliente;
import modelos.Compra;
import modelos.DetalleCompra;
import modelos.Producto;
import modelos.ProductoInsertado;

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
	
	// Metodo para obtener el rol de un usuario segun sus credenciales
	
	public static String obtenerRol(Cliente c) {
		String rol = "";
		
		String sql = "SELECT rol FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, c.getNombreUsuario());
			ps.setString(2, c.getClave());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rol = rs.getString("rol");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rol;
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
				cliente = new Cliente(rs.getInt("id"), rs.getString("correo"), rs.getString("nombre_usuario"), rs.getString("telefono"), rs.getString("contrasena"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	// Obtener ID de un producto segun su nombre
	
	public static int obtenerIdProducto(String nombre) {
		int id = 0;
		
		String sql = "SELECT id FROM productos WHERE nombre = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, nombre);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return id;
	}
	
	// Insertar producto en la tabla 'Carrito'
	
	public static boolean insertarProductoCarrito(ProductoInsertado prod) {
		boolean añadido = false;
		
		String sql = "INSERT INTO carrito (id_usuario, id_producto, cantidad) VALUES (?, ?, ?)";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(productoExiste(prod.getIdProducto(), prod.getIdUsuario())) {
				añadido = false;
			}else {
				ps.setInt(1, prod.getIdUsuario());
				ps.setInt(2, prod.getIdProducto());
				ps.setInt(3, prod.getCantidad());
			
				ps.executeUpdate();
				
				añadido = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return añadido;
	}
	
	// Comprobar si un producto ya existe en el carrito
	
	public static boolean productoExiste(int id, int idUsuario) {
		boolean existe = false;
		
		String sql = "SELECT * FROM carrito WHERE id_producto = ? AND id_usuario = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.setInt(2, idUsuario);
			
			ResultSet rs = ps.executeQuery();
			
			existe = rs.next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return existe;
	}
	
	// Obtener los productos añadidos al carrito segun el ID del usuario
	
	public static List<ProductoInsertado> obtenerCarrito(int idUsuario){
		List<ProductoInsertado> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM carrito WHERE id_usuario = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, idUsuario);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int idProducto = rs.getInt("id_producto");
				int cantidad = rs.getInt("cantidad");

				ProductoInsertado pi = new ProductoInsertado(idUsuario, idProducto, cantidad);
				lista.add(pi);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	// Obtener un producto segun el ID
	
	public static Producto obtenerProducto(int id) {
		Producto producto = new Producto();
		
		String sql = "SELECT * FROM productos WHERE id = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				producto = new Producto(
						rs.getInt("id"),
						rs.getString("categoria"),
						rs.getString("nombre"),
						rs.getString("descripcion"),
						rs.getDouble("precio_unitario"),
						rs.getInt("stock"),
						rs.getInt("IVA"),
						rs.getInt("descuento"),
						rs.getString("imagen_url")
					);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return producto;
	}
	
	// Eliminar producto del carrito
	
	public static void eliminarProducto(int idProducto, int idUsuario) {
		String sql = "DELETE FROM carrito WHERE id_producto = ? AND id_usuario = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, idProducto);
			ps.setInt(2, idUsuario);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Insertar compra en tabla Compras
	
	public static int insertarCompra(Compra c) {
		int idGenerado = -1;
		
		String sql = "INSERT INTO compras (id_usuario, fecha_compra, total, pdf_factura) VALUES (?, ?, ?, ?)";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, c.getIdUsuario());
			ps.setDate(2, java.sql.Date.valueOf(c.getFechaCompra()));
			ps.setDouble(3, c.getTotal());
			ps.setString(4, c.getRutaFactura());
			
			int confirmacion = ps.executeUpdate();
			
			if(confirmacion == 1) {
				ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                idGenerado = rs.getInt(1);
	                c.setId(idGenerado);
	            }
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return idGenerado;
	}
	
	// Generar el PDF de una compra
	
	public static String generarFactura(Compra compra) {
		String ruta = "";
		
		JFileChooser explorador = new JFileChooser();
		explorador.setDialogTitle("Selecciona donde quieres guardar tu factura");
		explorador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		explorador.setAcceptAllFileFilterUsed(false);
		
		int seleccion = explorador.showSaveDialog(null);
		
		if(seleccion == JFileChooser.APPROVE_OPTION) {
			File carpeta = explorador.getSelectedFile();
			ruta = carpeta.getAbsolutePath() + "/factura_compra_" + compra.getId() + ".pdf";
		}
		
	    try {
	        Document document = new Document();
	        PdfWriter.getInstance(document, new FileOutputStream(ruta));
	        document.open();
	        
	        document.add(new Paragraph("- Factura de compra -"));
	        document.add(new Paragraph("---------------------------------"));
	        document.add(new Paragraph("Fecha: " + compra.getFechaCompra()));
	        document.add(new Paragraph("\n"));
	        
	        for (DetalleCompra detalle : compra.getDetalles()) {
	            document.add(new Paragraph("Producto: " + obtenerProducto(detalle.getIdProducto()).getNombre()));
	            document.add(new Paragraph("Cantidad: " + detalle.getCantidad()));
	            document.add(new Paragraph("Precio unitario: " + String.format("%.2f €", detalle.getPrecioUnitario())));
	            document.add(new Paragraph("Total: " + detalle.getPrecioUnitario() * detalle.getCantidad()));
	            document.add(new Paragraph("\n"));
	        }
	        
	        document.add(new Paragraph("Total de la compra: " + String.format("%.2f €", compra.getTotal())));
	        document.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return ruta;
	}

	// Insertar fila en tabla detalles_compra
	
	public static boolean insertarDetalleCompra(DetalleCompra detalle) {
	    boolean insertado = false;
	    
	    String sql = "INSERT INTO detalle_compra (id_compra, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";

	    try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, detalle.getIdCompra());
			ps.setInt(2, detalle.getIdProducto());
			ps.setInt(3, detalle.getCantidad());
			ps.setDouble(4, detalle.getPrecioUnitario());
			
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

	// Actualizar la ruta de la factura en tabla compras
	
	public static void actualizarRutaFactura(int idCompra, String rutaFactura) {
		String sql = "UPDATE compras SET pdf_factura = ? WHERE id = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, rutaFactura);
			ps.setInt(2, idCompra);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Vaciar carrito de la compra
	
	public static void vaciarCarrito(int idUsuario) {
		String sql = "DELETE FROM carrito WHERE id_usuario = ?";
		
		try {
			Connection conn = Conexion.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, idUsuario);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
