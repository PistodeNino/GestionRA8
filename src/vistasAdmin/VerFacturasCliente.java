package vistasAdmin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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

public class VerFacturasCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private String nombreUsuario;
	
	private DefaultTableModel dtm;
	private JTable tabla;
	private JButton abrir;

	/**
	 * Create the frame.
	 */
	public VerFacturasCliente(String nombre) {
		setTitle("Consultar facturas");
		ImageIcon icon = new ImageIcon(getClass().getResource("/facturas.png"));
        setIconImage(icon.getImage());
		
		this.nombreUsuario = nombre;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 40, 426, 218);
		contentPane.add(scrollPane);
		
		String columnas[] = {"Facturas del cliente "+nombre};
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
		
		abrir = new JButton("Abrir factura");
		abrir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		abrir.setBorder(new LineBorder(new Color(64, 64, 64)));
		abrir.setBackground(new Color(255, 255, 255));
		abrir.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		abrir.setBounds(145, 290, 195, 51);
		contentPane.add(abrir);
		
		rellenarTabla();
		
		// Manejadores de eventos
		
		abrir.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejar eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == abrir) {
				abrirPdf();
			}
		}
		
	}
	
	/*
	 * Metodos auxiliares
	 */
	
	public void abrirPdf() {
		int fila = tabla.getSelectedRow();
		
		if(fila < 0) {
			JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
		}else {
			Object archivo = tabla.getValueAt(fila, 0);
			try {
				if(archivo instanceof File) {
					Desktop.getDesktop().open((File) archivo);
				}
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Error al abrir el PDF");
				e.printStackTrace();
			}
		}
	}
	
	public void rellenarTabla() {
		File carpeta = new File("facturas");
		if(!carpeta.exists()) {
			carpeta.mkdir();
		}
		
		File facturas[] = carpeta.listFiles();
		
		if(facturas != null) {
			for(File f: facturas) {
				if(f.getName().contains(nombreUsuario)) {
					Object fila[] = {
							f
					};
					dtm.addRow(fila);
				}
			}
		}
	}

}
