<?php
require_once("classes/db.php");



if(!empty($_POST["username"])) {
    $usern = strip_tags(trim(htmlspecialchars($_POST["username"])));
  $result = $mysqli->query("SELECT boo_users_username FROM boo_users WHERE boo_users_username='" . $usern . "'")or die($mysqli->error);

  if($result->num_rows > 0) {
      echo "0";
  }else{
      echo "1";
  }
}
