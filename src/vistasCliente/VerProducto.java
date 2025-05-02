package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controladores.OperacionesCliente;
import modelos.Cliente;
import modelos.Producto;

public class VerProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private String filtro;
	
	private JPanel contenedor;
	
	private JButton volver;
	private JButton perfil;
	private JButton carrito;
	
	private Cliente cliente;

	/**
	 * Create the frame.
	 */
	public VerProducto(String filtro, Cliente cliente) {
		this.filtro = filtro;
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
		
		JLabel logo = new JLabel("");
		logo.setBounds(30, 5, 120, 90);
		logo.setIcon(new ImageIcon(getClass().getResource("/logo3.png")));
		navbar.add(logo);
		
		perfil = new JButton("");
		perfil.setIcon(new ImageIcon(getClass().getResource("/perfil.png")));
		perfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		perfil.setContentAreaFilled(false);
		perfil.setBorder(null);
		perfil.setBounds(1074, 25, 50, 50);
		navbar.add(perfil);
		
		carrito = new JButton("");
		carrito.setIcon(new ImageIcon(getClass().getResource("/carrito.png")));
		carrito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		carrito.setContentAreaFilled(false);
		carrito.setBorder(null);
		carrito.setBounds(1194, 25, 50, 50);
		navbar.add(carrito);     
		
		/*
		 * Contenido del resto del Frame
		 */
		
		JPanel contenido = new JPanel();
		contenido.setBounds(-7, 100, 1280, 620);
		contentPane.add(contenido);
		contenido.setLayout(null);
		
		JLabel titulo = new JLabel("Resultados para \""+filtro+"\"");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 30));
		titulo.setBounds(370, 50, 539, 38);
		contenido.add(titulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 100, 1104, 464);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenido.add(scrollPane);
		
		JPanel envoltorio = new JPanel();
		envoltorio.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, 0, 0));
		envoltorio.setBackground(new Color(240, 240, 240));
		
		contenedor = new JPanel(new GridLayout(0, 4, 30, 30));
		contenedor.setBackground(new Color(240, 240, 240));
		contenedor.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		envoltorio.add(contenedor);
		scrollPane.setViewportView(envoltorio);
		
		volver = new JButton("");
		volver.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setContentAreaFilled(false);
		volver.setBorder(null);
		volver.setBounds(20, 524, 40, 40);
		contenido.add(volver);
		
		/*
		 * Manejadores de eventos
		 */
		
		volver.addActionListener(new botones());
		
		cargarProductos();
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
			}
		}
		
	}
	
	/*
	 * Métodos auxiliares
	 */
	
	public void cargarProductos() {
		List<Producto> lista = OperacionesCliente.obtenerProductos(filtro);
		contenedor.removeAll();

		for (Producto p : lista) {
			PanelProducto prod = new PanelProducto(p);
			prod.setPreferredSize(new Dimension(230, 290));
			contenedor.add(prod);
		}

		contenedor.revalidate();
		contenedor.repaint();
	}
}
