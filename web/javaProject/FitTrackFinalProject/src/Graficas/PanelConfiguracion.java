package Graficas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConfiguracion extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelConfiguracion(CardLayout cardLayout, JPanel contentPane) {
	       setLayout(null);
	        setBounds(0, 0, 820, 700);

	        JLabel fondo = new JLabel();
	        fondo.setBounds(0, 0, 1018, 861);
	        add(fondo);

	        JPanel panel = new JPanel() {
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                Graphics2D g2 = (Graphics2D) g;
	                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 70, 80), 0, getHeight(), new Color(50, 220, 230));
	                g2.setPaint(gp);
	                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
	            }
	        };
	}

}

