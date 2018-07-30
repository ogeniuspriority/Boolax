/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var usernValid;
var emailValid;
var birthdateValid;
var passValid;
var loginEmailValid;
var loginPasswordValid;
var resetEmailValid;
var resetpassValid;
var changeMailValid;



$(function () {



    $("#uprovince").change(function () {

        var $dropdown = $(this);
        $.getJSON("data.json", function (data) {

            var key = $dropdown.val();
            var vals = [];
            switch (key) {
                case 'eastern':
                    vals = data.eastern.split(",");
                    break;
                case 'western':
                    vals = data.western.split(",");
                    break;
                case 'northern':
                    vals = data.northern.split(",");
                    break;
                case 'southern':
                    vals = data.southern.split(",");
                    break;
                case 'city':
                    vals = data.city.split(",");
                    break;
            }

            var $jsontwo = $("#udistrict");
            $jsontwo.empty();
            $.each(vals, function (index, value) {
                $jsontwo.append("<option>" + value + "</option>");
            });
        });
    });
});
$(document).ready(function () {

    $("#umail").on('blur', function (event) {


        $.ajax({
            async: true,
            url: "checkMail.php",
            data: 'email=' + $("#umail").val(),
            type: "POST",
            success: function (data) {
                if (data === "0") {
                    $("#umail").focus();
                    $("#errMail").html('<small class="text-danger">Taken</small>');
                    emailValid = 0;
                } else {
                    $("#errMail").html(data);
                    emailValid = 1;
                }
            },
            error: function () {
                $("#errMail").html('<span class="text-danger"><small>Error occured</small></span>');
            }
        });
    });
});
$(document).ready(function () {
    $("#uusername").on('blur', function (event) {
        $.ajax({
            async: true,
            url: "checkUsern.php",
            data: 'username=' + $("#uusername").val(),
            type: "POST",
            success: function (data) {
                if (data === "0") {
                    $("#uusername").focus();
                    $("#errUsern").html('<small class="text-danger">Taken</small>');
                    usernValid = 0;
                } else {
                    $("#errUsern").html(data);
                    usernValid = 1;
                }
            },
            error: function () {
                $("#errUsern").html('<span class="text-danger"><small>Error occured</small></span>');
            }
        });
    });
});
$(document).ready(function () {
    $("#ubirthdate").on('blur', function (event) {
        if (calculateAge(new Date($("#ubirthdate").val())) < 18) {
            $("#ubirthdate").val("under Aged");
            birthdateValid = 0;
            alert("You are under aged for this platform");
        } else if (calculateAge(new Date($("#ubirthdate").val())) > 100) {
            birthdateValid = 0;
            $("#ubirthdate").val("Impossible");
            $("#ubirthdate").focus();
        } else {
            birthdateValid = 1;
        }
    });
});
function calculateAge(birthday) {
    var ageDifMS = Date.now() - birthday.getTime();
    var ageDate = new Date(ageDifMS);
    return Math.abs(ageDate.getUTCFullYear() - 1970);
}

