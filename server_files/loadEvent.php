<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require 'classes/db.php';
session_start();

/* SQL query to get results from database */
$final_result = array();
$sql = "SELECT boo_event_id, boo_event_name, boo_event_datedue, "
        . "boo_event_place, boo_event_organizer, boo_event_createasgroup, "
        . "boo_event_description, boo_event_datecreated, boo_event_peoplegoing "
        . "FROM boo_event WHERE '1'"
        . "ORDER BY RAND() LIMIT 10";




$result = $mysqli->query($sql)or die($mysqli->error);

/* If there are results from database push to result array */


if ($result->num_rows > 0) {

    $row = $result->fetch_all(MYSQLI_BOTH);

    array_push($final_result, $row);
    //--------------------------------------------------------------------------
    // 3) echo result as json 
    //--------------------------------------------------------------------------
    
}

echo json_encode($final_result);
