package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
import javax.swing.border.LineBorder;

import controladores.OperacionesCliente;
import modelos.Cliente;
import vistasAdmin.InicioSesionAdmin;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombretf;
	private JPasswordField clavetf;
	
	private JButton iniciarSesion, registrar, registrarAdmin;


	/**
	 * Lanza la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame.
	 */
	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Codigo correspondiente al panel del cliente
		 */
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBackground(new Color(255, 255, 255));
		panelCliente.setBounds(29, 16, 850, 650);
		contentPane.add(panelCliente);
		panelCliente.setLayout(null);
		
		JLabel titulo = new JLabel("SCRIBA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		titulo.setBounds(343, 50, 163, 63);
		panelCliente.add(titulo);
		
		JLabel frase = new JLabel("Inicia sesion en tu cuenta de Scriba");
		frase.setFont(new Font("Inter 28pt Light", Font.PLAIN, 32));
		frase.setHorizontalAlignment(SwingConstants.CENTER);
		frase.setBounds(158, 130, 533, 39);
		panelCliente.add(frase);
		
		JLabel nombrelbl = new JLabel("Nombre de usuario");
		nombrelbl.setHorizontalAlignment(SwingConstants.CENTER);
		nombrelbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 16));
		nombrelbl.setBounds(208, 212, 137, 20);
		panelCliente.add(nombrelbl);
		
		nombretf = new JTextField();
		nombretf.setHorizontalAlignment(SwingConstants.CENTER);
		nombretf.setBorder(null);
		nombretf.setBackground(new Color(240, 240, 240));
		nombretf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 18));
		nombretf.setBounds(208, 242, 434, 39);
		panelCliente.add(nombretf);
		nombretf.setColumns(10);
		
		JLabel contraseñalbl = new JLabel("Contraseña");
		contraseñalbl.setHorizontalAlignment(SwingConstants.LEFT);
		contraseñalbl.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 16));
		contraseñalbl.setBounds(208, 315, 137, 20);
		panelCliente.add(contraseñalbl);
		
		clavetf = new JPasswordField();
		clavetf.setHorizontalAlignment(SwingConstants.CENTER);
		clavetf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 18));
		clavetf.setBackground(new Color(240, 240, 240));
		clavetf.setBorder(null);
		clavetf.setBounds(208, 345, 434, 39);
		panelCliente.add(clavetf);
		
		iniciarSesion = new JButton("Iniciar sesión");
		iniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iniciarSesion.setForeground(new Color(255, 255, 255));
		iniciarSesion.setBorder(null);
		iniciarSesion.setBackground(new Color(64, 64, 64));
		iniciarSesion.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		iniciarSesion.setBounds(208, 488, 434, 45);
		panelCliente.add(iniciarSesion);
		
		registrar = new JButton("Crear cuenta");
		registrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registrar.setForeground(new Color(64, 64, 64));
		registrar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		registrar.setBorder(new LineBorder(new Color(64, 64, 64)));
		registrar.setBackground(new Color(255, 255, 255));
		registrar.setBounds(208, 545, 434, 45);
		panelCliente.add(registrar);
		
		/*
		 * Codigo correspondiente al panel de administrador
		 */
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setBackground(new Color(64, 64, 64));
		panelAdmin.setBounds(908, 16, 329, 650);
		contentPane.add(panelAdmin);
		panelAdmin.setLayout(null);
		
		JLabel titulo2 = new JLabel("¿Eres Administrador?");
		titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		titulo2.setForeground(new Color(255, 255, 255));
		titulo2.setFont(new Font("Inter 28pt Black", Font.PLAIN, 24));
		titulo2.setBounds(24, 62, 281, 30);
		panelAdmin.add(titulo2);
		
		JLabel texto = new JLabel("<html>Inicia sesión en tu cuenta<br>para gestionar tu negocio</html>");
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setForeground(new Color(255, 255, 255));
		texto.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 20));
		texto.setBounds(24, 130, 281, 60);
		panelAdmin.add(texto);
		
		registrarAdmin = new JButton("Soy Admin");
		registrarAdmin.setBackground(new Color(255, 255, 255));
		registrarAdmin.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		registrarAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registrarAdmin.setBorder(null);
		registrarAdmin.setBounds(38, 580, 252, 39);
		panelAdmin.add(registrarAdmin);
		
		JLabel imagen = new JLabel("");
		imagen.setBounds(51, 230, 227, 296);
		ImageIcon icon = new ImageIcon(getClass().getResource("/vector-admin.png"));
		Image resized = icon.getImage().getScaledInstance(227, 296, Image.SCALE_SMOOTH);
		imagen.setIcon(new ImageIcon(resized));
		panelAdmin.add(imagen);
		
		/*
		 * Manejadores de eventos
		 */
		
		nombretf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					clavetf.requestFocusInWindow();
				}
			}
		});
		
		clavetf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					iniciarSesion.doClick();
				}
			}
		});
		
		iniciarSesion.addActionListener(new botones());
		registrar.addActionListener(new botones());
		registrarAdmin.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejar los eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == iniciarSesion) {
				iniciarSesion();
			}else if(boton == registrar) {
				Registro r = new Registro();
				r.setVisible(true);
				dispose();
			}else {
				InicioSesionAdmin inicAdmin = new InicioSesionAdmin();
				inicAdmin.setVisible(true);
				dispose();
			}
		}
		
	}
	
	/*
	 * Métodos auxiliares
	 */
	
	public void iniciarSesion() {
		String nombre = nombretf.getText();
		String clave = new String(clavetf.getPassword());
		
		Cliente c = new Cliente(nombre, clave);
		
		if(OperacionesCliente.iniciarSesion(c)) {
			String rolUsuario = OperacionesCliente.obtenerRol(c);
			
			JOptionPane.showMessageDialog(null, "Sesion iniciada con éxito como "+rolUsuario, "Inicio de sesion en Scriba", 1);
			
			if(rolUsuario.equals("cliente")) {
				Cliente cliente = OperacionesCliente.obtenerCliente(nombre, clave);
				Principal princ = new Principal(cliente);
				princ.setVisible(true);
				dispose(); 
			}else if(rolUsuario.equals("admin")){
				// Aquí se deberá llamar al Frame correspondiente
			}
		}else{
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Inicio de sesion en Scriba", 0);
			resetearCampos();
		}
	}
	
	public void resetearCampos() {
		nombretf.setText("");
		clavetf.setText("");
	}
}
