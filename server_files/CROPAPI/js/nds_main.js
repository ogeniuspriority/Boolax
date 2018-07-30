function _(x) {
    return document.getElementById(x);
}

function togglePlayPause() {
    alert("ada");

}

var showHideState = true;

//$("#togglePlayPause").slideDown();
$("#video_win").mouseover(function() {
    if (showHideState) {
        $("#togglePlayPause").slideDown();
        showHideState = false;

    }
});

$("#togglePlayPause").mouseover(function(event) {
    //event.stopPropagation();
    showHideState = false;

});
$("#video_win").mousemove(function() {
    $("#togglePlayPause").show();
});
$("#video_win").mouseout(function() {

    if (!showHideState) {
        $("#togglePlayPause").delay(2000).fadeOut();
        showHideState = true;
    }
});
//------------
$("#togglePlayPause").click(function() {
    switch(_("videoPlayerStatus").value) {
        case "pause":
            _("togglePlayPause").src = "images/bigplay.png";
            _("videoPlayerStatus").value = "play";
            _("video_win").pause();

            break;
        case "play":
            _("togglePlayPause").src = "images/pause_o.jpg";
            _("videoPlayerStatus").value = "pause";
            _("video_win").play();

            break;
    }
});
//-----------
$("#video_win").click(function() {
    //alert(_("videoPlayerStatus").value);
    switch(_("videoPlayerStatus").value) {
        case "pause":
            _("togglePlayPause").src = "images/bigplay.png";
            _("videoPlayerStatus").value = "play";
            _("video_win").pause();

            break;
        case "play":
            _("togglePlayPause").src = "images/pause_o.jpg";
            _("videoPlayerStatus").value = "pause";
            _("video_win").play();

            break;
    }
});
//----------Choose opened tab view---panel_registration-----------------
$("#Individual").addClass("panel_registration_cliked");
//$("#Institution").addClass("panel_registration_cliked");
//$("#Officials").addClass("panel_registration_cliked");
//-------------
$("#individual_claim").fadeIn();
$("#institution_claim").hide();
$("#officials_claim").hide();
//---
$("#Individual").click(function() {
    $("#Individual").removeClass("panel_registration").addClass("panel_registration_cliked");
    $("#Institution").removeClass("panel_registration_cliked").addClass("panel_registration");
    $("#Officials").removeClass("panel_registration_cliked").addClass("panel_registration");
    //---------------------------------
    $("#institution_claim").fadeOut();
    $("#officials_claim").fadeOut();
    $("#individual_claim").fadeIn();

});
$("#Institution").click(function() {
    $("#Individual").removeClass("panel_registration_cliked").addClass("panel_registration");
    $("#Institution").removeClass("panel_registration").addClass("panel_registration_cliked");
    $("#Officials").removeClass("panel_registration_cliked").addClass("panel_registration");
    //------------------------------------------
    $("#individual_claim").fadeOut();
    $("#officials_claim").fadeOut();
    $("#institution_claim").fadeIn();
});
$("#Officials").click(function() {
    $("#Individual").removeClass("panel_registration_cliked").addClass("panel_registration");
    $("#Institution").removeClass("panel_registration_cliked").addClass("panel_registration");
    $("#Officials").removeClass("panel_registration").addClass("panel_registration_cliked");
    //------------------------------
    $("#individual_claim").fadeOut();
    $("#institution_claim").fadeOut();
    $("#officials_claim").fadeIn();
});
//----background smoothening
var currentImageHome = 0;
var currentImageIndexHome = 0;
var imagesHome = $('#bg_image_gallery_farm').find('img').map(function() {
    return this.src;
}).get();
//---
//alert(imagesHome.length);
function ogeniusGalleryHasRightHome(indexNow) {
    currentImageIndexHome = indexNow + 1;
    if (currentImageIndexHome < (imagesHome.length)) {
        return true;
    } else {
        currentImageIndexHome = 0;
        return false;
    }
}

function ogeniusMoveRightHome() {

    try {
        //StopOgeniusSlideTimer();
        if (ogeniusGalleryHasRightHome(currentImageIndexHome)) {
            //--------------------------------------
            window.setTimeout(function() {
                $("#bg_image_screen").fadeOut("slow");
                window.setTimeout(function() {
                    //----------------------
                    $("#bg_image_screen").fadeIn("slower");
                    //----------------------
                    //--------------------
                    _("bg_image_screen").src = imagesHome[currentImageIndexHome];
                    //--mark current image
                    //ogeniusGalleryCurrentImageDetector(_("slideShowViewer_image").src);
                }, 500);
            }, 500);

        } else {
            window.setTimeout(function() {
                $("#bg_image_screen").fadeOut("slow");
                window.setTimeout(function() {
                    //----------------------
                    $("#bg_image_screen").fadeIn("slower");
                    //----------------------
                    //--------------------
                    _("bg_image_screen").src = imagesHome[currentImageIndexHome];
                    //--mark current image
                    //ogeniusGalleryCurrentImageDetector(_("slideShowViewer_image").src);
                }, 500);
            }, 500);

        }
    } catch(err) {

    }
}

//----

var ogeniusIntervalTimer;
ogeniusIntervalTimer = window.setInterval(function() {
    //----------------
    if (_("home_page_2017")) {
        if (ogeniusGalleryHasRightHome(currentImageIndexHome)) {
            ogeniusMoveRightHome();
        } else {
            ogeniusMoveRightHome();
        }
    }

}, 5000);
//----------Datepicker--
$(function() {
    $('#pickBirthDay').datepicker({
        'scrollDefault' : 'now'
    });
});
$(function() {
    $('#pickBirthDay_second').datepicker({
        'scrollDefault' : 'now'
    });
});
//---
$(function() {
    $('#pickBirthDay_second_99').datepicker({
        'scrollDefault' : 'now'
    });
});
$(function() {
    $('#pickBirthDay_second_98').datepicker({
        'scrollDefault' : 'now'
    });
});
//---scrollToMagic by Cedro
/*$('html, body').animate({
 scrollTop: $("footer").offset().top
 }, 1000);*/
function scrollToRegWin() {
    $('html, body').animate({
        scrollTop : $("#CreateAccount_").offset().top
    }, 1000);
}

//------------
function openSignInWindow() {

    $("#loginFairy_popUp").css("visibility", "visible");
    $("#loginFairy_popUp").css("width", window.innerWidth + "px");
    _("loginFairy_popUp").style.top = 0 + "px";
    _("loginFairy_popUp").style.left = 0 + "px";
    $("#loginFairy_popUp").css("height", window.innerHeight + "px");
    $("#loginFairy_popUp").css("background", "rgba(0,200,200,0.5)");
    $("#loginFairy_popUp").css("text-align", "center");
    $("#loginFairy_popUp").fadeIn();
    //$("#loginFairy_popUp").delay(2000).fadeOut();
    $("#loginP").hide();
    $("#loginP").delay(500).slideDown("fast").animate({
        fontSize : '3em'
    }, "slow").delay(500).animate({
        fontSize : '1em'
    }, "slow");

}

function hideThisLog() {
    $("#loginFairy_popUp").fadeOut();
}

///---------------
function openVerificationWindow() {

    $("#registerFairy_popUp").css("visibility", "visible");
    $("#registerFairy_popUp").css("width", window.innerWidth + "px");
    _("registerFairy_popUp").style.top = 0 + "px";
    _("registerFairy_popUp").style.left = 0 + "px";
    $("#registerFairy_popUp").css("height", window.innerHeight + "px");
    $("#registerFairy_popUp").css("background", "rgba(0,200,200,0.5)");
    $("#registerFairy_popUp").css("text-align", "center");
    $("#registerFairy_popUp").fadeIn();
    //$("#loginFairy_popUp").delay(2000).fadeOut();
    $("#registerP").hide();
    $("#registerP").delay(500).slideDown("fast").animate({
        fontSize : '3em'
    }, "slow").delay(500).animate({
        fontSize : '1em'
    }, "slow");

}

// //---test this--
// openVerificationWindow();
//
// //--
// function hideThisRegister() {
// $("#registerFairy_popUp").fadeOut();
// }
//------------goback_no_log.php
function ajaxObj(meth, url) {

    var x = new XMLHttpRequest();

    x.open(meth, url, true);

    x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    return x;

}

function ajaxReturn(x) {

    if (x.readyState == 4 && x.status == 200) {

        return true;

    }

}

function goBackLink() {
    var ajax = ajaxObj("POST", "ajax_php_user_scripts/goback_no_log.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            window.location = "index.php";
        } else {
        }
    };
    ajax.send();

}

function textAreaAdjust(o) {
    o.style.height = "1px";
    o.style.height = (15 + o.scrollHeight) + "px";
}

var boxWidth = $("#notifications_panel_mainpop").width();
var isNotifyWinActive = false;
//------------------------
var theCurrentNotifiObject;
function notification_pop(obj) {
    main_page_notif_brief_me_now_cyuma_2017(obj.title);
    try {
        var p = $("#" + theCurrentNotifiObject);
        $("#mainpage_notification").removeClass("mainPageNotificationHeader_taken").addClass("mainPageNotificationHeader");
        $("#" + theCurrentNotifiObject + theCurrentNotifiObject).removeClass("notify_record_taken").addClass("notify_record");

    } catch(error) {

    }
    //-----------
    try {
        theCurrentNotifiObject = obj.id;
        var p = $("#" + theCurrentNotifiObject);
        $("#mainpage_notification").removeClass("mainPageNotificationHeader").addClass("mainPageNotificationHeader_taken");
        $("#" + theCurrentNotifiObject + theCurrentNotifiObject).removeClass("notify_record").addClass("notify_record_taken");

    } catch(error) {

    }

    //------
    isNotifyWinActive = true;
    var p = $("#" + obj.id);
    var position = p.position();
    //alert(position.top + "px");

    $("#notifications_panel_mainpop").css("visibility", "visible");
    //-------------------------------
    _("notifications_panel_mainpop").style.top = position.top + "px";
    //---------------------------
    //---------------------------------------------
    _("notifications_panel_mainpop").style.left = 340 + "px";
    //-----------------
    //$("#notifications_panel_mainpop").css("height", $("#notifications_panel_mainpop_notify").height() + "px");
    $("#notifications_panel_mainpop").css("width", 0 + "px");
    //-------------------------------
    $("#notifications_panel_mainpop").css("background", "rgba(255,255,255,1)");
    $("#notifications_panel_mainpop").css("text-align", "center");

    //-----------------------------------------
    $("#notifications_panel_mainpop").animate({
        width : 0
    });
    $("#notifications_panel_mainpop").animate({
        width : boxWidth
    });

    $("#notifications_panel_mainpop").css("border", "1px solid #0080FF");
    $("#notifications_panel_mainpop").css("border-radius", "5px");
    $('html, body').animate({
        scrollTop : $("#notifications_panel_mainpop").offset().top - $("#headerUpperNav").height() - 5
    }, 1000);
}

function hideThis_notifications_panel() {
    $("#notifications_panel_mainpop").animate({
        width : 0
    });
    $("#notifications_panel_mainpop").css("border-style", "none");
    //$("#notifications_panel_mainpop").fadeOut();
}

///-----------------------
var boxWidthMessages = $("#messages_panel_mainpop").width();
var MessagesisNotifyWinActive = false;
//------------------------
var tMob = false;
var theCurrentMessageObject;
function Messages_pop(obj, queryIf) {
    main_page_show_my_messages(obj.title, queryIf);
    try {
        var p = $("#" + theCurrentMessageObject);
        $("#mainpageMessage").removeClass("mainPageNotificationHeader_taken").addClass("mainPage_Message");
        $("#" + theCurrentMessageObject).removeClass("message_record_taken").addClass("message_record");
    } catch(error) {

    }
    //-----------
    try {
        theCurrentMessageObject = obj.id;
        var p = $("#" + theCurrentMessageObject);
        $("#mainpageMessage").removeClass("mainPage_Message").addClass("mainPageNotificationHeader_taken");
        $("#" + theCurrentMessageObject).removeClass("message_record").addClass("message_record_taken");
    } catch(error) {

    }
    //--------------

    MessagesisNotifyWinActive = true;
    $("#messages_panel_mainpop").css("height", "auto");
    tMob = true;
    var p = $("#" + obj.id);
    var position = p.position();
    //alert(position.top + "px");
    $("#messages_panel_mainpop").css("visibility", "visible");
    //-------------------------------

    _("messages_panel_mainpop").style.top = 350 + "px";
    //---------------------------
    //---------------------------------------------
    _("messages_panel_mainpop").style.left = 340 + "px";
    //-----------------
    //$("#notifications_panel_mainpop").css("height", $("#notifications_panel_mainpop_notify").height() + "px");
    $("#messages_panel_mainpop").css("width", 0 + "px");
    //-------------------------------
    $("#messages_panel_mainpop").css("background", "rgba(255,255,255,1)");
    $("#messages_panel_mainpop").css("text-align", "center");

    //-----------------------------------------
    $("#messages_panel_mainpop").animate({
        width : 0
    });
    $("#messages_panel_mainpop").animate({
        width : boxWidthMessages
    });

    $("#messages_panel_mainpop").css("border", "1px solid #0080FF");
    $("#messages_panel_mainpop").css("border-radius", "5px");
    $('html, body').animate({
        scrollTop : $("#messages_panel_mainpop").offset().top - $("#headerUpperNav").height() - 5
    }, 1000);
    //----------

    var tImeOut = window.setTimeout(function() {
        if (tMob) {

            /*MessagesisNotifyWinActive_finalize = true;
             var p = $("#" + "finalizeBtn");
             var position = p.position();
             //alert(position.top + "px");
             $("#message_panel_finalize").css("visibility", "visible");
             //-------------------------------

             _("message_panel_finalize").style.top = position.top + 30 + "px";
             //---------------------------
             //---------------------------------------------
             _("message_panel_finalize").style.left = 200 + "px";
             //-----------------
             //$("#notifications_panel_mainpop").css("height", $("#notifications_panel_mainpop_notify").height() + "px");
             $("#message_panel_finalize").css("width", 0 + "px");
             //-------------------------------
             $("#message_panel_finalize").css("background", "rgba(255,255,255,1)");
             $("#message_panel_finalize").css("text-align", "center");

             //-----------------------------------------
             $("#message_panel_finalize").animate({
             width : 0
             });
             $("#message_panel_finalize").animate({
             width : boxWidthMessages_finalize
             });

             $("#message_panel_finalize").css("border", "1px solid #0080FF");
             $("#message_panel_finalize").css("border-radius", "5px");
             $('html, body').animate({
             scrollTop : $("#message_panel_finalize").offset().top - $("#headerUpperNav").height() - 5
             }, 1000);
             */
        }
    }, 20000);

}

function hideThis_Messages_panel() {
    _("messages_panel_mainpop").innerHTML = "";
    $("#messages_panel_mainpop").animate({
        width : 0
    });
    $("#messages_panel_mainpop").css("border-style", "none");
    //$("#notifications_panel_mainpop").fadeOut();
}

///-----------------------
var boxWidthMessages_finalize = $("#message_panel_finalize").width();
var MessagesisNotifyWinActive_finalize = false;
//------------------------
function main_page_follow_up_query_hide() {
    $("#main_page_2017_followUp_query_cyuma").slideUp();
}

function main_page_follow_up_query(obj) {
    var p = $("#" + obj.id);
    var position = p.position();
    $("#main_page_2017_followUp_query_cyuma").css("visibility", "visible");
    _("main_page_2017_followUp_query_cyuma").style.top = position.top + 30 + "px";
    _("main_page_2017_followUp_query_cyuma").style.left = 100 + "px";
    $("#main_page_2017_followUp_query_cyuma").slideDown();
    //----------------------------follow this query-
    //----------all chatters except me haha!
    _("main_page_2017_followUp_query_cyuma_data").innerHTML = "<img src='images/loader_custom.gif' style='margin:auto;width:100px;height:100px;border-radius:20px;' />";
    //showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_followUpMyQuery_cyuma.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            _("main_page_2017_followUp_query_cyuma_data").innerHTML = "" + ajax.responseText;
            //-------------
            $(function() {
                $("#queries_followUp").accordion({
                    collapsible : true,
                    active : 'none',
                    autoHeight : false,
                    navigation : true,
                    heightStyle : "content"
                });
            });

        } else {
            // showloadingPanel("failed");
            //alert(ajax.responseText);

        }
    };
    ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&queryId_34=" + _("the_popped_up_query_suggst_id").value + "&key=cyuma");

    //------------------------
}

function Messages_pop_finalize_hide() {
    $("#main_page__2017_finalize_query_cyuma").slideUp();
}

//------------------finalize option-------
var theMyChoiceResolution = "resolved";
function Messages_pop_finalize_choiceOfResponse(obj) {
    //--inprogress--pending--resolved--unsatisfied--_("main_page_cyuma_finalize_statement").value
    theMyChoiceResolution = obj.title;

}

//-------------
function Messages_pop_finalize_choiceOfResponse_focus(obj) {
    _("x_check_1_3").checked = true;
    theMyChoiceResolution = "unsatisfied";
}

//------
function Messages_pop_finalize_choiceOfResponse_document() {
    //-------------_("the_popped_up_query_suggst_id").value
    if (theMyChoiceResolution == "unsatisfied") {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/main_page_observerMyQuery_2017.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    Messages_pop_finalize_hide();
                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("observerData=" + _("main_page_cyuma_finalize_statement").value + "&theMyChoiceResolution=" + theMyChoiceResolution + "&queryId_34=" + _("the_popped_up_query_suggst_id").value + "&key=cyuma");

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/main_page_observerMyQuery_2017.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    Messages_pop_finalize_hide();
                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("&theMyChoiceResolution=" + theMyChoiceResolution + "&queryId_34=" + _("the_popped_up_query_suggst_id").value + "&key=cyuma");

    }
}

//-
function Messages_pop_finalize(obj) {
    var p = $("#" + obj.id);
    var position = p.position();
    $("#main_page__2017_finalize_query_cyuma").css("visibility", "visible");
    _("main_page__2017_finalize_query_cyuma").style.top = position.top + 30 + "px";
    _("main_page__2017_finalize_query_cyuma").style.left = 100 + "px";
    $("#main_page__2017_finalize_query_cyuma").slideDown();
    //-------------------
    /*
     tMob = false;
     MessagesisNotifyWinActive_finalize = true;
     var p = $("#" + obj.id);
     var position = p.position();
     //alert(position.top + "px");
     $("#message_panel_finalize").css("visibility", "visible");
     //-------------------------------

     _("message_panel_finalize").style.top = position.top + 30 + "px";
     //---------------------------
     //---------------------------------------------
     _("message_panel_finalize").style.left = 200 + "px";
     //-----------------
     //$("#notifications_panel_mainpop").css("height", $("#notifications_panel_mainpop_notify").height() + "px");
     $("#message_panel_finalize").css("width", 0 + "px");
     //-------------------------------
     $("#message_panel_finalize").css("background", "rgba(255,255,255,1)");
     $("#message_panel_finalize").css("text-align", "center");

     //-----------------------------------------
     $("#message_panel_finalize").animate({
     width : 0
     });
     $("#message_panel_finalize").animate({
     width : boxWidthMessages_finalize
     });

     $("#message_panel_finalize").css("border", "1px solid #0080FF");
     $("#message_panel_finalize").css("border-radius", "5px");
     $('html, body').animate({
     scrollTop : $("#message_panel_finalize").offset().top - $("#headerUpperNav").height() - 5
     }, 1000);
     */
}

//---------The suggestion box ----------
var boxWidth_suggestion = $("#suggestion_panel_mainpop").width();
var is_suggestionWinActive = false;
var theCurrentRGB_suggest_Object;
//------------------------
var main_page_rgb_suggestion_tag;
function suggestion_panel_pop(obj, title) {
    //---
    switch(title) {
        case "vup":
            _("title_question_data").innerHTML = "VUP";
            main_page_rgb_suggestion_tag = "VUP";
            break;
        case "ibibazo_general":
            _("title_question_data").innerHTML = "IBIBAZO BY' ABATURAGE";
            main_page_rgb_suggestion_tag = "IBIBAZO BY' ABATURAGE";
            break;
        case "sacco":
            _("title_question_data").innerHTML = "UMURENGE SACCO";
            main_page_rgb_suggestion_tag = "UMURENGE SACCO";
            break;
        case "girinka":
            _("title_question_data").innerHTML = "GIRINKA";
            main_page_rgb_suggestion_tag = "GIRINKA";
            break;
        case "mutuelle":
            _("title_question_data").innerHTML = "MUTUELLE";
            main_page_rgb_suggestion_tag = "MUTUELLE";
            break;

    }
    //-------------
    try {
        var p = $("#" + theCurrentRGB_suggest_Object);
        $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
        $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
    } catch(error) {

    }
    //-----------
    try {
        theCurrentRGB_suggest_Object = obj.id;
        var p = $("#" + theCurrentMessageObject);
        $("#rgb_suggestion_").removeClass("rgb_suggestion_panel").addClass("rgb_suggestion_panel_taken");
        $("#" + theCurrentRGB_suggest_Object).removeClass("rgb").addClass("rgb_taken");
    } catch(error) {

    }

    //--
    is_suggestionWinActive = true;
    var p = $("#" + obj.id);
    var position = p.position();
    if (is_suggestionWinActive) {
        //alert(position.top + "px");
    }
    var gnh = $("#suggestion_panel_mainpop");
    var gnh_position = gnh.position();

    $("#suggestion_panel_mainpop").css("visibility", "visible");
    //-------------------------------
    _("suggestion_panel_mainpop").style.top = position.top + "px";
    //---------------------------
    //---------------------------------------------
    _("suggestion_panel_mainpop").style.left = position.left - boxWidth_suggestion + "px";
    //-----------------
    //$("#notifications_panel_mainpop").css("height", $("#notifications_panel_mainpop_notify").height() + "px");
    $("#suggestion_panel_mainpop").css("width", 0 + "px");
    //-------------------------------
    $("#suggestion_panel_mainpop").css("background", "rgba(255,255,255,1)");
    $("#suggestion_panel_mainpop").css("text-align", "center");

    //-----------------------------------------
    $("#suggestion_panel_mainpop").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop").animate({
        width : boxWidth
    });

    $("#suggestion_panel_mainpop").css("border", "1px solid #0080FF");
    $("#suggestion_panel_mainpop").css("border-radius", "5px");
    $('html, body').animate({
        scrollTop : $("#suggestion_panel_mainpop").offset().top - $("#headerUpperNav").height() - 5
    }, 1000);
}

//-------------Main page rgb suggest now---------------main_page_rgb_ask_question_2017
//--------main page rgb suggest send--main_page_rgb_suggestion_tag
function main_page_rgb_ask_question() {
    //alert(_("main_page_rgb_ask_question_2017").value+"---"+main_page_rgb_suggestion_tag+"--"+_("common_user_settings_the_id").value);
    //------Girinka-VUP--MUTUELLE DE SANTE--UMURENGE SACCO--IBIBAZO BY'ABATURAGE
    if (_("main_page_rgb_ask_question_2017").value.length > 6) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/main_page_send_query_toRGB.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    _("main_page_rgb_ask_question_2017").value = "";
                    if (is_suggestionWinActive) {
                        //-----------------
                        try {
                            var p = $("#" + theCurrentRGB_suggest_Object);
                            $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
                            $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
                        } catch(error) {

                            //--
                        }
                        is_suggestionWinActive = false;
                        $("#suggestion_panel_mainpop").animate({
                            width : 0
                        });
                        $("#suggestion_panel_mainpop").css("border-style", "none");
                    } else {
                        //alert("cyuma");
                    }

                } else {
                    alert("" + ajax.responseText);
                }

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&query=" + _("main_page_rgb_ask_question_2017").value + "&queryOrientation=" + main_page_rgb_suggestion_tag + "&key=cyuma");
    }
}

function main_page_rgb_ask_question_dismiss() {
    if (is_suggestionWinActive) {
        //-----------------
        try {
            var p = $("#" + theCurrentRGB_suggest_Object);
            $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
            $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
        } catch(error) {

            //--
        }
        is_suggestionWinActive = false;
        $("#suggestion_panel_mainpop").animate({
            width : 0
        });
        $("#suggestion_panel_mainpop").css("border-style", "none");
    } else {
        //alert("cyuma");
    }

}

//------------
//---------The suggestion box ----------
var boxWidth_suggestion_community = $("#suggestion_panel_mainpop_community").width();
var is_suggestionWinActive_community = false;
//------------------------
var theCurrentCommunity_suggest_Object;

var main_page_suggestToTheCommunity;
//---------

function suggestion_panel_pop_community(obj, title) {
    //---
    switch(title) {
        case "text":
            $("#text_0").show();
            $("#image_0").hide();
            $("#audio_0").hide();
            $("#video_0").hide();
            main_page_suggestToTheCommunity = 'text';
            break;
        case "image":
            $("#text_0").hide();
            $("#image_0").show();
            $("#audio_0").hide();
            $("#video_0").hide();
            main_page_suggestToTheCommunity = 'image';
            break;
        case "audio":
            $("#text_0").hide();
            $("#image_0").hide();
            $("#audio_0").show();
            $("#video_0").hide();
            main_page_suggestToTheCommunity = 'audio';
            break;
        case "video":
            $("#text_0").hide();
            $("#image_0").hide();
            $("#audio_0").hide();
            $("#video_0").show();
            main_page_suggestToTheCommunity = 'video';
            break;

    }
    //----------
    try {
        var p = $("#" + theCurrentCommunity_suggest_Object);
        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
    } catch(error) {

    }
    //-----------
    try {
        theCurrentCommunity_suggest_Object = obj.id;
        var p = $("#" + theCurrentCommunity_suggest_Object);
        $("#community_suggestion_box_").removeClass("community_suggestion_box").addClass("community_suggestion_box_taken");
        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest").addClass("community_suggest_taken");
    } catch(error) {

    }

    //--
    is_suggestionWinActive_community = true;
    var p = $("#" + obj.id);
    var position = p.position();
    if (is_suggestionWinActive) {
        //alert(position.top + "px");
    }
    var gnh = $("#suggestion_panel_mainpop_community");
    var gnh_position = gnh.position();

    $("#suggestion_panel_mainpop_community").css("visibility", "visible");
    //-------------------------------
    _("suggestion_panel_mainpop_community").style.top = position.top + "px";
    //---------------------------
    //---------------------------------------------
    _("suggestion_panel_mainpop_community").style.left = position.left - boxWidth_suggestion + "px";
    //-----------------
    //$("#notifications_panel_mainpop").css("height", $("#notifications_panel_mainpop_notify").height() + "px");
    $("#suggestion_panel_mainpop_community").css("width", 0 + "px");
    //-------------------------------
    $("#suggestion_panel_mainpop_community").css("background", "rgba(255,255,255,1)");
    $("#suggestion_panel_mainpop_community").css("text-align", "center");

    //-----------------------------------------
    $("#suggestion_panel_mainpop_community").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop_community").animate({
        width : boxWidth
    });

    $("#suggestion_panel_mainpop_community").css("border", "1px solid #0080FF");
    $("#suggestion_panel_mainpop_community").css("border-radius", "5px");
    $('html, body').animate({
        scrollTop : $("#suggestion_panel_mainpop_community").offset().top - $("#headerUpperNav").height() - 5
    }, 1000);
}

//----------All the suggestion panel functions---main_page_suggestToTheCommunity---------common_user_settings_the_id---------
function main_page_suggest_to_community_view_all() {
    //------------mainpage_search_for_a_valid_company_to_suggest_all.php
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/mainpage_search_for_a_valid_company_to_suggest_all.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            //main_page_the_last_populated = comments_conatiner;

            _("mainpage_suggest_text_search_company_results_data").innerHTML = "" + ajax.responseText;
            //_("mainpage_id_of_selected_company_suggestion_box").value = obj.id;
            $("#mainpage_suggest_text_search_company_results").css("visibility", "visible");
            $("#mainpage_suggest_text_search_company_results").slideDown();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("main_page_suggestToTheCommunity=" + main_page_suggestToTheCommunity + "&key=cyuma");

}

//-----------------
function main_page_make_choiceOfCompanyToSuggestTo(obj) {
    //alert(obj.id);
    showloadingPanel("loading");
    //--------------------------
    var ajax = ajaxObj("POST", "nds_web_scripts/mainpage_search_for_a_valid_company_to_suggest_TheOne.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            //main_page_the_last_populated = comments_conatiner;
            switch(main_page_suggestToTheCommunity) {
                case "text":
                    $("#mainpage_suggest_text_search_company_results").slideUp();
                    _("main_page_text_company_preview_data_id").value = obj.id;
                    _("main_page_text_company_preview_data").innerHTML = "" + ajax.responseText;
                    break;
                case "image":
                    $("#mainpage_suggest_text_search_company_results").slideUp();
                    _("main_page_image_company_preview_data_id").value = obj.id;
                    _("main_page_image_company_preview_data").innerHTML = "" + ajax.responseText;
                    break;
                case "audio":
                    $("#mainpage_suggest_text_search_company_results").slideUp();
                    _("main_page_audio_company_preview_data_id").value = obj.id;
                    _("main_page_audio_company_preview_data").innerHTML = "" + ajax.responseText;
                    break;
                case "video":
                    $("#mainpage_suggest_text_search_company_results").slideUp();
                    _("main_page_video_company_preview_data_id").value = obj.id;
                    _("main_page_video_company_preview_data").innerHTML = "" + ajax.responseText;
                    break;
            }

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("main_page_suggestToTheCommunity=" + main_page_suggestToTheCommunity + "&companyId=" + obj.id + "&key=cyuma");

}

function main_page_hide_search_company_results() {
    $("#mainpage_suggest_text_search_company_results").slideUp();
}

//----------------Search for a company--
function main_page_suggest_to_community_view_all_bySearch(obj) {
    if (obj.value.length >= 1) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/mainpage_search_for_a_valid_company_to_suggest_all_bySearch.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;

                _("mainpage_suggest_text_search_company_results_data").innerHTML = "" + ajax.responseText;
                //_("mainpage_id_of_selected_company_suggestion_box").value = obj.id;
                $("#mainpage_suggest_text_search_company_results").css("visibility", "visible");
                $("#mainpage_suggest_text_search_company_results").slideDown();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("main_page_suggestToTheCommunity=" + main_page_suggestToTheCommunity + "&theSearchKeyword=" + obj.value + "&key=cyuma");
    }
}

function main_page_suggest_to_community_view_all_bySearch_click() {
    if (_("main_page_find_the_companies_reg").value != "") {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/mainpage_search_for_a_valid_company_to_suggest_all_bySearch.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;

                _("mainpage_suggest_text_search_company_results_data").innerHTML = "" + ajax.responseText;
                //_("mainpage_id_of_selected_company_suggestion_box").value = obj.id;
                $("#mainpage_suggest_text_search_company_results").css("visibility", "visible");
                $("#mainpage_suggest_text_search_company_results").slideDown();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("main_page_suggestToTheCommunity=" + main_page_suggestToTheCommunity + "&theSearchKeyword=" + _("main_page_find_the_companies_reg").value + "&key=cyuma");

    } else {
        alert("nope!");
    }
}

//---------------
function main_page_suggestToCommunity_removeThisFromVisibility(obj) {
    //alert(obj.name);
    if ($("#" + obj.name)) {
        $("#" + obj.name).slideUp();
        switch(main_page_suggestToTheCommunity) {
            case "text":

                _("main_page_text_company_preview_data_id").value = "";

                break;
            case "image":

                _("main_page_image_company_preview_data_id").value = "";

                break;
            case "audio":

                _("main_page_audio_company_preview_data_id").value = "";

                break;
            case "video":

                _("main_page_video_company_preview_data_id").value = "";

                break;
        }
    }

}

