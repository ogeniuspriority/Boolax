package com.ogeniuspriority.boolax.boolax.m_UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.ogeniuspriority.boolax.boolax.Config;
import com.ogeniuspriority.boolax.boolax.R;
import com.ogeniuspriority.boolax.boolax.m_DataObject.Boolax_favorite_booers_boos_objects;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_favorite_booers_custom_adapter_for_boos extends BaseAdapter implements GlideModule{
    Context c;
     ArrayList<Boolax_favorite_booers_boos_objects> my_loaded_remote_boos_search = new ArrayList<Boolax_favorite_booers_boos_objects>();

    //-----
    int layoutResourceId;
    public List<String> data;
    public List<String> tags;
    public List<String> tags_unlike;


    public Boolax_favorite_booers_custom_adapter_for_boos(Context c, ArrayList<Boolax_favorite_booers_boos_objects> my_Community_Posts_) {

        this.c = c;
        this.my_loaded_remote_boos_search = my_Community_Posts_;
        //----------------------------------------------------PlaceholderFragment.MYRemoteId
        // this.layoutResourceId = resource;
        this.c = c;


    }


    @Override
    public int getCount() {

        return my_loaded_remote_boos_search.size();

    }

    @Override
    public Object getItem(int position) {
        return my_loaded_remote_boos_search.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        // viewHolder = new ViewHolder();
        // viewHolder.position = position;
        //-----For folder id,profile_photos
        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.boolax_boo_data_snippet, parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //---------------------------
        final Boolax_favorite_booers_boos_objects boolax_boos = (Boolax_favorite_booers_boos_objects) getItem(position);

        convertView.setTag(viewHolder);

        viewHolder.boolax_boo_avatar = (CircleImageView) convertView.findViewById(R.id.boolax_boo_avatar);
        viewHolder.boolax_boo_location_text = (TextView) convertView.findViewById(R.id.boolax_boo_location_text);
        viewHolder.boolax_boo_name = (TextView) convertView.findViewById(R.id.boolax_boo_name);
        viewHolder.boo_add_stream = (TextView) convertView.findViewById(R.id.boo_add_stream);
        viewHolder.boolax_boo_age = (TextView) convertView.findViewById(R.id.boolax_boo_age);
        viewHolder.request_sent = (FancyButton) convertView.findViewById(R.id.request_sent);
        //--------Load the Image--
        viewHolder.boolax_boo_location_text.setText(boolax_boos.get_Boolax_favorite_booers_boo_Location_Text());
        viewHolder.boolax_boo_name.setText(boolax_boos.get_Boolax_favorite_booers_boo_username());
        viewHolder.boolax_boo_age.setText(boolax_boos.get_Boolax_favorite_booers_boo_Age());
        viewHolder.boo_add_stream.setText(boolax_boos.get_Boolax_favorite_booers_boo_WholeDataStream());
        //--------------
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(c)
                .load(Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS + "/" + my_loaded_remote_boos_search.get(position).get_Boolax_favorite_booers_boo_remoteId() + "/profile_photos/" + my_loaded_remote_boos_search.get(position).get_Boolax_favorite_booers_boo_Avatar())
                .apply(requestOptions.placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder))
                .into(viewHolder.boolax_boo_avatar);


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
