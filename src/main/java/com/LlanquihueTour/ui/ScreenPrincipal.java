package com.LlanquihueTour.ui;

import com.LlanquihueTour.data.GestorEntidades;
import com.LlanquihueTour.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenPrincipal extends JFrame {

    private static GestorEntidades gestor = new GestorEntidades();
    private JTextArea areaTexto;

    public ScreenPrincipal() {
        // ESTE TROZO ES PARA CONFIGURAR PANTALLA
        setTitle("LLANQUIHUE TOUR - Sistema de Gestion");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Panel superior o nombre de ventana
        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("LLANQUIHUE TOUR - Sistema de Gestion");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelTitulo.add(titulo);
        add(panelTitulo, BorderLayout.NORTH);

        // panel de los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Opciones"));

        JButton btnAgregarGuia = new JButton("Agregar Guia");
        JButton btnAgregarVehiculo = new JButton("Agregar Vehiculo");
        JButton btnAgregarColaborador = new JButton("Agregar Colaborador");
        JButton btnMostrarTodos = new JButton("Mostrar Todos");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnSalir = new JButton("Salir");


        //AÑADO LOS BOTONES CON ADD
        panelBotones.add(btnAgregarGuia);
        panelBotones.add(btnAgregarVehiculo);
        panelBotones.add(btnAgregarColaborador);
        panelBotones.add(btnMostrarTodos);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.CENTER);

        // PARTE DE ABAJO Panel
        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new BorderLayout());
        panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 13));


        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setPreferredSize(new Dimension(780, 350));
        panelResultados.add(scrollPane, BorderLayout.CENTER);

        add(panelResultados, BorderLayout.SOUTH);

        // Acciones de los botones
        btnAgregarGuia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarGuia();
            }
        });

        btnAgregarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVehiculo();
            }
        });

        btnAgregarColaborador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarColaborador();
            }
        });

        btnMostrarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodos();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText("Listo para operar...\n");
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                        ScreenPrincipal.this,
                        "Esta seguro de que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (opcion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        gestor.agregarEntidad(new GuiaTuristico("Pedro Munoz", "Montana", 8));
        gestor.agregarEntidad(new GuiaTuristico("Laura Vidal", "Gastronomia", 5));
        gestor.agregarEntidad(new Vehiculo("ABCD12", "Van", 12));
        gestor.agregarEntidad(new Vehiculo("EFGH34", "Bus", 30));
        gestor.agregarEntidad(new ColaboradorExterno("Restaurante El Patagonico", "Alimentacion", "+56912345678"));
        gestor.agregarEntidad(new ColaboradorExterno("Museo Colonial", "Cultura", "+56987654321"));
    }

    private void agregarGuia() {
        JTextField txtNombre = new JTextField();
        JTextField txtEspecialidad = new JTextField();
        JTextField txtYears = new JTextField();

        Object[] campos = {
                "Nombre del guia:", txtNombre,
                "Especialidad:", txtEspecialidad,
                "Años de experiencia:", txtYears
        };

        int opcion = JOptionPane.showConfirmDialog(
                this, campos, "Agregar Guia Turistico",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcion == JOptionPane.OK_OPTION) {
            String nombre = txtNombre.getText().trim();
            String especialidad = txtEspecialidad.getText().trim();
            String yearsStr = txtYears.getText().trim();

            if (nombre.isEmpty() || especialidad.isEmpty() || yearsStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int years = Integer.parseInt(yearsStr);
                GuiaTuristico guia = new GuiaTuristico(nombre, especialidad, years);
                gestor.agregarEntidad(guia);
                areaTexto.append("Guia agregado: " + nombre + " (" + especialidad + ")\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Los anios deben ser un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void agregarVehiculo() {
        JTextField txtPatente = new JTextField();
        JTextField txtTipo = new JTextField();
        JTextField txtCapacidad = new JTextField();

        Object[] campos = {
                "Patente:", txtPatente,
                "Tipo (Van, Bus, Auto):", txtTipo,
                "Capacidad:", txtCapacidad
        };

        int opcion = JOptionPane.showConfirmDialog(
                this, campos, "Agregar Vehiculo",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcion == JOptionPane.OK_OPTION) {
            String patente = txtPatente.getText().trim().toUpperCase();
            String tipo = txtTipo.getText().trim();
            String capacidadStr = txtCapacidad.getText().trim();

            if (patente.isEmpty() || tipo.isEmpty() || capacidadStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int capacidad = Integer.parseInt(capacidadStr);
                Vehiculo vehiculo = new Vehiculo(patente, tipo, capacidad);
                gestor.agregarEntidad(vehiculo);
                areaTexto.append("Vehiculo agregado: " + patente + " (" + tipo + ")\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La capacidad debe ser un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void agregarColaborador() {
        JTextField txtNombre = new JTextField();
        JTextField txtServicio = new JTextField();
        JTextField txtTelefono = new JTextField();

        Object[] campos = {
                "Nombre/empresa:", txtNombre,
                "Tipo de servicio:", txtServicio,
                "Telefono:", txtTelefono
        };

        int opcion = JOptionPane.showConfirmDialog(
                this, campos, "Agregar Colaborador Externo",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcion == JOptionPane.OK_OPTION) {
            String nombre = txtNombre.getText().trim();
            String servicio = txtServicio.getText().trim();
            String telefono = txtTelefono.getText().trim();

            if (nombre.isEmpty() || servicio.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ColaboradorExterno colaborador = new ColaboradorExterno(nombre, servicio, telefono);
            gestor.agregarEntidad(colaborador);
            areaTexto.append("Colaborador agregado: " + nombre + " (" + servicio + ")\n");
        }
    }

    private void mostrarTodos() {
        if (gestor.getEntidades().isEmpty()) {
            areaTexto.setText("No hay entidades registradas.\n");
            return;
        }

        StringBuilder resumen = new StringBuilder();
        resumen.append("=== ENTIDADES REGISTRADAS ===\n\n");

        for (Registrable entidad : gestor.getEntidades()) {
            if (entidad instanceof GuiaTuristico) {
                GuiaTuristico g = (GuiaTuristico) entidad;
                resumen.append("GUIA TURISTICO\n");
                resumen.append("  Nombre: ").append(g.getNombre()).append("\n");
                resumen.append("  Especialidad: ").append(g.getEspecialidad()).append("\n");
                resumen.append("  Experiencia: ").append(g.getYearsExperiencia()).append(" años\n\n");
            } else if (entidad instanceof Vehiculo) {
                Vehiculo v = (Vehiculo) entidad;
                resumen.append("VEHICULO\n");
                resumen.append("  Patente: ").append(v.getPatente()).append("\n");
                resumen.append("  Tipo: ").append(v.getTipo()).append("\n");
                resumen.append("  Capacidad: ").append(v.getCapacidad()).append(" pasajeros\n\n");
            } else if (entidad instanceof ColaboradorExterno) {
                ColaboradorExterno c = (ColaboradorExterno) entidad;
                resumen.append("COLABORADOR EXTERNO\n");
                resumen.append("  Nombre: ").append(c.getNombre()).append("\n");
                resumen.append("  Servicio: ").append(c.getServicio()).append("\n");
                resumen.append("  Telefono: ").append(c.getTelefono()).append("\n\n");
            }
            resumen.append("----------------------------------------\n");
        }
        areaTexto.setText(resumen.toString());
    }

}