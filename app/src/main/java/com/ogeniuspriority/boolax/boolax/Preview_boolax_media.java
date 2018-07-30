package com.ogeniuspriority.boolax.boolax;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;
import com.bumptech.glide.Glide;
import com.ogeniuspriority.boolax.boolax.m_DataObject.My_Community_Upload_audio;
import com.ogeniuspriority.boolax.boolax.m_DataObject.My_Community_Upload_image;
import com.ogeniuspriority.boolax.boolax.m_DataObject.My_Community_Upload_video;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import nl.changer.audiowife.AudioWife;

public class Preview_boolax_media extends AppCompatActivity implements EasyVideoCallback {
    private static String TEST_URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

    private EasyVideoPlayer player;
    ListView thisP_lit;
    String theLocalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_boolax_media);
        getSupportActionBar().hide();
        //--------------------
        AudioWife.getInstance().release();
        thisP_lit = boolax_booers_chats_chatroom.boolax_boos_list;
        LinearLayout thePreviewedPic = (LinearLayout) findViewById(R.id.thePreviewedPic);
        LinearLayout thePreviewedPAudio = (LinearLayout) findViewById(R.id.thePreviewedPAudio);
        LinearLayout thePreviewedVideo = (LinearLayout) findViewById(R.id.thePreviewedVideo);
        //-----------
        thePreviewedPic.setVisibility(View.GONE);
        thePreviewedPAudio.setVisibility(View.GONE);
        thePreviewedVideo.setVisibility(View.GONE);
        //-----get the passed video url--
        Intent intent = getIntent();

        final String fName = intent.getStringExtra("theVideoUrl");
        final String mediaType = intent.getStringExtra("mediaType");

        final String remoteIdOfReceipient = intent.getStringExtra("remoteIdOfReceipient");
        final String myRemoteId = intent.getStringExtra("myRemoteId");

        if (mediaType.equalsIgnoreCase("video")) {
            thePreviewedVideo.setVisibility(View.VISIBLE);
            TEST_URL = Environment.getExternalStorageDirectory() + File.separator
                    + "/boolax_videos/" + fName;

            // Grabs a reference to the player view
            player = (EasyVideoPlayer) findViewById(R.id.player);

            // Sets the callback to this Activity, since it inherits EasyVideoCallback
            player.setCallback(this);

            // Sets the source to the HTTP URL held in the TEST_URL variable.
            // To play files, you can use Uri.fromFile(new File("..."))
            player.setSource(Uri.parse(TEST_URL));

            // From here, the player view will show a progress indicator until the player is prepared.
            // Once it's prepared, the progress indicator goes away and the controls become enabled for the user to begin playback.
            Button back_video = (Button) findViewById(R.id.back_video);
            Button Send_video = (Button) findViewById(R.id.Send_video);
            final EditText thePreviewedVideo_actual_video_caption = (EditText) findViewById(R.id.thePreviewedVideo_actual_video_caption);
            //------------------
            back_video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            //-------------
            Send_video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //------------theSqliteSave-----------
                    NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(Preview_boolax_media.this);
                    thDb.openToWrite();
                    try {
                        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
                        String date = df.format(Calendar.getInstance().getTime());
                        if (thDb.save_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_locally(fName,
                                "video", "0", "", remoteIdOfReceipient, myRemoteId, "", "",
                                date, "")) {

                            //-------Retreive this local id---------------
                            Cursor allNotSentTxtMsgs = thDb.GET_CHAT_MESSAGES_ALL_NOT_SENT(remoteIdOfReceipient);
                            if (allNotSentTxtMsgs.moveToFirst()) {
                                for (int i = 0; i < allNotSentTxtMsgs.getCount(); i++) {
                                    theLocalId = allNotSentTxtMsgs.getString(0);


                                }

                            }

                            new My_Community_Upload_video(boolax_booers_chats_chatroom.theCtx,Preview_boolax_media.this, TEST_URL,
                                    fName,
                                    remoteIdOfReceipient, myRemoteId, thePreviewedVideo_actual_video_caption.getText().toString(), "video", thisP_lit, theLocalId).execute();


                        }
                    } catch (Exception ss) {

                    }


                }
            });
        } else if (mediaType.equalsIgnoreCase("audio")) {
            TEST_URL = Environment.getExternalStorageDirectory() + File.separator
                    + "/boolax_audios/" + fName;
            thePreviewedPAudio.setVisibility(View.VISIBLE);
            String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/boolax_audios/" + fName;
            // AudioWife takes care of click handler for play/pause button
            ImageView boolax_boo_message_audio_play_btn = (ImageView) findViewById(R.id.boolax_boo_message_audio_play_btn);
            ImageView ic_pause_circle_outline_black_24dp = (ImageView) findViewById(R.id.ic_pause_circle_outline_black_24dp);
            SeekBar boolax_boo_message_seekbar = (SeekBar) findViewById(R.id.boolax_boo_message_seekbar);
            TextView boolax_boo_message_rec_time = (TextView) findViewById(R.id.boolax_boo_message_rec_time);
            TextView boolax_boo_message_time_tot = (TextView) findViewById(R.id.boolax_boo_message_time_tot);

            Button audio_back = (Button) findViewById(R.id.audio_back);
            Button audioSend = (Button) findViewById(R.id.audioSend);
            final EditText thePreviewedPAudio_caption = (EditText) findViewById(R.id.thePreviewedPAudio_caption);
            //------------------
            audio_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AudioWife.getInstance().pause();
                    AudioWife.getInstance().release();
                    finish();

                }
            });
            //-------------
            audioSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //------------theSqliteSave-----------
                    NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(Preview_boolax_media.this);
                    thDb.openToWrite();
                    try {
                        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
                        String date = df.format(Calendar.getInstance().getTime());
                        if (thDb.save_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_locally(fName,
                                "audio", "0", "", remoteIdOfReceipient, myRemoteId, "", "",
                                date, "")) {

                            //-------Retreive this local id---------------
                            Cursor allNotSentTxtMsgs = thDb.GET_CHAT_MESSAGES_ALL_NOT_SENT(remoteIdOfReceipient);
                            if (allNotSentTxtMsgs.moveToFirst()) {
                                for (int i = 0; i < allNotSentTxtMsgs.getCount(); i++) {
                                    theLocalId = allNotSentTxtMsgs.getString(0);


                                }

                            }

                            new My_Community_Upload_audio(boolax_booers_chats_chatroom.theCtx,Preview_boolax_media.this, TEST_URL,
                                    fName,
                                    remoteIdOfReceipient, myRemoteId, thePreviewedPAudio_caption.getText().toString(), "audio", thisP_lit, theLocalId).execute();


                        }
                    } catch (Exception ss) {

                    }


                }
            });

            AudioWife.getInstance()
                    .init(Preview_boolax_media.this, Uri.fromFile(new File(filePath)))
                    .setPlayView(boolax_boo_message_audio_play_btn)
                    .setPauseView(ic_pause_circle_outline_black_24dp)
                    .setSeekBar(boolax_boo_message_seekbar)
                    .setRuntimeView(boolax_boo_message_rec_time)
                    .setTotalTimeView(boolax_boo_message_time_tot);


        } else if (mediaType.equalsIgnoreCase("image")) {
            TEST_URL = Environment.getExternalStorageDirectory() + File.separator
                    + "/boolax_images/" + fName;
            thePreviewedPic.setVisibility(View.VISIBLE);
            //-------------------
            String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/boolax_images/" + fName;
            ImageView thePreviewedPic_actual_img = (ImageView) findViewById(R.id.thePreviewedPic_actual_img);
            Button back = (Button) findViewById(R.id.back);
            Button Send = (Button) findViewById(R.id.Send);
            final EditText thePreviewedPic_caption = (EditText) findViewById(R.id.thePreviewedPic_caption);
            //------------------
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            //-------------
            Send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //------------theSqliteSave-----------
                    NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(Preview_boolax_media.this);
                    thDb.openToWrite();
                    try {
                        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
                        String date = df.format(Calendar.getInstance().getTime());
                        if (thDb.save_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_locally(fName,
                                "image", "0", "", remoteIdOfReceipient, myRemoteId, "", "",
                                date, "")) {

                            //-------Retreive this local id---------------
                            Cursor allNotSentTxtMsgs = thDb.GET_CHAT_MESSAGES_ALL_NOT_SENT(remoteIdOfReceipient);
                            if (allNotSentTxtMsgs.moveToFirst()) {
                                for (int i = 0; i < allNotSentTxtMsgs.getCount(); i++) {
                                    theLocalId = allNotSentTxtMsgs.getString(0);


                                }

                            }

                            new My_Community_Upload_image(boolax_booers_chats_chatroom.theCtx,Preview_boolax_media.this, TEST_URL,
                                    fName,
                                    remoteIdOfReceipient, myRemoteId, thePreviewedPic_caption.getText().toString(), "image", thisP_lit, theLocalId).execute();

                        }
                    } catch (Exception ss) {

                    }


                }
            });

            Glide.with(Preview_boolax_media.this)
                    .load(Uri.fromFile(new File(filePath)))
                    .into(thePreviewedPic_actual_img);

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        // Make sure the player stops playing if the user presses the home button.
        try {
            player.pause();
        } catch (RuntimeException fdh) {

        }
    }


    // Methods for the implemented EasyVideoCallback

    @Override
    public void onPreparing(EasyVideoPlayer player) {
        // TODO handle if needed
    }

    @Override
    public void onPrepared(EasyVideoPlayer player) {
        // TODO handle
    }

    @Override
    public void onBuffering(int percent) {
        // TODO handle if needed
    }

    @Override
    public void onError(EasyVideoPlayer player, Exception e) {
        // TODO handle
    }

    @Override
    public void onCompletion(EasyVideoPlayer player) {
        // TODO handle if needed
    }

    @Override
    public void onRetry(EasyVideoPlayer player, Uri source) {
        // TODO handle if used
    }

    @Override
    public void onSubmit(EasyVideoPlayer player, Uri source) {
        // TODO handle if used
    }

    @Override
    public void onStarted(EasyVideoPlayer player) {
        // TODO handle if needed
    }

    @Override
    public void onPaused(EasyVideoPlayer player) {
        // TODO handle if needed
    }

    @Override
    public void onBackPressed() {
        AudioWife.getInstance().pause();
        AudioWife.getInstance().release();
        finish();

    }
}
