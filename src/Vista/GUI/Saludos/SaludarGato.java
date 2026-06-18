package Vista.GUI.Saludos;

import Controlador.ControladorGato;
import Modelo.Gato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class SaludarGato extends WindowAdapter implements ActionListener {

    private Frame frame;
    private TextArea stockArea;
    private TextField txtNombreGato;
    private Button btnSaludar;
    private TextArea saludoOutputArea; // Área para mostrar el saludo y el arte ASCII
    private ControladorGato controlador;

    public SaludarGato() {
        controlador = new ControladorGato();

        frame = new Frame("Saludos +Kota - Gato");
        frame.setLayout(new BorderLayout());
		frame.setResizable(false);
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(this);

        // Panel superior para el stock de gatos
        JPanel panelStock = new JPanel(new BorderLayout());
        panelStock.add(new Label("Gatos en Stock:"), BorderLayout.NORTH);
        stockArea = new TextArea();
        stockArea.setEditable(false);
        stockArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        actualizarStockArea();
        panelStock.add(stockArea, BorderLayout.CENTER);

        // Panel central para la entrada de nombre y botón
        JPanel panelInput = new JPanel(new FlowLayout());
        panelInput.add(new Label("Nombre del gato a saludar:"));
        txtNombreGato = new TextField(15);
		txtNombreGato.setFont(new Font("Arial", Font.BOLD, 18));
        panelInput.add(txtNombreGato);
        btnSaludar = new Button("Saludar");
        btnSaludar.addActionListener(this);
        panelInput.add(btnSaludar);

        // Panel inferior para el output del saludo
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.add(new Label("Saludo del Gato:"), BorderLayout.NORTH);
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

    private void actualizarStockArea() {
        StringBuilder stockTexto = new StringBuilder();
        ArrayList<Gato> gatos = controlador.consultarGatos();
        if (gatos.isEmpty()) {
            stockTexto.append("No hay gatos en stock para saludar.");
        } else {
            for (Gato gato : gatos) {
                stockTexto.append("Nombre: ").append(gato.getNombre())
                        .append(", Raza: ").append(gato.getRaza())
                        .append(", Color de Ojos: ").append(getColorOjosString(gato.getColorOjos()))
                        .append("\n");
            }
        }
        stockArea.setText(stockTexto.toString());
    }

    private String getColorOjosString(int colorOjos) {
        return switch (colorOjos) {
            case 1 -> "Azules";
            case 2 -> "Verdes";
            case 3 -> "Negros";
            case 4 -> "Cafe";
            case 5 -> "Grises";
            default -> "Desconocido";
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSaludar) {
            String nombreGato = txtNombreGato.getText().trim();
            if (nombreGato.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese el nombre del gato a saludar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ArrayList<Gato> gatos = controlador.consultarGatos();
            Gato gatoASaludar = null;
            for (Gato gato : gatos) {
                if (gato.getNombre().equalsIgnoreCase(nombreGato)) {
                    gatoASaludar = gato;
                    break;
                }
            }

            if (gatoASaludar != null) {
                StringBuilder saludo = new StringBuilder();
                saludo.append("¡Hola! Soy ").append(gatoASaludar.getNombre()).append(".\n");
                saludo.append("""
                         /\\_/\\
                        ( o.o )
                         > ^ <
                        """);
                saludo.append("\n");

                // El método Saludar() en ControladorGato imprime a consola,
                // aquí simulamos el saludo específico.
                saludo.append("¡MIAU!").append("\n"); // Saludo genérico de gato
                saludo.append("----------------------------------------\n");
                saludo.append("Detalles:\n");
                saludo.append("Edad: ").append(gatoASaludar.getEdad()).append(" meses\n");
                saludo.append("Color: ").append(gatoASaludar.getColor()).append("\n");
                saludo.append("Raza: ").append(gatoASaludar.getRaza()).append("\n");
                saludo.append("Tamaño: ").append(gatoASaludar.getTamanio()).append(" cm\n");
                saludo.append("Peso: ").append(gatoASaludar.getPeso()).append(" kg\n");
                saludo.append("Precio: $").append(gatoASaludar.getPrecio()).append("\n");
                saludo.append("Color de Ojos: ").append(getColorOjosString(gatoASaludar.getColorOjos())).append("\n");
                saludo.append("Sexo: ").append(gatoASaludar.getSexo() ? "Macho" : "Hembra").append("\n");
                saludo.append("Alimentación: ").append(gatoASaludar.getAlimentacion()).append("\n");


                saludoOutputArea.setText(saludo.toString());
            } else {
                saludoOutputArea.setText("No se encontró ningún gato con el nombre: '" + nombreGato + "' en el stock disponible.");
            }
        }
    }

    public void windowClosing(WindowEvent e) {
        frame.dispose();
    }
}
