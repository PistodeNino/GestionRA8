package vistasAdmin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelos.Cliente;

public class PanelControl extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Cliente cliente;
	
	private JButton gestionar, historial, pedir, verStats, perfil;

	/**
	 * Create the frame.
	 */
	public PanelControl(Cliente cliente) {
		setTitle("Panel de control del Administrador");
		ImageIcon icon = new ImageIcon(getClass().getResource("/ajustes.png"));
        setIconImage(icon.getImage());
		
		this.cliente = cliente;
		
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
		
		perfil = new JButton("");
		perfil.setFocusable(false);
		perfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		perfil.setContentAreaFilled(false);
		perfil.setBorder(null);
		perfil.setIcon(new ImageIcon(getClass().getResource("/perfil.png")));
		perfil.setBounds(1194, 25, 50, 50);
		navbar.add(perfil);
		
		JPanel contenido = new JPanel();
		contenido.setBounds(-7, 100, 1280, 620);
		contentPane.add(contenido);
		contenido.setLayout(null);
		
		JLabel titulo = new JLabel("Bienvenido a tu panel de control");
		titulo.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 30));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(395, 70, 490, 47);
		contenido.add(titulo);
		
		JPanel gestion = new JPanel();
		gestion.setBorder(new LineBorder(new Color(64, 64, 64)));
		gestion.setBackground(new Color(255, 255, 255));
		gestion.setBounds(450, 145, 180, 180);
		contenido.add(gestion);
		gestion.setLayout(null);
		
		JLabel almacenlbl = new JLabel("Almacén");
		almacenlbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		almacenlbl.setHorizontalAlignment(SwingConstants.CENTER);
		almacenlbl.setBounds(10, 142, 160, 28);
		gestion.add(almacenlbl);
		
		gestionar = new JButton("");
		gestionar.setContentAreaFilled(false);
		gestionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestionar.setBorder(null);
		ImageIcon original = new ImageIcon(getClass().getResource("/gestion.png"));
		Image escalada = original.getImage().getScaledInstance(120, 110, Image.SCALE_SMOOTH);
		gestionar.setIcon(new ImageIcon(escalada));
		gestionar.setBounds(30, 20, 120, 110);
		gestion.add(gestionar);
		
		JPanel clientes = new JPanel();
		clientes.setBorder(new LineBorder(new Color(64, 64, 64)));
		clientes.setBackground(Color.WHITE);
		clientes.setBounds(650, 145, 180, 180);
		contenido.add(clientes);
		clientes.setLayout(null);
		
		historial = new JButton("");
		historial.setBorder(null);
		historial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon original2 = new ImageIcon(getClass().getResource("/clientes.png"));
		Image escalada2 = original2.getImage().getScaledInstance(120, 110, Image.SCALE_SMOOTH);
		historial.setIcon(new ImageIcon(escalada2));
		historial.setBounds(30, 20, 120, 110);
		clientes.add(historial);
		
		JLabel clienteslbl = new JLabel("Ver Clientes");
		clienteslbl.setHorizontalAlignment(SwingConstants.CENTER);
		clienteslbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		clienteslbl.setBounds(10, 142, 160, 28);
		clientes.add(clienteslbl);
		
		JPanel pedidos = new JPanel();
		pedidos.setBorder(new LineBorder(new Color(64, 64, 64)));
		pedidos.setBackground(Color.WHITE);
		pedidos.setBounds(450, 345, 180, 180);
		contenido.add(pedidos);
		pedidos.setLayout(null);
		
		JLabel pedidoslbl = new JLabel("Hacer pedido");
		pedidoslbl.setHorizontalAlignment(SwingConstants.CENTER);
		pedidoslbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		pedidoslbl.setBounds(10, 142, 160, 28);
		pedidos.add(pedidoslbl);
		
		pedir = new JButton("");
		pedir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon original3 = new ImageIcon(getClass().getResource("/pedidos.png"));
		Image escalada3 = original3.getImage().getScaledInstance(120, 110, Image.SCALE_SMOOTH);
		pedir.setIcon(new ImageIcon(escalada3));
		pedir.setContentAreaFilled(false);
		pedir.setBorder(null);
		pedir.setBounds(30, 20, 120, 110);
		pedidos.add(pedir);
		
		JPanel estadisticas = new JPanel();
		estadisticas.setBorder(new LineBorder(new Color(64, 64, 64)));
		estadisticas.setBackground(Color.WHITE);
		estadisticas.setBounds(650, 345, 180, 180);
		contenido.add(estadisticas);
		estadisticas.setLayout(null);
		
		JLabel estadisticaslbl = new JLabel("Estadísticas");
		estadisticaslbl.setHorizontalAlignment(SwingConstants.CENTER);
		estadisticaslbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		estadisticaslbl.setBounds(10, 142, 160, 28);
		estadisticas.add(estadisticaslbl);
		
		verStats = new JButton("");
		verStats.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verStats.setContentAreaFilled(false);
		verStats.setBorder(null);
		ImageIcon original4 = new ImageIcon(getClass().getResource("/grafico.png"));
		Image escalada4 = original4.getImage().getScaledInstance(120, 110, Image.SCALE_SMOOTH);
		verStats.setIcon(new ImageIcon(escalada4));
		verStats.setBounds(30, 20, 120, 110);
		estadisticas.add(verStats);
		
		/*
		 * Manejadores de eventos
		 */
		
		gestionar.addActionListener(new botones());
		historial.addActionListener(new botones());
		pedir.addActionListener(new botones());
		verStats.addActionListener(new botones());
		perfil.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejar eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == gestionar) {
				GestionAlmacen gestion = new GestionAlmacen(cliente);
				gestion.setVisible(true);
				dispose();
			}else if(boton == historial) {
				
			}else if(boton == pedir) {
				
			}else if(boton == verStats) {
				Estadisticas stats = new Estadisticas(cliente);
				stats.setVisible(true);
				dispose();
			}else if(boton == perfil) {
				PopupPerfil popup = new PopupPerfil(cliente, PanelControl.this);
				popup.setVisible(true);
			}
		}
	}
	
	/*
	 * Metodos auxiliares
	 */
	
	
}
