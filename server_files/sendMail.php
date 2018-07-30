<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
session_start();
require 'classes/db.php';
date_default_timezone_set('Etc/UTC');
require 'classes/PHPMailerAutoload.php';
if(!empty($_POST["email"])) {
$to = $_POST['email'];
$send_result = $mysqli->query("SELECT boo_users_firstname, boo_users_lastname,boo_users_password FROM boo_users WHERE boo_users_email='$to';")or die($mysqli->error);


$send_user = $send_result->fetch_assoc();

$reg_subject = 'Account Verification ( boolax.com )';

$name = $send_user['boo_users_firstname'];
$send_pass = $send_user['boo_users_password'];
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
$mail->addAddress($to, $name);

//Set the subject line
$mail->Subject = $reg_subject;

//Read an HTML message body from an external file, convert referenced images to embedded,
//convert HTML into a basic plain-text alternative body
$mail->isHTML(true);
$mail->Body = '<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <title>Boolax</title>
</head>
<body>
<div style="width: 640px; font-family: Arial, Helvetica, sans-serif; font-size: 11px;">
  <h4>This is a mail verification.</h4>
  <div align="center">
    <a href="https://github.com/PHPMailer/PHPMailer/">
        <img src="images/phpmailer.png" height="90" width="340" alt="PHPMailer rocks">
    </a>
  </div>
  <p>Hello ' . $name . ',

        Thank you for signing up!

        Please click this link to activate your account:

        http://localhost/boolax/verify.php?email=' . $to . '&password=' . $send_pass . '</p>
            </div>
            </body>
            </html>
            ';

//Replace the plain text body with one created manually


//send the message, check for errors
if (!$mail->send()) {
    echo "Mailer Error: " . $mail->ErrorInfo;
} else {
    echo "Message sent!";
    
}
      
}  