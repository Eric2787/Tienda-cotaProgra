package Vista.GUI.Registros;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import Controlador.ControladorGato;
import Controlador.ControladorValidacion;

/**
 * Clase RegistrarGato
 * Representa la interfaz gráfica (Vista) para registrar un nuevo gato en el sistema +KOTA.
 */
public class RegistrarGato implements ActionListener, WindowListener {

    // --- DECLARACIÓN DE COMPONENTES DE LA VISTA ---
    Frame f;
    TextArea txtArte;
    TextField txtNombre, txtEdad, txtColor, txtRaza;
    TextField txtTamanio, txtPeso, txtPrecio;
    Choice choiceSexo, choiceColorOjos, choiceAlimentacion;
    Button btnGuardar;

    // --- INSTANCIAS DE CONTROLADORES ---
    ControladorGato controlador;
    ControladorValidacion validador; // <-- DECLARAMOS EL VALIDADOR

    /**
     * Constructor de la clase RegistrarGato.
     */
    public RegistrarGato() {

        // INICIALIZAR CONTROLADORES
        controlador = new ControladorGato();
        validador = new ControladorValidacion();

        f = new Frame("Registro +Kota - Nuevo Gato");
        f.setLayout(new BorderLayout());
        f.setSize(700, 650);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.addWindowListener(this);

        String arteAscii =
                """
                        ,_     _,
                        |\\\\___//|
                        |=6   6=|
                        \\\\=._Y_.=//
                         )  `  (    ,
                        /       \\\\  ((
                        |       |   ))
                       /| |   | |\\\\_//
                       \\\\| |._.| |/-`
                        '"'   '"'""";

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

        // Precio y Color de Ojos
        panelFormulario.add(crearLabel("Precio ($):", fuenteEtiqueta));
        txtPrecio = crearTextField(fuenteTexto);
        panelFormulario.add(txtPrecio);

        panelFormulario.add(crearLabel("Color de Ojos:", fuenteEtiqueta));
        choiceColorOjos = new Choice();
        choiceColorOjos.add("Azules");
        choiceColorOjos.add("Verdes");
        choiceColorOjos.add("Negros");
        choiceColorOjos.add("Café");
        choiceColorOjos.add("Grises");
        choiceColorOjos.setFont(fuenteTexto);
        panelFormulario.add(choiceColorOjos);

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

        // --- BOTÓN (Zona Inferior) ---
        btnGuardar = new Button("Registrar Gato");
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

    private Label crearLabel(String texto, Font fuente) {
        Label lbl = new Label(texto);
        lbl.setFont(fuente);
        return lbl;
    }

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
            if (txtNombre.getText().trim().isEmpty() || txtRaza.getText().trim().isEmpty() || txtColor.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(f, "Por favor, llena los campos de Nombre, Color y Raza.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
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

            String nombre = txtNombre.getText();
            String raza = txtRaza.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String color = txtColor.getText();
            float tamanio = Float.parseFloat(txtTamanio.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            float precio = Float.parseFloat(txtPrecio.getText());

            int colorOjos = choiceColorOjos.getSelectedIndex() + 1;
            boolean sexo = (choiceSexo.getSelectedIndex() == 0);
            String alimentacion = choiceAlimentacion.getSelectedItem();

            controlador.registrarGato(nombre, raza, edad, color, tamanio, peso, precio, sexo, alimentacion, colorOjos);

            // Restaurar la interfaz vaciando los campos
            txtNombre.setText("");
            txtEdad.setText("");
            txtColor.setText("");
            txtRaza.setText("");
            txtTamanio.setText("");
            txtPeso.setText("");
            txtPrecio.setText("");
            choiceColorOjos.select(0);
            choiceSexo.select(0);
            choiceAlimentacion.select(0);

            JOptionPane.showMessageDialog(f, "¡El gato ha sido registrado correctamente en el sistema!", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
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