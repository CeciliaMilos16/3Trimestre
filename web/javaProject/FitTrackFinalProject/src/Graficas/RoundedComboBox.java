package Graficas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

/**
 * JComboBox con esquinas redondeadas y fondo blanco.
 * Usa el mismo patrón que RoundedTextField/RoundedPasswordField.
 */
public class RoundedComboBox<E> extends JComboBox<E> {

    private final int arc;   // radio de redondez

    public RoundedComboBox(E[] items, int arc) {
        super(items);        // pasa las opciones al JComboBox
        this.arc = arc;
        setOpaque(false);    // fondo transparente para que se vea el rectángulo redondeado
        setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10)); // padding interno
    }

    // Si quieres un constructor sin items:
    public RoundedComboBox(int arc) {
        super();
        this.arc = arc;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.WHITE);                    // color de fondo
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
        g2.dispose();
        super.paintComponent(g);                     // dibuja el texto y la flecha
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.LIGHT_GRAY);               // color del borde
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
        g2.dispose();
    }
}

