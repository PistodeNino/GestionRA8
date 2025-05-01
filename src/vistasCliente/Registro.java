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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controladores.OperacionesCliente;
import modelos.Cliente;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField correotf;
	private JTextField nombretf;
	private JTextField telefonotf;
	private JPasswordField clavetf;
	
	private JButton volver;
	private JButton registrar;

	/**
	 * Create the frame.
	 */
	public Registro() {
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
		titulo.setBounds(295, 40, 224, 58);
		panel.add(titulo);
		
		JLabel subtitulo = new JLabel("Crea tu cuenta de Scriba");
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setFont(new Font("Inter 28pt Light", Font.PLAIN, 32));
		subtitulo.setBounds(205, 110, 404, 39);
		panel.add(subtitulo);
		
		JLabel correolbl = new JLabel("Correo electrónico");
		correolbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 16));
		correolbl.setBounds(190, 216, 137, 20);
		panel.add(correolbl);
		
		correotf = new JTextField();
		correotf.setBorder(null);
		correotf.setHorizontalAlignment(SwingConstants.CENTER);
		correotf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 18));
		correotf.setBackground(new Color(240, 240, 240));
		correotf.setBounds(190, 246, 434, 39);
		panel.add(correotf);
		correotf.setColumns(10);
		
		JLabel nombrelbl = new JLabel("Nombre de usuario");
		nombrelbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 16));
		nombrelbl.setBounds(190, 295, 137, 20);
		panel.add(nombrelbl);
		
		nombretf = new JTextField();
		nombretf.setHorizontalAlignment(SwingConstants.CENTER);
		nombretf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 18));
		nombretf.setColumns(10);
		nombretf.setBorder(null);
		nombretf.setBackground(UIManager.getColor("Button.background"));
		nombretf.setBounds(190, 325, 434, 39);
		panel.add(nombretf);
		
		JLabel telefonolbl = new JLabel("Teléfono");
		telefonolbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 16));
		telefonolbl.setBounds(190, 374, 137, 20);
		panel.add(telefonolbl);
		
		telefonotf = new JTextField();
		telefonotf.setHorizontalAlignment(SwingConstants.CENTER);
		telefonotf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 18));
		telefonotf.setColumns(10);
		telefonotf.setBorder(null);
		telefonotf.setBackground(UIManager.getColor("Button.background"));
		telefonotf.setBounds(190, 404, 434, 39);
		panel.add(telefonotf);
		
		JLabel clavelbl = new JLabel("Contraseña");
		clavelbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 16));
		clavelbl.setBounds(190, 453, 137, 20);
		panel.add(clavelbl);
		
		clavetf = new JPasswordField();
		clavetf.setHorizontalAlignment(SwingConstants.CENTER);
		clavetf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 18));
		clavetf.setBorder(null);
		clavetf.setBackground(new Color(240, 240, 240));
		clavetf.setBounds(190, 483, 434, 39);
		panel.add(clavetf);
		
		registrar = new JButton("Crear cuenta");
		registrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registrar.setForeground(new Color(255, 255, 255));
		registrar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		registrar.setBorder(null);
		registrar.setBackground(new Color(64, 64, 64));
		registrar.setBounds(190, 575, 434, 49);
		panel.add(registrar);
		
		volver = new JButton("");
		volver.setContentAreaFilled(false);
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setBorder(null);
		volver.setBounds(10, 631, 40, 40);
		volver.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		contentPane.add(volver);
		
		/*
		 * Manejadores de eventos
		 */
		
		registrar.addActionListener(new botones());
		volver.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejar los eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == registrar) {
				registrar();
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
	
	public void registrar() {
	    String correo = correotf.getText();
	    String nombre = nombretf.getText();
	    String telefono = telefonotf.getText();
	    String clave = new String(clavetf.getPassword());

	    try {
	        if (!correo.contains("@")) {
	            throw new IllegalArgumentException("El correo electrónico debe contener un '@'.");
	        }

	        if (!telefono.matches("\\d+")) {
	            throw new IllegalArgumentException("El teléfono solo debe contener números.");
	        }

	        if (!nombre.matches("^[a-zA-Z0-9_]+$")) {
	            throw new IllegalArgumentException("El nombre de usuario solo puede contener letras, números y guiones bajos.");
	        }

	        Cliente c = new Cliente(correo, nombre, telefono, clave);

	        if (OperacionesCliente.registrarUsuario(c)) {
	            JOptionPane.showMessageDialog(null, "Cuenta creada con éxito", "Crea tu cuenta", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "Ya existe un usuario con esas credenciales", "Crea tu cuenta", JOptionPane.ERROR_MESSAGE);
	            resetearCampos();
	        }

	    } catch (IllegalArgumentException ex) {
	        JOptionPane.showMessageDialog(null, ex.getMessage(), "Entrada no válida", JOptionPane.WARNING_MESSAGE);
	        resetearCampos();
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        resetearCampos();
	    }
	}

	
	public void resetearCampos() {
		nombretf.setText("");
		clavetf.setText("");
		correotf.setText("");
		telefonotf.setText("");
	}

}
