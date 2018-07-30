<?php
require_once("classes/db.php");



if(!empty($_POST["email"])) {
  // prevent sql injections/ clear user invalid inputs
    $email = strip_tags(trim(htmlspecialchars($_POST['loginEmail'])));
    $pass = strip_tags(trim(htmlspecialchars($_POST['loginPassword'])));

    $login_sql = "SELECT * FROM boo_users WHERE boo_users_email= '$email'";
    $login_result = $mysqli->query($login_sql) or die($mysqli->error);
    echo '<script>';
    echo 'alert("login..php");';
    echo '</script>';
    if ($login_result->num_rows > 0) {
        $user = $login_result->fetch_assoc();

        if ($user['boo_users_password'] == $pass) {
            $_SESSION['active'] = $login_activation;
            header("Location: main_page.php");
        } else {
            
            echo "0";
            
        }
    } else {

         echo "0";
    }
}
