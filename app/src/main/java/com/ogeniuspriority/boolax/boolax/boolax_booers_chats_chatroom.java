package com.ogeniuspriority.boolax.boolax;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialcamera.MaterialCamera;
import com.kbeanie.multipicker.api.AudioPicker;
import com.kbeanie.multipicker.api.Picker;
import com.kbeanie.multipicker.api.VideoPicker;
import com.kbeanie.multipicker.api.callbacks.AudioPickerCallback;
import com.kbeanie.multipicker.api.callbacks.VideoPickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenAudio;
import com.kbeanie.multipicker.api.entity.ChosenVideo;
import com.marcoscg.dialogsheet.DialogSheet;
import com.ogeniuspriority.boolax.boolax.m_DataObject.My_Community_Upload_audio_special;
import com.ogeniuspriority.boolax.boolax.m_DataObject.My_Community_Upload_image;
import com.ogeniuspriority.boolax.boolax.m_DataObject.My_Community_Upload_image_special;
import com.ogeniuspriority.boolax.boolax.m_DataObject.My_Community_Upload_video_special;
import com.ogeniuspriority.boolax.boolax.m_DataObject.boolax_chats_get_all_this_meet_chats;
import com.ogeniuspriority.boolax.boolax.m_DataObject.boolax_chats_msgs_download_audio;
import com.ogeniuspriority.boolax.boolax.m_DataObject.boolax_chats_msgs_download_image;
import com.ogeniuspriority.boolax.boolax.m_DataObject.boolax_chats_msgs_download_video;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_actual_lovers_send_msg;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_actual_lovers_send_msg_special;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_favorite_booers_download_actual_lovers;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_actual_lovers_send_txt_messages;
import com.theartofdev.edmodo.cropper.CropImage;
import com.vanniktech.emoji.EmojiEditText;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.ios.IosEmojiProvider;

import net.alhazmy13.mediapicker.Image.ImagePicker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import cafe.adriel.androidaudiorecorder.AndroidAudioRecorder;
import cafe.adriel.androidaudiorecorder.model.AudioChannel;
import cafe.adriel.androidaudiorecorder.model.AudioSampleRate;
import cafe.adriel.androidaudiorecorder.model.AudioSource;
import nl.changer.audiowife.AudioWife;

public class boolax_booers_chats_chatroom extends AppCompatActivity {
    private final static int CAMERA_RQ = 6969;
    private final static int CAMERA_RQ_RECORD = 6970;
    static volatile String thePassedIntel = "";
    String fname = "";
    String lname = "";
    String gender = "";
    String email = "";
    String username = "";
    String regdate = "";
    String age = "";
    String birthdate = "";
    String country = "";
    String province = "";
    String district = "";
    String how_attractive = "";
    String like_status = "";
    String about_life = "";
    String about_love = "";
    String about_relationships = "";
    String about_lover_criteria = "";
    String about_hobbies = "";
    String about_religious_affiliation = "";
    String about_academics_and_work = "";
    String avatar_image = "";
    public static volatile String remote_id = "";
    String interested_in = "";
    String your_height = "";
    String your_weight = "";
    String your_skin_color = "";
    //-------
    private static int downloadedSize;
    static String localAvatar = "";
    public static volatile String local_Remote_Id = "";
    //----------
    static ListView boolax_boos_list;
    //----the messages--
    static volatile String[] chat_id, actual_message,
            chat_type, chat_status,
            regdate_new,
            chat_sender,
            chat_receiver,
            who_sent,
            data_url,
            actual_message_,
            chats_archived,
            chat_remote_id;
    //--------
    static volatile String theAudioFile = "";
    public static Context theCtx;
    int totalSize = 0;

