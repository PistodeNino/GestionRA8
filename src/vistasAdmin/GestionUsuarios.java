package vistasAdmin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controladores.OperacionesAdmin;
import modelos.Cliente;
import modelos.Producto;

public class GestionUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTable tabla;
	private DefaultTableModel dtm;
	private List<Cliente> lista;
	
	private JButton eliminar, verFacturas, volver, editar;
	
	private Cliente cliente;

	/**
	 * Create the frame.
	 */
	public GestionUsuarios(Cliente cliente) {
		this.cliente = cliente;
		
		setTitle("Gestión de clientes");
		ImageIcon icon = new ImageIcon(getClass().getResource("/cliente.png"));
        setIconImage(icon.getImage());
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navbar = new JPanel();
		navbar.setBackground(new Color(64, 64, 64));
		navbar.setBounds(-7, 0, 1280, 100);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(getClass().getResource("/logo3.png")));
		logo.setBounds(30, 5, 120, 90);
		navbar.add(logo);
		
		JPanel contenido = new JPanel();
		contenido.setBounds(-7, 100, 1280, 620);
		contentPane.add(contenido);
		contenido.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 50, 1036, 420);
		contenido.add(scrollPane);
		
		String columnas[] = {"Id", "Nombre", "Correo", "Teléfono", "Rol"};
		dtm = new DefaultTableModel(columnas, 0);
		
		tabla = new JTable(dtm);
		tabla.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		tabla.setBackground(Color.WHITE);
		tabla.setGridColor(new Color(200, 200, 200));
		tabla.setRowHeight(30);
		tabla.setShowHorizontalLines(true);
		tabla.setShowVerticalLines(false);
		tabla.setBorder(null);
		tabla.setFillsViewportHeight(true);
		
		JTableHeader header = tabla.getTableHeader();
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		header.setFont(new Font("Inter", Font.BOLD, 15));
		header.setForeground(Color.WHITE);
		header.setBackground(new Color(64, 64, 64));
		header.setReorderingAllowed(false);
		((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		scrollPane.setViewportView(tabla);
		
		JPanel panelEliminar = new JPanel();
		panelEliminar.setBorder(new LineBorder(new Color(64, 64, 64)));
		panelEliminar.setBackground(new Color(255, 255, 255));
		panelEliminar.setBounds(122, 500, 268, 65);
		contenido.add(panelEliminar);
		panelEliminar.setLayout(null);
		
		JLabel eliminarIcono = new JLabel("");
		eliminarIcono.setIcon(new ImageIcon(getClass().getResource("/eliminarProducto.png")));
		eliminarIcono.setBounds(13, 7, 50, 50);
		panelEliminar.add(eliminarIcono);
		
		eliminar = new JButton("Eliminar cliente");
		eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminar.setContentAreaFilled(false);
		eliminar.setBorder(null);
		eliminar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 22));
		eliminar.setBounds(77, 10, 181, 45);
		panelEliminar.add(eliminar);
		
		JPanel panelFacturas = new JPanel();
		panelFacturas.setLayout(null);
		panelFacturas.setBorder(new LineBorder(new Color(64, 64, 64)));
		panelFacturas.setBackground(Color.WHITE);
		panelFacturas.setBounds(890, 500, 268, 65);
		contenido.add(panelFacturas);
		
		JLabel facturasIcono = new JLabel("");
		facturasIcono.setIcon(new ImageIcon(GestionUsuarios.class.getResource("/facturas.png")));
		facturasIcono.setBounds(13, 7, 50, 50);
		panelFacturas.add(facturasIcono);
		
		verFacturas = new JButton("Ver facturas");
		verFacturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verFacturas.setFont(new Font("Inter 28pt Light", Font.PLAIN, 22));
		verFacturas.setContentAreaFilled(false);
		verFacturas.setBorder(null);
		verFacturas.setBounds(77, 10, 181, 45);
		panelFacturas.add(verFacturas);
		
		volver = new JButton("");
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setContentAreaFilled(false);
		volver.setBorder(null);
		volver.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		volver.setBounds(34, 430, 40, 40);
		contenido.add(volver);
		
		JPanel panelEditar = new JPanel();
		panelEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelEditar.setLayout(null);
		panelEditar.setBorder(new LineBorder(new Color(64, 64, 64)));
		panelEditar.setBackground(Color.WHITE);
		panelEditar.setBounds(506, 500, 268, 65);
		contenido.add(panelEditar);
		
		JLabel editarIcono = new JLabel("");
		editarIcono.setIcon(new ImageIcon(GestionUsuarios.class.getResource("/editar.png")));
		editarIcono.setBounds(13, 7, 50, 50);
		panelEditar.add(editarIcono);
		
		editar = new JButton("Editar cliente");
		editar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 22));
		editar.setContentAreaFilled(false);
		editar.setBorder(null);
		editar.setBounds(77, 10, 181, 45);
		panelEditar.add(editar);
		
		lista = OperacionesAdmin.obtenerListaUsuarios();
		
		rellenarTabla();
		
		// Manejadores de eventos
		
		eliminar.addActionListener(new botones());
		verFacturas.addActionListener(new botones());
		volver.addActionListener(new botones());
		editar.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejar eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == eliminar) {
				eliminarCliente();
			}else if(boton == verFacturas) {
				verFacturas();
			}else if(boton == volver) {
				PanelControl panel = new PanelControl(cliente);
				panel.setVisible(true);
				dispose();
			}else if(boton == editar) {
				editarCliente();
			}
		}
	}
	
	/*
	 * Metodos auxiliares
	 */
	
	public void editarCliente() {
		int fila = tabla.getSelectedRow();
		
		if(fila < 0) {
			JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
		}else {
			int idCliente = (int) tabla.getValueAt(fila, 0);
			Cliente c = OperacionesAdmin.obtenerCliente(idCliente);
			EdicionCliente edicion = new EdicionCliente(c);
			edicion.setVisible(true);
		}
	}
	
	public void verFacturas() {
		int fila = tabla.getSelectedRow();
		
		if(fila < 0) {
			JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
		}else {
			String nombre = (String) tabla.getValueAt(fila, 1);
			VerFacturasCliente ver = new VerFacturasCliente(nombre);
			ver.setVisible(true);
		}
	}
	
	public void eliminarCliente() {
		int fila = tabla.getSelectedRow();
		
		if(fila < 0) {
			JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
		}else {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este cliente?",
					"Confirmar eliminacion", JOptionPane.YES_NO_OPTION);

			if (confirmacion == JOptionPane.YES_OPTION) {
				int idCliente = (int) tabla.getValueAt(fila, 0);
				if(OperacionesAdmin.eliminarCliente(idCliente)) {
					JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");
					actualizarTabla();
				}
			}
		}
	}
	
	public void rellenarTabla() {
		for(Cliente c: lista) {
			Object fila[] = {
				c.getId(),
				c.getNombreUsuario(),
				c.getCorreo(),
				c.getTelefono(),
				c.getRol()
			};
			dtm.addRow(fila);
		}
	}
	
	public void actualizarTabla() {
	    dtm.setRowCount(0);
	    lista = OperacionesAdmin.obtenerListaUsuarios();
	    rellenarTabla();
	}

}
