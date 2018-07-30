<div class="main-list" id="chat-main-list">
    <ul class="new-chat-modal" style="margin: 0; padding: 0">
        <li class="new-chat-modal-header" style="margin: 0; padding: 0">
            <div  style="display:flex; height: 56px; width: 100%; font-size: 14px;line-height: 1.42857143;color: #555;background-image: none;
                  flex-direction: row; justify-content: flex-start; align-items: center; padding: 8px 0px;  background-color: #555;">

                <div class="addmessagerecip">
                    <img src="images/icons/ic_arrow_back_black_24dp.png" id="cancelMessageRecip" onclick="cancelmessagerecipient();"  alt="123">
                </div>
            </div>
        </li>
        <li class="new-chat-modal-body" style="margin: 0; padding: 0">
        </li>

    </ul>
    <div  style="display:flex; height: 56px; width: 100%; font-size: 14px;line-height: 1.42857143;color: #555;background-image: none;
          flex-direction: row; justify-content: flex-start; align-items: center; padding: 8px 0px;  background-color: white;">
        <div style="width: 100%">
            <input id="searchText" type="text" style=" height: 36px;
                   width:100%;
                   padding: 6px 12px;
                   font-size: 14px;
                   line-height: 1.42857143;
                   border: none;
                   " name="searchText" placeholder="Search...">
        </div>
        <div class="addmessagerecip">
            <img src="images/icons/ic_add_black_24dp.png" id="addMessageRecip" onclick="addmessagerecipient();"  alt="123">
        </div>
    </div>
    <div class="list-divider" style=" height: 1px;background: #cccccc;"></div>

    <div class="sideBar-list" id="chat-sideBar-list">
        <ul class="chat-list-item">
            <li class="chat-list-item-avatar">
                <img src="images/users_files/1/avatar-icon.jpg" alt="pp" class="avatar-icon">
            </li>
            <li class="chat-list-item-metas">
                <span class="name-meta">SomeGrumpyCor</span><br>
                <i><span class="message-meta">mesaf gjfh fdgb</span></i>
            </li>
            <li class="chat-list-item-notif"><span class="badge">35</span>
            </li>
        </ul>

        <div class="chat-divider"><h5><b>Groups</b></h5></div>
        <ul class="chat-list-item">
            <li class="chat-list-item-avatar">
                <img src="images/users_files/1/avatar-icon.jpg" alt="pp" class="avatar-icon">
            </li>
            <li class="chat-list-item-metas">
                <span class="name-meta">SomeGrumpyCoreNotAdd</span><br>
                <i><span class="message-meta">mesaf gjfh fdgb</span></i>
            </li>
            <li class="chat-list-item-location"><span class="badge">35</span>
            </li>
        </ul>

    </div>
</div>
<!-- Conversation Start -->
<div id="chat-details">

    <div class="chat-header">
        <div>
            <div class="chat-header-avatar">
                <img src="images/users_files/1/avatar-icon.jpg" alt="pp" class="avatar-icon">
            </div>
            <div class="chat-header-metas">
                <span class="name-meta">SomeGrumpyCor</span><br>
                <i><span class="chat-status">online</span></i>
            </div>
        </div>

        <div class="chat-header-options">
            <div class="chat-header-options-more">
                <img src="images/icons/ic_reply_black_24dp.png"/>
                <img src="images/icons/ic_delete_black_24dp.png"/>
            </div>
            <img class="options-more" onclick="chatdropdown()" src="images/icons/ic_more_vert_black_24dp.png"/>
        </div>
        <ul class="chat-header-options-dropdown">
            <li>view profile</li>
            <li>mute</li>
            <li>add to favorite</li>
            <li>add to group</li>
            <li>delete conversation</li>
            <li>block person</li>

        </ul>
    </div>

    <div class="chat-body">

        <div class="chat-bubble right"onclick="selectmessage();">
            <input type="checkbox" class="form-control bubble-select"/>
            <img class="bubble-img" src="images/avatar/rutacris2/avatar-icon.jpg">


            <div class="bubble-content">
                <p> shbvhrbvbvu vtb shbvhrbvbvu vtb shbvhrbvbvu vtb shbvhrbvbvu: vtb shbvhrbvbvu vtb ~gfshdgfjhdgsf hdhd hdd dh hd dh dh </p>
                <div class="bubble-extra"><span><small>12:00am</small></span><img src="images/icons/ic_done_all_white_18dp.png"></div>

            </div>

        </div>
        <div class="chat-bubble right"onclick="selectmessage();">
            <input type="checkbox" class="form-control bubble-select"/>
            <img class="bubble-img" src="images/avatar/rutacris2/avatar-icon.jpg">


            <div class="bubble-content"onclick="selectmessage();">
                <p> shbvhrbvbvu vtb shbvhrbvbvu vtb shbvhrbvbvu vtb shbvhrbvbvu: vtb shbvhrbvbvu vtb ~gfshdgfjhdgsf hdhd hdd dh hd dh dh </p>
                <div class="bubble-extra"><span><small>12:00am</small></span><img src="images/icons/ic_done_all_white_18dp.png"></div>

            </div>

        </div>
        <div class="chat-bubble left" onclick="selectmessage();">
            <input type="checkbox" class="form-control bubble-select"/>
            <img class="bubble-img" src="images/avatar/rutacris2/avatar-icon.jpg">


            <div class="bubble-content">
                <p> shbvhrbvbvu vtb shbvhrbvbvu vtb shbvhrbvbvu vtb shbvhrbvbvu: vtb shbvhrbvbvu vtb ~gfshdgfjhdgsf hdhd hdd dh hd dh dh </p>
                <div class="bubble-extra"><span><small>12:00am</small></span><img src="images/icons/ic_done_all_white_18dp.png"></div>

            </div>

        </div>
    </div>

    <div class="chat-area">


        <ul id="addmediaDialog">

            <li>
                <input type="file" name="chat-emoji">
            </li>
            <li>
                <input type="file" name="chat-video">
            </li>
            <li>
                <input type="file" name="chat-audio">
            </li>
            <li>
                <input type="file" name="chat-record">
            </li>
            <li>
                <input type="file" name="chat-image">
            </li>

        </ul>

        <div id="addmedia"> 
            <img src="images/icons/ic_add_black_24dp.png" id="addMedia" onclick="addmedia();"  alt="123">
        </div>
        <div id="addemoji"> 
            <img src="images/icons/emoji.png"  alt="123">
        </div>
        <input type="textarea" placeholder="type message...">
        <div id="sendmessage"> 
            <img src="images/icons/ic_send_black_24dp.png" alt="send">  
        </div>      


    </div>

</div>
