package Vista.GUI.RegistrosStock;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

// CONTROLADORES
import Controlador.ControladorSerpiente;
import Controlador.ControladorValidacion;

/**
 * Clase RegistrarSerpiente
 * Representa la interfaz gráfica (Vista) para registrar una nueva serpiente en el sistema +KOTA.
 */
public class RegistrarSerpiente implements ActionListener, WindowListener {

    // --- DECLARACIÓN DE COMPONENTES DE LA VISTA ---
    Frame f;
    TextArea txtArte;
    TextField txtNombre, txtEdad, txtColor, txtRaza;
    TextField txtTamanio, txtPeso, txtPrecio, txtPaisOrigen;
    Choice choiceSexo, choiceAlimentacion;
    Button btnGuardar;

    // --- INSTANCIAS DE CONTROLADORES ---
    ControladorSerpiente controlador;
    ControladorValidacion validador; // <-- DECLARAMOS EL VALIDADOR

    /**
     * Constructor de la clase RegistrarSerpiente.
     */
    public RegistrarSerpiente() {
        controlador = new ControladorSerpiente();
        validador = new ControladorValidacion(); // <-- INICIALIZAMOS EL VALIDADOR

        // Configuración básica de la ventana principal
        f = new Frame("Registro +Kota - Nueva Serpiente");
        f.setLayout(new BorderLayout());
        f.setSize(700, 650);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.addWindowListener(this);

        String arteAscii =
                """
                

                                       (\\   .-.   /_")
                                        \\\\_//^\\\\_//
                                         `"`   `"`
                

                """;

        txtArte = new TextArea(arteAscii, 12, 50, TextArea.SCROLLBARS_NONE);
        txtArte.setEditable(false);
        txtArte.setBackground(Color.white);
        txtArte.setForeground(Color.black);
        txtArte.setFont(new Font("Monospaced", Font.BOLD, 14));

        Font fuenteEtiqueta = new Font("Arial", Font.BOLD, 14);
        Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);

        // --- FORMULARIO ---
        Panel panelFormulario = new Panel(new GridLayout(5, 4, 15, 25));

        // Nombre y Edad
        panelFormulario.add(crearLabel("Nombre:", fuenteEtiqueta));
        txtNombre = crearTextField(fuenteTexto);
        panelFormulario.add(txtNombre);

        panelFormulario.add(crearLabel("Edad (meses):", fuenteEtiqueta));
        txtEdad = crearTextField(fuenteTexto);
        panelFormulario.add(txtEdad);

        // Color y Raza
        panelFormulario.add(crearLabel("Color:", fuenteEtiqueta));
        txtColor = crearTextField(fuenteTexto);
        panelFormulario.add(txtColor);

        panelFormulario.add(crearLabel("Raza:", fuenteEtiqueta));
        txtRaza = crearTextField(fuenteTexto);
        panelFormulario.add(txtRaza);

        // Tamaño y Peso
        panelFormulario.add(crearLabel("Tamaño (cm):", fuenteEtiqueta));
        txtTamanio = crearTextField(fuenteTexto);
        panelFormulario.add(txtTamanio);

        panelFormulario.add(crearLabel("Peso (kg):", fuenteEtiqueta));
        txtPeso = crearTextField(fuenteTexto);
        panelFormulario.add(txtPeso);

        // Precio y País de Origen
        panelFormulario.add(crearLabel("Precio ($):", fuenteEtiqueta));
        txtPrecio = crearTextField(fuenteTexto);
        panelFormulario.add(txtPrecio);

        panelFormulario.add(crearLabel("País de Origen:", fuenteEtiqueta));
        txtPaisOrigen = crearTextField(fuenteTexto);
        panelFormulario.add(txtPaisOrigen);

        // Sexo y Alimentación
        panelFormulario.add(crearLabel("Sexo:", fuenteEtiqueta));
        choiceSexo = new Choice();
        choiceSexo.add("Macho");
        choiceSexo.add("Hembra");
        choiceSexo.setFont(fuenteTexto);
        panelFormulario.add(choiceSexo);

