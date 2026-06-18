package Vista.GUI;

import Controlador.*;
import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Clase MostrarPrecio.
 *
 * Representa la clase MostrarPrecio del sistema.
 */
public class MostrarPrecio extends WindowAdapter implements ActionListener {

    Frame frame;
    TextArea stockArea;
    TextField txtNombreAnimal;
    Button btnBuscarPrecio;
    TextArea precioOutputArea;

    // Controladores para cada tipo de animal
    private ControladorPerro controladorPerro;
    private ControladorGato controladorGato;
    private ControladorPez controladorPez;
    private ControladorArania controladorArania;
    private ControladorSerpiente controladorSerpiente;

    /**
     * Método MostrarPrecio.
     *
     * Ejecuta la acción del método MostrarPrecio.
     */
    public MostrarPrecio() {
        controladorPerro = new ControladorPerro();
        controladorGato = new ControladorGato();
        controladorPez = new ControladorPez();
        controladorArania = new ControladorArania();
        controladorSerpiente = new ControladorSerpiente();

        frame = new Frame("Mostrar Precio +Kota");
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(this);

        // Panel superior para el stock de animales
        JPanel panelStock = new JPanel(new BorderLayout());
        panelStock.add(new Label("Animales en Stock:"), BorderLayout.NORTH);
        stockArea = new TextArea();
        stockArea.setEditable(false);
        stockArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        actualizarStockArea();
        panelStock.add(stockArea, BorderLayout.CENTER);

        // Panel central para la entrada de nombre y botón
        JPanel panelInput = new JPanel(new FlowLayout());
        panelInput.add(new Label("Nombre del animal para ver precio:"));
        txtNombreAnimal = new TextField(15);
        panelInput.add(txtNombreAnimal);
        btnBuscarPrecio = new Button("Buscar Precio");
        btnBuscarPrecio.addActionListener(this);
        panelInput.add(btnBuscarPrecio);

        // Panel inferior para el output del precio
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.add(new Label("Precio del Animal:"), BorderLayout.NORTH);
        precioOutputArea = new TextArea();
        precioOutputArea.setEditable(false);
        precioOutputArea.setFont(new Font("Monospaced", Font.BOLD, 16));
        panelOutput.add(precioOutputArea, BorderLayout.CENTER);


        frame.add(panelStock, BorderLayout.NORTH);
        frame.add(panelInput, BorderLayout.CENTER);
        frame.add(panelOutput, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    /**
     * Método actualizarStockArea.
     *
     * Ejecuta la acción del método actualizarStockArea.
     */
    private void actualizarStockArea() {
        StringBuilder stockTexto = new StringBuilder();
        stockTexto.append("--- Perros ---\n");
        ArrayList<Perro> perros = controladorPerro.consultarPerros();
        if (perros.isEmpty()) {
            stockTexto.append("No hay perros en stock.\n");
        } else {
            for (Perro perro : perros) {
                stockTexto.append("  - ").append(perro.getNombre()).append(" (Raza: ").append(perro.getRaza()).append(")\n");
            }
        }

        stockTexto.append("\n--- Gatos ---\n");
        ArrayList<Gato> gatos = controladorGato.consultarGatos();
        if (gatos.isEmpty()) {
            stockTexto.append("No hay gatos en stock.\n");
        } else {
            for (Gato gato : gatos) {
                stockTexto.append("  - ").append(gato.getNombre()).append(" (Raza: ").append(gato.getRaza()).append(")\n");
            }
        }

        stockTexto.append("\n--- Peces ---\n");
        ArrayList<Pez> peces = controladorPez.consultarPez();
        if (peces.isEmpty()) {
            stockTexto.append("No hay peces en stock.\n");
        } else {
            for (Pez pez : peces) {
                stockTexto.append("  - ").append(pez.getNombre()).append(" (Raza: ").append(pez.getRaza()).append(")\n");
            }
        }

        stockTexto.append("\n--- Arañas ---\n");
        ArrayList<Arania> aranias = controladorArania.consultarArania();
        if (aranias.isEmpty()) {
            stockTexto.append("No hay arañas en stock.\n");
        } else {
            for (Arania arania : aranias) {
                stockTexto.append("  - ").append(arania.getNombre()).append(" (Raza: ").append(arania.getRaza()).append(")\n");
            }
        }

        stockTexto.append("\n--- Serpientes ---\n");
        ArrayList<Serpiente> serpientes = controladorSerpiente.consultarSerpiente();
        if (serpientes.isEmpty()) {
            stockTexto.append("No hay serpientes en stock.\n");
        } else {
            for (Serpiente serpiente : serpientes) {
                stockTexto.append("  - ").append(serpiente.getNombre()).append(" (Raza: ").append(serpiente.getRaza()).append(")\n");
            }
        }

        stockArea.setText(stockTexto.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscarPrecio) {
            String nombreAnimal = txtNombreAnimal.getText().trim();
            if (nombreAnimal.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese el nombre del animal.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String resultadoPrecio = buscarPrecioAnimal(nombreAnimal);
            precioOutputArea.setText(resultadoPrecio);
        }
    }

    /**
     * Método buscarPrecioAnimal.
     *
     * Ejecuta la acción del método buscarPrecioAnimal.
     * @param nombre Parámetro nombre.
     * @return Retorna un valor de tipo String.
     */
    private String buscarPrecioAnimal(String nombre) {
        // Buscar en perros
        for (Perro perro : controladorPerro.consultarPerros()) {
            if (perro.getNombre().equalsIgnoreCase(nombre)) {
                return "Animal: " + perro.getNombre() + " (Perro)\nPrecio: $" + perro.getPrecio();
            }
        }
        // Buscar en gatos
        for (Gato gato : controladorGato.consultarGatos()) {
            if (gato.getNombre().equalsIgnoreCase(nombre)) {
                return "Animal: " + gato.getNombre() + " (Gato)\nPrecio: $" + gato.getPrecio();
            }
        }
        // Buscar en peces
        for (Pez pez : controladorPez.consultarPez()) {
            if (pez.getNombre().equalsIgnoreCase(nombre)) {
                return "Animal: " + pez.getNombre() + " (Pez)\nPrecio: $" + pez.getPrecio();
            }
        }
        // Buscar en arañas
        for (Arania arania : controladorArania.consultarArania()) {
            if (arania.getNombre().equalsIgnoreCase(nombre)) {
                return "Animal: " + arania.getNombre() + " (Araña)\nPrecio: $" + arania.getPrecio();
            }
        }
        // Buscar en serpientes
        for (Serpiente serpiente : controladorSerpiente.consultarSerpiente()) {
            if (serpiente.getNombre().equalsIgnoreCase(nombre)) {
                return "Animal: " + serpiente.getNombre() + " (Serpiente)\nPrecio: $" + serpiente.getPrecio();
            }
        }

        return "No se encontró ningún animal con el nombre: '" + nombre + "'.";
    }

    /**
     * Método windowClosing.
     *
     * Ejecuta la acción del método windowClosing.
     * @param e Parámetro e.
     */
    public void windowClosing(WindowEvent e) {
        frame.dispose();
    }

    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
}
