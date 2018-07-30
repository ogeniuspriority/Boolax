<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require 'classes/db.php';
session_start();
$g = $_SESSION['gender'];
$id = $_SESSION['id'];

/* SQL query to get results from database */
$final_result = array();

$userIDs = array();
$meetIDs = array(0);


$acquint = "";
$quu = "SELECT boo_users.boo_users_id,"
        . "boo_users.boo_users_username, "
        . "boo_users_meet.boo_users_meet_id,boo_users_meet.boo_users_meet_me_id,"
        . "boo_users_meet.boo_users_meet_acquanitance,"
        . "boo_users_meet.boo_users_meet_meilikeu,boo_users_meet.boo_users_meet_ulikeme,"
        . "boo_users_meet.boo_users_meet_me_block,boo_users_meet.boo_users_meet_them_block FROM boo_users "
        . "INNER JOIN boo_users_meet ON boo_users.boo_users_id = boo_users_meet.boo_users_meet_acquanitance"
        . " AND boo_users_meet.boo_users_meet_me_id = $id WHERE boo_users_meet.boo_users_meet_meilikeu = '1'"
        . " AND boo_users_meet.boo_users_meet_ulikeme = '1' AND boo_users_meet.boo_users_meet_me_block = '0' "
        . " AND boo_users_meet.boo_users_meet_them_block = '0'";



$result = $mysqli->query($quu)or die($mysqli->error);

/* If there are results from database push to result array */

if ($result->num_rows > 0) {
    while ($row = mysqli_fetch_assoc($result)) {


        /* If there are results from database push to result array */


        $final_result += $row;
    }
}






//--------------------------------------------------------------------------
// 3) echo result as json 
//--------------------------------------------------------------------------

echo json_encode($final_result);


