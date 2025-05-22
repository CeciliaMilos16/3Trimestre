package Sesiones;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistroFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroFrame frame = new RegistroFrame();
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
	public RegistroFrame() {
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1020,900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(92, 203, 198));
		lblNewLabel.setIcon(new ImageIcon("//C:\\\\Users\\\\cecil\\\\Downloads\\\\imagenWeb\\\\fondo1.png")); //C:\\Users\\cecil\\Downloads\\imagenWeb\\fondo1.png
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
		panel.setBounds(115, 156, 779, 484);
		contentPane.add(panel);
		
		contentPane.setComponentZOrder(panel, 0);
		panel.setLayout(null);
		
		
		//PONER ICONO
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(77, 153, 109, 115);
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
		lblNewLabel_2.setBounds(52, 268, 172, 50);
		panel.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("Iniciar Sesión");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(301, 51, 370, 50);
		panel.add(lblNewLabel_3);
		
		
		//PEDIR CORREO ELECTRONICO
		JLabel lblNewLabel_4 = new JLabel("Correo Electrónico");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblNewLabel_4.setBounds(301, 140, 223, 27);
		panel.add(lblNewLabel_4);
		
	
		
		//CONTRASEÑA
		JLabel lblNewLabel_7 = new JLabel("Contraseña");
		lblNewLabel_7.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(301, 236, 109, 27);
		panel.add(lblNewLabel_7);
		
		// CAMPO: CORREO
		RoundedTextField txtCorreo = new RoundedTextField(30); // 30 es el radio de redondez

		txtCorreo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		txtCorreo.setBounds(301, 178, 370, 33);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);

		

		// CAMPO: CONTRASEÑA
		RoundedPasswordField txtContrasena = new RoundedPasswordField(30);
		txtContrasena.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		txtContrasena.setBounds(301, 268, 370, 33);
		panel.add(txtContrasena);
		
	
		//BOTON PARA INGRESAR
		RoundedButton btnNewButton = new RoundedButton("Comenzar", 30);
		btnNewButton.setBounds(416, 344, 134, 40);
		panel.add(btnNewButton);
	
		btnNewButton.addActionListener(e -> {
		    String correo = txtCorreo.getText();
		    String contrasena = new String(txtContrasena.getPassword());

		    // Validar que no estén vacíos
		    if (correo.isEmpty() || contrasena.isEmpty()) {
		        javax.swing.JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
		        return;
		    }

		    try {
		        // Conexión a tu base de datos
		        Connection conn = ConexionDB.getConnection();

		        // Consulta preparada para verificar si existe el usuario
		        String sql = "SELECT * FROM usuario WHERE CORREO = ? AND CONTRASEÑA = ?";
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        stmt.setString(1, correo);
		        stmt.setString(2, contrasena);

		        ResultSet rs = stmt.executeQuery();

		        if (rs.next()) {
		            // Usuario válido, abrir panel principal
		            javax.swing.JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");

		            // Aquí abres el nuevo JFrame (panel principal)
		            PanelPrincipal ventanaPrincipal = new PanelPrincipal();
		            ventanaPrincipal.setVisible(true);
		            this.dispose(); // Cierra la ventana actual
		        } else {
		            javax.swing.JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos");
		        }

		        rs.close();
		        stmt.close();
		        conn.close();

		    } catch (Exception ex) {
		        ex.printStackTrace();
		        javax.swing.JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
		    }
		});


	

	



      
	}
}
