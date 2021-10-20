<?php

$dbhost = "localhost";
//$username="derma_dermato"; //usuario
$username = "usuario_may"; //usuario
//$password="ZfYUYM5FDqKjVafP";  //contrase�a
$password = "xx9jklmayeutica";  //contrase�a
$dbname = 'bd_mayeutica';   // nombre de la bs


$conexion = new mysqli($dbhost, $username, $password) or die('No se puede conectar.');
if ($conexion->connect_errno) {

    die("La conexion ha fallado" . $conexion->connect_errno);
}
?>


