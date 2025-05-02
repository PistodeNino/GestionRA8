package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import modelos.Producto;

public class PanelProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;

	/**
	 * Create the panel.
	 */
	public PanelProducto(Producto producto) {
		this.producto = producto;
		
		setBorder(new LineBorder(new Color(64, 64, 64)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel imagen = new JLabel("");
		ImageIcon icon = new ImageIcon(producto.getRutaImagen());
		Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		imagen.setIcon(new ImageIcon(img));
		imagen.setBounds(40, 10, 150, 150);
		add(imagen);
		
		JButton comprar = new JButton("Comprar");
		comprar.setBorder(null);
		comprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comprar.setBackground(new Color(64, 64, 64));
		comprar.setForeground(new Color(255, 255, 255));
		comprar.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		comprar.setBounds(10, 247, 144, 33);
		add(comprar);
		
		JButton carrito = new JButton("");
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
		
		JLabel precio = new JLabel(String.format("%.2f€", producto.getPrecioUnitario()));
		precio.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		precio.setBounds(10, 204, 210, 33);
		add(precio);
		
		
	}

}