//------------------------
function main_page_send_this_suggestionToTheCompany(whichType) {
    //alert(_("main_page_text_company_preview_data_id").value);

    //---------------------------------
    switch(whichType) {
        case "text":
            if (_("main_page_text_company_preview_data_id").value == "") {
                alert("Choose an organisation!!?");
            } else {
                //-----------------
                if (_("main_page_community_suggest_To_text2017").value != "") {
                    showloadingPanel("loading");
                    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_community_text_suggestion.php");
                    ajax.onreadystatechange = function() {
                        if (ajaxReturn(ajax) == true) {
                            //main_page_the_last_populated = comments_conatiner;
                            if (parseInt(ajax.responseText) == 1000) {
                                _("main_page_community_suggest_To_text2017").value = "";
                                if (is_suggestionWinActive_community) {
                                    //--
                                    try {
                                        var p = $("#" + theCurrentCommunity_suggest_Object);
                                        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
                                        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
                                    } catch(error) {

                                    }
                                    is_suggestionWinActive_community = false;
                                    $("#suggestion_panel_mainpop_community").animate({
                                        width : 0
                                    });
                                    $("#suggestion_panel_mainpop_community").css("border-style", "none");
                                }

                            } else {
                                alert("" + ajax.responseText);
                            }

                        } else {
                            // showloadingPanel("failed");

                        }
                    };
                    ajax.send("MyRemoteId=" + _("common_user_settings_the_id").value + "&Suggestion_box_id=" + _("main_page_text_company_preview_data_id").value + "&CaptionDesc=" + _("main_page_community_suggest_To_text2017").value + "&key=cyuma");
                    //----------
                }
            }
            break;
        case "video":
            if (_("main_page_video_company_preview_data_id").value == "") {
                alert("Choose an organisation!!?");
            } else {
                if (_("main_page_community_suggest_video_2017_form_file_val").value == "") {
                    alert("Video please!!?");
                } else {
                    showloadingPanel("loading");
                    var ajax = ajaxObj("POST", "nds_web_scripts/nds_main_page_Save_Suggested_video.php");
                    ajax.onreadystatechange = function() {
                        if (ajaxReturn(ajax) == true) {
                            //main_page_the_last_populated = comments_conatiner;
                            if (parseInt(ajax.responseText) == 1000) {
                                _("main_page_community_suggest_video_caption").value = "";
                                _("main_page_community_suggest_video_clouds").innerHTML = "";
                                _("main_page_community_suggest_video_2017_form_file_val").value = "";
                                if (is_suggestionWinActive_community) {
                                    //--
                                    try {
                                        var p = $("#" + theCurrentCommunity_suggest_Object);
                                        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
                                        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
                                    } catch(error) {

                                    }
                                    is_suggestionWinActive_community = false;
                                    $("#suggestion_panel_mainpop_community").animate({
                                        width : 0
                                    });
                                    $("#suggestion_panel_mainpop_community").css("border-style", "none");
                                }

                            } else {
                                alert("" + ajax.responseText);
                            }

                        } else {
                            // showloadingPanel("failed");

                        }
                    };
                    ajax.send("MyRemoteId=" + _("common_user_settings_the_id").value + "&Suggestion_box_id=" + _("main_page_video_company_preview_data_id").value + "&CaptionDesc=" + _("main_page_community_suggest_video_caption").value + "&TheVideoSrc=" + _("main_page_community_suggest_video_2017_form_file_val").value + "&key=cyuma");
                    //----------

                }
            }
            break;
        case "audio":
            if (_("main_page_audio_company_preview_data_id").value == "") {
                alert("Choose an organisation!!?");
            } else {
                if (_("main_page_community_suggest_audio_2017_file_val").value == "") {
                    alert("Audio Please!");
                } else {
                    showloadingPanel("loading");
                    var ajax = ajaxObj("POST", "nds_web_scripts/nds_main_page_Save_Suggested_audio.php");
                    ajax.onreadystatechange = function() {
                        if (ajaxReturn(ajax) == true) {
                            //main_page_the_last_populated = comments_conatiner;
                            if (parseInt(ajax.responseText) == 1000) {
                                _("main_page_community_suggest_audio_2017_file_val").value = "";
                                _("main_page_community_suggested_audio_2017_preview").innerHTML = "";
                                _("main_page_community_suggest_audio_2017_we").value = "";
                                if (is_suggestionWinActive_community) {
                                    //--
                                    try {
                                        var p = $("#" + theCurrentCommunity_suggest_Object);
                                        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
                                        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
                                    } catch(error) {

                                    }
                                    is_suggestionWinActive_community = false;
                                    $("#suggestion_panel_mainpop_community").animate({
                                        width : 0
                                    });
                                    $("#suggestion_panel_mainpop_community").css("border-style", "none");
                                }

                            } else {
                                alert("" + ajax.responseText);
                            }

                        } else {
                            // showloadingPanel("failed");

                        }
                    };
                    ajax.send("MyRemoteId=" + _("common_user_settings_the_id").value + "&Suggestion_box_id=" + _("main_page_audio_company_preview_data_id").value + "&CaptionDesc=" + _("main_page_community_suggest_audio_2017_we").value + "&TheAudioSrc=" + _("main_page_community_suggest_audio_2017_file_val").value + "&key=cyuma");
                    //----------

                }
            }
            break;
        case "image":
            if (_("main_page_image_company_preview_data_id").value == "") {
                alert("Image Choose an organisation!!?");
            } else {
                if (main_page_community_suggest_imgs_array.length == 0) {
                    alert("Image Please!");
                } else {
                    var theMainPageImgsTemp_store = "";
                    if (main_page_community_suggest_imgs_array.length == 1) {
                        var theMainPageImgsTemp_store = main_page_community_suggest_imgs_array[0];

                    } else {

                        for (var i = 0; i < main_page_community_suggest_imgs_array.length; i++) {
                            if (i != 0) {
                                theMainPageImgsTemp_store = theMainPageImgsTemp_store + "~" + main_page_community_suggest_imgs_array[i];
                            } else {
                                theMainPageImgsTemp_store = theMainPageImgsTemp_store + main_page_community_suggest_imgs_array[i];
                            }
                        }

                    }
                    //alert(theMainPageImgsTemp_store);
                    showloadingPanel("loading");
                    //----------load the images---------------------
                    var ajax = ajaxObj("POST", "nds_web_scripts/nds_main_page_Save_Suggested_imageS.php");
                    ajax.onreadystatechange = function() {
                        if (ajaxReturn(ajax) == true) {
                            //main_page_the_last_populated = comments_conatiner;
                            if (parseInt(ajax.responseText) == 1000) {
                                main_page_community_suggest_imgs_array = [];
                                _("main_pagee_community_suggest_an_Image_2017_caption").value = '';
                                _("main_page_community_suggest_IMG_clouds").innerHTML = '';
                                if (is_suggestionWinActive_community) {
                                    //--
                                    try {
                                        var p = $("#" + theCurrentCommunity_suggest_Object);
                                        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
                                        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
                                    } catch(error) {

                                    }
                                    is_suggestionWinActive_community = false;
                                    $("#suggestion_panel_mainpop_community").animate({
                                        width : 0
                                    });
                                    $("#suggestion_panel_mainpop_community").css("border-style", "none");
                                }

                            }

                        } else {
                            // showloadingPanel("failed");

                        }
                    };
                    ajax.send("theMainPageImgsTemp_store=" + theMainPageImgsTemp_store + "&MyRemoteId=" + _("common_user_settings_the_id").value + "&Suggestion_box_id=" + _("main_page_image_company_preview_data_id").value + "&CaptionDesc=" + _("main_pagee_community_suggest_an_Image_2017_caption").value + "&key=cyuma");

                }

            }
            break;

    }
}

//------------------main page uppload community suggest images--
//-------------------------------------------------------------
function upload_mainpage_img_suggest() {
    var file = document.getElementById("main_page_suggest_img_form_2017_file").files[0];
    if (!file) {
    } else {
        //------------------
        var fd = new FormData();
        fd.append("main_page_suggest_img_form_2017", file);
        var aj = new XMLHttpRequest();
        aj.upload.addEventListener("progress", progress_mainpage_img_suggest, false);
        aj.addEventListener("load", complete_mainpage_img_suggest, false);
        aj.addEventListener("error", error_mainpage_img_suggest, false);
        aj.addEventListener("abort", abort_mainpage_img_suggest, false);
        aj.open("POST", "nds_web_scripts/nds_main_page_suggest_image.php");
        aj.send(fd);
    }
}

//----------------------------------
function progress_mainpage_img_suggest(event) {
    var percent = (event.loaded / event.total) * 100;
    var quotient = (event.loaded / event.total);
    document.getElementById("mainpage_community_suggest_img_msg").innerHTML = Math.round(percent) + "% Uploading ...";
    //document.getElementById("progressBar").style.width = (220 / event.total) * event.loaded + "px";
}

function complete_mainpage_img_suggest(event) {
    //document.getElementById("community_user_settings_up_img_messenger").innerHTML = "";
    //document.getElementById("progressBar").style.width = 0;
    // _("community_user_settings_up_img_val").value = event.target.responseText;
    //_("community_user_settings_up_img_preview").src = "neza_advert_images/" + event.target.responseText;
    //-----------------

    //-------------check if response is in image format

    if (event.target.responseText == "Erros occur!" || event.target.responseText == "Wrong image format." || event.target.responseText == "Unkown Format") {
        document.getElementById("mainpage_community_suggest_img_msg").innerHTML = event.target.responseText;
    } else {
        document.getElementById("mainpage_community_suggest_img_msg").innerHTML = "";
        //----adding to array of images--------
        main_page_community_suggest_imgs_array.push(event.target.responseText);
        // alert("added To Array" + main_page_community_suggest_imgs_array.length);
        //--------------load the images from arrays os images--
        mainpage_suggest_imageToCommunity_load_allImgs();

    }

}

function error_mainpage_img_suggest(event) {
}

function abort_mainpage_img_suggest(event) {
}

//-------------------The Audio suggest api------------------------------------------
function upload_mainpage_audio_suggest() {
    var file = document.getElementById("main_page_community_suggest_audio_2017_file").files[0];
    if (!file) {
    } else {
        //------------------
        var fd = new FormData();
        fd.append("main_page_community_suggest_audio_2017", file);
        var aj = new XMLHttpRequest();
        aj.upload.addEventListener("progress", progress_mainpage_audio_suggest, false);
        aj.addEventListener("load", complete_mainpage_audio_suggest, false);
        aj.addEventListener("error", error_mainpage_audio_suggest, false);
        aj.addEventListener("abort", abort_mainpage_audio_suggest, false);
        aj.open("POST", "nds_web_scripts/nds_main_page_suggest_audio.php");
        aj.send(fd);
    }
}

//----------------------------------
function progress_mainpage_audio_suggest(event) {
    var percent = (event.loaded / event.total) * 100;
    var quotient = (event.loaded / event.total);
    document.getElementById("main_page_community_suggest_audio_2017_file_msg").innerHTML = Math.round(percent) + "% Uploading ...";
    //document.getElementById("progressBar").style.width = (220 / event.total) * event.loaded + "px";
}

function complete_mainpage_audio_suggest(event) {
    //document.getElementById("community_user_settings_up_img_messenger").innerHTML = "";
    //document.getElementById("progressBar").style.width = 0;
    // _("community_user_settings_up_img_val").value = event.target.responseText;
    //_("community_user_settings_up_img_preview").src = "neza_advert_images/" + event.target.responseText;
    //-----------------

    //-------------check if response is in image format

    if (event.target.responseText == "Erros occur!" || event.target.responseText == "Wrong image format." || event.target.responseText == "Unkown Format") {
        document.getElementById("main_page_community_suggest_audio_2017_file_msg").innerHTML = event.target.responseText;
    } else {
        document.getElementById("main_page_community_suggest_audio_2017_file_msg").innerHTML = "";
        //----adding to array of images--------
        // main_page_community_suggest_audios_array.push(event.target.responseText);

        //--------------load the images from arrays os images--
        try {
            _("main_page_community_suggest_audio_2017_file_val").value = event.target.responseText;
        } catch(err) {
            alert(err);
        }

        mainpage_suggest_imageToCommunity_load_lastAudio(event.target.responseText);

    }

}

function error_mainpage_audio_suggest(event) {
}

function abort_mainpage_audio_suggest(event) {
}

//---------------------------
//-------------------The Video suggest api------------------------------------------
function upload_mainpage_video_suggest() {
    var file = document.getElementById("main_page_community_suggest_video_2017_form_file").files[0];
    if (!file) {
    } else {
        //------------------
        var fd = new FormData();
        fd.append("main_page_community_suggest_video_2017_form", file);
        var aj = new XMLHttpRequest();
        aj.upload.addEventListener("progress", progress_mainpage_video_suggest, false);
        aj.addEventListener("load", complete_mainpage_video_suggest, false);
        aj.addEventListener("error", error_mainpage_video_suggest, false);
        aj.addEventListener("abort", abort_mainpage_video_suggest, false);
        aj.open("POST", "nds_web_scripts/nds_main_page_suggest_video.php");
        aj.send(fd);
    }
}

//----------------------------------
function progress_mainpage_video_suggest(event) {
    var percent = (event.loaded / event.total) * 100;
    var quotient = (event.loaded / event.total);
    document.getElementById("main_page_community_suggest_video_2017_form_file_msg").innerHTML = Math.round(percent) + "% Uploading ...";
    //document.getElementById("progressBar").style.width = (220 / event.total) * event.loaded + "px";
}

function complete_mainpage_video_suggest(event) {
    //document.getElementById("community_user_settings_up_img_messenger").innerHTML = "";
    //document.getElementById("progressBar").style.width = 0;
    // _("community_user_settings_up_img_val").value = event.target.responseText;
    //_("community_user_settings_up_img_preview").src = "neza_advert_images/" + event.target.responseText;
    //-----------------

    //-------------check if response is in image format

    if (event.target.responseText == "Erros occur!" || event.target.responseText == "Wrong image format." || event.target.responseText == "Unkown Format") {
        document.getElementById("main_page_community_suggest_video_2017_form_file_msg").innerHTML = event.target.responseText;
    } else {
        document.getElementById("main_page_community_suggest_video_2017_form_file_msg").innerHTML = "";
        //----adding to array of images--------
        // main_page_community_suggest_audios_array.push(event.target.responseText);
        //alert(event.target.responseText);
        //--------------load the images from arrays os images--
        try {
            _("main_page_community_suggest_video_2017_form_file_val").value = event.target.responseText;
        } catch(err) {
            alert(err);
        }

        mainpage_suggest_imageToCommunity_load_lastVideo(event.target.responseText);

    }

}

function error_mainpage_video_suggest(event) {
}

function abort_mainpage_video_suggest(event) {
}

//--------the array declaration--
var main_page_community_suggest_imgs_array = [];
//-----------audio arrays-
var main_page_community_suggest_audios_array = [];
//-------------check image availability
function checkUrl(url) {
    var arr = ["jpeg", "jpg", "gif", "png"];
    var ext = url.substring(url.lastIndexOf(".") + 1);
    if ($.inArray(ext, arr)) {
        //alert("valid url");
        return true;
    } else {
        return false;
    }
}

//----------
function main_page_commununity_img_suggest_removeThisOneFromArray(obj) {
    // alert(obj.id);
    //-----------remove The Image From The Load----------

    if (main_page_community_suggest_imgs_array.length == 1) {
        $("#" + obj.name).slideUp();
        main_page_community_suggest_imgs_array = [];

    } else {
        var n5 = 0;
        for (var i = main_page_community_suggest_imgs_array.length - 1; i >= 0; i--) {
            if (main_page_community_suggest_imgs_array[i] === obj.id) {
                main_page_community_suggest_imgs_array.splice(i, 1);
                $("#" + obj.name).slideUp();
                //------------------Delete the last element------

            } else {

            }
            //-----------------
            if (n5 == (main_page_community_suggest_imgs_array.length - 1)) {

                main_page_community_suggest_imgs_array[i].pop();
                $("#" + obj.name).slideUp();
            }
            //---------------------
            n5++;
        }

    }

}

function mainpage_suggest_imageToCommunity_load_allImgs() {
    //------------use the current image array--
    var theMainPageImgsTemp_store = "";
    if (main_page_community_suggest_imgs_array.length == 1) {
        var theMainPageImgsTemp_store = main_page_community_suggest_imgs_array[0];

    } else {

        for (var i = 0; i < main_page_community_suggest_imgs_array.length; i++) {
            if (i != 0) {
                theMainPageImgsTemp_store = theMainPageImgsTemp_store + "~" + main_page_community_suggest_imgs_array[i];
            } else {
                theMainPageImgsTemp_store = theMainPageImgsTemp_store + main_page_community_suggest_imgs_array[i];
            }
        }

    }
    //alert(theMainPageImgsTemp_store);
    showloadingPanel("loading");
    //----------load the images---------------------
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_load_all_community_suggested_imgs.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            //main_page_the_last_populated = comments_conatiner;

            _("main_page_community_suggest_IMG_clouds").innerHTML = "" + ajax.responseText;

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("theMainPageImgsTemp_store=" + theMainPageImgsTemp_store + "&key=cyuma");

}

function mainpage_suggest_imageToCommunity_load_lastAudio(theAudio) {

    showloadingPanel("loading");
    //----------load the images---------------------
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_company_audio_structure_load.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            //main_page_the_last_populated = comments_conatiner;

            _("main_page_community_suggested_audio_2017_preview").innerHTML = "" + ajax.responseText;

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("theAudio=" + theAudio + "&key=cyuma");

}

//--------------------------------------
function mainpage_suggest_imageToCommunity_load_lastVideo(theVideoN) {

    showloadingPanel("loading");
    //----------load the images---------------------
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_company_video_structure_load.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            //main_page_the_last_populated = comments_conatiner;

            _("main_page_community_suggest_video_clouds").innerHTML = "" + ajax.responseText;

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("theVideoN=" + theVideoN + "&key=cyuma");

}

//-------------
function main_page_community_audio_removeThis2017(obj) {
    $("#" + obj.name).hide();
    _("main_page_community_suggest_audio_2017_file_val").value = "";
}

function main_page_community_video_removeThis2017(obj) {
    $("#" + obj.name).hide();
    _("main_page_community_suggest_video_2017_form_file_val").value = "";
}

//---------------------------------
function main_page_suggest_to_community_close_up2017() {
    if (is_suggestionWinActive_community) {
        //--
        try {
            var p = $("#" + theCurrentCommunity_suggest_Object);
            $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
            $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
        } catch(error) {

        }
        is_suggestionWinActive_community = false;
        $("#suggestion_panel_mainpop_community").animate({
            width : 0
        });
        $("#suggestion_panel_mainpop_community").css("border-style", "none");
    }

}


$(document).click(function(event) {
    //--notify popup

    if (isNotifyWinActive) {
        tMob = false;
        isNotifyWinActive = false;
        $("#notifications_panel_mainpop").animate({
            width : 0
        });
        $("#notifications_panel_mainpop").css("border-style", "none");
        //-------------remove decoration---------
        try {
            var p = $("#" + theCurrentNotifiObject);
            $("#mainpage_notification").removeClass("mainPageNotificationHeader_taken").addClass("mainPageNotificationHeader");
            $("#" + theCurrentNotifiObject + theCurrentNotifiObject).removeClass("notify_record_taken").addClass("notify_record");

        } catch(error) {

        }
    }
    //--------------Messages--tag_xvv
    if (MessagesisNotifyWinActive) {

        MessagesisNotifyWinActive = false;

        tMob = false;
        $("#messages_panel_mainpop").animate({
            width : 0,
            height : 0
        });
        $("#messages_panel_mainpop").css("border-style", "none");
        $("#messages_panel_mainpop").css("height", "0px");
        _("messages_panel_mainpop").innerHTML = "";
        //-------------------------------------
        try {
            var p = $("#" + theCurrentMessageObject);
            $("#mainpageMessage").removeClass("mainPageNotificationHeader_taken").addClass("mainPage_Message");
            $("#" + theCurrentMessageObject).removeClass("message_record_taken").addClass("message_record");
        } catch(error) {

        }
    } else {

        $("#messages_panel_mainpop").css("height", "auto");

    }
    if (MessagesisNotifyWinActive_finalize) {
        MessagesisNotifyWinActive_finalize = false;
        $("#message_panel_finalize").animate({
            width : 0
        });
        $("#message_panel_finalize").css("border-style", "none");
    }
    if (is_suggestionWinActive) {
        //-----------------
        try {
            var p = $("#" + theCurrentRGB_suggest_Object);
            $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
            $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
        } catch(error) {

            //--
        }
        is_suggestionWinActive = false;
        $("#suggestion_panel_mainpop").animate({
            width : 0
        });
        $("#suggestion_panel_mainpop").css("border-style", "none");
    } else {
        //alert("cyuma");
    }
    if (is_suggestionWinActive_community) {
        //--
        try {
            var p = $("#" + theCurrentCommunity_suggest_Object);
            $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
            $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
        } catch(error) {

        }
        is_suggestionWinActive_community = false;
        $("#suggestion_panel_mainpop_community").animate({
            width : 0
        });
        $("#suggestion_panel_mainpop_community").css("border-style", "none");
    }

});
//--
$("#notifications_panel_mainpop").click(function(event) {
    try {
        var p = $("#" + theCurrentCommunity_suggest_Object);
        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
    } catch(error) {

    }
    //-------------------------------------
    try {
        var p = $("#" + theCurrentRGB_suggest_Object);
        $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
        $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
    } catch(error) {

        //--
    }
    //-------------------------------------
    try {
        var p = $("#" + theCurrentMessageObject);
        $("#mainpageMessage").removeClass("mainPageNotificationHeader_taken").addClass("mainPage_Message");
        $("#" + theCurrentMessageObject).removeClass("message_record_taken").addClass("message_record");
    } catch(error) {

    }
    //--------------
    event.stopPropagation();
    tMob = false;
    if (MessagesisNotifyWinActive) {
        MessagesisNotifyWinActive = false;
        _("messages_panel_mainpop").innerHTMl = "";
        $("#messages_panel_mainpop").animate({
            width : 0
        });
        $("#messages_panel_mainpop").css("border-style", "none");
    }
    //--
    $("#suggestion_panel_mainpop").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop").css("border-style", "none");
    $("#suggestion_panel_mainpop_community").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop_community").css("border-style", "none");
});
$(".uv_0000").click(function(event) {
    try {
        var p = $("#" + theCurrentCommunity_suggest_Object);
        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
    } catch(error) {

    }
    //------------
    try {
        var p = $("#" + theCurrentRGB_suggest_Object);
        $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
        $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
    } catch(error) {

        //--
    }
    //-------------------------------------
    try {
        var p = $("#" + theCurrentMessageObject);
        $("#mainpageMessage").removeClass("mainPageNotificationHeader_taken").addClass("mainPage_Message");
        $("#" + theCurrentMessageObject).removeClass("message_record_taken").addClass("message_record");
    } catch(error) {

    }
    tMob = false;
    event.stopPropagation();
    if (MessagesisNotifyWinActive) {
        _("messages_panel_mainpop").innerHTMl = "";
        MessagesisNotifyWinActive = false;
        $("#messages_panel_mainpop").animate({
            width : 0
        });
        $("#messages_panel_mainpop").css("border-style", "none");
    }
    $("#suggestion_panel_mainpop_community").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop_community").css("border-style", "none");
    //--
    $("#suggestion_panel_mainpop").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop").css("border-style", "none");
});
///------------
$("#messages_panel_mainpop").click(function(event) {
    event.stopPropagation();
    try {
        var p = $("#" + theCurrentCommunity_suggest_Object);
        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
    } catch(error) {

    }
    $("#suggestion_panel_mainpop_community").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop_community").css("border-style", "none");
    isNotifyWinActive = false;
    $("#notifications_panel_mainpop").animate({
        width : 0
    });
    $("#notifications_panel_mainpop").css("border-style", "none");
    //--------------------
    $("#message_panel_finalize").animate({
        width : 0
    });
    $("#message_panel_finalize").css("border-style", "none");
    //---
    $("#suggestion_panel_mainpop").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop").css("border-style", "none");
});
$(".message_record").click(function(event) {
    try {
        var p = $("#" + theCurrentCommunity_suggest_Object);
        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
    } catch(error) {

    }
    //-------
    try {
        var p = $("#" + theCurrentRGB_suggest_Object);
        $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
        $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
    } catch(error) {

        //--
    }
    //------------
    try {
        var p = $("#" + theCurrentNotifiObject);
        $("#mainpage_notification").removeClass("mainPageNotificationHeader_taken").addClass("mainPageNotificationHeader");
        $("#" + theCurrentNotifiObject + theCurrentNotifiObject).removeClass("notify_record_taken").addClass("notify_record");

    } catch(error) {

    }
    //-------------
    $("#suggestion_panel_mainpop_community").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop_community").css("border-style", "none");
    $("#suggestion_panel_mainpop").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop").css("border-style", "none");
    event.stopPropagation();

    isNotifyWinActive = false;
    $("#notifications_panel_mainpop").animate({
        width : 0
    });
    $("#notifications_panel_mainpop").css("border-style", "none");
    //---------
    $("#message_panel_finalize").animate({
        width : 0
    });
    $("#message_panel_finalize").css("border-style", "none");
    window.clearTimeout(tImeOut);
    tMob = false;
    //--

});
///--------------------------------------------------------------
$("#message_panel_finalize").click(function(event) {
    event.stopPropagation();
    isNotifyWinActive = false;

});
$("#finalizeBtn").click(function(event) {
    event.stopPropagation();
    isNotifyWinActive = false;
    window.clearTimeout(tImeOut);
    tMob = false;

});
//----rgb-----
$("#suggestion_panel_mainpop").click(function(event) {
    //---------------
    try {
        var p = $("#" + theCurrentCommunity_suggest_Object);
        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
    } catch(error) {

    }
    //-------------------------------------
    try {
        var p = $("#" + theCurrentMessageObject);
        $("#mainpageMessage").removeClass("mainPageNotificationHeader_taken").addClass("mainPage_Message");
        $("#" + theCurrentMessageObject).removeClass("message_record_taken").addClass("message_record");
    } catch(error) {

    }
    event.stopPropagation();
    window.clearTimeout(tImeOut);
    tMob = false;

});
$(".rgb").click(function(event) {
    //--------------
    try {
        var p = $("#" + theCurrentCommunity_suggest_Object);
        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
    } catch(error) {

    }
    //-------------------------------------
    try {
        var p = $("#" + theCurrentMessageObject);
        $("#mainpageMessage").removeClass("mainPageNotificationHeader_taken").addClass("mainPage_Message");
        $("#" + theCurrentMessageObject).removeClass("message_record_taken").addClass("message_record");
    } catch(error) {

    }
    event.stopPropagation();
    //---
    try {
        var p = $("#" + theCurrentNotifiObject);
        $("#mainpage_notification").removeClass("mainPageNotificationHeader_taken").addClass("mainPageNotificationHeader");
        $("#" + theCurrentNotifiObject + theCurrentNotifiObject).removeClass("notify_record_taken").addClass("notify_record");

    } catch(error) {

    }
    //--
    $("#suggestion_panel_mainpop_community").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop_community").css("border-style", "none");

    tMob = false;
    //--
    $("#notifications_panel_mainpop").animate({
        width : 0
    });
    $("#notifications_panel_mainpop").css("border-style", "none");

    //--------------Messages

    $("#messages_panel_mainpop").animate({
        width : 0
    });
    $("#messages_panel_mainpop").css("border-style", "none");

    $("#message_panel_finalize").animate({
        width : 0
    });
    $("#message_panel_finalize").css("border-style", "none");

});
//--------
$("#suggestion_panel_mainpop_community").click(function(event) {
    //--------------
    try {
        var p = $("#" + theCurrentRGB_suggest_Object);
        $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
        $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
    } catch(error) {

        //--
    }
    //-------------------------------------
    try {
        var p = $("#" + theCurrentMessageObject);
        $("#mainpageMessage").removeClass("mainPageNotificationHeader_taken").addClass("mainPage_Message");
        $("#" + theCurrentMessageObject).removeClass("message_record_taken").addClass("message_record");
    } catch(error) {

    }
    event.stopPropagation();
    isNotifyWinActive = false;
    window.clearTimeout(tImeOut);
    tMob = false;

});
//----rgb-----
$(".community_suggest").click(function(event) {
    //-------------
    try {
        var p = $("#" + theCurrentRGB_suggest_Object);
        $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
        $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
    } catch(error) {

        //--
    }
    //-------------------------------------
    try {
        var p = $("#" + theCurrentMessageObject);
        $("#mainpageMessage").removeClass("mainPageNotificationHeader_taken").addClass("mainPage_Message");
        $("#" + theCurrentMessageObject).removeClass("message_record_taken").addClass("message_record");
    } catch(error) {

    }
    //-----------------
    try {
        var p = $("#" + theCurrentNotifiObject);
        $("#mainpage_notification").removeClass("mainPageNotificationHeader_taken").addClass("mainPageNotificationHeader");
        $("#" + theCurrentNotifiObject + theCurrentNotifiObject).removeClass("notify_record_taken").addClass("notify_record");

    } catch(error) {

    }
    //--------------------
    $("#suggestion_panel_mainpop").animate({
        width : 0
    });
    $("#suggestion_panel_mainpop").css("border-style", "none");
    //------------------
    $("#notifications_panel_mainpop").animate({
        width : 0
    });
    $("#notifications_panel_mainpop").css("border-style", "none");

    //--------------Messages

    $("#messages_panel_mainpop").animate({
        width : 0
    });
    $("#messages_panel_mainpop").css("border-style", "none");

    $("#message_panel_finalize").animate({
        width : 0
    });
    $("#message_panel_finalize").css("border-style", "none");
    event.stopPropagation();
    if (tImeOut != null) {
        window.clearTimeout(tImeOut);
    }
    tMob = false;

});
//---jquery follow----scrollAnime--

$(window).scroll(function() {
    try {
        //-----------------

        //--------------
        // if ($(this).scrollTop() > $("#theDownFeedData").offset().top && $(this).scrollTop() < ($("#theDownFeedData").offset().top + 1000)) {
        // $("#main_page_col_left").css("margin-top", $(this).scrollTop() - $("#theDownFeedData").offset().top);
        // $("#main_page_col_middle").css("margin-top", $(this).scrollTop() - $("#theDownFeedData").offset().top);
        //
        // } else {
        // $("#main_page_col_left").css("margin-top", 0);
        // $("#main_page_col_middle").css("margin-top", 0);
        //
        // }
    } catch(err) {

    }
    //----------------------------
    if ($(this).scrollTop() > ($("#headerUpperNav").height() + 5)) {
        $("#headerUpperNav").removeClass("headerNotFixed").addClass("headerFixed");
        //$("#headerUpperNav").fadeIn();

    } else {
        $("#headerUpperNav").removeClass("headerFixed").addClass("headerNotFixed");

    }
});
//-----panels--
$("#rgb_suggestion_panel").hide();
$("#rgb_queries_").show();
$("#institution_queries").removeClass("box_receipt").addClass("box_receipt_taken");
//-------------
$("#institution_queries").click(function() {
    $("#rgb_suggestion_panel").hide();
    $("#rgb_queries_").show();
    $("#institution_queries").removeClass("box_receipt").addClass("box_receipt_taken");
    $("#institution_suggest_box_psanel").removeClass("box_receipt_taken").addClass("box_receipt");
});
$("#institution_suggest_box_psanel").click(function() {
    $("#rgb_suggestion_panel").show();
    $("#rgb_queries_").hide();
    $("#institution_suggest_box_psanel").removeClass("box_receipt").addClass("box_receipt_taken");
    $("#institution_queries").removeClass("box_receipt_taken").addClass("box_receipt");
});
//--Setting menu--
try {
    if (_("whichPageSettings").value == "common_user") {
        $("#screen_Admin").hide();
        $("#screen_Language").show();
        $("#settings_list_li_Language").removeClass("settings_list_li").addClass("settings_list_opened");
        $("#settings_list_li_Admin").removeClass("settings_list_opened").addClass("settings_list_li");
        //$("#settings_list_li_Language").removeClass("settings_list_opened").addClass("settings_list_li");
        $("#settings_list_li_Preferences").removeClass("settings_list_opened").addClass("settings_list_li");
        $("#settings_list_li_Privacy").removeClass("settings_list_opened").addClass("settings_list_li");
        $("#settings_list_li_Ads").removeClass("settings_list_opened").addClass("settings_list_li");
        $("#settings_list_li_Notification").removeClass("settings_list_opened").addClass("settings_list_li");
        $("#screen_Notification").hide();
        $("#screen_Preferences").hide();
        $("#screen_Privacy").hide();
        $("#screen_Ads").hide();
        //----
        $("#settings_list_li_Admin").hide();
    } else {
        $("#screen_Admin").show();
        $("#screen_Language").hide();
        $("#screen_Notification").hide();
        $("#screen_Preferences").hide();
        $("#screen_Privacy").hide();
        $("#screen_Ads").hide();
        //-----------
        $("#settings_list_li_Admin").removeClass("settings_list_li").addClass("settings_list_opened");
        $("#settings_list_li_Language").removeClass("settings_list_opened").addClass("settings_list_li");
        $("#settings_list_li_Preferences").removeClass("settings_list_opened").addClass("settings_list_li");
        $("#settings_list_li_Privacy").removeClass("settings_list_opened").addClass("settings_list_li");
        $("#settings_list_li_Ads").removeClass("settings_list_opened").addClass("settings_list_li");
        $("#settings_list_li_Notification").removeClass("settings_list_opened").addClass("settings_list_li");
    }
} catch(err) {

}
//---------
$("#settings_list_li_Admin").click(function() {
    $("#screen_Admin").show();
    $("#settings_list_li_Admin").removeClass("settings_list_li").addClass("settings_list_opened");
    $("#settings_list_li_Language").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Preferences").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Privacy").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Ads").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Notification").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#screen_Language").hide();
    $("#screen_Notification").hide();
    $("#screen_Preferences").hide();
    $("#screen_Privacy").hide();
    $("#screen_Ads").hide();
});
$("#settings_list_li_Language").click(function() {
    $("#screen_Admin").hide();
    $("#screen_Language").show();
    $("#settings_list_li_Language").removeClass("settings_list_li").addClass("settings_list_opened");
    $("#settings_list_li_Admin").removeClass("settings_list_opened").addClass("settings_list_li");
    //$("#settings_list_li_Language").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Preferences").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Privacy").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Ads").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Notification").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#screen_Notification").hide();
    $("#screen_Preferences").hide();
    $("#screen_Privacy").hide();
    $("#screen_Ads").hide();
});
$("#settings_list_li_Preferences").click(function() {
    $("#screen_Admin").hide();
    $("#screen_Language").hide();
    $("#screen_Notification").hide();
    $("#screen_Preferences").show();
    $("#settings_list_li_Preferences").removeClass("settings_list_li").addClass("settings_list_opened");
    $("#settings_list_li_Admin").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Language").removeClass("settings_list_opened").addClass("settings_list_li");
    //$("#settings_list_li_Preferences").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Privacy").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Ads").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Notification").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#screen_Privacy").hide();
    $("#screen_Ads").hide();
});
$("#settings_list_li_Privacy").click(function() {
    $("#screen_Admin").hide();
    $("#screen_Language").hide();
    $("#screen_Notification").hide();
    $("#screen_Preferences").hide();
    $("#screen_Privacy").show();
    $("#settings_list_li_Privacy").removeClass("settings_list_li").addClass("settings_list_opened");
    $("#settings_list_li_Admin").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Language").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Preferences").removeClass("settings_list_opened").addClass("settings_list_li");
    //$("#settings_list_li_Privacy").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Ads").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Notification").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#screen_Ads").hide();
});
$("#settings_list_li_Ads").click(function() {
    $("#screen_Admin").hide();
    $("#screen_Language").hide();
    $("#screen_Notification").hide();
    $("#screen_Preferences").hide();
    $("#screen_Privacy").hide();
    $("#screen_Ads").show();
    $("#settings_list_li_Ads").removeClass("settings_list_li").addClass("settings_list_opened");
    $("#settings_list_li_Admin").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Language").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Preferences").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Privacy").removeClass("settings_list_opened").addClass("settings_list_li");
    //$("#settings_list_li_Ads").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Notification").removeClass("settings_list_opened").addClass("settings_list_li");
});
$("#settings_list_li_Notification").click(function() {
    $("#screen_Admin").hide();
    $("#screen_Language").hide();
    $("#screen_Notification").show();
    $("#settings_list_li_Notification").removeClass("settings_list_li").addClass("settings_list_opened");
    $("#settings_list_li_Admin").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Language").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Preferences").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Privacy").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#settings_list_li_Ads").removeClass("settings_list_opened").addClass("settings_list_li");
    //$("#settings_list_li_Notification").removeClass("settings_list_opened").addClass("settings_list_li");
    $("#screen_Preferences").hide();
    $("#screen_Privacy").hide();
    $("#screen_Ads").hide();
});
//---accordion --
$(function() {
    $("#accordion").accordion({
        collapsible : true,
        active : 'none',
        autoHeight : false,
        navigation : true,
        heightStyle : "content"
    });
});
//--
$("#activated_users_view").show();
$("#not_activated_users_users_view").hide();
$("#suspended_users_view").hide();
$("#activated_users").removeClass("adminUsersManu").addClass("adminUsersManu_taken");
$("#not_activated_users").removeClass("adminUsersManu_taken").addClass("adminUsersManu");
$("#suspended_users").removeClass("adminUsersManu_taken").addClass("adminUsersManu");
//----------Admin users--
$("#activated_users").click(function() {
    $("#activated_users_view").show();
    $("#not_activated_users_users_view").hide();
    $("#suspended_users_view").hide();
    $("#activated_users").removeClass("adminUsersManu").addClass("adminUsersManu_taken");
    $("#not_activated_users").removeClass("adminUsersManu_taken").addClass("adminUsersManu");
    $("#suspended_users").removeClass("adminUsersManu_taken").addClass("adminUsersManu");

});
$("#not_activated_users").click(function() {
    $("#activated_users_view").hide();
    $("#not_activated_users_users_view").show();
    $("#suspended_users_view").hide();
    $("#not_activated_users").removeClass("adminUsersManu").addClass("adminUsersManu_taken");
    $("#activated_users").removeClass("adminUsersManu_taken").addClass("adminUsersManu");
    $("#suspended_users").removeClass("adminUsersManu_taken").addClass("adminUsersManu");

});
$("#suspended_users").click(function() {
    $("#activated_users_view").hide();
    $("#not_activated_users_users_view").hide();
    $("#suspended_users_view").show();
    $("#suspended_users").removeClass("adminUsersManu").addClass("adminUsersManu_taken");
    $("#activated_users").removeClass("adminUsersManu_taken").addClass("adminUsersManu");
    $("#not_activated_users").removeClass("adminUsersManu_taken").addClass("adminUsersManu");
});
//-----suggestion box hovering fix==

