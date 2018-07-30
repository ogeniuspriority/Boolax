<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require 'classes/db.php';
session_start();

/* SQL query to get results from database */
$id = $_POST['id'];
if (isset($_POST['username'])) {
    $sql = "SELECT boo_users_username FROM boo_users WHERE boo_users_id = '$id'";
    $result = $mysqli->query($sql)or die($mysqli->error);
    if ($result->num_rows > 0) {
        $row = $result->fetch_all(MYSQLI_BOTH);
        echo json_encode($row);
    } else {
        echo "Sorry, We could not data right now!";
    }
} elseif (!isset($_POST['username'])) {
    $sql = "SELECT * FROM boo_users WHERE boo_users_id = '$id'";


    $row[0] = scandir("images/users_files/$id/gallery");
    $result = $mysqli->query($sql)or die($mysqli->error);

    /* If there are results from database push to result array */

    if ($result->num_rows > 0) {


        $row[1] = $result->fetch_all(MYSQLI_BOTH);


        //--------------------------------------------------------------------------
        // 3) echo result as json 
        //--------------------------------------------------------------------------
        echo json_encode($row);
    } else {
        echo "Sorry, We could not data right now!";
    }
}




/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

