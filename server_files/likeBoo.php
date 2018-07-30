<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require 'classes/db.php';
session_start();

/* SQL query to get results from database */
if (isset($_POST['btnlike'])) {
    $g = $_SESSION['id'];
    $h = $_POST['booID'];
    $l = 1;
    $currentDate = date("Y-m-d H:i:s");
    
    $sql = "SELECT FROM boo_users_meet WHERE boo_users_meet_me_id = '$g' AND boo_users_meet_acquanitance = '$h'";

    $reg_result = $mysqli->query($sql)or die($mysqli->error);
    if ($reg_result) {
        echo"request sent";
    }
    /* If there are results from database push to result array */ else {
        echo "Sorry, something went wrong!";
    }
} elseif (isset($_POST['btn-boo-passon'])) {
    $g = $_SESSION['id'];
    $h = $_POST['booID'];
    $l = 1;
    $currentDate = date("Y-m-d H:i:s");
    $sql = "UPDATE boo_users_meet SET boo_users_meet_melikeignored = '$l' WHERE boo_users_meet_me_id = '$g' AND boo_users_meet_acquanitance = '$h'";


    $reg_result = $mysqli->query($sql)or die($mysqli->error);
    if ($reg_result) {
        echo"request sent";
    }
    /* If there are results from database push to result array */ else {
        echo "Sorry, something went wrong!";
    }
}


