package Graficas;

import javax.swing.*;
import java.awt.*;

public class PanelPlanNutricional extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelPlanNutricional(CardLayout cardLayout, JPanel contentPane) {
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
        JLabel lblTitulo = new JLabel("Selecciona tu Plan Nutricional");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(200, 20, 400, 30);
        panelFondo.add(lblTitulo);

        // Botones de selección
        JButton btnVegano = new JButton("Dieta Vegana");
        JButton btnKeto = new JButton("Dieta Keto");
        JButton btnMusculo = new JButton("Ganar Músculo");
        JButton btnPerderGrasa = new JButton("Perder Grasa");

        btnVegano.setBounds(100, 80, 200, 40);
        btnKeto.setBounds(100, 140, 200, 40);
        btnMusculo.setBounds(100, 200, 200, 40);
        btnPerderGrasa.setBounds(100, 260, 200, 40);

        panelFondo.add(btnVegano);
        panelFondo.add(btnKeto);
        panelFondo.add(btnMusculo);
        panelFondo.add(btnPerderGrasa);

        // Panel de contenido
        JTextArea areaDescripcion = new JTextArea();
        areaDescripcion.setEditable(false);
        areaDescripcion.setWrapStyleWord(true);
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scroll = new JScrollPane(areaDescripcion);
        scroll.setBounds(330, 80, 340, 220);
        panelFondo.add(scroll);

        // Acción de los botones
        btnVegano.addActionListener(e -> areaDescripcion.setText("La dieta vegana excluye productos animales y se centra en vegetales, legumbres, frutas, semillas y granos. Rica en fibra y antioxidantes."));
        btnKeto.addActionListener(e -> areaDescripcion.setText("La dieta keto es alta en grasas saludables, moderada en proteínas y muy baja en carbohidratos. Favorece la cetosis y quema de grasa."));
        btnMusculo.addActionListener(e -> areaDescripcion.setText("Plan para ganar músculo: alto en proteínas, carbohidratos complejos y grasas saludables. Necesita un superávit calórico."));
        btnPerderGrasa.addActionListener(e -> areaDescripcion.setText("Plan para perder grasa: déficit calórico controlado, rica en proteínas y baja en carbohidratos simples. Incluye control de porciones."));

        // Botón volver (opcional)
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(550, 520, 100, 30);
        panelFondo.add(btnVolver);

        btnVolver.addActionListener(e -> cardLayout.show(contentPane, "principal"));
    }
}



