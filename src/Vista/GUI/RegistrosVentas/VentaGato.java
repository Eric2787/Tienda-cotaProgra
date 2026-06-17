package Vista.GUI.RegistrosVentas;

import Controlador.ControladorGato;
import Modelo.Gato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentaGato extends WindowAdapter implements ActionListener{

    //Componentes de la vista
    Frame f;
    TextArea txtAreaVentas;
    TextField txtBuscar;
    Button btnVender, btnBuscar;

    // Conexion con el ControladorGato seleccionado
    private ControladorGato controladorGato;
    private Gato gatoEncontrado;


    public VentaGato(){
        //ControladorGato
        this.controladorGato = new ControladorGato();

        // Configuración básica de la ventana
        f = new Frame("Ventas +Kota - Vender Gatos");
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
        txtAreaVentas.setText("Aqui se muestra el gatito.");

        Font fuenteEtiqueta = new Font("Arial", Font.BOLD, 14);
        Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);

        Panel panelBuscar = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelBuscar.setBackground(Color.LIGHT_GRAY);

        panelBuscar.add(crearLabel("Ingresa el nombre del gatito:", fuenteEtiqueta));
        txtBuscar = crearTextField(fuenteTexto);
        panelBuscar.add(txtBuscar);

        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(fuenteEtiqueta);
        btnBuscar.addActionListener(this);
        panelBuscar.add(btnBuscar);


        btnVender = new Button("Confirmar venta");
        btnVender.setFont(fuenteEtiqueta);
        btnVender.setEnabled(false); //Se muestra cuando se busca un gato
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
           if (gatoEncontrado != null) {
               controladorGato.venderGatos(gatoEncontrado);
               JOptionPane.showMessageDialog(f, "¡Gato vendido con éxito!", "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);
               txtAreaVentas.setText("Aqui se muestra el gatito.");
               txtBuscar.setText("");
               btnVender.setEnabled(false);
               gatoEncontrado = null;
           }
        }

        if (e.getSource() == btnBuscar) {
            String busqueda = txtBuscar.getText().trim();

            if (busqueda.isEmpty()) {
                txtAreaVentas.setText("Ingresa el nombre del gatito");
                btnVender.setEnabled(false);
                gatoEncontrado = null;
                return;
            }

            // Buscar el gato en el stock
            Gato foundGato = null;
            for (Gato g : controladorGato.consultarGatos()) {
                if (g.getNombre().equalsIgnoreCase(busqueda)) {
                    foundGato = g;
                    break;
                }
            }
            gatoEncontrado = foundGato;

            if (gatoEncontrado != null) {
                txtAreaVentas.setText("¡GATITO ENCONTRADO!\n");
                txtAreaVentas.append("Nombre: " + gatoEncontrado.getNombre() + "\n");
                txtAreaVentas.append("Edad: " + gatoEncontrado.getEdad() + "\n");
                txtAreaVentas.append("Color: " + gatoEncontrado.getColor() + "\n");
                txtAreaVentas.append("Raza: " + gatoEncontrado.getRaza()+ "\n");
                txtAreaVentas.append("Tamaño: " + gatoEncontrado.getTamanio()+ "\n");
                txtAreaVentas.append("Peso: " + gatoEncontrado.getPeso()+ "\n");
                txtAreaVentas.append("Precio: " + gatoEncontrado.getPrecio()+ "\n");

                String sexoMascota;
                if(gatoEncontrado.getSexo()){
                    sexoMascota = "Macho";
                }else{
                    sexoMascota = "Hembra";
                }
                txtAreaVentas.append("Sexo: " + sexoMascota+ "\n");
                txtAreaVentas.append("Alimentacion: " + gatoEncontrado.getAlimentacion()+ "\n");

                String colorOjosGato = "";
                switch(gatoEncontrado.getColorOjos()){
                    case 1: colorOjosGato = "Azules"; break;
                    case 2: colorOjosGato = "Verdes"; break;
                    case 3: colorOjosGato = "Negros"; break;
                    case 4: colorOjosGato = "Cafe"; break;
                    case 5: colorOjosGato = "Grises"; break;
                    default: colorOjosGato = "Desconocido"; break;
                }
                txtAreaVentas.append("Color de ojos: " + colorOjosGato + "\n");


                txtAreaVentas.append("Presione el botón 'Confirmar Venta' para realizar la operación. \n");
                btnVender.setEnabled(true); //Se muestra el boton para confirmar venta
            } else {
                txtAreaVentas.setText("No se encontró ningún gatito con el nombre: '" + busqueda + "' en el stock disponible.");
                btnVender.setEnabled(false);
                gatoEncontrado = null;
            }

        }
    }
}