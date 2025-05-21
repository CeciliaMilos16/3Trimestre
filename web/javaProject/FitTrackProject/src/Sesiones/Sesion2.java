package Sesiones;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class Sesion2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sesion2 frame = new Sesion2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sesion2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1020,900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(92, 203, 198));
		lblNewLabel.setIcon(new ImageIcon("//C:\\Users\\cecil\\Downloads\\imagenWeb\\fondo1.png")); //C:\\Users\\cecil\\Downloads\\imagenWeb\\fondo1.png
		lblNewLabel.setBounds(0, 0, 1018, 861);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel);

		
		
		//PONER EL PANEL VERDE DEGRADADO
		JPanel panel = new JPanel() {
		    private static final long serialVersionUID = 1L;

		    @Override
		    protected void paintComponent(java.awt.Graphics g) {
		        super.paintComponent(g);
		        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
		        java.awt.GradientPaint gp = new java.awt.GradientPaint(
		            0, 0, new Color(0, 70, 80),
		            0, getHeight(), new Color(50, 220, 230)
		        );
		        g2.setPaint(gp);
		        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
		    }
		};
		panel.setBounds(207, 239, 576, 332);
		contentPane.add(panel);
		
		contentPane.setComponentZOrder(panel, 0);
		panel.setLayout(null);
		
		
		//PONER ICONO
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(231, 33, 109, 115);
		panel.add(lblNewLabel_1);

		ImageIcon originalIcon = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\logoGrande.png");
		Image img = originalIcon.getImage();
		Image scaledImg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		lblNewLabel_1.setIcon(scaledIcon);
		
		//TITULO DE FITTRACK
		JLabel lblNewLabel_2 = new JLabel("FIT-TRACK");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
		lblNewLabel_2.setBounds(205, 148, 172, 50);
		panel.add(lblNewLabel_2);
		
		//SLOGAN
		JLabel lblNewLabel_3 = new JLabel("Tu bienestar comienza aqui");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(149, 197, 282, 27);
		panel.add(lblNewLabel_3);
		
		
		//BOTON COMENZAR
		RoundedButton btnNewButton = new RoundedButton("Comenzar", 30);
		btnNewButton.setText("Iniciar Sesión");
		btnNewButton.setBounds(225, 235, 134, 40);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(e -> {
		    RegistroFrame registro = new RegistroFrame();
		    registro.setVisible(true);
		    this.dispose();  // Cierra la ventana actual Sesion2
		});

	}
}
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
