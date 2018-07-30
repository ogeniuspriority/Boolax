<div class="sidenav" >
    <ul class="nav">
        <li class="one">
            <a href="#" id="boo-link" onclick="booLinkFx(); return false;"><img src="images/icons/ic_search_black_24dp.png"/></a>

            <span class="sr-only">(current)</span>
        </li>

        <li class="two">
            <a href="#" id="group-link" onclick="groupLinkFx(); return false;"><img src="images/icons/ic_people_black_24dp.png"/><span class="badge"></span></a>
        </li>
        <li class="three">
            <a href="#" id="event-link" onclick="eventLinkFx(); return false;"><img src="images/icons/ic_event_black_24dp.png"/></a>
        </li>
    </ul>

</div>
<div id="favorite-wrapper">



</div>
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<script>
   $(document).ready(function () {
   $('#new-group-btn').click(function(){
    alert("gbdhghj");
    $('#new-group').animate({left: '-75px;'});
});});
    $('#event-link').click(function () {
        $('#favorite-wrapper').load('include/favorite/event.php');
        return false;
    });
   
     function groupLinkFx() {
            $('#favorite-wrapper').load('include/favorite/group.php');
            loadGroup();

            return false;
        }
        function loadGroup() {
            $.ajax({
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


        function viewGroupDetails(id) {
            var gname;
            $.ajax({
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
                        gname = "" + id;
                        if (obj.group_admin === <?php $_SESSION['user'] ?>) {
                            alert("js fx from main page");
                            theNanString = "<h3 class='page-header'>" + obj.group_name + "</h3><div class='row'><div class='container-fluid main-info'><div class='col-md-3 main-thumbnail' style=''>"
                                    + "<img src='images/groups_files/" + obj.group_name + id + "/_group_avatar.jpg' id='boo-det-profile' style='width:auto; height: 150px;' alt='profile picture'/></div><div class='col-md-8'>"
                                    + "<ul class='page-info'><li><span>Created by you</span><br><span>tags: " + obj.group_tags + "</span>"
                                    + "</li><li class='row '><div class='container-fluid'><button class='btn btn-primary col-md-3' onclick='joinGroup(" + gname + ");'>JOIN</button></div></li></ul>"
                                    + "</div></div><div class=''><ul id='myTabs' class='nav nav-tabs' role='tablist'><li role='presentation' class='active'>"
                                    + "      <a href='#members' id='members-tab' role='tab' data-toggle='tab' aria-controls='members' aria-expanded='true'>Members</a></li></ul>"
                                    + "<div id='myTabContent' class='tab-content'><div role='tabpanel' class='tab-pane fade active in' id='members' aria-labelledby='members-tab'> "
                                    + "      <p class='text-info'> You are not allowed to view this list<br> Join first!</p></div></div></div></div>";

                        } else {
                            theNanString = "<h3 class='page-header'>" + obj.group_name + "</h3><div class='row'><div class='container-fluid main-info'><div class='col-md-3 main-thumbnail' style=''>"
                                    + "<img src='images/groups_files/" + obj.group_name + id + "/_group_avatar.jpg' id='boo-det-profile' style='width:auto; height: 150px;' alt='profile picture'/></div><div class='col-md-8'>"
                                    + "<ul class='page-info'><li><span>Created by " + obj.group_admin + "</span><br><span>tags: " + obj.group_tags + "</span>"
                                    + "</li><li class='row '><div class='container-fluid'><button class='btn btn-primary col-md-3' onclick='joinGroup(" + gname + ");'>JOIN</button></div></li></ul>"
                                    + "</div></div><div class=''><ul id='myTabs' class='nav nav-tabs' role='tablist'><li role='presentation' class='active'>"
                                    + "      <a href='#members' id='members-tab' role='tab' data-toggle='tab' aria-controls='members' aria-expanded='true'>Members</a></li></ul>"
                                    + "<div id='myTabContent' class='tab-content'><div role='tabpanel' class='tab-pane fade active in' id='members' aria-labelledby='members-tab'> "
                                    + "      <p class='text-info'> You are not allowed to view this list<br> Join first!</p></div></div></div></div>";


                        }
                    });
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
    </script>
</script>