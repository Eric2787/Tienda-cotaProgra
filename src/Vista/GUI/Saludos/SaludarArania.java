package Vista.GUI.Saludos;

import Controlador.ControladorArania;
import Modelo.Arania;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Clase SaludarArania.
 *
 * Representa la clase SaludarArania del sistema.
 */
public class SaludarArania extends WindowAdapter implements ActionListener {

    private Frame frame;
    private TextArea stockArea;
    private TextField txtNombreArania;
    private Button btnSaludar;
    private TextArea saludoOutputArea; // Área para mostrar el saludo y el arte ASCII
    private ControladorArania controlador;

    public SaludarArania() {
        controlador = new ControladorArania();

        frame = new Frame("Saludos +Kota - Araña");
        frame.setLayout(new BorderLayout());
	    frame.setResizable(false);
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(this);

        // Panel superior para el stock de arañas
        JPanel panelStock = new JPanel(new BorderLayout());
        panelStock.add(new Label("Arañas en Stock:"), BorderLayout.NORTH);
        stockArea = new TextArea();
        stockArea.setEditable(false);
        stockArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        actualizarStockArea();
        panelStock.add(stockArea, BorderLayout.CENTER);

        // Panel central para la entrada de nombre y botón
        JPanel panelInput = new JPanel(new FlowLayout());
        panelInput.add(new Label("Nombre de la araña a saludar:"));
        txtNombreArania = new TextField(15);
        panelInput.add(txtNombreArania);
		txtNombreArania.setFont(new Font("Arial", Font.BOLD, 18));
        btnSaludar = new Button("Saludar");
        btnSaludar.addActionListener(this);
        panelInput.add(btnSaludar);

        // Panel inferior para el output del saludo
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.add(new Label("Saludo de la Araña:"), BorderLayout.NORTH);
		panelOutput.setFont(new Font("Arial", Font.BOLD, 18));
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
        ArrayList<Arania> aranias = controlador.consultarArania();
        if (aranias.isEmpty()) {
            stockTexto.append("No hay arañas en stock para saludar.");
        } else {
            for (Arania arania : aranias) {
                stockTexto.append("Nombre: ").append(arania.getNombre())
                        .append(", Raza: ").append(arania.getRaza())
                        .append(", Venenosa: ").append(arania.getVenenosa() ? "Sí" : "No")
                        .append("\n");
            }
        }
        stockArea.setText(stockTexto.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSaludar) {
            String nombreArania = txtNombreArania.getText().trim();
            if (nombreArania.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese el nombre de la araña a saludar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ArrayList<Arania> aranias = controlador.consultarArania();
            Arania araniaASaludar = null;
            for (Arania arania : aranias) {
                if (arania.getNombre().equalsIgnoreCase(nombreArania)) {
                    araniaASaludar = arania;
                    break;
                }
            }

            if (araniaASaludar != null) {
                StringBuilder saludo = new StringBuilder();
                saludo.append("¡Hola! Soy ").append(araniaASaludar.getNombre()).append(".\n");
                saludo.append("""
                         /\\ \\  / /\\
                        //\\\\ .. //\\\\
                        //\\((  ))/\\\\
                        /  < '' >  \\
                        """);
                saludo.append("\n");

                // El método Saludar() en ControladorArania imprime a consola,
                // aquí simulamos el saludo específico.
                saludo.append("¡Sssshhh!").append("\n"); // Saludo genérico de araña
                saludo.append("----------------------------------------\n");
                saludo.append("Detalles:\n");
                saludo.append("Edad: ").append(araniaASaludar.getEdad()).append(" meses\n");
                saludo.append("Color: ").append(araniaASaludar.getColor()).append("\n");
                saludo.append("Raza: ").append(araniaASaludar.getRaza()).append("\n");
                saludo.append("Tamaño: ").append(araniaASaludar.getTamanio()).append(" cm\n");
                saludo.append("Peso: ").append(araniaASaludar.getPeso()).append(" kg\n");
                saludo.append("Precio: $").append(araniaASaludar.getPrecio()).append("\n");
                saludo.append("Venenosa: ").append(araniaASaludar.getVenenosa() ? "Sí" : "No").append("\n");
                saludo.append("Sexo: ").append(araniaASaludar.getSexo() ? "Macho" : "Hembra").append("\n");
                saludo.append("Alimentación: ").append(araniaASaludar.getAlimentacion()).append("\n");


                saludoOutputArea.setText(saludo.toString());
            } else {
                saludoOutputArea.setText("No se encontró ninguna araña con el nombre: '" + nombreArania + "' en el stock disponible.");
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
