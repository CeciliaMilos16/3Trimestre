package Sesiones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class PanelPrincipal extends JFrame {

    private JPanel contentPane;
    private JPanel panelAlimentos;  // Panel para mostrar alimentos
    private JPanel panelContenedor; // Panel dentro del scroll para contener etiquetas

    public PanelPrincipal() {
        setTitle("Bienvenido a FitTrack");
        setSize(1200, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(173, 233, 226));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JPanel panelBlanco = new JPanel() {
            private static final long serialVersionUID = 1L;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            }
        };
        panelBlanco.setOpaque(false);
        panelBlanco.setBounds(10, 140, 1164, 567);
        panelBlanco.setLayout(null);
        contentPane.add(panelBlanco);

        JPanel panelMenu = new JPanel() {
            private static final long serialVersionUID = 1L;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 70, 80), 0, getHeight(), new Color(50, 220, 230));
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            }
        };
        panelMenu.setOpaque(false);
        panelMenu.setBounds(10, 140, 338, 567);
        panelMenu.setLayout(null);
        contentPane.add(panelMenu);
        contentPane.setComponentZOrder(panelMenu, 0);

        JLabel lblTitulo = new JLabel("MIS ALIMENTOS CONSUMIDOS");
        lblTitulo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
        lblTitulo.setBounds(370, 35, 418, 40);
        panelBlanco.add(lblTitulo);

        JButton btnDatos = new JButton("Ver Mis Datos");
        btnDatos.setBounds(33, 273, 280, 40);
        panelBlanco.add(btnDatos);

        JButton btnAgregarAlimento = new JButton("Agregar Alimento");
        btnAgregarAlimento.setBounds(446, 461, 285, 40);
        btnAgregarAlimento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BuscarAlimento buscador = new BuscarAlimento(PanelPrincipal.this);
                buscador.setVisible(true);
            }
        });
        panelBlanco.add(btnAgregarAlimento);

        JButton btnAjustes = new JButton("Ajustar Datos");
        btnAjustes.setBounds(33, 336, 280, 40);
        panelMenu.add(btnAjustes);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBounds(102, 38, 136, 140);
        panelMenu.add(lblNewLabel_1);

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\logoGrande.png");
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        lblNewLabel_1.setIcon(scaledIcon);

        JLabel lblNewLabel_2 = new JLabel("FIT-TRACK");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
        lblNewLabel_2.setBounds(90, 178, 172, 50);
        panelMenu.add(lblNewLabel_2);

        // ----------------------
        // Panel con scroll para mostrar alimentos
        panelAlimentos = new JPanel();
        panelAlimentos.setBounds(370, 110, 418, 340);
        panelAlimentos.setBackground(Color.WHITE);
        panelAlimentos.setLayout(new BorderLayout());
        panelBlanco.add(panelAlimentos);

        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS)); // Layout vertical
        panelContenedor.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(panelContenedor);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelAlimentos.add(scrollPane, BorderLayout.CENTER);
        
        JLabel lblNewLabel = new JLabel("RESUMEN GENERAL");
        lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
        lblNewLabel.setBounds(822, 35, 244, 40);
        panelBlanco.add(lblNewLabel);
    }

    // Método público para agregar alimentos al panel
    public void agregarAlimento(String nombreAlimento, int cantidad) {
        JLabel label = new JLabel(nombreAlimento + " - Cantidad: " + cantidad);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelContenedor.add(label);
        panelContenedor.revalidate();
        panelContenedor.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PanelPrincipal ventana = new PanelPrincipal();
            ventana.setVisible(true);
        });
    }
}
