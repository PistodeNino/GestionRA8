package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controladores.OperacionesCliente;
import modelos.Cliente;
import modelos.Producto;
import modelos.ProductoInsertado;

public class PanelCarritoProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//private ProductoInsertado producto;
	private Cliente cliente;
	private Carrito carrito;
	private Producto producto;
	
	private JTextField cantidad;
	private JButton mas, menos, eliminar, comprar;
	private JLabel precio;
	
	private int contador = 1;

	/**
	 * Create the panel.
	 */
	public PanelCarritoProducto(Cliente cliente, Producto producto, Carrito carrito) {
		setBackground(new Color(255, 255, 255));
		
		this.cliente = cliente;
		this.carrito = carrito;
		this.producto = producto;
		
		setBorder(new LineBorder(new Color(64, 64, 64)));
		setLayout(null);
		
		JLabel imagen = new JLabel("");
		imagen.setBorder(null);
		imagen.setBounds(15, 15, 100, 100);
		ImageIcon iconoOriginal = new ImageIcon(producto.getRutaImagen());
		Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		imagen.setIcon(new ImageIcon(imagenEscalada));

		add(imagen);
		
		JLabel nombre = new JLabel(producto.getNombre());
		nombre.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		nombre.setBounds(125, 15, 319, 34);
		add(nombre);
		
		precio = new JLabel(String.format("%.2f€", producto.getPrecioUnitario()));
		precio.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		precio.setBounds(125, 81, 319, 34); 
		add(precio);
		
		comprar = new JButton("Comprar ya");
		comprar.setForeground(new Color(255, 255, 255));
		comprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comprar.setBorder(null);
		comprar.setBackground(new Color(92, 158, 255));
		comprar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		comprar.setBounds(454, 75, 236, 40);
		add(comprar);
		
		eliminar = new JButton("");
		eliminar.setIcon(new ImageIcon(getClass().getResource("/eliminar.png")));
		eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminar.setForeground(Color.WHITE);
		eliminar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		eliminar.setBorder(null);
		eliminar.setBackground(new Color(255, 106, 61));
		eliminar.setBounds(580, 25, 110, 40);
		add(eliminar);
		
		JPanel panelContador = new JPanel();
		panelContador.setBackground(new Color(255, 255, 255));
		panelContador.setBorder(new LineBorder(new Color(64, 64, 64)));
		panelContador.setBounds(454, 25, 110, 40);
		add(panelContador);
		panelContador.setLayout(null);
		
		menos = new JButton("-");
		menos.setForeground(new Color(255, 255, 255));
		menos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menos.setBorder(null);
		menos.setBackground(new Color(64, 64, 64));
		menos.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		menos.setBounds(5, 5, 30, 30);
		panelContador.add(menos);
		
		mas = new JButton("+");
		mas.setForeground(Color.WHITE);
		mas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mas.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		mas.setBorder(null);
		mas.setBackground(Color.DARK_GRAY);
		mas.setBounds(75, 5, 30, 30);
		panelContador.add(mas);
		
		cantidad = new JTextField();
		cantidad.setText(String.valueOf(contador));
		cantidad.setEditable(false);
		cantidad.setBackground(new Color(255, 255, 255));
		cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		cantidad.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		cantidad.setBounds(40, 5, 30, 30);
		panelContador.add(cantidad);
		cantidad.setColumns(10);
		
		/*
		 * Manejadores de eventos
		 */

		mas.addActionListener(new botones());
		menos.addActionListener(new botones());
		eliminar.addActionListener(new botones());
		comprar.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejadores de eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == menos) {
				decrementar();
				carrito.actualizarResumen();
			}else if(boton == mas) {
				incrementar();
				carrito.actualizarResumen();
			}else if(boton == eliminar) {
				eliminarProducto();
			}else if(boton == comprar) {
				
			}
		}
	}
	
	/*
	 * Métodos auxiliares
	 */
	
	public void eliminarProducto() {
		int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar este producto de su cesta?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(opcion == 0) {
			OperacionesCliente.eliminarProducto(producto.getId(), cliente.getId());
			JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
			carrito.eliminarProducto(this);
		}
	}
	
	public void incrementar() {
		contador++;
		cantidad.setText(String.valueOf(contador));
	}

	public void decrementar() {
		if (contador > 1) {
			contador--;
		}
		cantidad.setText(String.valueOf(contador));
	}

	/*public ProductoInsertado getProducto() {
		return producto;
	}

	public void setProducto(ProductoInsertado producto) {
		this.producto = producto;
	}*/

	public JTextField getCantidad() {
		return cantidad;
	}

	public void setCantidad(JTextField cantidad) {
		this.cantidad = cantidad;
	}
	
	public JLabel getPrecio() {
		return precio;
	}

}
