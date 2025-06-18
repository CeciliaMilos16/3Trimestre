package Graficas;

import javax.swing.*;
import java.awt.*;

public class PlanEjercicio extends JPanel {

    private static final long serialVersionUID = 1L;

    public PlanEjercicio(CardLayout cardLayout, JPanel contentPane) {
        setLayout(null);
        setBounds(0, 0, 820, 700);

        // Panel con fondo degradado
        JPanel panelFondo = new JPanel() {
            private static final long serialVersionUID = 1L;

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 70, 80), 0, getHeight(), new Color(50, 220, 230));
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            }
        };
        panelFondo.setBounds(50, 50, 700, 600);
        panelFondo.setLayout(null);
        add(panelFondo);

        // Título
        JLabel lblTitulo = new JLabel("Selecciona tu Plan de Ejercicio");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(200, 20, 400, 30);
        panelFondo.add(lblTitulo);

        // Botones de planes
        JButton btnHipertrofia = new JButton("Hipertrofia");
        JButton btnPerderGrasa = new JButton("Perder Grasa");
        JButton btnCardio = new JButton("Cardio");

        btnHipertrofia.setBounds(100, 80, 200, 40);
        btnPerderGrasa.setBounds(100, 140, 200, 40);
        btnCardio.setBounds(100, 200, 200, 40);

        panelFondo.add(btnHipertrofia);
        panelFondo.add(btnPerderGrasa);
        panelFondo.add(btnCardio);

        // Área de descripción
        JTextArea areaDescripcion = new JTextArea();
        areaDescripcion.setEditable(false);
        areaDescripcion.setWrapStyleWord(true);
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scroll = new JScrollPane(areaDescripcion);
        scroll.setBounds(330, 80, 340, 220);
        panelFondo.add(scroll);

        // Acciones de los botones
        btnHipertrofia.addActionListener(e -> areaDescripcion.setText("Plan de Hipertrofia: enfocado en aumentar la masa muscular mediante ejercicios de fuerza, series múltiples y cargas progresivas. Entrenamiento dividido por grupos musculares."));
        btnPerderGrasa.addActionListener(e -> areaDescripcion.setText("Plan para Perder Grasa: combinación de entrenamiento funcional, fuerza moderada y cardio. Ideal con déficit calórico. Incluye intervalos y alta intensidad."));
        btnCardio.addActionListener(e -> areaDescripcion.setText("Plan de Cardio: mejora la salud cardiovascular. Incluye caminatas, trote, ciclismo o HIIT. Se recomienda realizarlo de 3 a 5 veces por semana."));

        // Botón volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(550, 520, 100, 30);
        panelFondo.add(btnVolver);

        btnVolver.addActionListener(e -> cardLayout.show(contentPane, "principal"));
    }
}

