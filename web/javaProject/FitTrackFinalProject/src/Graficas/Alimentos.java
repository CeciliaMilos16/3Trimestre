package Graficas;

import javax.swing.*;

import Objetos.AlimentoConsumido;

import java.awt.*;
import java.util.ArrayList;

public class Alimentos extends JPanel {
    public static ArrayList<AlimentoConsumido> historialAlimentos = new ArrayList<>();
    private static final long serialVersionUID = 1L;

    private JPanel panelCambiante;
    private CardLayout cardLayout;

    public Alimentos(JFrame mainFrame) {
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnRegistrar = new JButton("Registrar Alimentos");
        JButton btnAgregar = new JButton("Agregar Alimentos");
        JButton btnHistorial = new JButton("Historial Consumo");
        JButton btnAtras = new JButton("Atrás");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnHistorial);
        panelBotones.add(btnAtras);

        add(panelBotones, BorderLayout.NORTH);

        // Panel central con CardLayout
        cardLayout = new CardLayout();
        panelCambiante = new JPanel(cardLayout);

        JPanel panelRegistrar = crearPanelRegistrar();
        JPanel panelAgregar = crearPanelAgregar();
        JPanel panelHistorial = crearPanelHistorial();

        panelCambiante.add(panelRegistrar, "Registrar");
        panelCambiante.add(panelAgregar, "Agregar");
        panelCambiante.add(panelHistorial, "Historial");

        add(panelCambiante, BorderLayout.CENTER);

        // Acciones botones
        btnRegistrar.addActionListener(e -> cardLayout.show(panelCambiante, "Registrar"));
        btnAgregar.addActionListener(e -> cardLayout.show(panelCambiante, "Agregar"));
        btnHistorial.addActionListener(e -> cardLayout.show(panelCambiante, "Historial"));
        btnAtras.addActionListener(e -> {
            mainFrame.setContentPane(new MenuPrincipal().getContentPane());
            mainFrame.revalidate();
            mainFrame.repaint();
        });

