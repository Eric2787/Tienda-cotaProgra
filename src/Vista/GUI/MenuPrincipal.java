package Vista.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import Controlador.ControladorBD;

/**
 * Clase MenuPrincipal.
 * Contiene la lógica y atributos correspondientes a la entidad o controlador MenuPrincipal en el sistema.
 */
public class MenuPrincipal extends WindowAdapter implements ActionListener {

	ControladorBD controladorBD = new ControladorBD();

	Frame frame;
	Label label;
	Button btnRegistrarAnimal, btnVerStock, btnVenderAnimal, btnConsultarVentas, btnRespaldarBD, btnCargarBD, btnSaludar;

	/**
	 * Ejecuta la acción del método MenuPrincipal.
	 * @return Un valor de tipo public.
	 */
	public MenuPrincipal() {
		frame = new Frame("Menu Principal");


		label = new Label("Bienvenido al sistema de gestión de la tienda ");
		label.setBackground(Color.darkGray);
		label.setForeground(Color.white);
		label.setBounds(50, 50, 700, 30);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setAlignment(Label.CENTER);


		String asciiMasKOTA = "       _  _____ _____  _   \n" +
				"   _  | |/ / _ \\_   _|/ \\  \n" +
				" _| |_| ' / | | || | / _ \\ \n" +
				"|_   _| . \\ |_| || |/ ___ \\\n" +
				"  |_| |_|\\_\\___/ |_/_/   \\_\\\n";

		TextArea asciiLabel = new TextArea(asciiMasKOTA, 0, 0, TextArea.SCROLLBARS_NONE);
		asciiLabel.setEditable(false);
		asciiLabel.setBackground(Color.darkGray);
		asciiLabel.setForeground(Color.white);
		asciiLabel.setBounds(50, 100, 700, 160);
		asciiLabel.setFont(new Font("Monospaced", Font.BOLD, 20));


		btnRegistrarAnimal = new Button("Registrar animal");
		btnRegistrarAnimal.setBounds(50, 300, 200, 30);
		btnRegistrarAnimal.addActionListener(this);

		btnVerStock = new Button("Ver Stock");
		btnVerStock.setBounds(50, 350, 200, 30);
		btnVerStock.addActionListener(this);

		btnVenderAnimal = new Button("Vender animal");
		btnVenderAnimal.setBounds(50, 400, 200, 30);
		btnVenderAnimal.addActionListener(this);

		btnConsultarVentas = new Button("Consultar ventas");
		btnConsultarVentas.setBounds(50, 450, 200, 30);
		btnConsultarVentas.addActionListener(this);

		btnRespaldarBD = new Button("Respaldar base de datos");
		btnRespaldarBD.setBounds(50, 500, 200, 30);
		btnRespaldarBD.addActionListener(this);

		btnCargarBD = new Button("Cargar base de datos");
		btnCargarBD.setBounds(50, 550, 200, 30);
		btnCargarBD.addActionListener(this);

		btnSaludar = new Button("Saludar");
		btnSaludar.setBounds(50, 600, 200, 30);
		btnSaludar.addActionListener(this);


		frame.add(label);
		frame.add(btnRegistrarAnimal);
		frame.add(btnVerStock);
		frame.add(asciiLabel);
		frame.add(btnVenderAnimal);
		frame.add(btnConsultarVentas);
		frame.add(btnRespaldarBD);
		frame.add(btnCargarBD);
		frame.add(btnSaludar);


		frame.addWindowListener(this);
		frame.setLayout(null);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}

	/**
	 * Ejecuta la acción del método windowClosing.
	 * @param e Parámetro e.
	 */
	public void windowClosing(WindowEvent e){
		frame.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrarAnimal) {
			new RegistrarAnimal();
		}

		if (e.getSource() == btnVerStock) {
	/**
	 * Ejecuta la acción del método VerStock.
	 * @return Un valor de tipo new.
	 */
			new VerStock();
		}

		if (e.getSource() == btnVenderAnimal) {
	/**
	 * Ejecuta la acción del método VenderAnimal.
	 * @return Un valor de tipo new.
	 */
			new VenderAnimal();
		}

		if (e.getSource() == btnConsultarVentas) {
	/**
	 * Ejecuta la acción del método ConsultarVentas.
	 * @return Un valor de tipo new.
	 */
			new ConsultarVentas();
		}

		if (e.getSource() == btnRespaldarBD) {
			try {
				controladorBD.respaldarBD();
				javax.swing.JOptionPane.showMessageDialog(frame, "La base de datos fue respaldada con éxito.");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}

		if (e.getSource() == btnCargarBD) {
			try {
				controladorBD.cargarBD();
				javax.swing.JOptionPane.showMessageDialog(frame, "La base de datos fue cargada con éxito.");

			} catch (IOException | ClassNotFoundException ex) {
				throw new RuntimeException(ex);
			}
		}

		if (e.getSource() == btnSaludar) {
	/**
	 * Ejecuta la acción del método Saludar.
	 * @return Un valor de tipo new.
	 */
			new Saludar();
		}

	}
}