$(document).ready(function () {
    $("#registrationForm").on('submit', function (event) {
        if (usernValid === 0 || emailValid === 0 || birthdateValid === 0 || passValid === 0) {

            alert("Check your input! Something is wrong!");
            event.preventDefault();
        }

    });
});
function checkPass()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('upassword');
    var pass2 = document.getElementById('upassword2');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if (pass1.value === pass2.value) {
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        pass2.style.borderColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match";
        passValid = 1;
    } else {
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.borderColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!";
        passValid = 0;
    }
}
$(document).ready(function () {
    $("#loginEmail").on('blur', function (event) {

        $.ajax({
            async: true,
            url: "checkLoginMail.php",
            data: 'email=' + $("#loginEmail").val(),
            type: "POST",
            success: function (data) {
                if (data === "0") {
                    $("#loginEmail").focus();
                    $("#loginEmail").css('borderColor', 'red');
                    loginEmailValid = 0;
                } else {
                    $("#loginEmail").css('borderColor', 'lightBlue');
                    loginEmailValid = 1;
                }
            },
            error: function () {
                $("#loginEmail").html('<span class="text-danger"><small>Error occured</small></span>');
            }
        });
    });
});
$(document).ready(function () {
    $("#loginForm").on('submit', function (event) {
        if (loginEmailValid === 0) {
            $("#loginEmail").focus();
            $("#loginEmail").text("wrong Email");
            event.preventDefault();
        }


    });
});
$(document).ready(function () {
    $("#resetEmail").on('blur', function (event) {

        $.ajax({
            async: true,
            url: "checkLoginMail.php",
            data: 'email=' + $("#resetEmail").val(),
            type: "POST",
            success: function (data) {
                if (data === "0") {
                    $("#resetEmail").focus();
                    $("#resetEmail").css('borderColor', 'red');
                    resetEmailValid = 0;
                } else {
                    $("#loginEmail").css('borderColor', 'blue');
                    resetEmailValid = 1;
                }
            },
            error: function () {
                $("#resetEmail").html('<span class="text-danger"><small>Error occured</small></span>');
            }
        });
    });
});
function checkResetPass()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('resetPassword1');
    var pass2 = document.getElementById('resetPassword2');
    //Store the Confimation Message Object ...
    var message = document.getElementById('resetMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if (pass1.value === pass2.value) {
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        pass2.style.borderColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match";
        resetpassValid = 1;
    } else {
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.borderColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!";
        resetpassValid = 0;
    }
}

$(document).ready(function () {
    $("#resetForm").on('submit', function (event) {
        if (resetEmailValid === 0 || resetpassValid === 0) {
            $("#resetEmail").focus();
            $("#resetEmail").text("No such email!");
            event.preventDefault();
        }


    });
});
$(document).ready(function () {

    $('ul.tabs li').click(function () {
        var tab_id = $(this).attr('data-tab');
        $('ul.tabs li').removeClass('current');
        $('.tab-content').removeClass('current');
        $(this).addClass('current');
        $("#" + tab_id).addClass('current');
    });
});
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
});
// activation panel  
function showModal() {
    $('#activateModal').css('display', 'block');
}
// toggle change mail form
// 
function toggleChangeMail() {
    $("#changeMailForm").css('display', 'block');
}

// check if Change email does not already exist

$(document).ready(function () {
    $("#changeMail").on('blur', function (event) {

        $.ajax({
            async: true,
            url: "checkLoginMail.php",
            data: 'email=' + $("#changeMail").val(),
            type: "POST",
            success: function (data) {
                if (data === "1") {
                    $("#changeMail").focus();
                    $("#changeMail").css('borderColor', 'red');
                    $("#errChangeMail").text("Email already taken");
                    changeMailValid = 0;
                } else
                    changeMailValid = 1;
            },
            error: function () {
                $("#changeMail").html('<span class="text-danger"><small>Error occured</small></span>');
            }
        });
    });
});
// 
$(document).ready(function () {
    $("#changeMailForm").on('submit', function (event) {
        if (changeMailValid === 0) {
            event.preventDefault();
        }
    });
});
// resend mail button

$(document).ready(function () {
    $("#resendBtn").on('click', function (event) {
        $(".loader").css('visibility', 'visible');
        $("#resendBtn").addClass("disabled");
        $.ajax({
            async: true,
            url: "sendMail.php",
            data: 'email=' + $("#resendMail").text(),
            type: "POST",
            success: function (data) {
                if (data === "Message sent!") {
                    window.location.assign('main_page.php');
                    alert("Successfully sent");
                    $("#successMessage").text("Successfully sent");
                    $(".loader").css('visibility', 'hidden');
                    $("#resendBtn").removeClass("disabled");
                } else {
                    alert("Not sent");
//                    window.location.assign('main_page.php');
                }
            },
            error: function () {
                alert("Error occured");
                $("#resetEmail").html('<span class="text-danger"><small>Error occured</small></span>');
            }
        });
    });
});
// main navigation

