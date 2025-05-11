package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controladores.OperacionesCliente;
import modelos.Cliente;
import modelos.Historial;
import javax.swing.border.LineBorder;

public class HistorialCompras extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	
	private Cliente cliente;

	/**
	 * Create the frame.
	 */
	public HistorialCompras(Cliente cliente) {
		this.cliente = cliente;
		
		setTitle("Historial de compras");
		ImageIcon icon = new ImageIcon(getClass().getResource("/historial.png"));
        setIconImage(icon.getImage());
		
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
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(getClass().getResource("/logo3.png")));
		logo.setBounds(30, 5, 120, 90);
		navbar.add(logo);
		
		JPanel panel = new JPanel();
		panel.setBounds(-7, 100, 1280, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel icono = new JLabel("");
		ImageIcon original = new ImageIcon(getClass().getResource("/historial.png"));
		Image escalada = original.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		icono.setIcon(new ImageIcon(escalada));
		icono.setBounds(385, 60, 100, 100);
		panel.add(icono);
		
		JLabel titulo = new JLabel("Historial de compras");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Inter 28pt Light", Font.PLAIN, 40));
		titulo.setBounds(495, 60, 371, 100);
		panel.add(titulo);
		
		String columnas[] = {"Id de Compra", "Fecha de compra", "Cantidad de productos", "Precio total"};
		DefaultTableModel dtm = new DefaultTableModel(columnas, 0);
		
		/*
		 * Personalizacion de la tabla
		 */
		
		tabla = new JTable(dtm);
		tabla.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		tabla.setBounds(285, 238, 709, 159);
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
		header.setForeground(Color.white);
		header.setBackground(new Color(92, 158, 255));
		header.setReorderingAllowed(false);
		((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tabla.getColumnCount(); i++) {
		    tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		panel.add(tabla);
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBorder(new LineBorder(new Color(64, 64, 64)));
		scrollPane.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 10));
		scrollPane.setBounds(251, 216, 778, 332);
		panel.add(scrollPane);
		scrollPane.setViewportView(tabla);
		
		JButton volver = new JButton("");
		volver.setContentAreaFilled(false);
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setBorder(null);
		volver.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		volver.setBounds(36, 508, 40, 40);
		panel.add(volver);
		
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal(cliente);
				principal.setVisible(true);
				dispose();
			}
			
		});
		
		int idUsuario = OperacionesCliente.obtenerCliente(cliente.getNombreUsuario(), cliente.getClave()).getId();
		List<Historial> lista = OperacionesCliente.obtenerCompras(idUsuario);
		
		for(Historial h: lista) {
			Object fila[] = {
				h.getId(),
				h.getFecha(),
				h.getProductos(),
				h.getPrecio()
			};
			dtm.addRow(fila);
		}
	}
}
