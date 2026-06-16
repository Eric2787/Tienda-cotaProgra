package Vista.GUI.Registros;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane; //ALERTAS VISUALES

import Controlador.ControladorPerro;

/**
 * Clase RegistrarPerro
 * Representa la interfaz gráfica (Vista) para registrar un nuevo perro en el sistema +KOTA.
 */
public class RegistrarPerro implements ActionListener, WindowListener {

    // --- 1. DECLARACIÓN DE COMPONENTES DE LA VISTA ---
    Frame f;
    TextArea txtArte;
    TextField txtNombre, txtEdad, txtColor, txtRaza;
    TextField txtTamanio, txtPeso, txtPrecio;
    Choice choiceSexo, choicePerfil, choiceAlimentacion;
    Button btnGuardar;

    // INSTANCIA DEL CONTROLADOR ---
    ControladorPerro controlador;

    /**
     * Constructor de la clase RegistrarPerro.
     * Inicializa el controlador, configura la ventana y todos los elementos visuales.
     */
    public RegistrarPerro() {
        controlador = new ControladorPerro();

        // Configuración básica de la ventana principal
        f = new Frame("Registro +Kota - Nuevo Perro");
        f.setLayout(new BorderLayout());
        f.setSize(700, 650);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.addWindowListener(this);

        String arteAscii =
                "   /(\n" +
                        "  //\\\\\n" +
                        " // )_.-\"\"\"-._,-\"\"-.\n" +
                        " \\\\ ^,'_\\ /_\\ )\n" +
                        "  `./ /O\\| |/O\\\\ /\n" +
                        "    \\ \\_/| |\\_/ \\_/\n" +
                        "     \\ .' _ `. /\n" +
                        " .-. ( .:(_):. ) ,-.\n" +
                        "( `._`._.-._,'_,' )\n" +
                        " ) (\n" +
                        "( .-------------. ) hjw\n" +
                        " `-' `-'";

        txtArte = new TextArea(arteAscii, 12, 50, TextArea.SCROLLBARS_NONE);
        txtArte.setEditable(false);
        txtArte.setBackground(Color.white);
        txtArte.setForeground(Color.black);
        txtArte.setFont(new Font("Monospaced", Font.BOLD, 14));

        Font fuenteEtiqueta = new Font("Arial", Font.BOLD, 14);
        Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);

        // --- FORMULARIO ---
        Panel panelFormulario = new Panel(new GridLayout(5, 4, 15, 25));

        // Fila 1: Nombre y Edad
        panelFormulario.add(crearLabel("Nombre:", fuenteEtiqueta));
        txtNombre = crearTextField(fuenteTexto);
        panelFormulario.add(txtNombre);

        panelFormulario.add(crearLabel("Edad (meses):", fuenteEtiqueta));
        txtEdad = crearTextField(fuenteTexto);
        panelFormulario.add(txtEdad);

        // Fila 2: Color y Raza
        panelFormulario.add(crearLabel("Color:", fuenteEtiqueta));
        txtColor = crearTextField(fuenteTexto);
        panelFormulario.add(txtColor);

        panelFormulario.add(crearLabel("Raza:", fuenteEtiqueta));
        txtRaza = crearTextField(fuenteTexto);
        panelFormulario.add(txtRaza);

        // Fila 3: Tamaño y Peso
        panelFormulario.add(crearLabel("Tamaño (cm):", fuenteEtiqueta));
        txtTamanio = crearTextField(fuenteTexto);
        panelFormulario.add(txtTamanio);

        panelFormulario.add(crearLabel("Peso (kg):", fuenteEtiqueta));
        txtPeso = crearTextField(fuenteTexto);
        panelFormulario.add(txtPeso);

        // Fila 4: Precio y Perfil
        panelFormulario.add(crearLabel("Precio ($):", fuenteEtiqueta));
        txtPrecio = crearTextField(fuenteTexto);
        panelFormulario.add(txtPrecio);

        panelFormulario.add(crearLabel("Perfil:", fuenteEtiqueta));
        choicePerfil = new Choice();
        choicePerfil.add("Semental");           // Índice 0
        choicePerfil.add("Mascota");            // Índice 1
        choicePerfil.add("Policia");            // Índice 2
        choicePerfil.add("Apoyo a Incidentes"); // Índice 3
        choicePerfil.setFont(fuenteTexto);
        panelFormulario.add(choicePerfil);

        // Fila 5: Sexo y Alimentación
        panelFormulario.add(crearLabel("Sexo:", fuenteEtiqueta));
        choiceSexo = new Choice();
        choiceSexo.add("Macho");  // Índice 0
        choiceSexo.add("Hembra"); // Índice 1
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
        btnGuardar = new Button("Registrar Perro");
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

            //VALIDACION: Comprobar que no haya campos de texto vacíos
            if (txtNombre.getText().trim().isEmpty() || txtRaza.getText().trim().isEmpty() || txtColor.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(f, "Por favor, llena los campos de Nombre, Color y Raza.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
                return; // Detiene la ejecución para que no intente guardar
            }

            try {
                // Extraer los textos ingresados y convertirlos a sus tipos de dato correspondientes
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String color = txtColor.getText();
                String raza = txtRaza.getText();
                float tamanio = Float.parseFloat(txtTamanio.getText());
                float peso = Float.parseFloat(txtPeso.getText());
                float precio = Float.parseFloat(txtPrecio.getText());

                // Se suma +1 al índice porque getSelectedIndex() devuelve 0, 1, 2, 3 pero la BD espera 1, 2, 3, 4
                int perfil = choicePerfil.getSelectedIndex() + 1;
                // Si el índice es 0 ("Macho"), devuelve true. Si es 1 ("Hembra"), devuelve false.
                boolean sexo = (choiceSexo.getSelectedIndex() == 0);
                // Extrae el texto exacto seleccionado (ej. "Carnivoro")
                String alimentacion = choiceAlimentacion.getSelectedItem();

                // Pasar los datos extraídos y validados al metodo del controlador
                controlador.registrarPerro(nombre, edad, color, raza, tamanio, peso, precio, perfil, sexo, alimentacion);

                // Restaurar la interfaz vaciando los campos tras un registro exitoso
                txtNombre.setText("");
                txtEdad.setText("");
                txtColor.setText("");
                txtRaza.setText("");
                txtTamanio.setText("");
                txtPeso.setText("");
                txtPrecio.setText("");
                choicePerfil.select(0);
                choiceSexo.select(0);
                choiceAlimentacion.select(0);

                // MENSAJE DE ÉXITO
                JOptionPane.showMessageDialog(f, "¡El perro ha sido registrado correctamente en el sistema!", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                // MENSAJE DE ERROR
                JOptionPane.showMessageDialog(f, "Error en los datos numéricos.\nPor favor ingresa solo números en Edad, Tamaño, Peso y Precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // --- LÓGICA DE LA VENTANA ---
    @Override
    public void windowClosing(WindowEvent e) {
        // Cierra únicamente esta ventana liberando recursos en memoria, sin detener toda la aplicación
        f.dispose();
    }

    // Métodos obligatorios de la interfaz WindowListener (no usados en este caso pero requeridos por Java)
    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
}