$('#favorite-link').click(function () {
    $('#wrapper').load('include/favorite.php');
    return false;
});
$('#chat-link').click(function () {

    $('#wrapper').load('include/chat.php');
    loadMessages();
    return false;
});
function loadMessages() {

    $.ajax({
        async: true,
        url: "messages.php", //the script to call to get data 

        data: "", //you can insert url argumnets here to pass to api.php
        //for example "id=5&parent=6"
        type: "POST",
        dataType: "json",
        success: function (data)          //on recieve of reply
        {
            if (data.length > 0) {
                var theNanString = "";
                $.each(data, function (idx, obj) {


                    theNanString += "<ul class='chat-list-item' onclick='viewDetails(" + obj.boo_users_id + ");'><li class='chat-list-item-avatar'><img src='images/users_files/" + obj.boo_users_id + "/avatar-icon.jpg' class='avatar-icon'>"
                            + "</li><li class='chat-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span><br><i><span class='message-meta'>" + obj.boo_chat_message_message + "</span></i></li><li class='chat-list-item-notif'><span class='badge'>3</span></li></ul>";

                });
                $('#chat-sideBar-list').html(removeNanShit(theNanString));
            } else {
                $('#chat-sideBar-list').html("<p style='text-align:center; padding-top:6px'> Looks like it's blank here! </p>");

            }

        },
        error: function () {
            $('#sideBar-list').html("<p style='text-align:center; padding-top:6px'>could not load data!</p>");
        }

    });
    return false;
}
function loadMessageRecipient() {

    $.ajax({
        async: true,
        url: "messageRecipient.php", //the script to call to get data 

        data: "", //you can insert url argumnets here to pass to api.php
        //for example "id=5&parent=6"
        type: "POST",
        dataType: "json",
        success: function (data)          //on recieve of reply
        {
            if (data.length > 0) {
                var theNanString = "";
                $.each(data, function (idx, obj) {


                    theNanString += "<ul class='chat-list-item' onclick='viewDetails(" + obj.boo_users_id + ");'><li class='chat-list-item-avatar'><img src='images/users_files/" + obj.boo_users_id + "/avatar-icon.jpg' class='avatar-icon'>"
                            + "</li><li class='chat-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span></li></ul>";

                });
                $('.new-chat-modal-body').html(removeNanShit(theNanString));
            } else {
                $('.new-chat-modal-body').html("<p style='text-align:center; padding-top:6px'> Looks like it's blank here! </p>");

            }

        },
        error: function () {
            $('.new-chat-modal-body').html("<p style='text-align:center; padding-top:6px'>could not load data!</p>");
        }

    });
    return false;
}
$('#account-link').click(function () {

    $('#wrapper').load('include/account.php');
    return false;
});
// favorite navigation
function booLinkFx() {

    $('#favorite-wrapper').load('include/favorite/boo.php');
    $.ajax({
        async: true,
        url: "loadBoo.php", //the script to call to get data 

        data: "", //you can insert url argumnets here to pass to api.php
        //for example "id=5&parent=6"
        type: "POST",
        dataType: "json",
        success: function (data)          //on recieve of reply
        {
            if (data.length > 0) {
                var theNanString = "";
                $.each(data, function (idx, obj) {

                    var id = obj.boo_users_id;
                    var ilikeu = obj.boo_users_meet_meilikeu;
                    var wholiked = obj.boo_users_meet_wholiked;
                    var meetid = obj.boo_users_meet_id;
                    if (obj.boo_users_meet_wholiked !== id) {
                        if (obj.boo_users_meet_meilikeu === '1') {
                            theNanString += "<ul class='boo-list-item' onclick='viewDetails(" + id + ","+wholiked+"," + ilikeu + "); return false;'><li class='boo-list-item-avatar'><img src='images/users_files/" + id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='boo-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span><br><span class='location-meta'>" + obj.boo_users_province + "," + obj.boo_users_district + "</span></li><span class='boo-list-item-indicator' style='background-color: #428bca;'>YOU LIKED</span><li class='boo-list-age'><i><span class='age-meta'>" + obj.boo_users_age + "</span> years old</i></li></ul>";
                        } else if (obj.boo_users_meet_ulikeme === '1') {
                            theNanString += "<ul class='boo-list-item' onclick='viewDetails(" + id + ","+wholiked+");'><span class='boo-list-item-indicator' style='background-color: #428bca;'>BEEN LIKED</span><li class='boo-list-item-avatar'><img src='images/users_files/" + id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='boo-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span><br><span class='location-meta'>" + obj.boo_users_province + "," + obj.boo_users_district + "</span></li><span class='boo-list-item-indicator' style='background-color: #428bca;'>YOU'VE BEEN LIKED</span><li class='boo-list-age'><i><span class='age-meta'>" + obj.boo_users_age + "</span> years old</i></li></ul>";
                        } else if (obj.boo_users_meet_melikeignored === '1') {
                            theNanString += "<ul class='boo-list-item' onclick='viewDetails(" + id + ","+wholiked+");'><span class='boo-list-item-indicator' style='background-color: red;'>PASSED ON</span><li class='boo-list-item-avatar'><img src='images/users_files/" + id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='boo-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span><br><span class='location-meta'>" + obj.boo_users_province + "," + obj.boo_users_district + "</span></li><span class='boo-list-item-indicator' style='background-color: RED;'>PASSED ON</span><li class='boo-list-age'><i><span class='age-meta'>" + obj.boo_users_age + "</span> years old</i></li></ul>";
                        } else {

                            theNanString += "<ul class='boo-list-item' onclick='viewDetails(" + id + ","+wholiked+");'><li class='boo-list-item-avatar'><img src='images/users_files/" + id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='boo-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span><br><span class='location-meta'>" + obj.boo_users_province + "," + obj.boo_users_district + "</span></li><li class='boo-list-age'><i><span class='age-meta'>" + obj.boo_users_age + "</span> years old</i></li></ul>";
                        }
                    } else {
                        if (obj.boo_users_meet_ulikeme === '1') {
                            theNanString += "<ul class='boo-list-item' onclick='viewDetails(" + id + ","+wholiked+"," + ilikeu + "); return false;'><li class='boo-list-item-avatar'><img src='images/users_files/" + id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='boo-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span><br><span class='location-meta'>" + obj.boo_users_province + "," + obj.boo_users_district + "</span></li><span class='boo-list-item-indicator' style='background-color: #428bca;'>LIKED</span><li class='boo-list-age'><i><span class='age-meta'>" + obj.boo_users_age + "</span> years old</i></li></ul>";
                        } else if (obj.boo_users_meet_meilikeu === '1') {
                            theNanString += "<ul class='boo-list-item' onclick='viewDetails(" + id + ","+wholiked+");'><span class='boo-list-item-indicator' style='background-color: #428bca;'>YOU'VE BEEN LIKED</span><li class='boo-list-item-avatar'><img src='images/users_files/" + id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='boo-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span><br><span class='location-meta'>" + obj.boo_users_province + "," + obj.boo_users_district + "</span></li><li class='boo-list-age'><i><span class='age-meta'>" + obj.boo_users_age + "</span> years old</i></li></ul>";
                        } else if (obj.boo_users_meet_melikeignored === '1') {
                            theNanString += "<ul class='boo-list-item' onclick='viewDetails(" + id + ","+wholiked+");'><span class='boo-list-item-indicator' style='background-color: red;'>PASSED ON</span><li class='boo-list-item-avatar'><img src='images/users_files/" + id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='boo-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span><br><span class='location-meta'>" + obj.boo_users_province + "," + obj.boo_users_district + "</span></li><span class='boo-list-item-indicator' style='background-color: red;'>YOU'VE BEEN PASSED ON</span><li class='boo-list-age'><i><span class='age-meta'>" + obj.boo_users_age + "</span> years old</i></li></ul>";
                        } else {

                            theNanString += "<ul class='boo-list-item' onclick='viewDetails(" + id + ","+wholiked+");'><li class='boo-list-item-avatar'><img src='images/users_files/" + id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='boo-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span><br><span class='location-meta'>" + obj.boo_users_province + "," + obj.boo_users_district + "</span></li><li class='boo-list-age'><i><span class='age-meta'>" + obj.boo_users_age + "</span> years old</i></li></ul>";
                        }
                    }
                });
                $('#sideBar-list').html(removeNanShit(theNanString));
            } else {
                $('#sideBar-list').html("<p style='text-align:center; padding-top:6px'> Sorry, no boo for the moment! </p>");
            }

        },
        error: function () {
            $('#sideBar-list').html("<p style='text-align:center; padding-top:6px'>could not load data!</p>");
        }

    });
    return false;
}
function removeNanShit(theNanData) {
    var ans_ = theNanData.replace(/NaN/g, "");

    return ans_;
}

