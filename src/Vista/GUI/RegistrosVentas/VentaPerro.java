package Vista.GUI.RegistrosVentas;

import Controlador.ControladorPerro;
import Modelo.Perro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentaPerro extends WindowAdapter implements ActionListener{

    //Componentes de la vista
    Frame f;
    TextArea txtAreaVentas;
    TextField txtBuscar;
    Button btnVender, btnBuscar;

    // Conexion con el ControladorPerro seleccionado
    private ControladorPerro controladorPerro;
    private Perro perroEncontrado;


    public VentaPerro(){
        //ControladorPerro
        this.controladorPerro = new ControladorPerro();

        // Configuración básica de la ventana
        f = new Frame("Ventas +Kota - Vender Perros");
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
        txtAreaVentas.setText("Aqui se muestra el perrito.");

        Font fuenteEtiqueta = new Font("Arial", Font.BOLD, 14);
        Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);

        Panel panelBuscar = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelBuscar.setBackground(Color.LIGHT_GRAY);

        panelBuscar.add(crearLabel("Ingresa el nombre del perrito:", fuenteEtiqueta));
        txtBuscar = crearTextField(fuenteTexto);
        panelBuscar.add(txtBuscar);

        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(fuenteEtiqueta);
        btnBuscar.addActionListener(this);
        panelBuscar.add(btnBuscar);


        btnVender = new Button("Confirmar venta");
        btnVender.setFont(fuenteEtiqueta);
        btnVender.setEnabled(false); //Se muestra cuando se busca un perro
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
           if (perroEncontrado != null) {
               controladorPerro.venderPerro(perroEncontrado);
           }
        }

        if (e.getSource() == btnBuscar) {
            String busqueda = txtBuscar.getText().trim();

            if (busqueda.isEmpty()) {
                txtAreaVentas.setText("Ingresa el nombre del perrito");
                btnVender.setEnabled(false);
                perroEncontrado = null;
                return;
            }

            perroEncontrado = controladorPerro.buscarPerro(busqueda);

            if (perroEncontrado != null) {
                txtAreaVentas.setText("¡PERRITO ENCONTRADO!\n");
                txtAreaVentas.append("Nombre: " + perroEncontrado.getNombre() + "\n");
                txtAreaVentas.append("Edad: " + perroEncontrado.getEdad() + "\n");
                txtAreaVentas.append("Color: " + perroEncontrado.getColor() + "\n");
                txtAreaVentas.append("Raza: " + perroEncontrado.getRaza()+ "\n");
                txtAreaVentas.append("Tamaño: " + perroEncontrado.getTamanio()+ "\n");
                txtAreaVentas.append("Peso: " + perroEncontrado.getPeso()+ "\n");
                txtAreaVentas.append("Precio: " + perroEncontrado.getPrecio()+ "\n");

                String sexoMascota;
                if(perroEncontrado.getSexo()){
                    sexoMascota = "Macho";
                }else{
                    sexoMascota = "Hembra";
                }
                txtAreaVentas.append("Sexo: " + sexoMascota+ "\n");
                txtAreaVentas.append("Alimentacion: " + perroEncontrado.getAlimentacion()+ "\n");

                String perfilPerro = "";
                switch (perroEncontrado.getPerfil()) {
                    case 1: perfilPerro = "Semental"; break;
                    case 2: perfilPerro = "Mascota"; break;
                    case 3: perfilPerro = "Policia"; break;
                    case 4: perfilPerro = "Apoyo a invidentes"; break;
                }
                txtAreaVentas.append("Perfil: " + perfilPerro+ "\n");

                txtAreaVentas.append("Funcion: " );
                switch(perroEncontrado.getPerfil()) {
                    case 1:
                        System.out.println("¡GUAU, GUAU! \n");
                        break;
                    case 2:
                        System.out.println("El perrito esta dormido \n");
                        break;
                    case 3:
                        System.out.println("El perrito esta olfateando \n");
                        break;
                    case 4:
                        System.out.println("El perro esta sentado esperando \n");
                        break;
                }

                txtAreaVentas.append("Presione el botón 'Confirmar Venta' para realizar la operación. \n");
                btnVender.setEnabled(true); //Se muestra el boton para confirmar venta
            } else {
                txtAreaVentas.setText("No se encontró ningún perrito con el nombre: '" + busqueda + "' en el stock disponible.");
                btnVender.setEnabled(false);
                perroEncontrado = null;
            }

        }
    }
}
