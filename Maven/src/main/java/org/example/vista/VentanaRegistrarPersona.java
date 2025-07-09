package org.example.vista;

import org.example.dao.PersonaDAO;
import org.example.modelo.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistrarPersona extends JFrame {

    private JTextField campoNombre;
    private JTextField campoAltura;
    private JTextField campoPeso;
    private JTextField campoTez;
    private JButton botonRegistrar;

    public VentanaRegistrarPersona() {
        setTitle("Registrar Persona");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        // Componentes
        panel.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        panel.add(campoNombre);

        panel.add(new JLabel("Altura:"));
        campoAltura = new JTextField();
        panel.add(campoAltura);

        panel.add(new JLabel("Peso:"));
        campoPeso = new JTextField();
        panel.add(campoPeso);

        panel.add(new JLabel("Tez:"));
        campoTez = new JTextField();
        panel.add(campoTez);

        botonRegistrar = new JButton("Registrar");
        panel.add(botonRegistrar);

        // Espacio en blanco
        panel.add(new JLabel());

        add(panel);

        // Acción del botón
        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPersona();
            }
        });

        setVisible(true);
    }

    private void registrarPersona() {
        try {
            String nombre = campoNombre.getText();
            double altura = Double.parseDouble(campoAltura.getText());
            double peso = Double.parseDouble(campoPeso.getText());
            String tez = campoTez.getText();

            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setAltura(altura);
            persona.setPeso(peso);
            persona.setTez(tez);

            PersonaDAO dao = new PersonaDAO();
            dao.guardarPersona(persona);

            JOptionPane.showMessageDialog(this, "✅ Persona registrada con éxito.");

            // Limpiar campos
            campoNombre.setText("");
            campoAltura.setText("");
            campoPeso.setText("");
            campoTez.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Error al registrar: " + ex.getMessage());
        }
    }
}
