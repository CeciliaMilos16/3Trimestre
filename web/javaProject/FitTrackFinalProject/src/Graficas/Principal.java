package Graficas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout; // CardLayout para cambiar de pantalla

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Principal frame = new Principal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 700);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

        // Crear las pantallas
        JPanel panelBienvenida = crearPanelBienvenida();
       
        JPanel panelLogin = new PanelLogin(cardLayout, contentPane);
        contentPane.add(panelLogin, "login");

        JPanel panelRegistrase = new PanelRegistrarse(cardLayout, contentPane);
        contentPane.add(panelRegistrase,"registrarse");
        
        PanelConfiguracion panelConfiguracion = new PanelConfiguracion(cardLayout, contentPane);
        contentPane.add(panelConfiguracion, "configuracion");
        
        JPanel panelRegistrarAlimentos= new PanelregistrarAlimentos(cardLayout, contentPane);
        contentPane.add(panelRegistrarAlimentos,"registrar alimentos");
        
        JPanel panelPlanNutricional = new PanelPlanNutricional(cardLayout, contentPane);
        contentPane.add(panelPlanNutricional,"plan nutricional");
        
        JPanel panelPlanEjercicio = new PlanEjercicio(cardLayout, contentPane);
        contentPane.add(panelPlanEjercicio,"plan ejercicio");

        // Agregarlas al CardLayout
        contentPane.add(panelBienvenida, "bienvenida");
        contentPane.add(panelLogin, "login");
        contentPane.add(panelRegistrase, "registrarse");

        // Mostrar pantalla de bienvenida al inicio
        cardLayout.show(contentPane, "bienvenida");
    }

    private JPanel crearPanelBienvenida() {
        JPanel panel = new JPanel(null);

        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\fondo1.png"));
        fondo.setBounds(0, 0, 1018, 861);
        panel.add(fondo);

        JPanel panelCentral = new JPanel() {
            @Override
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
        panelCentral.setBounds(210, 160, 400, 354); 
        panelCentral.setLayout(null);
        panel.add(panelCentral);
        panel.setComponentZOrder(panelCentral, 0);

        JLabel lblLogo = new JLabel();
        lblLogo.setBounds((400 - 100) / 2, 20, 100, 100); 
        ImageIcon icon = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\logoGrande.png");
        Image img = icon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(img));
        panelCentral.add(lblLogo);

        JLabel lblTitulo = new JLabel("FIT-TRACK");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
        lblTitulo.setBounds(120, 131, 173, 40);
        panelCentral.add(lblTitulo);

        JLabel lblSlogan = new JLabel("Tu bienestar comienza aquí");
        lblSlogan.setForeground(Color.WHITE);
        lblSlogan.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
        lblSlogan.setBounds(89, 179, 218, 30); 
        panelCentral.add(lblSlogan);

        RoundedButton btnIniciar = new RoundedButton("Iniciar Sesión", 30);
        btnIniciar.setBounds((400 - 160) / 2, 220, 160, 40); 
        panelCentral.add(btnIniciar);
        btnIniciar.addActionListener(e -> cardLayout.show(contentPane, "login"));

        RoundedButton btnRegistrarse = new RoundedButton("Registrarse", 30);
        btnRegistrarse.setBounds((400 - 160) / 2, 275, 160, 40); 
        panelCentral.add(btnRegistrarse);
        btnRegistrarse.addActionListener(e -> cardLayout.show(contentPane, "registrarse"));

        return panel;
    }

}

