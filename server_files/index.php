
<?php
require 'classes/db.php';
date_default_timezone_set('Etc/UTC');
require 'classes/PHPMailerAutoload.php';
session_start();
if (isset($_POST['loginBtn'])) {
// prevent sql injections/ clear user invalid inputs
    $email = strip_tags(trim(htmlspecialchars($_POST['loginEmail'])));
    $pass = strip_tags(trim(htmlspecialchars($_POST['loginPassword'])));

    $login_sql = "SELECT * FROM boo_users WHERE boo_users_email= '$email' AND boo_users_password= '$pass'";
    $login_result = $mysqli->query($login_sql) or die($mysqli->error);

    if ($login_result->num_rows > 0) {

        $user = $login_result->fetch_assoc();
        if ($user['reset_done'] == '1') {
            $_SESSION['active'] = $user['boo_active'];
//0 until user activates their account with verify.php
// So we know the user has logged in
            $_SESSION['first_name'] = $user['boo_users_firstname'];
            $_SESSION['last_name'] = $user['boo_users_lastname'];
            $_SESSION['email'] = $user['boo_users_email'];
            $_SESSION['user'] = $user['boo_users_username'];
            $_SESSION['id'] = $user['boo_users_id'];
            $_SESSION['gender'] = $user['boo_users_gender'];
            header("Location: main_page.php");
        } else {




            echo 'You have reset your password. Check your mailbox!';
        }
    } else {
        echo '<script>';
        echo 'alert("Email or Password incorrect!");';
        echo '</script>';
    }
} elseif (isset($_POST['resetBtn'])) {
// prevent sql injections/ clear user invalid inputs
    $resetEmail = strip_tags(trim(htmlspecialchars($_POST['resetEmail'])));
    $resetPass = strip_tags(trim(htmlspecialchars($_POST['resetPassword1'])));
    $reset_sql1 = "SELECT boo_users_lastname, resetToken, reset_done FROM boo_users WHERE boo_users_email='$resetEmail';";
    $reset_result1 = $mysqli->query($reset_sql1)or die($mysqli->error);


    $user = $reset_result1->fetch_assoc();
    if ($user['reset_done'] == '1') {
        $reset_sql = "UPDATE boo_users SET resetToken = '$resetPass' WHERE boo_users_email = '$resetEmail';";
        $reset_result = $mysqli->query($reset_sql)or die($mysqli->error);
        if ($reset_result) {
            $mysqli->query("UPDATE boo_users SET reset_done = '0' WHERE boo_users_email = '$resetEmail';");


//0 until user activates their account with verify.php
// So we know the user has logged in

            $_SESSION['message'] = "Reset link has been sent to $resetEmail, please verify
                 your account by clicking on the link in the message!";

// Send registration confirmation link (verify.php)
            $to = $resetEmail;
            $subject = 'Password reset ( boolax.com )';
            $reset_body = 'Hello, Please click this link to reset your password: http://localhost/boolax/reset.php?email=' . $resetEmail . '&password=' . $resetPass;
            $name = $user['boo_users_lastname'];
//Create a new PHPMailer instance
            $mail = new PHPMailer;

//Tell PHPMailer to use SMTP
            $mail->isSMTP();

//Enable SMTP debugging
// 0 = off (for production use)
// 1 = client messages
// 2 = client and server messages
            $mail->SMTPDebug = 2;

//Ask for HTML-friendly debug output
            $mail->Debugoutput = 'html';

//Set the hostname of the mail server
            $mail->Host = 'smtp.gmail.com';
// use
// $mail->Host = gethostbyname('smtp.gmail.com');
// if your network does not support SMTP over IPv6
//Set the SMTP port number - 587 for authenticated TLS, a.k.a. RFC4409 SMTP submission
            $mail->Port = 587;

//Set the encryption system to use - ssl (deprecated) or tls
            $mail->SMTPSecure = 'tls';

//Whether to use SMTP authentication
            $mail->SMTPAuth = true;

//Username to use for SMTP authentication - use full email address for gmail
            $mail->Username = "ogeniuspriority@gmail.com";

//Password to use for SMTP authentication
            $mail->Password = "Akarusho_4002";

//Set who the message is to be sent from
            $mail->setFrom('ogeniuspriority@gmail.com', 'Boolax');

//Set an alternative reply-to address
            $mail->addReplyTo('rutacris21@gmail.com', 'cris ruta');

//Set who the message is to be sent to
            $mail->addAddress($resetEmail, $name);

//Set the subject line
            $mail->Subject = 'Reset confirmation';

//Read an HTML message body from an external file, convert referenced images to embedded,
//convert HTML into a basic plain-text alternative body
            $mail->isHTML(true);
            $mail->Body = '<html>
                            <head>
                                <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
                                <title>Reset link</title>
                            </head>
                            <body>
                                <div style="width: 640px; font-family: Arial, Helvetica, sans-serif; font-size: 11px;">
                                    <div align="center">
                                        <a href="https://github.com/PHPMailer/PHPMailer/">
                                            <img src="images/phpmailer.png" height="90" width="340" alt="PHPMailer rocks">
                                        </a>
                                    </div>
                                    <p>
                                    Hello ,
                                    Please click this link to reset your password:
                                    http://localhost/boolax/reset.php?email=' . $resetEmail . '&password=' . $resetPass . '</p>
                                </div>
                            </body>
                            </html>';

//Replace the plain text body with one created manually
            $mail->AltBody = $reset_body;

//Attach an image file
            $mail->addAttachment('images/icons/google-plus.png');

//send the message, check for errors
            if (!$mail->send()) {
                echo "Mailer Error: " . $mail->ErrorInfo;
            } else {
                echo "Message sent!";
            }
        }
    } else {
        echo '<script>';
        echo 'alert("You have reset your password. Check your mailbox!");';
        echo '</script>';
    }
} elseif (isset($_POST['registerBtn'])) {
// prevent sql injections/ clear user invalid inputs
    $firstname = strip_tags(trim(htmlspecialchars($_POST['ufirstname'])));
    $lastname = strip_tags(trim(htmlspecialchars($_POST['ulastname'])));
    $gender = strip_tags(trim(htmlspecialchars($_POST['ugender'])));
    $birthdate = strip_tags(trim(htmlspecialchars($_POST['ubirthdate'])));
    $email = strip_tags(trim(htmlspecialchars($_POST['umail'])));
    $country = strip_tags(trim(htmlspecialchars($_POST['ucountry'])));
    $province = strip_tags(trim(htmlspecialchars($_POST['uprovince'])));
    $district = strip_tags(trim(htmlspecialchars($_POST['udistrict'])));
    $username = strip_tags(trim(htmlspecialchars($_POST['uusername'])));
    $password = strip_tags(trim(htmlspecialchars($_POST['upassword'])));
    $time_temp = strtotime($birthdate);
    $birthdate_temp = date('d-m-y', $time_temp);
    $age = ((time() - $time_temp) / (3600 * 24 * 365));
    $sql = "SELECT boo_users_email,boo_users_username  FROM boo_users WHERE boo_users_email = '$email' OR boo_users_username= '$username' ";
    $result = $mysqli->query($sql) or die($mysqli->error);
    if ($result->num_rows > 0) { // User doesn't exist
        $_SESSION['message'] = "User with that email already exist!";
        header("location: index.php");
    } else { // User doesn't exist
        $reg_sql = "INSERT INTO boo_users (boo_users_firstname, boo_users_lastname, boo_users_password,  boo_users_gender,boo_users_country,boo_users_province, boo_users_district, boo_users_email, boo_users_username, boo_users_birthdate, boo_users_age) "
                . "VALUES ('$firstname','$lastname','$password','$gender','$country','$province','$district','$email','$username','$birthdate','$age')";
        $reg_result = $mysqli->query($reg_sql)or die($mysqli->error);
        if ($reg_result) {
            $_SESSION['active'] = 0;
//0 until user activates their account with verify.php
// So we know the user has logged in
            $_SESSION['first_name'] = $firstname;
            $_SESSION['last_name'] = $lastname;
            $_SESSION['email'] = $email;
            $_SESSION['user'] = $username;

            $_SESSION['gender'] = $gender;
            $_SESSION['message'] = "Confirmation link has been sent to $email, please verify
                 your account by clicking on the link in the message!";

// Send registration confirmation link (verify.php)
            $to = $email;
            $name = $firstname;
            $subject = 'Account Verification ( boolax.com )';
            $message_body = 'Hello ' . $firstname . ',

        Thank you for signing up!

        Please click this link to activate your account:

        http://localhost/boolax/verify.php?email=' . $email . '&password=' . $password . '>Hello ' . $firstname . ',

        Thank you for signing up!

        Please click this link to activate your account:

        http://localhost/boolax/verify.php?email=' . $email . '&password=' . $password;

            $mail = new PHPMailer;

//Tell PHPMailer to use SMTP
            $mail->isSMTP();

//Enable SMTP debugging
// 0 = off (for production use)
// 1 = client messages
// 2 = client and server messages
            $mail->SMTPDebug = 2;

//Ask for HTML-friendly debug output
            $mail->Debugoutput = 'html';

//Set the hostname of the mail server
            $mail->Host = 'smtp.gmail.com';
// use
// $mail->Host = gethostbyname('smtp.gmail.com');
// if your network does not support SMTP over IPv6
//Set the SMTP port number - 587 for authenticated TLS, a.k.a. RFC4409 SMTP submission
            $mail->Port = 587;

//Set the encryption system to use - ssl (deprecated) or tls
            $mail->SMTPSecure = 'tls';

//Whether to use SMTP authentication
            $mail->SMTPAuth = true;

//Username to use for SMTP authentication - use full email address for gmail
            $mail->Username = 'ogeniuspriority@gmail.com';

//Password to use for SMTP authentication
            $mail->Password = 'Akarusho_4002';

//Set who the message is to be sent from
            $mail->setFrom('ogeniuspriority@gmail.com', 'Boolax');

//Set an alternative reply-to address
            $mail->addReplyTo('rutacris21@gmail.com', 'cris ruta');

//Set who the message is to be sent to
            $mail->addAddress($email, $name);

//Set the subject line
            $mail->Subject = $subject;

//Read an HTML message body from an external file, convert referenced images to embedded,
//convert HTML into a basic plain-text alternative body
            $mail->isHTML(true);
            $mail->Body = '<html>
            <head>
            <meta http-equiv = "Content-Type" content = "text/html; charset=iso-8859-1">
            <title>PHPMailer</title>
            </head>
            <body>
            <div style = "width: 640px; font-family: Arial, Helvetica, sans-serif; font-size: 11px;">
            <h1>This is a test of PHPMailer.</h1>
            <div align = "center">
            <a href = "https://github.com/PHPMailer/PHPMailer/">
            <img src = "images/phpmailer.png" height = "90" width = "340" alt = "PHPMailer rocks">
            </a>
            </div>
            <p>hello ' . $firstname . ',
            Thank you for signing up!
            Please click this link to activate your account:

            http://localhost/boolax/verify.php?email=' . $email . '&password=' . $password . '>Hello ' . $firstname . ',

            Thank you for signing up!
            Please click this link to activate your account:

            http://localhost/boolax/verify.php?email=' . $email . '&password=' . $password . '</p>
            </div>
            </body>
            </html>
            ';

//Replace the plain text body with one created manually
            $mail->AltBody = $message_body;

//Attach an image file
            $mail->addAttachment('images/icons/google-plus.png');

//send the message, check for errors
            if (!$mail->send()) {
                echo "Mailer Error: " . $mail->ErrorInfo;
            } else {
                echo "Message sent!";
            }
        }
    }
}
// it will never let you open index(login) page if session is set
if (!isset($_SESSION['user'])) {
    ?>
    <!DOCTYPE html>
    <!--
    To change this license header, choose License Headers in Project Properties.
    To change this template file, choose Tools | Templates
    and open the template in the editor.
    -->
    <html>
        <head>
            <meta charset="UTF-8">

            <link href="style/bootstrap.min.css" rel="stylesheet">
            <!--            <link href="style/main.css" rel="stylesheet">-->

            <style>
                body{
                    height: 100vh;
                }
                footer {
                    background-color: #333;
                    color: #999; /* IE8 proofing */
                    color: rgba(255,255,255,.5);
                    text-align: center;
                    position: fixed;
                    width: 100%;
                    bottom: 0;
                }
                /* Start the vertical centering */

                /* Handle the widths */
                footer {
                    width: 100%; /* Must be percentage or pixels for horizontal alignment */
                }
                .outer{
                    width: 100%;
                    height: 100%;
                    background-color:rgba(255,0,0,0.3); 
                    background-size: cover; 
                    background-position: center;
                    padding: 0px;
                    margin: 0px;
                    display: table;
                }
                .front-text {
                    display: table-cell;
                    vertical-align: middle;
                    padding: 0 20px;
                }
                .front-text .btn {

                    padding: 10px 20px;
                    font-weight: bold;
                }
                .bottom-text {

                }
                .bottom-text .btn {
                    width: 100px;
                    margin: 5px 10px;
                    padding: 10px 20px;
                    font-weight: normal;
                }
                .facebook-btn{
                    background-color: #337ab7;
                }
                .gmail-btn{
                    background-color: #d43f3a;
                }
                .front-column{
                    display: table-column;
                }
                .inner {


                    padding: 10px;
                }
                section{
                    width: 100%;
                    height: calc(100% - 102px);
                    margin: -20px 0px 0px 0px;
                    padding: 0px;
                    overflow: auto;
                    color: #ffffff;
                    text-align: center;
                    background-image: url("images/background1.svg");
                    vertical-align: middle;
                    background-position: center;
                    background-size: 100% auto;
                    background-origin: content-box;
                    background-repeat: no-repeat;
                }
                footer option{
                    color: black;
                }
            </style>

            <title>Boolax</title>
        </head>
        <body>
            <nav class="navbar navbar-default"> 
                <div class="container-fluid"> <!-- Brand and toggle get grouped for better mobile display --> 
                    <div class="navbar-header"> 
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span> 
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span> 
                            <span class="icon-bar"></span> 
                        </button>
                        <a class="navbar-brand" href="#">Boolax</a> 
                    </div >
                    <!-- Collect the nav links, forms, and other content for toggling --> 
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> 
                        <form method="post" id="loginForm" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" class="navbar-form  navbar-right" >

                            <div class="form-group"> 
                                <label for="loginEmail">Email address</label>
                                <input type="email" class="form-control" id="loginEmail" name="loginEmail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder="Email"> 
                            </div> 
                            <div class="form-group"> 
                                <label for="loginPassword">Password</label> 
                                <input type="password" class="form-control" id="loginPassword" name="loginPassword" placeholder="Password">  
                                <a href="#" data-toggle="modal" data-target="#resetModal" class="tooltip-bottom" title="Did you forget your credentials?">
                                    <img alt="help" id="passwordHelp" src="images/icons/ic_help_outline_black_18dp.png"></a>
                            </div> 

                            <button type="submit" name="loginBtn" class="bottom btn btn-default">Submit</button>
                        </form>
                        <div class="modal fade" id="resetModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
                            <div class="modal-dialog"> 
                                <div class="modal-content"> 
                                    <!-- Header--> 
                                    <div class="modal-header "> 
                                        <button type="button" class="close" data-dismiss="modal"> 
                                            <span aria-hidden="true">&times;</span> 
                                            <span class="sr-only">Close</span> 
                                        </button>
                                        <h4 class="modal-title"> Reset password? </h4>
                                    </div>
                                    <!-- Body -->
                                    <form name="resetForm" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post" id="resetForm">
                                        <div class="modal-body"> 
                                            <div class="">
                                                <div class="form-group col-md-6"> 
                                                    <label for="resetEmail">Email address</label>
                                                    <input type="email" class="form-control" id="resetEmail" name="resetEmail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder="Email"> 
                                                </div>

                                                <div class="form-group col-md-6"> 
                                                    <label for="resetpassword">New Password</label>
                                                    <input required name="resetPassword1" type="password" class="form-control inputpass" autocomplete="off"  minlength="4" placeholder="Enter password" id="resetPassword1" title="Passwords must be above 4 characters contain at least a number, and a capital letter" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$"  />
                                                </div>
                                                <div class="form-group col-md-6"> 
                                                    <label for="resetPassword2">New Password</label>
                                                    <input required name="resetPassword2" type="password" class="form-control inputpass" minlength="4" placeholder="Enter again to validate"  id="resetPassword2" onkeyup="checkResetPass();return false;" />
                                                    <div><small><span id="resetMessage"></span></small></div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Footer --> 
                                        <div class="modal-footer"> 
                                            <button type="button" id="reg-cancel" class="btn btn-default" data-dismiss="modal">Cancel
                                            </button> 
                                            <button id="resetBtn" class="btn btn-primary" type="submit" name="resetBtn">Reset
                                            </button> 

                                        </div>
                                    </form>
                                </div> 
                            </div> 
                        </div>

                    </div>


                </div><!-- /.navbar-collapse --> 

            </nav>
            <section>
                <div class="outer">
                    <div class="inner front-text">
                        <h1><b>BOOLAX</b></h1>
                        <p class="lead">Join Us, meet beautiful people<br> be connected to people and events near you!</p>
                        <p class="lead">
                            <button class="btn btn-primary" data-toggle="modal" data-target="#registerModal" id="getStarted">
                                LET'S GET STARTED
                            </button>
                        </p>



                        <div class = "inner bottom-text">
                            <p>use social media to log in</p>
                            <button class = "btn  facebook-btn">FACEBOOK</button><button class = "btn gmail-btn">GMAIL</button>
                        </div>
                    </div>
                </div>
            </section>
            <div class = "modal fade" id = "registerModal" tabindex = "-1" role = "dialog" aria-labelledby = "myModalLabel" aria-hidden = "true">
                <div class = "modal-dialog">
                    <div class = "modal-content">
                        <!--Header-->
                        <div class = "modal-header ">
                            <button type = "button" class = "close" data-dismiss = "modal">
                                <span aria-hidden = "true">&times;
                                </span>
                                <span class = "sr-only">Close</span>
                            </button>
                            <h4 class = "modal-title"> Welcome </h4>
                        </div>
                        <!--Body -->
                        <form name = 'registration' action = "<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method = "post" id = "registrationForm" >
                            <div class = "modal-body">
                                <div>
                                    <div class = "form-group col-sm-4">
                                        <label for = "first_name" class = "control-label">First name:</label>
                                        <input class = "form-control" type = "text" name = "ufirstname" id = "ufirstname" pattern = "[a-zA-Z0-9]{1,25}" required />
                                    </div>
                                    <div class = "form-group col-sm-4">
                                        <label for = "last_name" class = "control-label" >Last Name:</label>
                                        <input class = "form-control" type = "text" name = "ulastname" id = "ulastname" pattern = "[a-zA-Z0-9]{1,25}" required />
                                    </div>
                                    <div class = "form-group col-sm-4">
                                        <label for = "uusername" class = "control-label" >Username:</label><small><span id = "errUsern" class = "errUsern"></span></small>
                                        <input class = "form-control" type = "text" name = "uusername" id = "uusername" pattern = "[a-zA-Z0-9]{1,25}" placeholder = "minimum 6 letters" required />
                                    </div>
                                </div>
                                <div>
                                    <div class = "form-group col-sm-6">
                                        <label for = "gender" class = "control-label"> Gender</label>
                                        <select id = "gender" class = "form-control selectpicker" name = "ugender" required = "">
                                            <option value = "" name = "gender" selected>choose</option>
                                            <option value = "male" name = "gender">Male</option>
                                            <option value = "Female" name = "gender">Female</option>
                                        </select>
                                    </div>
                                    <div class = "form-group col-sm-6">
                                        <label for = "datepicker" class = "control-label">Birthday</label>
                                        <input type = "date" id = "ubirthdate" name = "ubirthdate" placeholder = "DD/MM/YYYY" class = "form-control" pattern = "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" title = "Format: DD/MM/YYYY" required/>


                                    </div>
                                </div>
                                <div>
                                    <div class = "form-group col-sm-4">


                                        <label for = "ucontry" class = "control-label">Country:</label>
                                        <select id = "ucountry" class = "form-control" name = "ucountry" required>
                                            <option value = "" selected>choose</option>
                                            <option value = "rwanda" selected>Rwanda</option>
                                        </select>
                                    </div>
                                    <div class = "form-group col-sm-4">
                                        <label for = "uprovince" class = "control-label">Province:</label>
                                        <select id = "uprovince" class = "form-control" name = "uprovince" required>
                                            <option value = "" selected>choose</option>
                                            <option value = "eastern" >Eastern</option>
                                            <option value = "western">Western</option>
                                            <option value = "northern">Northern</option>
                                            <option value = "southern">Southern</option>
                                            <option value = "city">Kigali</option>
                                        </select>
                                    </div>
                                    <div class = "form-group col-sm-4">
                                        <label for = "udistrict" class = "control-label">District:</label>
                                        <select id = "udistrict" class = "form-control" name = "udistrict" required>
                                            <option value = "" selected>choose</option>
                                        </select>
                                    </div>

                                </div>
                                <div>
                                    <div class = "form-group col-sm-6">
                                        <label for = "umail" class = "control-label">Email:</label><small><span id = "errMail" class = "errMail"></span></small>

                                        <input type = "email" class = "form-control" id = "umail" name = "umail" pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required/>
                                    </div>
                                    <div class = "form-group col-sm-6">
                                        <label for = "uphone" class = "control-label">Phone:</label>
                                        <input id = "uphone" class = "form-control phone" maxlength = "17" required type = "tel" pattern = "[\(][\+]\d{3}[\)]\d{2}[\-]\d{3}[\-]\d{4}" name = "uphone" placeholder = "(+250)78-888-8888" title = "Tel Format:(+250)78-888-8888">
                                    </div>
                                </div>
                                <div>

                                    <div class = "form-group col-sm-6">
                                        <label for = "upassword" class = "control-label">Password:
                                        </label>
                                        <input required name = "upassword" type = "password" class = "form-control inputpass" autocomplete = "off" minlength = "4" placeholder = "Enter password" id = "upassword" title = "Passwords must be above 4 characters contain at least a number, and a capital letter" pattern = "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$" />
                                        <small><span id = "errPass" class = "errPass"></span></small>
                                    </div>
                                    <div class = "form-group col-sm-6">
                                        <label for = "confirm_password" class = "control-label"> Re-type password:
                                        </label>
                                        <input required name = "password" type = "password" class = "form-control inputpass" minlength = "4" placeholder = "Enter again to validate" id = "upassword2" onkeyup = "checkPass();return false;" />
                                        <small><span id = "confirmMessage" class = "confirmMessage"></span></small>
                                    </div>
                                </div>
                            </div>
                            <!--Footer -->
                            <div class = "modal-footer">
                                <button type = "button" id = "reg-cancel" class = "btn btn-default" data-dismiss = "modal">Cancel
                                </button>
                                <button id = "registerBtn" class = "btn btn-primary" type = "submit" name = "registerBtn">
                                    Register
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <footer>
                <div class = "inner">
                    <div class = "row">
                        <div class = "col-sm-10">
                            <p>This platform <a href = "http://boolax.com">Boolax</a>, was developed by <a href = "https://ogeniuspriority.com">O'Genius Priority ltd</a>.</p>
                        </div>
                        <div class="col-sm-2">
                            <label for="language" class="col-sm-6" > Language</label>
                            <select class="col-sm-4" id="language" name="language" style="color: black; ">
                                <option value="choose" name="gender" selected >En</option>
                                <option value="fr">Fr</option>
                                <option value="Kiny">Kiny</option>
                            </select>  
                        </div>
                    </div>
                </div>
            </footer>
            <script src="js/jquery-3.2.1.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/main.js"></script>
        </body>
    </html>
    <?php
} else {
    header("Location: main_page.php");
}