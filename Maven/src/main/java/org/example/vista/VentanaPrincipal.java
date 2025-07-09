package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JButton botonRegistrar;
    private JButton botonLista;
    private JButton botonCerrar;

    public VentanaPrincipal() {
        setTitle("Gestión de Personas");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 10, 10));

        botonRegistrar = new JButton("Registrar Persona");
        botonLista = new JButton("Mirar Lista");
        botonCerrar = new JButton("Cerrar");

        add(botonRegistrar);
        add(botonLista);
        add(botonCerrar);

        // Acción: Abrir ventana de registro
        botonRegistrar.addActionListener(e -> new VentanaRegistrarPersona());

        // Acción: Abrir ventana de lista
        botonLista.addActionListener(e -> new VentanaConsultarPersonas());

        // Acción: Cerrar aplicación
        botonCerrar.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}
