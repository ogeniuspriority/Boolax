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
$quu = "SELECT boo_users.boo_users_id, boo_users.boo_users_firstname, boo_users.boo_users_lastname,"
        . " boo_users.boo_users_gender,boo_users.boo_users_username,boo_users.boo_users_age, "
        . "boo_users.boo_users_province, boo_users.boo_users_district,boo_users_meet.boo_users_meet_id,boo_users_meet.boo_users_meet_me_id,"
        . "boo_users_meet.boo_users_meet_acquanitance,boo_users_meet.boo_users_meet_regdate,"
        . "boo_users_meet.boo_users_meet_meilikeu,boo_users_meet.boo_users_meet_ulikeme,"
        . "boo_users_meet.boo_users_meet_melikeseen,boo_users_meet.boo_users_meet_wholiked,boo_users_meet.boo_users_meet_melikeignored,"
        . "boo_users_meet.boo_users_meet_me_block,boo_users_meet.boo_users_meet_them_block FROM boo_users "
        . "INNER JOIN boo_users_meet ON (boo_users_meet.boo_users_meet_acquanitance = boo_users.boo_users_id"
        . " AND boo_users_meet.boo_users_meet_me_id = $id) OR (boo_users_meet.boo_users_meet_acquanitance = $id "
        . " AND boo_users_meet.boo_users_meet_me_id = boo_users.boo_users_id) "
        . "ORDER BY RAND() LIMIT 10";


$result = $mysqli->query($quu)or die($mysqli->error);

/* If there are results from database push to result array */

if ($result->num_rows > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
        $acquint = $row['boo_users_id'];
        array_push($userIDs, $acquint);
        array_push($meetIDs, $row['boo_users_meet_id']);
        

          /* If there are results from database push to result array */
 
        if ($row['boo_users_meet_meilikeu'] == $row['boo_users_meet_ulikeme']) {
            if ($row['boo_users_meet_ulikeme'] == 0 && $row['boo_users_meet_melikeignored'] == 0) {
                array_push($final_result, $row);
            } elseif ($row['boo_users_meet_ulikeme'] == 0 && $row['boo_users_meet_melikeignored'] == 1) {
                if (randomize($row['boo_users_meet_regdate'])) {
                    array_push($final_result, $row);
                }
            } else {
                continue;
            }
        } elseif ($row['boo_users_meet_meilikeu'] != $row['boo_users_meet_ulikeme']) {
            if ($row['boo_users_meet_meilikeu'] == 1 && $row['boo_users_meet_ulikeme'] == 0) {
                if ($row['boo_users_meet_ulikeme'] == 0 && $row['boo_users_meet_melikeignored'] == 1) {
//                    if (randomize($row['boo_users_meet_regdate'])) {
//                        array_push($final_result, $row);
//                    }
                    continue;
                } else {
                    array_push($final_result, $row);
                }
            }
            if ($row['boo_users_meet_meilikeu'] == 0 && $row['boo_users_meet_ulikeme'] == 1) {
                if ($row['boo_users_meet_ulikeme'] == 1 && $row['boo_users_meet_melikeignored'] == 1) {
//                    if (randomize($row['boo_users_meet_regdate'])) {
//                        array_push($final_result, $row);
//                    }
                    continue;
                } else {
                    array_push($final_result, $row);
                }
            }
        } else {
            
        }
    }
}
if (!empty($meetIDs)) {
//    $meetIDs=array(0);


    $sql = "SELECT boo_users_id, boo_users_firstname, boo_users_lastname, boo_users_gender,boo_users_username, boo_users_age, boo_users_province, boo_users_district FROM boo_users WHERE  RAND()<(SELECT ((1/COUNT(*))*10) FROM boo_users) AND boo_users_gender != '$g' AND boo_users_id NOT IN (SELECT boo_users_meet_me_id FROM boo_users_meet WHERE boo_users_meet_id IN (" . implode(',', $meetIDs) . ")) AND boo_users_id NOT IN (SELECT boo_users_meet_acquanitance FROM boo_users_meet WHERE boo_users_meet_id IN  (" . implode(',', $meetIDs) . "))";

    $result1 = $mysqli->query($sql)or die($mysqli->error);

    /* If there are results from database push to result array */

    if ($result1->num_rows > 0) {
        $currentDate = date("Y-m-d H:i:s");
        while ($row1 = mysqli_fetch_assoc($result1)) {
            $sql1 = "INSERT INTO boo_users_meet ( boo_users_meet_me_id, boo_users_meet_acquanitance,  boo_users_meet_regdate, boo_users_meet_wholiked)"
                    . "VALUES ('$id'," . $row1['boo_users_id'] . ",'$currentDate', '$id')";
            $reg_result = $mysqli->query($sql1)or die($mysqli->error);
            if ($reg_result) {
                array_push($final_result, $row1);
            }
        }
    }
}


//--------------------------------------------------------------------------
// 3) echo result as json 
//--------------------------------------------------------------------------

echo json_encode($final_result);

function randomize($param) {

    $time_temp = strtotime($param);

    $days = ((time() - $time_temp) / (3600 * 24));
    $bool = $days / (30);
    if (($bool % 2) == 0) {
        return true;
    } else {
        return false;
    }
}