function fixHoverInfoSuggestion(obj) {
    switch(obj.id) {
        case "er":
            var p = $("#" + obj.id);
            var position = p.position();
            _("txtSuggestion").style.top = position.top + "px";
            //_("txtSuggestion").style.left = obj.style.left - 20 + "px";
            _("txtSuggestion").style.height = "25px";
            break;
        case "er0":
            var p = $("#" + obj.id);
            var position = p.position();
            _("picSuggestion").style.top = position.top + "px";
            //_("picSuggestion").style.left = obj.style.left - 20 + "px";
            _("picSuggestion").style.height = "25px";
            break;
        case "er1":
            var p = $("#" + obj.id);
            var position = p.position();
            _("audioSuggestion").style.top = position.top + "px";
            //_("audioSuggestion").style.left = obj.style.left - 20 + "px";
            _("audioSuggestion").style.height = "25px";
            break;
        case "er2":
            var p = $("#" + obj.id);
            var position = p.position();
            _("videoSuggestion").style.top = position.top + "px";
            //_("videoSuggestion").style.left = obj.style.left - 20 + "px";
            _("videoSuggestion").style.height = "25px";
            break;
    }

}

//--------------------------------main_page_carousel
var global_var_which_forum_menu = "";
try {
    $("#All_mainPage").removeClass("header_0_forum").addClass("header_0_forum_taken");
    $("#Latest_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#whereIamTagged_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Trending_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Myposts_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#search_MainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    global_var_which_forum_menu = "all";
    //------------------

} catch(error) {

}
//------------
$("#All_mainPage").click(function() {
    $("#All_mainPage").removeClass("header_0_forum").addClass("header_0_forum_taken");
    $("#Latest_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#whereIamTagged_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Trending_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Myposts_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#search_MainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    //---
    global_var_which_forum_menu = "all";
    ///-------------------
    if (_("main_page_carousel")) {
        main_page_load_all_posts();
    }

});
//--------------------load main page all--
function main_page_load_all_posts() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("main_page_common_user_posts_preview").innerHTML = ajax.responseText;
            $(".main_page_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=all" + "&key=cyuma");
}


$("#Latest_mainPage").click(function() {
    $("#All_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Latest_mainPage").removeClass("header_0_forum").addClass("header_0_forum_taken");
    $("#whereIamTagged_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Trending_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Myposts_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#search_MainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    //---
    global_var_which_forum_menu = "latest";
    //------------------------
    if (_("main_page_carousel")) {
        main_page_load_all_posts_latest();
    }

});
//-----------------
function main_page_load_all_posts_latest() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("main_page_common_user_posts_preview").innerHTML = ajax.responseText;
            $(".main_page_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=latest" + "&key=cyuma");

}


$("#whereIamTagged_mainPage").click(function() {
    $("#All_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Latest_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#whereIamTagged_mainPage").removeClass("header_0_forum").addClass("header_0_forum_taken");
    $("#Trending_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Myposts_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#search_MainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    //---
    global_var_which_forum_menu = "where_i_am_tagged";
    //----------------------
    if (_("main_page_carousel")) {
        main_page_load_all_posts_where_i_am_tagged();
    }
});
//-----------------
function main_page_load_all_posts_where_i_am_tagged() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("main_page_common_user_posts_preview").innerHTML = ajax.responseText;
            $(".main_page_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=where_i_am_tagged" + "&key=cyuma");

}


$("#Trending_mainPage").click(function() {
    $("#All_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Latest_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#whereIamTagged_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Trending_mainPage").removeClass("header_0_forum").addClass("header_0_forum_taken");
    $("#Myposts_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#search_MainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    //---
    global_var_which_forum_menu = "trending";
    //-------------------------
    if (_("main_page_carousel")) {
        main_page_load_all_posts_trending();
    }
});
//-----------------
function main_page_load_all_posts_trending() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("main_page_common_user_posts_preview").innerHTML = ajax.responseText;
            $(".main_page_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=trending" + "&key=cyuma");

}


$("#Myposts_mainPage").click(function() {
    $("#All_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Latest_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#whereIamTagged_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Trending_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Myposts_mainPage").removeClass("header_0_forum").addClass("header_0_forum_taken");
    $("#search_MainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    //---
    global_var_which_forum_menu = "myposts";
    //--------------------------------
    if (_("main_page_carousel")) {
        main_page_load_all_posts_myposts();
    }
});
//-----------------
function main_page_load_all_posts_myposts() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("main_page_common_user_posts_preview").innerHTML = ajax.responseText;
            $(".main_page_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=myposts" + "&key=cyuma");

}


$("#search_MainPage").click(function() {
    $("#All_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Latest_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#whereIamTagged_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Trending_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#Myposts_mainPage").removeClass("header_0_forum_taken").addClass("header_0_forum");
    $("#search_MainPage").removeClass("header_0_forum").addClass("header_0_forum_taken");
    //---
    global_var_which_forum_menu = "search";
    //------------------------
    if (_("main_page_carousel")) {
        main_page_load_all_posts_search();
    }
});
//-----------------nds_main_page_search_in_posts.php
function main_page_load_all_posts_search() {
    // alert("search");
}

function main_page_load_all_posts_search(obj) {
    if (obj.value.length >= 3) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_search_in_posts.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                showloadingPanel("erase");
                _("main_page_common_user_posts_preview").innerHTML = ajax.responseText;
                $(".main_page_collapsibles_2017").slideUp();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("searchKeyword=" + obj.value + "&key=cyuma");

    }

}

function main_page_load_all_posts_search_click() {
    if (_("main_page_search_posts").value.length >= 3) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_search_in_posts.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                showloadingPanel("erase");
                _("main_page_common_user_posts_preview").innerHTML = ajax.responseText;
                $(".main_page_collapsibles_2017").slideUp();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("searchKeyword=" + _("main_page_search_posts").value + "&key=cyuma");

    }
}

//----Forum menus  highlight on the main page institution-------------------
var global_var_main_page_institution_which_forum_menu = "";
try {
    $("#institution_all").removeClass("forum_activ").addClass("forum_activ_taken");
    $("#institution_latest").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_whereIamTagged").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_trending").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_ourposts").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_search").removeClass("forum_activ_taken").addClass("forum_activ");
    //-----------
    global_var_main_page_institution_which_forum_menu = "all";

} catch(err) {

}
//--------------------------------------------------
$("#institution_all").click(function() {
    $("#institution_all").removeClass("forum_activ").addClass("forum_activ_taken");
    $("#institution_latest").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_whereIamTagged").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_trending").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_ourposts").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_search").removeClass("forum_activ_taken").addClass("forum_activ");
    //-----------
    global_var_main_page_institution_which_forum_menu = "all";
    //-----------
    if (_("main_page_institution_2017_")) {
        main_page_institution_load_all_posts();
    }
});
//--------------------load main page institution all--
function main_page_institution_load_all_posts() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_institution_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("theDownFeedData").innerHTML = ajax.responseText;
            $(".main_page_institution_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=all" + "&key=cyuma");
}


$("#institution_latest").click(function() {
    $("#institution_all").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_latest").removeClass("forum_activ").addClass("forum_activ_taken");
    $("#institution_whereIamTagged").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_trending").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_ourposts").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_search").removeClass("forum_activ_taken").addClass("forum_activ");
    //-----------
    global_var_main_page_institution_which_forum_menu = "latest";
    //------------------
    if (_("main_page_institution_2017_")) {
        main_page_institution_load_all_posts_latest();
    }
});
//-------------main page load latest----
function main_page_institution_load_all_posts_latest() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_institution_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("theDownFeedData").innerHTML = ajax.responseText;
            $(".main_page_institution_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=latest" + "&key=cyuma");

}


$("#institution_whereIamTagged").click(function() {
    $("#institution_all").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_latest").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_whereIamTagged").removeClass("forum_activ").addClass("forum_activ_taken");
    $("#institution_trending").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_ourposts").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_search").removeClass("forum_activ_taken").addClass("forum_activ");
    //-----------
    global_var_main_page_institution_which_forum_menu = "where_i_am_tagged";
    //------------------
    if (_("main_page_institution_2017_")) {
        main_page_institution_load_all_posts_where_i_am_tagged();
    }
});
//-------------mainpage institution where i am tagged----
function main_page_institution_load_all_posts_where_i_am_tagged() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_institution_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("theDownFeedData").innerHTML = ajax.responseText;
            $(".main_page_institution_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=where_i_am_tagged" + "&key=cyuma");

}


$("#institution_trending").click(function() {
    $("#institution_all").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_latest").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_whereIamTagged").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_trending").removeClass("forum_activ").addClass("forum_activ_taken");
    $("#institution_ourposts").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_search").removeClass("forum_activ_taken").addClass("forum_activ");
    //-----------
    global_var_main_page_institution_which_forum_menu = "trending";
    ///--
    if (_("main_page_institution_2017_")) {
        main_page_institution_load_all_posts_trending();

    }
});
//----------main page institution trending-------
function main_page_institution_load_all_posts_trending() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_institution_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("theDownFeedData").innerHTML = ajax.responseText;
            $(".main_page_institution_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=trending" + "&key=cyuma");

}


$("#institution_ourposts").click(function() {
    $("#institution_all").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_latest").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_whereIamTagged").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_trending").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_ourposts").removeClass("forum_activ").addClass("forum_activ_taken");
    $("#institution_search").removeClass("forum_activ_taken").addClass("forum_activ");
    //-----------
    global_var_main_page_institution_which_forum_menu = "myposts";
    ///--
    if (_("main_page_institution_2017_")) {
        main_page_institution_load_all_posts_myposts();
    }
});
//-----------------
function main_page_institution_load_all_posts_myposts() {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "main_page_institution_load_posts_using_tag_menus.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("theDownFeedData").innerHTML = ajax.responseText;
            $(".main_page_institution_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&select_directive=myposts" + "&key=cyuma");

}


$("#institution_search").click(function() {
    $("#institution_all").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_latest").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_whereIamTagged").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_trending").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_ourposts").removeClass("forum_activ_taken").addClass("forum_activ");
    $("#institution_search").removeClass("forum_activ").addClass("forum_activ_taken");
    //-----------
    global_var_main_page_institution_which_forum_menu = "search";

});
//--------------------------------search functions on the main page-------------
function main_page_institution_load_all_posts_search(obj) {
    if (obj.value.length >= 3) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_institution_search_in_posts.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                showloadingPanel("erase");
                _("theDownFeedData").innerHTML = ajax.responseText;
                $(".main_page_institution_collapsibles_2017").slideUp();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("searchKeyword=" + obj.value + "&key=cyuma");

    }

}

//--------------------------
function main_page_institution_load_all_posts_search_click() {
    if (_("main_page_search_posts").value.length >= 3) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_institution_search_in_posts.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                showloadingPanel("erase");
                _("theDownFeedData").innerHTML = ajax.responseText;
                $(".main_page_institution_collapsibles_2017").slideUp();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("searchKeyword=" + _("main_page_search_posts").value + "&key=cyuma");

    }
}

//-----
//-------------------------------Login Handling---
//---hide the msg tickers--
$(document).ready(function() {
    //---------Emoji------
    try {
        hideAll_LoginCallbacks();
        $("#loader_2017_").hide();
    } catch(err) {

    }

});
function hideAll_LoginCallbacks() {
    //--home_individual_fname
    $("#home_individual_fname_wait").hide();
    $("#home_individual_fname_failed").hide();
    $("#home_individual_fname_okay").hide();
    //-------------------
    //--home_individual_lname
    $("#home_individual_lname_wait").hide();
    $("#home_individual_lname_failed").hide();
    $("#home_individual_lname_okay").hide();
    //-------------------
    //--pickBirthDay
    $("#pickBirthDay_wait").hide();
    $("#pickBirthDay_failed").hide();
    $("#pickBirthDay_okay").hide();
    //--home_individual_gender
    $("#home_individual_gender_wait").hide();
    $("#home_individual_gender_failed").hide();
    $("#home_individual_gender_okay").hide();
    //--home_individual_profession
    $("#home_individual_gender_wait").hide();
    $("#home_individual_gender_failed").hide();
    $("#home_individual_gender_okay").hide();
    //--home_individual_username
    $("#home_individual_username_wait").hide();
    $("#home_individual_username_failed").hide();
    $("#home_individual_username_okay").hide();
    //--home_individual_marital_status
    $("#home_individual_marital_status_wait").hide();
    $("#home_individual_marital_status_failed").hide();
    $("#home_individual_marital_status_okay").hide();
    //--home_individual_province
    $("#home_individual_province_wait").hide();
    $("#home_individual_province_failed").hide();
    $("#home_individual_province_okay").hide();
    //--home_individual_district
    $("#home_individual_district_wait").hide();
    $("#home_individual_district_failed").hide();
    $("#home_individual_district_okay").hide();
    //--home_individual_sector
    $("#home_individual_sector_wait").hide();
    $("#home_individual_sector_failed").hide();
    $("#home_individual_sector_okay").hide();
    //--home_individual_email_add
    $("#home_individual_email_add_wait").hide();
    $("#home_individual_email_add_failed").hide();
    $("#home_individual_email_add_okay").hide();
    //--home_individual_password
    $("#home_individual_password_wait").hide();
    $("#home_individual_password_failed").hide();
    $("#home_individual_password_okay").hide();
    //--home_individual_password_retype
    $("#home_individual_password_retype_wait").hide();
    $("#home_individual_password_retype_failed").hide();
    $("#home_individual_password_retype_okay").hide();
    //--home_individual_phone
    $("#home_individual_phone_wait").hide();
    $("#home_individual_phone_failed").hide();
    $("#home_individual_phone_okay").hide();
    //--home_institution_institution
    $("#home_institution_wait").hide();
    $("#home_institution_failed").hide();
    $("#home_institution_okay").hide();
    //--home_institution_website
    $("#home_institution_website_wait").hide();
    $("#home_institution_website_failed").hide();
    $("#home_institution_website_okay").hide();
    //--home_institution_info_email
    $("#home_institution_info_email_wait").hide();
    $("#home_institution_info_email_failed").hide();
    $("#home_institution_info_email_okay").hide();
    //--home_institution_province
    $("#home_institution_province_wait").hide();
    $("#home_institution_province_failed").hide();
    $("#home_institution_province_okay").hide();
    //--home_institution_district
    $("#home_institution_district_wait").hide();
    $("#home_institution_district_failed").hide();
    $("#home_institution_district_okay").hide();
    //--home_institution_sector
    $("#home_institution_sector_wait").hide();
    $("#home_institution_sector_failed").hide();
    $("#home_institution_sector_okay").hide();
    //--home_individual_profession
    $("#home_individual_profession_wait").hide();
    $("#home_individual_profession_failed").hide();
    $("#home_individual_profession_okay").hide();
    //--home_institution_motto
    $("#home_institution_motto_wait").hide();
    $("#home_institution_motto_failed").hide();
    $("#home_institution_motto_okay").hide();
    //--home_institution_username
    $("#home_institution_username_wait").hide();
    $("#home_institution_username_failed").hide();
    $("#home_institution_username_okay").hide();
    //--home_institution_password
    $("#home_institution_password_wait").hide();
    $("#home_institution_password_failed").hide();
    $("#home_institution_password_okay").hide();
    //--home_institution_password_retype
    $("#home_institution_password_retype_wait").hide();
    $("#home_institution_password_retype_failed").hide();
    $("#home_institution_password_retype_okay").hide();
    //--home_official_fname
    $("#home_official_fname_wait").hide();
    $("#home_official_fname_failed").hide();
    $("#home_official_fname_okay").hide();
    //--home_official_lname
    $("#home_official_lname_wait").hide();
    $("#home_official_lname_failed").hide();
    $("#home_official_lname_okay").hide();
    //--home_official_username
    $("#home_official_username_wait").hide();
    $("#home_official_username_failed").hide();
    $("#home_official_username_okay").hide();
    //--home_official_marital_status
    $("#home_official_marital_status_wait").hide();
    $("#home_official_marital_status_failed").hide();
    $("#home_official_marital_status_okay").hide();
    //--home_official_gender
    $("#home_official_gender_wait").hide();
    $("#home_official_gender_failed").hide();
    $("#home_official_gender_okay").hide();
    //--home_official_department
    $("#home_official_department_wait").hide();
    $("#home_official_department_failed").hide();
    $("#home_official_department_okay").hide();
    //--home_official_position
    $("#home_official_position_wait").hide();
    $("#home_official_position_failed").hide();
    $("#home_official_position_okay").hide();
    //--home_official_district
    $("#home_official_district_wait").hide();
    $("#home_official_district_failed").hide();
    $("#home_official_district_okay").hide();
    //--home_official_sector
    $("#home_official_sector_wait").hide();
    $("#home_official_sector_failed").hide();
    $("#home_official_sector_okay").hide();
    //--home_official_work_nber
    $("#home_official_work_nber_wait").hide();
    $("#home_official_work_nber_failed").hide();
    $("#home_official_work_nber_okay").hide();
    //--home_official_company_address_mail
    $("#home_official_company_address_mail_wait").hide();
    $("#home_official_company_address_mail_failed").hide();
    $("#home_official_company_address_mail_okay").hide();
    //--home_official_password
    $("#home_official_password_wait").hide();
    $("#home_official_password_failed").hide();
    $("#home_official_password_okay").hide();
    //--home_official_password_retype
    $("#home_official_password_retype_wait").hide();
    $("#home_official_password_retype_failed").hide();
    $("#home_official_password_retype_okay").hide();
    //--home_institution_institution
    $("#home_institution_institution_wait").hide();
    $("#home_institution_institution_failed").hide();
    $("#home_institution_institution_okay").hide();
    //--home_official_institution_0000
    $("#home_official_institution_0000_wait").hide();
    $("#home_official_institution_0000_failed").hide();
    $("#home_official_institution_0000_okay").hide();
    //--home_official_province
    $("#home_official_province_wait").hide();
    $("#home_official_province_failed").hide();
    $("#home_official_province_okay").hide();
}

//-------------------------------------
function facebook_api_log(first_name, name, gender, email, id, imgUrl) {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "ajax_php_user_scripts/create_account_with_facebook_log.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                //----Registered for the first time

                showloadingPanel("loaded", ajax.responseText);
                window.location = "profile_page.php";
            } else if (parseInt(ajax.responseText) == 2000) {
                //-----already registered
                showloadingPanel("loaded", ajax.responseText);
                window.location = "main_page.php";

            } else {
                showloadingPanel("failed", ajax.responseText);
            }
        } else {
        }
    };
    ajax.send("first_name=" + first_name + "&name=" + name + "&gender=" + gender + "&email=" + email + "&id=" + id + "&choiceLng_name=" + _("34e").value + "&imgUrl=" + imgUrl + "&key=cyuma");

}

function showloadingPanel(statusLoad, response) {
    //------------------

    //alert(response);
    $("#loader_2017_").css("visibility", "visible");
    $("#loader_2017_").css("top", 300 + "px");
    $("#loader_2017_").css("left", -350 + "px");
    $("#loader_2017_").fadeIn();
    $("#loader_2017_").css("position", "fixed");
    switch(statusLoad) {
        case"loading":
            //----------------
            $("#loader_loaded").show();
            $("#loader_done_now").hide();
            $("#loader_2017_").delay(800).fadeOut();
            //-----------
            break;
        case"loaded":
            //----------------
            $("#loader_loaded").hide();
            $("#loader_done_now").show();
            $("#loader_done_now_ok").show();
            $("#loader_done_now_fail").hide();
            $("#loader_2017_").delay(800).fadeOut();
            //-----------
            break;
        case"failed":
            //----------------
            $("#loader_loaded").hide();
            $("#loader_done_now").show();
            $("#loader_done_now_ok").hide();
            $("#loader_done_now_fail").show();
            $("#loader_2017_").delay(800).fadeOut();
            //-----------
            break;
        case"erase":
            //----------------
            $("#loader_2017_").hide().fadeOut();
            //-----------
            break;
    }

}

//---------------------------------
function google_api_log(Name, Email, Id, Name, GivenName, FamilyName, imgUrl) {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "ajax_php_user_scripts/create_account_with_gmail_log.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                //----Registered for the first time

                showloadingPanel("loaded", ajax.responseText);
                window.location = "profile_page.php";
            } else if (parseInt(ajax.responseText) == 2000) {
                //-----already registered
                showloadingPanel("loaded", ajax.responseText);
                window.location = "main_page.php";

            } else {
                showloadingPanel("failed", ajax.responseText);
            }
        } else {
        }
    };
    ajax.send("Name=" + Name + "&Email=" + Email + "&Id=" + Id + "&GivenName=" + GivenName + "&FamilyName=" + FamilyName + "&choiceLng_name=" + _("34e").value + "&imgUrl=" + imgUrl + "&key=cyuma");

}

//------------Normal login---------------------
//---------------Individual Register Or Login--
function create_individual_account_nds() {

    if (_("home_individual_fname").value == "") {
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").show();
        $("#home_individual_fname_okay").hide();
        $("#home_individual_fname").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_fname").offset().top
        }, 1000);
    } else if (_("home_individual_lname").value == "") {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").show();
        $("#home_individual_lname_okay").hide();
        $("#home_individual_lname").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_lname").offset().top
        }, 1000);

    } else if (_("pickBirthDay").value == "") {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").show();
        $("#pickBirthDay_okay").hide();
        $("#pickBirthDay").focus();
        $('html, body').animate({
            scrollTop : $("#pickBirthDay").offset().top
        }, 1000);

    } else if (_("home_individual_gender").value == "") {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").show();
        $("#home_individual_gender_okay").hide();
        $("#home_individual_gender").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_gender").offset().top
        }, 1000);

    } else if (_("home_individual_profession").value == "") {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").show();
        $("#home_individual_profession_okay").hide();
        $("#home_individual_profession").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_profession").offset().top
        }, 1000);

    } else if (!individualUsernameValidation) {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").hide();
        $("#home_individual_profession_okay").show();
        $("#home_individual_username").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_username").offset().top
        }, 1000);

    } else if (_("home_individual_marital_status").value == "") {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").hide();
        $("#home_individual_profession_okay").show();
        //-------username
        //individualUser_nds_validate_Username(_("home_individual_username"));
        //-----------marital status--
        $("#home_individual_marital_status_wait").hide();
        $("#home_individual_marital_status_failed").show();
        $("#home_individual_marital_status_okay").hide();
        $("#home_individual_marital_status").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_marital_status").offset().top
        }, 1000);

    } else if (_("home_individual_province").value == "") {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").hide();
        $("#home_individual_profession_okay").show();
        //-------username
        //individualUser_nds_validate_Username(_("home_individual_username"));
        //-----------marital status--
        $("#home_individual_marital_status_wait").hide();
        $("#home_individual_marital_status_failed").hide();
        $("#home_individual_marital_status_okay").show();
        //--------------province---
        $("#home_individual_province_wait").hide();
        $("#home_individual_province_failed").show();
        $("#home_individual_province_okay").hide();
        //---------
        $("#home_individual_province").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_province").offset().top
        }, 1000);

    } else if (_("home_individual_district").value == "") {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").hide();
        $("#home_individual_profession_okay").show();
        //-------username
        //individualUser_nds_validate_Username(_("home_individual_username"));
        //-----------marital status--
        $("#home_individual_marital_status_wait").hide();
        $("#home_individual_marital_status_failed").hide();
        $("#home_individual_marital_status_okay").show();
        //--------------province---
        $("#home_individual_province_wait").hide();
        $("#home_individual_province_failed").hide();
        $("#home_individual_province_okay").show();
        //---------district
        $("#home_individual_district_wait").hide();
        $("#home_individual_district_failed").show();
        $("#home_individual_district_okay").hide();
        $("#home_individual_district").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_district").offset().top
        }, 1000);

    } else if (_("home_individual_sector").value == "") {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").hide();
        $("#home_individual_profession_okay").show();
        //-------username
        //individualUser_nds_validate_Username(_("home_individual_username"));
        //-----------marital status--
        $("#home_individual_marital_status_wait").hide();
        $("#home_individual_marital_status_failed").hide();
        $("#home_individual_marital_status_okay").show();
        //--------------province---
        $("#home_individual_province_wait").hide();
        $("#home_individual_province_failed").hide();
        $("#home_individual_province_okay").show();
        //---------district
        $("#home_individual_district_wait").hide();
        $("#home_individual_district_failed").hide();
        $("#home_individual_district_okay").show();
        //---------------sector-----------
        $("#home_individual_sector_wait").hide();
        $("#home_individual_sector_failed").show();
        $("#home_individual_sector_okay").hide();
        $("#home_individual_sector").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_sector").offset().top
        }, 1000);

    } else if (!individualEmailValidation) {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").hide();
        $("#home_individual_profession_okay").show();
        //-------username
        //individualUser_nds_validate_Username(_("home_individual_username"));
        //-----------marital status--
        $("#home_individual_marital_status_wait").hide();
        $("#home_individual_marital_status_failed").hide();
        $("#home_individual_marital_status_okay").show();
        //--------------province---
        $("#home_individual_province_wait").hide();
        $("#home_individual_province_failed").hide();
        $("#home_individual_province_okay").show();
        //---------district
        $("#home_individual_district_wait").hide();
        $("#home_individual_district_failed").hide();
        $("#home_individual_district_okay").show();
        //---------------sector-----------
        $("#home_individual_sector_wait").hide();
        $("#home_individual_sector_failed").hide();
        $("#home_individual_sector_okay").show();
        $("#home_individual_email_add").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_email_add").offset().top
        }, 1000);

    } else if (!individualPasswordsValidation) {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").hide();
        $("#home_individual_profession_okay").show();
        //-------username
        //individualUser_nds_validate_Username(_("home_individual_username"));
        //-----------marital status--
        $("#home_individual_marital_status_wait").hide();
        $("#home_individual_marital_status_failed").hide();
        $("#home_individual_marital_status_okay").show();
        //--------------province---
        $("#home_individual_province_wait").hide();
        $("#home_individual_province_failed").hide();
        $("#home_individual_province_okay").show();
        //---------district
        $("#home_individual_district_wait").hide();
        $("#home_individual_district_failed").hide();
        $("#home_individual_district_okay").show();
        //---------------sector-----------
        $("#home_individual_sector_wait").hide();
        $("#home_individual_sector_failed").hide();
        $("#home_individual_sector_okay").show();
        //---------Email---------------
        $("#home_individual_password").focus();

        $('html, body').animate({
            scrollTop : $("#home_individual_password").offset().top
        }, 1000);

    } else if (!individualPhoneValidation) {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").hide();
        $("#home_individual_profession_okay").show();
        //-------username
        //individualUser_nds_validate_Username(_("home_individual_username"));
        //-----------marital status--
        $("#home_individual_marital_status_wait").hide();
        $("#home_individual_marital_status_failed").hide();
        $("#home_individual_marital_status_okay").show();
        //--------------province---
        $("#home_individual_province_wait").hide();
        $("#home_individual_province_failed").hide();
        $("#home_individual_province_okay").show();
        //---------district
        $("#home_individual_district_wait").hide();
        $("#home_individual_district_failed").hide();
        $("#home_individual_district_okay").show();
        //---------------sector-----------
        $("#home_individual_sector_wait").hide();
        $("#home_individual_sector_failed").hide();
        $("#home_individual_sector_okay").show();
        //---------Email---------------
        //individualUser_nds_validate_Email(_("home_individual_email_add"));
        //-----------password---
        //individualUser_nds_validate_Passwords(_("home_individual_password"));
        //----password retype
        //individualUser_nds_validate_Passwords(_("home_individual_password_retype"));
        $("#home_individual_phone").focus();
        $('html, body').animate({
            scrollTop : $("#home_individual_phone").offset().top
        }, 1000);

    } else {
        //------------fname is okay
        $("#home_individual_fname_wait").hide();
        $("#home_individual_fname_failed").hide();
        $("#home_individual_fname_okay").show();
        //------------lname----------------
        $("#home_individual_lname_wait").hide();
        $("#home_individual_lname_failed").hide();
        $("#home_individual_lname_okay").show();
        //------------birth date---
        $("#pickBirthDay_wait").hide();
        $("#pickBirthDay_failed").hide();
        $("#pickBirthDay_okay").show();
        //----------gender---
        $("#home_individual_gender_wait").hide();
        $("#home_individual_gender_failed").hide();
        $("#home_individual_gender_okay").show();
        //==========profession----
        $("#home_individual_profession_wait").hide();
        $("#home_individual_profession_failed").hide();
        $("#home_individual_profession_okay").show();
        //-------username
        //individualUser_nds_validate_Username(_("home_individual_username"));
        //-----------marital status--
        $("#home_individual_marital_status_wait").hide();
        $("#home_individual_marital_status_failed").hide();
        $("#home_individual_marital_status_okay").show();
        //--------------province---
        $("#home_individual_province_wait").hide();
        $("#home_individual_province_failed").hide();
        $("#home_individual_province_okay").show();
        //---------district
        $("#home_individual_district_wait").hide();
        $("#home_individual_district_failed").hide();
        $("#home_individual_district_okay").show();
        //---------------sector-----------
        $("#home_individual_sector_wait").hide();
        $("#home_individual_sector_failed").hide();
        $("#home_individual_sector_okay").show();
        //---------Email---------------
        //----------------save to database
        showloadingPanel("loading");
        var t_000;
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_individual_account_creation.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (this.readyState == 4 && this.status == 200) {
                    if (parseInt(ajax.responseText) == 1000) {
                        window.clearTimeout(t_000);
                        //----Registered for the first time

                        showloadingPanel("loaded", ajax.responseText);
                        window.location = "waiting_pagex.php";
                    } else {
                        showloadingPanel("failed", ajax.responseText);
                    }
                } else {

                }

            } else {

            }
        };
        ajax.send("home_individual_fname=" + _("home_individual_fname").value + "&home_individual_lname=" + _("home_individual_lname").value + "&pickBirthDay=" + _("pickBirthDay").value + "&home_individual_gender=" + _("home_individual_gender").value + "&home_individual_profession=" + _("home_individual_profession").value + "&home_individual_username=" + _("home_individual_username").value + "&home_individual_marital_status=" + _("home_individual_marital_status").value + "&home_individual_province=" + _("home_individual_province").value + "&home_individual_district=" + _("home_individual_district").value + "&home_individual_sector=" + _("home_individual_sector").value + "&home_individual_email_add=" + _("home_individual_email_add").value + "&home_individual_password=" + _("home_individual_password").value + "&home_individual_phone=" + _("home_individual_phone").value + "&choiceLng_name=" + _("34e").value + "&key=cyuma");

    }

}

//----detect change------------

//-----------Individual Account Validate username--
var individualUsernameValidation = false;
function individualUser_nds_validate_Username(obj) {
    //--------------------------------
    if (obj.value != "") {
        $("#home_individual_username_wait").show();
        $("#home_individual_username_failed").hide();
        $("#home_individual_username_okay").hide();

        //---------------
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_username.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //----Registered for the first time
                    $("#home_individual_username_wait").hide();
                    $("#home_individual_username_failed").hide();
                    $("#home_individual_username_okay").show();
                    //--------------------------
                    individualUsernameValidation = true;
                } else {
                    //-----already registered
                    $("#home_individual_username_wait").hide();
                    $("#home_individual_username_failed").show();
                    $("#home_individual_username_okay").hide();
                    //----------
                    individualUsernameValidation = false;

                }
            } else {
                individualUsernameValidation = false;
            }
        };
        ajax.send("userNameVal=" + obj.value + "&key=cyuma");
    } else {
        $("#home_individual_username_wait").hide();
        $("#home_individual_username_failed").show();
        $("#home_individual_username_okay").hide();
        individualUsernameValidation = false;
    }

}

//-----------Individual Account Validate email--
var individualEmailValidation = false;
function individualUser_nds_validate_Email(obj) {
    if (obj.value != "") {
        $("#home_individual_email_add_wait").show();
        var x = obj.value;
        var atpos = x.indexOf("@");
        var dotpos = x.lastIndexOf(".");
        if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
            $("#home_individual_email_add_wait").delay(200).hide();
            $("#home_individual_email_add_failed").delay(500).show();
            $("#home_individual_email_add_okay").hide();
            //-----------------
            individualEmailValidation = false;
        } else {
            $("#home_individual_email_add_wait").delay(200).hide();
            $("#home_individual_email_add_failed").hide();
            $("#home_individual_email_add_okay").delay(500).show();
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_email.php");
            //------------------------------------------
            $("#home_individual_email_add_wait").show();
            $("#home_individual_email_add_failed").hide();
            $("#home_individual_email_add_okay").hide();
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        //----Registered for the first time
                        $("#home_individual_email_add_wait").hide();
                        $("#home_individual_email_add_failed").hide();
                        $("#home_individual_email_add_okay").show();
                        //--------------------------
                        individualEmailValidation = true;
                    } else {
                        //-----already registered
                        $("#home_individual_email_add_wait").hide();
                        $("#home_individual_email_add_failed").show();
                        $("#home_individual_email_add_okay").hide();
                        //---------
                        individualEmailValidation = false;

                    }
                } else {
                    individualEmailValidation = false;
                }
            };
            ajax.send("userEmailVal=" + obj.value + "&key=cyuma");
        }
    } else {
        $("#home_individual_email_add_wait").hide();
        $("#home_individual_email_add_failed").show();
        $("#home_individual_email_add_okay").hide();
        individualEmailValidation = false;
    }
}

