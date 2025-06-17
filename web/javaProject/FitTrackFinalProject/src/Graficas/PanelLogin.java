package Graficas;

import javax.swing.*;
import BaseDeDatos.ConexionDB;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PanelLogin extends JPanel {

    public PanelLogin(CardLayout cardLayout, JPanel contentPane) {
        setLayout(null);
        setBounds(0, 0, 820, 700);

        // Fondo
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\fondo1.png"));
        fondo.setBounds(0, 0, 1018, 861);
        add(fondo);

        // Panel verde degradado
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(0, 70, 80),
                        0, getHeight(), new Color(50, 220, 230));
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            }
        };
        panel.setLayout(null);
        panel.setBounds(115, 99, 588, 438);
        add(panel);
        setComponentZOrder(panel, 0);

        // Logo
        JLabel lblLogo = new JLabel();
        lblLogo.setBounds(69, 120, 109, 115);
        panel.add(lblLogo);
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\logoGrande.png");
        Image img = originalIcon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(img));

        // Título
        JLabel lblTitulo = new JLabel("FIT-TRACK");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 31));
        lblTitulo.setBounds(49, 246, 150, 50);
        panel.add(lblTitulo);

        JLabel lblSubtitulo = new JLabel("Iniciar Sesión");
        lblSubtitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
        lblSubtitulo.setForeground(Color.WHITE);
        lblSubtitulo.setBounds(247, 51, 214, 50);
        panel.add(lblSubtitulo);

        // Correo
        JLabel lblCorreo = new JLabel("Correo Electrónico");
        lblCorreo.setForeground(Color.WHITE);
        lblCorreo.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
        lblCorreo.setBounds(247, 141, 223, 27);
        panel.add(lblCorreo);

        RoundedTextField txtCorreo = new RoundedTextField(30);
        txtCorreo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        txtCorreo.setBounds(247, 179, 309, 30);
        panel.add(txtCorreo);

        // Contraseña
        JLabel lblContrasena = new JLabel("Contraseña");
        lblContrasena.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
        lblContrasena.setForeground(Color.WHITE);
        lblContrasena.setBounds(247, 230, 109, 27);
        panel.add(lblContrasena);

        RoundedPasswordField txtContrasena = new RoundedPasswordField(30);
        txtContrasena.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        txtContrasena.setBounds(247, 268, 309, 30);
        panel.add(txtContrasena);

        // Botón de inicio
        RoundedButton btnComenzar = new RoundedButton("Comenzar", 30);
        btnComenzar.setBounds(345, 337, 134, 40);
        panel.add(btnComenzar);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(10, 10, 100, 30);
        btnVolver.addActionListener(e -> cardLayout.show(contentPane, "bienvenida"));
        panel.add(btnVolver);

        btnComenzar.addActionListener((ActionEvent e) -> {
            String correo = txtCorreo.getText();
            String contrasena = new String(txtContrasena.getPassword());

            if (correo.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                return;
            }

            try (Connection conn = ConexionDB.getConnection()) {
                String sql = "SELECT * FROM usuario WHERE CORREO = ? AND CONTRASEÑA = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, correo);
                stmt.setString(2, contrasena);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");

                    JPanel panelPrincipal = new PanelDeUsuario(cardLayout, contentPane);
                    contentPane.add(panelPrincipal, "principal");
                    cardLayout.show(contentPane, "principal");

                } else {
                    JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos");
                }

                rs.close();
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            }
        });

        // Agregar el fondo al final para que esté al fondo
        setComponentZOrder(fondo, getComponentCount() - 1);
    }
}



