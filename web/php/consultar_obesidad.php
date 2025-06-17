<?php
include("ConexionDB.php");

echo "<h2>Usuarios con obesidad (IMC ≥ 30)</h2>";

$consulta = "SELECT * FROM usuario WHERE IMC >= 30";
$resultado = mysqli_query($conex, $consulta);

if ($resultado && mysqli_num_rows($resultado) > 0) {
    echo "<table border='1'>                           
            <tr>
                <th>Nombre</th>
                <th>Email</th>
                <th>Peso (kg)</th>
                <th>Altura (cm)</th>
                <th>IMC</th>
            </tr>";

    while ($fila = mysqli_fetch_assoc($resultado)) {
        echo "<tr>
                <td>{$fila['NOMBRE_USUARIO']} {$fila['APELLIDO_DE_USUARIO']}</td>
                <td>{$fila['CORREO']}</td>
                <td>{$fila['PESO']}</td>
                <td>{$fila['ALTURA']}</td>
                <td>{$fila['IMC']}</td>
            </tr>";
    }
    echo "</table>";
} else {
    echo "No hay usuarios con obesidad registrados.";
}
?>
