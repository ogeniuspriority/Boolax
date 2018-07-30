<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require 'classes/db.php';
session_start();

/* SQL query to get results from database */
if (isset($_POST['btnjoin'])) {
    $g = $_SESSION['id'];
    $h = $_POST['groupid'];
    $sql1 = "SELECT group_name FROM boo_group WHERE group_id= '$h'";
    $reg_result1 = $mysqli->query($sql1)or die($mysqli->error);
    if ($reg_result1->num_rows > 0) {
        
        $reg_row1 = mysqli_fetch_assoc($reg_result1);
        $currentDate = date("Y-m-d H:i:s");
        $n = $reg_row1['group_name'].''.$h;
        $sql = "UPDATE $n SET group_member_active = '1' WHERE group_member_id = '$g'";
        $reg_result = $mysqli->query($sql)or die($mysqli->error);
        if ($reg_result) {
        echo"request sent";
    }
    /* If there are results from database push to result array */ else {
        echo "Sorry, something went wrong!";
    }
    }

    
}


