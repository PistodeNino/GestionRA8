package vistasCliente;

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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelos.Cliente;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

public class VerPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton cerrar;
	
	private Cliente cliente;
	private JLabel nombre, correo, telefono;


	/**
	 * Crea el frame.
	 */
	public VerPerfil(Cliente cliente) {
		this.cliente = cliente;
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(64, 64, 64)));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usuario = new JLabel("");
		usuario.setIcon(new ImageIcon(getClass().getResource("/perfil-usuario.png")));
		usuario.setBounds(190, 50, 70, 70);
		contentPane.add(usuario);
		
		JLabel elipse = new JLabel("");
		elipse.setIcon(new ImageIcon(getClass().getResource("/elipse.png")));
		elipse.setBounds(160, 20, 130, 130);
		contentPane.add(elipse);
		
		cerrar = new JButton("Cerrar");
		cerrar.setForeground(new Color(255, 255, 255));
		cerrar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		cerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cerrar.setBorder(null);
		cerrar.setBackground(new Color(64, 64, 64));
		cerrar.setBounds(31, 522, 388, 47);
		contentPane.add(cerrar);
		
		nombre = new JLabel(cliente.getNombreUsuario());
		nombre.setBackground(new Color(255, 255, 255));
		nombre.setHorizontalTextPosition(SwingConstants.CENTER);
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		nombre.setBounds(31, 220, 388, 47);
		contentPane.add(nombre);
		
		correo = new JLabel(cliente.getCorreo());
		correo.setHorizontalTextPosition(SwingConstants.CENTER);
		correo.setHorizontalAlignment(SwingConstants.CENTER);
		correo.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		correo.setBounds(31, 300, 388, 47);
		contentPane.add(correo);
		
		telefono = new JLabel(cliente.getTelefono());
		telefono.setHorizontalTextPosition(SwingConstants.CENTER);
		telefono.setHorizontalAlignment(SwingConstants.CENTER);
		telefono.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		telefono.setBounds(31, 380, 388, 47);
		contentPane.add(telefono);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(64, 64, 64)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(31, 205, 388, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(64, 64, 64));
		separator.setBounds(10, 80, 368, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(64, 64, 64));
		separator_1.setBounds(10, 160, 368, 2);
		panel.add(separator_1);
		
		cerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
