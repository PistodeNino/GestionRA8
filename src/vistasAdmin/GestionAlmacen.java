package vistasAdmin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controladores.OperacionesAdmin;
import modelos.Cliente;
import modelos.Producto;

public class GestionAlmacen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm;
	private JButton eliminar, editar, buscar, volver, añadir, pedir;
	
	private List<Producto> lista;
	private List<Producto> listaOriginal;
	private JTextField busquedatf;
	
	private Cliente cliente;
	private JLabel logo; 

	/**
	 * Create the frame.
	 */
	public GestionAlmacen(Cliente cliente) {
		setTitle("Gestiona tu almacén");
		ImageIcon icon = new ImageIcon(getClass().getResource("/cajas.png"));
        setIconImage(icon.getImage());
		
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
		navbar.setLayout(null);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(getClass().getResource("/logo3.png")));
		logo.setBounds(30, 5, 120, 90);
		navbar.add(logo);
		
		JPanel contenido = new JPanel();
		contenido.setBounds(-7, 100, 1280, 620);
		contentPane.add(contenido);
		contenido.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 75, 884, 470);
		contenido.add(scrollPane);
		
		String columnas[] = {"Id", "Nombre", "Descripcion", "Categoria", "Precio", "Stock", "IVA", "Descuento", "Imagen"};
		dtm = new DefaultTableModel(columnas, 0);
		
		table = new JTable(dtm);
		table.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		table.setBackground(Color.WHITE);
		table.setGridColor(new Color(200, 200, 200));
		table.setRowHeight(30);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(false);
		table.setBorder(null);
		table.setFillsViewportHeight(true);
		
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		header.setFont(new Font("Inter", Font.BOLD, 15));
		header.setForeground(Color.WHITE);
		header.setBackground(new Color(64, 64, 64));
		header.setReorderingAllowed(false);
		((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		scrollPane.setViewportView(table);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(new Color(217, 217, 217));
		panelBotones.setBorder(new LineBorder(new Color(64, 64, 64)));
		panelBotones.setBounds(1000, 148, 249, 324);
		contenido.add(panelBotones);
		panelBotones.setLayout(null);
		
		eliminar = new JButton("");
		eliminar.setBackground(new Color(255, 255, 255));
		eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminar.setBorder(new LineBorder(new Color(64, 64, 64)));
		eliminar.setIcon(new ImageIcon(getClass().getResource("/eliminarProducto.png")));
		eliminar.setBounds(16, 10, 100, 100);
		panelBotones.add(eliminar);
		
		editar = new JButton("");
		editar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editar.setBorder(new LineBorder(new Color(64, 64, 64)));
		editar.setBackground(new Color(255, 255, 255));
		editar.setIcon(new ImageIcon(getClass().getResource("/editar.png")));
		editar.setBounds(132, 10, 100, 100);
		panelBotones.add(editar);
		
		JPanel cuadroBusqueda = new JPanel();
		cuadroBusqueda.setBorder(new LineBorder(new Color(64, 64, 64)));
		cuadroBusqueda.setBackground(new Color(255, 255, 255));
		cuadroBusqueda.setBounds(16, 120, 216, 50);
		panelBotones.add(cuadroBusqueda);
		cuadroBusqueda.setLayout(null);
		
		busquedatf = new JTextField();
		busquedatf.setHorizontalAlignment(SwingConstants.LEFT);
		busquedatf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		busquedatf.setBorder(null);
		busquedatf.setBounds(10, 5, 155, 40);
		cuadroBusqueda.add(busquedatf);
		busquedatf.setColumns(10);
		
		buscar = new JButton("");
		buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buscar.setContentAreaFilled(false);
		buscar.setBackground(new Color(255, 255, 255));
		buscar.setBorder(null);
		buscar.setIcon(new ImageIcon(getClass().getResource("/lupa.png")));
		buscar.setBounds(170, 5, 40, 40);
		cuadroBusqueda.add(buscar);
		
		JPanel añadirProductos = new JPanel();
		añadirProductos.setBackground(new Color(255, 255, 255));
		añadirProductos.setBorder(new LineBorder(new Color(64, 64, 64)));
		añadirProductos.setBounds(16, 180, 216, 60);
		panelBotones.add(añadirProductos);
		añadirProductos.setLayout(null);
		
		JLabel añadirIcono = new JLabel("");
		añadirIcono.setIcon(new ImageIcon(getClass().getResource("/añadir.png")));
		añadirIcono.setBounds(15, 10, 40, 40);
		añadirProductos.add(añadirIcono);
		
		añadir = new JButton("Añadir producto");
		añadir.setBackground(new Color(255, 255, 255));
		añadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		añadir.setBorder(null);
		añadir.setFont(new Font("Inter 28pt Light", Font.PLAIN, 19));
		añadir.setBounds(65, 10, 141, 40);
		añadirProductos.add(añadir);
		
		JPanel hacerPedido = new JPanel();
		hacerPedido.setBorder(new LineBorder(new Color(64, 64, 64)));
		hacerPedido.setBackground(new Color(255, 255, 255));
		hacerPedido.setBounds(16, 250, 216, 60);
		panelBotones.add(hacerPedido);
		hacerPedido.setLayout(null);
		
		JLabel pedidosIcono = new JLabel("");
		pedidosIcono.setIcon(new ImageIcon(getClass().getResource("/pedidos-proveedor.png")));
		pedidosIcono.setBounds(15, 10, 40, 40);
		hacerPedido.add(pedidosIcono);
		
		pedir = new JButton("Hacer pedido");
		pedir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pedir.setFont(new Font("Inter 28pt Light", Font.PLAIN, 19));
		pedir.setBorder(null);
		pedir.setBackground(Color.WHITE);
		pedir.setBounds(65, 10, 141, 40);
		hacerPedido.add(pedir);
		
		volver = new JButton("");
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setContentAreaFilled(false);
		volver.setBorder(null);
		volver.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		volver.setBounds(20, 505, 40, 40);
		contenido.add(volver);
		
		lista = OperacionesAdmin.obtenerListaProductos();
		listaOriginal = List.copyOf(lista);
		
		rellenarTabla(dtm);
		
		/*
		 * Manejadores de eventos
		 */
		
		busquedatf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscar.doClick();
				}
			}
			
		});
		
		buscar.addActionListener(new botones());
		eliminar.addActionListener(new botones());
		editar.addActionListener(new botones());
		volver.addActionListener(new botones());
		añadir.addActionListener(new botones());
		pedir.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejar eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == eliminar) {
				eliminarProducto();
			}else if(boton == editar) {
				editarProducto();
			}else if(boton == buscar) {
				filtrarProductos(dtm);
			}else if(boton == volver) {
				PanelControl panel = new PanelControl(cliente);
				panel.setVisible(true);
				dispose();
			}else if(boton == añadir) {
				InsertarProducto insertar = new InsertarProducto();
				insertar.setVisible(true);
			}else if(boton == pedir) {
				hacerPedido();
			}
		}
		
	}
	
	/*
	 * Metodos auxiliares
	 */
	
	public void hacerPedido() {
		int fila = table.getSelectedRow();
		
		if(fila < 0) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar un producto");
		}else {
			int idProducto = (int) table.getValueAt(fila, 0);
			Producto p = OperacionesAdmin.obtenerProducto(idProducto);
			Proveedor prov = new Proveedor(p);
			prov.setVisible(true);
		}
	}
	
	public void editarProducto() {
		int filaSeleccionada = table.getSelectedRow();

		if (filaSeleccionada < 0) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar una fila");
		} else {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas editar este producto?",
					"Confirmar edición", JOptionPane.YES_NO_OPTION);

			if (confirmacion == JOptionPane.YES_OPTION) {
				int idProducto = (int) table.getValueAt(filaSeleccionada, 0);
				Producto p = OperacionesAdmin.obtenerProducto(idProducto);
				EdicionProducto edicion = new EdicionProducto(p);
				edicion.setVisible(true);
			}
		}
	}
	
	public void filtrarProductos(DefaultTableModel dtm) {
		String filtro = busquedatf.getText();
		
		if(filtro.isEmpty()) {
			lista = List.copyOf(listaOriginal);
			dtm.setRowCount(0);
			rellenarTabla(dtm);
		}else {
			List<Producto> filtrados = OperacionesAdmin.buscarProducto(filtro);
			
			if(filtrados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No se encuentran productos con el filtro especificado");
				busquedatf.setText("");
			}else {
				dtm.setRowCount(0);
				
				for(Producto p: filtrados) {
					Object fila[] = {
						p.getId(),
						p.getNombre(),
						p.getDescripcion(),
						p.getCategoria(),
						p.getPrecioUnitario(),
						p.getStock(),
						p.getIVA(),
						p.getDescuento(),
						p.getRutaImagen()
					};
					
					dtm.addRow(fila);
				}
				lista = filtrados;
			}
		}
	}
	
	public void eliminarProducto() {
		int filaSeleccionada = table.getSelectedRow();
		
		if(filaSeleccionada < 0) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar una fila");
		}else {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este producto?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
			
			if(confirmacion == JOptionPane.YES_OPTION) {
				int idProducto = (int) table.getValueAt(filaSeleccionada, 0);
				if(OperacionesAdmin.eliminarProducto(idProducto)) {
					JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
					actualizarTabla();
				}
			}
		}
	}
	
	
	public void rellenarTabla(DefaultTableModel dtm) {
		for(Producto p: lista) {
			Object fila[] = {
				p.getId(),
				p.getNombre(),
				p.getDescripcion(),
				p.getCategoria(),
				p.getPrecioUnitario(),
				p.getStock(),
				p.getIVA(),
				p.getDescuento(),
				p.getRutaImagen()
			};
			
			dtm.addRow(fila);
		}
	}
	
	public void actualizarTabla() {
	    dtm.setRowCount(0);
	    lista = OperacionesAdmin.obtenerListaProductos();
	    rellenarTabla(dtm);
	}

}
