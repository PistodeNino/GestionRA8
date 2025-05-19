package vistasCliente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
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
import vistasAdmin.PanelControl;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombretf;
	private JPasswordField clavetf;
	
	private JButton iniciarSesion, registrar;
	private JLabel fondo;

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
		setTitle("Inicia sesion en tu cuenta de Scriba");
		ImageIcon icon = new ImageIcon(getClass().getResource("/logo3.png"));
        setIconImage(icon.getImage());
        
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
		panelCliente.setBorder(new LineBorder(new Color(64, 64, 64)));
		panelCliente.setBackground(new Color(255, 255, 255));
		panelCliente.setBounds(208, 16, 850, 650);
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
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(getClass().getResource("/fondo-login.png")));
		fondo.setBounds(-7, -18, 1280, 720);
		contentPane.add(fondo);
		
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
				Cliente cliente = OperacionesCliente.obtenerCliente(nombre, clave);
				PanelControl panel = new PanelControl(cliente);
				panel.setVisible(true);
				dispose();
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