function groupLinkFx() {
    $('#favorite-wrapper').load('include/favorite/group.php');
    loadGroup();

    return false;
}
function loadGroup() {
    $.ajax({
        async: true,
        url: "loadGroup.php", //the script to call to get data 

        data: "", //you can insert url argumnets here to pass to api.php
        //for example "id=5&parent=6"
        type: "POST",
        dataType: "json",
        success: function (data)          //on recieve of reply
        {
            if (data.length > 0) {
                var theNanString = "";

                $.each(data, function (idx, obj) {
                    alert(obj.group_name);
                    var name = obj.group_name;
                    var id = obj.group_id;
                    var privacy = obj.group_privacy;
                    if (privacy === "private") {
                        theNanString += "<ul class='group-list-item' id='privacy-list-item' onclick='viewGroupDetails(" + id + ");'><li class='group-list-item-avatar'><img src='images/groups_files/" + name + "" + id + "/_group_avatar.jpg' alt='pp' class='avatar-icon'/></li><li class='group-list-item-metas'><span class='name-meta'>" + obj.group_name + "</span><br><span class='location-meta' id='location-meta'>" + obj.group_privacy + "</span></li><li class='group-list-members'><i><span class='age-meta'>" + obj.group_members_no + "</span></i></li></ul>";

                    } else {
                        theNanString += "<ul class='group-list-item' onclick='viewGroupDetails(" + id + ");'><li class='group-list-item-avatar'><img src='images/groups_files/" + name + "" + id + "/_group_avatar.jpg' alt='pp' class='avatar-icon'/></li><li class='group-list-item-metas'><span class='name-meta'>" + obj.group_name + "</span><br><span class='location-meta'>" + obj.group_privacy + "</span></li><li class='group-list-members'><i><span class='age-meta'>" + obj.group_members_no + "</span></i></li></ul>";
                    }
                });
                $('#group-sideBar-list').html(removeNanShit(theNanString));
            } else {
                $('#group-sideBar-list').html("<p style='text-align:center; padding-top:6px'>We could not find any group!</p>");
            }

        },
        error: function () {

            $('#group-sideBar-list').html("<p style='text-align:center; padding-top:6px'>could not load data!</p>");
        }

    });
}
$('#privacy-list-item').hover(function () {
    $('#location-meta').html("<p style='color: blue'>You were invited!</p>");
}, function () {
    $(this).css("background-color", "pink");
});