//-----------Individual Account Validate phone--
var individualPhoneValidation = false;
function individualUser_nds_validate_Phone(obj, e) {
    if (obj.value != "") {
        //---------------
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
        // Allow: Ctrl+A
        (e.keyCode == 65 && e.ctrlKey === true) ||
        // Allow: home, end, left, right
        (e.keyCode >= 35 && e.keyCode <= 39)) {
            // let it happen, don't do anything
            return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
        //-------------
        $("#home_individual_phone_wait").show();
        if ((obj.value.length < 12)) {
            $("#home_individual_phone_wait").delay(200).hide();
            $("#home_individual_phone_failed").delay(500).show();
            $("#home_individual_phone_okay").hide();
            //---------
            individualPhoneValidation = false;
        } else {
            $("#home_individual_phone_wait").delay(200).hide();
            $("#home_individual_phone_failed").hide();
            $("#home_individual_phone_okay").delay(500).show();
            //----------------
            individualPhoneValidation = true;
        }
    } else {
        $("#home_individual_phone_wait").delay(200).hide();
        $("#home_individual_phone_failed").delay(500).show();
        $("#home_individual_phone_okay").hide();
        //---------
        individualPhoneValidation = false;
    }

}

//-----------Individual Account Validate passwords--
var individualPasswordsValidation = false;
function individualUser_nds_validate_Passwords(obj) {
    if (obj.value != "") {
        switch(obj.id) {
            case "home_individual_password":
                if (_("home_individual_password").value == "") {
                    $("#home_individual_password_wait").hide();
                    $("#home_individual_password_failed").show();
                    $("#home_individual_password_okay").hide();

                } else if (_("home_individual_password").value != "") {
                    $("#home_individual_password_wait").hide();
                    $("#home_individual_password_failed").hide();
                    $("#home_individual_password_okay").show();

                }
                break;
            case "home_individual_password_retype":
                if (_("home_individual_password_retype").value == "") {
                    $("#home_individual_password_retype_wait").hide();
                    $("#home_individual_password_retype_failed").show();
                    $("#home_individual_password_retype_okay").hide();
                } else if (_("home_individual_password_retype").value != "") {
                    $("#home_individual_password_retype_wait").hide();
                    $("#home_individual_password_retype_failed").hide();
                    $("#home_individual_password_retype_okay").show();
                    //-------------------------------------------
                    if (_("home_individual_password").value != _("home_individual_password_retype").value) {
                        $("#home_individual_password_wait").hide();
                        $("#home_individual_password_failed").show();
                        $("#home_individual_password_okay").hide();
                        //-------------
                        $("#home_individual_password_retype_wait").hide();
                        $("#home_individual_password_retype_failed").show();
                        $("#home_individual_password_retype_okay").hide();
                        individualPasswordsValidation = false;
                    } else if (_("home_individual_password").value == _("home_individual_password_retype").value) {
                        $("#home_individual_password_wait").hide();
                        $("#home_individual_password_failed").hide();
                        $("#home_individual_password_okay").show();
                        //-------------
                        $("#home_individual_password_retype_wait").hide();
                        $("#home_individual_password_retype_failed").hide();
                        $("#home_individual_password_retype_okay").show();
                        individualPasswordsValidation = true;

                    }
                }
                break;
            default:
                if (_("home_individual_password").value != _("home_individual_password_retype").value) {
                    $("#home_individual_password_wait").hide();
                    $("#home_individual_password_failed").show();
                    $("#home_individual_password_okay").hide();
                    //-------------
                    $("#home_individual_password_retype_wait").hide();
                    $("#home_individual_password_retype_failed").show();
                    $("#home_individual_password_retype_okay").hide();
                    individualPasswordsValidation = false;
                } else if (_("home_individual_password").value == _("home_individual_password_retype").value) {
                    $("#home_individual_password_wait").hide();
                    $("#home_individual_password_failed").hide();
                    $("#home_individual_password_okay").show();
                    //-------------
                    $("#home_individual_password_retype_wait").hide();
                    $("#home_individual_password_retype_failed").hide();
                    $("#home_individual_password_retype_okay").show();
                    individualPasswordsValidation = true;
                }
                break;

        }
    } else {
        $("#home_individual_password_wait").hide();
        $("#home_individual_password_failed").show();
        $("#home_individual_password_okay").hide();
        //-------------
        $("#home_individual_password_retype_wait").hide();
        $("#home_individual_password_retype_failed").show();
        $("#home_individual_password_retype_okay").hide();
        individualPasswordsValidation = false;
    }

}

//---------------Institution Register Or Login--
function create_institution_account_nds() {
    if (_("home_institution_institution").value == "") {
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").show();
        $("#home_institution_institution_okay").hide();
        $("#home_institution_institution").focus();
        $('html, body').animate({
            scrollTop : $("#home_institution_institution").offset().top
        }, 1000);

    } else if (!institutionWebsiteValidation) {
        //--------institution--
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").hide();
        $("#home_institution_institution_okay").show();
        //----------website----
        $("#home_institution_website_wait").hide();
        $("#home_institution_website_failed").show();
        $("#home_institution_website_okay").hide();
        //---------
        $("#home_institution_website").focus();
        $('html, body').animate({
            scrollTop : $("#home_institution_website").offset().top
        }, 1000);

    } else if (!institutionEmailValidation) {
        //--------institution--
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").hide();
        $("#home_institution_institution_okay").show();
        //----------website----
        $("#home_institution_website_wait").hide();
        $("#home_institution_website_failed").hide();
        $("#home_institution_website_okay").show();
        //----------website----
        $("#home_institution_info_email_wait").hide();
        $("#home_institution_info_email_failed").show();
        $("#home_institution_info_email_okay").hide();
        //---------
        $("#home_institution_info_email").focus();
        $('html, body').animate({
            scrollTop : $("#home_institution_info_email").offset().top
        }, 1000);

    } else if (_("home_institution_province").value == "") {
        //--------institution--
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").hide();
        $("#home_institution_institution_okay").show();
        //----------website----
        $("#home_institution_website_wait").hide();
        $("#home_institution_website_failed").hide();
        $("#home_institution_website_okay").show();
        //----------website----
        $("#home_institution_info_email_wait").hide();
        $("#home_institution_info_email_failed").hide();
        $("#home_institution_info_email_okay").show();
        //----------province----
        $("#home_institution_province_wait").hide();
        $("#home_institution_province_failed").show();
        $("#home_institution_province_okay").hide();
        //---------
        $("#home_institution_province").focus();
        $('html, body').animate({
            scrollTop : $("#home_institution_province").offset().top
        }, 1000);

    } else if (_("home_institution_district").value == "") {
        //--------institution--
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").hide();
        $("#home_institution_institution_okay").show();
        //----------website----
        $("#home_institution_website_wait").hide();
        $("#home_institution_website_failed").hide();
        $("#home_institution_website_okay").show();
        //----------website----
        $("#home_institution_info_email_wait").hide();
        $("#home_institution_info_email_failed").hide();
        $("#home_institution_info_email_okay").show();
        //----------province----
        $("#home_institution_province_wait").hide();
        $("#home_institution_province_failed").hide();
        $("#home_institution_province_okay").show();
        //----------district----
        $("#home_institution_district_wait").hide();
        $("#home_institution_district_failed").show();
        $("#home_institution_district_okay").hide();
        //---------
        $("#home_institution_district").focus();
        $('html, body').animate({
            scrollTop : $("#home_institution_district").offset().top
        }, 1000);
    } else if (_("home_institution_sector").value == "") {
        //--------institution--
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").hide();
        $("#home_institution_institution_okay").show();
        //----------website----
        $("#home_institution_website_wait").hide();
        $("#home_institution_website_failed").hide();
        $("#home_institution_website_okay").show();
        //----------website----
        $("#home_institution_info_email_wait").hide();
        $("#home_institution_info_email_failed").hide();
        $("#home_institution_info_email_okay").show();
        //----------province----
        $("#home_institution_province_wait").hide();
        $("#home_institution_province_failed").hide();
        $("#home_institution_province_okay").show();
        //----------district----
        $("#home_institution_district_wait").hide();
        $("#home_institution_district_failed").hide();
        $("#home_institution_district_okay").show();
        //----------Sector----
        $("#home_institution_sector_wait").hide();
        $("#home_institution_sector_failed").show();
        $("#home_institution_sector_okay").hide();
        //---------
        $("#home_institution_sector").focus();
        $('html, body').animate({
            scrollTop : $("#home_institution_sector").offset().top
        }, 1000);

    } else if (_("home_institution_motto").value == "") {
        //--------institution--
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").hide();
        $("#home_institution_institution_okay").show();
        //----------website----
        $("#home_institution_website_wait").hide();
        $("#home_institution_website_failed").hide();
        $("#home_institution_website_okay").show();
        //----------website----
        $("#home_institution_info_email_wait").hide();
        $("#home_institution_info_email_failed").hide();
        $("#home_institution_info_email_okay").show();
        //----------province----
        $("#home_institution_province_wait").hide();
        $("#home_institution_province_failed").hide();
        $("#home_institution_province_okay").show();
        //----------district----
        $("#home_institution_district_wait").hide();
        $("#home_institution_district_failed").hide();
        $("#home_institution_district_okay").show();
        //----------Sector----
        $("#home_institution_sector_wait").hide();
        $("#home_institution_sector_failed").hide();
        $("#home_institution_sector_okay").show();
        //----------Motto----
        $("#home_institution_motto_wait").hide();
        $("#home_institution_motto_failed").show();
        $("#home_institution_motto_okay").hide();
        //---------
        $("#home_institution_motto").focus();
        $('html, body').animate({
            scrollTop : $("#home_institution_motto").offset().top
        }, 1000);

    } else if (!institutionUsernameValidation) {
        //--------institution--
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").hide();
        $("#home_institution_institution_okay").show();
        //----------website----
        $("#home_institution_website_wait").hide();
        $("#home_institution_website_failed").hide();
        $("#home_institution_website_okay").show();
        //----------website----
        $("#home_institution_info_email_wait").hide();
        $("#home_institution_info_email_failed").hide();
        $("#home_institution_info_email_okay").show();
        //----------province----
        $("#home_institution_province_wait").hide();
        $("#home_institution_province_failed").hide();
        $("#home_institution_province_okay").show();
        //----------district----
        $("#home_institution_district_wait").hide();
        $("#home_institution_district_failed").hide();
        $("#home_institution_district_okay").show();
        //----------Sector----
        $("#home_institution_sector_wait").hide();
        $("#home_institution_sector_failed").hide();
        $("#home_institution_sector_okay").show();
        //----------Motto----
        $("#home_institution_motto_wait").hide();
        $("#home_institution_motto_failed").hide();
        $("#home_institution_motto_okay").show();
        //----------username----
        $("#home_institution_username_wait").hide();
        $("#home_institution_username_failed").show();
        $("#home_institution_username_okay").hide();
        //---------

        $("#home_institution_username").focus();
        $('html, body').animate({
            scrollTop : $("#home_institution_username").offset().top
        }, 1000);

    } else if (!institutionPasswordsValidation) {
        //--------institution--
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").hide();
        $("#home_institution_institution_okay").show();
        //----------website----
        $("#home_institution_website_wait").hide();
        $("#home_institution_website_failed").hide();
        $("#home_institution_website_okay").show();
        //----------website----
        $("#home_institution_info_email_wait").hide();
        $("#home_institution_info_email_failed").hide();
        $("#home_institution_info_email_okay").show();
        //----------province----
        $("#home_institution_province_wait").hide();
        $("#home_institution_province_failed").hide();
        $("#home_institution_province_okay").show();
        //----------district----
        $("#home_institution_district_wait").hide();
        $("#home_institution_district_failed").hide();
        $("#home_institution_district_okay").show();
        //----------Sector----
        $("#home_institution_sector_wait").hide();
        $("#home_institution_sector_failed").hide();
        $("#home_institution_sector_okay").show();
        //----------Motto----
        $("#home_institution_motto_wait").hide();
        $("#home_institution_motto_failed").hide();
        $("#home_institution_motto_okay").show();
        //----------username----
        $("#home_institution_username_wait").hide();
        $("#home_institution_username_failed").show();
        $("#home_institution_username_okay").hide();
        //---------

        $("#home_institution_password").focus();
        $('html, body').animate({
            scrollTop : $("#home_institution_password").offset().top
        }, 1000);

    } else {
        //--------institution--
        $("#home_institution_institution_wait").hide();
        $("#home_institution_institution_failed").hide();
        $("#home_institution_institution_okay").show();
        //----------website----
        $("#home_institution_website_wait").hide();
        $("#home_institution_website_failed").hide();
        $("#home_institution_website_okay").show();
        //----------website----
        $("#home_institution_info_email_wait").hide();
        $("#home_institution_info_email_failed").hide();
        $("#home_institution_info_email_okay").show();
        //----------province----
        $("#home_institution_province_wait").hide();
        $("#home_institution_province_failed").hide();
        $("#home_institution_province_okay").show();
        //----------district----
        $("#home_institution_district_wait").hide();
        $("#home_institution_district_failed").hide();
        $("#home_institution_district_okay").show();
        //----------Sector----
        $("#home_institution_sector_wait").hide();
        $("#home_institution_sector_failed").hide();
        $("#home_institution_sector_okay").show();
        //----------Motto----
        $("#home_institution_motto_wait").hide();
        $("#home_institution_motto_failed").hide();
        $("#home_institution_motto_okay").show();
        //----------username----
        $("#home_institution_username_wait").hide();
        $("#home_institution_username_failed").hide();
        $("#home_institution_username_okay").show();
        //alert("good to go");
        //---------------------
        showloadingPanel("loading");
        var t_000;
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_institution_account_creation.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (this.readyState == 4 && this.status == 200) {
                    if (parseInt(ajax.responseText) == 1000) {
                        window.clearTimeout(t_000);
                        //----Registered for the first time

                        showloadingPanel("loaded", ajax.responseText);
                        window.location = "waiting_pagex_institution.php";
                    } else {
                        showloadingPanel("failed", ajax.responseText);
                    }
                } else {

                }

            } else {

            }
        };
        ajax.send("home_institution_institution=" + _("home_institution_institution").value + "&home_institution_website=" + _("home_institution_website").value + "&home_institution_info_email=" + _("home_institution_info_email").value + "&home_institution_province=" + _("home_institution_province").value + "&home_institution_district=" + _("home_institution_district").value + "&home_institution_sector=" + _("home_institution_sector").value + "&home_institution_motto=" + _("home_institution_motto").value + "&home_institution_username=" + _("home_institution_username").value + "&home_institution_password=" + _("home_institution_password").value + "&choiceLng_name=" + _("34e").value + "&key=cyuma");

    }
}

//-----------Institution Account Validate website--
var institutionWebsiteValidation = false;
function institutionUser_nds_validate_Website(obj) {
    $("#home_institution_website_wait").show();
    var pattern = new RegExp('^(https?:\\//\\//)?' + // protocol
    '((([a-z\\d]([a-z\\d-]*[a-z\d])*)\\.)+[a-z]{2,}|' + // domain name
    '((\\d{1,3}\\.){3}\\d{1,3}))' + // OR ip (v4) address
    '(\\:\d+)?(\\//[-a-z\\d%_.~+]*)*' + // port and path
    '(\\?[;&a-z\\d%_.~+=-]*)?' + // query string
    '(\\#[-a-z\\d_]*)?$', 'i');
    // fragment locater
    if (!pattern.test(obj.value)) {
        $("#home_institution_website_wait").delay(200).hide();
        $("#home_institution_website_failed").delay(500).show();
        $("#home_institution_website_okay").hide();
        //alert("Please enter a valid URL.");
        // return false;
        institutionWebsiteValidation = false;
    } else {
        $("#home_institution_website_wait").delay(200).hide();
        $("#home_institution_website_failed").hide();
        $("#home_institution_website_okay").delay(500).show();
        institutionWebsiteValidation = true;
    }

}

//-----------Institution Account Validate email--
var institutionEmailValidation = false;
function institutionUser_nds_validate_Email(obj) {
    $("#home_institution_info_email_wait").show();
    var x = obj.value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
        $("#home_institution_info_email_wait").delay(200).hide();
        $("#home_institution_info_email_failed").delay(500).show();
        $("#home_institution_info_email_okay").hide();
        //--
        institutionEmailValidation = false;
    } else {
        $("#home_institution_info_email_wait").delay(200).hide();
        $("#home_institution_info_email_failed").hide();
        $("#home_institution_info_email_okay").delay(500).show();
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_email.php");
        //------------------------------------------
        $("#home_institution_info_email_wait").show();
        $("#home_institution_info_email_failed").hide();
        $("#home_official_company_address_mail_okay").hide();
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //----Registered for the first time
                    $("#home_institution_info_email_wait").hide();
                    $("#home_institution_info_email_failed").hide();
                    $("#home_institution_info_email_okay").show();
                    //--------------------------
                    institutionEmailValidation = true;
                } else {
                    //-----already registered
                    $("#home_institution_info_email_wait").hide();
                    $("#home_institution_info_email_failed").show();
                    $("#home_institution_info_email_okay").hide();
                    //------
                    institutionEmailValidation = false;

                }
            } else {
                //-----already registered
                $("#home_institution_info_email_wait").hide();
                $("#home_institution_info_email_failed").show();
                $("#home_institution_info_email_okay").hide();
                //------------
                institutionEmailValidation = false;
            }
        };
        ajax.send("userEmailVal=" + obj.value + "&key=cyuma");
    }
}

//-----------Institution Account Validate username--
var institutionUsernameValidation = false;
function institutionUser_nds_validate_Username(obj) {
    if (obj.value != "") {
        //---------------
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_username.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //----Registered for the first time
                    $("#home_institution_username_wait").hide();
                    $("#home_institution_username_failed").hide();
                    $("#home_institution_username_okay").show();
                    //--------------------------
                    institutionUsernameValidation = true;
                } else {
                    //-----already registered
                    $("#home_institution_username_wait").hide();
                    $("#home_institution_username_failed").show();
                    $("#home_institution_username_okay").hide();
                    //----------------
                    institutionUsernameValidation = false;

                }
            } else {
                institutionUsernameValidation = false;
            }
        };
        ajax.send("userNameVal=" + obj.value + "&key=cyuma");
    } else {
        //-----already registered
        $("#home_institution_username_wait").hide();
        $("#home_institution_username_failed").show();
        $("#home_institution_username_okay").hide();
        //----------------
        institutionUsernameValidation = false;

    }
}

//-----------Institution Account Validate passwords--
var institutionPasswordsValidation = false;
function institutionUser_nds_validate_Passwords(obj) {
    if (obj.value != "") {
        switch(obj.id) {
            case "home_institution_password":
                if (_("home_institution_password").value == "") {
                    $("#home_institution_password_wait").hide();
                    $("#home_institution_password_failed").show();
                    $("#home_institution_password_okay").hide();

                } else if (_("home_institution_password").value != "") {
                    $("#home_institution_password_wait").hide();
                    $("#home_institution_password_failed").hide();
                    $("#home_institution_password_okay").show();

                }
                break;
            case "home_institution_password_retype":
                if (_("home_institution_password_retype").value == "") {
                    $("#home_institution_password_retype_wait").hide();
                    $("#home_institution_password_retype_failed").show();
                    $("#home_institution_password_retype_okay").hide();
                } else if (_("home_institution_password_retype").value != "") {
                    $("#home_institution_password_retype_wait").hide();
                    $("#home_institution_password_retype_failed").hide();
                    $("#home_institution_password_retype_okay").show();
                    //---
                    if (_("home_institution_password").value != _("home_institution_password_retype").value) {
                        $("#home_institution_password_wait").hide();
                        $("#home_institution_password_failed").show();
                        $("#home_institution_password_okay").hide();
                        //-------------
                        $("#home_institution_password_retype_wait").hide();
                        $("#home_institution_password_retype_failed").show();
                        $("#home_institution_password_retype_okay").hide();
                        institutionPasswordsValidation = false;
                    } else if (_("home_individual_password").value == _("home_individual_password_retype").value) {
                        $("#home_institution_password_wait").hide();
                        $("#home_institution_password_failed").hide();
                        $("#home_institution_password_okay").show();
                        //-------------
                        $("#home_institution_password_retype_wait").hide();
                        $("#home_institution_password_retype_failed").hide();
                        $("#home_institution_password_retype_okay").show();
                        institutionPasswordsValidation = true;
                    }
                }
                break;
            default:
                if (_("home_institution_password").value != _("home_institution_password_retype").value) {
                    $("#home_institution_password_wait").hide();
                    $("#home_institution_password_failed").show();
                    $("#home_institution_password_okay").hide();
                    //-------------
                    $("#home_institution_password_retype_wait").hide();
                    $("#home_institution_password_retype_failed").show();
                    $("#home_institution_password_retype_okay").hide();
                    //------------
                    institutionPasswordsValidation = false;
                } else if (_("home_individual_password").value == _("home_individual_password_retype").value) {
                    $("#home_institution_password_wait").hide();
                    $("#home_institution_password_failed").hide();
                    $("#home_institution_password_okay").show();
                    //-------------
                    $("#home_institution_password_retype_wait").hide();
                    $("#home_institution_password_retype_failed").hide();
                    $("#home_institution_password_retype_okay").show();
                    //-----------
                    institutionPasswordsValidation = true;

                }
                break;
        }
    } else {
        $("#home_institution_password_wait").hide();
        $("#home_institution_password_failed").show();
        $("#home_institution_password_okay").hide();
        //-------------
        $("#home_institution_password_retype_wait").hide();
        $("#home_institution_password_retype_failed").show();
        $("#home_institution_password_retype_okay").hide();
        //------------
        institutionPasswordsValidation = false;
    }

}

//---------------Institution Register Or Login--
function create_institution_official_account_nds() {
    if (_("home_official_fname").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").show();
        $("#home_official_fname_okay").hide();
        //=============
        $("#home_official_fname").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_fname").offset().top
        }, 1000);

    } else if (_("home_official_lname").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").show();
        $("#home_official_lname_okay").hide();
        //=============
        $("#home_official_lname").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_lname").offset().top
        }, 1000);

    } else if (!officialUsernameValidation) {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-----------------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").show();
        $("#home_official_username_okay").hide();
        //=============
        $("#home_official_username").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_username").offset().top
        }, 1000);
    } else if (_("home_official_marital_status").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").show();
        $("#home_official_marital_status_okay").hide();
        //=============
        $("#home_official_marital_status").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_marital_status").offset().top
        }, 1000);
    } else if (_("home_official_gender").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").show();
        $("#home_official_gender_okay").hide();

        //=============
        $("#home_official_gender").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_gender").offset().top
        }, 1000);

    } else if (_("home_official_institution_0000").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").hide();
        $("#home_official_gender_okay").show();
        //-------institution name----------
        $("#home_official_institution_0000_wait").hide();
        $("#home_official_institution_0000_failed").show();
        $("#home_official_institution_0000_okay").hide();

        //=============
        $("#home_official_institution_0000").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_institution_0000").offset().top
        }, 1000);

    } else if (_("home_official_department").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").hide();
        $("#home_official_gender_okay").show();
        //-------institution name----------
        $("#home_official_institution_0000_wait").hide();
        $("#home_official_institution_0000_failed").hide();
        $("#home_official_institution_0000_okay").show();
        //-------department----------
        $("#home_official_department_wait").hide();
        $("#home_official_department_failed").hide();
        $("#home_official_department_okay").show();

        //=============
        $("#home_official_department").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_department").offset().top
        }, 1000);

    } else if (_("home_official_position").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").hide();
        $("#home_official_gender_okay").show();
        //-------institution name----------
        $("#home_official_institution_0000_wait").hide();
        $("#home_official_institution_0000_failed").hide();
        $("#home_official_institution_0000_okay").show();
        //-------Department----------
        $("#home_official_department_wait").hide();
        $("#home_official_department_failed").hide();
        $("#home_official_department_okay").show();
        //-------Position----------
        $("#home_official_position_wait").hide();
        $("#home_official_position_failed").show();
        $("#home_official_position_okay").hide();

        //=============
        $("#home_official_position").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_position").offset().top
        }, 1000);

    } else if (_("home_official_province").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").hide();
        $("#home_official_gender_okay").show();
        //-------institution name----------
        $("#home_official_institution_0000_wait").hide();
        $("#home_official_institution_0000_failed").hide();
        $("#home_official_institution_0000_okay").show();
        //-------Department----------
        $("#home_official_department_wait").hide();
        $("#home_official_department_failed").hide();
        $("#home_official_department_okay").show();
        //-------Position----------
        $("#home_official_position_wait").hide();
        $("#home_official_position_failed").hide();
        $("#home_official_position_okay").show();
        //-------Province----------
        $("#home_official_province_wait").hide();
        $("#home_official_province_failed").show();
        $("#home_official_province_okay").hide();

        //=============
        $("#home_official_province").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_province").offset().top
        }, 1000);

    } else if (_("home_official_district").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").hide();
        $("#home_official_gender_okay").show();
        //-------institution name----------
        $("#home_official_institution_0000_wait").hide();
        $("#home_official_institution_0000_failed").hide();
        $("#home_official_institution_0000_okay").show();
        //-------Department----------
        $("#home_official_department_wait").hide();
        $("#home_official_department_failed").hide();
        $("#home_official_department_okay").show();
        //-------Position----------
        $("#home_official_position_wait").hide();
        $("#home_official_position_failed").hide();
        $("#home_official_position_okay").show();
        //-------Province----------
        $("#home_official_province_wait").hide();
        $("#home_official_province_failed").hide();
        $("#home_official_province_okay").show();
        //-------District----------
        $("#home_official_district_wait").hide();
        $("#home_official_district_failed").show();
        $("#home_official_district_okay").hide();

        //=============
        $("#home_official_district").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_district").offset().top
        }, 1000);
    } else if (_("home_official_sector").value == "") {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").hide();
        $("#home_official_gender_okay").show();
        //-------institution name----------
        $("#home_official_institution_0000_wait").hide();
        $("#home_official_institution_0000_failed").hide();
        $("#home_official_institution_0000_okay").show();
        //-------Department----------
        $("#home_official_department_wait").hide();
        $("#home_official_department_failed").hide();
        $("#home_official_department_okay").show();
        //-------Position----------
        $("#home_official_position_wait").hide();
        $("#home_official_position_failed").hide();
        $("#home_official_position_okay").show();
        //-------Province----------
        $("#home_official_province_wait").hide();
        $("#home_official_province_failed").hide();
        $("#home_official_province_okay").show();
        //-------District----------
        $("#home_official_district_wait").hide();
        $("#home_official_district_failed").hide();
        $("#home_official_district_okay").show();
        //-------Sector----------
        $("#home_official_sector_wait").hide();
        $("#home_official_sector_failed").show();
        $("#home_official_sector_okay").hide();

        //=============
        $("#home_official_sector").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_sector").offset().top
        }, 1000);

    } else if (!officialPhoneValidation) {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").hide();
        $("#home_official_gender_okay").show();
        //-------institution name----------
        $("#home_official_institution_0000_wait").hide();
        $("#home_official_institution_0000_failed").hide();
        $("#home_official_institution_0000_okay").show();
        //-------Department----------
        $("#home_official_department_wait").hide();
        $("#home_official_department_failed").hide();
        $("#home_official_department_okay").show();
        //-------Position----------
        $("#home_official_position_wait").hide();
        $("#home_official_position_failed").hide();
        $("#home_official_position_okay").show();
        //-------Province----------
        $("#home_official_province_wait").hide();
        $("#home_official_province_failed").hide();
        $("#home_official_province_okay").show();
        //-------District----------
        $("#home_official_district_wait").hide();
        $("#home_official_district_failed").hide();
        $("#home_official_district_okay").show();
        //-------Sector----------
        $("#home_official_sector_wait").hide();
        $("#home_official_sector_failed").hide();
        $("#home_official_sector_okay").show();
        //-------official nber----------
        $("#home_official_work_nber_wait").hide();
        $("#home_official_work_nber_failed").show();
        $("#home_official_work_nber_okay").hide();

        //=============
        $("#home_official_work_nber").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_work_nber").offset().top
        }, 1000);

    } else if (!officialEmailValidation) {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").hide();
        $("#home_official_gender_okay").show();
        //-------institution name----------
        $("#home_official_institution_0000_wait").hide();
        $("#home_official_institution_0000_failed").hide();
        $("#home_official_institution_0000_okay").show();
        //-------Department----------
        $("#home_official_department_wait").hide();
        $("#home_official_department_failed").hide();
        $("#home_official_department_okay").show();
        //-------Position----------
        $("#home_official_position_wait").hide();
        $("#home_official_position_failed").hide();
        $("#home_official_position_okay").show();
        //-------Province----------
        $("#home_official_province_wait").hide();
        $("#home_official_province_failed").hide();
        $("#home_official_province_okay").show();
        //-------District----------
        $("#home_official_district_wait").hide();
        $("#home_official_district_failed").hide();
        $("#home_official_district_okay").show();
        //-------Sector----------
        $("#home_official_sector_wait").hide();
        $("#home_official_sector_failed").hide();
        $("#home_official_sector_okay").show();
        //-------official nber----------
        $("#home_official_work_nber_wait").hide();
        $("#home_official_work_nber_failed").hide();
        $("#home_official_work_nber_okay").show();
        //-------Email ----------
        $("#home_official_company_address_mail_wait").hide();
        $("#home_official_company_address_mail_failed").show();
        $("#home_official_company_address_mail_okay").hide();

        //=============
        $("#home_official_company_address_mail").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_company_address_mail").offset().top
        }, 1000);

    } else if (!officialPasswordsValidation) {
        $("#home_official_fname_wait").hide();
        $("#home_official_fname_failed").hide();
        $("#home_official_fname_okay").show();
        //-----------------
        $("#home_official_lname_wait").hide();
        $("#home_official_lname_failed").hide();
        $("#home_official_lname_okay").show();
        //-------username----------
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").hide();
        $("#home_official_username_okay").show();
        //-------marital status----------
        $("#home_official_marital_status_wait").hide();
        $("#home_official_marital_status_failed").hide();
        $("#home_official_marital_status_okay").show();
        //-------Gender----------
        $("#home_official_gender_wait").hide();
        $("#home_official_gender_failed").hide();
        $("#home_official_gender_okay").show();
        //-------institution name----------
        $("#home_official_institution_0000_wait").hide();
        $("#home_official_institution_0000_failed").hide();
        $("#home_official_institution_0000_okay").show();
        //-------Department----------
        $("#home_official_department_wait").hide();
        $("#home_official_department_failed").hide();
        $("#home_official_department_okay").show();
        //-------Position----------
        $("#home_official_position_wait").hide();
        $("#home_official_position_failed").hide();
        $("#home_official_position_okay").show();
        //-------Province----------
        $("#home_official_province_wait").hide();
        $("#home_official_province_failed").hide();
        $("#home_official_province_okay").show();
        //-------District----------
        $("#home_official_district_wait").hide();
        $("#home_official_district_failed").hide();
        $("#home_official_district_okay").show();
        //-------Sector----------
        $("#home_official_sector_wait").hide();
        $("#home_official_sector_failed").hide();
        $("#home_official_sector_okay").show();
        //-------official nber----------
        $("#home_official_work_nber_wait").hide();
        $("#home_official_work_nber_failed").hide();
        $("#home_official_work_nber_okay").show();

        //=============
        $("#home_official_password").focus();
        $('html, body').animate({
            scrollTop : $("#home_official_password").offset().top
        }, 1000);

    } else {
        //alert("Good to go!");
        showloadingPanel("loading");
        var t_000;
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_institution_official_account_creation.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (this.readyState == 4 && this.status == 200) {
                    if (parseInt(ajax.responseText) == 1000) {
                        window.clearTimeout(t_000);
                        //----Registered for the first time

                        showloadingPanel("loaded", ajax.responseText);
                        alert("Your credentials are well received, you need to wait for the Administrator of your Institution to activate your account for further access!!!!");
                        window.location = "index.php";
                    } else {
                        showloadingPanel("failed", ajax.responseText);
                        //alert(ajax.responseText);
                    }
                } else {

                }

            } else {

            }
        };
        ajax.send("home_official_fname=" + _("home_official_fname").value + "&home_official_lname=" + _("home_official_lname").value + "&home_official_username=" + _("home_official_username").value + "&home_official_marital_status=" + _("home_official_marital_status").value + "&home_official_gender=" + _("home_official_gender").value + "&home_official_institution_0000=" + _("home_official_institution_0000").value + "&home_official_department=" + _("home_official_department").value + "&home_official_position=" + _("home_official_position").value + "&home_official_province=" + _("home_official_province").value + "&home_official_district=" + _("home_official_district").value + "&home_official_sector=" + _("home_official_sector").value + "&home_official_work_nber=" + _("home_official_work_nber").value + "&home_official_company_address_mail=" + _("home_official_company_address_mail").value + "&home_official_password=" + _("home_official_password").value + "&choiceLng_name=" + _("34e").value + "&key=cyuma");

    }
}

//-----------Official Account Validate username--
var officialUsernameValidation = false;
function officialUser_nds_validate_Username(obj) {
    if (obj.value != "") {
        //---------------
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_username.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //----Registered for the first time
                    $("#home_official_username_wait").hide();
                    $("#home_official_username_failed").hide();
                    $("#home_official_username_okay").show();
                    //--------------------------
                    officialUsernameValidation = true;
                } else {
                    //-----already registered
                    $("#home_official_username_wait").hide();
                    $("#home_official_username_failed").show();
                    $("#home_official_username_okay").hide();
                    //---------
                    officialUsernameValidation = false;

                }
            } else {
            }
        };
        ajax.send("userNameVal=" + obj.value + "&key=cyuma");
    } else {
        $("#home_official_username_wait").hide();
        $("#home_official_username_failed").show();
        $("#home_official_username_okay").hide();
        //---------
        officialUsernameValidation = false;
    }
}

//-----------Official Account Validate phone--
var officialPhoneValidation = false;
function officialUser_nds_validate_Phone(obj, e) {
    //---------------
    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
    // Allow: Ctrl+A
    (e.keyCode == 65 && e.ctrlKey === true) ||
    // Allow: home, end, left, right
    (e.keyCode >= 35 && e.keyCode <= 39)) {
        // let it happen, don't do anything
        return;
    }
    // Ensure that it is a number and stop the keypress
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
        e.preventDefault();
    }
    //-------------
    $("#home_official_work_nber_wait").show();
    if ((obj.value.length < 12)) {
        $("#home_official_work_nber_wait").delay(200).hide();
        $("#home_official_work_nber_failed").delay(500).show();
        $("#home_official_work_nber_okay").hide();
        //--------
        officialPhoneValidation = false;
    } else {
        $("#home_official_work_nber_wait").delay(200).hide();
        $("#home_official_work_nber_failed").hide();
        $("#home_official_work_nber_okay").delay(500).show();
        //-----------
        officialPhoneValidation = true;
    }
}

