<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require 'classes/db.php'; #
session_start();
$myId = $_SESSION['id'];

/* SQL query to get results from database */
$final_result = array();
$sql = "SELECT group_id, group_name, group_privacy, group_members_no FROM boo_group WHERE group_privacy = 'public'";
$sql1 = "SELECT group_id, group_name, group_privacy, group_members_no FROM boo_group WHERE group_privacy = 'private'";
$result1 = $mysqli->query($sql1)or die($mysqli->error);
if ($result1->num_rows > 0) {
    while ($row1 = mysqli_fetch_assoc($result1)) {
        $tablename = $row1['group_name'] . "" . $row1['group_id'];
        $sql2 = "SELECT *  FROM $tablename WHERE group_member_id = '$myId'";
        $result2 = $mysqli->query($sql2)or die($mysqli->error);
        if ($result2->num_rows > 0) {
            array_push($final_result, $row1);
        } else {
            continue;
        }
    }
}

$result = $mysqli->query($sql)or die($mysqli->error);

/* If there are results from database push to result array */
if ($result->num_rows > 0) {
    while ($row = mysqli_fetch_assoc($result)) {


        array_push($final_result, $row);
    }
}
//--------------------------------------------------------------------------
// 3) echo result as json 
//--------------------------------------------------------------------------
echo json_encode($final_result);