function eventLinkFx() {
    $('#favorite-wrapper').load('include/favorite/event.php');
    $.ajax({
        async: true,
        url: "loadEvent.php", //the script to call to get data 

        data: "", //you can insert url argumnets here to pass to api.php
        //for example "id=5&parent=6"
        type: "POST",
        dataType: "json",
        success: function (data)          //on recieve of reply
        {

            if (data.length > 0) {
                var theNanString = "";
                $.each(data, function (idx, obj) {
                    var id = obj.boo_event_name;
                    theNanString += "<ul class='event-list-item' onclick='viewDetails(" + id + ");'><li class='event-list-item-avatar'><img src='images/group_files/" + id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='event-list-item-metas'><span class='name-meta'>" + obj.boo_event_name + "</span><br><span class='location-meta'>" + obj.boo_event_place + "</span></li><li class='event-list-members'><i><span class='age-meta'>" + obj.boo_event_peoplegoing + "</span></i></li></ul>";
                });
                $('#event-sideBar-list').html(removeNanShit(theNanString));
            } else {


                $('#event-sideBar-list').html("<p style='text-align:center; padding-top:6px'>We could not find any event!</p>");

            }

        },
        error: function () {

            $('#event-sideBar-list').html("<p style='text-align:center; padding-top:6px'>could not load data!</p>");
        }

    });
    return false;
}

