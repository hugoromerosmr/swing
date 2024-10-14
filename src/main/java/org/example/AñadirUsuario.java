package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class AñadirUsuario extends JFrame {
    private JLabel text;
    private JTextField textcorreo;
    private JTable table1;
    private JComboBox<String> combopais;
    private JComboBox<String> comboplataforma;
    private JButton buttonconfirmar;
    private JButton buttonvovolver;
    private JLabel correo;
    private JLabel pais;
    private JLabel plataforma;
    private JPanel Principal;
    private JScrollPane scroll;
    private DefaultTableModel modeloTabla;

    public AñadirUsuario() {
        setContentPane(Principal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Añadir Usuario");
        pack();
        setLocationRelativeTo(null);

        combopais.addItem("España");
        combopais.addItem("Paris");
        combopais.addItem("Florencia");
        combopais.addItem("Argentina");
        combopais.addItem("Malaysia");

        comboplataforma.addItem("Escritorio");
        comboplataforma.addItem("Movil");
        comboplataforma.addItem("Desconocido");

        String[] cabecera = {"Correo","Pais","Plataforma"};
        modeloTabla = new DefaultTableModel(cabecera,0);
        table1.setModel(modeloTabla);


        buttonconfirmar.addActionListener((ActionEvent e)->{
                String correoUsuario = textcorreo.getText();
                String paisSeleccionado = (String) combopais.getSelectedItem();
                String plataformaSeleccionada = (String) comboplataforma.getSelectedItem();

                if (correoUsuario.isEmpty() || correoUsuario.contains("ejemplo") || paisSeleccionado == null || paisSeleccionado.contains("Seleccione")
                        || plataformaSeleccionada == null || plataformaSeleccionada.contains("Seleccione")) {
                    JOptionPane.showMessageDialog(null, "Te falta algun campo por rellenar", "Falta de Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    Object[] fila = {correoUsuario, paisSeleccionado, plataformaSeleccionada};
                    modeloTabla.addRow(fila);
                    textcorreo.setText("");
                    combopais.setSelectedIndex(0);
                    comboplataforma.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Usuario almacenado correctamente.");
                }
        });

        buttonvovolver.addActionListener((ActionEvent e)->{
                dispose();
        });
    }

}




