package vistasAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import controladores.OperacionesAdmin;
import modelos.Cliente;
import modelos.TopProducto;

public class Estadisticas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTable table;
	private DefaultTableModel dtm;
	private JButton volver;
	
	private List<TopProducto> lista;
	
	private Cliente cliente;

	/**
	 * Create the frame.
	 */
	public Estadisticas(Cliente cliente) {
		this.cliente = cliente;
		
		setTitle("Bienvenido a tu Dashboard");
		ImageIcon icon = new ImageIcon(getClass().getResource("/tablero.png"));
        setIconImage(icon.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navbar = new JPanel();
		navbar.setBackground(new Color(64, 64, 64));
		navbar.setBounds(-7, 0, 1280, 100);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(getClass().getResource("/logo3.png")));
		logo.setBounds(30, 5, 120, 90);
		navbar.add(logo);
		
		volver = new JButton("");
		volver.setIcon(new ImageIcon(getClass().getResource("/arrow-back2.png")));
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setContentAreaFilled(false);
		volver.setBorder(null);
		volver.setBounds(1194, 30, 40, 40);
		navbar.add(volver);
		
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelControl panel = new PanelControl(cliente);
				panel.setVisible(true);
				dispose();
			}
			
		});
		
		JPanel contenido = new JPanel();
		contenido.setBackground(new Color(219, 219, 219));
		contenido.setBounds(-7, 100, 1280, 720);
		contentPane.add(contenido);
		contenido.setLayout(null);
		
		/*
		 * Top de productos mas vendidos
		 */
		
		JPanel topProductos = new JPanel();
		topProductos.setBorder(new LineBorder(new Color(64, 64, 64)));
		topProductos.setBackground(new Color(255, 255, 255));
		topProductos.setBounds(30, 382, 750, 278);
		contenido.add(topProductos);
		topProductos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 81, 671, 163);
		topProductos.add(scrollPane);
		
		String columnas[] = {"Productos más vendidos", "Unidades"};
		dtm = new DefaultTableModel(columnas, 0);
		
		table = new JTable(dtm);
		table.setFont(new Font("Inter", Font.PLAIN, 18));
		table.setBackground(Color.WHITE);
		table.setGridColor(new Color(200, 200, 200));
		table.setRowHeight(40);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(false);
		table.setBorder(null);
		table.setFillsViewportHeight(true);

		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(header.getWidth(), 40));
		header.setFont(new Font("Inter", Font.BOLD, 20));
		header.setForeground(Color.WHITE);
		header.setBackground(new Color(45, 121, 144));
		header.setReorderingAllowed(false);
		((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		scrollPane.setViewportView(table);
		
		JLabel icono = new JLabel("");
		ImageIcon original = new ImageIcon(getClass().getResource("/flecha.png"));
		Image escalada = original.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		icono.setIcon(new ImageIcon(escalada));
		icono.setBounds(39, 24, 40, 40);
		topProductos.add(icono);
		
		JLabel titulo = new JLabel("Lista de tus productos más vendidos");
		titulo.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		titulo.setBounds(95, 32, 358, 25);
		topProductos.add(titulo);
		
		rellenarTabla();
		
		/*
		 * Grafico de barras
		 */
		
		JPanel graficoBarras = new JPanel();
		graficoBarras.setBorder(new LineBorder(new Color(64, 64, 64)));
		graficoBarras.setBackground(Color.WHITE);
		graficoBarras.setBounds(30, 21, 750, 340);
		contenido.add(graficoBarras);
		
		mostrarGraficoLineal(graficoBarras); // Cambiar a metodo real
		
		/*
		 * Grafico circular
		 */
		
		JPanel graficoCircular = new JPanel();
		graficoCircular.setBorder(new LineBorder(new Color(64, 64, 64)));
		graficoCircular.setBackground(Color.WHITE);
		graficoCircular.setBounds(800, 320, 451, 340);
		contenido.add(graficoCircular);
		
		mostrarGraficoCircular(graficoCircular);
		
		/*
		 * Panel de ganancias totales
		 */
		
		JPanel panelGanancias = new JPanel();
		panelGanancias.setBorder(new LineBorder(new Color(0, 255, 136), 5));
		panelGanancias.setBackground(new Color(0, 79, 83));
		panelGanancias.setBounds(800, 21, 225, 278);
		contenido.add(panelGanancias);
		panelGanancias.setLayout(null);
		
		JLabel gananciaslbl = new JLabel(String.format("%.2f €",OperacionesAdmin.calcularGananciasTotales()));
		gananciaslbl.setForeground(new Color(255, 255, 255));
		gananciaslbl.setFont(new Font("Inter 28pt Black", Font.BOLD | Font.ITALIC, 30));
		gananciaslbl.setHorizontalAlignment(SwingConstants.CENTER);
		gananciaslbl.setBounds(10, 112, 205, 53);
		panelGanancias.add(gananciaslbl);
		
		JLabel iconoDinero = new JLabel("");
		iconoDinero.setIcon(new ImageIcon(getClass().getResource("/dinero.png")));
		iconoDinero.setBounds(20, 20, 40, 40);
		panelGanancias.add(iconoDinero);
		
		JLabel titulo1 = new JLabel("Ingresos");
		titulo1.setForeground(new Color(0, 255, 136));
		titulo1.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		titulo1.setBounds(70, 20, 117, 40);
		panelGanancias.add(titulo1);
		
		/*
		 * Panel de numero de clientes registrados
		 */
		
		JPanel panelUsuarios = new JPanel();
		panelUsuarios.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panelUsuarios.setBackground(new Color(244, 97, 63));
		panelUsuarios.setBounds(1045, 21, 205, 278);
		contenido.add(panelUsuarios);
		panelUsuarios.setLayout(null);
		
		JLabel totalClienteslbl = new JLabel(String.valueOf(OperacionesAdmin.calcularClientes()));
		totalClienteslbl.setForeground(new Color(255, 255, 255));
		totalClienteslbl.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 30));
		totalClienteslbl.setHorizontalAlignment(SwingConstants.CENTER);
		totalClienteslbl.setBounds(10, 112, 185, 53);
		panelUsuarios.add(totalClienteslbl);
		
		JLabel iconoUsuarios = new JLabel("");
		iconoUsuarios.setIcon(new ImageIcon(getClass().getResource("/usuarios.png")));
		iconoUsuarios.setBounds(20, 20, 40, 40);
		panelUsuarios.add(iconoUsuarios);
		
		JLabel titulo2 = new JLabel("<html>Clientes <br> registrados</html>");
		titulo2.setForeground(new Color(255, 255, 255));
		titulo2.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		titulo2.setBounds(66, 20, 117, 53);
		panelUsuarios.add(titulo2);
	}
	
	/*
	 * Clase privada para manejar los eventos
	 */
	
	
	
	/*
	 * Métodos auxiliares
	 */
	
	public void rellenarTabla() {
		lista = OperacionesAdmin.obtenerTop();
		
		for(TopProducto p: lista) {
			Object fila[] = {
				p.getNombre(),
				p.getUnidades()
			};
			dtm.addRow(fila);
		}
	}
	
	public void mostrarGraficoCircular(JPanel graficoCircular) {
		Map<String, Integer> mapa = OperacionesAdmin.obtenerCategorias();

		DefaultPieDataset datos = new DefaultPieDataset();
		for (String m : mapa.keySet()) {
			datos.setValue(m, mapa.get(m));
		}

		JFreeChart grafico = ChartFactory.createPieChart("Categorías más vendidas", datos, true, true, false);
		
		grafico.setTitle(new TextTitle(
			"Categorías más vendidas",
			new Font("Inter 28pt Medium", Font.PLAIN, 20)
		));

		grafico.setBackgroundPaint(Color.WHITE);
		grafico.getPlot().setBackgroundPaint(Color.WHITE);
		grafico.getPlot().setOutlineVisible(false);

		ChartPanel panel = new ChartPanel(grafico);
		panel.setPreferredSize(new Dimension(400, 300));
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		panel.setBorder(null);

		graficoCircular.setLayout(new BorderLayout());
		graficoCircular.add(panel, BorderLayout.CENTER);
		graficoCircular.revalidate();
	}
	
	public void mostrarGraficoLineal(JPanel graficoLineal) {
		Map<LocalDate, Double> mapa = OperacionesAdmin.obtenerGananciasDiarias();
		
		Map<LocalDate, Double> mapaOrdenado = new TreeMap<>(mapa);
		
		DefaultCategoryDataset datos = new DefaultCategoryDataset();
		for(LocalDate m: mapaOrdenado.keySet()) {
			datos.addValue(mapa.get(m), "Ganancia", m);
		}
		
		JFreeChart lineal = ChartFactory.createLineChart("Ganancias Diarias - Ultimos 30 dias", "Fecha", "Ganancias (€)", datos, PlotOrientation.VERTICAL, true, true, false);
		
		lineal.setTitle(new TextTitle("Ganancias Diarias - Últimos 30 días", new Font("Inter 28pt Medium", Font.PLAIN, 20)));
		
		lineal.setBackgroundPaint(Color.WHITE);
	    lineal.getPlot().setBackgroundPaint(Color.WHITE);
	    lineal.getPlot().setOutlineVisible(false);
		
		ChartPanel panel = new ChartPanel(lineal);
		panel.setPreferredSize(new Dimension(600, 300));
		  panel.setBackground(Color.WHITE);
		    panel.setOpaque(true);
		    panel.setBorder(null);
		
		graficoLineal.removeAll();
		graficoLineal.setLayout(new BorderLayout());
		graficoLineal.add(panel, BorderLayout.CENTER);
		graficoLineal.revalidate();
		graficoLineal.repaint();
		
	}
}
