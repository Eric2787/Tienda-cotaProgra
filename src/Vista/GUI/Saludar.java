package Vista.GUI;

import Vista.GUI.Saludos.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase Saludar.
 * Contiene la lógica y atributos correspondientes a la entidad o controlador Saludar en el sistema.
 */
public class Saludar extends WindowAdapter implements ActionListener {
	Frame f = new Frame("Saludar Animal - Tienda +Kota");
	Label label;
	Button btnPerro, btnGato, btnPez, btnArania, btnSerpiente;

	public Saludar() {

		f.setLayout(null);
		f.setSize(800, 800);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
		f.addWindowListener(this);

		label = new Label("Saludar a un animal: Seleccione una opcion");
		label.setBackground(Color.darkGray);
		label.setForeground(Color.white);
		label.setBounds(50, 50, 700, 30);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setAlignment(Label.CENTER);


		btnPerro = new Button("Perro");
		btnPerro.setBounds(50, 150, 200, 30);
		btnPerro.setFont(new Font("Arial", Font.BOLD, 20));
		btnPerro.addActionListener(this);

		btnGato = new Button("Gato");
		btnGato.setBounds(50, 200, 200, 30);
		btnGato.setFont(new Font("Arial", Font.BOLD, 20));
		btnGato.addActionListener(this);

		btnPez = new Button("Pez");
		btnPez.setBounds(50, 250, 200, 30);
		btnPez.setFont(new Font("Arial", Font.BOLD, 20));
		btnPez.addActionListener(this);

		btnArania = new Button("Arania");
		btnArania.setBounds(50, 300, 200, 30);
		btnArania.setFont(new Font("Arial", Font.BOLD, 20));
		btnArania.addActionListener(this);

		btnSerpiente = new Button("Serpiente");
		btnSerpiente.setBounds(50, 350, 200, 30);
		btnSerpiente.setFont(new Font("Arial", Font.BOLD, 20));
		btnSerpiente.addActionListener(this);


		f.add(label);
		f.add(btnPerro);
		f.add(btnGato);
		f.add(btnPez);
		f.add(btnArania);
		f.add(btnSerpiente);
	}

	/**
	 * Método windowClosing.
	 *
	 * Ejecuta la acción del método windowClosing.
	 * @param e Parámetro e.
	 */
	public void windowClosing(WindowEvent e) {
		f.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnPerro) {
			new SaludarPerro();
		}
		if (e.getSource() == btnGato) {
			new SaludarGato();
		}

		if (e.getSource() == btnPez) {
			new SaludarPez();
		}

		if (e.getSource() == btnArania) {
			new SaludarArania();
		}

		if (e.getSource() == btnSerpiente) {
			new SaludarSerpiente();
		}

	}
}
