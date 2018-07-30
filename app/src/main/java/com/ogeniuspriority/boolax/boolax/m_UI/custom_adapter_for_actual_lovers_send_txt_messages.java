package com.ogeniuspriority.boolax.boolax.m_UI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Priority;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.request.RequestOptions;
import com.ogeniuspriority.boolax.boolax.Config;
import com.ogeniuspriority.boolax.boolax.MyPlayerActivity;
import com.ogeniuspriority.boolax.boolax.R;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import nl.changer.audiowife.AudioWife;

/**
 * Created by USER on 2/6/2017.
 */
public class custom_adapter_for_actual_lovers_send_txt_messages extends BaseAdapter implements GlideModule {
    Context c;

    int layoutResourceId;
    public List<String> data;
    public List<String> tags;
    public List<String> tags_unlike;
    //-------------
    static volatile String[] chat_id;
    static volatile String[] actual_message;
    static volatile String[] chat_type;
    static volatile String[] chat_status;
    static volatile String[] regdate;
    static volatile String[] chat_sender;
    static volatile String[] chat_receiver;
    static volatile String[] who_sent;
    static volatile String[] data_url;
    static volatile String[] actual_message_;
    static volatile String[] chats_archived;
    static volatile String[] chat_remote_id;
    static volatile String my_local_id;


    public custom_adapter_for_actual_lovers_send_txt_messages(Context c, String[] chat_id, String[] actual_message, String[] chat_type, String[] chat_status,
                                                              String[] regdate, String[] chat_sender, String[] chat_receiver, String[] who_sent,
                                                              String[] data_url, String[] actual_message_, String[] chats_archived, String[] chat_remote_id, String my_local_id) {

        this.c = c;
        this.chat_id = chat_id;
        this.actual_message = actual_message;
        this.chat_type = chat_type;
        this.chat_status = chat_status;
        this.chat_sender = chat_sender;
        this.regdate = regdate;
        this.chat_receiver = chat_receiver;
        this.who_sent = who_sent;
        this.data_url = data_url;
        this.actual_message_ = actual_message_;
        this.chats_archived = chats_archived;
        this.chat_remote_id = chat_remote_id;

        // this.layoutResourceId = resource;
        this.c = c;
        this.my_local_id = my_local_id;


    }


    @Override
    public int getCount() {

        return this.actual_message_.length;

    }

    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        // viewHolder = new ViewHolder();
        // viewHolder.position = position;
        //-----For folder id,profile_photos

