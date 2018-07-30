package com.ogeniuspriority.boolax.boolax.m_UI;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.annotation.GlideModule;
import com.ogeniuspriority.boolax.boolax.Config;
import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.R;
import com.ogeniuspriority.boolax.boolax.boolax_booers_chats_chatroom;

import java.lang.annotation.Annotation;
import java.util.Calendar;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_actual_lovers_send_txt_messages.my_local_id;

/**
 * Created by USER on 2/6/2017.
 */
public class custom_adapter_for_actual_lovers extends BaseAdapter implements GlideModule {
    Context c;

    int layoutResourceId;
    public List<String> data;
    public List<String> tags;
    public List<String> tags_unlike;
    //-------------
    String[] fname;
    String[] lname;
    String[] gender;
    String[] email;
    String[] username;
    String[] regdate;
    String[] age;
    String[] birthdate;
    String[] country;
    String[] province;
    String[] district;
    String[] how_attractive;
    String[] about_life;
    String[] about_love;
    String[] about_relationships;
    String[] about_lover_criteria;
    String[] about_hobbies;
    String[] about_religious_affiliation;
    String[] about_academics_and_work;
    String[] avatar_image;
    String[] remote_id;
    String[] interested_in;
    String[] your_height;
    String[] your_weight;
    String[] your_skin_color;

    NDS_boolax_db_adapter thDb;


    public custom_adapter_for_actual_lovers(Context c, String[] fname, String[] lname, String[] gender, String[] email,
                                            String[] username, String[] regdate, String[] age, String[] birthdate,
                                            String[] country, String[] province, String[] district, String[] how_attractive,
                                            String[] about_life, String[] about_love, String[] about_relationships,
                                            String[] about_lover_criteria, String[] about_hobbies, String[] about_religious_affiliation,
                                            String[] about_academics_and_work, String[] avatar_image, String[] remote_id,
                                            String[] interested_in, String[] your_height, String[] your_weight, String[] your_skin_color) {

        this.c = c;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.email = email;
        this.username = username;
        this.regdate = regdate;
        this.age = age;
        this.birthdate = birthdate;
        this.country = country;
        this.province = province;
        this.district = district;
        this.how_attractive = how_attractive;
        this.about_life = about_life;
        this.about_love = about_love;
        this.about_relationships = about_relationships;
        this.about_lover_criteria = about_lover_criteria;
        this.about_hobbies = about_hobbies;
        this.about_religious_affiliation = about_religious_affiliation;
        this.about_academics_and_work = about_academics_and_work;
        this.avatar_image = avatar_image;
        this.remote_id = remote_id;
        this.interested_in = interested_in;
        this.your_height = your_height;
        this.your_weight = your_weight;
        this.your_skin_color = your_skin_color;
        // this.layoutResourceId = resource;
        this.c = c;
        //--
        thDb = new NDS_boolax_db_adapter(c);
        thDb.openToWrite();


    }


