<?php

require 'classes/db.php';
session_start();

// Make sure email and hash variables aren't empty
if( isset($_GET['email']) && !empty($_GET['email']) AND isset($_GET['password']) && !empty($_GET['password']) )
{
    $em = $mysqli->escape_string($_GET['email']); 
    $pas = $mysqli->escape_string($_GET['password']); 

    // Make sure user email with matching hash exist
    $result = $mysqli->query("SELECT * FROM boo_users WHERE boo_users_email='$em' AND resetToken='$pas'");

    if ( $result->num_rows > 0 )
    {
        $mysqli->query("UPDATE boo_users SET boo_users_password = '$pas', resetToken = '', reset_done='1' WHERE boo_users_email='$em'");
       
    }
    else{
       $_SESSION['message'] = "You have entered invalid URL for password reset!";
        header("location: index.php"); 
    }
}
else {
    $_SESSION['message'] = "Sorry, verification failed, try again!";
    header("location: index.php");  
}