//-----------Official Account Validate Email--
var officialEmailValidation = false;
function officialUser_nds_validate_Email(obj) {
    $("#home_official_company_address_mail_wait").show();
    var x = obj.value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
        $("#home_official_company_address_mail_wait").delay(200).hide();
        $("#home_official_company_address_mail_failed").delay(500).show();
        $("#home_official_company_address_mail_okay").hide();
        //---------
        officialEmailValidation = false;
    } else {
        $("#home_official_company_address_mail_wait").delay(200).hide();
        $("#home_official_company_address_mail_failed").hide();
        $("#home_official_company_address_mail_okay").delay(500).show();
        //---------------
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_email.php");
        //------------------------------------------
        $("#home_official_company_address_mail_wait").show();
        $("#home_official_company_address_mail_failed").hide();
        $("#home_official_company_address_mail_okay").hide();
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //----Registered for the first time
                    $("#home_official_company_address_mail_wait").hide();
                    $("#home_official_company_address_mail_failed").hide();
                    $("#home_official_company_address_mail_okay").show();
                    //--------------------------
                    officialEmailValidation = true;
                } else {
                    //-----already registered
                    $("#home_official_company_address_mail_wait").hide();
                    $("#home_official_company_address_mail_failed").show();
                    $("#home_official_company_address_mail_okay").hide();
                    //----
                    officialEmailValidation = false;

                }
            } else {
                //-----already registered
                $("#home_official_company_address_mail_wait").hide();
                $("#home_official_company_address_mail_failed").show();
                $("#home_official_company_address_mail_okay").hide();
                //--------
                officialEmailValidation = false;
            }
        };
        ajax.send("userEmailVal=" + obj.value + "&key=cyuma");
    }
}

//-----------Official Account Validate passwords--
var officialPasswordsValidation = false;
function officialUser_nds_validate_Passwords(obj) {
    if (obj.value != "") {
        switch(obj.id) {
            case "home_official_password":
                if (_("home_official_password").value == "") {
                    $("#home_official_password_wait").hide();
                    $("#home_official_password_failed").show();
                    $("#home_official_password_okay").hide();

                } else if (_("home_official_password").value != "") {
                    $("#home_official_password_wait").hide();
                    $("#home_official_password_failed").hide();
                    $("#home_official_password_okay").show();

                }
                break;
            case "home_official_password_retype":
                if (_("home_official_password_retype").value == "") {
                    $("#home_official_password_retype_wait").hide();
                    $("#home_official_password_retype_failed").show();
                    $("#home_official_password_retype_okay").hide();
                } else if (_("home_official_password_retype").value != "") {
                    $("#home_official_password_retype_wait").hide();
                    $("#home_official_password_retype_failed").hide();
                    $("#home_official_password_retype_okay").show();
                    //---
                    if (_("home_official_password").value != _("home_official_password_retype").value) {
                        $("#home_official_password_wait").hide();
                        $("#home_official_password_failed").show();
                        $("#home_official_password_okay").hide();
                        //-------------
                        $("#home_official_password_retype_wait").hide();
                        $("#home_official_password_retype_failed").show();
                        $("#home_official_password_retype_okay").hide();
                        officialPasswordsValidation = false;
                    } else if (_("home_official_password").value == _("home_official_password_retype").value) {
                        $("#home_official_password_wait").hide();
                        $("#home_official_password_failed").hide();
                        $("#home_official_password_okay").show();
                        //-------------
                        $("#home_official_password_retype_wait").hide();
                        $("#home_official_password_retype_failed").hide();
                        $("#home_official_password_retype_okay").show();
                        officialPasswordsValidation = true;

                    }
                }
                break;
            default:
                if (_("home_official_password").value != _("home_official_password_retype").value) {
                    $("#home_official_password_wait").hide();
                    $("#home_official_password_failed").show();
                    $("#home_official_password_okay").hide();
                    //-------------
                    $("#home_official_password_retype_wait").hide();
                    $("#home_official_password_retype_failed").show();
                    $("#home_official_password_retype_okay").hide();
                    officialPasswordsValidation = false;
                } else if (_("home_official_password").value == _("home_official_password_retype").value) {
                    $("#home_official_password_wait").hide();
                    $("#home_official_password_failed").hide();
                    $("#home_official_password_okay").show();
                    //-------------
                    $("#home_official_password_retype_wait").hide();
                    $("#home_official_password_retype_failed").hide();
                    $("#home_official_password_retype_okay").show();
                    officialPasswordsValidation = true;

                }
                break;
        }
    } else {
        $("#home_official_password_wait").hide();
        $("#home_official_password_failed").show();
        $("#home_official_password_okay").hide();
        //-------------
        $("#home_official_password_retype_wait").hide();
        $("#home_official_password_retype_failed").show();
        $("#home_official_password_retype_okay").hide();
        officialPasswordsValidation = false;
    }
}

//------------------waiting pagex---
function undisableThisField() {
    _("waitingPagexCheckEmail").disabled = false;
    //alert(_("waitingPagexCheckEmail").value);

}

var waitingEmailValid = true;

//----verify the code
function verifyTheWaitingCode(obj) {
    //------------verify the code within the parameters
    //alert("haha");

    if (waitingEmailValid) {

        if (!(_("waitingCode").value == "")) {
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/activateTheAccountIndividual.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "profile_page.php";
                    } else if (ajax.responseText == "The code is not valid or expired check your email again or resend the email using the resend button!") {
                        //showloadingPanel("failed");
                        alert("response:" + ajax.responseText);
                    }
                } else {
                    // showloadingPanel("failed");
                }
                if (this.status >= 200 && this.status < 304) {
                    // alert("connection exists!");

                } else {

                    showloadingPanel("failed", ajax.responseText);

                }
            };
            ajax.send("waitingCode=" + _("waitingCode").value + "&id=" + obj.id + "&waitingPagexCheckEmail=" + _("waitingPagexCheckEmail").value + "&key=cyuma");
        }
    } else {

    }
}

function verifyTheWaitingCodeInstitution(obj) {
    //------------verify the code within the parameters
    //alert("haha");

    if (waitingEmailValid) {

        if (!(_("waitingCode").value == "")) {
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/activateTheAccountInstitution.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "profile_page_institution.php";
                    } else if (ajax.responseText == "The code is not valid or expired check your email again or resend the email using the resend button!") {
                        //showloadingPanel("failed");
                        alert("response:" + ajax.responseText);
                    }
                } else {
                    // showloadingPanel("failed");
                }
                if (this.status >= 200 && this.status < 304) {
                    // alert("connection exists!");

                } else {

                    showloadingPanel("failed", ajax.responseText);

                }
            };
            ajax.send("waitingCode=" + _("waitingCode").value + "&id=" + obj.id + "&waitingPagexCheckEmail=" + _("waitingPagexCheckEmail").value + "&key=cyuma");
        }
    } else {

    }
}

//----------------
function verifyTheWaitingCodeInstitutionOfficial(obj) {
    //------------verify the code within the parameters
    //alert("haha");

    if (waitingEmailValid) {

        if (!(_("waitingCode").value == "")) {
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/activateTheAccountInstitutionOfficial.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "profile_page_officials.php";
                    } else if (ajax.responseText == "The code is not valid or expired check your email again or resend the email using the resend button!") {
                        //showloadingPanel("failed");
                        alert("response:" + ajax.responseText);
                    }
                } else {
                    // showloadingPanel("failed");
                }
                if (this.status >= 200 && this.status < 304) {
                    // alert("connection exists!");

                } else {

                    showloadingPanel("failed", ajax.responseText);

                }
            };
            ajax.send("waitingCode=" + _("waitingCode").value + "&id=" + obj.id + "&waitingPagexCheckEmail=" + _("waitingPagexCheckEmail").value + "&key=cyuma");
        }
    } else {

    }
}

//----------Resend the email
function resendTheEmail(obj) {
    if (waitingEmailValid) {
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/resending_email_.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    //window.location = "profile_page.php";
                } else {
                    showloadingPanel("failed");
                }
            } else {
                showloadingPanel("failed");
            }
        };
        ajax.send("id=" + obj.id + "&waitingPagexCheckEmail=" + _("waitingPagexCheckEmail").value + "&key=cyuma");

    } else {

    }

}

//-----------------------
try {
    $("#waiting_email_wait").hide();
    $("#waiting_email_failed").hide();
    $("#waiting_email_okay").hide();
} catch(err) {

}
function validate_waiting_Email(obj) {
    if (obj.value != "") {
        $("#waiting_email_wait").show();
        var x = obj.value;
        var atpos = x.indexOf("@");
        var dotpos = x.lastIndexOf(".");
        if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
            $("#waiting_email_wait").delay(200).hide();
            $("#waiting_email_failed").delay(500).show();
            $("#waiting_email_okay").hide();
            //-----------------
            waitingEmailValid = false;
        } else {
            $("#waiting_email_wait").delay(200).hide();
            $("#waiting_email_failed").hide();
            $("#waiting_email_okay").delay(500).show();
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_email.php");
            //------------------------------------------
            $("#waiting_email_wait").show();
            $("#waiting_email_failed").hide();
            $("#waiting_email_okay").hide();
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        //----Registered for the first time
                        $("#waiting_email_wait").hide();
                        $("#waiting_email_failed").hide();
                        $("#waiting_email_okay").show();
                        //--------------------------
                        waitingEmailValid = true;
                    } else {
                        //-----already registered
                        $("#waiting_email_wait").hide();
                        $("#waiting_email_failed").show();
                        $("#waiting_email_okay").hide();
                        //---------
                        waitingEmailValid = false;

                    }
                } else {
                    waitingEmailValid = false;
                }
            };
            ajax.send("userEmailVal=" + obj.value + "&key=cyuma");
        }
    } else {
        $("#waiting_email_wait").hide();
        $("#waiting_email_failed").show();
        $("#waiting_email_okay").hide();
        waitingEmailValid = false;
    }
}

//----Send the suggestion-------------------
function sendSuggestionToThePlatform() {
    if (_("Names_2017").value == '' || _("email_add_2017").value == '' || _("message_2017").value == '' || !suggestToCommonBox) {

    } else {
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/sendTheSuggestion_2017.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    //window.location = "profile_page.php";
                    //---------------------
                    _("Names_2017").value = "";
                    _("email_add_2017").value = "";
                    _("message_2017").value = "";
                    suggestToCommonBox = false;
                } else {
                    alert(ajax.responseText);
                    showloadingPanel("failed");
                }
            } else {
                showloadingPanel("failed");
            }
        };
        ajax.send("Names_2017=" + _("Names_2017").value + "&email_add_2017=" + _("email_add_2017").value + "&message_2017=" + _("message_2017").value + "&key=cyuma");
    }

}

//-----------------------
var suggestToCommonBox = false;
function nds_validate_suggestion_common_mail(obj) {

    var x = obj.value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
        suggestToCommonBox = false;
        //---------
    } else {
        suggestToCommonBox = true;
    }
}

//---------------Login to the main Page Account--------
function renew_nds_this(obj) {
    $("#" + obj.id).css("border-style", "none");

}

function logInToThePlatform() {
    if (_("login_panel_username").value == "" || _("login_panel_password").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/nds_main_account_login.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "main_page.php";

                } else if (parseInt(ajax.responseText) == 2000) {
                    showloadingPanel("loaded");
                    window.location = "main_page_institution.php";

                } else if (parseInt(ajax.responseText) == 3000) {
                    showloadingPanel("loaded");
                    window.location = "main_page_institution.php";

                } else if (parseInt(ajax.responseText) == 4000) {
                    showloadingPanel("loaded");
                    window.location = "main_page_institution_rgb.php";

                } else if (parseInt(ajax.responseText) == 110) {
                    //---------------------
                    // alert(ajax.responseText);
                    $("#" + "login_panel_username").css("border", "2px dotted red");
                    $("#" + "login_panel_password").css("border", "2px dotted red");

                } else {
                    alert(ajax.responseText);
                    //howloadingPanel("failed");
                }
            } else if (ajaxReturn(ajax) == false) {
                showloadingPanel("failed");
            }
        };
        ajax.send("login_panel_username=" + _("login_panel_username").value + "&login_panel_password=" + _("login_panel_password").value + "&key=cyuma");

    }

}

//----------------profile page profile page--------------------
function enableThisIndivProfPageDiv(obj, theInputField) {
    $('#' + obj.id).change(function() {
        //If checkbox is checked then disable or enable input
        if ($(this).is(':checked')) {

            $("#" + theInputField).prop('disabled', false);
            $("#" + theInputField).focus();
        }
        //If checkbox is unchecked then disable or enable input
        else {
            $("#" + theInputField).prop('disabled', true);
        }
    });
}

//--------------Profile page individual-----Adjustments--
//----validate username--password change popup---validate emailpopup---validate phone--save changes---Continue--edit profile Image
//--Username validation
$("#profile_page_username_wait").hide();
$("#profile_page_username_failed").hide();
$("#profile_page_username_okay").hide();
var profile_page_UsernameValidation = true;
function profile_page_nds_validate_Username(obj) {
    if (obj.value != "") {
        //---------------
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_username.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //----Registered for the first time
                    $("#profile_page_username_wait").hide();
                    $("#profile_page_username_failed").hide();
                    $("#profile_page_username_okay").show();
                    //--------------------------
                    profile_page_UsernameValidation = true;
                } else {
                    //-----already registered
                    $("#profile_page_username_wait").hide();
                    $("#profile_page_username_failed").show();
                    $("#profile_page_username_okay").hide();
                    //---------
                    profile_page_UsernameValidation = false;

                }
            } else {
            }
        };
        ajax.send("userNameVal=" + obj.value + "&key=cyuma");
    } else {
        $("#profile_page_username_wait").hide();
        $("#profile_page_username_failed").show();
        $("#profile_page_username_okay").hide();
        //---------
        profile_page_UsernameValidation = false;
    }
}

//-------validat email-----------
$("#profile_page_email_wait").hide();
$("#profile_page_email_failed").hide();
$("#profile_page_email_okay").hide();
var profile_page_email_valid = true;
function profile_page_email_validate(obj) {
    if (obj.value != "") {
        $("#profile_page_email_wait").show();
        var x = obj.value;
        var atpos = x.indexOf("@");
        var dotpos = x.lastIndexOf(".");
        if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
            $("#profile_page_email_wait").delay(200).hide();
            $("#profile_page_email_failed").delay(500).show();
            $("#profile_page_email_okay").hide();
            //-----------------
            profile_page_email_valid = false;
        } else {
            $("#profile_page_email_wait").delay(200).hide();
            $("#profile_page_email_failed").hide();
            $("#profile_page_email_okay").delay(500).show();
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_email.php");
            //------------------------------------------
            $("#profile_page_email_wait").show();
            $("#waiting_email_failed").hide();
            $("#profile_page_email_okay").hide();
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        //----Registered for the first time
                        $("#profile_page_email_wait").hide();
                        $("#profile_page_email_failed").hide();
                        $("#profile_page_email_okay").show();
                        //--------------------------
                        profile_page_email_valid = true;
                    } else {
                        //-----already registered
                        $("#profile_page_email_wait").hide();
                        $("#profile_page_email_failed").show();
                        $("#profile_page_email_okay").hide();
                        //---------
                        profile_page_email_valid = false;

                    }
                } else {
                    profile_page_email_valid = false;
                }
            };
            ajax.send("userEmailVal=" + obj.value + "&key=cyuma");
        }
    } else {
        $("#profile_page_email_wait").hide();
        $("#profile_page_email_failed").show();
        $("#profile_page_email_okay").hide();
        profile_page_email_valid = false;
    }
}

//--------------the phone--------------
$("#profile_page_nds_validate_Phone_wait").hide();
$("#profile_page_nds_validate_Phone_failed").hide();
$("#profile_page_nds_validate_Phoneokay").hide();
var profile_page_PhoneValidation = true;
function profile_page_nds_validate_Phone(obj, e) {
    if (obj.value != "") {
        //---------------
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
        // Allow: Ctrl+A
        (e.keyCode == 65 && e.ctrlKey === true) ||
        // Allow: home, end, left, right
        (e.keyCode >= 35 && e.keyCode <= 39)) {
            // let it happen, don't do anything
            return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
        //-------------
        $("#home_individual_phone_wait").show();
        if ((obj.value.length < 12)) {
            $("#profile_page_nds_validate_Phone_wait").delay(200).hide();
            $("#profile_page_nds_validate_Phone_failed").delay(500).show();
            $("#profile_page_nds_validate_Phoneokay").hide();
            //---------
            profile_page_PhoneValidation = false;
        } else {
            $("#profile_page_nds_validate_Phone_wait").delay(200).hide();
            $("#profile_page_nds_validate_Phone_failed").hide();
            $("#profile_page_nds_validate_Phoneokay").delay(500).show();
            //----------------
            profile_page_PhoneValidation = true;
        }
    } else {
        $("#profile_page_nds_validate_Phone_wait").delay(200).hide();
        $("#profile_page_nds_validate_Phone_failed").delay(500).show();
        $("#profile_page_nds_validate_Phoneokay").hide();
        //---------
        profile_page_PhoneValidation = false;
    }

}

//-----------Password popup--------------------
function showProfilePagePopUp_passwords(obj) {
    var p = $("#" + obj.id);
    var position = p.position();

    $("#profile_page_password_popup").css("visibility", "visible");
    $("#profile_page_password_popup").slideDown();
    //-------------------------------
    _("profile_page_password_popup").style.top = position.top - 100 + "px";
    //---------------------------
    //---------------------------------------------
    _("profile_page_password_popup").style.left = position.left + "px";
    //-----------------
    $("#profile_page_password_old").focus();

}


$(document).ready(function() {
    $("#password_change_cool").hide();
    //----------------
    $("#profile_page_password_wait").hide();
    $("#profile_page_password_failed").hide();
    $("#profile_page_password_okay").hide();
});

//----------hide the password poup
function hideThePassPopUp() {
    window.clearInterval(animateInterval_progress);
    $("#password_change_cool").hide();
    _("profile_page_password_old").value = "";
    _("profile_page_password_new").value = "";
    _("profile_page_password_repeat").value = "";
    $("#profile_page_password_popup").slideUp();
    //-----------

}

//-------------animate the progress-----------
var animateInterval_progress;
var t_reference_anime = 0;
var denominator_timer = 0;
var x_cris = 0;
var x_cris2 = 0;
var x_cris3 = 0;
function animate_progress_balloons(idnbera, idnber2, idnber3, theContainer, StatusAnimation) {
    //-----
    $("#" + theContainer).show();
    //p----
    clearInterval(animateInterval_progress);
    $("#" + idnbera).show();
    $("#" + idnber2).show();
    $("#" + idnber3).show();
    switch(StatusAnimation) {
        case "animate":

            animateInterval_progress = setInterval(function() {
                //----------------------
                $("#" + idnbera).delay(100).fadeToggle().delay(200).fadeToggle();
                $("#" + idnber2).delay(150).fadeToggle().delay(300).fadeToggle();
                $("#" + idnber3).delay(200).fadeToggle().delay(500).fadeToggle();
                //-------------------
                $("#" + theContainer).effect("bounce", {
                    times : 4,
                    direction : "down",
                    distance : 30
                }, 300);

                //-----------

            }, 2000);

            break;
        case "stop":
            window.clearInterval(t_reference_anime);
            $("#" + theContainer).hide();
            break;
    }

}

//------------------
function saveThisPasswordXchange_profile_page(theId) {

    if (_("profile_page_password_old").value == '' || _("profile_page_password_new").value == '' || _("profile_page_password_repeat").value == '') {

    } else if (_("profile_page_password_new").value != _("profile_page_password_repeat").value) {
        alert("Passwords do not match!?");
    } else {
        animate_progress_balloons("balloon_1", "balloon_2", "balloon_3", "password_change_cool", "animate");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_and_record_new_password_profile_page.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    animate_progress_balloons("balloon_1", "balloon_2", "balloon_3", "password_change_cool", "stop");
                    hideThePassPopUp();
                } else {
                    alert(ajax.responseText);
                    animate_progress_balloons("balloon_1", "balloon_2", "balloon_3", "password_change_cool", "stop");
                    //showloadingPanel("failed");
                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("profile_page_password_old=" + _("profile_page_password_old").value + "&profile_page_password_new=" + _("profile_page_password_new").value + "&profile_page_password_repeat=" + _("profile_page_password_repeat").value + "&theId=" + theId + "&key=cyuma");
    }
}


$(document).ready(function() {
    $("#profile_image_choose_img_from_device").hide();
});
//----------------------Upload new Image from device--
function upload_profile_page_avatar_image() {
    $("#profile_image_choose_img_from_device").css("visiblity", "visible");
    $("#profile_image_choose_img_from_device_data").load("crop_mydata.php?theId_2017=" + _("theOurIdUser").value + "&img2017src=" + _("profile_page_indiv_img_data").src);
    $("#profile_image_choose_img_from_device").slideDown();
}

//================
function hideTheProfilePopProfileImage() {
    $("#profile_image_choose_img_from_device").slideUp();
    window.location = "profile_page.php";
}

//-----------------continue profile page ignore------
function profile_page_continue() {
    window.location = "main_page.php";
}

//-------------Save profile page changes--
function saveIndiv_profilePageChanges() {
    if (_("theOurIdUser").value == "" || _("profile_page_fname_id").value == "" || _("profile_page_lname_id").value == "" || _("profile_page_gender_id").value == "" || _("profile_page_username").value == "" || _("profile_page_email").value == "" || _("profile_page_email").value == "" || _("profile_page_indiv_phone").value == "" || _("profile_page_indiv_profession").value == "" || _("profile_page_indiv_province").value == "" || _("profile_page_indiv_district").value == "" || _("profile_page_indiv_sector").value == "" || _("profile_page_indiv_marital_status").value == "" || _("pickBirthDay").value == "" || !profile_page_PhoneValidation || !profile_page_email_valid || !profile_page_UsernameValidation) {
        alert("Empty field or Another error marked with red cross!");
    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_profile_page_changes.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "profile_page.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("theOurIdUser=" + _("theOurIdUser").value + "&profile_page_fname=" + _("profile_page_fname_id").value + "&profile_page_lname=" + _("profile_page_lname_id").value + "&profile_page_gender=" + _("profile_page_gender_id").value + "&profile_page_username=" + _("profile_page_username").value + "&profile_page_email=" + _("profile_page_email").value + "&profile_page_indiv_phone=" + _("profile_page_indiv_phone").value + "&profile_page_indiv_profession=" + _("profile_page_indiv_profession").value + "&profile_page_indiv_province=" + _("profile_page_indiv_province").value + "&profile_page_indiv_district=" + _("profile_page_indiv_district").value + "&profile_page_indiv_sector=" + _("profile_page_indiv_sector").value + "&profile_page_indiv_marital_status=" + _("profile_page_indiv_marital_status").value + "&pickBirthDay=" + _("pickBirthDay").value + "&key=cyuma");

    }
}

//----------------Website------Institution profile  page--------
$(document).ready(function() {
    //---------------institution
    $("#profile_page_institution_website_wait").hide();
    $("#profile_page_institution_website_failed").hide();
    $("#profile_page_institution_website_okay").hide();
    //-----------WEbsite------
    $("#profile_page_institution_email_add_wait").hide();
    $("#profile_page_institution_email_add_failed").hide();
    $("#profile_page_institution_email_add_okay").hide();
    //-----------Username------
    $("#profile_page_institution_username_wait").hide();
    $("#profile_page_institution_username_failed").hide();
    $("#profile_page_institution_username_okay").hide();
    //-----------------

});

var profile_page_institutionWebsiteValidation = true;
function profile_page_institutionUser_nds_validate_Website(obj) {
    $("#profile_page_institution_website_wait").show();
    var pattern = new RegExp('^(https?:\\//\\//)?' + // protocol
    '((([a-z\\d]([a-z\\d-]*[a-z\d])*)\\.)+[a-z]{2,}|' + // domain name
    '((\\d{1,3}\\.){3}\\d{1,3}))' + // OR ip (v4) address
    '(\\:\d+)?(\\//[-a-z\\d%_.~+]*)*' + // port and path
    '(\\?[;&a-z\\d%_.~+=-]*)?' + // query string
    '(\\#[-a-z\\d_]*)?$', 'i');
    // fragment locater
    if (!pattern.test(obj.value)) {
        $("#profile_page_institution_website_wait").delay(200).hide();
        $("#profile_page_institution_website_failed").delay(500).show();
        $("#profile_page_institution_website_okay").hide();
        //alert("Please enter a valid URL.");
        // return false;
        profile_page_institutionWebsiteValidation = false;
    } else {
        $("#profile_page_institution_website_wait").delay(200).hide();
        $("#profile_page_institution_website_failed").hide();
        $("#profile_page_institution_website_okay").delay(500).show();
        profile_page_institutionWebsiteValidation = true;
    }

}

//--------------------Email------------
var profile_page_institutionEmailValidation = true;
function profile_page_institutionUser_nds_validate_Email(obj) {
    $("#profile_page_institution_email_add_wait").show();
    var x = obj.value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
        $("#profile_page_institution_email_add_wait").delay(200).hide();
        $("#profile_page_institution_email_add_failed").delay(500).show();
        $("#profile_page_institution_email_add_okay").hide();
        //--
        profile_page_institutionEmailValidation = false;
    } else {
        $("#profile_page_institution_email_add_wait").delay(200).hide();
        $("#profile_page_institution_email_add_failed").hide();
        $("#profile_page_institution_email_add_okay").delay(500).show();
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_email.php");
        //------------------------------------------
        $("#profile_page_institution_email_add_wait").show();
        $("#profile_page_institution_email_add_failed").hide();
        $("#profile_page_institution_email_add_okay").hide();
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //----Registered for the first time
                    $("#profile_page_institution_email_add_wait").hide();
                    $("#profile_page_institution_email_add_failed").hide();
                    $("#profile_page_institution_email_add_okay").show();
                    //--------------------------
                    profile_page_institutionEmailValidation = true;
                } else {
                    //-----already registered
                    $("#profile_page_institution_email_add_wait").hide();
                    $("#profile_page_institution_email_add_failed").show();
                    $("#profile_page_institution_email_add_okay").hide();
                    //------
                    profile_page_institutionEmailValidation = false;

                }
            } else {
                //-----already registered
                $("#profile_page_institution_email_add_wait").hide();
                $("#profile_page_institution_email_add_failed").show();
                $("#profile_page_institution_email_add_okay").hide();
                //------------
                profile_page_institutionEmailValidation = false;
            }
        };
        ajax.send("userEmailVal=" + obj.value + "&key=cyuma");
    }
}

//--------Username------------------------------------------------
var profile_page_institutionUsernameValidation = true;
function profile_page_institutionUser_nds_validate_Username(obj) {
    if (obj.value != "") {
        //---------------
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_username.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //----Registered for the first time
                    $("#profile_page_institution_username_wait").hide();
                    $("#profile_page_institution_username_failed").hide();
                    $("#profile_page_institution_username_okay").show();
                    //--------------------------
                    profile_page_institutionUsernameValidation = true;
                } else {
                    //-----already registered
                    $("#profile_page_institution_username_wait").hide();
                    $("#profile_page_institution_username_failed").show();
                    $("#profile_page_institution_username_okay").hide();
                    //----------------
                    profile_page_institutionUsernameValidation = false;

                }
            } else {
                profile_page_institutionUsernameValidation = false;
            }
        };
        ajax.send("userNameVal=" + obj.value + "&key=cyuma");
    } else {
        //-----already registered
        $("#profile_page_institution_username_wait").hide();
        $("#profile_page_institution_username_failed").show();
        $("#profile_page_institution_username_okay").hide();
        //----------------
        profile_page_institutionUsernameValidation = false;

    }
}

//-----------------
//-----------Password popup--------------------
function showProfilePage_institution_PopUp_passwords(obj) {
    var p = $("#" + obj.id);
    var position = p.position();

    $("#profile_page_institution_password_popup").css("visibility", "visible");
    $("#profile_page_institution_password_popup").slideDown();
    //-------------------------------
    _("profile_page_institution_password_popup").style.top = position.top - 100 + "px";
    //---------------------------
    //---------------------------------------------
    _("profile_page_institution_password_popup").style.left = position.left + "px";
    //-----------------
    $("#profile_page_institution_password_old").focus();

}

function hideThePassProfileInstitutionPopUp() {
    window.clearInterval(animateInterval_progress);
    $("#profile_page_institution_password_change_cool").hide();
    _("profile_page_institution_password_old").value = "";
    _("profile_page_institution_password_new").value = "";
    _("profile_page_institution_password_repeat").value = "";
    $("#profile_page_institution_password_popup").slideUp();
    //-----------
}

//----password profile page institution-------
function saveThisPasswordXchange_institution_profile_page(theId) {

    if (_("profile_page_institution_password_old").value == '' || _("profile_page_institution_password_new").value == '' || _("profile_page_institution_password_repeat").value == '') {

    } else if (_("profile_page_institution_password_new").value != _("profile_page_institution_password_repeat").value) {
        alert("Passwords do not match!?");
    } else {
        animate_progress_balloons("balloon_1", "balloon_2", "balloon_3", "profile_page_institution_password_change_cool", "animate");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_and_record_new_password_profile_page_institution.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    animate_progress_balloons("balloon_1", "balloon_2", "balloon_3", "profile_page_institution_password_change_cool", "stop");
                    hideThePassProfileInstitutionPopUp();
                } else {
                    alert(ajax.responseText);
                    animate_progress_balloons("balloon_1", "balloon_2", "balloon_3", "profile_page_institution_password_change_cool", "stop");
                    //showloadingPanel("failed");
                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("profile_page_institution_password_old=" + _("profile_page_institution_password_old").value + "&profile_page_institution_password_new=" + _("profile_page_institution_password_new").value + "&profile_page_institution_password_repeat=" + _("profile_page_institution_password_repeat").value + "&theId=" + theId + "&key=cyuma");
    }
}

//------------
$(document).ready(function() {
    try {
        $("#profile_page_institution_password_wait").hide();
        $("#profile_page_institution_password_failed").hide();
        $("#profile_page_institution_password_okay").hide();
        //---------
        $("#profile_page_institution_password_change_cool").hide();
    } catch(err) {

    }

});
//----------profile page institution continue
function profile_page_institution_continue() {
    switch(_("account_profile_institution_check9").value) {
        case "rgb":
            window.location = "main_page_institution_rgb.php";
            break;
        case "insti":
            window.location = "main_page_institution.php";
            break;

        default:
            break;
    }

}

//-----------------
function upload_profile_page_institu_avatar_image() {
    $("#profile_image_insti_choose_img_from_device").css("visiblity", "visible");
    $("#profile_image_insti_choose_img_from_device_data").load("crop_mydata.php?theId_2017=" + _("theOurIdUser").value + "&img2017src=" + _("profile_page_institu_img_data").src);
    $("#profile_image_insti_choose_img_from_device").slideDown();
}

function hideTheProfile_instiPopProfileImage() {
    $("#profile_image_insti_choose_img_from_device").slideUp();
    window.location = "profile_page_institution.php";
}

//---------
$(document).ready(function() {
    $("#profile_image_insti_choose_img_from_device").hide();
});
//--------------------------
function save_Institution_profilePageChanges() {
    if (_("theOurIdUser").value == "" || _("profile_page_institution_name").value == "" || _("profile_page_institution_website").value == "" || _("profile_page_institution_email_add").value == "" || _("profile_page_institution_province").value == "" || _("profile_page_institution_district").value == "" || _("profile_page_institution_sector").value == "" || _("profile_page_institution_motto").value == "" || _("profile_page_institution_username").value == "" || !profile_page_institutionUsernameValidation || !profile_page_institutionEmailValidation || !profile_page_institutionWebsiteValidation) {
        alert("Empty field or Another error marked with red cross!");
    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_profile_page__institution_changes.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "profile_page_institution.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("theOurIdUser=" + _("theOurIdUser").value + "&profile_page_institution_name=" + _("profile_page_institution_name").value + "&profile_page_institution_website=" + _("profile_page_institution_website").value + "&profile_page_institution_email_add=" + _("profile_page_institution_email_add").value + "&profile_page_institution_province=" + _("profile_page_institution_province").value + "&profile_page_institution_district=" + _("profile_page_institution_district").value + "&profile_page_institution_sector=" + _("profile_page_institution_sector").value + "&profile_page_institution_motto=" + _("profile_page_institution_motto").value + "&profile_page_institution_username=" + _("profile_page_institution_username").value + "&key=cyuma");

    }
}


$(document).ready(function() {
    $("#official_username_wait00").hide();
    $("#official_username_failed00").hide();
    $("#official_username_okay00").hide();
});

var official_UsernameValidation = true;
function official_nds_validate_Username(obj) {
    if (obj.value != "") {
        //---------------
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_username.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //----Registered for the first time
                    $("#official_username_wait00").hide();
                    $("#official_username_failed00").hide();
                    $("#official_username_okay00").show();
                    //--------------------------
                    official_UsernameValidation = true;
                } else {
                    //-----already registered
                    $("#official_username_wait00").hide();
                    $("#official_username_failed00").show();
                    $("#official_username_okay00").hide();
                    //---------
                    official_UsernameValidation = false;

                }
            } else {
            }
        };
        ajax.send("userNameVal=" + obj.value + "&key=cyuma");
    } else {
        $("#official_username_wait00").hide();
        $("#official_username_failed00").show();
        $("#official_username_okay00").hide();
        //---------
        official_UsernameValidation = false;
    }
}

//-------------------------
//--------------the phone--------------
$(document).ready(function() {
    $("#official_phone_wait00").hide();
    $("#official_phone_failed00").hide();
    $("#official_phone_okay00").hide();
});

//--------
var official_profile_page_PhoneValidation = true;
function official_profile_page_nds_validate_Phone(obj, e) {
    if (obj.value != "") {
        //---------------
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
        // Allow: Ctrl+A
        (e.keyCode == 65 && e.ctrlKey === true) ||
        // Allow: home, end, left, right
        (e.keyCode >= 35 && e.keyCode <= 39)) {
            // let it happen, don't do anything
            return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
        //-------------
        $("#home_individual_phone_wait").show();
        if ((obj.value.length < 12)) {
            $("#official_phone_wait00").delay(200).hide();
            $("#official_phone_failed00").delay(500).show();
            $("#official_phone_okay00").hide();
            //---------
            official_profile_page_PhoneValidation = false;
        } else {
            $("#official_phone_wait00").delay(200).hide();
            $("#official_phone_failed00").hide();
            $("#official_phone_okay00").delay(500).show();
            //----------------
            official_profile_page_PhoneValidation = true;
        }
    } else {
        $("#official_phone_wait00").delay(200).hide();
        $("#official_phone_failed00").delay(500).show();
        $("#official_phone_okay00").hide();
        //---------
        official_profile_page_PhoneValidation = false;
    }

}

//--------------Email-----------------------------------------
$(document).ready(function() {
    $("#official_email_wait00").hide();
    $("#official_email_failed00").hide();
    $("#official_email_okay00").hide();
});

