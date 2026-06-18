package Vista.GUI.Saludos;

import Controlador.ControladorSerpiente;
import Modelo.Serpiente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Clase SaludarSerpiente.
 *
 * Representa la clase SaludarSerpiente del sistema.
 */
public class SaludarSerpiente extends WindowAdapter implements ActionListener {

    private Frame frame;
    private TextArea stockArea;
    private TextField txtNombreSerpiente;
    private Button btnSaludar;
    private TextArea saludoOutputArea; // Área para mostrar el saludo y el arte ASCII
    private ControladorSerpiente controlador;

    public SaludarSerpiente() {
        controlador = new ControladorSerpiente();

        frame = new Frame("Saludos +Kota - Serpiente");
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 700);
	    frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(this);

        // Panel superior para el stock de serpientes
        JPanel panelStock = new JPanel(new BorderLayout());
        panelStock.add(new Label("Serpientes en Stock:"), BorderLayout.NORTH);
        stockArea = new TextArea();
        stockArea.setEditable(false);
        stockArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        actualizarStockArea();
        panelStock.add(stockArea, BorderLayout.CENTER);

        // Panel central para la entrada de nombre y botón
        JPanel panelInput = new JPanel(new FlowLayout());
        panelInput.add(new Label("Nombre de la serpiente a saludar:"));
        txtNombreSerpiente = new TextField(15);
        panelInput.add(txtNombreSerpiente);
        btnSaludar = new Button("Saludar");
        btnSaludar.addActionListener(this);
        panelInput.add(btnSaludar);

        // Panel inferior para el output del saludo
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.add(new Label("Saludo de la Serpiente:"), BorderLayout.NORTH);
        saludoOutputArea = new TextArea();
        saludoOutputArea.setEditable(false);
        saludoOutputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        panelOutput.add(saludoOutputArea, BorderLayout.CENTER);


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
        ArrayList<Serpiente> serpientes = controlador.consultarSerpiente();
        if (serpientes.isEmpty()) {
            stockTexto.append("No hay serpientes en stock para saludar.");
        } else {
            for (Serpiente serpiente : serpientes) {
                stockTexto.append("Nombre: ").append(serpiente.getNombre())
                        .append(", Raza: ").append(serpiente.getRaza())
                        .append(", País de Origen: ").append(serpiente.getPaisOrigen())
                        .append("\n");
            }
        }
        stockArea.setText(stockTexto.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSaludar) {
            String nombreSerpiente = txtNombreSerpiente.getText().trim();
            if (nombreSerpiente.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese el nombre de la serpiente a saludar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ArrayList<Serpiente> serpientes = controlador.consultarSerpiente();
            Serpiente serpienteASaludar = null;
            for (Serpiente serpiente : serpientes) {
                if (serpiente.getNombre().equalsIgnoreCase(nombreSerpiente)) {
                    serpienteASaludar = serpiente;
                    break;
                }
            }

            if (serpienteASaludar != null) {
                StringBuilder saludo = new StringBuilder();
                saludo.append("¡Hola! Soy ").append(serpienteASaludar.getNombre()).append(".\n");
                saludo.append("""
                         (\\   .-.   /_\")
                          \\\\_//^\\\\_//
                           `"`   `"`
                        """);
                saludo.append("\n");

                // El método Saludar() en ControladorSerpiente imprime a consola,
                // aquí simulamos el saludo específico.
                saludo.append("¡Ssssss!").append("\n"); // Saludo genérico de serpiente
                saludo.append("----------------------------------------\n");
                saludo.append("Detalles:\n");
                saludo.append("Edad: ").append(serpienteASaludar.getEdad()).append(" meses\n");
                saludo.append("Color: ").append(serpienteASaludar.getColor()).append("\n");
                saludo.append("Raza: ").append(serpienteASaludar.getRaza()).append("\n");
                saludo.append("Tamaño: ").append(serpienteASaludar.getTamanio()).append(" cm\n");
                saludo.append("Peso: ").append(serpienteASaludar.getPeso()).append(" kg\n");
                saludo.append("Precio: $").append(serpienteASaludar.getPrecio()).append("\n");
                saludo.append("País de Origen: ").append(serpienteASaludar.getPaisOrigen()).append("\n");
                saludo.append("Sexo: ").append(serpienteASaludar.getSexo() ? "Macho" : "Hembra").append("\n");
                saludo.append("Alimentación: ").append(serpienteASaludar.getAlimentacion()).append("\n");


                saludoOutputArea.setText(saludo.toString());
            } else {
                saludoOutputArea.setText("No se encontró ninguna serpiente con el nombre: '" + nombreSerpiente + "' en el stock disponible.");
            }
        }
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
}
