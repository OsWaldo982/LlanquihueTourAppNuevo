package com.LlanquihueTour.ui;

import com.LlanquihueTour.data.GestorEntidades;
import com.LlanquihueTour.data.GestorReservas;
import com.LlanquihueTour.data.GestorServicios;
import com.LlanquihueTour.exception.DatoInvalidoException;
import com.LlanquihueTour.model.ColaboradorExterno;
import com.LlanquihueTour.model.GuiaTuristico;
import com.LlanquihueTour.model.Registrable;
import com.LlanquihueTour.model.ReservaTuristica;
import com.LlanquihueTour.model.ServicioTuristico;
import com.LlanquihueTour.model.Vehiculo;
import com.LlanquihueTour.service.ControladorDeTurismo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Ventana principal que comunica al usuario con los gestores del sistema.
 */
public class ScreenPrincipal extends JFrame {

    private final GestorEntidades gestor;
    private final GestorReservas gestorReservas;
    private final ArrayList<ServicioTuristico> servicios;
    private final ControladorDeTurismo controlador;
    private JTextArea areaTexto;

    public ScreenPrincipal() {
        gestor = new GestorEntidades();
        gestorReservas = new GestorReservas();
        servicios = new GestorServicios().generarTuristicos();
        controlador = new ControladorDeTurismo();

        // ESTE TROZO ES PARA CONFIGURAR PANTALLA
        setTitle("LLANQUIHUE TOUR - Sistema de Gestion");
        setSize(920, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        // Panel superior o nombre de ventana
        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("LLANQUIHUE TOUR - Sistema de Gestion");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelTitulo.add(titulo);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel de los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(0, 4, 8, 8));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Opciones"));

        JButton btnAgregarGuia = new JButton("Agregar Guia");
        JButton btnAgregarVehiculo = new JButton("Agregar Vehiculo");
        JButton btnAgregarColaborador = new JButton("Agregar Colaborador");
        JButton btnMostrarTodos = new JButton("Mostrar Entidades");
        JButton btnMostrarServicios = new JButton("Mostrar Servicios");
        JButton btnBuscar = new JButton("Buscar Entidad");
        JButton btnEliminar = new JButton("Eliminar Entidad");
        JButton btnCrearReserva = new JButton("Crear Reserva");
        JButton btnMostrarReservas = new JButton("Mostrar Reservas");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnSalir = new JButton("Salir");

        // AÑADO LOS BOTONES CON ADD
        panelBotones.add(btnAgregarGuia);
        panelBotones.add(btnAgregarVehiculo);
        panelBotones.add(btnAgregarColaborador);
        panelBotones.add(btnMostrarTodos);
        panelBotones.add(btnMostrarServicios);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCrearReserva);
        panelBotones.add(btnMostrarReservas);
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
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setPreferredSize(new Dimension(890, 350));
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

        btnMostrarServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarServicios();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEntidad();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEntidad();
            }
        });

        btnCrearReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearReserva();
            }
        });

        btnMostrarReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarReservas();
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
                        "¿Esta seguro de que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (opcion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        mostrarInicio();
    }

    private void mostrarInicio() {
        areaTexto.setText("Datos cargados correctamente desde archivos TXT.\n");
        areaTexto.append("Entidades disponibles: " + gestor.getEntidades().size() + "\n");
        areaTexto.append("Servicios disponibles: " + servicios.size() + "\n");
        areaTexto.append("Seleccione una opcion para comenzar.\n");
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
            try {
                int years = Integer.parseInt(txtYears.getText().trim());
                GuiaTuristico guia = new GuiaTuristico(
                        txtNombre.getText(), txtEspecialidad.getText(), years);
                gestor.agregarEntidad(guia);
                areaTexto.append("Guia agregado: " + guia + "\n");
            } catch (NumberFormatException ex) {
                mostrarError("Los años deben ser un numero valido.");
            } catch (DatoInvalidoException ex) {
                mostrarError(ex.getMessage());
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
            try {
                int capacidad = Integer.parseInt(txtCapacidad.getText().trim());
                Vehiculo vehiculo = new Vehiculo(
                        txtPatente.getText(), txtTipo.getText(), capacidad);
                gestor.agregarEntidad(vehiculo);
                areaTexto.append("Vehiculo agregado: " + vehiculo + "\n");
            } catch (NumberFormatException ex) {
                mostrarError("La capacidad debe ser un numero valido.");
            } catch (DatoInvalidoException ex) {
                mostrarError(ex.getMessage());
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
            try {
                ColaboradorExterno colaborador = new ColaboradorExterno(
                        txtNombre.getText(), txtServicio.getText(), txtTelefono.getText());
                gestor.agregarEntidad(colaborador);
                areaTexto.append("Colaborador agregado: " + colaborador + "\n");
            } catch (DatoInvalidoException ex) {
                mostrarError(ex.getMessage());
            }
        }
    }

    private void mostrarTodos() {
        mostrarListaEntidades("=== ENTIDADES REGISTRADAS ===", gestor.getEntidades());
    }

    private void mostrarListaEntidades(String titulo, ArrayList<Registrable> entidades) {
        if (entidades.isEmpty()) {
            areaTexto.setText("No se encontraron entidades.\n");
            return;
        }

        StringBuilder resumen = new StringBuilder();
        resumen.append(titulo).append("\n\n");

        // La lista es polimorfica y se valida el tipo concreto con instanceof.
        for (Registrable entidad : entidades) {
            if (entidad instanceof GuiaTuristico) {
                resumen.append("[GUIA] ");
            } else if (entidad instanceof Vehiculo) {
                resumen.append("[VEHICULO] ");
            } else if (entidad instanceof ColaboradorExterno) {
                resumen.append("[COLABORADOR] ");
            }
            resumen.append(entidad).append("\n");
            resumen.append("----------------------------------------\n");
        }
        areaTexto.setText(resumen.toString());
    }

    private void mostrarServicios() {
        areaTexto.setText(controlador.obtenerResumenTuristicos(servicios));
    }

    private void buscarEntidad() {
        String criterio = JOptionPane.showInputDialog(
                this, "Ingrese nombre, patente, especialidad o servicio:", "Buscar entidad",
                JOptionPane.QUESTION_MESSAGE);

        if (criterio != null) {
            if (criterio.trim().isEmpty()) {
                mostrarError("Debe ingresar un criterio de busqueda.");
                return;
            }
            mostrarListaEntidades("=== RESULTADOS DE BUSQUEDA ===", gestor.buscarEntidades(criterio));
        }
    }

    private void eliminarEntidad() {
        String criterio = JOptionPane.showInputDialog(
                this, "Ingrese un nombre o patente para eliminar:", "Eliminar entidad",
                JOptionPane.WARNING_MESSAGE);

        if (criterio != null) {
            boolean eliminado = gestor.eliminarEntidad(criterio);
            if (eliminado) {
                areaTexto.setText("Entidad eliminada correctamente.\n");
                areaTexto.append("Entidades restantes: " + gestor.getEntidades().size() + "\n");
            } else {
                mostrarError("No se encontro una entidad con ese criterio.");
            }
        }
    }

    private void crearReserva() {
        ArrayList<Registrable> entidadesGuia = gestor.buscarEntidades(GuiaTuristico.class);
        if (servicios.isEmpty() || entidadesGuia.isEmpty()) {
            mostrarError("Se necesita al menos un servicio y un guia para crear una reserva.");
            return;
        }

        GuiaTuristico[] guias = new GuiaTuristico[entidadesGuia.size()];
        for (int i = 0; i < entidadesGuia.size(); i++) {
            guias[i] = (GuiaTuristico) entidadesGuia.get(i);
        }

        JTextField txtCliente = new JTextField();
        JComboBox<ServicioTuristico> comboServicios = new JComboBox<>(
                servicios.toArray(new ServicioTuristico[0]));
        JComboBox<GuiaTuristico> comboGuias = new JComboBox<>(guias);

        Object[] campos = {
                "Nombre del cliente:", txtCliente,
                "Servicio turistico:", comboServicios,
                "Guia responsable:", comboGuias
        };

        int opcion = JOptionPane.showConfirmDialog(
                this, campos, "Crear Reserva Turistica",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcion == JOptionPane.OK_OPTION) {
            try {
                ReservaTuristica reserva = gestorReservas.crearReserva(
                        txtCliente.getText(),
                        (ServicioTuristico) comboServicios.getSelectedItem(),
                        (GuiaTuristico) comboGuias.getSelectedItem());
                areaTexto.setText("Reserva creada correctamente:\n" + reserva + "\n");
            } catch (DatoInvalidoException ex) {
                mostrarError(ex.getMessage());
            }
        }
    }

    private void mostrarReservas() {
        ArrayList<ReservaTuristica> reservas = gestorReservas.getReservas();
        if (reservas.isEmpty()) {
            areaTexto.setText("No hay reservas creadas durante esta ejecucion.\n");
            return;
        }

        StringBuilder resumen = new StringBuilder("=== RESERVAS TURISTICAS ===\n\n");
        for (ReservaTuristica reserva : reservas) {
            resumen.append(reserva).append("\n");
            resumen.append("----------------------------------------\n");
        }
        areaTexto.setText(resumen.toString());
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