function viewDetails(id, ilikeu) {
    $('.progress-container').css('display', 'block');
    if (ilikeu === 1) {
        $.ajax({
            async: true,
            url: "loadBooDetails.php", //the script to call to get data 

            data: 'id=' + id + '&username=' + 'the', //you can insert url argumnets here to pass to api.php
            //for example "id=5&parent=6"
            dataType: "json",
            type: "POST",
            success: function (data)          //on recieve of reply
            {
                $.each(data, function (idx, obj) {
                    $('#details').html("<p style='text-align:center'>wait for response from <i><b>" + obj.boo_users_username + "</i></b> <br>to be able to be in contact<br><br><button class='btn btn-primary'>say hi!</button></p>");
                });
                $('.progress-container').css('display', 'none');
            },
            error: function () {
                $('#details').html("<p>could not load data!</p>");
                $('.progress-container').css('display', 'none');
            }
        });

    } else {
        $.ajax({
            async: true,
            url: "loadBooDetails.php", //the script to call to get data 

            data: 'id=' + id, //you can insert url argumnets here to pass to api.php
            //for example "id=5&parent=6"
            type: "POST",
            dataType: "json",
            success: function (data)          //on recieve of reply
            {
                var theNanString = "";
                $.each(data[1], function (idx, obj) {
                    theNanString = "<ul class='page-header' style='margin:0px; list-style: none; display: flex; flex-direction: row; justify-content: space-between; align-items: center; '><li><h3  class='boo-det-username' id='boo-det-username' >" + obj.boo_users_username + "</h3></li><li class='btn-group row' style='width: 300px;'><div class='container-fluid'><button class='btn btn-default col-md-6' name='btn-boo-passon' onclick='passBoo();' id='btn-boo-passon'>PASS ON</button></span><span><button class='btn btn-primary col-md-6' name='btn-boo-like' onclick='likeboo(" + id + ");' id='btn-boo-like'>LIKE</button></div></li></ul>"

                            + "<div class='row'><div class='col-md-2 boo-det-profile'><img src='images/users_files/" + id + "/main-thumb-1.png' id='boo-det-profile' style='width:auto; height: 150px;' alt='profile picture'/>"
                            + "</div><ul class='col-md-5 boo-det-info'><li><span class=''><b>Full names:</b></span><span  id='boo-det-fullname'>" + obj.boo_users_firstname + " " + obj.boo_users_lastname + "</span>"
                            + "</li><li><b> Age: </b> <span class='' id='boo-det-age'>" + obj.boo_users_age + "</span></li><li><span class=''><b>Username:</b></span><span class='boo-det-username' id='boo-det-username'>" + obj.boo_users_username + "</span>"
                            + "</li><li><b> Location: </b><span class='' id='boo-det-location'>" + obj.boo_users_province + ", " + obj.boo_users_district + "</span></li></ul><div class='col-md-5'><span><h4>Some pictures...</h4></span><ul id='boo-det-gallery'>"
                            + "<li></li></ul></div></div><div><ul id='myTabs' class='nav nav-tabs' role='tablist'><li role='presentation' class='active'><a href='#about' id='about-tab' role='tab' data-toggle='tab' aria-controls='about' aria-expanded='true'>"
                            + "About</a> </li><li role='presentation' class=''><a href='#map' id='map-tab' role='tab' data-toggle='tab' aria-controls='map' aria-expanded='true'>"
                            + "Map</a></li> </ul><div id='myTabContent' class='tab-content'><div role='tabpanel' class='tab-pane fade active in' id='about' aria-labelledby='about-tab'>"
                            + "<ul><li><b> Height:</b><span> </span><b>weight:</b><span></span></li><li><b>Skin Color:</b><span class=''></span></li><li><b> Interested in:</b><ul><li><b> Age range:</b><span> </span></li><li><b>Skin Color:</b><span> </span></li><li><b> Religion:</b><span> </span></li>"
                            + "<li><b> Education level:</b><span> </span></li><li><p><b>  Other :</b></p></li></ul></li><li></li></ul></div><div role='tabpanel' class='tab - pane fade active in' id='map' style='height: 100% ; width: 100% 'aria-labelledby='map-tab'>"
                            + "</div> </div></div>";
//                var src1 = "images/users_files/" + id + "/main-thumb-1.png";
//                $('#boo-det-profile').attr('src', src1);
//                $('.boo-det-username').text(obj.boo_users_username);
//                $('#boo-det-username').text(obj.boo_users_username);
//                $('#boo-det-fullname').text(obj.boo_users_firstname + "&nbsp" + obj.boo_users_lastname);
//                $('#boo-det-age').text(obj.boo_users_age);
//                $('#boo-det-location').text(obj.boo_users_province + ",&nbsp;" + obj.boo_users_district);
                    //Set output element html
                    //recommend reading up on jquery selectors they are awesome 
                    // http://api.jquery.com/category/selectors/

                });
                $('#details').html(removeNanShit(theNanString));
                var gal_list = "";
                var counter = 2;
                var src = "";
                $.each(data[0], function (idy, obj1) {
                    src = "images/users_files/" + id + "/gallery/" + data[0][counter];
                    gal_list += "<li><img class='gallery-img' src=" + src + " alt='photo' /></li>";
                    counter++;
                });
                $('#boo-det-gallery').html(gal_list);
                $('.progress-container').css('display', 'none');
            },
            error: function () {
                $('#details').html("<p>could not load data!</p>");
                $('.progress-container').css('display', 'none');
            }

        });
    }
    return false;
}