        panelFormulario.add(crearLabel("Alimentación:", fuenteEtiqueta));
        choiceAlimentacion = new Choice();
        choiceAlimentacion.add("Carnivoro");
        choiceAlimentacion.add("Hervivoro");
        choiceAlimentacion.add("Omnivoro");
        choiceAlimentacion.setFont(fuenteTexto);
        panelFormulario.add(choiceAlimentacion);

        Panel panelCentro = new Panel(new FlowLayout(FlowLayout.CENTER, 30, 40));
        panelCentro.add(panelFormulario);

        btnGuardar = new Button("Registrar Serpiente");
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 20));
        btnGuardar.setBackground(Color.gray);
        btnGuardar.setForeground(Color.BLACK);
        btnGuardar.addActionListener(this);

        // --- ENSAMBLAJE FINAL ---
        f.add(txtArte, BorderLayout.NORTH);
        f.add(panelCentro, BorderLayout.CENTER);
        f.add(btnGuardar, BorderLayout.SOUTH);
        f.setVisible(true);
    }

	/**
	 * Ejecuta la acción del método crearLabel.
	 * @param texto Parámetro texto.
	 * @param fuente Parámetro fuente.
	 * @return Un valor de tipo Label.
	 */
    private Label crearLabel(String texto, Font fuente) {
        Label lbl = new Label(texto);
        lbl.setFont(fuente);
        return lbl;
    }

	/**
	 * Ejecuta la acción del método crearTextField.
	 * @param fuente Parámetro fuente.
	 * @return Un valor de tipo TextField.
	 */
    private TextField crearTextField(Font fuente) {
        TextField txt = new TextField(12);
        txt.setFont(fuente);
        return txt;
    }

    // --- LÓGICA DE EVENTOS (Acción del botón) ---
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {

            // VALIDACIÓN: Comprobar que no haya campos de texto vacíos
            if (txtNombre.getText().trim().isEmpty() || txtRaza.getText().trim().isEmpty() ||
                    txtColor.getText().trim().isEmpty() || txtPaisOrigen.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(f, "Por favor, llena los campos de Nombre, Color, Raza y País de Origen.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // --- NUEVA VALIDACIÓN USANDO TU CONTROLADOR ---
            if (!validador.valEntero(txtEdad.getText()) ||
                    !validador.valFloat(txtTamanio.getText()) ||
                    !validador.valFloat(txtPeso.getText()) ||
                    !validador.valFloat(txtPrecio.getText())) {

                JOptionPane.showMessageDialog(f, "Error en los datos numéricos.\nPor favor ingresa solo números válidos en Edad, Tamaño, Peso y Precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Si pasa las validaciones
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String color = txtColor.getText();
            String raza = txtRaza.getText();
            float tamanio = Float.parseFloat(txtTamanio.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            float precio = Float.parseFloat(txtPrecio.getText());
            String paisOrigen = txtPaisOrigen.getText();

            boolean sexo = (choiceSexo.getSelectedIndex() == 0);
            String alimentacion = choiceAlimentacion.getSelectedItem();

            controlador.registrarSerpiente(nombre, edad, color, raza, tamanio, peso, precio, sexo, alimentacion, paisOrigen);

            // Restaurar la interfaz vaciando los campos
            txtNombre.setText("");
            txtEdad.setText("");
            txtColor.setText("");
            txtRaza.setText("");
            txtTamanio.setText("");
            txtPeso.setText("");
            txtPrecio.setText("");
            txtPaisOrigen.setText("");
            choiceSexo.select(0);
            choiceAlimentacion.select(0);

            // MENSAJE DE ÉXITO VISUAL
            JOptionPane.showMessageDialog(f, "¡La serpiente ha sido registrada correctamente en el sistema!", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // --- LÓGICA DE LA VENTANA ---
    @Override
    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
}