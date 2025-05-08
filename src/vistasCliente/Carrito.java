package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controladores.OperacionesCliente;
import modelos.Cliente;
import modelos.Producto;
import modelos.ProductoInsertado;

public class Carrito extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Cliente cliente;
	
	private JPanel contenedor;
	private JTextField productostf, totaltf;
	private JButton comprar, volver, crearFactura;
	
	private List<PanelCarritoProducto> listaProductos = new ArrayList<>();

	/**
	 * Create the frame.
	 */
	public Carrito(Cliente cliente) {
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navbar = new JPanel();
		navbar.setBackground(new Color(64, 64, 64));
		navbar.setBounds(-7, 0, 1280, 100);
		contentPane.add(navbar);
		
		JPanel contenido = new JPanel();
		contenido.setBounds(-7, 100, 1280, 620);
		contentPane.add(contenido);
		contenido.setLayout(null);
		
		contenedor = new JPanel();
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
		contenedor.setBackground(new Color(217, 217, 217));
		contenedor.setBorder(new EmptyBorder(20, 20, 20, 20));

		
		JScrollPane scrollPane = new JScrollPane(contenedor);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(110, 103, 800, 445);
		scrollPane.setViewportView(contenedor);
		contenido.add(scrollPane);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(64, 64, 64));
		separator1.setBounds(947, 103, 290, 2);
		contenido.add(separator1);
		
		JLabel resumen = new JLabel("Resumen");
		resumen.setHorizontalAlignment(SwingConstants.CENTER);
		resumen.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 30));
		resumen.setBounds(947, 48, 290, 45);
		contenido.add(resumen);
		
		JLabel carrito = new JLabel("Mi carrito");
		carrito.setHorizontalAlignment(SwingConstants.CENTER);
		carrito.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 30));
		carrito.setBounds(360, 48, 290, 45);
		contenido.add(carrito);
		
		JLabel totalProductos = new JLabel("Productos:");
		totalProductos.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		totalProductos.setBounds(947, 143, 140, 25);
		contenido.add(totalProductos);
		
		productostf = new JTextField();
		productostf.setBorder(null);
		productostf.setEditable(false);
		productostf.setBackground(new Color(240, 240, 240));
		productostf.setHorizontalAlignment(SwingConstants.CENTER);
		productostf.setFont(new Font("Inter 28pt SemiBold", Font.PLAIN, 20));
		productostf.setBounds(1141, 143, 96, 25);
		contenido.add(productostf);
		productostf.setColumns(10);
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(Color.DARK_GRAY);
		separator2.setBounds(947, 197, 290, 2);
		contenido.add(separator2);
		
		JLabel totalDinero = new JLabel("Total:");
		totalDinero.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 30));
		totalDinero.setBounds(947, 234, 140, 38);
		contenido.add(totalDinero);
		
		totaltf = new JTextField();
		totaltf.setHorizontalAlignment(SwingConstants.CENTER);
		totaltf.setFont(new Font("Inter 28pt SemiBold", Font.PLAIN, 30));
		totaltf.setEditable(false);
		totaltf.setColumns(10);
		totaltf.setBorder(null);
		totaltf.setBackground(UIManager.getColor("Button.background"));
		totaltf.setBounds(1097, 234, 140, 38);
		contenido.add(totaltf);
		
		comprar = new JButton("Finalizar compra");
		comprar.setForeground(new Color(255, 255, 255));
		comprar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		comprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comprar.setBorder(null);
		comprar.setBackground(new Color(64, 64, 64));
		comprar.setBounds(947, 424, 290, 57);
		contenido.add(comprar);
		
		volver = new JButton("");
		volver.setContentAreaFilled(false);
		volver.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setBorder(null);
		volver.setBounds(36, 508, 40, 40);
		contenido.add(volver);
		
		crearFactura = new JButton("Generar Factura");
		crearFactura.setEnabled(false);
		crearFactura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearFactura.setForeground(Color.WHITE);
		crearFactura.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		crearFactura.setBorder(null);
		crearFactura.setBackground(new Color(92, 158, 255));
		crearFactura.setBounds(947, 491, 290, 57);
		contenido.add(crearFactura);
		
		cargarProductosCarrito();
		
		/*
		 * Manejadores de eventos
		 */
		
		volver.addActionListener(new botones());
		comprar.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejadores de eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == volver) {
				Principal princ = new Principal(cliente);
				princ.setVisible(true);
				dispose();
			}else if(boton == comprar) {
				
			}
		}
		
	}
	
	/*
	 * Métodos auxiliares
	 */
	
	public void cargarProductosCarrito() {
		List<ProductoInsertado> carrito = OperacionesCliente.obtenerCarrito(cliente.getId());

		for (ProductoInsertado prod : carrito) {
			Producto p = OperacionesCliente.obtenerProducto(prod.getIdProducto());
			PanelCarritoProducto panel = new PanelCarritoProducto(cliente, p, this);
			
			Dimension tamanyo = new Dimension(700, 130);
			panel.setMinimumSize(tamanyo);
			panel.setPreferredSize(tamanyo);
			panel.setMaximumSize(tamanyo);

			
			listaProductos.add(panel);
			
			contenedor.add(Box.createVerticalStrut(10));
			contenedor.add(panel);
		}

		contenedor.revalidate();
		contenedor.repaint();
		
		actualizarResumen();
		
	}
	
	public void actualizarResumen() {
		double precioTotal = 0.00D;
		int cantidad = 0;

		productostf.setText("0");
		totaltf.setText("0.00€");

		for (PanelCarritoProducto panel : listaProductos) {
			String precioTexto = panel.getPrecio().getText().replace("€", "").replace(",", ".").trim();
			String cantidadTexto = panel.getCantidad().getText().trim();
			
			if (!precioTexto.isEmpty() && !cantidadTexto.isEmpty()) {
				double precio = Double.parseDouble(precioTexto);
				int unidades = Integer.parseInt(cantidadTexto);

				precioTotal += precio * unidades;
				cantidad += unidades;
			}
		}

		productostf.setText(String.valueOf(cantidad));
		totaltf.setText(String.format("%.2f€", precioTotal));
	}
	
	public void eliminarProducto(PanelCarritoProducto panel) {
	    listaProductos.remove(panel);
	    contenedor.remove(panel);
	    contenedor.revalidate();
	    contenedor.repaint();
	    actualizarResumen();
	}
}
