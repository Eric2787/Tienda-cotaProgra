package Vista.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Almacenamiento.BD;
import Modelo.*;

public class ConsultarVentas extends WindowAdapter implements ActionListener {

	Frame f = new Frame("Consultar Ventas");
	TextArea txtVentas;

	public ConsultarVentas() {
		f.setLayout(new BorderLayout());
		f.setSize(500, 450);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.addWindowListener(this);

		txtVentas = new TextArea();
		txtVentas.setEditable(false);
		txtVentas.setFont(new Font("Arial", Font.BOLD, 16));
		txtVentas.setBackground(Color.WHITE);
		txtVentas.setForeground(Color.BLACK);

		cargarDatosVentas();

		f.add(txtVentas, BorderLayout.CENTER);
		f.setVisible(true);
	}

	private void cargarDatosVentas() {
		StringBuilder sb = new StringBuilder();
		sb.append("--- CONSULTA DE VENTAS ---\n\n");

		int totalPerros = BD.getVentaPerros().size();
		int totalGatos = BD.getVentaGatos().size();
		int totalPeces = BD.getVentaPez().size();
		int totalAranias = BD.getVentaAranias().size();
		int totalSerpientes = BD.getVentaSerp().size();

		int totalAnimales = totalPerros + totalGatos + totalPeces + totalAranias + totalSerpientes;
		sb.append("Total general de animales vendidos: ").append(totalAnimales).append("\n\n");

		sb.append("PERROS VENDIDOS (").append(totalPerros).append("):\n");
		for (Perro perro : BD.getVentaPerros()) {
			sb.append("- Nombre: ").append(perro.getNombre()).append(" | Edad: ").append(perro.getEdad()).append(" | Precio: $").append(perro.getPrecio()).append("\n");
		}

		sb.append("\nGATOS VENDIDOS (").append(totalGatos).append("):\n");
		for (Gato gato : BD.getVentaGatos()) {
			sb.append("- Nombre: ").append(gato.getNombre()).append(" | Edad: ").append(gato.getEdad()).append(" | Precio: $").append(gato.getPrecio()).append("\n");
		}

		sb.append("\nPECES VENDIDOS (").append(totalPeces).append("):\n");
		for (Pez pez : BD.getVentaPez()) {
			sb.append("- Nombre: ").append(pez.getNombre()).append(" | Edad: ").append(pez.getEdad()).append(" | Precio: $").append(pez.getPrecio()).append("\n");
		}

		sb.append("\nARAÑAS VENDIDAS (").append(totalAranias).append("):\n");
		for (Arania arania : BD.getVentaAranias()) {
			sb.append("- Nombre: ").append(arania.getNombre()).append(" | Edad: ").append(arania.getEdad()).append(" | Precio: $").append(arania.getPrecio()).append("\n");
		}

		sb.append("\nSERPIENTES VENDIDAS (").append(totalSerpientes).append("):\n");
		for (Serpiente serp : BD.getVentaSerp()) {
			sb.append("- Nombre: ").append(serp.getNombre()).append(" | Edad: ").append(serp.getEdad()).append(" | Precio: $").append(serp.getPrecio()).append("\n");
		}

		txtVentas.setText(sb.toString());
	}

	public void windowClosing(WindowEvent e) {
		f.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
