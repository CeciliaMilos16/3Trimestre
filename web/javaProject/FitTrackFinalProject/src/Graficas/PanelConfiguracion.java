package Graficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelConfiguracion extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelConfiguracion(CardLayout cardLayout, JPanel contentPane) {
        setLayout(null);
        setBounds(0, 0, 820, 700);

        // Fondo
        JLabel fondo = new JLabel(new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\fondo1.png"));
        fondo.setBounds(0, 0, 1018, 861);
        add(fondo);

        // Panel central con gradiente
        JPanel panelCentral = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(0, 70, 80),
                        0, getHeight(), new Color(50, 220, 230)
                );
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            }
        };
        panelCentral.setLayout(null);
        panelCentral.setBounds(160, 100, 500, 500);
        panelCentral.setOpaque(false);
        add(panelCentral);
        setComponentZOrder(panelCentral, 0);
        setComponentZOrder(fondo, 1);

        // Título
        JLabel lblTitulo = new JLabel("Configuración");
        lblTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(160, 30, 300, 40);
        panelCentral.add(lblTitulo);

        // Botón Cambiar Contraseña
        RoundedButton btnCambiarContrasena = new RoundedButton("Cambiar Contraseña", 25);
        btnCambiarContrasena.setBounds(150, 100, 200, 40);
        panelCentral.add(btnCambiarContrasena);

        // Botón Cambiar Idioma
        RoundedButton btnIdioma = new RoundedButton("Idioma: Español", 25);
        btnIdioma.setBounds(150, 160, 200, 40);
        panelCentral.add(btnIdioma);

        // Botón Cambiar Tema
        RoundedButton btnTema = new RoundedButton("Tema: Claro", 25);
        btnTema.setBounds(150, 220, 200, 40);
        panelCentral.add(btnTema);

        // Botón Notificaciones
        RoundedButton btnNotificaciones = new RoundedButton("Notificaciones: Activadas", 25);
        btnNotificaciones.setBounds(150, 280, 200, 40);
        panelCentral.add(btnNotificaciones);

        // Botón Volver al menú usuario
        RoundedButton btnVolver = new RoundedButton("Volver", 25);
        btnVolver.setBounds(150, 360, 200, 40);
        panelCentral.add(btnVolver);
        btnVolver.addActionListener(e -> cardLayout.show(contentPane, "principal"));

        // Acción de ejemplo para cambiar texto del tema
        btnTema.addActionListener(new ActionListener() {
            boolean claro = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                claro = !claro;
                btnTema.setText("Tema: " + (claro ? "Claro" : "Oscuro"));
            }
        });

        // Acción para cambiar el idioma (ejemplo)
        btnIdioma.addActionListener(e -> {
            if (btnIdioma.getText().equals("Idioma: Español")) {
                btnIdioma.setText("Idioma: Inglés");
            } else {
                btnIdioma.setText("Idioma: Español");
            }
        });

        // Acción para notificaciones (ejemplo)
        btnNotificaciones.addActionListener(e -> {
            if (btnNotificaciones.getText().contains("Activadas")) {
                btnNotificaciones.setText("Notificaciones: Desactivadas");
            } else {
                btnNotificaciones.setText("Notificaciones: Activadas");
            }
        });

        // Acción cambiar contraseña (solo simula con mensaje)
        btnCambiarContrasena.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funcionalidad para cambiar contraseña aún no implementada.");
        });
    }
}


