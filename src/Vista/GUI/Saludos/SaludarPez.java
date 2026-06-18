package Vista.GUI.Saludos;

import Controlador.ControladorPez;
import Modelo.Pez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class SaludarPez extends WindowAdapter implements ActionListener {

    private Frame frame;
    private TextArea stockArea;
    private TextField txtNombrePez;
    private Button btnSaludar;
    private TextArea saludoOutputArea; // Área para mostrar el saludo y el arte ASCII
    private ControladorPez controlador;

    public SaludarPez() {
        controlador = new ControladorPez();

        frame = new Frame("Saludos +Kota - Pez");
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 700);
	    frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(this);

        // Panel superior para el stock de peces
        JPanel panelStock = new JPanel(new BorderLayout());
        panelStock.add(new Label("Peces en Stock:"), BorderLayout.NORTH);
        stockArea = new TextArea();
        stockArea.setEditable(false);
        stockArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        actualizarStockArea();
        panelStock.add(stockArea, BorderLayout.CENTER);

        // Panel central para la entrada de nombre y botón
        JPanel panelInput = new JPanel(new FlowLayout());
        panelInput.add(new Label("Nombre del pez a saludar:"));
        txtNombrePez = new TextField(15);
        panelInput.add(txtNombrePez);
		txtNombrePez.setFont(new Font("Arial", Font.BOLD, 18));
        btnSaludar = new Button("Saludar");
        btnSaludar.addActionListener(this);
        panelInput.add(btnSaludar);

        // Panel inferior para el output del saludo
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.add(new Label("Saludo del Pez:"), BorderLayout.NORTH);
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
        ArrayList<Pez> peces = controlador.consultarPez();
        if (peces.isEmpty()) {
            stockTexto.append("No hay peces en stock para saludar.");
        } else {
            for (Pez pez : peces) {
                stockTexto.append("Nombre: ").append(pez.getNombre())
                        .append(", Raza: ").append(pez.getRaza())
                        .append(", Tipo de Agua: ").append(getTipoAguaString(pez.getTipoAgua()))
                        .append("\n");
            }
        }
        stockArea.setText(stockTexto.toString());
    }

    private String getTipoAguaString(boolean tipoAgua) {
        return tipoAgua ? "Salada" : "Dulce";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSaludar) {
            String nombrePez = txtNombrePez.getText().trim();
            if (nombrePez.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese el nombre del pez a saludar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ArrayList<Pez> peces = controlador.consultarPez();
            Pez pezASaludar = null;
            for (Pez pez : peces) {
                if (pez.getNombre().equalsIgnoreCase(nombrePez)) {
                    pezASaludar = pez;
                    break;
                }
            }

            if (pezASaludar != null) {
                StringBuilder saludo = new StringBuilder();
                saludo.append("¡Hola! Soy ").append(pezASaludar.getNombre()).append(".\n");
                saludo.append("""
                                      /`·.¸
                                     /¸...¸`:·
                                 ¸.·´  ¸   `·.¸.·´)
                                : © ):´;      ¸  {
                                 `·.¸ `·  ¸.·´\\`·¸)
                                     `\\\\´´\\¸.·´
                        """);
                saludo.append("\n");

                // El método Saludar() en ControladorPez imprime a consola,
                // aquí simulamos el saludo específico.
                saludo.append("¡Glub glub!").append("\n"); // Saludo genérico de pez
                saludo.append("----------------------------------------\n");
                saludo.append("Detalles:\n");
                saludo.append("Edad: ").append(pezASaludar.getEdad()).append(" meses\n");
                saludo.append("Color: ").append(pezASaludar.getColor()).append("\n");
                saludo.append("Raza: ").append(pezASaludar.getRaza()).append("\n");
                saludo.append("Tamaño: ").append(pezASaludar.getTamanio()).append(" cm\n");
                saludo.append("Peso: ").append(pezASaludar.getPeso()).append(" kg\n");
                saludo.append("Precio: $").append(pezASaludar.getPrecio()).append("\n");
                saludo.append("Tipo de Agua: ").append(getTipoAguaString(pezASaludar.getTipoAgua())).append("\n");
                saludo.append("Sexo: ").append(pezASaludar.getSexo() ? "Macho" : "Hembra").append("\n");
                saludo.append("Alimentación: ").append(pezASaludar.getAlimentacion()).append("\n");


                saludoOutputArea.setText(saludo.toString());
            } else {
                saludoOutputArea.setText("No se encontró ningún pez con el nombre: '" + nombrePez + "' en el stock disponible.");
            }
        }
    }

    public void windowClosing(WindowEvent e) {
        frame.dispose();
    }
}
