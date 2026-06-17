package Vista.GUI;

import Vista.GUI.RegistrosStock.*;
import Vista.GUI.RegistrosVentas.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VenderAnimal extends WindowAdapter implements ActionListener {

    Frame f = new Frame("Vender un Animal");
    Label label;
    Button btnPerro, btnGato, btnPez, btnArania, btnSerpiente;

    public VenderAnimal() {
        f.setLayout(null);
        f.setSize(600,600);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
        f.addWindowListener(this);

        label = new Label("Vender un Animal: Seleccione una opcion");
        label.setBackground(Color.darkGray);
        label.setForeground(Color.white);
        label.setBounds(50, 50, 500, 30);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setAlignment(Label.CENTER);

        btnPerro = new Button("Perro");
        btnPerro.setBounds(50, 150, 200, 30);
        btnPerro.setFont(new Font("Arial", Font.BOLD, 20));
        btnPerro.addActionListener(this);

        btnGato = new Button("Gato");
        btnGato.setBounds(50, 200, 200, 30);
        btnGato.setFont(new Font("Arial", Font.BOLD, 20));
        btnGato.addActionListener(this);

        btnPez = new Button("Pez");
        btnPez.setBounds(50, 250, 200, 30);
        btnPez.setFont(new Font("Arial", Font.BOLD, 20));
        btnPez.addActionListener(this);

        btnArania = new Button("Araña");
        btnArania.setBounds(50, 300, 200, 30);
        btnArania.setFont(new Font("Arial", Font.BOLD, 20));
        btnArania.addActionListener(this);

        btnSerpiente = new Button("Serpiente");
        btnSerpiente.setBounds(50, 350, 200, 30);
        btnSerpiente.setFont(new Font("Arial", Font.BOLD, 20));
        btnSerpiente.addActionListener(this);

        f.add(label);
        f.add(btnPerro);
        f.add(btnGato);
        f.add(btnPez);
        f.add(btnArania);
        f.add(btnSerpiente);
    }

    public void windowClosing(WindowEvent e){
        f.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPerro) {
            new VentaPerro();
        }
        if (e.getSource() == btnGato) {
            new VentaGato();
        }

        if (e.getSource() == btnPez) {
            new VentaPez();
        }

        if (e.getSource() == btnArania) {
            new VentaArania();
        }

        if (e.getSource() == btnSerpiente) {
            new VentaSerpiente();
        }
    }
}
