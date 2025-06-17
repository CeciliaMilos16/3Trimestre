package Graficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

class RoundedButton extends JButton {
    private int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setOpaque(false); // Hacemos el fondo transparente
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setBackground(new Color(21, 101, 221));
        setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Efecto de clic: cambiar a un tono más oscuro cuando se presiona
        Color baseColor = getBackground();
        if (getModel().isPressed()) {
            baseColor = baseColor.darker();
        } else if (getModel().isRollover()) {
            baseColor = baseColor.brighter(); // efecto al pasar el mouse
        }

        g2.setColor(baseColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Dibujar el texto encima del fondo personalizado
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Sin borde exterior
    }
}  

