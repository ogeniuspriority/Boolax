
<div class="main-list">
    <div style="display:flex; flex-direction: column; justify-content: center; align-items: center; padding-bottom: 12px; padding-top: 12px; background-color: white ">

        <a class="new-favorite-btn" id="new-event-btn" >New Event</a>
        <script>
            $(document).ready(function () {
                $('#new-event-btn').click(function () {
                    alert("gbdhghj");

                    $("#new-event").css({
                        "right": "0"
                    });
                });
            });</script>
    </div>

    <div class="list-divider" style="height: 1px;background: #cccccc;"></div>



    <div id="event-sideBar-list">

    </div>
</div>
<div class="details" id="details">
 <p style="text-align: center; color: #cccccc; top: 20px; font-size: 16px; font-weight: bold"> You have not selected any event <br> Click on any event on the list on the left</p>


</div>





<div class="new-group" id="new-event">
    <ul class="new-members-modal" style="margin: 0; padding: 0">

        <li class="new-members-modal-body" style="margin: 0; padding: 0">
        </li>
        <li class="new-btn-group container-fluid ">
            <button class="btn btn-default col-md-6" id="newMembersCancelbtn">Cancel</button><button class="btn btn-primary col-md-6" id="newMembersbtn">Add</button>
        </li>
        <script>$("#newMembersbtn").click(function () {
                alert("ff");
                var members = [];

                $.each($("input[name='new-member-list-item-input']:checked"), function () {

                    members.push($(this).val());

                });
                $('.new-members-modal').css('display', 'none');
                alert("My favourite sports are: " + members.join(", "));
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
            $("#newMembersCancelbtn").click(function () {

            });
        </script>
    </ul>
    <form action="#" name="new-event-form" id="neweventform">
        <div>

            <div class="new-img-holder">
                <input type="file" class="new-img-thumbnail" id="file" name="new-img-thumbnail">
            </div>
            <script>

            </script>
            <div class="new-info">
                <div class = "form-group col-sm-11">
                    <label for = "event-name" class = "control-label">Event name:</label>
                    <input id="event-name" class="form-control" type="text" maxlength="20" required="">
                </div>

                <div class = "form-group col-sm-6">
                    <label for = "event-place" class = "control-label">Place:</label>
                    <input id="event-place" class="form-control" type="text"  required="">
                </div>
                <div class ="form-group col-sm-6">
                    <label for ="date" class ="control-label">Date:</label>
                    <input type="date" placeholder="Date of event" class="form-control" required>
                </div>
                <div class = "form-group col-sm-12">
                    <label for = "event-description" class = "control-label">Description</label><span><small id="word-count">100</small></span>
                    <textarea name="comment" id="event-description" form="neweventform" class="form-control" maxlength="100">Enter text here...</textarea>
                </div>
                
            </div>
        </div>
        <div class="new-tab">
            <div id="members-tab">
                <a href="#members" id="members-tab" role="tab" data-toggle="tab" aria-controls="members" aria-expanded="true">
                    Tag friends 
                    <button onclick="Viewmembers();" style="padding: 0px; margin: 0px; height:28px; width: 28px;">
                        <img src="images/icons/ic_add_black_18dp.png" alt="add"/>
                    </button> 
                </a>
            </div>
        </div>
        <div class="members-list">

        </div>






        <div class="new-btn-group">

            <button class="btn btn-primary col-md-9" type="submit" name="new-event-btn">CREATE</button>

        </div>
    </form>
    <script>
  
                    var maxLength = 100;
                    $('#event-description').keyup(function() {
                        
                    var length = $(this).val().length;
                    var length = maxLength - length;
                    $('#word-count').text(length);
                });
                
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

    </script>

</div>