        cardLayout.show(panelCambiante, "Registrar");
    }

    private JPanel crearPanelRegistrar() {
        JPanel panelRegistrarAlimentos = new JPanel();
        panelRegistrarAlimentos.setLayout(null);
        panelRegistrarAlimentos.setPreferredSize(new Dimension(577, 364));

        String[] tipos = {"Carbohidratos", "Proteínas", "Grasas"};
        JComboBox<String> comboTipos = new JComboBox<>(tipos);
        comboTipos.setBounds(0, 0, 106, 19);
        panelRegistrarAlimentos.add(comboTipos);

        JPanel panelFormularios = new JPanel(new CardLayout());
        panelFormularios.setBounds(0, 19, 577, 345);

        // Carbohidratos
        JPanel panelCarbohidratos = new JPanel();
        panelCarbohidratos.setLayout(null);
        JLabel label = new JLabel("Nombre:");
        label.setBounds(31, 7, 67, 25);
        panelCarbohidratos.add(label);
        JTextField textField = new JTextField();
        textField.setBounds(84, 10, 172, 19);
        panelCarbohidratos.add(textField);

        JLabel label_1 = new JLabel("Calorías:");
        label_1.setBounds(31, 42, 57, 19);
        panelCarbohidratos.add(label_1);
        JTextField textField_1 = new JTextField();
        textField_1.setBounds(84, 42, 146, 19);
        panelCarbohidratos.add(textField_1);

        JLabel label_2 = new JLabel("Cantidad:");
        label_2.setBounds(31, 80, 67, 19);
        panelCarbohidratos.add(label_2);
        JTextField textField_2 = new JTextField();
        textField_2.setBounds(84, 76, 91, 27);
        panelCarbohidratos.add(textField_2);

        JLabel label_4 = new JLabel("Azúcares (g):");
        label_4.setBounds(31, 109, 67, 25);
        panelCarbohidratos.add(label_4);
        JTextField textField_4 = new JTextField();
        textField_4.setBounds(94, 113, 132, 35);
        panelCarbohidratos.add(textField_4);

        JLabel label_5 = new JLabel("Fibras (g):");
        label_5.setBounds(31, 152, 57, 25);
        panelCarbohidratos.add(label_5);
        JTextField textField_5 = new JTextField();
        textField_5.setBounds(84, 158, 116, 25);
        panelCarbohidratos.add(textField_5);

        JLabel label_6 = new JLabel("");
        label_6.setBounds(0, 212, 225, 35);
        panelCarbohidratos.add(label_6);
        JButton button = new JButton("Agregar");
        button.setBounds(55, 193, 225, 35);
        panelCarbohidratos.add(button);

        // Proteínas
        JPanel panelProteinas = new JPanel();
        panelProteinas.setLayout(null);
        JLabel label_3 = new JLabel("Nombre:");
        label_3.setBounds(70, 20, 96, 19);
        panelProteinas.add(label_3);
        JTextField textField_3 = new JTextField();
        textField_3.setBounds(126, 17, 128, 25);
        panelProteinas.add(textField_3);

        JLabel label_7 = new JLabel("Calorías:");
        label_7.setBounds(64, 77, 87, 19);
        panelProteinas.add(label_7);
        JTextField textField_6 = new JTextField();
        textField_6.setBounds(126, 74, 128, 22);
        panelProteinas.add(textField_6);

        JLabel label_8 = new JLabel("Cantidad:");
        label_8.setBounds(78, 131, 73, 25);
        panelProteinas.add(label_8);
        JTextField textField_7 = new JTextField();
        textField_7.setBounds(126, 131, 128, 25);
        panelProteinas.add(textField_7);

        JLabel label_10 = new JLabel("Aminoácidos:");
        label_10.setBounds(64, 171, 87, 25);
        panelProteinas.add(label_10);
        JTextField textField_9 = new JTextField();
        textField_9.setBounds(136, 171, 142, 25);
        panelProteinas.add(textField_9);

        JLabel label_11 = new JLabel("");
        label_11.setBounds(0, 286, 288, 57);
        panelProteinas.add(label_11);
        JButton button_1 = new JButton("Agregar");
        button_1.setBounds(208, 216, 128, 33);
        panelProteinas.add(button_1);

        // Grasas
        JPanel panelGrasas = new JPanel();
        panelGrasas.setLayout(null);
        JLabel label_12 = new JLabel("Nombre:");
        label_12.setBounds(54, 11, 85, 21);
        panelGrasas.add(label_12);
        JTextField textField_10 = new JTextField();
        textField_10.setBounds(103, 11, 116, 21);
        panelGrasas.add(textField_10);

        JLabel label_13 = new JLabel("Calorías:");
        label_13.setBounds(247, 11, 73, 21);
        panelGrasas.add(label_13);
        JTextField textField_11 = new JTextField();
        textField_11.setBounds(298, 11, 97, 21);
        panelGrasas.add(textField_11);

        JLabel label_14 = new JLabel("Cantidad:");
        label_14.setBounds(39, 58, 85, 21);
        panelGrasas.add(label_14);
        JTextField textField_12 = new JTextField();
        textField_12.setBounds(103, 52, 116, 33);
        panelGrasas.add(textField_12);

        JLabel label_16 = new JLabel("Saturadas (g):");
        label_16.setBounds(39, 104, 85, 33);
        panelGrasas.add(label_16);
        JTextField textField_14 = new JTextField();
        textField_14.setBounds(113, 104, 130, 33);
        panelGrasas.add(textField_14);

        JLabel label_17 = new JLabel("Insaturadas (g):");
        label_17.setBounds(39, 147, 97, 21);
        panelGrasas.add(label_17);
        JTextField textField_15 = new JTextField();
        textField_15.setBounds(123, 147, 116, 33);
        panelGrasas.add(textField_15);

        JLabel label_18 = new JLabel("Trans (g):");
        label_18.setBounds(35, 191, 73, 33);
        panelGrasas.add(label_18);
        JTextField textField_16 = new JTextField();
        textField_16.setBounds(90, 191, 116, 33);
        panelGrasas.add(textField_16);

        JLabel label_19 = new JLabel("");
        label_19.setBounds(0, 301, 288, 43);
        panelGrasas.add(label_19);
        JButton button_2 = new JButton("Agregar");
        button_2.setBounds(158, 257, 130, 34);
        panelGrasas.add(button_2);

        // Agregar formularios al panelFormularios
        panelFormularios.add(panelCarbohidratos, "Carbohidratos");
        panelFormularios.add(panelProteinas, "Proteínas");
        panelFormularios.add(panelGrasas, "Grasas");

        panelRegistrarAlimentos.add(panelFormularios);

        // Cambiar formulario según selección
        comboTipos.addActionListener(e -> {
            CardLayout cl = (CardLayout) panelFormularios.getLayout();
            cl.show(panelFormularios, (String) comboTipos.getSelectedItem());
        });

        // Agregar funcionalidad a los botones de agregar en cada formulario
        button.addActionListener(e -> {
            try {
                String nombre = textField.getText().trim();
                double calorias = Double.parseDouble(textField_1.getText().trim());
                double cantidad = Double.parseDouble(textField_2.getText().trim());
                double azucares = Double.parseDouble(textField_4.getText().trim());
                double fibras = Double.parseDouble(textField_5.getText().trim());

                if(nombre.isEmpty()) {
                    label_6.setText("El nombre no puede estar vacío.");
                    return;
                }

                // Crear objeto AlimentoConsumido para carbohidratos
                AlimentoConsumido alimento = new AlimentoConsumido(nombre, "Carbohidratos", calorias, cantidad, azucares, fibras);
                historialAlimentos.add(alimento);

                label_6.setText("Carbohidrato agregado correctamente.");
                limpiarCampos(textField, textField_1, textField_2, textField_4, textField_5);
            } catch (NumberFormatException ex) {
                label_6.setText("Por favor, ingresa valores numéricos válidos.");
            }
        });

        button_1.addActionListener(e -> {
            try {
                String nombre = textField_3.getText().trim();
                double calorias = Double.parseDouble(textField_6.getText().trim());
                double cantidad = Double.parseDouble(textField_7.getText().trim());
                String aminoacidos = textField_9.getText().trim();

                if(nombre.isEmpty()) {
                    label_11.setText("El nombre no puede estar vacío.");
                    return;
                }

                // Aquí puedes ajustar según la clase AlimentoConsumido para proteínas
                AlimentoConsumido alimento = new AlimentoConsumido(nombre, "Proteínas", calorias, cantidad, aminoacidos);
                historialAlimentos.add(alimento);

                label_11.setText("Proteína agregada correctamente.");
                limpiarCampos(textField_3, textField_6, textField_7, textField_9);
            } catch (NumberFormatException ex) {
                label_11.setText("Por favor, ingresa valores numéricos válidos.");
            }
        });

        button_2.addActionListener(e -> {
            try {
                String nombre = textField_10.getText().trim();
                double calorias = Double.parseDouble(textField_11.getText().trim());
                double cantidad = Double.parseDouble(textField_12.getText().trim());
                double saturadas = Double.parseDouble(textField_14.getText().trim());
                double insaturadas = Double.parseDouble(textField_15.getText().trim());
                double trans = Double.parseDouble(textField_16.getText().trim());

                if(nombre.isEmpty()) {
                    label_19.setText("El nombre no puede estar vacío.");
                    return;
                }

                // Crear objeto AlimentoConsumido para grasas
                AlimentoConsumido alimento = new AlimentoConsumido(nombre, "Grasas", calorias, cantidad, saturadas, insaturadas, trans);
                historialAlimentos.add(alimento);

                label_19.setText("Grasa agregada correctamente.");
                limpiarCampos(textField_10, textField_11, textField_12, textField_14, textField_15, textField_16);
            } catch (NumberFormatException ex) {
                label_19.setText("Por favor, ingresa valores numéricos válidos.");
            }
        });

        return panelRegistrarAlimentos;
    }

    private JPanel crearPanelAgregar() {
        JPanel panelAgregarAlimento = new JPanel();
        panelAgregarAlimento.setLayout(null);

        JLabel lblSeleccioneAlimento = new JLabel("Seleccione alimento consumido:");
        lblSeleccioneAlimento.setBounds(15, 14, 200, 20);
        panelAgregarAlimento.add(lblSeleccioneAlimento);

        // Lista de alimentos para registrar consumo
        DefaultListModel<String> modeloAlimentos = new DefaultListModel<>();
        for (AlimentoConsumido a : historialAlimentos) {
            modeloAlimentos.addElement(a.getNombre() + " (" + a.getTipo() + ")");
        }
        JList<String> listaAlimentos = new JList<>(modeloAlimentos);
        JScrollPane scrollPane = new JScrollPane(listaAlimentos);
        scrollPane.setBounds(15, 44, 275, 200);
        panelAgregarAlimento.add(scrollPane);

        JLabel lblCantidad = new JLabel("Cantidad consumida:");
        lblCantidad.setBounds(15, 255, 130, 20);
        panelAgregarAlimento.add(lblCantidad);

        JTextField textCantidad = new JTextField();
        textCantidad.setBounds(140, 252, 100, 26);
        panelAgregarAlimento.add(textCantidad);

        JButton btnAgregarConsumo = new JButton("Agregar consumo");
        btnAgregarConsumo.setBounds(314, 204, 225, 40);
        panelAgregarAlimento.add(btnAgregarConsumo);

        btnAgregarConsumo.addActionListener(e -> {
            int index = listaAlimentos.getSelectedIndex();
            if (index == -1) {
                return;
            }

            try {
                double cantidadConsumida = Double.parseDouble(textCantidad.getText().trim());
                if (cantidadConsumida <= 0) {
                    return;
                }

                AlimentoConsumido seleccionado = historialAlimentos.get(index);
                // Aquí deberías registrar el consumo. Por ejemplo:
                seleccionado.registrarConsumo(cantidadConsumida);
                textCantidad.setText("");
            } catch (NumberFormatException ex) {
            }
        });

        return panelAgregarAlimento;
    }

    private JPanel crearPanelHistorial() {
        JPanel panelHistoriaConsumo = new JPanel();
        panelHistoriaConsumo.setLayout(new BorderLayout());

        JTextArea textAreaHistorial = new JTextArea();
        textAreaHistorial.setEditable(false);

        StringBuilder sb = new StringBuilder();
        for (AlimentoConsumido a : historialAlimentos) {
            sb.append(a.toString()).append("\n");
        }
        textAreaHistorial.setText(sb.toString());

        JScrollPane scrollPane = new JScrollPane(textAreaHistorial);
        panelHistoriaConsumo.add(scrollPane, BorderLayout.CENTER);

        return panelHistoriaConsumo;
    }

    private void limpiarCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }
}