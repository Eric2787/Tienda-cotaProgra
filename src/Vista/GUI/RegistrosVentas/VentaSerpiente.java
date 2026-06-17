package Vista.GUI.RegistrosVentas;

import Controlador.ControladorSerpiente;
import Modelo.Serpiente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentaSerpiente extends WindowAdapter implements ActionListener{

    //Componentes de la vista
    Frame f;
    TextArea txtAreaVentas;
    TextField txtBuscar;
    Button btnVender, btnBuscar;

    // Conexion con el ControladorSerpiente seleccionado
    private ControladorSerpiente controladorSerpiente;
    private Serpiente serpienteEncontrada;


    public VentaSerpiente(){
        //ControladorSerpiente
        this.controladorSerpiente = new ControladorSerpiente();

        // Configuración básica de la ventana
        f = new Frame("Ventas +Kota - Vender Serpientes");
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
        txtAreaVentas.setText("Aqui se muestra la serpiente.");

        Font fuenteEtiqueta = new Font("Arial", Font.BOLD, 14);
        Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);

        Panel panelBuscar = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelBuscar.setBackground(Color.LIGHT_GRAY);

        panelBuscar.add(crearLabel("Ingresa el nombre de la serpiente:", fuenteEtiqueta));
        txtBuscar = crearTextField(fuenteTexto);
        panelBuscar.add(txtBuscar);

        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(fuenteEtiqueta);
        btnBuscar.addActionListener(this);
        panelBuscar.add(btnBuscar);


        btnVender = new Button("Confirmar venta");
        btnVender.setFont(fuenteEtiqueta);
        btnVender.setEnabled(false); //Se muestra cuando se busca una serpiente
        btnVender.addActionListener(this);
        panelBuscar.add(btnVender);

        f.add(panelBuscar, BorderLayout.NORTH);
        f.add(txtAreaVentas, BorderLayout.CENTER);
        f.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVender) {
           if (serpienteEncontrada != null) {
               controladorSerpiente.venderSerpiente(serpienteEncontrada);
               JOptionPane.showMessageDialog(f, "¡Serpiente vendida con éxito!", "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);
               txtAreaVentas.setText("Aqui se muestra la serpiente.");
               txtBuscar.setText("");
               btnVender.setEnabled(false);
               serpienteEncontrada = null;
           }
        }

        if (e.getSource() == btnBuscar) {
            String busqueda = txtBuscar.getText().trim();

            if (busqueda.isEmpty()) {
                txtAreaVentas.setText("Ingresa el nombre de la serpiente");
                btnVender.setEnabled(false);
                serpienteEncontrada = null;
                return;
            }

            // Buscar la serpiente en el stock
            Serpiente foundSerpiente = null;
            for (Serpiente s : controladorSerpiente.consultarSerpiente()) {
                if (s.getNombre().equalsIgnoreCase(busqueda)) {
                    foundSerpiente = s;
                    break;
                }
            }
            serpienteEncontrada = foundSerpiente;

            if (serpienteEncontrada != null) {
                txtAreaVentas.setText("¡SERPIENTE ENCONTRADA!\n");
                txtAreaVentas.append("Nombre: " + serpienteEncontrada.getNombre() + "\n");
                txtAreaVentas.append("Edad: " + serpienteEncontrada.getEdad() + "\n");
                txtAreaVentas.append("Color: " + serpienteEncontrada.getColor() + "\n");
                txtAreaVentas.append("Raza: " + serpienteEncontrada.getRaza()+ "\n");
                txtAreaVentas.append("Tamaño: " + serpienteEncontrada.getTamanio()+ "\n");
                txtAreaVentas.append("Peso: " + serpienteEncontrada.getPeso()+ "\n");
                txtAreaVentas.append("Precio: " + serpienteEncontrada.getPrecio()+ "\n");

                String sexoMascota;
                if(serpienteEncontrada.getSexo()){
                    sexoMascota = "Macho";
                }else{
                    sexoMascota = "Hembra";
                }
                txtAreaVentas.append("Sexo: " + sexoMascota+ "\n");
                txtAreaVentas.append("Alimentacion: " + serpienteEncontrada.getAlimentacion()+ "\n");
                txtAreaVentas.append("País de Origen: " + serpienteEncontrada.getPaisOrigen()+ "\n");


                txtAreaVentas.append("Presione el botón 'Confirmar Venta' para realizar la operación. \n");
                btnVender.setEnabled(true); //Se muestra el boton para confirmar venta
            } else {
                txtAreaVentas.setText("No se encontró ninguna serpiente con el nombre: '" + busqueda + "' en el stock disponible.");
                btnVender.setEnabled(false);
                serpienteEncontrada = null;
            }

        }
    }
}