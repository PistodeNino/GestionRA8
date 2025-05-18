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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controladores.OperacionesAdmin;
import modelos.Producto;
import javax.swing.SwingConstants;

public class Proveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Producto producto;
	private JTextField cantidadtf;
	private JButton mas, menos, pedir;
	
	private int cantidad = 1;

	/**
	 * Create the frame.
	 */
	public Proveedor(Producto producto) {
		setTitle("Haz un pedido a tu proveedor");
		ImageIcon icon = new ImageIcon(getClass().getResource("/pedidos-proveedor.png"));
        setIconImage(icon.getImage());
        
		this.producto = producto;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pedir = new JButton("Hacer pedido");
		pedir.setFocusable(false);
		pedir.setForeground(new Color(255, 255, 255));
		pedir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pedir.setBackground(new Color(64, 64, 64));
		pedir.setBorder(null);
		pedir.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		pedir.setBounds(18, 305, 549, 45);
		contentPane.add(pedir);
		
		JLabel imagen = new JLabel("");
		imagen.setBorder(new LineBorder(new Color(64, 64, 64)));
		ImageIcon original = new ImageIcon(producto.getRutaImagen());
		Image escalada = original.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		imagen.setIcon(new ImageIcon(escalada));
		imagen.setBounds(20, 20, 150, 150);
		contentPane.add(imagen);
		
		JLabel nombre = new JLabel(producto.getNombre());
		nombre.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		nombre.setBounds(191, 20, 376, 45);
		contentPane.add(nombre);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setLineWrap(true);
		descripcion.setEditable(false);
		descripcion.setText(producto.getDescripcion());
		descripcion.setBackground(new Color(240, 240, 240));
		descripcion.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		descripcion.setBounds(191, 88, 368, 82);
		contentPane.add(descripcion);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(64, 64, 64)));
		panel.setBounds(18, 226, 549, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		menos = new JButton("-");
		menos.setForeground(new Color(255, 255, 255));
		menos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menos.setBorder(null);
		menos.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 30));
		menos.setBackground(new Color(64, 64, 64));
		menos.setBounds(5, 5, 100, 50);
		panel.add(menos);
		
		mas = new JButton("+");
		mas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mas.setForeground(Color.WHITE);
		mas.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 30));
		mas.setBorder(null);
		mas.setBackground(Color.DARK_GRAY);
		mas.setBounds(445, 5, 100, 50);
		panel.add(mas);
		
		cantidadtf = new JTextField(String.valueOf(cantidad));
		cantidadtf.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadtf.setFont(new Font("Inter 28pt SemiBold", Font.PLAIN, 20));
		cantidadtf.setBounds(224, 5, 100, 50);
		panel.add(cantidadtf);
		cantidadtf.setColumns(10);
		
		/*
		 * Manejadores de eventos
		 */
		
		mas.addActionListener(new botones());
		menos.addActionListener(new botones());
		pedir.addActionListener(new botones());
	}
	
	/*
	 * Clase privada
	 */
	
	private class botones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			if(boton == mas) {
				aumentar();
			}else if(boton == menos) {
				disminuir();
			}else if(boton == pedir) {
				pedido();
			}
		}
		
	}
	
	/*
	 * Metodos auxiliares
	 */
	
	public void pedido() {
		int idProducto = producto.getId();
		int cantidadPedida = cantidad;
		
		if(OperacionesAdmin.rellenarStock(idProducto, cantidadPedida)) {
			JOptionPane.showMessageDialog(null, "Pedido realizado con exito, pronto se rellenará tu Stock");
		}
	}
	
	public void aumentar() {
		cantidad++;
		cantidadtf.setText(String.valueOf(cantidad));
	}
	
	public void disminuir() {
		if(cantidad > 1) {
			cantidad --;
			cantidadtf.setText(String.valueOf(cantidad));
		}
	}
}
