package vistasAdmin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controladores.OperacionesAdmin;
import modelos.Producto;

public class InsertarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//Comentario de prueba
	
	private JPanel contentPane;
	private JTextField nombretf;
	private JLabel categorialbl;
	private JTextField preciotf;
	private JTextField stocktf;
	private JTextField descuentotf;
	private JTextField ivatf;
	
	private JComboBox categorias;
	private JTextArea descripciontf;
	private JButton aceptar, cancelar, imagen, añadir;
	
	private String ruta;
	private JLabel imagenSeleccionada;

	/**
	 * Crear el Frame
	 */
	public InsertarProducto() {
		setTitle("Añade un producto a tu almacen");
		ImageIcon icon = new ImageIcon(getClass().getResource("/añadir.png"));
        setIconImage(icon.getImage());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombrelbl = new JLabel("Nombre");
		nombrelbl.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		nombrelbl.setHorizontalAlignment(SwingConstants.LEFT);
		nombrelbl.setBounds(30, 30, 89, 32);
		contentPane.add(nombrelbl);
		
		nombretf = new JTextField();
		nombretf.setBorder(new LineBorder(new Color(64, 64, 64)));
		nombretf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		nombretf.setBounds(30, 70, 218, 32);
		contentPane.add(nombretf);
		nombretf.setColumns(10);
		
		categorialbl = new JLabel("Categoría");
		categorialbl.setHorizontalAlignment(SwingConstants.LEFT);
		categorialbl.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		categorialbl.setBounds(30, 130, 111, 32);
		contentPane.add(categorialbl);
		
		Set<String> categ = OperacionesAdmin.obtenerListaCategorias();
		
		categorias = new JComboBox(categ.toArray());
		categorias.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		categorias.setBorder(new LineBorder(new Color(64, 64, 64)));
		categorias.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		categorias.setBounds(30, 172, 218, 32);
		contentPane.add(categorias);
		
		JLabel preciolbl = new JLabel("Precio");
		preciolbl.setHorizontalAlignment(SwingConstants.LEFT);
		preciolbl.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		preciolbl.setBounds(30, 238, 111, 32);
		contentPane.add(preciolbl);
		
		preciotf = new JTextField();
		preciotf.setBorder(new LineBorder(new Color(64, 64, 64)));
		preciotf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		preciotf.setColumns(10);
		preciotf.setBounds(30, 280, 218, 32);
		contentPane.add(preciotf);
		
		JLabel stocklbl = new JLabel("Stock");
		stocklbl.setHorizontalAlignment(SwingConstants.LEFT);
		stocklbl.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		stocklbl.setBounds(298, 30, 89, 32);
		contentPane.add(stocklbl);
		
		stocktf = new JTextField();
		stocktf.setBorder(new LineBorder(new Color(64, 64, 64)));
		stocktf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		stocktf.setColumns(10);
		stocktf.setBounds(298, 70, 218, 32);
		contentPane.add(stocktf);
		
		JLabel ivalbl = new JLabel("IVA");
		ivalbl.setHorizontalAlignment(SwingConstants.LEFT);
		ivalbl.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		ivalbl.setBounds(298, 130, 111, 32);
		contentPane.add(ivalbl);
		
		JLabel descuentolbl = new JLabel("Descuento");
		descuentolbl.setHorizontalAlignment(SwingConstants.LEFT);
		descuentolbl.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		descuentolbl.setBounds(298, 238, 111, 32);
		contentPane.add(descuentolbl);
		
		descuentotf = new JTextField();
		descuentotf.setBorder(new LineBorder(new Color(64, 64, 64)));
		descuentotf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		descuentotf.setColumns(10);
		descuentotf.setBounds(298, 280, 218, 32);
		contentPane.add(descuentotf);
		
		ivatf = new JTextField();
		ivatf.setBorder(new LineBorder(new Color(64, 64, 64)));
		ivatf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		ivatf.setColumns(10);
		ivatf.setBounds(298, 172, 218, 32);
		contentPane.add(ivatf);
		
		descripciontf = new JTextArea();
		descripciontf.setBorder(new LineBorder(new Color(64, 64, 64)));
		descripciontf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		descripciontf.setBounds(30, 400, 486, 91);
		contentPane.add(descripciontf);
		
		JLabel descripcionlbl = new JLabel("Descripción");
		descripcionlbl.setHorizontalAlignment(SwingConstants.LEFT);
		descripcionlbl.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		descripcionlbl.setBounds(30, 350, 111, 32);
		contentPane.add(descripcionlbl);
		
		imagen = new JButton("");
		imagen.setBackground(new Color(255, 255, 255));
		imagen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imagen.setBorder(new LineBorder(new Color(192, 192, 192)));
		ImageIcon original = new ImageIcon(getClass().getResource("/imagen.png"));
		Image escalada = original.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		imagen.setIcon(new ImageIcon(escalada));
		imagen.setBounds(570, 70, 235, 242);
		contentPane.add(imagen);
		
		cancelar = new JButton("Cancelar");
		cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setBorder(new LineBorder(new Color(255, 128, 128)));
		cancelar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		cancelar.setBounds(570, 450, 235, 41);
		contentPane.add(cancelar);
		
		aceptar = new JButton("Aceptar");
		aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aceptar.setBorder(new LineBorder(new Color(0, 255, 64)));
		aceptar.setBackground(new Color(255, 255, 255));
		aceptar.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		aceptar.setBounds(570, 400, 235, 41);
		contentPane.add(aceptar);
		
		añadir = new JButton("");
		añadir.setHorizontalAlignment(SwingConstants.RIGHT);
		añadir.setContentAreaFilled(false);
		añadir.setBorder(null);
		añadir.setIcon(new ImageIcon(getClass().getResource("/firmar.png")));
		añadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		añadir.setBounds(188, 126, 60, 40);
		contentPane.add(añadir);
		
		imagenSeleccionada = new JLabel("Imagen seleccionada");
		imagenSeleccionada.setVisible(false);
		imagenSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		imagenSeleccionada.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		imagenSeleccionada.setBounds(570, 327, 235, 32);
		contentPane.add(imagenSeleccionada);
		
		/*
		 * Manejadores de eventos
		 */
		
		aceptar.addActionListener(new botones());
		cancelar.addActionListener(new botones());
		imagen.addActionListener(new botones());
		añadir.addActionListener(new botones());
	}
	
	/*
	 * Clase privada para manejar eventos
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == aceptar) {
				insertarProducto();
			}else if(boton == cancelar) {
				dispose();
			}else if(boton == imagen) {
				ruta = insertarImagen();
				imagenSeleccionada.setVisible(true);
			}else if(boton == añadir) {
				insertarCategoria();
			}
		}
	}
	
	/*
	 * Metodos auxiliares
	 */
	
	public String insertarImagen() {
		String ruta = "";
		
		JFileChooser filechooser = new JFileChooser();
		int seleccion = filechooser.showOpenDialog(this);
		
		if(seleccion == JFileChooser.APPROVE_OPTION) {
			File imagen = filechooser.getSelectedFile();
			try {
				File carpetaImagenes = new File("imagenes");
				
				String nombreImagen = imagen.getName();
				File destino = new File(carpetaImagenes, nombreImagen);
				
				int contador = 1;
				while (destino.exists()) {
				    String nombreSinExtension = nombreImagen.substring(0, nombreImagen.lastIndexOf('.'));
				    String extension = nombreImagen.substring(nombreImagen.lastIndexOf('.'));
				    
				    destino = new File(carpetaImagenes, nombreSinExtension + "_" + contador + extension);
				    contador++;
				}
				
				Files.copy(imagen.toPath(), destino.toPath());
				
				ruta = "imagenes/"+destino.getName();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		imagen.setIcon(new ImageIcon(ruta));
		
		return ruta;
	}
	
	public void insertarProducto() {
		String nombre = nombretf.getText();
		String descripcion = descripciontf.getText();
		String categoria = (String) categorias.getSelectedItem();
		double precio = Double.parseDouble(preciotf.getText());
		int stock = Integer.parseInt(stocktf.getText());
		int iva = Integer.parseInt(ivatf.getText());
		int descuento = Integer.parseInt(descuentotf.getText());
		String urlImagen = ruta;
		
		Producto p = new Producto(nombre, descripcion, categoria, precio, stock, iva, descuento, urlImagen);
		
		if(OperacionesAdmin.insertarProducto(p)) {
			JOptionPane.showMessageDialog(null, "Has introducido el nuevo producto con exito");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Ha habido un error");
		}
	}
	
	public void insertarCategoria() {
		String categoria = JOptionPane.showInputDialog("Introduce la categoria que quieras");
		categorias.addItem(categoria);
	}
}
