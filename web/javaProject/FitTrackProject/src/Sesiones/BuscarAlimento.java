package Sesiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class BuscarAlimento extends JFrame {
    private JTextField campoBusqueda;
    private JPanel resultadosPanel;
    private Connection conexion;
    private PanelPrincipal panelPrincipal; // Referencia a la ventana principal

    public BuscarAlimento(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setTitle("Buscar Alimentos");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        conexion = ConexionDB.getConnection();
        if (conexion == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
            return;
        }

        JPanel panelBusqueda = new JPanel();
        campoBusqueda = new JTextField(30);
        JButton btnBuscar = new JButton("Buscar");

        btnBuscar.addActionListener(e -> buscarAlimentos());

        panelBusqueda.add(new JLabel("Buscar alimento:"));
        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(btnBuscar);
        add(panelBusqueda, BorderLayout.NORTH);

        resultadosPanel = new JPanel();
        resultadosPanel.setLayout(new BoxLayout(resultadosPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(resultadosPanel), BorderLayout.CENTER);
    }

    private void buscarAlimentos() {
        resultadosPanel.removeAll();

        String textoBusqueda = campoBusqueda.getText().trim();

        if (textoBusqueda.isEmpty()) return;

        try {
            String query = "SELECT * FROM alimentos WHERE NOMBRE_DEL_ALIMENTO LIKE ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, "%" + textoBusqueda + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_ALIMENTO");
                String nombre = rs.getString("NOMBRE_DEL_ALIMENTO");
                double calorias = rs.getDouble("CALORIAS");

                JCheckBox check = new JCheckBox(nombre + " (" + calorias + " cal)");
                JTextField cantidad = new JTextField("100", 5);

                JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT));
                fila.add(check);
                fila.add(new JLabel("Cantidad (g):"));
                fila.add(cantidad);

                resultadosPanel.add(fila);
            }

            JButton btnConfirmar = new JButton("Agregar seleccionados");
            btnConfirmar.addActionListener(e -> agregarSeleccionados());

            resultadosPanel.add(Box.createVerticalStrut(10));
            resultadosPanel.add(btnConfirmar);
            resultadosPanel.revalidate();
            resultadosPanel.repaint();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage());
        }
    }

    private void agregarSeleccionados() {
        Component[] componentes = resultadosPanel.getComponents();
        for (Component comp : componentes) {
            if (comp instanceof JPanel) {
                JPanel fila = (JPanel) comp;
                Component[] hijos = fila.getComponents();

                if (hijos.length >= 3 && hijos[0] instanceof JCheckBox && hijos[2] instanceof JTextField) {
                    JCheckBox check = (JCheckBox) hijos[0];
                    JTextField campoCantidad = (JTextField) hijos[2];

                    if (check.isSelected()) {
                        String nombre = check.getText();
                        try {
                            int cantidad = Integer.parseInt(campoCantidad.getText());
                            panelPrincipal.agregarAlimento(nombre, cantidad);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Cantidad inválida para: " + nombre);
                        }
                    }
                }
            }
        }

        dispose();
    }
}

