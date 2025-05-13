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
import modelos.Producto;

public class EdicionProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField nombretf, descripciontf, categoriatf, preciotf, stocktf, ivatf, descuentotf, imagentf;
	private JButton aceptar, cancelar;
	
	private Producto producto;

	/**
	 * Create the frame.
	 */
	public EdicionProducto(Producto producto) {
		this.producto = producto;
		
		setTitle("Edicion de producto");
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
		
		JLabel nombrelbl = new JLabel("Nombre");
		nombrelbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		nombrelbl.setBounds(38, 37, 140, 35);
		contentPane.add(nombrelbl);
		
		nombretf = new JTextField(producto.getNombre());
		nombretf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		nombretf.setBounds(216, 37, 182, 35);
		contentPane.add(nombretf);
		nombretf.setColumns(10);
		
		JLabel descripcionlbl = new JLabel("Descripcion");
		descripcionlbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		descripcionlbl.setBounds(38, 109, 140, 35);
		contentPane.add(descripcionlbl);
		
		JLabel categorialbl = new JLabel("Categoría");
		categorialbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		categorialbl.setBounds(38, 181, 140, 35);
		contentPane.add(categorialbl);
		
		JLabel preciolbl = new JLabel("Precio");
		preciolbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		preciolbl.setBounds(38, 253, 140, 35);
		contentPane.add(preciolbl);
		
		JLabel stocklbl = new JLabel("Stock");
		stocklbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		stocklbl.setBounds(38, 325, 140, 35);
		contentPane.add(stocklbl);
		
		JLabel ivalbl = new JLabel("IVA");
		ivalbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		ivalbl.setBounds(38, 397, 140, 35);
		contentPane.add(ivalbl);
		
		JLabel descuentolbl = new JLabel("Descuento");
		descuentolbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		descuentolbl.setBounds(38, 469, 140, 35);
		contentPane.add(descuentolbl);
		
		JLabel imagenlbl = new JLabel("Imagen");
		imagenlbl.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		imagenlbl.setBounds(38, 541, 140, 35);
		contentPane.add(imagenlbl);
		
		descripciontf = new JTextField(producto.getDescripcion());
		descripciontf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		descripciontf.setColumns(10);
		descripciontf.setBounds(216, 109, 182, 35);
		contentPane.add(descripciontf);
		
		categoriatf = new JTextField(producto.getCategoria());
		categoriatf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		categoriatf.setColumns(10);
		categoriatf.setBounds(216, 181, 182, 35);
		contentPane.add(categoriatf);
		
		preciotf = new JTextField(String.format("%.2f €", producto.getPrecioUnitario()));
		preciotf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		preciotf.setColumns(10);
		preciotf.setBounds(216, 253, 182, 35);
		contentPane.add(preciotf);
		
		stocktf = new JTextField(String.valueOf(producto.getStock()));
		stocktf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		stocktf.setColumns(10);
		stocktf.setBounds(216, 325, 182, 35);
		contentPane.add(stocktf);
		
		ivatf = new JTextField(String.valueOf(producto.getIVA()));
		ivatf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		ivatf.setColumns(10);
		ivatf.setBounds(216, 397, 182, 35);
		contentPane.add(ivatf);
		
		descuentotf = new JTextField(String.valueOf(producto.getDescuento()));
		descuentotf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		descuentotf.setColumns(10);
		descuentotf.setBounds(216, 469, 182, 35);
		contentPane.add(descuentotf);
		
		imagentf = new JTextField(producto.getRutaImagen());
		imagentf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 15));
		imagentf.setColumns(10);
		imagentf.setBounds(216, 541, 182, 35);
		contentPane.add(imagentf);
		
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
				editarProducto();
			}else if(boton == cancelar) {
				dispose();
			}
		}
		
	}
	
	/*
	 * Métodos auxiliares
	 */
	
	public void editarProducto() {
		Producto nuevo = new Producto(
				producto.getId(),
				nombretf.getText(),
				descripciontf.getText(),
				categoriatf.getText(),
				Double.valueOf(preciotf.getText().substring(0, preciotf.getText().indexOf(" ")).replace(",", ".")),
				Integer.valueOf(stocktf.getText()),
				Integer.valueOf(ivatf.getText()),
				Integer.valueOf(descuentotf.getText()),
				imagentf.getText()
				);
		OperacionesAdmin.actualizarProducto(nuevo);
		JOptionPane.showMessageDialog(null, "Producto Actualizado correctamente");
		dispose();
	}

}
