package org.example.vista;

import org.example.dao.PersonaDAO;
import org.example.modelo.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaConsultarPersonas extends JFrame {

    private JTable tablaPersonas;
    private DefaultTableModel modeloTabla;
    private JButton botonActualizar;

    public VentanaConsultarPersonas() {
        setTitle("Lista de Personas");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Altura", "Peso", "Tez"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaPersonas = new JTable(modeloTabla);

        JScrollPane scroll = new JScrollPane(tablaPersonas);

        botonActualizar = new JButton("Actualizar lista");

        // Acción del botón
        botonActualizar.addActionListener(e -> cargarPersonas());

        // Layout
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(botonActualizar, BorderLayout.SOUTH);

        add(panel);

        // Carga inicial
        cargarPersonas();

        setVisible(true);
    }

    private void cargarPersonas() {
        modeloTabla.setRowCount(0); // Limpiar tabla

        PersonaDAO dao = new PersonaDAO();
        List<Persona> lista = dao.obtenerTodas();

        for (Persona p : lista) {
            Object[] fila = {
                    p.getId(),
                    p.getNombre(),
                    p.getAltura(),
                    p.getPeso(),
                    p.getTez()
            };
            modeloTabla.addRow(fila);
        }
    }
}
