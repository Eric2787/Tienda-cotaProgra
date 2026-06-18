package Vista.GUI.Saludos;

import Controlador.ControladorPerro;
import Modelo.Perro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Clase SaludarPerro.
 *
 * Representa la clase SaludarPerro del sistema.
 */
public class SaludarPerro extends WindowAdapter implements ActionListener {

    private Frame frame;
    private TextArea stockArea;
    private TextField txtNombrePerro;
    private Button btnSaludar;
    private TextArea saludoOutputArea; // Área para mostrar el saludo y el arte ASCII
    private ControladorPerro controlador;

    public SaludarPerro() {
        controlador = new ControladorPerro();

        frame = new Frame("Saludos +Kota - Perro");
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 700);
	    frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(this);

        // Panel superior para el stock de perros
        JPanel panelStock = new JPanel(new BorderLayout());
        panelStock.add(new Label("Perros en Stock:"), BorderLayout.NORTH);
		panelStock.setFont(new Font("Arial", Font.BOLD, 18));
        stockArea = new TextArea();
        stockArea.setEditable(false);
        stockArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
       /**
        * Método actualizarStockArea.
        *
        * Ejecuta la acción del método actualizarStockArea.
        */
        actualizarStockArea();
        panelStock.add(stockArea, BorderLayout.CENTER);

        // Panel central para la entrada de nombre y botón
        JPanel panelInput = new JPanel(new FlowLayout());
        panelInput.add(new Label("Nombre del perro a saludar:"));
		panelInput.setFont(new Font("Arial", Font.BOLD, 18));
        txtNombrePerro = new TextField(15);
        panelInput.add(txtNombrePerro);
        btnSaludar = new Button("Saludar");
        btnSaludar.addActionListener(this);
        panelInput.add(btnSaludar);

        // Panel inferior para el output del saludo
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.add(new Label("Saludo del Perro:"), BorderLayout.NORTH);
		panelOutput.setFont(new Font("Arial", Font.BOLD, 18));
        saludoOutputArea = new TextArea();
        saludoOutputArea.setEditable(false);
        saludoOutputArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
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
        ArrayList<Perro> perros = controlador.consultarPerros();
        if (perros.isEmpty()) {
            stockTexto.append("No hay perros en stock para saludar.");
        } else {
            for (Perro perro : perros) {
                stockTexto.append("Nombre: ").append(perro.getNombre())
                        .append(", Raza: ").append(perro.getRaza())
                        .append(", Perfil: ").append(getPerfilString(perro.getPerfil()))
                        .append("\n");
            }
        }
        stockArea.setText(stockTexto.toString());
    }

    /**
     * Método getPerfilString.
     *
     * Ejecuta la acción del método getPerfilString.
     * @param perfil Parámetro perfil.
     * @return Retorna un valor de tipo String.
     */
    private String getPerfilString(int perfil) {
        return switch (perfil) {
            case 1 -> "Semental";
            case 2 -> "Mascota";
            case 3 -> "Policia";
            case 4 -> "Apoyo a invidentes";
            default -> "Desconocido";
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSaludar) {
            String nombrePerro = txtNombrePerro.getText().trim();
            if (nombrePerro.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese el nombre del perro a saludar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ArrayList<Perro> perros = controlador.consultarPerros();
            Perro perroASaludar = null;
            for (Perro perro : perros) {
                if (perro.getNombre().equalsIgnoreCase(nombrePerro)) {
                    perroASaludar = perro;
                    break;
                }
            }

            if (perroASaludar != null) {
                StringBuilder saludo = new StringBuilder();
                saludo.append("¡Hola! Soy ").append(perroASaludar.getNombre()).append(".\n");
                saludo.append("""
                          /^ ^\\
                         / 0 0 \\
                         V\\ Y /V
                          / - \\
                         /    |
                        V__) ||
                        """);
                saludo.append("\n");

                // Obtener el saludo específico del controlador (simulando la salida de consola)
                // Nota: El método Saludar(int perfil) en ControladorPerro imprime a consola.
                // Para una GUI, idealmente el controlador debería devolver el String.
                // Aquí lo simulamos con un switch.
                String perfilSaludo = "";
                switch (perroASaludar.getPerfil()) {
                    case 1: perfilSaludo = "¡GUAU, GUAU!"; break;
                    case 2: perfilSaludo = "El perrito esta dormido"; break;
                    case 3: perfilSaludo = "El perrito esta olfateando"; break;
                    case 4: perfilSaludo = "El perro esta sentado esperando"; break;
                }
                saludo.append(perfilSaludo).append("\n");
                saludo.append("----------------------------------------\n");
                saludo.append("Detalles:\n");
                saludo.append("Edad: ").append(perroASaludar.getEdad()).append(" meses\n");
                saludo.append("Color: ").append(perroASaludar.getColor()).append("\n");
                saludo.append("Raza: ").append(perroASaludar.getRaza()).append("\n");
                saludo.append("Tamaño: ").append(perroASaludar.getTamanio()).append(" cm\n");
                saludo.append("Peso: ").append(perroASaludar.getPeso()).append(" kg\n");
                saludo.append("Precio: $").append(perroASaludar.getPrecio()).append("\n");
                saludo.append("Perfil: ").append(getPerfilString(perroASaludar.getPerfil())).append("\n");
                saludo.append("Sexo: ").append(perroASaludar.getSexo() ? "Macho" : "Hembra").append("\n");
                saludo.append("Alimentación: ").append(perroASaludar.getAlimentacion()).append("\n");


                saludoOutputArea.setText(saludo.toString());
            } else {
                saludoOutputArea.setText("No se encontró ningún perro con el nombre: '" + nombrePerro + "' en el stock disponible.");
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
