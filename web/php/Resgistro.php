<?php

include("ConexionDB.php");

if (!$conex) {
    die("Error de conexión: " . mysqli_connect_error());
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    if (
        !empty($_POST['nombre']) &&
        !empty($_POST['apellido']) &&
        !empty($_POST['email']) &&
        !empty($_POST['contraseña']) &&
        !empty($_POST['sexo']) &&
        !empty($_POST['altura']) &&
        !empty($_POST['peso']) &&
        !empty($_POST['factor']) &&
        !empty($_POST['edad']) &&
        !empty($_POST['peso_objetivo'])
    ) {
        $nombre = trim($_POST['nombre']);
        $apellido = trim($_POST['apellido']);
        $email = trim($_POST['email']);
        $contraseña = trim($_POST['contraseña']);
        $sexo = trim($_POST['sexo']);
        $altura = floatval($_POST['altura']);

        // Convertir centímetros a metros si es necesario
        if ($altura > 10) {
            $altura = $altura / 100;
        }

        $peso = floatval($_POST['peso']);
        $factor = floatval($_POST['factor']);
        $edad = intval($_POST['edad']);
        $peso_objetivo = floatval($_POST['peso_objetivo']);

        $password_hash = password_hash($contraseña, PASSWORD_DEFAULT);

        // Calcular IMC actual
        $imc = $peso / ($altura * $altura);
        $imc = round($imc, 2);

        // Buscar categoría de IMC en la tabla imc
        $sql_categoria = "SELECT ID_IMC FROM imc WHERE ? BETWEEN IMC_MIN AND IMC_MAX LIMIT 1";
        $stmt = mysqli_prepare($conex, $sql_categoria);
        mysqli_stmt_bind_param($stmt, "d", $imc);
        mysqli_stmt_execute($stmt);
        mysqli_stmt_bind_result($stmt, $id_categoria);
        mysqli_stmt_fetch($stmt);
        mysqli_stmt_close($stmt);

        if (!$id_categoria) {
            echo '<h3 class="bad">No se encontró categoría para este IMC.</h3>';
            exit;
        }

        // Calcular rango saludable para validar peso objetivo
        $peso_objetivo_min = round(18.5 * ($altura * $altura), 2);
        $peso_objetivo_max = round(24.9 * ($altura * $altura), 2);

        // Validar que peso objetivo esté dentro del rango saludable
        if ($peso_objetivo < $peso_objetivo_min || $peso_objetivo > $peso_objetivo_max) {
            echo '<h3 class="bad">El peso objetivo debe estar entre ' . $peso_objetivo_min . ' kg y ' . $peso_objetivo_max . ' kg.</h3>';
            exit;
        }

        // Calorías recomendadas (Harris-Benedict) usando el peso objetivo
        if (strtolower($sexo) === 'hombre') {
            $calorias = 88.36 + (13.4 * $peso_objetivo) + (4.8 * ($altura * 100)) - (5.7 * $edad);
        } else {
            $calorias = 447.6 + (9.2 * $peso_objetivo) + (3.1 * ($altura * 100)) - (4.3 * $edad);
        }
        $calorias *= $factor;
        $calorias = round($calorias, 2);

        // Insertar en la base de datos
        $consulta = "INSERT INTO usuario (
            NOMBRE_USUARIO, 
            APELLIDO_DE_USUARIO, 
            CORREO, 
            CONTRASEÑA, 
            SEXO, 
            ALTURA, 
            PESO, 
            PESO_OBJETIVO, 
            IMC, 
            CALORIAS_RECOMENDADAS, 
            ID_CATEGO_IMC, 
            FACTOR,
            EDAD
        ) VALUES (
            '$nombre', 
            '$apellido', 
            '$email', 
            '$password_hash', 
            '$sexo', 
            $altura, 
            $peso, 
            $peso_objetivo, 
            $imc, 
            $calorias, 
            $id_categoria, 
            $factor,
            $edad
        )";

        $resultado = mysqli_query($conex, $consulta);

        if ($resultado) {
            echo '<h3 class="ok">¡Usuario registrado correctamente!</h3>';
        } else {
            echo '<h3 class="bad">Error al guardar: ' . mysqli_error($conex) . '</h3>';
        }

    } else {
        echo '<h3 class="bad">Por favor complete todos los campos.</h3>';
    }

} else {
    echo '<h3 class="bad">Método no permitido.</h3>';
}
?>
