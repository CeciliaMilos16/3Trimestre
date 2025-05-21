<?php

$conex= mysqli_connect("localhost", "root", "", "proyectofinal");


// Verifica si la conexión fue exitosa
if (!$conex) {
    die("Error de conexión: " . mysqli_connect_error());
}

?>