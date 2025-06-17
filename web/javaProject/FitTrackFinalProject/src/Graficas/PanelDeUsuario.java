package Graficas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelDeUsuario extends JPanel {
	public PanelDeUsuario(CardLayout cardLayout, JPanel contentPane) {
	    setLayout(null);
	    setBounds(0, 0, 820, 700);

	    // Fondo
	    JLabel fondo = new JLabel();
	    //fondo.setIcon(new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\fondo1.png"));
	    fondo.setBounds(0, 0, 1018, 861);
	    add(fondo);
	  

	    // Panel blanco al costado (encima del fondo, debajo de panelCentral)
	    JPanel panelBlanco = new JPanelRedondeado(30, 30); // redondeo de 30 píxeles
	    panelBlanco.setBounds(262, 23, 530, 606);
	    panelBlanco.setLayout(null);
	    panelBlanco.setOpaque(false);
	    add(panelBlanco);
	 // Botón de Registrar Alimento
	    ImageIcon iconoRegistrarAlimento = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\registrarAlimento.jpg");

	    JButton btnRegistrar = new JButton();
	    btnRegistrar.setBounds(35, 39, 233, 167);
	    panelBlanco.add(btnRegistrar);
	    btnRegistrar.setContentAreaFilled(false);
	    btnRegistrar.setBorderPainted(false);
	    btnRegistrar.setFocusPainted(false);
	    btnRegistrar.setOpaque(false);
	    
	    // Esperar a que esté visible y escalamos la imagen al tamaño del botón
	    SwingUtilities.invokeLater(() -> {
	        int ancho = btnRegistrar.getWidth();
	        int alto = btnRegistrar.getHeight();
	        if (ancho > 0 && alto > 0) {
	            Image imgEscalada = iconoRegistrarAlimento.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
	            btnRegistrar.setIcon(new ImageIcon(imgEscalada));
	        }
	    });

	    btnRegistrar.addActionListener(e -> {
	        System.out.println("¡Botón de Registrar Alimento pulsado!");
	    });

	    //Boton plan nutricional
	    ImageIcon iconoOriginalNutri = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\planNutricional.jpg");

	    JButton btnPlanNutri = new JButton();
	    
	    btnPlanNutri.setBounds(278, 39, 219, 167);
	    btnPlanNutri.setContentAreaFilled(false);
	    btnPlanNutri.setBorderPainted(false);
	    btnPlanNutri.setFocusPainted(false);
	    btnPlanNutri.setOpaque(false);

	    // Esperar a que esté visible y escalamos la imagen al tamaño del botón
	    SwingUtilities.invokeLater(() -> {
	        int ancho = btnPlanNutri.getWidth();
	        int alto = btnPlanNutri.getHeight();
	        if (ancho > 0 && alto > 0) {
	            Image imgEscalada = iconoOriginalNutri.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
	            btnPlanNutri.setIcon(new ImageIcon(imgEscalada));
	        }
	    });

	    btnPlanNutri.addActionListener(e -> {
	        System.out.println("¡Botón de Plan Nutricional pulsado!");
	    });

	    panelBlanco.add(btnPlanNutri);


	    // Botón de Plan de Ejercicio
	    ImageIcon iconoPlanEjer = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\planEjercicio.jpg");
	

	    JButton btnPlanEjer = new JButton();
	    btnPlanEjer.setBounds(35, 312, 233, 172);
	    panelBlanco.add(btnPlanEjer);
	    btnPlanEjer.setContentAreaFilled(false);
	    btnPlanEjer.setBorderPainted(false);
	    btnPlanEjer.setFocusPainted(false);
	    btnPlanEjer.setOpaque(false);
	    
	    // Esperar a que esté visible y escalamos la imagen al tamaño del botón
	    SwingUtilities.invokeLater(() -> {
	        int ancho = btnPlanEjer.getWidth();
	        int alto = btnPlanEjer.getHeight();
	        if (ancho > 0 && alto > 0) {
	            Image imgEscalada = iconoPlanEjer.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
	            btnPlanEjer.setIcon(new ImageIcon(imgEscalada));
	        }
	    });

	    btnPlanEjer.addActionListener(e -> {
	        System.out.println("¡Botón de Plan de Ejercicio pulsado!");
	    });
	    panelBlanco.add(btnPlanEjer);


	    // Panel con gradiente
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
	    panelCentral.setBounds(21, 23, 242, 606);
	    panelCentral.setLayout(null);
	    add(panelCentral);
	    
	    // OPCIONAL: Asegurar el orden de dibujo (panelCentral encima del blanco y fondo)
	    setComponentZOrder(panelCentral, 0);
	   setComponentZOrder(panelBlanco, 1);
	   setComponentZOrder(fondo, 2);
	    
	    
        JLabel lblLogo = new JLabel();
        lblLogo.setBounds(50, 37, 138, 139);
        ImageIcon icon = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\logoGrande.png");
        Image img = icon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(img));
        panelCentral.add(lblLogo);

        JLabel lblTitulo = new JLabel("FIT-TRACK");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 30));
        lblTitulo.setBounds(50, 183, 145, 49);
        panelCentral.add(lblTitulo);
     // Botón de configuración
        ImageIcon iconoConfig = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\confi.png");
        Image imgConfig = iconoConfig.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon iconoEscaladoConfig = new ImageIcon(imgConfig);

        JButton btnConfig = new JButton(iconoEscaladoConfig);
        btnConfig.setBounds(94, 268, 56, 56);
        panelCentral.add(btnConfig);
        btnConfig.setContentAreaFilled(false);
        btnConfig.setBorderPainted(false);
        btnConfig.setFocusPainted(false);
        btnConfig.setOpaque(false);

        btnConfig.addActionListener(e -> {
            System.out.println("¡Botón de configuración pulsado!");
        });

        // Botón de notificaciones
        ImageIcon iconoNoti = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\noti.png");
        Image imgNoti = iconoNoti.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon iconoEscaladoNoti = new ImageIcon(imgNoti);

        JButton btnNoti = new JButton(iconoEscaladoNoti);
        btnNoti.setBounds(94, 372, 56, 56);
        panelCentral.add(btnNoti);
        btnNoti.setContentAreaFilled(false);
        btnNoti.setBorderPainted(false);
        btnNoti.setFocusPainted(false);
        btnNoti.setOpaque(false);

        btnNoti.addActionListener(e -> {
            System.out.println("¡Botón de notificaciones pulsado!");
        });

        // Botón de cerrar sesión
        ImageIcon iconoCerrar = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\cerrarSesion.png");
        Image imgCerrar = iconoCerrar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon iconoEscaladoCerrar = new ImageIcon(imgCerrar);

        JButton btnCerrar = new JButton(iconoEscaladoCerrar);
        btnCerrar.setBounds(94, 476,56, 56);
        panelCentral.add(btnCerrar);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setOpaque(false);
        
    
        btnCerrar.addActionListener(e -> {
            cardLayout.show(contentPane, "bienvenida");
        });
        



       

    }
	//metodo para redondear las imagenesBuutton
	public BufferedImage getRoundedImage(Image img, int width, int height, int cornerRadius) {
	    BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = output.createGraphics();

	    // Habilitar antialiasing para bordes suaves
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	    // Crear una forma redondeada (rectángulo con esquinas redondeadas)
	    RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius);

	    // Recortar a la forma redondeada
	    g2.setClip(roundRect);

	    // Dibujar la imagen dentro del recorte
	    g2.drawImage(img, 0, 0, width, height, null);

	    g2.dispose();

	    return output;
	}
}



