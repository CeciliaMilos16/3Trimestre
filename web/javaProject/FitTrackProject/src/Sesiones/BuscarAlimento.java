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

    public BuscarAlimento() {
        setTitle("Buscar Alimentos");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

     // Dentro del constructor BuscarAlimento()

        conexion = ConexionDB.getConnection();
        if (conexion == null) {
            JOptionPane.showMessageDialog(this, "No se pudo establecer la conexión con la base de datos.");
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

        if (textoBusqueda.isEmpty()) {
            return;
        }

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
                JTextField cantidad = new JTextField("100", 5); // cantidad en gramos

                JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT));
                fila.add(check);
                fila.add(new JLabel("Cantidad (g):"));
                fila.add(cantidad);

                resultadosPanel.add(fila);
            }

            JButton btnConfirmar = new JButton("Agregar seleccionados");
            btnConfirmar.addActionListener(e -> agregarSeleccionados());

            resultadosPanel.add(Box.createVerticalStrut(10)); // espacio
            resultadosPanel.add(btnConfirmar);
            resultadosPanel.revalidate();
            resultadosPanel.repaint();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage());
        }
    }

    private void agregarSeleccionados() {
        Component[] componentes = resultadosPanel.getComponents();
        ArrayList<String> alimentosSeleccionados = new ArrayList<>();

        for (Component comp : componentes) {
            if (comp instanceof JPanel) {
                JPanel fila = (JPanel) comp;
                Component[] hijos = fila.getComponents();

                if (hijos[0] instanceof JCheckBox && hijos[2] instanceof JTextField) {
                    JCheckBox check = (JCheckBox) hijos[0];
                    JTextField campoCantidad = (JTextField) hijos[2];

                    if (check.isSelected()) {
                        String nombre = check.getText();
                        String cantidad = campoCantidad.getText();
                        alimentosSeleccionados.add(nombre + " - " + cantidad + "g");
                    }
                }
            }
        }

        // Puedes cambiar esto para enviarlo a otro panel
        JOptionPane.showMessageDialog(this, "Agregados:\n" + String.join("\n", alimentosSeleccionados));
        dispose();
    }
}


