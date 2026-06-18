package Vista.GUI.RegistrosVentas;

import Controlador.ControladorPez;
import Modelo.Pez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Clase VentaPez.
 *
 * Representa la clase VentaPez del sistema.
 */
public class VentaPez extends WindowAdapter implements ActionListener{

    //Componentes de la vista
    Frame f;
    TextArea txtAreaVentas;
    TextField txtBuscar;
    Button btnVender, btnBuscar;

    // Conexion con el ControladorPez seleccionado
    private ControladorPez controladorPez;
    private Pez pezEncontrado;


    public VentaPez(){
        //ControladorPez
        this.controladorPez = new ControladorPez();

        // Configuración básica de la ventana
        f = new Frame("Ventas +Kota - Vender Peces");
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
        txtAreaVentas.setText("Aqui se muestra el pececito.");

        Font fuenteEtiqueta = new Font("Arial", Font.BOLD, 14);
        Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);

        Panel panelBuscar = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelBuscar.setBackground(Color.LIGHT_GRAY);

        panelBuscar.add(crearLabel("Ingresa el nombre del pececito:", fuenteEtiqueta));
        txtBuscar = crearTextField(fuenteTexto);
        panelBuscar.add(txtBuscar);

        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(fuenteEtiqueta);
        btnBuscar.addActionListener(this);
        panelBuscar.add(btnBuscar);


        btnVender = new Button("Confirmar venta");
        btnVender.setFont(fuenteEtiqueta);
        btnVender.setEnabled(false); //Se muestra cuando se busca un pez
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
           if (pezEncontrado != null) {
               controladorPez.venderPez(pezEncontrado);
               JOptionPane.showMessageDialog(f, "¡Pez vendido con éxito!", "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);
               txtAreaVentas.setText("Aqui se muestra el pececito.");
               txtBuscar.setText("");
               btnVender.setEnabled(false);
               pezEncontrado = null;
           }
        }

        if (e.getSource() == btnBuscar) {
            String busqueda = txtBuscar.getText().trim();

            if (busqueda.isEmpty()) {
                txtAreaVentas.setText("Ingresa el nombre del pececito");
                btnVender.setEnabled(false);
                pezEncontrado = null;
                return;
            }

            // Buscar el pez en el stock
            Pez foundPez = null;
            for (Pez p : controladorPez.consultarPez()) {
                if (p.getNombre().equalsIgnoreCase(busqueda)) {
                    foundPez = p;
                    break;
                }
            }
            pezEncontrado = foundPez;

            if (pezEncontrado != null) {
                txtAreaVentas.setText("¡PECECITO ENCONTRADO!\n");
                txtAreaVentas.append("Nombre: " + pezEncontrado.getNombre() + "\n");
                txtAreaVentas.append("Edad: " + pezEncontrado.getEdad() + "\n");
                txtAreaVentas.append("Color: " + pezEncontrado.getColor() + "\n");
                txtAreaVentas.append("Raza: " + pezEncontrado.getRaza()+ "\n");
                txtAreaVentas.append("Tamaño: " + pezEncontrado.getTamanio()+ "\n");
                txtAreaVentas.append("Peso: " + pezEncontrado.getPeso()+ "\n");
                txtAreaVentas.append("Precio: " + pezEncontrado.getPrecio()+ "\n");

                String tipoAguaPez= "";
                if(pezEncontrado.getTipoAgua()){
                    tipoAguaPez = "Salada";
                }else{
                    tipoAguaPez = "Dulce";
                }
                txtAreaVentas.append("Tipo de agua: " + tipoAguaPez + "\n");

                String sexoMascota;
                if(pezEncontrado.getSexo()){
                    sexoMascota = "Macho";
                }else{
                    sexoMascota = "Hembra";
                }
                txtAreaVentas.append("Sexo: " + sexoMascota+ "\n");
                txtAreaVentas.append("Alimentacion: " + pezEncontrado.getAlimentacion()+ "\n");


                txtAreaVentas.append("Presione el botón 'Confirmar Venta' para realizar la operación. \n");
                btnVender.setEnabled(true); //Se muestra el boton para confirmar venta
            } else {
                txtAreaVentas.setText("No se encontró ningún pececito con el nombre: '" + busqueda + "' en el stock disponible.");
                btnVender.setEnabled(false);
                pezEncontrado = null;
            }

        }
    }
}