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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controladores.OperacionesAdmin;
import modelos.Cliente;
import modelos.Producto;

public class EdicionCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField idtf, nombretf, correotf, telefonotf, roltf;
	private JButton aceptar, cancelar;
	
	private Cliente cliente;

	/**
	 * Create the frame.
	 */
	public EdicionCliente(Cliente cliente) {
		this.cliente = cliente;
		
		setTitle("Edicion de usuario");
		ImageIcon icon = new ImageIcon(getClass().getResource("/editar.png"));
        setIconImage(icon.getImage());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon original = new ImageIcon(getClass().getResource("/editar.png"));
		Image escalada = original.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		JLabel idlbl = new JLabel("Id");
		idlbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		idlbl.setBounds(38, 81, 140, 35);
		contentPane.add(idlbl);
		
		idtf = new JTextField(String.valueOf(cliente.getId()));
		idtf.setEditable(false);
		idtf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		idtf.setBounds(216, 81, 182, 35);
		contentPane.add(idtf);
		idtf.setColumns(10);
		
		JLabel nombrelbl = new JLabel("Nombre");
		nombrelbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		nombrelbl.setBounds(38, 197, 140, 35);
		contentPane.add(nombrelbl);
		
		JLabel correolbl = new JLabel("Correo");
		correolbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		correolbl.setBounds(38, 313, 140, 35);
		contentPane.add(correolbl);
		
		JLabel telefonolbl = new JLabel("Teléfono");
		telefonolbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		telefonolbl.setBounds(38, 429, 140, 35);
		contentPane.add(telefonolbl);
		
		JLabel rollbl = new JLabel("Rol");
		rollbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		rollbl.setBounds(38, 545, 140, 35);
		contentPane.add(rollbl);
		
		nombretf = new JTextField(cliente.getNombreUsuario());
		nombretf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		nombretf.setColumns(10);
		nombretf.setBounds(216, 197, 182, 35);
		contentPane.add(nombretf);
		
		correotf = new JTextField(cliente.getCorreo());
		correotf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		correotf.setColumns(10);
		correotf.setBounds(216, 313, 182, 35);
		contentPane.add(correotf);
		
		telefonotf = new JTextField(cliente.getTelefono());
		telefonotf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		telefonotf.setColumns(10);
		telefonotf.setBounds(216, 429, 182, 35);
		contentPane.add(telefonotf);
		
		roltf = new JTextField(cliente.getRol());
		roltf.setEditable(false);
		roltf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		roltf.setColumns(10);
		roltf.setBounds(216, 545, 182, 35);
		contentPane.add(roltf);
		
		aceptar = new JButton("Aceptar");
		aceptar.setForeground(new Color(255, 255, 255));
		aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aceptar.setBackground(new Color(64, 64, 64));
		aceptar.setBorder(null);
		aceptar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		aceptar.setBounds(60, 613, 150, 40);
		contentPane.add(aceptar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelar.setBorder(new LineBorder(new Color(64, 64, 64)));
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setBounds(226, 613, 150, 40);
		contentPane.add(cancelar);
		
		/*
		 * Manejadores de eventos
		 */
		
		aceptar.addActionListener(new botones());
		cancelar.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejar los eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == aceptar) {
				editarCliente();
			}else if(boton == cancelar) {
				dispose();
			}
		}
		
	}
	
	/*
	 * Métodos auxiliares
	 */
	
	public void editarCliente() {
	    try {
	        String correo = correotf.getText().trim();
	        String telefono = telefonotf.getText().trim();
	        String nombre = nombretf.getText().trim();
	        
	        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
	            throw new IllegalArgumentException("Todos los campos deben estar llenos.");
	        }
	        
	        if (!correo.contains("@")) {
	            throw new IllegalArgumentException("El correo electrónico debe contener '@'.");
	        }

	        if (!telefono.matches("\\d+")) {
	            throw new IllegalArgumentException("El teléfono solo debe contener números.");
	        }

	        if (nombre.isEmpty()) {
	            throw new IllegalArgumentException("El nombre no puede estar vacío.");
	        }

	        Cliente nuevo = new Cliente();
	        nuevo.setId(cliente.getId());
	        nuevo.setCorreo(correo);
	        nuevo.setNombreUsuario(nombre);
	        nuevo.setTelefono(telefono);
	        nuevo.setClave(cliente.getClave());
	        nuevo.setRol(cliente.getRol());

	        OperacionesAdmin.actualizarCliente(nuevo);
	        JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
	        dispose();

	    } catch (IllegalArgumentException ex) {
	        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}


}
