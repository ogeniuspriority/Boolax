<?php

require 'classes/db.php';
session_start();

// Make sure email and hash variables aren't empty
if (isset($_GET['email']) && !empty($_GET['email']) AND isset($_GET['password']) && !empty($_GET['password'])) {
    $em = $mysqli->escape_string($_GET['email']);
    $pas = $mysqli->escape_string($_GET['password']);

    // Make sure user email with matching hash exist
    $result = $mysqli->query("SELECT * FROM boo_users WHERE boo_users_email='$em'");

    if ($result->num_rows > 0) {
        $result_1 = $mysqli->query("UPDATE boo_users SET boo_active = '1' WHERE boo_users_email='$em'") or die($mysqli->error);
        if ($result_1) {
            header("Location:main_page.php");
        }
    } else {
        $_SESSION['message'] = "You have entered invalid URL for password reset!";
        echo '<script>';
        echo 'alert("You have entered invalid URL for account verification!")';
        echo '</script>';
    }
}

