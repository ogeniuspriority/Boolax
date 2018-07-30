<?php
/* Database connection settings */
$host = 'localhost';
$user = 'root';
$pass = 'mugabo';
$db = 'boo';
$mysqli = new mysqli($host,$user,$pass,$db) or die($mysqli->error);