    @Override
    public int getCount() {

        return this.fname.length;

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
        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.boolax_booers_chats_snippet, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //---------------------------
        //final Boolax_favorite_booers_boos_objects boolax_boos = (Boolax_favorite_booers_boos_objects) getItem(position);

        convertView.setTag(viewHolder);

        viewHolder.boolax_event_avatar = (CircleImageView) convertView.findViewById(R.id.boolax_event_avatar);
        viewHolder.boolax_event_name = (TextView) convertView.findViewById(R.id.boo_last_sender_name);
        viewHolder.boolax_chats_last_message = (TextView) convertView.findViewById(R.id.boolax_chats_last_message);
        viewHolder.boolax_chat_time = (TextView) convertView.findViewById(R.id.boolax_chat_time);
        viewHolder.boolax_event_nber_new = (TextView) convertView.findViewById(R.id.boolax_event_nber_new);
        viewHolder.boo_add_stream = (TextView) convertView.findViewById(R.id.boo_add_stream);

        Calendar rightNow = Calendar.getInstance();
        int currentHour = rightNow.get(Calendar.HOUR_OF_DAY);
        int currentMin = rightNow.get(Calendar.MINUTE);
        //------------------
        viewHolder.boolax_event_name.setText(username[position]);
        viewHolder.boolax_event_nber_new.setText("");
        viewHolder.boolax_event_nber_new.setText("");


        //---hour of the last message
        viewHolder.boolax_chat_time.setText(" " + currentHour + ":" + currentMin);

        // viewHolder.boolax_chat_time.setText("Age: " + new AgeCalculator().main_age_calc_from_dob(birthdate[position]).years);
        viewHolder.boo_add_stream.setText(fname[position] + "~" + lname[position] + "~" + gender[position] + "~" + email[position] +
                "~" + username[position] + "~" + regdate[position] + "~" + age[position] + "~" + birthdate[position] +
                "~" + country[position] + "~" + province[position] + "~" + district[position] + "~" + how_attractive[position] +
                "~" + about_life[position] + "~" + about_love[position] + "~" + about_relationships[position] +
                "~" + about_lover_criteria[position] + "~" + about_hobbies[position] + "~" + about_religious_affiliation[position] +
                "~" + about_academics_and_work[position] + "~" + avatar_image[position] + "~" + remote_id[position]
                + "~" + interested_in[position] + "~" + your_height[position] + "~" + your_weight[position] + "~" + your_skin_color[position]);
        //--------------Last Message and time--
        Cursor allSavedMessages = thDb.GET_CHAT_MESSAGES_ALL(remote_id[position]);

        String[] last_date = new String[allSavedMessages.getCount()];
        String[] last_message = new String[allSavedMessages.getCount()];
        String[] last_message_sender = new String[allSavedMessages.getCount()];
        String[] chat_type = new String[allSavedMessages.getCount()];

        String[] chat_sender = new String[allSavedMessages.getCount()];

        viewHolder.boolax_chat_time.setText("");

        viewHolder.boolax_event_name.setText("" + username[position]);
        if (allSavedMessages.moveToFirst()) {
            for (int i = 0; i < allSavedMessages.getCount(); i++) {
                chat_sender[i] = allSavedMessages.getString(4);
                if (chat_sender[i].equalsIgnoreCase(my_local_id)) {

                    last_date[0] = "" + allSavedMessages.getString(4);
                    last_message[0] = "" + allSavedMessages.getString(1);
                    last_message_sender[0] = "" + allSavedMessages.getString(6);
                    chat_type[i] = allSavedMessages.getString(2);
                    //----
                    if (chat_type[i].equalsIgnoreCase("text")) {
                        viewHolder.boolax_chats_last_message.setText("" + last_message[0]);

                    } else if (chat_type[i].equalsIgnoreCase("video")) {
                        viewHolder.boolax_chats_last_message.setText("🎥");

                    } else if (chat_type[i].equalsIgnoreCase("audio")) {
                        viewHolder.boolax_chats_last_message.setText("\uD83D\uDD0A");

                    } else if (chat_type[i].equalsIgnoreCase("image")) {
                        viewHolder.boolax_chats_last_message.setText("\uD83D\uDCF7");

                    }

                    viewHolder.boolax_chat_time.setText("" + last_date[0]);
                }

            }
        }
        //-----------------

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String theAvatarImage = new Boolax_get_the_string_avatar(c, Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(), remote_id[position]).execute().get();
                    Log.w("theAvatarImage",""+Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS + "/" + theAvatarImage);
                    ((Activity) c).runOnUiThread(new Runnable() {
                        public void run() {
                            Glide.with(c)
                                    .load(Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS + "/" + theAvatarImage)
                                    .apply(new RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder))
                                    .into(viewHolder.boolax_boo_avatar);
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        }).start();*/
        //--------
        new My_Boolax_boxes_find_avatars(c, Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(), remote_id[position], viewHolder.boolax_event_avatar).execute();


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
        CircleImageView boolax_event_avatar;
        TextView boolax_event_name;
        TextView boolax_chats_last_message;
        TextView boolax_chat_time;
        TextView boolax_event_nber_new;
        TextView boo_add_stream;

        int position;

        public ViewHolder(View view) {

        }
    }


}
