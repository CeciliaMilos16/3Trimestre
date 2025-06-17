package Graficas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

import BaseDeDatos.ConexionDB;
import Objetos.Usuario;

public class PanelRegistrarse extends JPanel {

    public PanelRegistrarse(CardLayout cardLayout, JPanel contentPane) {
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
        panel.setLayout(null);
        panel.setBounds(49, 37, 726, 580);
        add(panel);
        setComponentZOrder(panel, 0);

        Font labelFont = new Font("Segoe UI Semilight", Font.BOLD, 16);

        JLabel lblLogo = new JLabel();
        lblLogo.setBounds(421, 30, 90, 89);
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\cecil\\Downloads\\imagenWeb\\logoGrande.png");
        Image img = originalIcon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(img));
        panel.add(lblLogo);

        JLabel lblTitulo = new JLabel("FIT-TRACK");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
        lblTitulo.setBounds(521, 54, 124, 40);
        panel.add(lblTitulo);

        JLabel lblSubtitulo = new JLabel("Registrarse");
        lblSubtitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 33));
        lblSubtitulo.setForeground(Color.WHITE);
        lblSubtitulo.setBounds(30, 51, 180, 68);
        panel.add(lblSubtitulo);

        JLabel lblCorreo = new JLabel("Correo Electrónico");
        lblCorreo.setBounds(30, 144, 200, 20); panel.add(lblCorreo);
        lblCorreo.setFont(labelFont); lblCorreo.setForeground(Color.WHITE);
        RoundedTextField txtCorreo = new RoundedTextField(30);
        txtCorreo.setBounds(30, 170, 300, 30); panel.add(txtCorreo);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(30, 223, 200, 20); panel.add(lblNombre);
        lblNombre.setFont(labelFont); lblNombre.setForeground(Color.WHITE);
        RoundedTextField txtNombre = new RoundedTextField(30);
        txtNombre.setBounds(30, 247, 300, 30); panel.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(380, 223, 200, 20); panel.add(lblApellido);
        lblApellido.setFont(labelFont); lblApellido.setForeground(Color.WHITE);
        RoundedTextField txtApellido = new RoundedTextField(30);
        txtApellido.setBounds(380, 247, 300, 30); panel.add(txtApellido);

        JLabel lblContraseña = new JLabel("Contraseña");
        lblContraseña.setBounds(380, 144, 200, 20); panel.add(lblContraseña);
        lblContraseña.setFont(labelFont); lblContraseña.setForeground(Color.WHITE);
        RoundedPasswordField txtContraseña = new RoundedPasswordField(30);
        txtContraseña.setBounds(380, 170, 300, 30); panel.add(txtContraseña);

        JLabel lblSexo = new JLabel("Sexo");
        lblSexo.setBounds(30, 295, 200, 20); panel.add(lblSexo);
        lblSexo.setFont(labelFont); lblSexo.setForeground(Color.WHITE);
        String[] sexo = {"Masculino", "Femenino"};
        RoundedComboBox<String> comboSexo = new  RoundedComboBox<String>(sexo,30);
        comboSexo.setBounds(30, 326, 300, 30);
        panel.add(comboSexo);

     // Modelo con valores entre 15 y 80 años, incremento de 1 y valor inicial 18
        SpinnerNumberModel modelEdad = new SpinnerNumberModel(18, 15, 80, 1);
        JSpinner spinnerEdad = new JSpinner(modelEdad);
        spinnerEdad.setBounds(380, 326, 300, 30);
        panel.add(spinnerEdad);

        // Para evitar que el usuario escriba manualmente en el JSpinner:
        JFormattedTextField txt = ((JSpinner.NumberEditor) spinnerEdad.getEditor()).getTextField();
        txt.setEditable(false);  // Aquí se bloquea la escritura manual


     // Altura (cm)
        JLabel lblAltura = new JLabel("Altura (cm)");
        lblAltura.setBounds(30, 362, 200, 20);
        panel.add(lblAltura);
        lblAltura.setFont(labelFont);
        lblAltura.setForeground(Color.WHITE);

        SpinnerNumberModel modelAltura = new SpinnerNumberModel(170, 100, 250, 1); // valor inicial 170 cm
        JSpinner spinnerAltura = new JSpinner(modelAltura);
        spinnerAltura.setBounds(30, 393, 300, 30);
        panel.add(spinnerAltura);
        // Bloquear edición manual
        JFormattedTextField txtAltura = ((JSpinner.NumberEditor) spinnerAltura.getEditor()).getTextField();
        txtAltura.setEditable(false);

        // Peso (kg)
        JLabel lblPeso = new JLabel("Peso (kg)");
        lblPeso.setBounds(380, 362, 200, 20);
        panel.add(lblPeso);
        lblPeso.setFont(labelFont);
        lblPeso.setForeground(Color.WHITE);

        SpinnerNumberModel modelPeso = new SpinnerNumberModel(70, 30, 250, 1); // valor inicial 70 kg
        JSpinner spinnerPeso = new JSpinner(modelPeso);
        spinnerPeso.setBounds(380, 393, 300, 30);
        panel.add(spinnerPeso);
        // Bloquear edición manual
        JFormattedTextField txtPeso = ((JSpinner.NumberEditor) spinnerPeso.getEditor()).getTextField();
        txtPeso.setEditable(false);


     // Label y Spinner para Peso Objetivo
        JLabel lblPesoObj = new JLabel("Peso Objetivo");
        lblPesoObj.setBounds(30, 429, 200, 20);
        panel.add(lblPesoObj);
        lblPesoObj.setFont(labelFont);
        lblPesoObj.setForeground(Color.WHITE);

        // Label para mostrar rango de peso objetivo
        JLabel lblRangoPesoObj = new JLabel("");
        lblRangoPesoObj.setBounds(30, 491, 239, 20);
        lblRangoPesoObj.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
        lblRangoPesoObj.setForeground(new Color(255, 255, 255));
        panel.add(lblRangoPesoObj);

        // Spinner para peso objetivo (se configurará luego)
        SpinnerNumberModel modelPesoObj = new SpinnerNumberModel(70, 30, 250, 1); // inicial dummy, se actualizará
        JSpinner spinnerPesoObj = new JSpinner(modelPesoObj);
        spinnerPesoObj.setBounds(30, 462, 300, 30);
        panel.add(spinnerPesoObj);
        // Bloquear edición manual
        JFormattedTextField txtPesoObjSpinner = ((JSpinner.NumberEditor) spinnerPesoObj.getEditor()).getTextField();
        txtPesoObjSpinner.setEditable(false);

        // Listener para el spinnerAltura (o cuando cambie su valor) para actualizar el rango de peso objetivo
        spinnerAltura.addChangeListener(e -> {
            int alturaCm = (Integer) spinnerAltura.getValue();
            double alturaM = alturaCm / 100.0;

            // Cálculo rango peso objetivo con IMC saludable
            int pesoMin = (int) Math.round(18.5 * alturaM * alturaM);
            int pesoMax = (int) Math.round(24.9 * alturaM * alturaM);

            // Actualizar etiqueta con rango
            lblRangoPesoObj.setText("Rango saludable: " + pesoMin + " kg - " + pesoMax + " kg");

            // Actualizar modelo spinnerPesoObj con nuevo rango
            int valorActual = (Integer) spinnerPesoObj.getValue();

            SpinnerNumberModel nuevoModelo = new SpinnerNumberModel(
                Math.min(Math.max(valorActual, pesoMin), pesoMax), // valor dentro del rango
                pesoMin,
                pesoMax,
                1
            );
            spinnerPesoObj.setModel(nuevoModelo);

       
            txt.setEditable(false);
        });


     // 1. Crear y añadir la etiqueta
        JLabel lblFactorAct = new JLabel("Factor de Actividad");
        lblFactorAct.setBounds(380, 429, 200, 20);
        panel.add(lblFactorAct);
        lblFactorAct.setFont(labelFont);
        lblFactorAct.setForeground(Color.WHITE);

        // 2. Crear el array con las opciones
        String[] factoresActividad = {
            "1.2 - Sedentario (poca o ninguna actividad física)",
            "1.375 - Ligero (ejercicio ligero 1-3 días/semana)",
            "1.55 - Moderado (ejercicio moderado 3-5 días/semana)",
            "1.725 - Intenso (ejercicio intenso 6-7 días/semana)",
            "1.9 - Muy Intenso (entrenamiento diario y trabajo físico)"
        };

        // 3. Crear y añadir el comboBox
        RoundedComboBox<String> comboFactorAct = new RoundedComboBox<String>(factoresActividad,30);
        comboFactorAct.setBounds(380, 462, 300, 30);
        panel.add(comboFactorAct);

        // 4. Crear un botón para capturar la selección y obtener el valor double
        JButton btnObtenerFactor = new JButton("Obtener Factor");
        btnObtenerFactor.setBounds(380, 500, 150, 30);
        panel.add(btnObtenerFactor);

        btnObtenerFactor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor seleccionado como String
                String seleccion = (String) comboFactorAct.getSelectedItem();

                // Extraer solo el número antes del guion
                String valorNumericoStr = seleccion.split(" - ")[0];

                // Convertir a double
                double factorActividad = Double.parseDouble(valorNumericoStr);

                // Mostrar o usar el valor double
                System.out.println("Factor de actividad seleccionado: " + factorActividad);

                // Por ejemplo, guardarlo en alguna variable o usarlo para cálculos
                // miVariableFactor = factorActividad;
            }
        });



        RoundedButton btnRegistrar = new RoundedButton("Registrar", 30);
        btnRegistrar.setBounds(281, 516, 140, 40);
        panel.add(btnRegistrar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(10, 10, 100, 30);
        btnVolver.addActionListener(e -> cardLayout.show(contentPane, "bienvenida"));
        panel.add(btnVolver);
        
        JLabel lblErrorCorreo = new JLabel();
        lblErrorCorreo.setForeground(Color.RED);
        lblErrorCorreo.setBounds(30, 199, 300, 14); // Ajusta posición debajo del campo correo
        panel.add(lblErrorCorreo);

        JLabel lblErrorNombre = new JLabel();
        lblErrorNombre.setForeground(Color.RED);
        lblErrorNombre.setBounds(30, 280, 300, 20); // Ajusta posición
        panel.add(lblErrorNombre);

        JLabel lblErrorApellido = new JLabel();
        lblErrorApellido.setForeground(Color.RED);
        lblErrorApellido.setBounds(380, 280, 300, 20);
        panel.add(lblErrorApellido);

        JLabel lblErrorContraseña = new JLabel();
        lblErrorContraseña.setForeground(Color.RED);
        lblErrorContraseña.setBounds(380, 196, 300, 20);
        panel.add(lblErrorContraseña);

        // ... haz lo mismo para otros campos que quieras validar

        btnRegistrar.addActionListener((ActionEvent e) -> {
            // Limpiar mensajes de error
            lblErrorCorreo.setText("");
            lblErrorNombre.setText("");
            lblErrorApellido.setText("");
            lblErrorContraseña.setText("");

            String correo = txtCorreo.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String contraseña = new String(txtContraseña.getPassword()).trim();

            boolean error = false;

            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                lblErrorCorreo.setText("Correo electrónico inválido");
                error = true;
            }
            if (nombre.length() < 3 || nombre.length() > 15 || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
                lblErrorNombre.setText("Nombre inválido (3-15 letras) sin espacios");
                error = true;
            }
            if (apellido.length() < 3 || apellido.length() > 25 || !apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
                lblErrorApellido.setText("Apellido inválido (3-25 letras) sin espacios");
                error = true;
            }
            if (contraseña.length() < 8) {
                lblErrorContraseña.setText("La contraseña debe tener mínimo 8 caracteres");
                error = true;
            }

            // Si hubo error, no continuar
            if (error) return;

            try {
                // Obtener valores desde los componentes correctos
                String sexoSeleccionado = (String) comboSexo.getSelectedItem();
                double peso = ((Integer) spinnerPeso.getValue()).doubleValue();
                double altura = ((Integer) spinnerAltura.getValue()).doubleValue();
                double pesoObjetivo = ((Integer) spinnerPesoObj.getValue()).doubleValue();
                int edad = (Integer) spinnerEdad.getValue();

                // Obtener factor de actividad
                String factorString = (String) comboFactorAct.getSelectedItem();
                double fActividad = Double.parseDouble(factorString.split(" ")[0]);

                // Calcular valores
                double imc = calcularImc(peso, altura);
                String categoriaImc = calcularCategoriaImc(imc);
                double caloriasRecomendadas = calcularCaloriasRecomendadas(peso, altura, edad, fActividad);

                // Crear usuario
                Usuario u = new Usuario(nombre, apellido, correo, contraseña, sexoSeleccionado, categoriaImc,
                        peso, altura, pesoObjetivo, fActividad, imc, caloriasRecomendadas, edad);

             

                // Aquí puedes añadir lógica para guardar el usuario o mostrar mensaje de éxito

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa datos numéricos válidos para peso, altura, edad y peso objetivo.");
            }

        });
    }


        
     // Métodos auxiliares

        protected double calcularImc(double peso, double altura) {
            return peso / (altura * altura);
        }

        protected String calcularCategoriaImc(double imc) {
            if (imc < 18.5) return "Bajo peso";
            else if (imc < 25) return "Normal";
            else if (imc < 30) return "Sobrepeso";
            else return "Obesidad";
        }

        protected double calcularCaloriasRecomendadas(double peso, double altura, int edad, double factorActividad) {
            double tmb = 10 * peso + 6.25 * (altura * 100) - 5 * edad + 5; // fórmula Harris-Benedict para hombre
            return tmb * factorActividad;
        }
        
}


