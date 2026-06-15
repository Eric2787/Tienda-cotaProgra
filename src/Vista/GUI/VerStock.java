package Vista.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Almacenamiento.BD;
import Modelo.*;

public class VerStock extends WindowAdapter implements ActionListener {

	Frame f = new Frame("Ver Stock");
	TextArea txtStock;


	public VerStock() {
		f.setLayout(new BorderLayout());
		f.setSize(500, 450);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.addWindowListener(this);

		txtStock = new TextArea();
		txtStock.setEditable(false);
		txtStock.setFont(new Font("Arial", Font.BOLD, 16));
		txtStock.setBackground(Color.WHITE);
		txtStock.setForeground(Color.BLACK);
		
		cargarDatosStock();

		f.add(txtStock, BorderLayout.CENTER);
		f.setVisible(true);
	}

	private void cargarDatosStock() {
		StringBuilder sb = new StringBuilder();
		sb.append("--- CONSULTA DE STOCK ---\n\n");

		int totalPerros = BD.getStockPerros().size();
		int totalGatos = BD.getStockGatos().size();
		int totalPeces = BD.getStockPez().size();
		int totalAranias = BD.getStockAranias().size();
		int totalSerpientes = BD.getStockSerp().size();
		
		int totalAnimales = totalPerros + totalGatos + totalPeces + totalAranias + totalSerpientes;
		sb.append("Total general de animales en stock: ").append(totalAnimales).append("\n\n");

		sb.append("PERROS (").append(totalPerros).append("):\n");
		for (Perro perro : BD.getStockPerros()) {
			sb.append("- Nombre: ").append(perro.getNombre()).append(" | Edad: ").append(perro.getEdad()).append(" | Precio: $").append(perro.getPrecio()).append("\n");
		}

		sb.append("\nGATOS (").append(totalGatos).append("):\n");
		for (Gato gato : BD.getStockGatos()) {
			sb.append("- Nombre: ").append(gato.getNombre()).append(" | Edad: ").append(gato.getEdad()).append(" | Precio: $").append(gato.getPrecio()).append("\n");
		}

		sb.append("\nPECES (").append(totalPeces).append("):\n");
		for (Pez pez : BD.getStockPez()) {
			sb.append("- Nombre: ").append(pez.getNombre()).append(" | Edad: ").append(pez.getEdad()).append(" | Precio: $").append(pez.getPrecio()).append("\n");
		}

		sb.append("\nARAÑAS (").append(totalAranias).append("):\n");
		for (Arania arania : BD.getStockAranias()) {
			sb.append("- Nombre: ").append(arania.getNombre()).append(" | Edad: ").append(arania.getEdad()).append(" | Precio: $").append(arania.getPrecio()).append("\n");
		}

		sb.append("\nSERPIENTES (").append(totalSerpientes).append("):\n");
		for (Serpiente serp : BD.getStockSerp()) {
			sb.append("- Nombre: ").append(serp.getNombre()).append(" | Edad: ").append(serp.getEdad()).append(" | Precio: $").append(serp.getPrecio()).append("\n");
		}

		txtStock.setText(sb.toString());
	}

	public void windowClosing(WindowEvent e) {
		f.dispose();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
