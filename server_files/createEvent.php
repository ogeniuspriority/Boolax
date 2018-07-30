<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require 'classes/db.php';
session_start();
if (isset($_POST["gprivacy"])) {
    /* SQL query to get results from database */
    $n = strip_tags(trim(htmlspecialchars($_POST["gname"])));
    $p = strip_tags(trim(htmlspecialchars($_POST["gprivacy"])));
    $c = strip_tags(trim(htmlspecialchars($_POST["gmember_count"])));
    $a = $_SESSION['user'];
    $m = strip_tags(trim(htmlspecialchars($_POST["members"])));
    $t = strip_tags(trim(htmlspecialchars($_POST["gtags"])));

    
    str_replace(' ', '', $n);
    /* Move_uploaded_file($_FILES["upload_file"]["tmp_name"], "$folder" . $_FILES["upload_file"]["name"]); */

    $currentDate = date("Y-m-d H:i:s");
    $l = 1;
    $sql = "INSERT INTO boo_event (boo_event_name, boo_event_datecreated, boo_event_datedue,boo_event_place,boo_event_organizer,boo_event_createasgroup, boo_event_description, boo_event_peoplegoing)"
            . "VALUES ('$n','$currentDate','$c','$t','$a','$currentDate','$d','$e')";
    $reg_result = $mysqli->query($sql)or die($mysqli->error);
    $sdl = "SELECT boo_event_id FROM boo_boo_event WHERE boo_event_name = '$n' AND boo_event_date_created = '$currentDate' ";
    $sdl_result = $mysqli->query($sdl)or die($mysqli->error);
    $row_sdl = mysqli_fetch_assoc($sdl_result);

    if ($reg_result) {
        $id_sdl= $row_sdl['boo_event_id'];
        $folder = "images/boo_events_files/$n$id_sdl";
        
        mkdir($folder);

        move_uploaded_file($_FILES["upload_file"]["tmp_name"], 'images/boo_events_files/' . $n.$id_sdl . '/_boo_event_avatar.jpg');
        $sql2 = "CREATE TABLE ".$n.$id_sdl." (id INT(11) AUTO_INCREMENT PRIMARY KEY, boo_event_member_username VARCHAR(30) NOT NULL, boo_event_member_id INT(11) NOT NULL, boo_event_member_admin VARCHAR(30) NOT NULL , boo_event_member_email VARCHAR(30) NOT NULL, boo_event_member_reg_date DATETIME)";
        $reg_result2 = $mysqli->query($sql2)or die($mysqli->error);
        if ($reg_result2) {


            $sql3 = "SELECT boo_users_id, boo_users_username, boo_users_email FROM boo_users WHERE boo_users_id IN (" . $m . ");";

            $result3 = $mysqli->query($sql3)or die($mysqli->error);

            /* If there are results from database push to result array */

            if ($result3->num_rows > 0) {


                while ($row3 = mysqli_fetch_assoc($result3)) {
                    $currentDate1 = date("Y-m-d H:i:s");
                    $email3 = $row3['boo_users_email'];
                    $username3 = $row3['boo_users_username'];
                    $id3 = $row3['boo_users_id'];

                    $sql4 = "INSERT INTO $n$id_sdl (boo_event_member_username, boo_event_member_id, boo_event_member_email,boo_event_member_reg_date)"
                            . "VALUES ( '$username3' , '$id3' , '$email3' , '$currentDate1')";

                    $result4 = $mysqli->query($sql4)or die($mysqli->error);
                }
            }
            $currentDate1 = date("Y-m-d H:i:s");
            $email5 = $_SESSION['email'];
            $username5 = $_SESSION['user'];
            $id5 = $_SESSION['id'];

            $sql5 = "INSERT INTO $n$id_sdl (boo_event_member_username, boo_event_member_id,boo_event_member_admin,boo_event_member_email,boo_event_member_reg_date)"
                    . "VALUES ( '$username5' , '$id5' , '1' ,'$email5', '$currentDate1')";
            $result5 = $mysqli->query($sql5)or die($mysqli->error);
            echo "1";
        }
        /* If there are results from database push to result array */ else {
            echo "0";
        }
    }
   
} else {
    
}
    