<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<?php
require 'classes/db.php';
date_default_timezone_set('Etc/UTC');
session_start();
$username1 = $_SESSION['user'];
$id1 = $_SESSION['id'];

if (isset($_POST['changeMailBtn'])) {
    // prevent sql injections/ clear user invalid inputs
    $changeMail = strip_tags(trim(htmlspecialchars($_POST['changeMail'])));
    $change_sql = "UPDATE boo_users SET boo_users_email = '$changeMail' WHERE boo_users_username = '$username1';";
    $change_result = $mysqli->query($change_sql)or die($mysqli->error);
    if ($change_result) {
        $_SESSION['email'] = $changeMail;
    }
}
if (isset($_SESSION['user'])) {
    ?>


    <html>
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
            <meta name="description" content="">
            <meta name="author" content="">


            <title><?php echo ($_SESSION['user']); ?></title>
            <!-- Bootstrap --> 
            <link href="style/bootstrap.min.css" rel="stylesheet"/> 
            <link media="(min-width: 500px) and (max-width: 768px)" href="style/tablet.css" rel="stylesheet"/>
            <link media="(max-width: 500px)" href="style/mobile.css" rel="stylesheet"/>
            <link media="(min-width: 768px)" href="style/desktop.css" rel="stylesheet"/>
            <script src="js/jquery-3.2.1.js"></script>
    <!--            <script src="js/bootstrap.js"></script>-->
            <script src="js/main.js"></script>


        </head>
        <body>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header ">
                        <a class="navbar-brand" href="#">Boolax</a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling --> 
                    <ul class="nav navbar-nav">
                        <li class=""><a href="#" id="favorite-link"  data-hover="tooltip" data-tooltip-content="favorite"><img src="images/icons/ic_favorite_border_white_24dp.png"></a></li>
                        <li class=""><a href="#" id="chat-link"  data-hover="tooltip" data-tooltip-content="Chat"><img src="images/icons/ic_chat_black_24dp.png"></a></li>
                        <li class=""><a href="#" id="account-link"  data-hover="tooltip" data-tooltip-content="Account"><img src="images/icons/ic_account_circle_white_24dp.png"></a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <div class="avatar-profile">
                                <img src="images/users_files/<?php echo $id1; ?>/avatar-icon.jpg" alt="photo">
                            </div>

                        </li>

                        <li class="dropdown"> 
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                Settings 
                                <span class="caret"></span>
                            </a> 
                            <ul class="dropdown-menu"> 
                                <li>
                                    <a href="logout.php" id="h_signout">Sign out</a>
                                </li> 
                                <li role="separator" class="divider"></li>
                                <li>
                                    <a href="#"><img src="images/icons/ic_settings_black_24dp.png" />Settings</a>
                                </li> 

                            </ul>
                        </li>
                    </ul>

                    <form class="navbar-form navbar-right ">

                        <input type="text" class="form-control" placeholder="Search...">
                    </form>

                </div>
            </nav>
            <div class="progress-container">
                <div class="progress">
                    <div class="progress-bar">

                    </div>
                </div>
            </div>
            <?php
            $result3 = $mysqli->query("SELECT boo_active FROM boo_users WHERE boo_users_username = '$username1' ") or die($mysqli->error);
            if ($result3->num_rows > 0) {
                $user1 = $result3->fetch_assoc();
                if ($user1['boo_active'] === '0') {
                    ?>
                    <div class="" id="activateModal" > 
                        <div class="modal-dialog"> 
                            <div class="modal-content"> 
                                <!-- Header--> 
                                <div class="modal-header"> 

                                    <h4 class="modal-title"> Activate your account </h4>
                                </div>
                                <!-- Body -->

                                <div class="modal-body"> 
                                    <div class="">
                                        <p> An activation link has been sent to your email address,<br> please check it visit before you continue!</p>
                                        <i id="resendMail"><?php echo $_SESSION['email']; ?></i> &nbsp;&nbsp;&nbsp;<a href="#" onclick="toggleChangeMail();
                                                return false;">Change</a><br>
                                        <form method="post" class="form-inline" id="changeMailForm" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>"><br>
                                            <small><span id="errChangeMail" class="errChangeMail text-danger" ></span></small>
                                            <input class="form-control" type="email" id="changeMail" name="changeMail" placeholder="Email address"> &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp; 
                                            <button type="submit" name="changeMailBtn" id="changeMailBtn" class="btn btn-primary">Change</button>
                                        </form>
                                        <br>
                                        <i> If you haven't received it yet, Check your internet connection<i> or </i><br>
                                        </i>
                                        <p id="successMessage" class="text-success"></p>
                                        <button class="btn btn-primary"  type="button" id="resendBtn"> RESEND </button><a href="logout.php" class="btn btn-default">GO BACK</a> <div class="loader">loading...</div>



                                    </div>
                                </div>
                                <!-- Footer --> 


                            </div> 
                        </div> 
                    </div>



                    <?php
                } else {
                    ?>
                    <div id="section" class="row">
                        <div id="wrapper">

                        </div>
                    </div>
                    <?php
                }
            }
            ?>
        </body>
    </html>
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>

    <?php
} else {
    header("Location: index.php");
}