function viewGroupDetails(id) {

    $.ajax({
        async: true,
        url: "loadGroupDetails.php", //the script to call to get data 

        data: 'id=' + id, //you can insert url argumnets here to pass to api.php
        //for example "id=5&parent=6"
        type: "POST",
        dataType: "json",
        success: function (data)          //on recieve of reply
        {
            var theNanString = "";
            var theNanString1 = "";

            $.each(data[1], function (idx, obj) {

                if (obj.group_member_admin === "") {
                    theNanString = "<h3 class='page-header'>" + obj.group_name + "</h3><div class='row'><div class='container-fluid main-info'><div class='col-md-3 main-thumbnail' style=''>"
                            + "<img src='images/groups_files/" + obj.group_name + id + "/_group_avatar.jpg' id='boo-det-profile' style='width:auto; height: 150px;' alt='profile picture'/></div><div class='col-md-8'>"
                            + "<ul class='page-info'><li><span>Created by " + obj.group_username + "</span><br><span>tags: " + obj.group_tags + "</span>"
                            + "</li></ul>"
                            + "</div></div><div class=''><ul id='myTabs' class='nav nav-tabs' role='tablist'><li role='presentation' class='active'>"
                            + "      <a href='#members' id='members-tab' role='tab' data-toggle='tab' aria-controls='members' aria-expanded='true'>Members</a></li></ul>"
                            + "<div id='myTabContent' class='tab-content'><div role='tabpanel' class='tab-pane fade active in' id='members' aria-labelledby='members-tab'> "
                            + "      <p class='text-info'> You are not allowed to view this list<br> Join first!</p></div></div></div></div>";
                } else {
                    theNanString = "<h3 class='page-header'>" + obj.group_name + "</h3><div class='row'><div class='container-fluid main-info'><div class='col-md-3 main-thumbnail' style=''>"
                            + "<img src='images/groups_files/" + obj.group_name + id + "/_group_avatar.jpg' id='boo-det-profile' style='width:auto; height: 150px;' alt='profile picture'/></div><div class='col-md-8'>"
                            + "<ul class='page-info'><li><span>Created by group_member_admin " + obj.group_name + " </span><br><span>tags: " + obj.group_tags + "</span>"
                            + "</li><li> <button class='btn btn-primary' onclick='joingroup(" + id + ");'> JOIN </button></li></ul>"
                            + "</div></div><div class=''><ul id='myTabs' class='nav nav-tabs' role='tablist'><li role='presentation' class='active'>"
                            + "      <a href='#members' id='members-tab' role='tab' data-toggle='tab' aria-controls='members' aria-expanded='true'>Members</a></li></ul>"
                            + "<div id='myTabContent' class='tab-content'><div role='tabpanel' class='tab-pane fade active in' id='members' aria-labelledby='members-tab'> "
                            + "      <p class='text-info'> You are not allowed to view this list<br> Join first!</p></div></div></div></div>";

                }

                $.each(data[0], function (idx, obj) {
                    if (data[0].length === 0) {
                        theNanString1 = "You have to join in first to be able to view the members";
                    } else {
                        if (obj.group_member_admin === '1') {
                            theNanString1 += "<ul class='event-list-item'><li class='event-list-item-avatar'><img src='images/users_files/" + obj.group_member_id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='event-list-item-metas'><span class='name-meta'>" + obj.group_member_username + "</span></li><li class='event-list-members'><i><span class='age-meta'> admin </span></i></li></ul>";
                        } else {
                            theNanString1 += "<ul class='event-list-item'><li class='event-list-item-avatar'><img src='images/users_files/" + obj.group_member_id + "/avatar-icon.jpg' alt='pp' class='avatar-icon'/></li><li class='event-list-item-metas'><span class='name-meta'>" + obj.group_member_username + "</span></li></ul>";

                        }
                    }

                }
                );
            });






            $('#details').html(removeNanShit(theNanString));
            $('#members').html(removeNanShit(theNanString1));



        },
        error: function () {
            $('#details').html("<p>could not load data!</p>");
            $('.progress-container').css('display', 'none');
        }

    });
}
function joinGroup(name) {
    $.ajax({
        async: true,
        url: "joinGroup.php", //the script to call to get data 

        data: 'btnjoin=' + "join" + '&groupid=' + name, //you can insert url argumnets here to pass to api.php
        //for example "id=5&parent=6"
        type: "POST",
        success: function (data)          //on recieve of reply
        {
            if (data === "request sent") {

                $('#details').html("<p style='text-align:center'> you are in baby!<br> you can start chatting in message tab <br><b>or, </b>just click here <button class='btn btn-primary'>say hello!</button></p>");
            } else {
                $('#details').html("<p> Something went wrong!</p>");
            }

        },
        error: function () {
            $('#details').html("<p>could not pace like!</p>");
        }

    });
}
function Viewmembers() {
    $('.new-members-modal').css('display', 'block');
    $.ajax({
        async: true,
        url: "loadMembers.php", //the script to call to get data 

        data: "", //you can insert url argumnets here to pass to api.php
        //for example "id=5&parent=6"
        type: "POST",
        dataType: "json",
        success: function (data)          //on recieve of reply
        {
            var theNanString = "";
            var id;
            $.each(data, function (idx, obj) {
                id = obj.boo_users_id;
                theNanString += "<ul class='new-member-list-item'><li class='new-member-list-item-input'><input type='checkbox' name='new-member-list-item-input' value=" + id + " id='new-member-list-item-input'></li><li class='new-member-list-item-avatar'><img src='images/users_files/" + id + "/avatar-icon.jpg'  class='avatar-icon'/></li><li class='new-member-list-item-metas'><span class='name-meta'>" + obj.boo_users_username + "</span></li></ul>";
            });
            $('.new-members-modal-body').html(removeNanShit(theNanString));


        },
        error: function () {
            $('.new-members-modal-body').html("<p>could not load data!</p>");
        }

    });

}

