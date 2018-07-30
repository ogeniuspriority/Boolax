<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require 'classes/db.php';
session_start();

/* SQL query to get results from database */
$g=$_POST['members'];
$sql = "SELECT boo_users_id, boo_users_firstname, boo_users_lastname, boo_users_gender, boo_users_username, boo_users_age, boo_users_province, boo_users_district FROM boo_users WHERE boo_users_id IN (".$g.");";

$result = $mysqli->query($sql)or die($mysqli->error);

/* If there are results from database push to result array */

if ($result->num_rows > 0) {
    

    $row = $result->fetch_all(MYSQLI_BOTH);
        
    
    //--------------------------------------------------------------------------
    // 3) echo result as json 
    //--------------------------------------------------------------------------
    echo json_encode($row);
} else {
    echo "Sorry, We can't find any boo right now!";
}



