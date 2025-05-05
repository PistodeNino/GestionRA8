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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelos.Cliente;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField busqueda;

	private JButton buscar, perfil, carrito, verColores, verEscritura, verOrganizacion, verAccesorios;
	private JPanel contenido, colores, escritura, organizacion, accesorios;
	private JLabel titulo, coloresImagen, coloreslbl, escrituraImagen, escrituralbl, orgImagen, orglbl, accImagen,
			acclbl;

	private Cliente cliente;
	private JLabel logo;

	/**
	 * Crea el frame.
	 */
	public Principal(Cliente cliente) {
		this.cliente = cliente;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * Código correspondiente a la barra de navegacion
		 */

		JPanel navbar = new JPanel();
		navbar.setBackground(new Color(64, 64, 64));
		navbar.setBounds(-7, 0, 1280, 100);
		contentPane.add(navbar);
		navbar.setLayout(null);

		JPanel cuadroBusqueda = new JPanel();
		cuadroBusqueda.setBackground(new Color(255, 255, 255));
		cuadroBusqueda.setBounds(274, 26, 732, 47);
		navbar.add(cuadroBusqueda);
		cuadroBusqueda.setLayout(null);

		busqueda = new JTextField();
		busqueda.setBorder(null);
		busqueda.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 18));
		busqueda.setBounds(10, 3, 641, 40);
		cuadroBusqueda.add(busqueda);
		busqueda.setColumns(10);

		buscar = new JButton("");
		buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buscar.setContentAreaFilled(false);
		buscar.setBorder(null);
		buscar.setBounds(670, 3, 40, 40);
		buscar.setIcon(new ImageIcon(getClass().getResource("/lupa.png")));
		cuadroBusqueda.add(buscar);

		perfil = new JButton("");
		perfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		perfil.setContentAreaFilled(false);
		perfil.setBorder(null);
		perfil.setBounds(1074, 25, 50, 50);
		perfil.setIcon(new ImageIcon(getClass().getResource("/perfil.png")));
		navbar.add(perfil);

		carrito = new JButton("");
		carrito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		carrito.setIcon(new ImageIcon(getClass().getResource("/carrito.png")));
		carrito.setContentAreaFilled(false);
		carrito.setBorder(null);
		carrito.setBounds(1194, 25, 50, 50);
		navbar.add(carrito);

		logo = new JLabel("");
		logo.setBounds(30, 5, 120, 90);
		logo.setIcon(new ImageIcon(getClass().getResource("/logo3.png")));
		navbar.add(logo);

		/*
		 * Codigo para el resto del cuerpo del frame
		 */

		contenido = new JPanel();
		contenido.setBounds(-7, 100, 1280, 620);
		contentPane.add(contenido);
		contenido.setLayout(null);

		titulo = new JLabel("Las categorías más buscadas");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 30));
		titulo.setBounds(438, 70, 403, 36);
		contenido.add(titulo);

		/*
		 * Panel de colores
		 */

		colores = new JPanel();
		colores.setName("colores");
		colores.setBorder(new LineBorder(new Color(64, 64, 64)));
		colores.setBackground(new Color(255, 255, 255));
		colores.setBounds(96, 160, 200, 300);
		contenido.add(colores);
		colores.setLayout(null);

		verColores = new JButton("Ver todo");
		verColores.setForeground(new Color(255, 255, 255));
		verColores.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 15));
		verColores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verColores.setBackground(new Color(64, 64, 64));
		verColores.setBorder(null);
		verColores.setBounds(10, 263, 180, 27);
		colores.add(verColores);

		coloresImagen = new JLabel("");
		coloresImagen.setBounds(10, 60, 180, 180);
		coloresImagen.setIcon(new ImageIcon(getClass().getResource("/colores.png")));
		colores.add(coloresImagen);

		coloreslbl = new JLabel("Colores");
		coloreslbl.setForeground(new Color(143, 128, 115));
		coloreslbl.setHorizontalAlignment(SwingConstants.CENTER);
		coloreslbl.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 25));
		coloreslbl.setBounds(44, 13, 111, 28);
		colores.add(coloreslbl);

		/*
		 * Panel de escritura
		 */

		escritura = new JPanel();
		escritura.setName("escritura");
		escritura.setLayout(null);
		escritura.setBorder(new LineBorder(new Color(64, 64, 64)));
		escritura.setBackground(Color.WHITE);
		escritura.setBounds(392, 160, 200, 300);
		contenido.add(escritura);

		verEscritura = new JButton("Ver todo");
		verEscritura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verEscritura.setForeground(Color.WHITE);
		verEscritura.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 15));
		verEscritura.setBorder(null);
		verEscritura.setBackground(Color.DARK_GRAY);
		verEscritura.setBounds(10, 263, 180, 27);
		escritura.add(verEscritura);

		escrituraImagen = new JLabel("");
		escrituraImagen.setIcon(new ImageIcon(Principal.class.getResource("/escritura.png")));
		escrituraImagen.setBounds(10, 60, 180, 180);
		escritura.add(escrituraImagen);

		escrituralbl = new JLabel("Escritura");
		escrituralbl.setHorizontalAlignment(SwingConstants.CENTER);
		escrituralbl.setForeground(new Color(143, 128, 115));
		escrituralbl.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 25));
		escrituralbl.setBounds(44, 13, 111, 28);
		escritura.add(escrituralbl);

		/*
		 * Panel de Organización
		 */

		organizacion = new JPanel();
		organizacion.setName("organizacion");
		organizacion.setLayout(null);
		organizacion.setBorder(new LineBorder(new Color(64, 64, 64)));
		organizacion.setBackground(Color.WHITE);
		organizacion.setBounds(688, 160, 200, 300);
		contenido.add(organizacion);

		verOrganizacion = new JButton("Ver todo");
		verOrganizacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verOrganizacion.setForeground(Color.WHITE);
		verOrganizacion.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 15));
		verOrganizacion.setBorder(null);
		verOrganizacion.setBackground(Color.DARK_GRAY);
		verOrganizacion.setBounds(10, 263, 180, 27);
		organizacion.add(verOrganizacion);

		orgImagen = new JLabel("");
		orgImagen.setIcon(new ImageIcon(Principal.class.getResource("/organizacion.png")));
		orgImagen.setBounds(10, 60, 180, 180);
		organizacion.add(orgImagen);

		orglbl = new JLabel("Organizacion");
		orglbl.setHorizontalAlignment(SwingConstants.CENTER);
		orglbl.setForeground(new Color(143, 128, 115));
		orglbl.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 25));
		orglbl.setBounds(10, 11, 180, 37);
		organizacion.add(orglbl);

		/*
		 * Panel de Accesorios
		 */

		accesorios = new JPanel();
		accesorios.setName("accesorios");
		accesorios.setLayout(null);
		accesorios.setBorder(new LineBorder(new Color(64, 64, 64)));
		accesorios.setBackground(Color.WHITE);
		accesorios.setBounds(984, 160, 200, 300);
		contenido.add(accesorios);

		verAccesorios = new JButton("Ver todo");
		verAccesorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verAccesorios.setForeground(Color.WHITE);
		verAccesorios.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 15));
		verAccesorios.setBorder(null);
		verAccesorios.setBackground(Color.DARK_GRAY);
		verAccesorios.setBounds(10, 263, 180, 27);
		accesorios.add(verAccesorios);

		accImagen = new JLabel("");
		accImagen.setIcon(new ImageIcon(Principal.class.getResource("/accesorios.png")));
		accImagen.setBounds(10, 60, 180, 180);
		accesorios.add(accImagen);

		acclbl = new JLabel("Accesorios");
		acclbl.setHorizontalAlignment(SwingConstants.CENTER);
		acclbl.setForeground(new Color(143, 128, 115));
		acclbl.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 25));
		acclbl.setBounds(10, 11, 180, 37);
		accesorios.add(acclbl);

		/*
		 * Manejadores de eventos
		 */

		busqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscar.doClick();
				}
			}
		});

		buscar.addActionListener(new botones());

		perfil.addActionListener(new botones());
		carrito.addActionListener(new botones());

		verColores.addActionListener(new botones());
		verEscritura.addActionListener(new botones());
		verOrganizacion.addActionListener(new botones());
		verAccesorios.addActionListener(new botones());

	}

	/*
	 * Clase privada para los manejadores de eventos
	 */

	private class botones implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();

			if (boton == perfil) {
				PopupPerfil pop = new PopupPerfil(cliente, Principal.this);
				pop.setVisible(true);
			} else if (boton == carrito) {
				Carrito carro = new Carrito(cliente);
				carro.setVisible(true);
				dispose();
			} else if (boton == verColores || boton == verEscritura || boton == verOrganizacion
					|| boton == verAccesorios) {
				String categoria = boton.getParent().getName();
				VerProducto ver = new VerProducto(categoria, cliente);
				ver.setVisible(true);
				dispose();
			} else if (boton == buscar) {
				String filtro = busqueda.getText();
				VerProducto ver = new VerProducto(filtro, cliente);
				ver.setVisible(true);
				dispose();
			}
		}

	}

	/*
	 * Métodos auxiliares
	 */

}