function likeboo(id) {
    $.ajax({
        async: true,
        url: "likeBoo.php", //the script to call to get data 

        data: 'btnlike=' + "like" + '&booID=' + id, //you can insert url argumnets here to pass to api.php
        //for example "id=5&parent=6"
        type: "POST",
        success: function (data)          //on recieve of reply
        {

            $('#details').html("<p> you like this one! wait for response!");
            booLinkFx();

        },
        error: function () {
            $('#details').html("<p>could not pace like!</p>");
        }

    });

}
function passboo() {}

function addmedia() {

    $("#addmediaDialog").css({
        "bottom": "45px",
        "visibility": "visible",
        "z-index": "10"
    });

}
function addmessagerecipient() {


    $(".new-chat-modal").css({
        "left": "0px",
        "visibility": "visible"

    });
    loadMessageRecipient();

}
function cancelmessagerecipient() {
    $(".new-chat-modal").css({
        "left": "-300px",
        "visibility": "hidden"

    });
}

function selectmessage(){
    
    $(".chat-bubble").css('background','whitesmoke');
    $(".bubble-select").css('display','block');
    $(".chat-bubble").css('box-shadow','inset 1px 0px .5px .5px rgba(0,0,0,0.1)');
    $(".chat-header-options-more").css('visibility','visible');
    
}
function chatdropdown(){
    $(".chat-header-options-dropdown").css('visibility','visible');
}
//$(document).click(function(){
//    $(".chat-header-options-dropdown").css('visibility','hidden');
//});