package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelos.Cliente;
import javax.swing.border.LineBorder;

public class PopupPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton perfil;
	private JButton cerrar;
	private JLabel usuario;
	private JButton salir;

	private Cliente cliente;
	private Principal principal;
	

	/**
	 * Create the frame.
	 */
	public PopupPerfil(Cliente cliente, Principal principal) {
		setUndecorated(true);
		
		this.principal = principal;
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 64, 64));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255)));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cerrar = new JButton("Cerrar sesión");
		cerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cerrar.setBorder(null);
		cerrar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		cerrar.setBackground(new Color(255, 255, 255));
		cerrar.setBounds(15, 427, 370, 47);
		contentPane.add(cerrar);
		
		perfil = new JButton("Ver perfil");
		perfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		perfil.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		perfil.setBorder(null);
		perfil.setBackground(Color.WHITE);
		perfil.setBounds(15, 359, 370, 47);
		contentPane.add(perfil);
		
		usuario = new JLabel("");
		usuario.setIcon(new ImageIcon(getClass().getResource("/perfil-usuario.png")));
		usuario.setBounds(165, 60, 70, 70);
		contentPane.add(usuario);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(getClass().getResource("/elipse.png")));
		icono.setBounds(135, 30, 130, 130);
		contentPane.add(icono);
		
		salir = new JButton("");
		salir.setIcon(new ImageIcon(getClass().getResource("/cerrar.png")));
		salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salir.setContentAreaFilled(false);
		salir.setBorder(null);
		salir.setBounds(327, 30, 45, 45);
		contentPane.add(salir);
		
		/*
		 * Manejadores de eventos
		 */
		
		salir.addActionListener(new botones());
		cerrar.addActionListener(new botones());
		perfil.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejar los eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == salir) {
				dispose();
			}else if(boton == cerrar) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea cerrar sesion?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(opcion == 0) {
					InicioSesion inicio = new InicioSesion();
					inicio.setVisible(true);
					dispose();
					principal.dispose();
				}
			}else {
				VerPerfil perfil = new VerPerfil(cliente);
				perfil.setVisible(true);
				dispose();
			}
		}	
	}
}