        //----------------flip the display------------
        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.boolax_favorite_boo_message_data_display_gravity_right, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            viewHolder.position = position;
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }
        //------------------
        if (!chat_sender[position].equalsIgnoreCase(my_local_id)) {
            LinearLayout flip_right = convertView.findViewById(R.id.flip_right);
            LinearLayout flip_left = convertView.findViewById(R.id.flip_left);
            //-----------
            flip_right.setVisibility(View.VISIBLE);
            flip_left.setVisibility(View.GONE);
            //------------

            //---------------------------
            //final Boolax_favorite_booers_boos_objects boolax_boos = (Boolax_favorite_booers_boos_objects) getItem(position);

            convertView.setTag(viewHolder);


            viewHolder.boolax_boo_avatar = (CircleImageView) convertView.findViewById(R.id.boolax_boo_avatar);
            viewHolder.boolax_boo_message_actual_txt_msg = (TextView) convertView.findViewById(R.id.boolax_boo_message_actual_txt_msg);
            viewHolder.boolax_boo_message_audio_play_btn = (ImageView) convertView.findViewById(R.id.boolax_boo_message_audio_play_btn);
            viewHolder.boolax_boo_message_seekbar = (SeekBar) convertView.findViewById(R.id.boolax_boo_message_seekbar);
            viewHolder.boolax_boo_message_time = (TextView) convertView.findViewById(R.id.boolax_boo_message_time);
            viewHolder.boolax_boo_message_audio_caption = (TextView) convertView.findViewById(R.id.boolax_boo_message_audio_caption);

            viewHolder.boolax_boo_message_image = (ImageView) convertView.findViewById(R.id.boolax_boo_message_image);
            viewHolder.boolax_boo_message_image_caption = (TextView) convertView.findViewById(R.id.boolax_boo_message_image_caption);
            viewHolder.boolax_boo_message_rec_time = (TextView) convertView.findViewById(R.id.boolax_boo_message_rec_time);

            viewHolder.boolax_boo_message_delivered = (ImageView) convertView.findViewById(R.id.boolax_boo_message_delivered);
            viewHolder.boolax_boo_message_sent = (ImageView) convertView.findViewById(R.id.boolax_boo_message_sent);
            viewHolder.boolax_boo_message_not_sent = (ImageView) convertView.findViewById(R.id.boolax_boo_message_not_sent);
            viewHolder.boolax_boo_message_seen = (ImageView) convertView.findViewById(R.id.boolax_boo_message_seen);
            viewHolder.boolax_boo_message_time_tot = (TextView) convertView.findViewById(R.id.boolax_boo_message_time_tot);
            viewHolder.progress_2 = (IconRoundCornerProgressBar) convertView.findViewById(R.id.progress_2);
            viewHolder.the_image_preview = (LinearLayout) convertView.findViewById(R.id.theimagepreview);

            viewHolder.theNoneText = (LinearLayout) convertView.findViewById(R.id.theNoneText);
            viewHolder.right_audio_holder = (LinearLayout) convertView.findViewById(R.id.right_audio_hold);



            viewHolder.ic_pause_circle_outline_black_24dp = (ImageView) convertView.findViewById(R.id.ic_pause_circle_outline_black_24dp);
            //-------Differentiate the  parallel data
            if (chat_sender[position].equalsIgnoreCase(my_local_id)) {
                new My_Boolax_boxes_find_avatars(c, Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(), chat_sender[position], viewHolder.boolax_boo_avatar).execute();

            } else {
                new My_Boolax_boxes_find_avatars(c, Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(), chat_sender[position], viewHolder.boolax_boo_avatar).execute();

            }
            try {
                viewHolder.boolax_boo_message_delivered.setVisibility(View.GONE);
                viewHolder.boolax_boo_message_sent.setVisibility(View.GONE);
                viewHolder.boolax_boo_message_not_sent.setVisibility(View.GONE);
                viewHolder.boolax_boo_message_seen.setVisibility(View.GONE);
            } catch (RuntimeException ff) {

            }
            //-------show appropriate status
            if (chat_status[position].equalsIgnoreCase("0")) {
                //---not sent
                viewHolder.boolax_boo_message_not_sent.setVisibility(View.VISIBLE);

            } else if (chat_status[position].equalsIgnoreCase("1")) {
                //---sent
                viewHolder.boolax_boo_message_sent.setVisibility(View.VISIBLE);

            } else if (chat_status[position].equalsIgnoreCase("2")) {
                //---delivered
                viewHolder.boolax_boo_message_delivered.setVisibility(View.VISIBLE);

            } else if (chat_status[position].equalsIgnoreCase("3")) {
                //---seen-------------
                viewHolder.boolax_boo_message_seen.setVisibility(View.VISIBLE);
            }
            //-------------------show appropriate data type
            viewHolder.boolax_boo_message_actual_txt_msg.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_audio_play_btn.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_seekbar.setVisibility(View.GONE);
            //viewHolder.boolax_boo_message_time.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_audio_caption.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_image.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_image_caption.setVisibility(View.GONE);
            //viewHolder.boolax_boo_message_rec_time.setVisibility(View.GONE);

            viewHolder.boolax_boo_message_time_tot.setVisibility(View.GONE);
            viewHolder.ic_pause_circle_outline_black_24dp.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_time.setVisibility(View.GONE);
            //viewHolder.theNoneText.setVisibility(View.GONE);
            viewHolder.the_image_preview.setVisibility(View.GONE);
            viewHolder.right_audio_holder.setVisibility(View.GONE);

            if (chat_type[position].equalsIgnoreCase("image")) {
                viewHolder.boolax_boo_message_image.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_image_caption.setVisibility(View.VISIBLE);
                viewHolder.theNoneText.setVisibility(View.VISIBLE);
                viewHolder.the_image_preview.setVisibility(View.VISIBLE);
                //----------
                viewHolder.boolax_boo_message_image_caption.setText("" + actual_message_[position]);
                //-------------------
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/boolax_images/" + actual_message[position];
                RequestOptions options = new RequestOptions()
                        .centerCrop()
                        .placeholder(R.mipmap.failed)
                        .error(R.mipmap.failed)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH);
                try {
                    Glide.with(c)
                            .load(Uri.fromFile(new File(filePath)))
                            .apply(options)
                            .into(viewHolder.boolax_boo_message_image);
                }catch (Exception df){

                }

            } else if (chat_type[position].equalsIgnoreCase("video")) {
                viewHolder.boolax_boo_message_image.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_image_caption.setVisibility(View.VISIBLE);
                viewHolder.the_image_preview.setVisibility(View.VISIBLE);
                //------------------
                viewHolder.boolax_boo_message_image_caption.setText("" + actual_message_[position]);
                viewHolder.theNoneText.setVisibility(View.VISIBLE);
                //-------------
                final String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/boolax_videos/" + actual_message[position];
                RequestOptions options = new RequestOptions()
                        .centerCrop()
                        .placeholder(R.mipmap.failed)
                        .error(R.mipmap.failed)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH);
                try {
                    Glide.with(c)
                            .load(Uri.fromFile(new File(filePath)))
                            .apply(options)
                            .into(viewHolder.boolax_boo_message_image);
                }catch (RuntimeException fkfk){

                }
                //-------------------

                viewHolder.boolax_boo_message_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(c, MyPlayerActivity.class);
                        intent.putExtra("theVideoUrl", filePath);
                        ((Activity) c).startActivity(intent);
                    }
                });


            } else if (chat_type[position].equalsIgnoreCase("text")) {
                viewHolder.boolax_boo_message_actual_txt_msg.setVisibility(View.VISIBLE);
                //---------------------
                viewHolder.boolax_boo_message_actual_txt_msg.setText( actual_message[position]);


            } else if (chat_type[position].equalsIgnoreCase("audio")) {
                viewHolder.boolax_boo_message_audio_caption.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_rec_time.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_seekbar.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_audio_play_btn.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_time_tot.setVisibility(View.VISIBLE);
                viewHolder.ic_pause_circle_outline_black_24dp.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_time.setVisibility(View.VISIBLE);
                viewHolder.theNoneText.setVisibility(View.VISIBLE);
                //----------------------------------------------
                viewHolder.right_audio_holder.setVisibility(View.VISIBLE);
                viewHolder.ic_pause_circle_outline_black_24dp.setVisibility(View.GONE);
                viewHolder.boolax_boo_message_audio_caption.setText("" + actual_message_[position]);
                //------------------------------
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/boolax_audios/" + actual_message[position];
                // AudioWife takes care of click handler for play/pause button
                try {
                    AudioWife.getInstance().release();
                    AudioWife.getInstance()
                            .init(c, Uri.fromFile(new File(filePath)))
                            .setPlayView(viewHolder.boolax_boo_message_audio_play_btn)
                            .setPauseView(viewHolder.ic_pause_circle_outline_black_24dp)
                            .setSeekBar(viewHolder.boolax_boo_message_seekbar)
                            .setRuntimeView(viewHolder.boolax_boo_message_time)
                            .setTotalTimeView(viewHolder.boolax_boo_message_time_tot);
                } catch (Exception jfjj) {

                }

            }
            viewHolder.boolax_boo_message_rec_time.setVisibility(View.VISIBLE);
            viewHolder.boolax_boo_message_rec_time.setText(" " + regdate[position]);

        } else {
            LinearLayout flip_right = convertView.findViewById(R.id.flip_right);
            LinearLayout flip_left = convertView.findViewById(R.id.flip_left);
            //-----------
            flip_right.setVisibility(View.GONE);
            flip_left.setVisibility(View.VISIBLE);
            //--------------

            //---------------------------
            //final Boolax_favorite_booers_boos_objects boolax_boos = (Boolax_favorite_booers_boos_objects) getItem(position);

            convertView.setTag(viewHolder);


            viewHolder.boolax_boo_avatar_left = (CircleImageView) convertView.findViewById(R.id.boolax_boo_avatar_left);
            viewHolder.boolax_boo_message_actual_txt_msg_left = (TextView) convertView.findViewById(R.id.boolax_boo_message_actual_txt_msg_left);
            viewHolder.boolax_boo_message_audio_play_btn_left = (ImageView) convertView.findViewById(R.id.boolax_boo_message_audio_play_btn_left);
            viewHolder.boolax_boo_message_seekbar_left = (SeekBar) convertView.findViewById(R.id.boolax_boo_message_seekbar_left);
            viewHolder.boolax_boo_message_time_left = (TextView) convertView.findViewById(R.id.boolax_boo_message_time_left);
            viewHolder.boolax_boo_message_audio_caption_left = (TextView) convertView.findViewById(R.id.boolax_boo_message_audio_caption_left);

            viewHolder.boolax_boo_message_image_left = (ImageView) convertView.findViewById(R.id.boolax_boo_message_image_left);
            viewHolder.boolax_boo_message_image_caption_left = (TextView) convertView.findViewById(R.id.boolax_boo_message_image_caption_left);
            viewHolder.boolax_boo_message_rec_time_left = (TextView) convertView.findViewById(R.id.boolax_boo_message_rec_time_left);

            viewHolder.boolax_boo_message_delivered_left = (ImageView) convertView.findViewById(R.id.boolax_boo_message_delivered_left);
            viewHolder.boolax_boo_message_sent_left = (ImageView) convertView.findViewById(R.id.boolax_boo_message_sent_left);
            viewHolder.boolax_boo_message_not_sent_left = (ImageView) convertView.findViewById(R.id.boolax_boo_message_not_sent_left);
            viewHolder.boolax_boo_message_seen_left = (ImageView) convertView.findViewById(R.id.boolax_boo_message_seen_left);
            viewHolder.boolax_boo_message_time_tot_left = (TextView) convertView.findViewById(R.id.boolax_boo_message_time_tot_left);
            viewHolder.progress_2_left = (IconRoundCornerProgressBar) convertView.findViewById(R.id.progress_2_left);
            viewHolder.the_image_preview_left = (LinearLayout) convertView.findViewById(R.id.theimagepreview_left);

            viewHolder.theNoneText_left = (LinearLayout) convertView.findViewById(R.id.theNoneText_left);


            viewHolder.ic_pause_circle_outline_black_24dp_left = (ImageView) convertView.findViewById(R.id.ic_pause_circle_outline_black_24dp_left);
            //-------Differentiate the  parallel data
            if (chat_sender[position].equalsIgnoreCase(my_local_id)) {
                new My_Boolax_boxes_find_avatars(c, Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(), chat_sender[position], viewHolder.boolax_boo_avatar_left).execute();

            } else {
                new My_Boolax_boxes_find_avatars(c, Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(), chat_sender[position], viewHolder.boolax_boo_avatar_left).execute();

            }
            try {
                viewHolder.boolax_boo_message_delivered_left.setVisibility(View.GONE);
                viewHolder.boolax_boo_message_sent_left.setVisibility(View.GONE);
                viewHolder.boolax_boo_message_not_sent_left.setVisibility(View.GONE);
                viewHolder.boolax_boo_message_seen_left.setVisibility(View.GONE);
            } catch (RuntimeException ff) {

            }
            //-------show appropriate status
            if (chat_status[position].equalsIgnoreCase("0")) {
                //---not sent
                viewHolder.boolax_boo_message_not_sent_left.setVisibility(View.VISIBLE);

            } else if (chat_status[position].equalsIgnoreCase("1")) {
                //---sent
                viewHolder.boolax_boo_message_sent_left.setVisibility(View.VISIBLE);

            } else if (chat_status[position].equalsIgnoreCase("2")) {
                //---delivered
                viewHolder.boolax_boo_message_delivered_left.setVisibility(View.VISIBLE);

            } else if (chat_status[position].equalsIgnoreCase("3")) {
                //---seen-------------
                viewHolder.boolax_boo_message_seen_left.setVisibility(View.VISIBLE);
            }
            //-------------------show appropriate data type
            viewHolder.boolax_boo_message_actual_txt_msg_left.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_audio_play_btn_left.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_seekbar_left.setVisibility(View.GONE);
            //viewHolder.boolax_boo_message_time.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_audio_caption_left.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_image_left.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_image_caption_left.setVisibility(View.GONE);
            //viewHolder.boolax_boo_message_rec_time.setVisibility(View.GONE);

            viewHolder.boolax_boo_message_time_tot_left.setVisibility(View.GONE);
            viewHolder.ic_pause_circle_outline_black_24dp_left.setVisibility(View.GONE);
            viewHolder.boolax_boo_message_time_left.setVisibility(View.GONE);
            //viewHolder.theNoneText.setVisibility(View.GONE);
            viewHolder.the_image_preview_left.setVisibility(View.GONE);

            if (chat_type[position].equalsIgnoreCase("image")) {
                viewHolder.boolax_boo_message_image_left.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_image_caption_left.setVisibility(View.VISIBLE);
                viewHolder.theNoneText_left.setVisibility(View.VISIBLE);
                viewHolder.the_image_preview_left.setVisibility(View.VISIBLE);
                //------------
                viewHolder.theNoneText_left.setMinimumWidth(200);
                //----------
                viewHolder.boolax_boo_message_image_caption_left.setText(actual_message_[position] + actual_message_[position]);
                //-------------------
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/boolax_images/" + actual_message[position];
                RequestOptions options = new RequestOptions()
                        .centerCrop()
                        .placeholder(R.mipmap.failed)
                        .error(R.mipmap.failed)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH);
                Glide.with(c)
                        .load(Uri.fromFile(new File(filePath)))
                        .apply(options)
                        .into(viewHolder.boolax_boo_message_image_left);

            } else if (chat_type[position].equalsIgnoreCase("video")) {
                viewHolder.boolax_boo_message_image_left.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_image_caption_left.setVisibility(View.VISIBLE);
                viewHolder.the_image_preview_left.setVisibility(View.VISIBLE);
                //------------------
                viewHolder.boolax_boo_message_image_caption_left.setText("" + actual_message_[position]);
                viewHolder.theNoneText_left.setVisibility(View.VISIBLE);
                //-------------
                final String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/boolax_videos/" + actual_message[position];
                RequestOptions options = new RequestOptions()
                        .centerCrop()
                        .placeholder(R.mipmap.failed)
                        .error(R.mipmap.failed)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH);
                Glide.with(c)
                        .load(Uri.fromFile(new File(filePath)))
                        .apply(options)
                        .into(viewHolder.boolax_boo_message_image_left);
                //-------------------

                viewHolder.boolax_boo_message_image_left.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(c, MyPlayerActivity.class);
                        intent.putExtra("theVideoUrl", filePath);
                        ((Activity) c).startActivity(intent);
                    }
                });


            } else if (chat_type[position].equalsIgnoreCase("text")) {
                viewHolder.boolax_boo_message_actual_txt_msg_left.setVisibility(View.VISIBLE);
                //---------------------
                viewHolder.boolax_boo_message_actual_txt_msg_left.setText( actual_message[position]);


            } else if (chat_type[position].equalsIgnoreCase("audio")) {
                viewHolder.boolax_boo_message_audio_caption_left.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_rec_time_left.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_seekbar_left.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_audio_play_btn_left.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_time_tot_left.setVisibility(View.VISIBLE);
                viewHolder.ic_pause_circle_outline_black_24dp_left.setVisibility(View.VISIBLE);
                viewHolder.boolax_boo_message_time_left.setVisibility(View.VISIBLE);
                viewHolder.theNoneText_left.setVisibility(View.VISIBLE);
                //----------------------------------------------
                viewHolder.ic_pause_circle_outline_black_24dp_left.setVisibility(View.GONE);
                viewHolder.boolax_boo_message_audio_caption_left.setText("" + actual_message_[position]);
                //------------------------------
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/boolax_audios/" + actual_message[position];
                // AudioWife takes care of click handler for play/pause button
                try {
                    AudioWife.getInstance().release();
                    AudioWife.getInstance()
                            .init(c, Uri.fromFile(new File(filePath)))
                            .setPlayView(viewHolder.boolax_boo_message_audio_play_btn_left)
                            .setPauseView(viewHolder.ic_pause_circle_outline_black_24dp_left)
                            .setSeekBar(viewHolder.boolax_boo_message_seekbar_left)
                            .setRuntimeView(viewHolder.boolax_boo_message_time_left)
                            .setTotalTimeView(viewHolder.boolax_boo_message_time_tot_left);
                } catch (Exception jfjj) {

                }

            }
            viewHolder.boolax_boo_message_rec_time_left.setVisibility(View.VISIBLE);
            viewHolder.boolax_boo_message_rec_time_left.setText(" " + regdate[position]);

        }
        //---------------------------


        //--------


        //--------


        return convertView;
    }

    @Override
    public String glideName() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public static class ViewHolder {
        static CircleImageView boolax_boo_avatar;
        static TextView boolax_boo_message_actual_txt_msg;
        static ImageView boolax_boo_message_audio_play_btn;
        static SeekBar boolax_boo_message_seekbar;
        static TextView boolax_boo_message_time;
        static TextView boolax_boo_message_audio_caption;
        //---
        static ImageView boolax_boo_message_image;
        static TextView boolax_boo_message_image_caption;
        static TextView boolax_boo_message_rec_time;

        static ImageView boolax_boo_message_delivered;
        static ImageView boolax_boo_message_sent;
        static ImageView boolax_boo_message_not_sent;
        static ImageView boolax_boo_message_seen;
        static TextView boolax_boo_message_time_tot;

        static ImageView ic_pause_circle_outline_black_24dp;

        static IconRoundCornerProgressBar progress_2;
        LinearLayout theNoneText;
        LinearLayout the_image_preview;
        static LinearLayout right_audio_holder;
        //--------------
        static CircleImageView boolax_boo_avatar_left;
        static TextView boolax_boo_message_actual_txt_msg_left;
        static ImageView boolax_boo_message_audio_play_btn_left;
        static SeekBar boolax_boo_message_seekbar_left;
        static TextView boolax_boo_message_time_left;
        static TextView boolax_boo_message_audio_caption_left;
        //---
        static ImageView boolax_boo_message_image_left;
        static TextView boolax_boo_message_image_caption_left;
        static TextView boolax_boo_message_rec_time_left;

        static ImageView boolax_boo_message_delivered_left;
        static ImageView boolax_boo_message_sent_left;
        static ImageView boolax_boo_message_not_sent_left;
        static ImageView boolax_boo_message_seen_left;
        static TextView boolax_boo_message_time_tot_left;

        static ImageView ic_pause_circle_outline_black_24dp_left;

        static IconRoundCornerProgressBar progress_2_left;
        LinearLayout theNoneText_left;
        LinearLayout the_image_preview_left;


        int position;

        public ViewHolder(View view) {

        }
    }


}