var official_profile_page_email_valid = true;
function official_profile_page_email_validate(obj) {
    if (obj.value != "") {
        $("#official_email_wait00").show();
        var x = obj.value;
        var atpos = x.indexOf("@");
        var dotpos = x.lastIndexOf(".");
        if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
            $("#official_email_wait00").delay(200).hide();
            $("#official_email_failed00").delay(500).show();
            $("#official_email_okay00").hide();
            //-----------------
            official_profile_page_email_valid = false;
        } else {
            $("#official_email_wait00").delay(200).hide();
            $("#official_email_failed00").hide();
            $("#official_email_okay00").delay(500).show();
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_individual_email.php");
            //------------------------------------------
            $("#official_email_wait00").show();
            $("#official_email_failed00").hide();
            $("#official_email_okay00").hide();
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        //----Registered for the first time
                        $("#official_email_wait00").hide();
                        $("#official_email_failed00").hide();
                        $("#official_email_okay00").show();
                        //--------------------------
                        official_profile_page_email_valid = true;
                    } else {
                        //-----already registered
                        $("#official_email_wait00").hide();
                        $("#official_email_failed00").show();
                        $("#official_email_okay00").hide();
                        //---------
                        official_profile_page_email_valid = false;

                    }
                } else {
                    official_profile_page_email_valid = false;
                }
            };
            ajax.send("userEmailVal=" + obj.value + "&key=cyuma");
        }
    } else {
        $("#official_email_wait00").hide();
        $("#official_email_failed00").show();
        $("#official_email_okay00").hide();
        official_profile_page_email_valid = false;
    }
}

//--------------
//----------profile page institution continue
function official_profile_page_institution_continue() {
    switch(_("account_profile_institution_check9").value) {
        case "rgb":
            window.location = "main_page_institution_rgb.php";
            break;
        case "insti":
            window.location = "main_page_institution.php";
            break;

        default:
            break;
    }

}

//--------090===================================================
function show_official_ProfilePagePopUp_passwords(obj) {
    var p = $("#" + obj.id);
    var position = p.position();

    $("#official_profile_page_password_popup").css("visibility", "visible");
    $("#official_profile_page_password_popup").slideDown();
    //-------------------------------
    _("official_profile_page_password_popup").style.top = position.top - 100 + "px";
    //---------------------------
    //---------------------------------------------
    _("official_profile_page_password_popup").style.left = position.left + "px";
    //-----------------
    $("#official_profile_page_password_old").focus();

}


$(document).ready(function() {
    $("#official_password_change_cool").hide();
    //----------------
    $("#official_profile_page_password_wait").hide();
    $("#official_profile_page_password_failed").hide();
    $("#official_profile_page_password_okay").hide();
});

//----------hide the password poup
function official_hideThePassPopUp() {
    window.clearInterval(animateInterval_progress);
    $("#official_password_change_cool").hide();
    _("official_profile_page_password_old").value = "";
    _("official_profile_page_password_new").value = "";
    _("official_profile_page_password_repeat").value = "";
    $("#official_profile_page_password_popup").slideUp();
    //-----------

}

//--------------
function saveThisPasswordXchange_official_profile_page(theId) {

    if (_("official_profile_page_password_old").value == '' || _("official_profile_page_password_new").value == '' || _("official_profile_page_password_repeat").value == '') {

    } else if (_("official_profile_page_password_new").value != _("official_profile_page_password_repeat").value) {
        alert("Passwords do not match!?");
    } else {
        animate_progress_balloons("balloon_1", "balloon_2", "balloon_3", "official_password_change_cool", "animate");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/verify_and_record_new_password_official_profile_page.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    animate_progress_balloons("balloon_1", "balloon_2", "balloon_3", "official_password_change_cool", "stop");
                    official_hideThePassPopUp();
                } else {
                    alert(ajax.responseText);
                    animate_progress_balloons("balloon_1", "balloon_2", "balloon_3", "official_password_change_cool", "stop");
                    //showloadingPanel("failed");
                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("official_profile_page_password_old=" + _("official_profile_page_password_old").value + "&official_profile_page_password_new=" + _("official_profile_page_password_new").value + "&official_profile_page_password_repeat=" + _("official_profile_page_password_repeat").value + "&theId=" + theId + "&key=cyuma");
    }
}

//---------------Image for official account---
//-----------------
function upload_profile_page_official_avatar_image() {
    $("#profile_image_official_choose_img_from_device").css("visiblity", "visible");
    $("#profile_image_official_choose_img_from_device_data").load("crop_mydata.php?theId_2017=" + _("theOurIdUser").value + "&img2017src=" + _("profile_page_official_img_data").src);
    $("#profile_image_official_choose_img_from_device").slideDown();
}

function hideTheProfile_official_PopProfileImage() {
    $("#profile_image_official_choose_img_from_device").slideUp();
    window.location = "profile_page_officials.php";
}

//---------
$(document).ready(function() {
    $("#profile_image_official_choose_img_from_device").hide();
});
//------------save profile changes for official account--
function save_Official_profilePageChanges() {
    if (_("theOurIdUser").value == "" || _("official_fname").value == "" || _("official_lname").value == "" || _("official_username").value == "" || _("official_gender_id").value == "" || _("official_marital_status").value == "" || _("official_institution_name").value == "" || _("official_department").value == "" || _("official_position").value == "" || _("official_province").value == "" || _("official_district").value == "" || _("official_sector").value == "" || _("official_phone").value == "" || _("official_email").value == "" || !official_profile_page_email_valid || !official_profile_page_PhoneValidation) {
        alert("Empty field or Another error marked with red cross!");
    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_profile_page__official_changes.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "profile_page_officials.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("theOurIdUser=" + _("theOurIdUser").value + "&official_fname=" + _("official_fname").value + "&official_lname=" + _("official_lname").value + "&official_username=" + _("official_username").value + "&official_gender_id=" + _("official_gender_id").value + "&official_marital_status=" + _("official_marital_status").value + "&official_institution_name=" + _("official_institution_name").value + "&official_department=" + _("official_department").value + "&official_position=" + _("official_position").value + "&official_province=" + _("official_province").value + "&official_district=" + _("official_district").value + "&official_sector=" + _("official_sector").value + "&official_phone=" + _("official_phone").value + "&official_email=" + _("official_email").value + "&key=cyuma");

    }
}

//--------------Community user settings-------------------------
function community_user_settings_change_language(idLanguage, idTheUser) {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_language_choice2017.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");
                window.location = "community_user_settings.php";
            } else {
                alert(ajax.responseText);

            }
        } else {
            showloadingPanel("failed");

        }
    };
    ajax.send("idLanguage=" + idLanguage + "&idTheUser=" + idTheUser + "&key=cyuma");

}

//--------------official user settings-------------------------
function official_user_settings_change_language(idLanguage, idTheUser) {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_language_choice2017.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");
                window.location = "official_user_settings.php";
            } else {
                alert(ajax.responseText);

            }
        } else {
            showloadingPanel("failed");

        }
    };
    ajax.send("idLanguage=" + idLanguage + "&idTheUser=" + idTheUser + "&key=cyuma");

}

//=============================institution----------------------------------------------------
function institution_user_settings_change_language(idLanguage, idTheUser) {
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_language_choice2017.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");
                window.location = "institution_user_settings.php";
            } else {
                alert(ajax.responseText);

            }
        } else {
            showloadingPanel("failed");

        }
    };
    ajax.send("idLanguage=" + idLanguage + "&idTheUser=" + idTheUser + "&key=cyuma");

}

//----------------------------------------------------------------------
function community_user_settings_change_notify_status(notification_type_id, whichone, status) {
    //alert(_("common_user_settings_the_id").value);
    //-------------------
    if (status == 0) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_notification_new_msg_coming.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 1 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    } else if (status == 1) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_notification_new_msg_coming.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 0 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

//-------------------------official---------------------------------------------
function official_user_settings_change_notify_status(notification_type_id, whichone, status) {
    //alert(_("common_user_settings_the_id").value);
    //-------------------
    if (status == 0) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_notification_new_msg_coming.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "official_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 1 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    } else if (status == 1) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_notification_new_msg_coming.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 0 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

//-----------------------------
function institution_user_settings_change_notify_status(notification_type_id, whichone, status) {
    //alert(_("common_user_settings_the_id").value);
    //-------------------
    if (status == 0) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_notification_new_msg_coming.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 1 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    } else if (status == 1) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_notification_new_msg_coming.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 0 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

//------------------------------Preferences----------------------------------------
function community_user_settings_change_preferences_status(notification_type_id, whichone, status) {
    //alert(_("common_user_settings_the_id").value);
    //-------------------
    if (status == 0) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_preferences_stay_logged_in.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 1 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    } else if (status == 1) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_preferences_stay_logged_in.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 0 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

function official_user_settings_change_preferences_status(notification_type_id, whichone, status) {
    //alert(_("common_user_settings_the_id").value);
    //-------------------
    if (status == 0) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_preferences_stay_logged_in.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "official_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 1 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    } else if (status == 1) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_preferences_stay_logged_in.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "official_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 0 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

//------------------------------Preferences----------------------------------------
function institution_user_settings_change_preferences_status(notification_type_id, whichone, status) {
    //alert(_("common_user_settings_the_id").value);
    //-------------------
    if (status == 0) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_preferences_stay_logged_in.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 1 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    } else if (status == 1) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_preferences_stay_logged_in.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("notification_type_id=" + notification_type_id + "&status=" + 0 + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

//-----------------creating a tag identifier------------------------------------
function community_user_settings_create_tag_identifier() {
    if (_("community_user_settings_new_ident").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_tag_identifier.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("community_user_settings_new_ident=" + _("community_user_settings_new_ident").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

//-----------------creating a tag identifier------------------------------------
function official_user_settings_create_tag_identifier() {
    if (_("community_user_settings_new_ident").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_tag_identifier.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "official_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("community_user_settings_new_ident=" + _("community_user_settings_new_ident").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

//-----------------creating a tag identifier------------------------------------
function institution_user_settings_create_tag_identifier() {
    if (_("community_user_settings_new_ident").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_tag_identifier.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("community_user_settings_new_ident=" + _("community_user_settings_new_ident").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

function community_user_settings_create_tag_identifier_delete(theidr) {
    if (confirm("Are you sure!??")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/delete_community_user_settings_tag_identifier.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + theidr + "&key=cyuma");
    }

}

function official_user_settings_create_tag_identifier_delete(theidr) {
    if (confirm("Are you sure!??")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/delete_community_user_settings_tag_identifier.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "official_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + theidr + "&key=cyuma");
    }

}

function institution_user_settings_create_tag_identifier_delete(theidr) {
    if (confirm("Are you sure!??")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/delete_community_user_settings_tag_identifier.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + theidr + "&key=cyuma");
    }

}

//------------------------------------------
function community_user_settings_create_tag_keyword_delete(theidr) {
    if (confirm("Are you sure!??")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/delete_community_user_settings_tag_keyword.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + theidr + "&key=cyuma");
    }

}

function official_user_settings_create_tag_keyword_delete(theidr) {
    if (confirm("Are you sure!??")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/delete_community_user_settings_tag_keyword.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "official_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + theidr + "&key=cyuma");
    }

}

//------------------------------------------
function institution_user_settings_create_tag_keyword_delete(theidr) {
    if (confirm("Are you sure!??")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/delete_community_user_settings_tag_keyword.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + theidr + "&key=cyuma");
    }

}

//-----------------creating a tag identifier------------------------------------
function community_user_settings_create_tag_keyword() {
    if (_("community_user_settings_new_keyword").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_tag_keyword.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("community_user_settings_new_keyword=" + _("community_user_settings_new_keyword").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

function institution_user_settings_create_tag_keyword() {
    if (_("community_user_settings_new_keyword").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_tag_keyword.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("community_user_settings_new_keyword=" + _("community_user_settings_new_keyword").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

function official_user_settings_create_tag_keyword() {
    if (_("community_user_settings_new_keyword").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_tag_keyword.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "official_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("community_user_settings_new_keyword=" + _("community_user_settings_new_keyword").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

//------------------register privacy suggest tool--
function nds_privacy_suggest_action_tools(obj, fdfd, whichTypeChosen) {

    //alert(whichTypeChosen);
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_save_privacy_suggest_settings.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");
                window.location = "community_user_settings.php";
            } else {
                alert(ajax.responseText);

            }
        } else {
            showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&whichTypeChosen=" + whichTypeChosen + "&key=cyuma");

}

function nds_privacy_suggest_action_tools_official(obj, fdfd, whichTypeChosen) {

    //alert(whichTypeChosen);
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_save_privacy_suggest_settings.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");
                window.location = "official_user_settings.php";
            } else {
                alert(ajax.responseText);

            }
        } else {
            showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&whichTypeChosen=" + whichTypeChosen + "&key=cyuma");

}

//------------ community user settings--My posts  2017 -----------
function nds_privacy_posts_action_tools(obj, fdfd, whichTypeChosen) {

    //alert(whichTypeChosen);
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_save_privacy_suggest_settings.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");
                window.location = "community_user_settings.php";
            } else {
                alert(ajax.responseText);

            }
        } else {
            showloadingPanel("failed");

        }
    };
    ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&whichTypeChosen=" + whichTypeChosen + "&key=cyuma");

}

function nds_privacy_check_which_posts_0(obj) {

    switch(obj.id) {
        case "community_user_settings_privacy_posts_0":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_save_privacy_posts_settings.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "community_user_settings.php";
                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    showloadingPanel("failed");

                }
            };
            ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

            break;
        case "community_user_settings_privacy_posts_1":
            //alert("Type 1");
            break;

    }

}

function nds_privacy_check_which_posts_0_official(obj) {

    switch(obj.id) {
        case "community_user_settings_privacy_posts_0":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_save_privacy_posts_settings.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "official_user_settings.php";
                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    showloadingPanel("failed");

                }
            };
            ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

            break;
        case "community_user_settings_privacy_posts_1":
            //alert("Type 1");
            break;

    }

}

function nds_privacy_check_which_posts_0_institution(obj) {

    switch(obj.id) {
        case "community_user_settings_privacy_posts_0":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_save_privacy_posts_settings.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "institution_user_settings.php";
                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    showloadingPanel("failed");

                }
            };
            ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

            break;
        case "community_user_settings_privacy_posts_1":
            //alert("Type 1");
            break;

    }

}

//----------------------------------
function nds_privacy_save_which_posts_1() {

    if (document.getElementById("community_user_settings_privacy_posts_1").checked == true) {

        if (_("comm_user_settings_MyOtherName").value != "") {
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_save_privacy_posts_settings_type2.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "community_user_settings.php";
                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    showloadingPanel("failed");

                }
            };
            ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&comm_user_settings_MyOtherName=" + _("comm_user_settings_MyOtherName").value + "&key=cyuma");

        }
    }

}

function nds_privacy_save_which_posts_1_official() {

    if (document.getElementById("community_user_settings_privacy_posts_1").checked == true) {

        if (_("comm_user_settings_MyOtherName").value != "") {
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_save_privacy_posts_settings_type2.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "official_user_settings.php";
                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    showloadingPanel("failed");

                }
            };
            ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&comm_user_settings_MyOtherName=" + _("comm_user_settings_MyOtherName").value + "&key=cyuma");

        }
    }

}

function nds_privacy_save_which_posts_1_institution() {

    if (document.getElementById("community_user_settings_privacy_posts_1").checked == true) {

        if (_("comm_user_settings_MyOtherName").value != "") {
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_save_privacy_posts_settings_type2.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "institution_user_settings.php";
                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    showloadingPanel("failed");

                }
            };
            ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&comm_user_settings_MyOtherName=" + _("comm_user_settings_MyOtherName").value + "&key=cyuma");

        }
    }

}

//----------------------------------nds_privacy send to govment institution----------
function nds_privacy_check_sending_to_govment_institution(obj) {
    switch(obj.id) {
        case "send_to_goverment_set_0":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_sending_to_goverment.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "community_user_settings.php";
                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    showloadingPanel("failed");

                }
            };
            ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&whichChoice=one" + "&key=cyuma");

            break;
        case "send_to_goverment_set_1":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_sending_to_goverment.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "community_user_settings.php";
                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    showloadingPanel("failed");

                }
            };
            ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&whichChoice=two" + "&key=cyuma");

            break;
        case "send_to_goverment_set_2":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_sending_to_goverment.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        window.location = "community_user_settings.php";
                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    showloadingPanel("failed");

                }
            };
            ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&whichChoice=three" + "&key=cyuma");

            break;

    }

}

//---------The adverts common_user_institution_settings----------------
function common_user_settings_create_your_own_advert(obj) {
    var p = $("#" + obj.id);
    var position = p.position();
    //-------------
    $("#community_user_settings_create_advert_here").css("visibility", "visible");

    $("#community_user_settings_create_advert_here").slideDown();

}

///--------------------
function common_user_settings_create_your_own_advert_hide() {
    $("#community_user_settings_create_advert_here").slideUp();
}

//----------------upload advert image for common user settings-------
//-------------------------------------------------------------
function upload_community_user_settings_advert_image() {
    var file = document.getElementById("community_user_settings_up_img_file").files[0];
    if (!file) {
    } else {
        //------------------
        var fd = new FormData();
        fd.append("community_user_settings_advert_upload_form", file);
        var aj = new XMLHttpRequest();
        aj.upload.addEventListener("progress", progress_community_user_settings_advert_image, false);
        aj.addEventListener("load", complete_community_user_settings_advert_image, false);
        aj.addEventListener("error", error_community_user_settings_advert_image, false);
        aj.addEventListener("abort", abort_community_user_settings_advert_image, false);
        aj.open("POST", "ajax_php_user_scripts/community_user_settings_upload_advert.php");
        aj.send(fd);
    }
}

//----------------------------------
function progress_community_user_settings_advert_image(event) {
    var percent = (event.loaded / event.total) * 100;
    var quotient = (event.loaded / event.total);
    document.getElementById("community_user_settings_up_img_messenger").innerHTML = Math.round(percent) + "% Uploading ...";
    //document.getElementById("progressBar").style.width = (220 / event.total) * event.loaded + "px";
}

function complete_community_user_settings_advert_image(event) {
    document.getElementById("community_user_settings_up_img_messenger").innerHTML = "";
    //document.getElementById("progressBar").style.width = 0;
    _("community_user_settings_up_img_val").value = event.target.responseText;
    _("community_user_settings_up_img_preview").src = "neza_advert_images/" + event.target.responseText;
}

function error_community_user_settings_advert_image(event) {
}

function abort_community_user_settings_advert_image(event) {
}

//-----------------Save the advert---------------------
function community_user_settings_save_advert_data() {
    if (_("community_user_settings_advert_start_date").value == "" || _("community_user_settings_advert_finish_date").value == "" || _("community_user_settings_advert_start_time").value == "" || _("community_user_settings_advert_finish_time").value == "" || _("community_user_settings_advert_name").value == "" || _("community_user_settings_advert_name").value == "" || _("community_user_settings_up_img_val").value == "") {
        alert("Okay cool!");
    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_advert.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "community_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&community_user_settings_advert_start_date=" + _("community_user_settings_advert_start_date").value + "&community_user_settings_advert_finish_date=" + _("community_user_settings_advert_finish_date").value + "&community_user_settings_advert_start_time=" + _("community_user_settings_advert_start_time").value + "&community_user_settings_advert_finish_time=" + _("community_user_settings_advert_finish_time").value + "&community_user_settings_advert_name=" + _("community_user_settings_advert_name").value + "&community_user_settings_up_img_val=" + _("community_user_settings_up_img_val").value + "&key=cyuma");

    }
}

function official_user_settings_save_advert_data() {
    if (_("community_user_settings_advert_start_date").value == "" || _("community_user_settings_advert_finish_date").value == "" || _("community_user_settings_advert_start_time").value == "" || _("community_user_settings_advert_finish_time").value == "" || _("community_user_settings_advert_name").value == "" || _("community_user_settings_advert_name").value == "" || _("community_user_settings_up_img_val").value == "") {
        alert("Okay cool!");
    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_advert.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "official_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&community_user_settings_advert_start_date=" + _("community_user_settings_advert_start_date").value + "&community_user_settings_advert_finish_date=" + _("community_user_settings_advert_finish_date").value + "&community_user_settings_advert_start_time=" + _("community_user_settings_advert_start_time").value + "&community_user_settings_advert_finish_time=" + _("community_user_settings_advert_finish_time").value + "&community_user_settings_advert_name=" + _("community_user_settings_advert_name").value + "&community_user_settings_up_img_val=" + _("community_user_settings_up_img_val").value + "&key=cyuma");

    }
}

function institution_user_settings_save_advert_data() {
    if (_("community_user_settings_advert_start_date").value == "" || _("community_user_settings_advert_finish_date").value == "" || _("community_user_settings_advert_start_time").value == "" || _("community_user_settings_advert_finish_time").value == "" || _("community_user_settings_advert_name").value == "" || _("community_user_settings_advert_name").value == "" || _("community_user_settings_up_img_val").value == "") {
        alert("Okay cool!");
    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/save_community_user_settings_advert.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&community_user_settings_advert_start_date=" + _("community_user_settings_advert_start_date").value + "&community_user_settings_advert_finish_date=" + _("community_user_settings_advert_finish_date").value + "&community_user_settings_advert_start_time=" + _("community_user_settings_advert_start_time").value + "&community_user_settings_advert_finish_time=" + _("community_user_settings_advert_finish_time").value + "&community_user_settings_advert_name=" + _("community_user_settings_advert_name").value + "&community_user_settings_up_img_val=" + _("community_user_settings_up_img_val").value + "&key=cyuma");

    }
}

//------------enlarge the image-------
function enlargeMe(obj, e) {
    $("#common_user_settings_enlarge_this_image").css("visibility", "visible");
    $("#common_user_settings_enlarge_this_image").fadeIn();
    _("common_user_settings_enlarge_this_image_preview").src = obj.src;
    _("common_user_settings_enlarge_this_image_preview").style.width = "70%";
    e.preventDefault();
}

//--------------------------------------------------
function hideThisEnlarge() {
    $("#common_user_settings_enlarge_this_image").fadeOut();
}

//-----------------
function institution_user_settings_suspend_user(obj) {
    if (confirm("Are you sure to continue!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/institution_user_settings_SuspendUser.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("insitution_user_settings_the_id=" + obj.name + "&key=cyuma");
    }
}

///-------------
function institution_user_settings_reedit_user(obj) {
    if (confirm("Are you sure to continue!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/institution_user_settings_ResetUser.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("insitution_user_settings_the_id=" + obj.name + "&key=cyuma");
    }
}

//-----------------
function institution_user_settings_activate_user(obj) {
    if (confirm("Are you sure to continue!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/institution_user_settings_activateNewUser.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("insitution_user_settings_the_id=" + obj.name + "&level_of_priviledge=" + _("institution_not_active" + obj.name).value + "&key=cyuma");
    }
}

//-----------------
function institution_user_settings_reactivate_user(obj) {
    if (confirm("Are you sure to continue!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "ajax_php_user_scripts/institution_user_settings_ReactivateUser.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    window.location = "institution_user_settings.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                showloadingPanel("failed");

            }
        };
        ajax.send("insitution_user_settings_the_id=" + obj.name + "&key=cyuma");
    }
}

//-----Main page codes finally----------------------
function main_page_post_inTheCommunity() {
    //_("main_page_community_post_field")--nds_main_page_send_post.php
    //_("common_user_settings_the_id")

    if (_("main_page_community_post_field").value != "") {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/nds_main_page_send_post.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    main_page_post_inTheCommunity_reload_tag_allPosts();
                    _("main_page_community_post_field").value = "";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("main_page_community_post_field=" + _("main_page_community_post_field").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");
    }
}

//-----------mainpage institution--
function main_page_institution_post_inTheCommunity() {
    //_("main_page_community_post_field")--nds_main_page_send_post.php
    //_("common_user_settings_the_id")

    if (_("main_page_institution_community_post_field").value != "") {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/nds_main_page_send_post.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    main_page_institution_post_inTheCommunity_reload_tag_allPosts();
                    _("main_page_institution_community_post_field").value = "";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("main_page_community_post_field=" + _("main_page_institution_community_post_field").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");
    }
}

function main_page_post_inTheCommunity_anImage() {
    //_("main_page_community_post_field")--nds_main_page_send_post.php
    //_("common_user_settings_the_id")
    $("#main_page_send_post_img_2017_popUp").css("visibility", "visible");
    $("#main_page_send_post_img_2017_popUp").slideDown();
    _("main_page_post_image_2017_up_file_preview").src = "";
    _("main_page_post_image_2017_up_file_caption").value = "";
}

function main_page_send_comment(obj, theNdsPostId, theCommentValContainer) {
    //alert(obj.name);
    if (_(obj.title).value != "") {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/nds_main_page_send_post_comment.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //showloadingPanel("loaded");
                    _(obj.title).value = "";
                    //---------------reload comments
                    main_page_posts_comments2017_reload(obj.name, theNdsPostId);

                    //window.location = "main_page.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("theNdsPostId=" + theNdsPostId + "&comment_2017=" + _(obj.title).value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");
    }
}

//---------------main page institution--------
function main_page_institution_send_comment(obj, theNdsPostId, theCommentValContainer) {
    //alert(obj.name);
    if (_(obj.title).value != "") {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/nds_main_page_send_post_comment.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    //showloadingPanel("loaded");
                    _(obj.title).value = "";
                    //---------------reload comments
                    main_page_institution_posts_comments2017_reload(obj.name, theNdsPostId);

                    //window.location = "main_page.php";
                } else {
                    alert(ajax.responseText);

                }
            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("theNdsPostId=" + theNdsPostId + "&comment_2017=" + _(obj.title).value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");
    }
}

function main_page_hide_flag_post_view(obj) {
    $("#" + obj.name).slideUp();
}

//-------main page institution---
function main_page_institution_hide_flag_post_view(obj) {
    $("#" + obj.name).slideUp();
}

function main_page_flag_this_post(obj, theNdsPostId) {

    $("#" + obj.name).css("visibility", "visible");
    $("#" + obj.name).slideDown();
}

function main_page_institution_flag_this_post(obj, theNdsPostId) {

    $("#" + obj.name).css("visibility", "visible");
    $("#" + obj.name).slideDown();
}

function main_page_flag_this_post_using_other(obj, theNdsPostId, theOther_radio_btn_trigger, theIsd) {
    //----------Other flag posting
    //_(theOther_radio_btn_trigger).checked = true;
    //alert(obj.title + _(obj.name).value + "Yes Flag This Dude!");
    //-----------
    if (_(obj.title).value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/NDS_ReportAPost.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    // var placeholder = document.getElementById(obj.id).getAttribute("placeholder");
                    //-----------
                    $("#" + "mainPageFlagOrReport" + theIsd).slideUp();

                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("theNdsPostId=" + theNdsPostId + "&theComment=" + _(obj.title).value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=unliked" + "&key=cyuma");

    }
}

//----------main page institution-----------
function main_page_institution_flag_this_post_using_other(obj, theNdsPostId, theOther_radio_btn_trigger, theIsd) {
    //----------Other flag posting
    //_(theOther_radio_btn_trigger).checked = true;
    //alert(obj.title + _(obj.name).value + "Yes Flag This Dude!");
    //-----------
    if (_(obj.title).value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/NDS_ReportAPost.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    // var placeholder = document.getElementById(obj.id).getAttribute("placeholder");
                    //-----------
                    $("#" + "mainPage_institution_FlagOrReport" + theIsd).slideUp();

                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("theNdsPostId=" + theNdsPostId + "&theComment=" + _(obj.title).value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=unliked" + "&key=cyuma");

    }
}

function main_page_flag_this_post_using_other_focus(obj, theNdsPostId, theOther_radio_btn_trigger) {
    //----------Other flag posting
    //alert("Inside");
    _(obj.title).checked = true;
    $("#" + obj.id).focus();
}

function main_page_institution_flag_this_post_using_other_focus(obj, theNdsPostId, theOther_radio_btn_trigger) {
    //----------Other flag posting
    //alert("Inside");
    _(obj.title).checked = true;
    $("#" + obj.id).focus();
}

function main_page_like_flag_this_post_2017(obj, theNdsPostId, whichTypeOfRate) {

    switch(whichTypeOfRate) {
        case "insulting":
            //alert("Insulting" + theNdsPostId);

            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "nds_web_scripts/NDS_ReportAPost.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        $("#" + obj.title).slideUp();

                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    //showloadingPanel("failed");

                }
            };
            ajax.send("theNdsPostId=" + theNdsPostId + "&theComment=" + "insulting" + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=unliked" + "&key=cyuma");

            break;
        case "inappropriate":
            //alert("Insulting" + theNdsPostId);
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "nds_web_scripts/NDS_ReportAPost.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        $("#" + obj.title).slideUp();

                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    //showloadingPanel("failed");

                }
            };
            ajax.send("theNdsPostId=" + theNdsPostId + "&theComment=" + "inappropriate" + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=unliked" + "&key=cyuma");

            break;
        case "other":
            // alert("Insulting" + theNdsPostId);
            break;

    }

}

//------------main page institution--------
function main_page_institution_like_flag_this_post_2017(obj, theNdsPostId, whichTypeOfRate) {

    switch(whichTypeOfRate) {
        case "insulting":
            //alert("Insulting" + theNdsPostId);

            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "nds_web_scripts/NDS_ReportAPost.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        $("#" + obj.title).slideUp();

                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    //showloadingPanel("failed");

                }
            };
            ajax.send("theNdsPostId=" + theNdsPostId + "&theComment=" + "insulting" + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=unliked" + "&key=cyuma");

            break;
        case "inappropriate":
            //alert("Insulting" + theNdsPostId);
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "nds_web_scripts/NDS_ReportAPost.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (parseInt(ajax.responseText) == 1000) {
                        showloadingPanel("loaded");
                        $("#" + obj.title).slideUp();

                    } else {
                        alert(ajax.responseText);

                    }
                } else {
                    //showloadingPanel("failed");

                }
            };
            ajax.send("theNdsPostId=" + theNdsPostId + "&theComment=" + "inappropriate" + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=unliked" + "&key=cyuma");

            break;
        case "other":
            // alert("Insulting" + theNdsPostId);
            break;

    }

}

function main_page_like_this_post(obj, theNdsPostId) {
    //alert("ThePostId=" + theNdsPostId);
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/NDS_likeOrDislikeThisPost.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");

            } else {
                alert(ajax.responseText);

            }
        } else {
            //showloadingPanel("failed");

        }
    };
    ajax.send("theNdsPostId=" + theNdsPostId + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=liked" + "&key=cyuma");

}

//---------main page institution---------
function main_page_institution_like_this_post(obj, theNdsPostId) {
    //alert("ThePostId=" + theNdsPostId);
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/NDS_likeOrDislikeThisPost.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");

            } else {
                alert(ajax.responseText);

            }
        } else {
            //showloadingPanel("failed");

        }
    };
    ajax.send("theNdsPostId=" + theNdsPostId + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=liked" + "&key=cyuma");

}

function main_page_unlike_this_post(obj, theNdsPostId) {
    //alert("ThePostId=" + theNdsPostId);
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/NDS_likeOrDislikeThisPost.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");

            } else {
                alert(ajax.responseText);

            }
        } else {
            //showloadingPanel("failed");

        }
    };
    ajax.send("theNdsPostId=" + theNdsPostId + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=unliked" + "&key=cyuma");

}

//-------------main page institution---
function main_page_institution_unlike_this_post(obj, theNdsPostId) {
    //alert("ThePostId=" + theNdsPostId);
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/NDS_likeOrDislikeThisPost.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (parseInt(ajax.responseText) == 1000) {
                showloadingPanel("loaded");

            } else {
                alert(ajax.responseText);

            }
        } else {
            //showloadingPanel("failed");

        }
    };
    ajax.send("theNdsPostId=" + theNdsPostId + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&likeOrDislikeTag=unliked" + "&key=cyuma");

}

function main_page_toggle_comment_of_this_post(obj, theNdsPostId) {

}


$(document).ready(function() {
    $(".main_page_collapsibles_2017").slideUp();
    $(".main_page_institution_collapsibles_2017").slideUp();
});
//--------------
function main_page_decollapse_this_comment(obj) {
    //----save them in array- looping_through_elements
    var allMyIds = [];
    var elements = document.getElementsByClassName("main_page_collapsibles_2017");
    for (var i = 0, len = elements.length; i < len; i++) {
        // elements[i].style ...
        allMyIds[i] = elements[i].id;
    }
    //-----use the ids-----
    for (var n = 0, len = allMyIds.length; n < len; n++) {
        // elements[i].style ...
        var tr = obj.name;
        var rt5 = allMyIds[n];
        if (obj.name == allMyIds[n]) {

            //alert("equal One");
        } else {
            $("#" + allMyIds[n]).slideUp();
        }

    }
    ///--

    $("#" + obj.name).slideToggle();

    main_page_the_last_populated = obj.name;
}

//--------main page institution--
function main_page_institution_decollapse_this_comment(obj) {
    //----save them in array- looping_through_elements
    var allMyIds = [];
    var elements = document.getElementsByClassName("main_page_institution_collapsibles_2017");
    for (var i = 0, len = elements.length; i < len; i++) {
        // elements[i].style ...
        allMyIds[i] = elements[i].id;
    }
    //-----use the ids-----
    for (var n = 0, len = allMyIds.length; n < len; n++) {
        // elements[i].style ...
        var tr = obj.name;
        var rt5 = allMyIds[n];
        if (obj.name == allMyIds[n]) {

            //alert("equal One");
        } else {
            $("#" + allMyIds[n]).slideUp();
        }

    }
    ///--

    $("#" + obj.name).slideToggle();

    main_page_institution_the_last_populated = obj.name;
}

function main_page_post_image_closeUp() {
    $("#main_page_send_post_img_2017_popUp").slideUp();
}

//--------------upload the image yo the community----------
function upload_main_page_post_img_2017() {
    var file = document.getElementById("main_page_post_image_2017_file").files[0];
    if (!file) {
    } else {
        //------------------
        var fd = new FormData();
        fd.append("main_page_post_image_2017_up_file_form", file);
        var aj = new XMLHttpRequest();
        aj.upload.addEventListener("progress", progress_main_page_post_img_2017, false);
        aj.addEventListener("load", complete_main_page_post_img_2017, false);
        aj.addEventListener("error", error_main_page_post_img_2017, false);
        aj.addEventListener("abort", abort_main_page_post_img_2017, false);
        aj.open("POST", "ajax_php_user_scripts/main_page_upload_the_postIMage.php");
        aj.send(fd);
    }
}

//----------------------------------
function progress_main_page_post_img_2017(event) {
    var percent = (event.loaded / event.total) * 100;
    var quotient = (event.loaded / event.total);
    document.getElementById("main_page_post_image_2017_up_file_msger").innerHTML = Math.round(percent) + "% Uploading ...";
    //document.getElementById("progressBar").style.width = (220 / event.total) * event.loaded + "px";
}

function complete_main_page_post_img_2017(event) {
    if (event.target.responseText == "none!" || event.target.responseText == "Wrong image format." || event.target.responseText == "Erros occur!") {
        document.getElementById("main_page_post_image_2017_up_file_msger").innerHTML = "";
    } else {
        document.getElementById("main_page_post_image_2017_up_file_msger").innerHTML = "";
        //document.getElementById("progressBar").style.width = 0;
        _("main_page_post_image_2017_up_file_name").value = event.target.responseText;
        _("main_page_post_image_2017_up_file_preview").src = "nds_community_posts_images/" + event.target.responseText;

    }
}

