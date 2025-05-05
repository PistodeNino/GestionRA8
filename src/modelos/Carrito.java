package modelos;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	
	private int idUsuario;
	private List<ProductoInsertado> productosAñadidos;
	
	public Carrito() {
		
	}

	public Carrito(int idUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.productosAñadidos = new ArrayList<>();
	}
	
	

}
