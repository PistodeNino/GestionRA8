package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controladores.OperacionesCliente;
import modelos.Cliente;
import modelos.Producto;
import modelos.ProductoInsertado;
import javax.swing.SwingConstants;

public class PanelProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	private Cliente cliente;
	
	private JButton comprar, carrito;

	/**
	 * Crea el panel.
	 */
	public PanelProducto(Producto producto, Cliente cliente) {
		this.producto = producto;
		this.cliente = cliente;
		
		setBorder(new LineBorder(new Color(64, 64, 64)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel imagen = new JLabel("");
		ImageIcon icon = new ImageIcon(producto.getRutaImagen());
		Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		imagen.setIcon(new ImageIcon(img));
		imagen.setBounds(40, 10, 150, 150);
		add(imagen);
		
		comprar = new JButton("Comprar");
		comprar.setBorder(null);
		comprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comprar.setBackground(new Color(64, 64, 64));
		comprar.setForeground(new Color(255, 255, 255));
		comprar.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		comprar.setBounds(10, 247, 144, 33);
		add(comprar);
		
		carrito = new JButton("");
		carrito.setIcon(new ImageIcon(getClass().getResource("/carrito-mini.png")));
		carrito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		carrito.setBorder(null);
		carrito.setBackground(new Color(92, 158, 255));
		carrito.setBounds(164, 247, 56, 33);
		add(carrito);
		
		JLabel titulo = new JLabel(producto.getNombre());
		titulo.setFont(new Font("Inter 28pt SemiBold", Font.PLAIN, 20));
		titulo.setBounds(10, 170, 210, 33);
		add(titulo);
		
		JLabel precio = new JLabel(String.format("%.2f €", producto.getPrecioUnitario()));
		precio.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		precio.setBounds(10, 204, 100, 33);
		add(precio);
		
		/*
		 * Manejadores de eventos
		 */
		
		comprar.addActionListener(new botones());
		carrito.addActionListener(new botones());
		
	}
	
	/*
	 * Clase privada para manejadores de eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == comprar) {
				PanelCompra compra = new PanelCompra(producto, cliente);
				compra.setVisible(true);
			}else if(boton == carrito){
				insertarProducto();
			}
		}
		
	}
	
	/*
	 * Métodos auxiliares
	 */
	
	public void insertarProducto() {
		int idUsuario = OperacionesCliente.obtenerCliente(cliente.getNombreUsuario(), cliente.getClave()).getId();
		int idProducto = OperacionesCliente.obtenerIdProducto(producto.getNombre());
		int cantidad = 1;
		
		ProductoInsertado prod = new ProductoInsertado(idUsuario, idProducto, cantidad);
		
		if(OperacionesCliente.insertarProductoCarrito(prod)) {
			JOptionPane.showMessageDialog(null, "Producto añadido con éxito");
		}else {
			JOptionPane.showMessageDialog(null, "Este producto ya está añadido en tu carrito");
		}
	}
}