function error_main_page_post_img_2017(event) {
}

function abort_main_page_post_img_2017(event) {
}

//------------------Safe the posts main page afterwards----
function main_page_send_img_post() {
    if (_("main_page_post_image_2017_up_file_name").value == "" || _("main_page_post_image_2017_up_file_caption").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/nds_main_page_send_post_image.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    $("#main_page_send_post_img_2017_popUp").slideUp();
                    main_page_post_inTheCommunity_reload_tag_allPosts();
                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("main_page_post_image_2017_up_file_name=" + _("main_page_post_image_2017_up_file_name").value + "&main_page_post_image_2017_up_file_caption=" + _("main_page_post_image_2017_up_file_caption").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

//----------main page institution
function main_page_institution_send_img_post() {
    if (_("main_page_post_image_2017_up_file_name").value == "" || _("main_page_post_image_2017_up_file_caption").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/nds_main_page_send_post_image.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");
                    $("#main_page_send_post_img_2017_popUp").slideUp();
                    main_page_institution_post_inTheCommunity_reload_tag_allPosts();
                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("main_page_post_image_2017_up_file_name=" + _("main_page_post_image_2017_up_file_name").value + "&main_page_post_image_2017_up_file_caption=" + _("main_page_post_image_2017_up_file_caption").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

//---------------function--reload the posts after a new post------.
function main_page_post_inTheCommunity_reload_tag_allPosts() {

    var ajax = ajaxObj("POST", "nds_main_page_reload_posts_tag_all.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("main_page_common_user_posts_preview").innerHTML = "" + ajax.responseText;
            $(".main_page_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&key=cyuma");

}

//-----------main page institution-----------
function main_page_institution_post_inTheCommunity_reload_tag_allPosts() {

    var ajax = ajaxObj("POST", "nds_main_page_institution_reload_posts_tag_all.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("theDownFeedData").innerHTML = "" + ajax.responseText;
            $(".main_page_institution_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("&key=cyuma");

}

//-------------------------reload comments-----nds_main_page_reload_posts_tag_commentsOfIdPost.php
var main_page_the_last_populated;
var main_page_institution_the_last_populated;
function main_page_posts_comments2017_reload(comments_conatiner, NdsPostId) {
    showloadingPanel("erase");
    var ajax = ajaxObj("POST", "nds_main_page_reload_posts_tag_commentsOfIdPost.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            main_page_the_last_populated = comments_conatiner;

            _(comments_conatiner).innerHTML = "" + ajax.responseText;
            $("#" + comments_conatiner).slideDown();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("NdsPostId=" + NdsPostId + "&key=cyuma");

}

//--------main page institution--
function main_page_institution_posts_comments2017_reload(comments_conatiner, NdsPostId) {
    showloadingPanel("erase");
    var ajax = ajaxObj("POST", "nds_main_page_institution_reload_posts_tag_commentsOfIdPost.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            main_page_institution_the_last_populated = comments_conatiner;

            _(comments_conatiner).innerHTML = "" + ajax.responseText;
            $("#" + comments_conatiner).slideDown();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("NdsPostId=" + NdsPostId + "&key=cyuma");

}

//--------------------------the rest of the main page-------------
function main_page_delete_this_post(obj, thePostId) {
    //alert("Delete the post ->" + thePostId);
    //-----------container id=
    if (confirm("Okay To Delete?!!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/NDS_DeleteThisPost.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");

                    main_page_post_inTheCommunity_reload_tag_allPosts();
                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&thePostId=" + thePostId + "&key=cyuma");

    }
}

//--------------
function main_page_institution_delete_this_post(obj, thePostId) {
    //alert("Delete the post ->" + thePostId);
    //-----------container id=
    if (confirm("Okay To Delete?!!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/NDS_DeleteThisPost.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");

                    main_page_institution_post_inTheCommunity_reload_tag_allPosts();
                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&thePostId=" + thePostId + "&key=cyuma");

    }
}

//-------------
//-------------------------reload comments-----nds_main_page_reload_posts_tag_commentsOfIdPost.php

function main_page_delete_this_post_comment(obj, thePostId, TheCommentID, ThNumbefr) {
    //alert("Delete the post comment ->" + thePostId);
    //-----------container id=
    if (confirm("Okay To Delete?!!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/NDS_DeleteThisPost_comment.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");

                    main_page_posts_comments2017_reload(main_page_the_last_populated, thePostId);
                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("" + "" + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&TheCommentID=" + TheCommentID + "&key=cyuma");

    }
}

//---------main page institution--
function main_page_institution_delete_this_post_comment(obj, thePostId, TheCommentID, ThNumbefr) {
    //alert("Delete the post comment ->" + thePostId);
    //-----------container id=
    if (confirm("Okay To Delete?!!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/NDS_DeleteThisPost_comment.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    showloadingPanel("loaded");

                    main_page_institution_posts_comments2017_reload(main_page_institution_the_last_populated, thePostId);
                } else {
                    alert(ajax.responseText);

                }
            } else {
                //showloadingPanel("failed");

            }
        };
        ajax.send("" + "" + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&TheCommentID=" + TheCommentID + "&key=cyuma");

    }
}

//---------------Using timer to load new stuff on main page--------------/
//-----global_var_which_forum_menu = "where_i_am_tagged";
//--main_page_carousel---
var main_page_carousel_tes = 0;
//------------main page institution--
var main_page_institution_carousel_tes = 0;
window.setInterval(function() {
    //----check if we are on the main page
    if (_("main_page_carousel") && global_var_which_forum_menu == "all") {
        //----------Find the new Posts If Available
        main_page_load_the_new_posts_number();

    } else {
        $("#main_page_carousel_new_posts").slideUp();
    }
    //-------------main page institution--
    if (_("main_page_institution_2017_") && global_var_main_page_institution_which_forum_menu == "all") {
        //----------Find the new Posts If Available
        main_page_institution_load_the_new_posts_number();

    } else {
        $("#main_page_institution_carousel_new_posts").slideUp();
        //alert("TR");
    }

    main_page_carousel_tes++;
    main_page_institution_carousel_tes++;

}, 3500);
//---------------------------
$(document).ready(function() {
    $("#main_page_carousel_new_posts").slideUp();
    //----main page institution-
    $("#main_page_institution_carousel_new_posts").slideUp();
});
function main_page_load_the_new_posts_number() {
    // showloadingPanel("erase");
    var ajax = ajaxObj("POST", "nds_web_scripts/NDS_main_page_count_new_posts.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {

            _("main_page_carousel_new_posts").innerHTML = parseInt(ajax.responseText) + " " + _("main_page_carousel_new_posts_uruhago_txt").value;
            _("main_page_carousel_new_posts_uruhago").value = parseInt(ajax.responseText);
            if (parseInt(ajax.responseText) == 0) {

                $("#main_page_carousel_new_posts").slideUp();

            } else {
                $("#main_page_carousel_new_posts").slideDown();
            }

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("main_page_latest_id=" + _('main_page_post_first_id').value + "&key=cyuma");
}

//---------------main page institution--
function main_page_institution_load_the_new_posts_number() {
    // showloadingPanel("erase");
    var ajax = ajaxObj("POST", "nds_web_scripts/NDS_main_page_count_new_posts.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {

            _("main_page_institution_carousel_new_posts").innerHTML = parseInt(ajax.responseText) + " " + _("main_page_institution_carousel_new_posts_uruhago_txt").value;
            _("main_page_institution_carousel_new_posts_uruhago").value = parseInt(ajax.responseText);
            if (parseInt(ajax.responseText) == 0) {

                $("#main_page_institution_carousel_new_posts").slideUp();

            } else {
                $("#main_page_institution_carousel_new_posts").slideDown();
            }

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("main_page_latest_id=" + _('main_page_institution_post_first_id').value + "&key=cyuma");
}

//-----------------
function main_page_load_the_new_posts_click() {
    showloadingPanel("loading");
    main_page_post_inTheCommunity_reload_tag_allPosts();
}

//----------main page institution--
function main_page_institution_load_the_new_posts_click() {
    showloadingPanel("loading");
    main_page_institution_post_inTheCommunity_reload_tag_allPosts();
}

function main_page_load_the_old_posts_click() {
    //alert(_("main_page_post_last_id").value);
    //---------------------------------------
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_main_page_reload_posts_tag_all_limit_add_10.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("main_page_common_user_posts_preview").innerHTML = ajax.responseText;
            $(".main_page_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("main_page_post_last_id=" + _("main_page_post_last_id").value + "&key=cyuma");
}

//---------main page institution----------
function main_page_institution_load_the_old_posts_click() {
    //alert(_("main_page_institution_post_last_id").value);
    //---------------------------------------
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_main_page_institution_reload_posts_tag_all_limit_add_10.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            _("theDownFeedData").innerHTML = ajax.responseText;
            $(".main_page_institution_collapsibles_2017").slideUp();

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("main_page_post_last_id=" + _("main_page_institution_post_last_id").value + "&key=cyuma");
}

//-------------main_page_the_last_populated--main_page_posts_comments2017_reload(comments_conatiner, NdsPostId)
function main_page_posts_comments_refresh_up(thePostId, obj) {
    //alert("Up=" + thePostId);
    try {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_reload_posts_tag_commentsOfIdPost_more_up.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;
                //alert('Error occured' + obj.className);
                if (obj.className != "") {
                    _(obj.className).innerHTML = "" + ajax.responseText;
                    $("#" + obj.className).slideDown();
                } else {
                    _(main_page_the_last_populated).innerHTML = "" + ajax.responseText;
                    $("#" + main_page_the_last_populated).slideDown();
                }

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("NdsPostId=" + thePostId + "&first_id_comment=" + _("mainpage_first_comment_id").value + "&key=cyuma");

    } catch(err) {

        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_reload_posts_tag_commentsOfIdPost_more_up.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;

                _(main_page_the_last_populated).innerHTML = "" + ajax.responseText;
                $("#" + main_page_the_last_populated).slideDown();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("NdsPostId=" + thePostId + "&first_id_comment=" + _("mainpage_first_comment_id").value + "&key=cyuma");

    }

}

//-------------main page institution--
function main_page_institution_posts_comments_refresh_up(thePostId, obj) {
    //alert("Up=" + thePostId);
    try {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_institution_reload_posts_tag_commentsOfIdPost_more_up.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;
                //alert('Error occured' + obj.className);
                if (obj.className != "") {
                    _(obj.className).innerHTML = "" + ajax.responseText;
                    $("#" + obj.className).slideDown();
                } else {
                    _(main_page_institution_the_last_populated).innerHTML = "" + ajax.responseText;
                    $("#" + main_page_institution_the_last_populated).slideDown();
                }

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("NdsPostId=" + thePostId + "&first_id_comment=" + _("mainpage_institution_first_comment_id").value + "&key=cyuma");

    } catch(err) {

        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_institution_reload_posts_tag_commentsOfIdPost_more_up.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;

                _(main_page_institution_the_last_populated).innerHTML = "" + ajax.responseText;
                $("#" + main_page_institution_the_last_populated).slideDown();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("NdsPostId=" + thePostId + "&first_id_comment=" + _("mainpage_institution_first_comment_id").value + "&key=cyuma");

    }

}

//----------------------
function main_page_posts_comments_refresh_down(thePostId, obj) {
    //alert("Down=" + obj.name);
    try {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_reload_posts_tag_commentsOfIdPost_more_down.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;
                if (obj.className != "") {
                    _(obj.className).innerHTML = "" + ajax.responseText;
                    $("#" + obj.className).slideDown();
                } else {
                    _(main_page_the_last_populated).innerHTML = "" + ajax.responseText;
                    $("#" + main_page_the_last_populated).slideDown();

                }

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("NdsPostId=" + thePostId + "&last_id_comment=" + _("mainpage_last_comment_id").value + "&key=cyuma");

    } catch(err) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_reload_posts_tag_commentsOfIdPost_more_down.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;

                _(main_page_the_last_populated).innerHTML = "" + ajax.responseText;
                $("#" + main_page_the_last_populated).slideDown();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("NdsPostId=" + thePostId + "&last_id_comment=" + _("mainpage_last_comment_id").value + "&key=cyuma");

    }
}

//-------------main page institution-
function main_page_institution_posts_comments_refresh_down(thePostId, obj) {
    //alert("Down=" + obj.name);
    try {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_institution_reload_posts_tag_commentsOfIdPost_more_down.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;
                if (obj.className != "") {
                    _(obj.className).innerHTML = "" + ajax.responseText;
                    $("#" + obj.className).slideDown();
                } else {
                    _(main_page_institution_the_last_populated).innerHTML = "" + ajax.responseText;
                    $("#" + main_page_institution_the_last_populated).slideDown();

                }

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("NdsPostId=" + thePostId + "&last_id_comment=" + _("mainpage_institution_last_comment_id").value + "&key=cyuma");

    } catch(err) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_main_page_institution_reload_posts_tag_commentsOfIdPost_more_down.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;

                _(main_page_institution_the_last_populated).innerHTML = "" + ajax.responseText;
                $("#" + main_page_institution_the_last_populated).slideDown();

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("NdsPostId=" + thePostId + "&last_id_comment=" + _("mainpage_institution_last_comment_id").value + "&key=cyuma");

    }
}

//-------------notifications and messages--main_page_institution_2017_--common_user_settings_the_id-
//--main page suggestions manipulation--
function main_page_institution_pic_view() {
    $("#main_page_institution_pic_view_container").slideUp();
}

function main_page_institution_pic_view_this_img_enlarge(obj) {

    var p = $("#" + obj.id);
    var position = p.position();
    _("main_page_institution_pic_view_container").style.left = 200 + "px";
    _("main_page_institution_pic_view_container").style.top = 200 + "px";
    $("#main_page_institution_pic_view_container").css("visibility", "visible");
    $("#main_page_institution_pic_view_container").css("z-index", 100000);
    _("main_page_institution_pic_view_container_img_src").src = obj.src;
    $("#main_page_institution_pic_view_container").fadeIn();
}

function main_page_institution_pic_view_this_img_enlarge_for_rgb(obj) {
    try {
        _("main_page_institution_pic_view_container").style.left = 200 + "px";
        _("main_page_institution_pic_view_container").style.top = 200 + "px";
        $("#main_page_institution_pic_view_container").css("visibility", "visible");
        $("#main_page_institution_pic_view_container").css("z-index", 100000);
        _("main_page_institution_pic_view_container_img_src").src = obj.src;
        $("#main_page_institution_pic_view_container").fadeIn();
    } catch(err) {

    }

}

//----the suggestion 's institution handling----------
function main_page_institution_visualize_suggestion_details_hide() {
    $("#main_page_institution_sugg_details_container_mugabo_2017").slideUp();
}

function main_page_institution_visualize_suggestion_details_rgb(obj) {
    //alert(obj.name);
    ///-----
    $("#main_page_institution_sugg_details_container_mugabo_2017").css("visibility", "visible");
    $("#main_page_institution_sugg_details_container_mugabo_2017").slideDown();
    //------------------------------------------
    var ttLeft, ttRight, $this = $("#" + obj.id), $tip = $("#main_page_institution_sugg_details_container_mugabo_2017"), triggerPos = $this.offset(), triggerH = $this.outerHeight(), triggerW = $this.outerWidth(), tipW = $tip.outerWidth(), tipH = $tip.outerHeight(), screenW = $(window).width(), scrollTop = $(document).scrollTop();

    if (triggerPos.top - tipH - scrollTop > 0) {
        ttTop = triggerPos.top - tipH - 10;
    } else {
        ttTop = triggerPos.top + triggerH + 10;
    }
    var overFlowRight = (triggerPos.left + tipW) - screenW;
    if (overFlowRight > 0) {
        ttLeft = triggerPos.left - overFlowRight - 10;
    } else {
        ttLeft = triggerPos.left + 30;
    }
    $tip.css({
        left : ttLeft,
        top : ttTop,
        position : 'absolute'
    }).fadeIn(200);
    //--------Populating the popup------
    _("main_page_institution_sugg_details_container_mugabo_2017_data_2017").innerHTML = "<img src='images/loader_custom.gif' style='margin:auto;width:100px;height:100px;border-radius:20px;' />";
    //------------Go to server and bring the cool stuff---
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_throw_an_eye_onthe_institution_suggestion_rgb.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            //main_page_the_last_populated = comments_conatiner;

            _("main_page_institution_sugg_details_container_mugabo_2017_data_2017").innerHTML = "" + ajax.responseText;

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("the2017_suggestId_MugaboS_Cedric=" + obj.name + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");
    //----------------
}

function main_page_institution_visualize_suggestion_details(obj) {
    //alert(obj.name);
    ///-----
    $("#main_page_institution_sugg_details_container_mugabo_2017").css("visibility", "visible");
    $("#main_page_institution_sugg_details_container_mugabo_2017").slideDown();
    //------------------------------------------
    var ttLeft, ttRight, $this = $("#" + obj.id), $tip = $("#main_page_institution_sugg_details_container_mugabo_2017"), triggerPos = $this.offset(), triggerH = $this.outerHeight(), triggerW = $this.outerWidth(), tipW = $tip.outerWidth(), tipH = $tip.outerHeight(), screenW = $(window).width(), scrollTop = $(document).scrollTop();

    if (triggerPos.top - tipH - scrollTop > 0) {
        ttTop = triggerPos.top - tipH - 10;
    } else {
        ttTop = triggerPos.top + triggerH + 10;
    }
    var overFlowRight = (triggerPos.left + tipW) - screenW;
    if (overFlowRight > 0) {
        ttLeft = triggerPos.left - overFlowRight - 10;
    } else {
        ttLeft = triggerPos.left + 30;
    }
    $tip.css({
        left : ttLeft,
        top : ttTop,
        position : 'absolute'
    }).fadeIn(200);
    //--------Populating the popup------
    _("main_page_institution_sugg_details_container_mugabo_2017_data_2017").innerHTML = "<img src='images/loader_custom.gif' style='margin:auto;width:100px;height:100px;border-radius:20px;' />";
    //------------Go to server and bring the cool stuff---
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_throw_an_eye_onthe_institution_suggestion.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            //main_page_the_last_populated = comments_conatiner;

            _("main_page_institution_sugg_details_container_mugabo_2017_data_2017").innerHTML = "" + ajax.responseText;

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("the2017_suggestId_MugaboS_Cedric=" + obj.name + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");
    //----------------
}

var thesuggestion_ID_2017_mugabo_main_inst;
function main_page_institution_visualize_suggestion_commentators(obj) {
    //alert(obj.name);
    thesuggestion_ID_2017_mugabo_main_inst = obj.name;
    $("#main_page_institution_sugg_details_conversations_container_mugabo_2017").css("visibility", "visible");
    $("#main_page_institution_sugg_details_conversations_container_mugabo_2017").slideDown();
    //------------------------------------------
    var ttLeft, ttRight, $this = $("#" + obj.id), $tip = $("#main_page_institution_sugg_details_conversations_container_mugabo_2017"), triggerPos = $this.offset(), triggerH = $this.outerHeight(), triggerW = $this.outerWidth(), tipW = $tip.outerWidth(), tipH = $tip.outerHeight(), screenW = $(window).width(), scrollTop = $(document).scrollTop();

    if (triggerPos.top - tipH - scrollTop > 0) {
        ttTop = triggerPos.top - tipH - 10;
    } else {
        ttTop = triggerPos.top + triggerH + 10;
    }
    var overFlowRight = (triggerPos.left + tipW) - screenW;
    if (overFlowRight > 0) {
        ttLeft = triggerPos.left - overFlowRight - 10;
    } else {
        ttLeft = triggerPos.left + 30;
    }
    $tip.css({
        left : ttLeft,
        top : ttTop,
        position : 'absolute'
    }).fadeIn(200);
    //------------populating the comment pool--
    //----
    _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").innerHTML = "<div style-'margin-auto;'><img src='images/loader_custom.gif' style='margin:auto;width:100px;height:100px;border-radius:20px;' /></div>";
    ;
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_institution_suggestions_chats_load.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            //main_page_the_last_populated = comments_conatiner;
            _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").innerHTML = "" + ajax.responseText;
            _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").scrollTop = _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").scrollHeight;

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("the2017_suggestId_MugaboS_Cedric=" + obj.name + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_suggest_comment_pool_strategy=" + _("main_page_institution_suggest_comment_pool_strategy").value + "&key=cyuma");
    //----------------
}

//-------------------------
function main_page_institution_visualize_suggestion_commentators_reload() {
    _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").innerHTML = "<div style-'margin-auto;'><img src='images/loader_custom.gif' style='margin:auto;width:100px;height:100px;border-radius:20px;' /></div>";
    ;
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_institution_suggestions_chats_load.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            //main_page_the_last_populated = comments_conatiner;
            _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").innerHTML = "" + ajax.responseText;
            _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").scrollTop = _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").scrollHeight;

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("the2017_suggestId_MugaboS_Cedric=" + thesuggestion_ID_2017_mugabo_main_inst + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_suggest_comment_pool_strategy=" + _("main_page_institution_suggest_comment_pool_strategy").value + "&key=cyuma");

}

//------------------------------------
function main_page_institution_visualize_suggestion_commentators_hide() {
    $("#main_page_institution_sugg_details_conversations_container_mugabo_2017").slideUp();
}

//----------------Navigate Through Message Choice---------
function main_page_institution_suggest_comment_mark_this(obj) {
    switch(obj.id) {
        case "jdj9900":
            //-------------------
            _("main_page_institution_suggest_comment_pool_strategy").value = "show_all_types_of_messages";
            main_page_institution_visualize_suggestion_commentators_reload();

            //--------------
            break;
        case "jdj9901":
            //-------------------
            _("main_page_institution_suggest_comment_pool_strategy").value = "show_only_internal_messages";
            main_page_institution_visualize_suggestion_commentators_reload();
            //-------------
            break;
        case "jdj9902":
            //-----------------------
            _("main_page_institution_suggest_comment_pool_strategy").value = "show_only_externally_open_messages";
            main_page_institution_visualize_suggestion_commentators_reload();
            //------------
            break;

    }
    //---------------------------------------------------------------
}

//----------------------
function main_page_institution_suggest_comment_2017_send() {
    //---_("common_user_settings_the_id").value
    //alert(thesuggestion_ID_2017_mugabo_main_inst + "---" + _("main_page_institution_suggest_comment_pool_view_strategy").value + "--" + _("main_page_institution_suggest_comment_pool_strategy").value);
    if (_("main_page_institution_suggesttion_comment_data").value == "") {

    } else {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/main_page_community_suggestion_institution_send_comment.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    _("main_page_institution_suggesttion_comment_data").value = "";
                    main_page_institution_visualize_suggestion_commentators_reload();
                    showloadingPanel("erase");
                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("main_page_institution_suggest_comment_pool_view_strategy=" + _("main_page_institution_suggest_comment_pool_view_strategy").value + "&main_page_institution_suggesttion_comment_data=" + _("main_page_institution_suggesttion_comment_data").value + "&the2017_suggestId_MugaboS_Cedric=" + thesuggestion_ID_2017_mugabo_main_inst + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_suggest_comment_pool_strategy=" + _("main_page_institution_suggest_comment_pool_strategy").value + "&key=cyuma");

    }
}

//----------------
function main_page_institution_comment_commntTypeMugabo_2017(obj) {
    switch(obj.id) {
        case "cmmntType456_main":
            //-------------------
            _("main_page_institution_suggest_comment_pool_view_strategy").value = "visible_to_public";

            //--------------
            break;
        case "cmmntType457_main":
            //-------------------
            _("main_page_institution_suggest_comment_pool_view_strategy").value = "invisible_to_public";
            //-------------
            break;

    }

}

//-----------Delete the sent comment------by Me--------------------
function main_page_institution_delete_this_commnt_suggestion(obj) {
    //--------------
    if (confirm("Are you sure, you want to delete this comment!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/NDS_DeleteThisCommunity_suggest_comment.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    main_page_institution_visualize_suggestion_commentators_reload();
                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("TheCommentID=" + obj.name + "&key=cyuma");

    }

}

//-----------------Detect session validity--------------------------------------------------
$(document).ready(function() {
    //-------
    window.setInterval(function() {
        $.get('nds_web_scripts/session_expire_status.php', function(data) {
            if (data == "Expired") {
                if (window.location.pathname === '/nds_ogenius/home.php') {
                    //code for index page

                } else {
                    //other tasks
                    window.location = "index.php";
                }
            } else if (data == "Active") {
                if (window.location.pathname === '/nds_ogenius/home.php') {
                    //code for index page

                } else {
                    //other tasks
                    // alert("Session active--"+window.location.pathname);
                }
                //
            } else {
                //alert("----"+data);
            }
        });

    }, 3000);

});
//------------load more comments on a suggestion thread--------
var thePreviousId_ = 0;
var thePreviousId_temp = 0;
function main_page_institution_load_more_cmmnts(obj, thesuggestBoxId) {
    // alert(obj.name + "---" + thesuggestBoxId);
    thePreviousId_ = obj.name;
    //---
    //_("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").innerHTML = "<div style-'margin-auto;'><img src='images/loader_custom.gif' style='margin:auto;width:100px;height:100px;border-radius:20px;' /></div>";
    if (thePreviousId_temp >= parseInt(obj.name)) {
        thePreviousId_temp = parseInt(obj.name);
        $("#" + obj.id).fadeOut();

    } else {
        thePreviousId_temp = parseInt(obj.name);
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/main_page_institution_suggestions_chats_load_with_more.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                //main_page_the_last_populated = comments_conatiner;
                var ancientHeight = _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").scrollHeight;
                _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").innerHTML = "" + ajax.responseText + _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").innerHTML;
                _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").scrollTop = _("main_page_institution_the_suggestion_chat_pool_2017_mugabo_data").scrollHeight - ancientHeight;

            } else {
                // showloadingPanel("failed");

            }
        };
        ajax.send("thePreviousIdCmment=" + obj.name + "&the2017_suggestId_MugaboS_Cedric=" + thesuggestBoxId + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_suggest_comment_pool_strategy=" + _("main_page_institution_suggest_comment_pool_strategy").value + "&key=cyuma");

    }

}

//-------------------load more suggestions ------------
function main_page_institution_load_latest_suggestions() {
    if (_("main_page_institution_suggestions_first_id")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "main_page_institution_suggestions_load_moreUp.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText + _("main_page_institution_suggestions_pool_data_2017").innerHTML;
            } else {
                // showloadingPanel("failed");
            }
        };
        ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_suggestions_first_id=" + _("main_page_institution_suggestions_first_id").value + "&key=cyuma");

    }
}

//----------load the previous suggestion--
function main_page_institution_load_latest_suggestions_downward() {

    if (_("main_page_institution_suggestions_last_id")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "main_page_institution_suggestions_load_moreDown.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText + _("main_page_institution_suggestions_pool_data_2017").innerHTML + ajax.responseText;
            } else {
                // showloadingPanel("failed");
            }
        };
        ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_suggestions_last_id=" + _("main_page_institution_suggestions_last_id").value + "&key=cyuma");
    }
}

//---------the institution's suggestions sorting mechanisms--
var suggestions_directive_load_2017_classA = "m_insti_descending";
var suggestions_directive_load_2017_classB = "m_insti_media_type";
//---------------
function main_page_institution_suggestions_sortClassA_markIt(obj) {
    //---m_insti_ascending--m_insti_descending--m_insti_byname--m_insti_bykeyword--m_insti_bygender
    //--m_insti_bymarital_status--
    switch(obj.id) {
        case "m_insti_ascending":
            suggestions_directive_load_2017_classA = obj.id;
            //alert(suggestions_directive_load_2017_classA);
            break;
        case "m_insti_descending":
            suggestions_directive_load_2017_classA = obj.id;
            //alert(suggestions_directive_load_2017_classA);
            break;
        case "m_insti_byname":
            suggestions_directive_load_2017_classA = obj.id;
            //alert(suggestions_directive_load_2017_classA);
            break;
        case "m_insti_bykeyword":
            suggestions_directive_load_2017_classA = obj.id;
            //alert(suggestions_directive_load_2017_classA);
            break;
        case "m_insti_bygender":
            suggestions_directive_load_2017_classA = obj.id;
            //alert(suggestions_directive_load_2017_classA);
            break;
        case "m_insti_bymarital_status":
            suggestions_directive_load_2017_classA = obj.id;
            //alert(suggestions_directive_load_2017_classA);
            break;

    }

}

//---------------
function main_page_institution_suggestions_sortClassB_markIt(obj) {

    //---m_insti_date_range--m_insti_media_type
    switch(obj.id) {
        case "m_insti_date_range":
            suggestions_directive_load_2017_classB = obj.id;
            //alert(suggestions_directive_load_2017_classB);
            break;
        case "m_insti_media_type":
            suggestions_directive_load_2017_classB = obj.id;
            //alert(suggestions_directive_load_2017_classB);
            break;

    }

}

//--------class A------------
function main_page_institution_suggestions_sortClassA() {
    switch(suggestions_directive_load_2017_classA) {
        case "m_insti_ascending":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "main_page_institution_suggestions_with_sorting_Algorithm.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText;
                } else {
                    // showloadingPanel("failed");
                }
            };
            ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_sort_tag=" + suggestions_directive_load_2017_classA + "&key=cyuma");

            break;
        case "m_insti_descending":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "main_page_institution_suggestions_with_sorting_Algorithm.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText;
                } else {
                    // showloadingPanel("failed");
                }
            };
            ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_sort_tag=" + suggestions_directive_load_2017_classA + "&key=cyuma");

            break;
        case "m_insti_byname":
            if (_("main_page_institutioin_suggest_byname").value.length >= 2) {
                showloadingPanel("loading");
                var ajax = ajaxObj("POST", "main_page_institution_suggestions_with_sorting_Algorithm.php");
                ajax.onreadystatechange = function() {
                    if (ajaxReturn(ajax) == true) {
                        _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText;
                    } else {
                        // showloadingPanel("failed");
                    }
                };
                ajax.send("main_page_institutioin_suggest_byname=" + _("main_page_institutioin_suggest_byname").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_sort_tag=" + suggestions_directive_load_2017_classA + "&key=cyuma");
            }
            break;
        case "m_insti_bykeyword":
            if (_("main_page_institutioin_suggest_bykeyword").value.length >= 2) {
                showloadingPanel("loading");
                var ajax = ajaxObj("POST", "main_page_institution_suggestions_with_sorting_Algorithm.php");
                ajax.onreadystatechange = function() {
                    if (ajaxReturn(ajax) == true) {
                        _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText;
                    } else {
                        // showloadingPanel("failed");
                    }
                };
                ajax.send("main_page_institutioin_suggest_bykeyword=" + _("main_page_institutioin_suggest_bykeyword").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_sort_tag=" + suggestions_directive_load_2017_classA + "&key=cyuma");
            }
            break;
        case "m_insti_bygender":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "main_page_institution_suggestions_with_sorting_Algorithm.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText;
                } else {
                    // showloadingPanel("failed");
                }
            };
            ajax.send("main_page_institutioin_suggest_bygender=" + _("main_page_institutioin_suggest_bygender").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_sort_tag=" + suggestions_directive_load_2017_classA + "&key=cyuma");

            break;
        case "m_insti_bymarital_status":
            showloadingPanel("loading");
            var ajax = ajaxObj("POST", "main_page_institution_suggestions_with_sorting_Algorithm.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText;
                } else {
                    // showloadingPanel("failed");
                }
            };
            ajax.send("main_page_institutioin_suggest_bymarital_status=" + _("main_page_institutioin_suggest_bymarital_status").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_sort_tag=" + suggestions_directive_load_2017_classA + "&key=cyuma");

            break;

    }

}

//--------class B------------
function main_page_institution_suggestions_sortClassB() {

    //-----------------check if checked--$(".insti_media_type").attr("checked") == true)
    var main_page_insti_suggest;
    var radioObj = document.getElementsByName('sgstChoice_classB');
    for (var i = 0; i < radioObj.length; i++) {
        if (radioObj[i].checked) {
            main_page_insti_suggest = radioObj[i].className;
            //alert(radioObj[i].className);
        }
    }

    //------------
    if (main_page_insti_suggest == "insti_media_type") {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "main_page_institution_suggestions_with_sorting_Algorithm.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText;
            } else {
                // showloadingPanel("failed");
            }
        };
        ajax.send("main_page_institutioin_suggest_bymedia_type=" + _("main_page_institutioin_suggest_bymedia_type").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_sort_tag=" + suggestions_directive_load_2017_classB + "&classBOrientation=" + "mediatype" + "&key=cyuma");

    }

}

//-----------
function main_page_institution_suggestions_sortClassB_2(btn) {

    var main_page_insti_suggest;
    var radioObj = document.getElementsByName('sgstChoice_classB');
    for (var i = 0; i < radioObj.length; i++) {
        if (radioObj[i].checked) {
            main_page_insti_suggest = radioObj[i].className;
            //alert(radioObj[i].className);
        }
    }
    //-----------------------------
    if (main_page_insti_suggest == "insti_date_range") {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "main_page_institution_suggestions_with_sorting_Algorithm.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                _("main_page_institution_suggestions_pool_data_2017").innerHTML = "" + ajax.responseText;
            } else {
                // showloadingPanel("failed");
            }
        };
        ajax.send("btn=" + btn + "&secondDateToUse=" + _("pickBirthDay_second").value + "&firstDateToUse=" + _("pickBirthDay").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_sort_tag=" + suggestions_directive_load_2017_classB + "&classBOrientation=" + "daterange" + "&key=cyuma");
    }

}

//-----------------------------------------------------------------------
//-----------reply to rgtb query---
var global_queryProvider = 0;
var global_queryId = 0;
var global_TheToBeId_nOw = '';
function main_page_rgb_reply_to_query(obj, queryProvider, queryId) {
    global_queryProvider = queryProvider;
    global_queryId = queryId;
    global_TheToBeId_nOw = obj.id;
    main_page_institution_RGB_TheQueryID = queryId;
    $("#main_page_institution_rgb_reply_popup").css("visibility", "visible");
    $("#main_page_institution_rgb_reply_popup").slideDown();

    //------------------------------------------
    var ttLeft, ttRight, $this = $("#" + obj.id), $tip = $("#main_page_institution_rgb_reply_popup"), triggerPos = $this.offset(), triggerH = $this.outerHeight(), triggerW = $this.outerWidth(), tipW = $tip.outerWidth(), tipH = $tip.outerHeight(), screenW = $(window).width(), scrollTop = $(document).scrollTop();

    if (triggerPos.top - tipH - scrollTop > 0) {
        ttTop = triggerPos.top - tipH - 10;
    } else {
        ttTop = triggerPos.top + triggerH + 10;
    }
    var overFlowRight = (triggerPos.left + tipW) - screenW;
    if (overFlowRight > 0) {
        ttLeft = triggerPos.left - overFlowRight - 10;
    } else {
        ttLeft = triggerPos.left + 30;
    }
    $tip.css({
        left : ttLeft,
        top : ttTop,
        position : 'absolute'
    }).fadeIn(200);
    //-----------------------------
    main_page_institution_visualize_rgb_query_commentators_reload();
}

//--------forward this query to other institution user---
var main_page_institution_RGB_TheQueryID = "";
var main_page_institution_RGB_TheQueryID_the_provider = "";
function main_page_rgb_forward_this_query(obj, queryProvider, queryId) {
    main_page_institution_RGB_TheQueryID = queryId;
    main_page_institution_RGB_TheQueryID_the_provider = queryProvider;
    $("#main_page_institution_rgb_forward_as_popup").css("visibility", "visible");
    $("#main_page_institution_rgb_forward_as_popup").slideDown();
    //------------------------------------------
    try {
        global_queryProvider = parseInt(queryProvider);
    } catch(err) {
        alert(err);
    }

    global_queryId = queryId;
    global_TheToBeId_nOw = obj.id;
    var ttLeft, ttRight, $this = $("#" + obj.id), $tip = $("#main_page_institution_rgb_forward_as_popup"), triggerPos = $this.offset(), triggerH = $this.outerHeight(), triggerW = $this.outerWidth(), tipW = $tip.outerWidth(), tipH = $tip.outerHeight(), screenW = $(window).width(), scrollTop = $(document).scrollTop();

    if (triggerPos.top - tipH - scrollTop > 0) {
        ttTop = triggerPos.top - tipH - 10;
    } else {
        ttTop = triggerPos.top + triggerH + 10;
    }
    var overFlowRight = (triggerPos.left + tipW) - screenW;
    if (overFlowRight > 0) {
        ttLeft = triggerPos.left - overFlowRight - 10;
    } else {
        ttLeft = triggerPos.left + 30;
    }
    $tip.css({
        left : ttLeft,
        top : ttTop,
        position : 'absolute'
    }).fadeIn(200);
    //-----------------------------
}

//--
function main_page_rgb_reply_to_query_hide() {
    $("#main_page_institution_rgb_reply_popup").slideUp();
}

function main_page_rgb_forward_this_query_hide() {
    $("#main_page_institution_rgb_forward_as_popup_contingency").slideUp();
    $("#main_page_institution_rgb_forward_as_popup").slideUp();
}

//------------
$("#main_page_institution_sugg_details_conversations_container_mugabo_2017").mouseover(function() {
    $("#main_page_institution_sugg_details_conversations_container_mugabo_2017").css("cursor", "grab");
});

$(function() {
    $("#main_page_institution_sugg_details_conversations_container_mugabo_2017").draggable({
        containment : $(this).parent().parent()
    });
});
$(function() {
    $("#main_page_institution_rgb_reply_popup").draggable({
        containment : $(this).parent().parent()
    });
});
//------------------rgb forward as codes------
var theRgbForwardSpecs = "";

function main_page_institution_forward_as_tools(forward_specs, obj) {
    _("main_page_institution_rgb_reply_popup_data").innerHTML = "";
    _("ToInstitutions_search_results").innerHTML = "";
    _("ToIndividuals_search_results").innerHTML = "";
    //alert(forward_specs + "--" + global_queryProvider + "--" + global_queryId);
    //alert(obj.id);
    theRgbForwardSpecs = forward_specs;
    _("main_page_institution_rgb_forward_as_popup_contingency_msg").innerHTML = "----" + forward_specs + " to---";
    //-------------------------------------------------------------
    $("#main_page_institution_rgb_forward_as_popup_contingency").css("visibility", "visible");
    $("#main_page_institution_rgb_forward_as_popup_contingency").slideDown();
    //------------------------------------------
    global_queryProvider = queryProvider;
    global_queryId = main_page_institution_RGB_TheQueryID;
    var ttLeft, ttRight, $this = $("#" + obj.id), $tip = $("#main_page_institution_rgb_forward_as_popup_contingency"), triggerPos = $this.offset(), triggerH = $this.outerHeight(), triggerW = $this.outerWidth(), tipW = $tip.outerWidth(), tipH = $tip.outerHeight(), screenW = $(window).width(), scrollTop = $(document).scrollTop();

    if (triggerPos.top - tipH - scrollTop > 0) {
        ttTop = triggerPos.top - tipH - 10;
    } else {
        ttTop = triggerPos.top + triggerH + 10;
    }
    var overFlowRight = (triggerPos.left + tipW) - screenW;
    if (overFlowRight > 0) {
        ttLeft = triggerPos.left - overFlowRight - 10;
    } else {
        ttLeft = triggerPos.left + 30;
    }
    $tip.css({
        left : ttLeft,
        top : ttTop,
        position : 'absolute'
    }).fadeIn(200);
    //-------------------load all potential institution-

}

//--------------
function main_page_rgb_forward_this_query_hide_contingency() {
    $("#main_page_institution_rgb_forward_as_popup_contingency").slideUp();
}

//---------------forward to individual or to institution-------as ikigo cy'imiyoborere--
$(function() {
    $("#rgb_my_whole_tabs_2017").tabs();
});
$(function() {
    //$("#rgb_forward_query").accordion();
});
$(function() {
    $("#rgb_forward_query").accordion({
        collapsible : true,
        active : 'none',
        autoHeight : false,
        navigation : true,
        heightStyle : "content"
    });
});
//--------------
$(function() {
    $("#main_page_institution_rgb_forward_as_popup_contingency").draggable({
        containment : $(this).parent().parent()
    });
});
//------------------------rgb query-----------------
//--------------send rgb query chat discussion--
function main_page_institution_suggest_comment_2017_send_rgb_queries_2017() {
    if (_("main_page_institution_suggesttion_comment_data_rgb_queries_2017").value == "") {

    } else {
        //alert(main_page_institution_RGB_TheQueryID);
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/main_page_community_suggestion_institution_rgb_send_comment.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    _("main_page_institution_suggesttion_comment_data_rgb_queries_2017").value = "";
                    main_page_institution_visualize_rgb_query_commentators_reload();
                    showloadingPanel("erase");
                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("main_page_institution_suggest_comment_pool_view_strategy=" + v_look_var_1111 + "&main_page_institution_suggesttion_comment_data=" + _("main_page_institution_suggesttion_comment_data_rgb_queries_2017").value + "&the2017_suggestId_MugaboS_Cedric=" + main_page_institution_RGB_TheQueryID + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_suggest_comment_pool_strategy=" + _("main_page_institution_suggest_comment_pool_strategy").value + "&key=cyuma");

    }
}

var v_look_var_1111 = "visible_to_public";
//--------choose message type=
function main_page_institution_comment_commntTypeMugabo_2017_rgb_queries_2017(obj, vible) {
    switch(vible) {
        case "visible_public":
            v_look_var_1111 = "visible_to_public";
            //alert(v_look_var_1111);
            break;
        case "visible_private":
            v_look_var_1111 = "not_visible_to_public";
            //alert(v_look_var_1111);
            break;

    }

}

var v_load_var_2222 = "show_all_types_of_messages";
//------------Sort through the chats here rgb queries comments--
function main_page_institution_suggest_comment_mark_this_rgb_queries_2017(obj, whichTypeToLoad) {
    switch(whichTypeToLoad) {
        case "all":
            v_load_var_2222 = "show_all_types_of_messages";
            main_page_institution_visualize_rgb_query_commentators_reload();
            break;
        case "external":
            v_load_var_2222 = "show_only_externally_open_messages";
            main_page_institution_visualize_rgb_query_commentators_reload();
            break;
        case "internal":
            v_load_var_2222 = "show_only_internal_messages";
            main_page_institution_visualize_rgb_query_commentators_reload();
            break;

    }
}

//----------Reload the chats -----------
//-------------------------
function main_page_institution_visualize_rgb_query_commentators_reload() {
    _("main_page_institution_rgb_reply_popup_data").innerHTML = "<div style-'margin-auto;'><img src='images/loader_custom.gif' style='margin:auto;width:100px;height:100px;border-radius:20px;' /></div>";
    ;
    showloadingPanel("loading");
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_institution_rgb_query_chats_load.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            showloadingPanel("erase");
            //alert(ajax.responseText);
            //main_page_the_last_populated = comments_conatiner;
            _("main_page_institution_rgb_reply_popup_data").innerHTML = "" + ajax.responseText;
            _("main_page_institution_rgb_reply_popup_data").scrollTop = _("main_page_institution_rgb_reply_popup_data").scrollHeight;

        } else {
            // showloadingPanel("failed");

        }
    };
    ajax.send("the2017_suggestId_MugaboS_Cedric=" + main_page_institution_RGB_TheQueryID + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&main_page_institution_suggest_comment_pool_strategy=" + v_load_var_2222 + "&key=cyuma");

}

//-----------Delete the sent comment------by Me--------------------
function main_page_institution_delete_this_commnt_rgb_query(obj) {
    //--------------
    if (confirm("Are you sure, you want to delete this comment!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/NDS_DeleteThisCommunity_suggest_comment.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    main_page_institution_visualize_rgb_query_commentators_reload();
                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("TheCommentID=" + obj.name + "&key=cyuma");

    }

}

//--------------View all institutions from RGB perspective--------------
function main_page_institution_rgb_load_all_institutions_only() {
    //alert("Load all institutions only!--" + main_page_institution_RGB_TheQueryID);
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_institution_rgb_load_all_institutions_only.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            _("ToInstitutions_search_results").innerHTML = ajax.responseText;

        } else {
            // showloadingPanel("failed");
            //alert(ajax.responseText);

        }
    };
    ajax.send("main_page_institution_RGB_TheQueryID=" + main_page_institution_RGB_TheQueryID + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&theRgbForwardSpecs=" + theRgbForwardSpecs + "&key=cyuma");
}

function main_page_institution_rgb_load_all_institutions_with_officials() {
    var ajax = ajaxObj("POST", "nds_web_scripts/main_page_institution_rgb_load_all_institutions_with_their_officials.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            _("ToIndividuals_search_results").innerHTML = ajax.responseText;
            $(function() {
                $("#rgb_forward_query").accordion({
                    collapsible : true,
                    active : 'none',
                    autoHeight : false,
                    navigation : true,
                    heightStyle : "content"
                });
            });

        } else {
            // showloadingPanel("failed");
            //alert(ajax.responseText);

        }
    };
    ajax.send("main_page_institution_RGB_TheQueryID=" + main_page_institution_RGB_TheQueryID + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&theRgbForwardSpecs=" + theRgbForwardSpecs + "&key=cyuma");

}

//--------------
function main_page_institution_forwardOrDelegateThisQuery(obj, queryId) {
    //-------------------------------forward or consult------------------

    switch(obj.id) {
        case "delegation":
            if (confirm("Are you sure you wan to delegate someone?")) {
                //alert(obj.id + "---" + queryId);
                var ajax = ajaxObj("POST", "nds_web_scripts/main_page_rgb_query_forward_or_delegate_script_2017.php");
                ajax.onreadystatechange = function() {
                    if (ajaxReturn(ajax) == true) {
                        if (parseInt(ajax.responseText) == 1000) {
                            main_page_rgb_forward_this_query_hide();
                            showloadingPanel("loaded");
                        } else {
                            // showloadingPanel("failed");
                            alert(ajax.responseText);

                        }

                    } else {
                        // showloadingPanel("failed");
                        //alert(ajax.responseText);

                    }
                };
                ajax.send("queryId=" + queryId + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&forwardedTo=" + obj.title + "&tag=delegation" + "&key=cyuma");

            }

            break;
        case "consultation":
            if (confirm("Are you sure you wan to consult someone?")) {
                //alert(obj.id + "---" + queryId);
                var ajax = ajaxObj("POST", "nds_web_scripts/main_page_rgb_query_forward_or_delegate_script_2017.php");
                ajax.onreadystatechange = function() {
                    if (ajaxReturn(ajax) == true) {
                        if (parseInt(ajax.responseText) == 1000) {
                            main_page_rgb_forward_this_query_hide();
                            showloadingPanel("loaded");
                        } else {
                            // showloadingPanel("failed");
                            alert(ajax.responseText);

                        }
                    } else {
                        // showloadingPanel("failed");
                        //alert(ajax.responseText);

                    }
                };
                ajax.send("queryId=" + queryId + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&forwardedTo=" + obj.title + "&tag=consultation" + "&key=cyuma");
            }
            break;
    }
}

//--search through all institutions for delegation--------------------------
function main_page_institution_search_through_institutions_ForDelegation(obj) {
    if (obj.value.length >= 2) {
        var ajax = ajaxObj("POST", "nds_web_scripts/main_page_institution_rgb_load_all_institutions_only_search.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                _("ToInstitutions_search_results").innerHTML = ajax.responseText;

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("instiSearch=" + obj.value + "&main_page_institution_RGB_TheQueryID=" + main_page_institution_RGB_TheQueryID + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&theRgbForwardSpecs=" + theRgbForwardSpecs + "&key=cyuma");

    } else {
    }
}

//------search through all institutions' officials for delegation---------------
function main_page_institution_search_through_institutions_officials_ForDelegation(obj) {
    if (obj.value.length >= 2) {
        var ajax = ajaxObj("POST", "nds_web_scripts/main_page_institution_rgb_load_all_institutions_with_their_officials_search.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                _("ToIndividuals_search_results").innerHTML = ajax.responseText;
                $(function() {
                    $("#rgb_forward_query").accordion({
                        collapsible : true,
                        active : 'none',
                        autoHeight : false,
                        navigation : true,
                        heightStyle : "content"
                    });
                });

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("instiSearch=" + obj.value + "&main_page_institution_RGB_TheQueryID=" + main_page_institution_RGB_TheQueryID + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&theRgbForwardSpecs=" + theRgbForwardSpecs + "&key=cyuma");

    }
}

//-------------------main page rgb sorting mechanisms---------
//----------choose class A-
var main_page_insti_rgb_classA_sort = "descending";
var main_page_insti_rgb_classB_sort = "bycategory";
function main_page_institution_rgb_sort_classA_query_choose_2017(obj) {

    var radioObj = document.getElementsByName('sgstChoice_classA_rgb');
    for (var i = 0; i < radioObj.length; i++) {
        if (radioObj[i].checked) {
            main_page_insti_rgb_classA_sort = radioObj[i].title;
            //alert(radioObj[i].className);
        }
    }
}

//-------Choose class B
function main_page_institution_rgb_sort_classB_query_choose_2017(obj) {

    var radioObj = document.getElementsByName('sgstChoice_classB_rgb');
    for (var i = 0; i < radioObj.length; i++) {
        if (radioObj[i].checked) {
            main_page_insti_rgb_classB_sort = radioObj[i].title;
            //alert(radioObj[i].className);
        }
    }
}

function main_page_institution_rgb_sort_classA_query() {
    //alert(main_page_insti_rgb_classA_sort);
    switch(main_page_insti_rgb_classA_sort) {
        case "ascending":
            var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

                } else {
                    // showloadingPanel("failed");
                    //alert(ajax.responseText);

                }
            };
            ajax.send("order_tag=" + "ASC" + "&target=" + main_page_insti_rgb_classA_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

            break;
        case "descending":
            var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

                } else {
                    // showloadingPanel("failed");
                    //alert(ajax.responseText);

                }
            };
            ajax.send("order_tag=" + "DESC" + "&target=" + main_page_insti_rgb_classA_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

            break;
        case "byname":
            if (_("main_page_institution_rgb_sort_2017_by_name").value.length >= 2) {
                var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm.php");
                ajax.onreadystatechange = function() {
                    if (ajaxReturn(ajax) == true) {
                        _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

                    } else {
                        // showloadingPanel("failed");
                        //alert(ajax.responseText);

                    }
                };
                ajax.send("byname=" + _("main_page_institution_rgb_sort_2017_by_name").value + "&target=" + main_page_insti_rgb_classA_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

            }

            break;
        case "bykeyword":
            if (_("main_page_institution_rgb_sort_2017_by_keyword").value.length >= 2) {
                var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm.php");
                ajax.onreadystatechange = function() {
                    if (ajaxReturn(ajax) == true) {
                        _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

                    } else {
                        // showloadingPanel("failed");
                        //alert(ajax.responseText);

                    }
                };
                ajax.send("bykeyword=" + _("main_page_institution_rgb_sort_2017_by_keyword").value + "&target=" + main_page_insti_rgb_classA_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

            }
            break;
        case "bygender":
            var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

                } else {
                    // showloadingPanel("failed");
                    //alert(ajax.responseText);

                }
            };
            ajax.send("bygender=" + _("main_page_institution_rgb_sort_2017_by_gender").value + "&target=" + main_page_insti_rgb_classA_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

            break;
        case "bymaritalstatus":
            var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

                } else {
                    // showloadingPanel("failed");
                    //alert(ajax.responseText);

                }
            };
            ajax.send("bymaritalstatus=" + _("main_page_institution_rgb_sort_2017_by_marital_status").value + "&target=" + main_page_insti_rgb_classA_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

            break;
    }

}

//---------By Category
function main_page_institution_rgb_sort_classB_query() {
    if (main_page_insti_rgb_classB_sort == "bycategory") {
        var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("bycategory=" + _("main_page_institution_rgb_sort_2017_by_category").value + "&target=" + main_page_insti_rgb_classB_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

//-------------By Progress
function main_page_institution_rgb_sort_classC_query() {
    if (main_page_insti_rgb_classB_sort == "byprogress") {
        var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("byprogress=" + _("main_page_institution_rgb_sort_2017_by_progress").value + "&target=" + main_page_insti_rgb_classB_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

//----------Daterange Dilemma
function main_page_institution_rgb_sort_classD_query(btn) {
    if (main_page_insti_rgb_classB_sort == "bydaterange") {
        var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("btn=" + btn + "&date1=" + _("pickBirthDay_second_99").value + "&date2=" + _("pickBirthDay_second_98").value + "&target=" + main_page_insti_rgb_classB_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }
}

//-----------------load more queries if needed--------
function main_page_institution_rgb_load_more_queriesUp() {
    if (_("main_page_institution_rgb_firstId")) {
        var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm_moreUp.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (ajax.responseText != "") {
                    _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("main_page_institution_rgb_firstId=" + _("main_page_institution_rgb_firstId").value + "&order_tag=" + "DESC" + "&target=" + main_page_insti_rgb_classA_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

function main_page_institution_rgb_load_more_queriesDown() {
    if (_("main_page_institution_rgb_LastId")) {
        var ajax = ajaxObj("POST", "main_page_institution_rgb_queries_with_sorting_Algorithm_moreDown.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (ajax.responseText != "") {
                    _("main_page_institution_rgb_query_pool_data_2017").innerHTML = ajax.responseText;

                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("main_page_institution_rgb_LastId=" + _("main_page_institution_rgb_LastId").value + "&order_tag=" + "DESC" + "&target=" + main_page_insti_rgb_classA_sort + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

var main_page_notification_count_val = 0;
//---------------------chat notifications-------------
$(document).ready(function() {
    //------------notification timer-----------
    if (_("main_page_notification_counter")) {
        _("main_page_notification_counter").innerHTML = 0;
    }
    if (_("main_page_institution_notification_counter")) {
        _("main_page_institution_notification_counter").innerHTML = 0;
    }
    if (_("main_page_institution_rgb_notification_counter")) {
        _("main_page_institution_rgb_notification_counter").innerHTML = 0;
    }
    window.setInterval(function() {
        //-------check if we are on a main page-------
        if (_("common_user_settings_the_id")) {
            //--------go to server and count notifications---------------
            var ajax = ajaxObj("POST", "nds_web_scripts/main_page_count_notifications_2017_cyuma.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (ajax.responseText != "") {
                        if (_("main_page_notification_counter")) {
                            _("main_page_notification_counter").innerHTML = ajax.responseText;
                            main_page_notification_count_val = ajax.responseText;
                        }
                        //alert(ajax.responseText);

                    }

                } else {
                    // showloadingPanel("failed");
                    //alert(ajax.responseText);

                }
            };
            ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

        }
        //-------check if we are on a main page institution-------
        if (_("common_user_settings_the_id")) {
            //--------go to server and count notifications---------------
            var ajax = ajaxObj("POST", "nds_web_scripts/main_page_count_notifications_2017_cyuma.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (ajax.responseText != "") {
                        if (_("main_page_institution_notification_counter")) {
                            _("main_page_institution_notification_counter").innerHTML = ajax.responseText;
                            main_page_notification_count_val = ajax.responseText;
                        }
                        //alert(ajax.responseText);

                    }

                } else {
                    // showloadingPanel("failed");
                    //alert(ajax.responseText);

                }
            };
            ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

        }
        //-------check if we are on a main page institution rgb-------
        if (_("common_user_settings_the_id")) {
            //--------go to server and count notifications---------------
            var ajax = ajaxObj("POST", "nds_web_scripts/main_page_count_notifications_2017_cyuma.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (ajax.responseText != "") {
                        if (_("main_page_institution_rgb_notification_counter")) {
                            _("main_page_institution_rgb_notification_counter").innerHTML = ajax.responseText;
                            main_page_notification_count_val = ajax.responseText;
                        }
                        //alert(ajax.responseText);

                    }

                } else {
                    // showloadingPanel("failed");
                    //alert(ajax.responseText);

                }
            };
            ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

        }
        //---------main page----------------------
        //alert(isNotifyWinActive);
        if (!isNotifyWinActive) {

            if (parseInt(main_page_notification_count_val) == 0) {
                $("#notifications_panel").slideUp();
                $("#main_page_notification_counter_messenger").slideDown();
            } else {
                $("#notifications_panel").slideDown();
                $("#main_page_notification_counter_messenger").slideUp();
            }
            //---------main page institution----------------------
            if (parseInt(main_page_notification_count_val) == 0) {
                $("#notifications_panel").slideUp();
                $("#main_page_institution_notification_counter_messenger").slideDown();
            } else {
                $("#notifications_panel").slideDown();
                $("#main_page_institution_notification_counter_messenger").slideUp();
            }
            //---------main page institution rgb----------------------
            if (parseInt(main_page_notification_count_val) == 0) {
                $("#notifications_panel").slideUp();
                $("#main_page_institution_rgb_notification_counter_messenger").slideDown();
            } else {
                $("#notifications_panel").slideDown();
                $("#main_page_institution_rgb_notification_counter_messenger").slideUp();
            }

        }

        //---------------------Showing the data in the fields--------

    }, 1000);
    window.setInterval(function() {
        //---------------------Showing the data in the fields--------

        if (parseInt(main_page_notification_count_val) > 0) {
            if (_("common_user_settings_the_id")) {
                //--------go to server and count notifications---------------
                var ajax = ajaxObj("POST", "nds_web_scripts/main_page_count_notifications_2017_cyuma_actual_notifications_view.php");
                ajax.onreadystatechange = function() {
                    if (ajaxReturn(ajax) == true) {
                        if (ajax.responseText != "") {
                            if (_("notifications_panel_data_pool_2017") && _("notifications_panel_data_pool_2017").innerHTML != "") {
                                _("notifications_panel_data_pool_2017").innerHTML = ajax.responseText;

                                $(".uv_0000").click(function(event) {
                                    try {
                                        var p = $("#" + theCurrentCommunity_suggest_Object);
                                        $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
                                        $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
                                    } catch(error) {

                                    }
                                    //------------
                                    try {
                                        var p = $("#" + theCurrentRGB_suggest_Object);
                                        $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
                                        $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
                                    } catch(error) {

                                        //--
                                    }
                                    //-------------------------------------
                                    try {
                                        var p = $("#" + theCurrentMessageObject);
                                        $("#mainpageMessage").removeClass("mainPageNotificationHeader_taken").addClass("mainPage_Message");
                                        $("#" + theCurrentMessageObject).removeClass("message_record_taken").addClass("message_record");
                                    } catch(error) {

                                    }
                                    tMob = false;
                                    event.stopPropagation();
                                    if (MessagesisNotifyWinActive) {
                                        _("messages_panel_mainpop").innerHTMl = "rtttrtt";

                                        MessagesisNotifyWinActive = false;
                                        $("#messages_panel_mainpop").animate({
                                            width : 0
                                        });
                                        $("#messages_panel_mainpop").css("border-style", "none");
                                    }
                                    $("#suggestion_panel_mainpop_community").animate({
                                        width : 0
                                    });
                                    $("#suggestion_panel_mainpop_community").css("border-style", "none");
                                    //--
                                    $("#suggestion_panel_mainpop").animate({
                                        width : 0
                                    });
                                    $("#suggestion_panel_mainpop").css("border-style", "none");
                                });
                            }
                            //alert(ajax.responseText);

                        }

                    } else {
                        // showloadingPanel("failed");
                        //alert(ajax.responseText);

                    }
                };
                ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");
            }
        }
    }, 2000);

});
//--------------------------
function main_page_notif_brief_me_now_cyuma_2017(notifId) {
    //---------------main_page_brief_me_about_this_notifications_2017_cyuma.php
    //alert("---" + notifId);
    //----------------------------------------------------------
    _("notifications_panel_mainpop_notify").innerHTML = "<img src='images/loader_custom.gif' style='margin:auto;width:100px;height:100px;border-radius:20px;' />";

    var ajax = ajaxObj("POST", "main_page_brief_me_about_this_notifications_2017_cyuma.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (ajax.responseText != "") {
                if (_("notifications_panel_mainpop_notify")) {
                    _("notifications_panel_mainpop_notify").innerHTML = ajax.responseText;
                    //main_page_notification_count_val = ajax.responseText;
                }
                //alert(ajax.responseText);

            }

        } else {
            // showloadingPanel("failed");
            //alert(ajax.responseText);

        }
    };
    ajax.send("notifId=" + notifId + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");
}

//-----loop for message display------------------------------------------------------------
var main_page_messages_count_val = 0;
$(document).ready(function() {
    //-------------------------
    if (_("mainpageMessage_message_count")) {
        _("mainpageMessage_message_count").innerHTML = 0;
    }
    //--------------
    window.setInterval(function() {
        if (_("common_user_settings_the_id")) {
            if (parseInt(main_page_messages_count_val) == 0) {
                $("#notifications_panel_for_message").slideUp();
                $("#main_page_noification_tag_2017").slideDown();
            } else {
                $("#notifications_panel_for_message").slideDown();
                $("#main_page_noification_tag_2017").slideUp();
            }

        }
        //----------Count all unread messages-------------------
        if (_("common_user_settings_the_id")) {
            //--------go to server and count all new messages---------------
            //----------
            var ajax = ajaxObj("POST", "nds_web_scripts/main_page_count_all_new_messages_2017.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (ajax.responseText != "") {
                        if (_("mainpageMessage_message_count")) {
                            _("mainpageMessage_message_count").innerHTML = ajax.responseText;
                            main_page_messages_count_val = ajax.responseText;
                            //alert(ajax.responseText);
                        }
                        //alert(ajax.responseText);

                    }

                } else {
                    // showloadingPanel("failed");
                    //alert(ajax.responseText);

                }
            };
            ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

        }

    }, 1000);
    //---------------load the messages----------------
    window.setInterval(function() {
        //---------------------Showing the data in the fields--------

        if (_("common_user_settings_the_id")) {
            //--------go to server and count notifications---------------
            var ajax = ajaxObj("POST", "nds_web_scripts/main_page_count_all_new_messages_2017_view_now.php");
            ajax.onreadystatechange = function() {
                if (ajaxReturn(ajax) == true) {
                    if (ajax.responseText != "") {
                        if (_("notifications_panel_for_message") && _("notifications_panel_for_message").innerHTML != "") {
                            _("notifications_panel_for_message").innerHTML = ajax.responseText;
                            //-------------------
                            $(".message_record").click(function(event) {
                                try {
                                    var p = $("#" + theCurrentCommunity_suggest_Object);
                                    $("#community_suggestion_box_").removeClass("community_suggestion_box_taken").addClass("community_suggestion_box");
                                    $("#" + theCurrentCommunity_suggest_Object).removeClass("community_suggest_taken").addClass("community_suggest");
                                } catch(error) {

                                }
                                //-------
                                try {
                                    var p = $("#" + theCurrentRGB_suggest_Object);
                                    $("#rgb_suggestion_").removeClass("rgb_suggestion_panel_taken").addClass("rgb_suggestion_panel");
                                    $("#" + theCurrentRGB_suggest_Object).removeClass("rgb_taken").addClass("rgb");
                                } catch(error) {

                                    //--
                                }
                                //------------
                                try {
                                    var p = $("#" + theCurrentNotifiObject);
                                    $("#mainpage_notification").removeClass("mainPageNotificationHeader_taken").addClass("mainPageNotificationHeader");
                                    $("#" + theCurrentNotifiObject + theCurrentNotifiObject).removeClass("notify_record_taken").addClass("notify_record");

                                } catch(error) {

                                }
                                //-------------
                                $("#suggestion_panel_mainpop_community").animate({
                                    width : 0
                                });
                                $("#suggestion_panel_mainpop_community").css("border-style", "none");
                                $("#suggestion_panel_mainpop").animate({
                                    width : 0
                                });
                                $("#suggestion_panel_mainpop").css("border-style", "none");
                                event.stopPropagation();

                                isNotifyWinActive = false;
                                $("#notifications_panel_mainpop").animate({
                                    width : 0
                                });
                                $("#notifications_panel_mainpop").css("border-style", "none");
                                //---------
                                $("#message_panel_finalize").animate({
                                    width : 0
                                });
                                $("#message_panel_finalize").css("border-style", "none");

                                tMob = true;
                                //--

                            });

                        }
                        //alert(ajax.responseText);

                    }

                } else {
                    // showloadingPanel("failed");
                    //alert(ajax.responseText);

                }
            };
            ajax.send("common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");
        }

    }, 2000);

});
//---------------------------
function main_page_show_my_messages(theQueryId, orient) {
    //------------------main_page_show_me_my_conversations_2017_cyuma.php
    _("messages_panel_mainpop").innerHTML = "<img src='images/loader_custom.gif' style='margin:auto;width:100px;height:100px;border-radius:20px;' />";

    var ajax = ajaxObj("POST", "main_page_show_me_my_conversations_2017_cyuma.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            if (ajax.responseText != "") {
                if (_("messages_panel_mainpop")) {
                    _("messages_panel_mainpop").innerHTML = ajax.responseText;
                    if (_("main_page_new_message_hah")) {
                        $("#main_page_new_message_hah").fadeOut();
                    }

                    //alert(ajax.responseText);
                }
                //alert(ajax.responseText);

            }

        } else {
            // showloadingPanel("failed");
            //alert(ajax.responseText);

        }
    };
    ajax.send("orient=" + orient + "&theQueryId=" + theQueryId + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

}

//--------------
$(document).ready(function() {
    if (_("main_page_new_message_hah")) {
        $("#main_page_new_message_hah").fadeOut();
    }

});
function toggle_this_new_message_thing() {
    $("#main_page_new_message_hah").fadeToggle();
}

//---------
$(document).ready(function() {

});
//-----------
//--------------send and reload chats on messages---
function main_page_send_MessageToRecipient(obj) {
    //------_("okay_good_orientation").value

    if (_("main_page_new_message_hah").value.length >= 2) {
        var ajax = ajaxObj("POST", "nds_web_scripts/main_page_send_comment_to_message_2017.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    _("main_page_new_message_hah").value = "";
                    main_page_messages_reload_for_this_pop();

                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("msgData=" + _("main_page_new_message_hah").value + "&queryTag=" + _("okay_good_orientation").value + "&queryId=" + _("the_popped_up_query_suggst_id").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

    }

}

//----------------
function main_page_messages_reload_for_this_pop() {
    var ajax = ajaxObj("POST", "main_page_show_me_my_conversations_reload_after_send.php");
    ajax.onreadystatechange = function() {
        if (ajaxReturn(ajax) == true) {
            _("main_scroll_msgs_page_cyuma_2017").innerHTML = "" + ajax.responseText;

        } else {
            // showloadingPanel("failed");
            //alert(ajax.responseText);

        }
    };
    ajax.send("orient=" + _("okay_good_orientation").value + "&theQueryId=" + _("the_popped_up_query_suggst_id").value + "&common_user_settings_the_id=" + _("common_user_settings_the_id").value + "&key=cyuma");

}

//-----------------main
function main_page_toggleAllMessages() {
    $("#main_scroll_msgs_page_cyuma_2017").fadeToggle();

}

//--------------------delete the comment-------------
function main_page_institution_delete_this_commnt_rgb_query_Messages(obj) {
    //--------------
    if (confirm("Are you sure, you want to delete this comment!")) {
        showloadingPanel("loading");
        var ajax = ajaxObj("POST", "nds_web_scripts/NDS_DeleteThisCommunity_suggest_comment.php");
        ajax.onreadystatechange = function() {
            if (ajaxReturn(ajax) == true) {
                if (parseInt(ajax.responseText) == 1000) {
                    main_page_messages_reload_for_this_pop();
                }

            } else {
                // showloadingPanel("failed");
                //alert(ajax.responseText);

            }
        };
        ajax.send("TheCommentID=" + obj.name + "&key=cyuma");

    }

}

//------------------
$(document).ready(function() {
    $("#messages_panel_mainpop").addClass("scroll");
    //---------
    // $("#notifications_panel_for_message").html("");
    //-----------------
    //$("#notifications_panel_data_pool_2017").html("");
});
//--------Clearing home fields----------
function clearTheIndividualFields() {
    _("home_individual_fname").value = "";
    _("home_individual_lname").value = "";
    _("pickBirthDay").value = "";
    _("home_individual_profession").value = "";
    _("home_individual_username").value = "";
    _("home_individual_province").value = "";
    _("home_individual_district").value = "";
    _("home_individual_sector").value = "";
    _("home_individual_email_add").value = "";
    _("home_individual_password").value = "";
    _("home_individual_password_retype").value = "";
    _("home_individual_phone").value = "";

}

//-------------Institution--
function clearTheInstitutionFields() {
    _("home_institution_institution").value = "";
    _("home_institution_website").value = "";
    _("home_institution_info_email").value = "";
    _("home_institution_province").value = "";
    _("home_institution_district").value = "";
    _("home_institution_sector").value = "";
    _("home_institution_motto").value = "";
    _("home_institution_username").value = "";
    _("home_institution_password").value = "";
    _("home_institution_password_retype").value = "";

}

//-------------official
function clearTheOfficialFields() {
    _("home_official_fname").value = "";
    _("home_official_lname").value = "";
    _("home_official_username").value = "";
    _("home_official_department").value = "";
    _("home_official_position").value = "";
    _("home_official_province").value = "";
    _("home_official_district").value = "";
    _("home_official_sector").value = "";
    _("home_official_work_nber").value = "";
    _("home_official_company_address_mail").value = "";
    _("home_official_password").value = "";
    _("home_official_password_retype").value = "";

}