    EmojiEditText comment_2017_send_data;
    private boolean permissionToRecordAccepted = false;
    private String[] permissions = {android.Manifest.permission.RECORD_AUDIO};
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    int index_gh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //----------------
        //--------------------
        theCtx = boolax_booers_chats_chatroom.this;
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        ///------------
        AudioWife.getInstance().release();
        EmojiManager.install(new IosEmojiProvider());
        setContentView(R.layout.activity_boolax_booers_chats_chatroom);
        //---------
        boolax_boos_list = (ListView) findViewById(R.id.boolax_boos_list);
        boolax_boos_list.setDivider(null);
        boolax_boos_list.setDividerHeight(0);
        //--------
        boolax_boos_list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                index_gh = firstVisibleItem;
            }
        });
        //-------------ThelocalCreds
        getSupportActionBar().hide();
        final NDS_boolax_db_adapter thDb;
        thDb = new NDS_boolax_db_adapter(boolax_booers_chats_chatroom.this);
        thDb.openToWrite();
        Cursor allUsersSaved = thDb.GET_USER_DATA();
        if (allUsersSaved.moveToLast()) {
            for (int i = 0; i < allUsersSaved.getCount(); i++) {
                localAvatar = allUsersSaved.getString(21);
                local_Remote_Id = allUsersSaved.getString(22);


            }

        }
        allUsersSaved.close();
        //------
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
            int i = 0;


            for (String retval : value.split("~")) {
                System.out.println(retval);
                switch (i) {
                    case 0:
                        fname = retval;
                        break;
                    case 1:
                        lname = retval;
                        break;
                    case 2:
                        gender = retval;
                        break;
                    case 3:
                        email = retval;
                        break;
                    case 4:
                        username = retval;
                        break;
                    case 5:
                        regdate = retval;
                        break;
                    case 6:
                        age = retval;
                        break;
                    case 7:
                        birthdate = retval;
                        break;
                    case 8:
                        country = retval;
                        break;
                    case 9:
                        province = retval;
                        break;
                    case 10:
                        district = retval;
                        break;
                    case 11:
                        how_attractive = retval;
                        break;
                    case 12:
                        about_life = retval;
                        break;
                    case 13:
                        about_love = retval;
                        break;
                    case 14:
                        about_relationships = retval;
                        break;
                    case 15:
                        about_lover_criteria = retval;
                        break;
                    case 16:
                        about_hobbies = retval;
                        break;
                    case 17:
                        about_religious_affiliation = retval;
                        break;
                    case 18:
                        about_academics_and_work = retval;
                        break;
                    case 19:
                        avatar_image = retval;
                        break;
                    case 20:
                        remote_id = retval;
                        break;
                    case 21:
                        interested_in = retval;
                        break;
                    case 22:
                        your_height = retval;
                        break;
                    case 23:
                        your_weight = retval;
                        break;
                    case 24:
                        your_skin_color = retval;
                        break;

                }

                i++;
            }
            //---Populate some of the -------------------
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("" + username);


            //new My_Boolax_boxes_find_avatars(getContext(), Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(), remote_id, boo_avatar).execute();
            ImageView ic_camera_alt_black_24dp = (ImageView) findViewById(R.id.ic_camera_alt_black_24dp);
            final ImageView ic_insert_emoticon_black_24dp = (ImageView) findViewById(R.id.ic_insert_emoticon_black_24dp);
            ImageView comment_send_2017 = (ImageView) findViewById(R.id.comment_send_2017);
            //-------------------
            comment_2017_send_data = (EmojiEditText) findViewById(R.id.comment_2017_send_data);

            ic_camera_alt_black_24dp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View view = View.inflate(boolax_booers_chats_chatroom.this, R.layout.boolax_choose_media_pop_from_device, null);
                    DialogSheet thisMediaPop = new DialogSheet(boolax_booers_chats_chatroom.this);
                    thisMediaPop.setView(view);
                    thisMediaPop.show();
                    // Access dialog custom inflated view
                    View inflatedView = thisMediaPop.getInflatedView();
                    //--
                    ImageView boolax_image_capture_img = (ImageView) inflatedView.findViewById(R.id.boolax_image_capture_img);
                    ImageView boolax_voice_record_image = (ImageView) inflatedView.findViewById(R.id.boolax_voice_record_image);
                    ImageView boolax_video_record_image = (ImageView) inflatedView.findViewById(R.id.boolax_video_record_image);
                    ImageView boolax_image_choose_img = (ImageView) inflatedView.findViewById(R.id.boolax_image_choose_img);
                    ImageView boolax_voice_choose_image = (ImageView) inflatedView.findViewById(R.id.boolax_voice_choose_image);
                    ImageView boolax_video_choose_image = (ImageView) inflatedView.findViewById(R.id.boolax_video_choose_image);
                    //------The triggers---
                    boolax_image_capture_img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new MaterialCamera(boolax_booers_chats_chatroom.this)
                                    /** all the previous methods can be called, but video ones would be ignored */
                                    .stillShot() // launches the Camera in stillshot mode
                                    .qualityProfile(MaterialCamera.QUALITY_1080P)
                                    .showPortraitWarning(true)
                                    .defaultToFrontFacing(true)
                                    .primaryColorAttr(R.attr.colorPrimary)
                                    .videoPreferredAspect(90f / 90f)
                                    .start(CAMERA_RQ);
                        }
                    });
                    //--
                    boolax_voice_record_image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Calendar cal = Calendar.getInstance();
                            String filename = "Boolax_audio_msg_" + cal.getTimeInMillis() + "." + "mp3";
                            theAudioFile = Environment.getExternalStorageDirectory() + File.separator
                                    + "/boolax_audios/" + "" + filename;
                            //theAudioFile = Environment.getExternalStorageDirectory() + "/recorded_audio.wav";
                            int color = getResources().getColor(R.color.colorPrimaryDark);
                            int requestCode = 870;


                            try {
                                AndroidAudioRecorder.with(boolax_booers_chats_chatroom.this)
                                        // Required
                                        .setFilePath(theAudioFile)
                                        .setColor(color)
                                        .setRequestCode(requestCode)
                                        // Optional
                                        .setSource(AudioSource.MIC)
                                        .setChannel(AudioChannel.STEREO)
                                        .setSampleRate(AudioSampleRate.HZ_48000)
                                        .setAutoStart(false)
                                        .setKeepDisplayOn(true)

                                        // Start recording
                                        .record();
                            } catch (Exception rrr) {


                            }

                        }
                    });
                    //--
                    boolax_video_record_image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            new MaterialCamera(boolax_booers_chats_chatroom.this)
                                    .videoEncodingBitRate(1024000)
                                    .defaultToFrontFacing(true)// Sets a custom bit rate for video recording.
                                    .audioEncodingBitRate(50000)                       // Sets a custom bit rate for audio recording.
                                    .videoFrameRate(24)                                // Sets a custom frame rate (FPS) for video recording.
                                    .qualityProfile(MaterialCamera.QUALITY_HIGH)
                                    .countdownSeconds(15.0f)                        // Sets a preferred height for the recorded video output.
                                    .videoPreferredAspect(90f / 90f)
                                    .primaryColorAttr(R.attr.colorPrimary)
                                    .start(CAMERA_RQ_RECORD);
                        }
                    });
                    //--
                    boolax_image_choose_img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new ImagePicker.Builder(boolax_booers_chats_chatroom.this)
                                    .mode(ImagePicker.Mode.GALLERY)
                                    .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                                    .directory(ImagePicker.Directory.DEFAULT)
                                    .extension(ImagePicker.Extension.PNG)
                                    .scale(600, 600)
                                    .allowMultipleImages(false)
                                    .enableDebuggingMode(true)
                                    .build();

                        }
                    });
                    //--
                    boolax_voice_choose_image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AudioPicker audioPicker = new AudioPicker(boolax_booers_chats_chatroom.this);
