package vistasAdmin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controladores.OperacionesAdmin;
import modelos.Administrador;
import vistasCliente.InicioSesion;

public class InicioSesionAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombretf;
	private JPasswordField clavetf;
	
	private JButton iniciarSesion;
	private JButton volver;

	/**
	 * Create the frame.
	 */
	public InicioSesionAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(225, 11, 815, 660);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel titulo = new JLabel("SCRIBA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		titulo.setBounds(300, 70, 215, 49);
		panel.add(titulo);
		
		JLabel subtitulo = new JLabel("Inicia sesion en tu cuenta de Administrador");
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setFont(new Font("Inter 28pt Light", Font.PLAIN, 32));
		subtitulo.setBounds(66, 130, 682, 49);
		panel.add(subtitulo);
		
		JLabel nombrelbl = new JLabel("Nombre de usuario");
		nombrelbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 16));
		nombrelbl.setBounds(190, 247, 142, 13);
		panel.add(nombrelbl);
		
		nombretf = new JTextField();
		nombretf.setBorder(null);
		nombretf.setHorizontalAlignment(SwingConstants.CENTER);
		nombretf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 18));
		nombretf.setBackground(new Color(240, 240, 240));
		nombretf.setBounds(190, 270, 434, 39);
		panel.add(nombretf);
		nombretf.setColumns(10);
		
		JLabel clavelbl = new JLabel("Contraseña");
		clavelbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 16));
		clavelbl.setBounds(190, 329, 142, 13);
		panel.add(clavelbl);
		
		clavetf = new JPasswordField();
		clavetf.setHorizontalAlignment(SwingConstants.CENTER);
		clavetf.setBorder(null);
		clavetf.setBackground(new Color(240, 240, 240));
		clavetf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 18));
		clavetf.setBounds(190, 352, 434, 39);
		panel.add(clavetf);
		
		iniciarSesion = new JButton("Iniciar sesion");
		iniciarSesion.setBackground(new Color(64, 64, 64));
		iniciarSesion.setForeground(new Color(255, 255, 255));
		iniciarSesion.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		iniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iniciarSesion.setBorder(null);
		iniciarSesion.setBounds(190, 542, 434, 50);
		panel.add(iniciarSesion);
		
		volver = new JButton("");
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setContentAreaFilled(false);
		volver.setBorder(null);
		volver.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		volver.setBounds(35, 621, 40, 40);
		contentPane.add(volver);
		
		/*
		 * Manejadores de eventos
		 */
		
		iniciarSesion.addActionListener(new botones());
		volver.addActionListener(new botones());
		
	}
	
	/*
	 * Clase privada para manejadores de eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == iniciarSesion) {
				inicioSesion();
			}else {
				InicioSesion inic = new InicioSesion();
				inic.setVisible(true);
				dispose();
			}
		}
		
	}
	
	/*
	 * Métodos auxiliares
	 */
	
	public void inicioSesion() {
		String nombre = nombretf.getText();
		String clave = new String(clavetf.getPassword());
		
		Administrador a = new Administrador(nombre, clave);
		
		if(OperacionesAdmin.iniciarSesion(a)) {
			JOptionPane.showMessageDialog(null, "Sesion iniciada con éxito", "Inicio de sesion de Administrador", 1);
		}else {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Inicio de sesion de Administrador", 0);
			resetearCampos();
		}
	}
	
	public void resetearCampos() {
		nombretf.setText("");
		clavetf.setText("");
	}
}
