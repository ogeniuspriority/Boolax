package com.ogeniuspriority.boolax.boolax.m_UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.annotation.GlideModule;
import com.ogeniuspriority.boolax.boolax.Config;
import com.ogeniuspriority.boolax.boolax.R;
import com.ogeniuspriority.boolax.boolax.utilities.AgeCalculator;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by USER on 2/6/2017.
 */
public class custom_adapter_for_booers extends BaseAdapter implements GlideModule {
    Context c;


    //-----
    int layoutResourceId;
    public List<String> data;
    public List<String> tags;
    public List<String> tags_unlike;
    //-----------------------------------
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
    String[] like_status;
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


    public custom_adapter_for_booers(Context c, String[] fname, String[] lname, String[] gender, String[] email,
                                     String[] username, String[] regdate, String[] age, String[] birthdate,
                                     String[] country, String[] province, String[] district, String[] how_attractive,
                                     String[] like_status, String[] about_life, String[] about_love, String[] about_relationships,
                                     String[] about_lover_criteria, String[] about_hobbies, String[] about_religious_affiliation,
                                     String[] about_academics_and_work, String[] avatar_image, String[] remote_id,
                                     String[] interested_in,String[] your_height,String[] your_weight,String[] your_skin_color) {

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
        this.like_status = like_status;
        this.about_life = about_life;
        this.about_love = about_love;
        this.about_relationships = about_relationships;
        this.about_lover_criteria = about_lover_criteria;
        this.about_hobbies = about_hobbies;
        this.about_religious_affiliation = about_religious_affiliation;
        this.about_academics_and_work = about_academics_and_work;
        this.avatar_image = avatar_image;
        this.remote_id = remote_id;

        this.interested_in=interested_in;
        this.your_height=your_height;
        this.your_weight=your_weight;
        this.your_skin_color=your_skin_color;
        // this.layoutResourceId = resource;
        //----------------------------------------------------PlaceholderFragment.MYRemoteId
        // this.layoutResourceId = resource;
        this.c = c;


    }


    @Override
    public int getCount() {

        return this.lname.length;

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
            convertView = LayoutInflater.from(c).inflate(R.layout.boolax_boo_data_snippet, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //---------------------------
       // final Boolax_favorite_booers_boos_objects boolax_boos = (Boolax_favorite_booers_boos_objects) getItem(position);

        convertView.setTag(viewHolder);

        viewHolder.boolax_boo_avatar = (CircleImageView) convertView.findViewById(R.id.boolax_boo_avatar);
        viewHolder.boolax_boo_location_text = (TextView) convertView.findViewById(R.id.boolax_boo_location_text);
        viewHolder.boolax_boo_name = (TextView) convertView.findViewById(R.id.boolax_boo_name);
        viewHolder.boo_add_stream = (TextView) convertView.findViewById(R.id.boo_add_stream);
        viewHolder.boolax_boo_age = (TextView) convertView.findViewById(R.id.boolax_boo_age);
        viewHolder.request_sent = (FancyButton) convertView.findViewById(R.id.request_sent);
        //--------Load the Image--
        viewHolder.boolax_boo_location_text.setText(country[position] + ", " + province[position] + ", " + district[position]);
        viewHolder.boolax_boo_name.setText(username[position]);
        viewHolder.boolax_boo_age.setText("");
        try {
            viewHolder.boolax_boo_age.setText("Age: " + new AgeCalculator().main_age_calc_from_dob(birthdate[position]).years);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        viewHolder.boo_add_stream.setText(fname[position] + "~" + lname[position] + "~" + gender[position] + "~" + email[position] +
                "~" + username[position] + "~" + regdate[position] + "~" + age[position] + "~" + birthdate[position] +
                "~" + country[position] + "~" + province[position] + "~" + district[position] + "~" + how_attractive[position] +
                "~" + like_status[position] + "~" + about_life[position] + "~" + about_love[position] + "~" + about_relationships[position] +
                "~" + about_lover_criteria[position] + "~" + about_hobbies[position] + "~" + about_religious_affiliation[position] +
                "~" + about_academics_and_work[position] + "~" + avatar_image[position] + "~" + remote_id[position]
                + "~" + interested_in[position]+ "~" + your_height[position]+ "~" + your_weight[position]+ "~" + your_skin_color[position]);
        //--------------
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String theAvatarImage=new Boolax_get_the_string_avatar(c,Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(),remote_id[position]).execute().get();
                    ((Activity) c).runOnUiThread(new Runnable() {
                        public void run() {
                            Glide.with(c)
                                    .load(Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS + "/"+theAvatarImage)
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
        new My_Boolax_boxes_find_avatars(c, Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(), remote_id[position],viewHolder.boolax_boo_avatar).execute();



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

    static class ViewHolder {
        CircleImageView boolax_boo_avatar;
        TextView boolax_boo_location_text;
        TextView boolax_boo_name;
        TextView boo_add_stream;
        TextView boolax_boo_age;
        FancyButton request_sent;
        int position;

        public ViewHolder(View view) {

        }
    }


}