// audioPicker.allowMultiple();
// audioPicker.
                            audioPicker.setAudioPickerCallback(new AudioPickerCallback() {
                                @Override
                                public void onAudiosChosen(List<ChosenAudio> files) {
                                    // Display Files
                                }

                                @Override
                                public void onError(String message) {
                                    // Handle errors
                                }
                            });

                            audioPicker.pickAudio();
                        }
                    });
                    //--
                    boolax_video_choose_image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //------------------------------
                            VideoPicker videoPicker = new VideoPicker(boolax_booers_chats_chatroom.this);
                            videoPicker.setVideoPickerCallback(new VideoPickerCallback() {
                                                                   @Override
                                                                   public void onError(String s) {

                                                                   }

                                                                   @Override
                                                                   public void onVideosChosen(List<ChosenVideo> list) {

                                                                   }

                                                               }
                            );
                            videoPicker.pickVideo();

                        }
                    });


                }
            });
            //--
            LinearLayout werrrrr = (LinearLayout) findViewById(R.id.werrrrr);
            final EmojiPopup emojiPopup = EmojiPopup.Builder.fromRootView(werrrrr).build(comment_2017_send_data);

            ic_insert_emoticon_black_24dp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ic_insert_emoticon_black_24dp.setImageResource(R.drawable.ic_keyboard_black_24dp);

                    if (emojiPopup.isShowing()) {
                        ic_insert_emoticon_black_24dp.setImageResource(R.drawable.ic_insert_emoticon_black_24dp);
                        emojiPopup.dismiss();
                    } else {
                        emojiPopup.toggle(); // Toggles visibility of the Popup.
                        ic_insert_emoticon_black_24dp.setImageResource(R.drawable.ic_keyboard_black_24dp);
                    }

                    // emojiPopup.dismiss(); // Dismisses the Popup.
                    // emojiPopup.isShowing(); // Returns true when Popup is showing.

                }
            });
            //------------sho
            comment_send_2017.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!comment_2017_send_data.getText().toString().equalsIgnoreCase("")) {
                        new Boolax_actual_lovers_send_msg(boolax_booers_chats_chatroom.this, Config.BOOLAX_ACCOUNT_LOAD_THE_ACTUAL_LOVERS_CHATS_TXT_MSGS_SEND.toString(), local_Remote_Id, remote_id, "text", "", "", comment_2017_send_data.getText().toString(), comment_2017_send_data, boolax_boos_list).execute();
                    }
                }
            });
            //----------------------

        }
        //--------The messages--
        thDb.openToWrite();
        //-------Retreive this local id---------------

        Cursor allSavedMessages = thDb.GET_CHAT_MESSAGES_ALL(remote_id);

        chat_id = new String[allSavedMessages.getCount()];
        actual_message = new String[allSavedMessages.getCount()];
        chat_type = new String[allSavedMessages.getCount()];
        chat_status = new String[allSavedMessages.getCount()];
        regdate_new = new String[allSavedMessages.getCount()];
        chat_sender = new String[allSavedMessages.getCount()];
        chat_receiver = new String[allSavedMessages.getCount()];
        who_sent = new String[allSavedMessages.getCount()];
        data_url = new String[allSavedMessages.getCount()];
        actual_message_ = new String[allSavedMessages.getCount()];
        chats_archived = new String[allSavedMessages.getCount()];
        chat_remote_id = new String[allSavedMessages.getCount()];

        if (allSavedMessages.moveToLast()) {
            for (int i = 0; i < allSavedMessages.getCount(); i++) {
                chat_id[i] = allSavedMessages.getString(0);
                actual_message[i] = allSavedMessages.getString(1);
                chat_type[i] = allSavedMessages.getString(2);
                chat_status[i] = allSavedMessages.getString(3);
                regdate_new[i] = allSavedMessages.getString(4);
                chat_sender[i] = allSavedMessages.getString(5);
                chat_receiver[i] = allSavedMessages.getString(6);
                who_sent[i] = allSavedMessages.getString(7);
                data_url[i] = allSavedMessages.getString(8);
                actual_message_[i] = allSavedMessages.getString(9);
                chats_archived[i] = allSavedMessages.getString(10);
                chat_remote_id[i] = allSavedMessages.getString(11);
                Log.w("count_this", "" + chat_remote_id[i]);

                allSavedMessages.moveToPrevious();
            }
            ListAdapter theMessages = new custom_adapter_for_actual_lovers_send_txt_messages(boolax_booers_chats_chatroom.this, chat_id, actual_message,
                    chat_type, chat_status,
                    regdate_new, chat_sender, chat_receiver, who_sent,
                    data_url, actual_message_, chats_archived, chat_remote_id, remote_id);
            boolax_boos_list.setAdapter(theMessages);
            boolax_boos_list.setSelection(theMessages.getCount() - 1);

        }
        allSavedMessages.close();

        //-----the background tasks--
        handlerRecycleActivity.postDelayed(runnableRecycleActivity, 1000);


    }


    //---------Onactivity result--------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImagePicker.IMAGE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            Log.w("media_chat", "Image Chosen");
            List<String> mPaths = (List<String>) data.getSerializableExtra(ImagePicker.EXTRA_IMAGE_PATH);
            try {
                // InputStream inputStreamImage = getBaseContext().getContentResolver().openInputStream(data.getData());
                //Log.w("image-00",""+inputStream);
                //-----------------
                File theFile = new File(mPaths.get(0));
                InputStream inputStreamImage = new FileInputStream(theFile);
                File SDCardRoot = Environment.getExternalStorageDirectory();
                //create a new file, to save the downloaded file
                File directory = new File(SDCardRoot, "/boolax_images/");

                if (!directory.exists()) {
                    directory.mkdir();
                }
                Calendar cal = Calendar.getInstance();
                String filename = "Boolax_img_msg_" + cal.getTimeInMillis() + ".png";

                File file = new File(directory, filename);

                FileOutputStream fileOutput = new FileOutputStream(file);

                //Stream used for reading the data from the internet
                InputStream inputStream = inputStreamImage;

                byte[] buffer = new byte[20 * 1024];
                int bufferLength = 0;

                while ((bufferLength = inputStream.read(buffer)) > 0) {
                    fileOutput.write(buffer, 0, bufferLength);
                    downloadedSize = bufferLength;

                }
                //close the output stream when complete //
                fileOutput.close();
                //------------
                String path_0 = Environment.getExternalStorageDirectory() + File.separator
                        + "/boolax_images/" + filename;
                String filename_to_up = path_0.substring(path_0.lastIndexOf("/") + 1);
                String theLocalId = "";
                //----------------------------


                //------------------

                Intent intent = new Intent(boolax_booers_chats_chatroom.this, Preview_boolax_media.class);
                intent.putExtra("theVideoUrl", filename_to_up);
                intent.putExtra("mediaType", "image");

                intent.putExtra("remoteIdOfReceipient", remote_id);
                intent.putExtra("myRemoteId", local_Remote_Id);
                intent.putExtra("theLocalId", theLocalId);
                startActivity(intent);

            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            }


        }

        // Received recording or error from MaterialCamera
        if (requestCode == CAMERA_RQ) {

            if (resultCode == RESULT_OK) {
                Log.w("media_chat", "Image taken from camera.");
                try {
                    InputStream inputStreamImage = getBaseContext().getContentResolver().openInputStream(data.getData());
                    //Log.w("image-00",""+inputStream);
                    //-----------------
                    File SDCardRoot = Environment.getExternalStorageDirectory();
                    //create a new file, to save the downloaded file
                    File directory = new File(SDCardRoot, "/boolax_images/");

                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    Calendar cal = Calendar.getInstance();
                    String filename = "Boolax_img_msg_" + cal.getTimeInMillis() + ".png";

                    File file = new File(directory, filename);

                    FileOutputStream fileOutput = new FileOutputStream(file);

                    //Stream used for reading the data from the internet
                    InputStream inputStream = inputStreamImage;

                    byte[] buffer = new byte[20 * 1024];
                    int bufferLength = 0;

                    while ((bufferLength = inputStream.read(buffer)) > 0) {
                        fileOutput.write(buffer, 0, bufferLength);
                        downloadedSize = bufferLength;

                    }
                    //close the output stream when complete //
                    fileOutput.close();
                    //------------
                    String path_0 = Environment.getExternalStorageDirectory() + File.separator
                            + "/boolax_images/" + filename;
                    String filename_to_up = path_0.substring(path_0.lastIndexOf("/") + 1);
                    String theLocalId = "";
                    //----------------------------


                    Intent intent = new Intent(boolax_booers_chats_chatroom.this, Preview_boolax_media.class);
                    intent.putExtra("theVideoUrl", filename_to_up);
                    intent.putExtra("mediaType", "image");

                    intent.putExtra("remoteIdOfReceipient", remote_id);
                    intent.putExtra("myRemoteId", local_Remote_Id);
                    intent.putExtra("theLocalId", theLocalId);
                    startActivity(intent);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();

                }


            }
        }
        if (requestCode == CAMERA_RQ_RECORD) {

            if (resultCode == RESULT_OK) {
                Log.w("media_chat", "Video record from camera.");
                try {
                    InputStream inputStreamVideo = getBaseContext().getContentResolver().openInputStream(data.getData());
                    //Log.w("image-00",""+inputStream);
                    //-----------------
                    File SDCardRoot = Environment.getExternalStorageDirectory();
                    //create a new file, to save the downloaded file
                    File directory = new File(SDCardRoot, "/boolax_videos/");

                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    Calendar cal = Calendar.getInstance();
                    String filename = "Boolax_video_msg_" + cal.getTimeInMillis() + ".mp4";

                    File file = new File(directory, filename);

                    FileOutputStream fileOutput = new FileOutputStream(file);

                    //Stream used for reading the data from the internet
                    InputStream inputStream = inputStreamVideo;
                    final String path_0 = Environment.getExternalStorageDirectory() + File.separator
                            + "boolax_videos/" + filename;
                    String filename_to_up = path_0.substring(path_0.lastIndexOf("/") + 1);

                    String theLocalId = "";
                    //----------------------------


                    byte[] buffer = new byte[20 * 1024];
                    int bufferLength = 0;

                    while ((bufferLength = inputStream.read(buffer)) > 0) {
                        fileOutput.write(buffer, 0, bufferLength);
                        downloadedSize = bufferLength;
                        // update the progressbar //

                    }
                    //close the output stream when complete //
                    fileOutput.close();
                    //--------------
                    Intent intent = new Intent(boolax_booers_chats_chatroom.this, Preview_boolax_media.class);
                    intent.putExtra("theVideoUrl", filename_to_up);
                    intent.putExtra("mediaType", "video");

                    intent.putExtra("remoteIdOfReceipient", remote_id);
                    intent.putExtra("myRemoteId", local_Remote_Id);
                    intent.putExtra("theLocalId", theLocalId);
                    startActivity(intent);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        if (requestCode == Picker.PICK_AUDIO && resultCode == RESULT_OK) {
            Log.w("media_chat", "Audio from device.");
            try {
                InputStream inputStreamImage = getBaseContext().getContentResolver().openInputStream(data.getData());
                //Log.w("image-00",""+inputStream);
                //-----------------
                File SDCardRoot = Environment.getExternalStorageDirectory();
                //create a new file, to save the downloaded file
                File directory = new File(SDCardRoot, "/boolax_audios/");

                if (!directory.exists()) {
                    directory.mkdir();
                }
                Calendar cal = Calendar.getInstance();
                //Log.w("00008", "" + selectedPath);

                //---
                //String filename = "NDS_audio_" + cal.getTimeInMillis() + "." + selectedPath.substring(selectedPath.lastIndexOf("."));
                String filename = "Boolax_audio_msg_" + cal.getTimeInMillis() + "." + "mp3";

                File file = new File(directory, filename);

                FileOutputStream fileOutput = new FileOutputStream(file);
                //-----------------
                final String path_0 = Environment.getExternalStorageDirectory() + File.separator
                        + "/boolax_audios/" + filename;
                String filename_to_up = path_0.substring(path_0.lastIndexOf("/") + 1);
                String theLocalId = "";
                //----------------------------


                //Stream used for reading the data from the internet
                InputStream inputStream = inputStreamImage;

                byte[] buffer = new byte[20 * 1024];
                int bufferLength = 0;

                while ((bufferLength = inputStream.read(buffer)) > 0) {
                    fileOutput.write(buffer, 0, bufferLength);
                    downloadedSize = bufferLength;

                }
                //close the output stream when complete //
                fileOutput.close();
                //------------
                Intent intent = new Intent(boolax_booers_chats_chatroom.this, Preview_boolax_media.class);
                intent.putExtra("theVideoUrl", filename_to_up);
                intent.putExtra("mediaType", "audio");

                intent.putExtra("remoteIdOfReceipient", remote_id);
                intent.putExtra("myRemoteId", local_Remote_Id);
                intent.putExtra("theLocalId", theLocalId);
                startActivity(intent);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (resultCode == RESULT_OK) {
            if (requestCode == Picker.PICK_VIDEO_DEVICE) {
                Log.w("media_chat", "Video from device.");
                try {
                    InputStream inputStreamVideo = getBaseContext().getContentResolver().openInputStream(data.getData());
                    //Log.w("image-00",""+inputStream);
                    //-----------------
                    File SDCardRoot = Environment.getExternalStorageDirectory();
                    //create a new file, to save the downloaded file
                    File directory = new File(SDCardRoot, "/boolax_videos/");

                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    Calendar cal = Calendar.getInstance();
                    String filename = "Boolax_video_msg_" + cal.getTimeInMillis() + ".mp4";

                    File file = new File(directory, filename);

                    FileOutputStream fileOutput = new FileOutputStream(file);

                    //Stream used for reading the data from the internet
                    InputStream inputStream = inputStreamVideo;
                    final String path_0 = Environment.getExternalStorageDirectory() + File.separator
                            + "NDS videos/" + filename;
                    String filename_to_up = path_0.substring(path_0.lastIndexOf("/") + 1);
                    String theLocalId = "";
                    //----------------------------


                    byte[] buffer = new byte[20 * 1024];
                    int bufferLength = 0;

                    while ((bufferLength = inputStream.read(buffer)) > 0) {
                        fileOutput.write(buffer, 0, bufferLength);
                        downloadedSize = bufferLength;
                        // update the progressbar //

                    }
                    //close the output stream when complete //
                    fileOutput.close();
                    //--------------
                    Intent intent = new Intent(boolax_booers_chats_chatroom.this, Preview_boolax_media.class);
                    intent.putExtra("theVideoUrl", filename_to_up);
                    intent.putExtra("mediaType", "video");

                    intent.putExtra("remoteIdOfReceipient", remote_id);
                    intent.putExtra("myRemoteId", local_Remote_Id);
                    intent.putExtra("theLocalId", theLocalId);
                    startActivity(intent);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        if (resultCode == RESULT_OK) {
            if (requestCode == 870) {
                Log.w("media_chat", "From record");

                //------------
                final String path_0 = theAudioFile;
                String filename_to_up = path_0.substring(path_0.lastIndexOf("/") + 1);

                String theLocalId = "";

                Intent intent = new Intent(boolax_booers_chats_chatroom.this, Preview_boolax_media.class);
                intent.putExtra("theVideoUrl", filename_to_up);
                intent.putExtra("mediaType", "audio");

                intent.putExtra("remoteIdOfReceipient", remote_id);
                intent.putExtra("myRemoteId", local_Remote_Id);
                intent.putExtra("theLocalId", theLocalId);
                startActivity(intent);


            }
        }
    }

    //-----------------------Download and handle other unsent messages
    Handler handlerRecycleActivity = new Handler();
    Runnable runnableRecycleActivity = new Runnable() {
        public void run() {
            //----------find all new Messages------
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final NDS_boolax_db_adapter thDb;
                    thDb = new NDS_boolax_db_adapter(boolax_booers_chats_chatroom.this);
                    thDb.openToWrite();
                    Cursor all_chats_msgs = thDb.GET_CHAT_MESSAGES_ALL_SENT(remote_id);
                    String all_the_chat_ids_for_this_meet = "";
                    if (all_chats_msgs.moveToLast()) {
                        for (int i = 0; i < all_chats_msgs.getCount(); i++) {
                            String chat_msg_remote_id = all_chats_msgs.getString(11);
                            if (all_the_chat_ids_for_this_meet.equalsIgnoreCase("")) {
                                all_the_chat_ids_for_this_meet = chat_msg_remote_id;
                            } else {
                                all_the_chat_ids_for_this_meet = all_the_chat_ids_for_this_meet + "~" + chat_msg_remote_id;
                            }
                            all_chats_msgs.moveToPrevious();

                        }
                    }
                    //----------Bring all New Messages text and media.
                    Cursor all_chats_msgs_debug = thDb.GET_CHAT_MESSAGES_ALL_NADA();
                    Log.w("chat_replies", "started " + all_chats_msgs_debug.getCount());
                    new boolax_chats_get_all_this_meet_chats(boolax_booers_chats_chatroom.this, Config.BOOLAX_ACCOUNT_LOAD_THE_ACTUAL_LOVERS_CHATS_GET_ALL_MESSAGES, local_Remote_Id, remote_id, all_the_chat_ids_for_this_meet, boolax_boos_list).execute();

                }
            }).start();
            //---Get all unsent messages and send them---------

            final NDS_boolax_db_adapter thDb;
            thDb = new NDS_boolax_db_adapter(boolax_booers_chats_chatroom.this);
            thDb.openToWrite();
            Cursor all_chats_msgs = thDb.GET_CHAT_MESSAGES_ALL_NOT_SENT(remote_id);
            if (all_chats_msgs.moveToLast()) {

                for (int i = 0; i < all_chats_msgs.getCount(); i++) {
                    String chat_msg_type = all_chats_msgs.getString(2);
                    String chat_actual_msg = all_chats_msgs.getString(1);
                    String chat_actual_local_id = all_chats_msgs.getString(0);
                    String chat_caption = all_chats_msgs.getString(9);
                    String chat_remote_id = all_chats_msgs.getString(11);

                    String the_sender_of = all_chats_msgs.getString(5);
                    String regdate = all_chats_msgs.getString(4);
                    if (the_sender_of.equalsIgnoreCase(local_Remote_Id)) {
                        if (chat_msg_type.equalsIgnoreCase("text")) {

                            new Boolax_actual_lovers_send_msg_special(boolax_booers_chats_chatroom.this, Config.BOOLAX_ACCOUNT_LOAD_THE_ACTUAL_LOVERS_CHATS_TXT_MSGS_SEND.toString(), local_Remote_Id, remote_id, "text", chat_caption, "", chat_actual_msg, boolax_boos_list, chat_actual_local_id, index_gh).execute();

                        } else if (chat_msg_type.equalsIgnoreCase("image")) {

                            String image_path = Environment.getExternalStorageDirectory() + File.separator
                                    + "/boolax_images/" + chat_actual_msg;

                            new My_Community_Upload_image_special(boolax_booers_chats_chatroom.this, image_path,
                                    chat_actual_msg,
                                    remote_id, local_Remote_Id, chat_caption, "image", boolax_boos_list, chat_actual_local_id, index_gh).execute();

                        } else if (chat_msg_type.equalsIgnoreCase("video")) {
                            String video_path = Environment.getExternalStorageDirectory() + File.separator
                                    + "/boolax_videos/" + chat_actual_msg;
                            new My_Community_Upload_video_special(boolax_booers_chats_chatroom.this, video_path,
                                    chat_actual_msg,
                                    remote_id, local_Remote_Id, chat_caption, "video", boolax_boos_list, chat_actual_local_id, index_gh).execute();

                        } else if (chat_msg_type.equalsIgnoreCase("audio")) {

                            String audio_path = Environment.getExternalStorageDirectory() + File.separator
                                    + "/boolax_audios/" + chat_actual_msg;
                            new My_Community_Upload_audio_special(boolax_booers_chats_chatroom.this, audio_path,
                                    chat_actual_msg,
                                    remote_id, local_Remote_Id, chat_caption, "video", boolax_boos_list, chat_actual_local_id, index_gh).execute();
                        }
                        //Log.w("Trying", " Media Msgs! Medias upload");
                    } else if (the_sender_of.equalsIgnoreCase(remote_id)) {
                        //---------Download all the media files------chat_actual_msg----------
                        Log.w("Trying", " Media Msgs! Medias download " + chat_msg_type + "--" + chat_remote_id);

                        if (chat_msg_type.equalsIgnoreCase("image")) {

                            new boolax_chats_msgs_download_image(boolax_booers_chats_chatroom.this, Config.BOOLAX_ACCOUNT_LOAD_THE_ACTUAL_LOVERS_CHATS_IMAGES + chat_actual_msg,
                                    chat_actual_msg,
                                    local_Remote_Id, remote_id, chat_caption, chat_msg_type,
                                    boolax_boos_list, chat_actual_local_id, regdate
                                    , chat_remote_id, index_gh).execute();

                        } else if (chat_msg_type.equalsIgnoreCase("video")) {
                            new boolax_chats_msgs_download_video(boolax_booers_chats_chatroom.this, Config.BOOLAX_ACCOUNT_LOAD_THE_ACTUAL_LOVERS_CHATS_VIDEOS + chat_actual_msg,
                                    chat_actual_msg,
                                    local_Remote_Id, remote_id, chat_caption, chat_msg_type,
                                    boolax_boos_list, chat_actual_local_id, regdate
                                    , chat_remote_id, index_gh).execute();

                        } else if (chat_msg_type.equalsIgnoreCase("audio")) {
                            new boolax_chats_msgs_download_audio(boolax_booers_chats_chatroom.this, Config.BOOLAX_ACCOUNT_LOAD_THE_ACTUAL_LOVERS_CHATS_AUDIOS + chat_actual_msg,
                                    chat_actual_msg,
                                    local_Remote_Id, remote_id, chat_caption, chat_msg_type,
                                    boolax_boos_list, chat_actual_local_id, regdate
                                    , chat_remote_id, index_gh).execute();

                        }
                    }

                    all_chats_msgs.moveToPrevious();
                }
            }
            //----------------------


            handlerRecycleActivity.postDelayed(this, 10000);

        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted) {

        }

    }

}
