<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require 'classes/db.php';
session_start();
$g = $_SESSION['id'];
/* SQL query to get results from database */
 $row2[] = array();
if (isset($_POST['id'])) {
    $id = $_POST['id'];
    $sql = "SELECT * FROM boo_group WHERE group_id = '$id'";

    $result = $mysqli->query($sql)or die($mysqli->error);
    if ($result->num_rows > 0) {

        while ($row = mysqli_fetch_assoc($result)) {
            $row2[] = array();
            array_push($row2[1], $row);
            $name = $row['group_name'] . '' . $row['group_id'];
            $sql1 = "SELECT * FROM $name WHERE group_member_id = '$g' AND group_member_active='1'";
            $result1 = $mysqli->query($sql1)or die($mysqli->error);
            if ($result1->num_rows > 0) {
                 $sql2 = "SELECT * FROM $name WHERE group_member_active ='1'";
                $result2 = $mysqli->query($sql2)or die($mysqli->error);
                if ($result2->num_rows > 0) {


                    $row2[0] = $result2->fetch_all(MYSQLI_BOTH);
                }
                
            }  else {
                continue;
            }
        }
    }

    echo json_encode($row2);

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

}    