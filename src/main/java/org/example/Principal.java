package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton confirmarYGuardarButton;
    private JButton volverAtrásButton;
    private JButton labelDeInformaciónButton;
    private JTable table1;

    private DefaultTableModel model;


    public Principal() {

        String[] cabecera = {"Correo", "País", "Plataforma"};
        model = new DefaultTableModel(cabecera, 0);
        table1.setModel(model);


        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Principal");
        this.setSize(600, 400);
        this.setResizable(false);

        setLocationRelativeTo(null);


        labelDeInformaciónButton.addActionListener((ActionEvent e) -> {

            int filaSeleccionada = table1.getSelectedRow();
            if (filaSeleccionada != -1) {

                String correo = (String) table1.getValueAt(filaSeleccionada, 0);
                String pais = (String) table1.getValueAt(filaSeleccionada, 1);
                String plataforma = (String) table1.getValueAt(filaSeleccionada, 2);


                JOptionPane.showMessageDialog(null,
                        "Correo: " + correo + "\nPaís: " + pais + "\nPlataforma: " + plataforma);
            } else {

                JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila.");
            }
        });

        confirmarYGuardarButton.addActionListener((ActionEvent e) -> {

            String correo = textField1.getText();
            String pais = textField2.getText();
            String plataforma = textField3.getText();

            if (!correo.isEmpty() && !pais.isEmpty() && !plataforma.isEmpty()) {
                Object[] fila = {correo, pais, plataforma};
                model.addRow(fila);

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.");
            }


        });
        volverAtrásButton.addActionListener((ActionEvent e) -> {

            dispose();

        });
    }
}
