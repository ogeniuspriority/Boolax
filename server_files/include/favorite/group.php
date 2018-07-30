
<div class="main-list">
    <div style="display:flex; flex-direction: column; justify-content: center; align-items: center; padding-bottom: 12px; padding-top: 12px;  background-color: white;">

        <a class="new-favorite-btn" id="new-group-btn" > New group</a>
        <script>
            $(document).ready(function () {
                $('#new-group-btn').click(function () {
                    
                    $("#new-group").css({
                        "right": "0"
                    });
                });
            });
        </script>
    </div>
    <div class="list-divider" style=" height: 1px;background: #cccccc;"></div>


    <div id="group-sideBar-list">

    </div>
</div>
<div class="details" id="details">

    <p style="text-align: center; color: #cccccc; top: 20px; font-size: 16px; font-weight: bold"> You have not selected any group <br> Click on any group on the list on the left</p>


</div>


<script>
    var members = [];
    var username = "<?php echo($_SESSION['user']); ?>";
    var userId = "<?php echo($_SESSION['id']); ?>";
</script>


<div class="new-group" id="new-group">
    <ul class="new-members-modal" style="margin: 0; padding: 0">

        <li class="new-members-modal-body" style="margin: 0; padding: 0">
        </li>
        <li class="new-btn-group container-fluid ">
            <button class="btn btn-default col-md-6">Cancel</button><button class="btn btn-primary col-md-6" id="newMembersbtn">Add</button>
        </li>
        <script>
            $("#newMembersbtn").click(function () {
                $.each($("input[name='new-member-list-item-input']:checked"), function () {

                    members.push($(this).val());
                });
                $('.new-members-modal').css('display', 'none');

                $.ajax({
                    url: "loadMember_2.php", //the script to call to get data 

                    data: 'members=' + members, //you can insert url argumnets here to pass to api.php
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
                        $('.members-list').html(removeNanShit(theNanString));
                    },
                    error: function () {
                        $('.members-list').html("<p>could not load data!</p>");
                    }

                });
                $('.members-list').html("<p>could not load data!</p>");
            });
        </script>
    </ul>
    <form action="#" method="post" name="newgroupform"  id="newgroupform" enctype="multipart/form-data">
        <div>
            <div class="new-img-holder">
                <input type="file" id="upload_file" name="upload_file" onchange="preview_image(event); return false;" name="new-img-thumbnail">
                <img class="new-img-thumbnail" id="output_image"/>
            </div>
            <script>
                function preview_image(event)
                {
                    var reader = new FileReader();
                    reader.onload = function ()
                    {
                        var output = document.getElementById('output_image');
                        output.src = reader.result;
                    };
                    reader.readAsDataURL(event.target.files[0]);
                    return false;
                }
            </script>
            <div class="new-info">
                <div class = "form-group col-sm-9">
                    <label for = "group-name" class = "control-label">Group name</label>
                    <input id="group-name" name="gname"  class="form-control" type="text" maxlength="20" required>
                </div>
                <div class = "form-group col-sm-3">
                    <label for = "group-privacy" class = "control-label" >Privacy:</label>
                    <select class="form-control" id="group-privacy" name="gprivacy" required>
                        <option selected>select..</option>
                        <option value="public">Public</option>
                        <option value="private">Private</option>
                    </select>
                </div>
                <div class = "form-group col-sm-9">
                    <label for = "group-tags" class = "control-label">Tags:</label>
                    <input id="group-tags" name="gtags" class="form-control" type="text"  required>
                </div>
            </div>
        </div>

        <div class="new-tab">
            <div id="members-tab">
                <a href="#members" id="members-tab" role="tab" data-toggle="tab" aria-controls="members" aria-expanded="true">
                    Members 
                    <button onclick="Viewmembers();" style="padding: 0px; margin: 0px; height:28px; width: 28px;">
                        <img src="images/icons/ic_add_black_18dp.png" alt="add"/>
                    </button> 
                </a>
            </div>
        </div>
        <div class="members-list">

        </div>





        <div class="new-btn-group">

            <button class="btn btn-primary col-md-9" type="submit" name="new-group-btn" id="new-group-btn">CREATE</button>

        </div>

    </form>
    <script>
        $("#newgroupform").on('submit', (function (event) {
            event.preventDefault();

            members.length;
            var formData = new FormData($('#newgroupform')[0]);
            formData.append('gmember_count', members.length);
            formData.append('members', members);
            $.ajax({
                url: "createGroup.php",
                data: formData,
                cache: false,
                contentType: false,
                processData: false,
                type: 'post',
                success: function (data) {
                    if (data === "1") {
                        alert("group created");
                        loadGroup();
                        $("#new-group").css({
                            "right": "-75%"
                        });
                    } else
                        alert("try again later");


                },
                error: function () {
                    alert("big error in group creation");
                }
            });

        }));
        
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


        
    </script>
</div>





