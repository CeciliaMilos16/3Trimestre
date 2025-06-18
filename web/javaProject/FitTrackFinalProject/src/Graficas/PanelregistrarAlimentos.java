package Graficas;

import javax.swing.*;
import java.awt.*;

public class PanelregistrarAlimentos extends JPanel {
    private static final long serialVersionUID = 1L;

    private CardLayout cardLayout;
    private JPanel panelCambiante;

    public PanelregistrarAlimentos(CardLayout cardLayout, JPanel contentPane) {
        setLayout(new BorderLayout());
        this.cardLayout = cardLayout;

        // Panel de botones arriba
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

        // Panel principal con CardLayout
        panelCambiante = new JPanel(new CardLayout());
        panelCambiante.add(crearPanelRegistrar(), "Registrar");
        panelCambiante.add(crearPanelAgregar(), "Agregar");
        panelCambiante.add(crearPanelHistorial(), "Historial");
        add(panelCambiante, BorderLayout.CENTER);

        // Acción de los botones
        btnRegistrar.addActionListener(e -> cambiarPanel("Registrar"));
        btnAgregar.addActionListener(e -> cambiarPanel("Agregar"));
        btnHistorial.addActionListener(e -> cambiarPanel("Historial"));
        btnAtras.addActionListener(e -> cardLayout.show(contentPane, "principal"));

        cambiarPanel("Registrar"); // Panel por defecto
    }

    private void cambiarPanel(String nombrePanel) {
        CardLayout cl = (CardLayout) panelCambiante.getLayout();
        cl.show(panelCambiante, nombrePanel);
    }

    private JPanel crearPanelRegistrar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Aquí irá el formulario para registrar alimentos", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label, BorderLayout.CENTER);

        // Más adelante aquí puedes insertar el mismo formulario que usó tu amiga:
        // nombre, calorías, cantidad, etc.
        // Y en lugar de guardar en ArrayList, harás INSERT en la base de datos.

        return panel;
    }

    private JPanel crearPanelAgregar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Aquí se podrán agregar alimentos consumidos", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label, BorderLayout.CENTER);

        // Más adelante aquí puedes cargar los alimentos desde tu base de datos
        // y permitir seleccionar uno y registrar la cantidad consumida.

        return panel;
    }

    private JPanel crearPanelHistorial() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("Aquí se mostrará el historial de alimentos consumidos\n(cargados desde tu base de datos)");

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        return panel;
    }
}
