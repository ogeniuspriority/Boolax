<?php
require_once("classes/db.php");



if(!empty($_POST["email"])) {
    $email = strip_tags(trim(htmlspecialchars($_POST["email"])));
  $result = $mysqli->query("SELECT boo_users_email FROM boo_users WHERE boo_users_email='" . $email . "'")or die($mysqli->error);

  if($result->num_rows > 0) {
      echo "0";
  }else{
      echo "1";
  }
}
