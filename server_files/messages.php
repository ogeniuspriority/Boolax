<?php

require 'classes/db.php';
session_start();

$id = $_SESSION['id'];

/* SQL query to get results from database */
$final_result = array();
$sql = "SELECT boo_users.boo_users_id,"
        . "boo_users.boo_users_username, "
        . "boo_chat_message.boo_chat_message_id,boo_chat_message.boo_chat_message_message,"
        . "boo_chat_message.boo_chat_message_type,boo_chat_message.boo_chat_message_status,"
        . "boo_chat_message.boo_chat_message_regdate,boo_chat_message.boo_chat_message_sender,"
        . "boo_chat_message.boo_chat_message_receiver,boo_chat_message.boo_chat_message_who_sent,"
        . "boo_chat_message.boo_chat_message_archived,boo_chat_message.boo_chat_message_who_archived FROM boo_users "
        . "INNER JOIN boo_chat_message ON boo_users.boo_users_id = boo_chat_message.boo_chat_message_sender"
        . " OR boo_users.boo_users_id = boo_chat_message.boo_chat_message_sender WHERE boo_chat_message.boo_chat_message_sender = '$id'"
        . " AND boo_chat_message.boo_chat_message_receiver = '$id'"
        . "ORDER BY boo_chat_message.boo_chat_message_regdate";

//$sql = "SELECT * FROM boo_chat_message WHERE boo_chat_message_sender = '$id' OR boo_chat_message_receiver = '$id'";
$result = $mysqli->query($sql)or die($mysqli->error);

/* If there are results from database push to result array */

if ($result->num_rows > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
        $final_result += $row;
    }
}





//--------------------------------------------------------------------------
// 3) echo result as json 
//--------------------------------------------------------------------------

echo json_encode($final_result);


