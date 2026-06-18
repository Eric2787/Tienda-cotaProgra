package Vista.GUI.RegistrosVentas;

import Controlador.ControladorArania;
import Modelo.Arania;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase VentaArania.
 *
 * Representa la clase VentaArania del sistema.
 */
public class VentaArania extends WindowAdapter implements ActionListener{

    //Componentes de la vista
    Frame f;
    TextArea txtAreaVentas;
    TextField txtBuscar;
    Button btnVender, btnBuscar;

    // Conexion con el ControladorArania seleccionado
    private ControladorArania controladorArania;
    private Arania araniaEncontrada;


    public VentaArania(){
        //ControladorArania
        this.controladorArania = new ControladorArania();

        // Configuración básica de la ventana
        f = new Frame("Ventas +Kota - Vender Arañas");
        f.setLayout(new BorderLayout());
        f.setSize(700, 650);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.addWindowListener(this);

        txtAreaVentas = new TextArea();
        txtAreaVentas.setEditable(false);
        txtAreaVentas.setFont(new Font("Arial", Font.BOLD, 16));
        txtAreaVentas.setBackground(Color.WHITE);
        txtAreaVentas.setForeground(Color.BLACK);
        txtAreaVentas.setText("Aqui se muestra la arañita.");

        Font fuenteEtiqueta = new Font("Arial", Font.BOLD, 14);
        Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);

        Panel panelBuscar = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelBuscar.setBackground(Color.LIGHT_GRAY);

        panelBuscar.add(crearLabel("Ingresa el nombre de la arañita:", fuenteEtiqueta));
        txtBuscar = crearTextField(fuenteTexto);
        panelBuscar.add(txtBuscar);

        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(fuenteEtiqueta);
        btnBuscar.addActionListener(this);
        panelBuscar.add(btnBuscar);


        btnVender = new Button("Confirmar venta");
        btnVender.setFont(fuenteEtiqueta);
        btnVender.setEnabled(false); //Se muestra cuando se busca una araña
        btnVender.addActionListener(this);
        panelBuscar.add(btnVender);

        f.add(panelBuscar, BorderLayout.NORTH);
        f.add(txtAreaVentas, BorderLayout.CENTER);
        f.setVisible(true);
    }

    /**
     * Método windowClosing.
     *
     * Ejecuta la acción del método windowClosing.
     * @param e Parámetro e.
     */
    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    /**
     * Método crearLabel.
     *
     * Ejecuta la acción del método crearLabel.
     * @param texto Parámetro texto.
     * @param fuente Parámetro fuente.
     * @return Retorna un valor de tipo Label.
     */
    private Label crearLabel(String texto, Font fuente) {
        Label lbl = new Label(texto);
        lbl.setFont(fuente);
        return lbl;
    }

    /**
     * Método crearTextField.
     *
     * Ejecuta la acción del método crearTextField.
     * @param fuente Parámetro fuente.
     * @return Retorna un valor de tipo TextField.
     */
    private TextField crearTextField(Font fuente) {
        TextField txt = new TextField(12);
        txt.setFont(fuente);
        return txt;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVender) {
           if (araniaEncontrada != null) {
               controladorArania.venderArania(araniaEncontrada);
               JOptionPane.showMessageDialog(f, "¡Araña vendida con éxito!", "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);
               txtAreaVentas.setText("Aqui se muestra la arañita.");
               txtBuscar.setText("");
               btnVender.setEnabled(false);
               araniaEncontrada = null;
           }
        }

        if (e.getSource() == btnBuscar) {
            String busqueda = txtBuscar.getText().trim();

            if (busqueda.isEmpty()) {
                txtAreaVentas.setText("Ingresa el nombre de la arañita");
                btnVender.setEnabled(false);
                araniaEncontrada = null;
                return;
            }

            // Buscar la araña en el stock
            Arania foundArania = null;
            for (Arania a : controladorArania.consultarArania()) {
                if (a.getNombre().equalsIgnoreCase(busqueda)) {
                    foundArania = a;
                    break;
                }
            }
            araniaEncontrada = foundArania;

            if (araniaEncontrada != null) {
                txtAreaVentas.setText("¡ARAÑITA ENCONTRADA!\n");
                txtAreaVentas.append("Nombre: " + araniaEncontrada.getNombre() + "\n");
                txtAreaVentas.append("Edad: " + araniaEncontrada.getEdad() + "\n");
                txtAreaVentas.append("Color: " + araniaEncontrada.getColor() + "\n");
                txtAreaVentas.append("Raza: " + araniaEncontrada.getRaza()+ "\n");
                txtAreaVentas.append("Tamaño: " + araniaEncontrada.getTamanio()+ "\n");
                txtAreaVentas.append("Peso: " + araniaEncontrada.getPeso()+ "\n");
                txtAreaVentas.append("Precio: " + araniaEncontrada.getPrecio()+ "\n");

                String venenosaStr = araniaEncontrada.getVenenosa() ? "Sí" : "No";
                txtAreaVentas.append("Venenosa: " + venenosaStr + "\n");

                String sexoMascota;
                if(araniaEncontrada.getSexo()){
                    sexoMascota = "Macho";
                }else{
                    sexoMascota = "Hembra";
                }
                txtAreaVentas.append("Sexo: " + sexoMascota+ "\n");
                txtAreaVentas.append("Alimentacion: " + araniaEncontrada.getAlimentacion()+ "\n");


                txtAreaVentas.append("Presione el botón 'Confirmar Venta' para realizar la operación. \n");
                btnVender.setEnabled(true); //Se muestra el boton para confirmar venta
            } else {
                txtAreaVentas.setText("No se encontró ninguna arañita con el nombre: '" + busqueda + "' en el stock disponible.");
                btnVender.setEnabled(false);
                araniaEncontrada = null;
            }

        }
    }
}