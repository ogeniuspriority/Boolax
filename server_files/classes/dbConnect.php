<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// this will avoid mysql_connect() deprecation error.

// but I strongly suggest you to use PDO or MySQLi.

define('DBHOST', 'localhost');
define('DBUSER', 'root');
define('DBPASS', 'mugabo');
define('DBNAME', 'boo');


$mysqli = new mysqli(DBHOST, DBUSER, DBPASS, DBNAME);
/* check connection */
if (mysqli_connect_errno()) {
    printf("Connect failed: %s\n", mysqli_connect_error());
    exit();
}