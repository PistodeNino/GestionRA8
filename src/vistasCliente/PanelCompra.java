package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controladores.OperacionesCliente;
import modelos.Cliente;
import modelos.Compra;
import modelos.DetalleCompra;
import modelos.Producto;

public class PanelCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton incremento, decremento, crearFactura, comprar;
	private JTextField cantidadtf;
	private JPanel panel;
	private JLabel importe;
	private JTextField totaltf;
	
	private Producto producto;
	private Cliente cliente;
	
	private Compra compraActual;
	private int idCompraActual;
	
	private double precioTotal;
	
	private int contador = 1;

	/**
	 * Create the frame.
	 */
	public PanelCompra(Producto producto, Cliente cliente) {
		this.producto = producto;
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imagen = new JLabel();
		ImageIcon iconoOriginal = new ImageIcon(producto.getRutaImagen());
		Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		imagen.setIcon(new ImageIcon(imagenEscalada));
		imagen.setBorder(null);
		imagen.setBounds(20, 20, 150, 150);
		contentPane.add(imagen);
		
		JLabel nombre = new JLabel(producto.getNombre());
		nombre.setForeground(new Color(64, 64, 64));
		nombre.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 20));
		nombre.setBounds(202, 20, 454, 34);
		contentPane.add(nombre);
		
		JLabel descripcion = new JLabel(producto.getDescripcion());
		descripcion.setForeground(Color.DARK_GRAY);
		descripcion.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		descripcion.setBounds(202, 76, 542, 34);
		contentPane.add(descripcion);
		
		crearFactura = new JButton("Generar factura");
		crearFactura.setEnabled(false);
		crearFactura.setForeground(new Color(255, 255, 255));
		crearFactura.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		crearFactura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearFactura.setBorder(null);
		crearFactura.setBackground(new Color(172, 206, 255));
		crearFactura.setBounds(20, 330, 724, 39);
		contentPane.add(crearFactura);
		
		comprar = new JButton("Finalizar compra");
		comprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comprar.setForeground(Color.WHITE);
		comprar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		comprar.setBorder(null);
		comprar.setBackground(new Color(64, 64, 64));
		comprar.setBounds(20, 280, 724, 39);
		contentPane.add(comprar);
		
		JPanel panelCantidad = new JPanel();
		panelCantidad.setBorder(new LineBorder(new Color(64, 64, 64)));
		panelCantidad.setBounds(20, 200, 150, 50);
		contentPane.add(panelCantidad);
		panelCantidad.setLayout(null);
		
		decremento = new JButton("-");
		decremento.setForeground(new Color(255, 255, 255));
		decremento.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		decremento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		decremento.setBorder(null);
		decremento.setBackground(new Color(64, 64, 64));
		decremento.setBounds(5, 5, 40, 40);
		panelCantidad.add(decremento);
		
		incremento = new JButton("+");
		incremento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		incremento.setForeground(Color.WHITE);
		incremento.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		incremento.setBorder(null);
		incremento.setBackground(Color.DARK_GRAY);
		incremento.setBounds(105, 5, 40, 40);
		panelCantidad.add(incremento);
		
		cantidadtf = new JTextField();
		cantidadtf.setText(String.valueOf(contador));
		cantidadtf.setBackground(new Color(255, 255, 255));
		cantidadtf.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadtf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		cantidadtf.setEditable(false);
		cantidadtf.setBounds(55, 5, 40, 40);
		panelCantidad.add(cantidadtf);
		cantidadtf.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(64, 64, 64)));
		panel.setBounds(202, 136, 303, 34);
		contentPane.add(panel);
		panel.setLayout(null);
		
		importe = new JLabel("Importe total:");
		importe.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		importe.setBounds(10, 4, 150, 25);
		panel.add(importe);
		
		precioTotal = producto.getPrecioUnitario() * Double.valueOf(cantidadtf.getText());
		
		totaltf = new JTextField();
		totaltf.setText(String.format("%.2f€", precioTotal));
		totaltf.setEditable(false);
		totaltf.setFocusable(false);
		totaltf.setBorder(null);
		totaltf.setBackground(new Color(240, 240, 240));
		totaltf.setHorizontalAlignment(SwingConstants.CENTER);
		totaltf.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 20));
		totaltf.setBounds(147, 4, 150, 25);
		panel.add(totaltf);
		totaltf.setColumns(10);
		
		/*
		 * Manejadores de eventos
		 */
		
		comprar.addActionListener(new botones());
		crearFactura.addActionListener(new botones());
		incremento.addActionListener(new botones());
		decremento.addActionListener(new botones());
		
	}
	
	/*
	 * Clase privada para manejar los eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == incremento) {
				contador++;
				cantidadtf.setText(String.valueOf(contador));
				actualizarTotal();
			}else if(boton == decremento) {
				if(contador > 1) {
					contador--;
				}
				cantidadtf.setText(String.valueOf(contador));
				actualizarTotal();
			}else if(boton == comprar) {
				comprar();
			}else if(boton == crearFactura) {
				generarFactura();
			}
		}
		
	}
	
	/*
	 * Métodos auxiliares
	 */
	
	private void actualizarTotal() {
	    double precioTotal = producto.getPrecioUnitario() * contador;
	    totaltf.setText(String.format("%.2f€", precioTotal));
	}
	
	public void comprar() {
		int idUsuario = OperacionesCliente.obtenerCliente(cliente.getNombreUsuario(), cliente.getClave()).getId();
		LocalDate fechaCompra = LocalDate.now();
		double total = precioTotal * Double.parseDouble(cantidadtf.getText());
		String rutaFactura = "";
		
		int idProducto = OperacionesCliente.obtenerIdProducto(producto.getNombre());
		int cantidad = Integer.parseInt(cantidadtf.getText());
		
		int stockDisponible = OperacionesCliente.obtenerStock(idProducto);
		
		if(cantidad > stockDisponible) {
			JOptionPane.showMessageDialog(null, "No hay suficiente stock para realizar esta compra.", "Stock insuficiente", JOptionPane.WARNING_MESSAGE);
			return;
		}else {
			compraActual = new Compra(idUsuario, fechaCompra, total, rutaFactura);
			
			// 1.Ahora se recupera el id de esa compra
			
			idCompraActual = OperacionesCliente.insertarCompra(compraActual);
			JOptionPane.showMessageDialog(null, "Has realizado con exito la compra");
			
			// 2.Una vez tengo el ID, creo un objeto de la clase DetalleCompra
			// 3.Le asigno ese id_compra, junto con el id_producto, cantidad y precio_unitario
			
			
			
			double precioUnidad = producto.getPrecioUnitario();
			
			DetalleCompra detalle = new DetalleCompra(idCompraActual, idProducto, cantidad, precioUnidad);
			
			// 4.Lo inserto en la base de datos, tabla detalles_compra
			
			OperacionesCliente.insertarDetalleCompra(detalle);
			
			// 5.Añadir a la lista de detalles
			
			List<DetalleCompra> lista = new ArrayList<>();
			lista.add(detalle);
			compraActual.setDetalles(lista);
			
			OperacionesCliente.restarStock(idProducto, cantidad);
			
			crearFactura.setBackground(new Color(92, 158, 255));
			crearFactura.setEnabled(true);
		}
	}
	
	public void generarFactura() {
		// 6.Llamo al metodo generarFactura(Compra c)
		// 7. Creo el PDF y lo guarda en la ruta

		String rutaFactura = OperacionesCliente.generarFactura(compraActual, cliente);

		// 8. Actualizar la ruta del PDF en la tabla compras de la base de datos, con un
		// UPDATE

		OperacionesCliente.actualizarRutaFactura(idCompraActual, rutaFactura);
		
		JOptionPane.showMessageDialog(null, "Factura generada correctamente");
		dispose();
	}

}
