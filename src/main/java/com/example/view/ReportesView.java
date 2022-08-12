package com.example.view;

import com.example.controller.*;
import com.example.model.vo.*;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;

public class ReportesView extends JFrame {

    public static final ReportesController controller = new ReportesController();

    // mitigar errores de instancia
    // private static final Long serialVersionUID = 1L;
    private JPanel contenPanel;
    private JTextArea textArea;

    public ReportesView() {

        panel();
    }

    public void panel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 570, 650);

        contenPanel = new JPanel();
        contenPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contenPanel);
        contenPanel.setLayout(null);

        JLabel lbTitulo = new JLabel("--RETO 5");
        lbTitulo.setBounds(28, 6, 61, 16);
        contenPanel.add(lbTitulo);

        // Dimensiones del contenido dentro de la ventana creada
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 500, 455);
        contenPanel.add(scrollPane);

        // Propocionar la vista que se desplaza
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        // Creamos los botones para cada informe
        JButton btninforme1 = new JButton("Informe 1");
        btninforme1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerInforme();
            }
        });
        btninforme1.setBounds(30, 37, 133, 29);
        contenPanel.add(btninforme1);

        JButton btninforme2 = new JButton("Informe 2");
        btninforme2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundoInforme();
            }
        });
        btninforme2.setBounds(210, 37, 133, 29);
        contenPanel.add(btninforme2);

        JButton btninforme3 = new JButton("Informe 3");
        btninforme3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tercerInforme();
            }
        });
        btninforme3.setBounds(390, 37, 133, 29);
        contenPanel.add(btninforme3);

        JButton btnlimpiar = new JButton("Limpiar");
        btnlimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnlimpiar.setBounds(390, 537, 133, 29);
        contenPanel.add(btnlimpiar);

    }

    public void primerInforme() {
        try {
            List<ListaLideresVo> lideres = controller.listarLideres();
            String salida = "***Nombres de Lideres por Ciudad de Residencia*** \n\n Lider \t Nombre \t Primer Apellido \t Residencia\n\n";

            for (ListaLideresVo i : lideres) {
                salida += i.getId() + " \t ";
                salida += i.getNombre() + " \t ";
                salida += i.getApellido() + "\t\t ";
                salida += i.getCiudad() + "\n ";

            }
            textArea.setText(salida);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void segundoInforme() {
        try {
            List<ProyectosVo> proyectos = controller.listarProyectos();
            String salida = "*** Proyectos Casa Campestre *** \n\n Id Proyecto \t Constructora \t\t Habitaciones \t Ciudad\n\n";

            for (ProyectosVo i : proyectos) {
                salida += i.getId() + " \t ";
                salida += i.getConstructora();
                if (i.getConstructora().length() <= 11) {
                    salida += "\t\t ";
                } else {
                    salida += "\t ";
                }
                salida += i.getHabitaciones() + " \t ";
                salida += i.getCiudad() + " \n ";
            }
            textArea.setText(salida);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tercerInforme() {
        try {
            List<ComprasPorProyectoVo> compras = controller.listarComprasProyectos();
            String salida = "*** Compras por Proveedor *** \n\n Id Compra \t Constructora \t\t Banco\n\n";

            for (ComprasPorProyectoVo i : compras) {
                salida += i.getId() + " \t ";
                salida += i.getConstructora();
                if (i.getConstructora().length() <= 11) {
                    salida += "\t\t ";
                } else {
                    salida += "\t ";
                }
                salida += i.getBancoVinculado() + " \n ";
            }
            textArea.setText(salida);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}