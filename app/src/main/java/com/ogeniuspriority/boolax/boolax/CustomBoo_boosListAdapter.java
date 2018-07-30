package com.ogeniuspriority.boolax.boolax;

/**
 * Created by USER on 1/5/2018.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomBoo_boosListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<boolax_boo_data_stream> boolax_boo_avatar_items;


    public CustomBoo_boosListAdapter(Activity activity, List<boolax_boo_data_stream> boolax_boo_avatar_items) {
        this.activity = activity;
        this.boolax_boo_avatar_items = boolax_boo_avatar_items;
    }

    @Override
    public int getCount() {
        return boolax_boo_avatar_items.size();
    }

    @Override
    public Object getItem(int location) {
        return boolax_boo_avatar_items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.boolax_boo_data_snippet, null);
            viewHolder = new ViewHolder();


            viewHolder.thumbNail = (CircleImageView) convertView
                    .findViewById(R.id.boolax_boo_avatar);
            viewHolder.boolax_boo_name = (TextView) convertView.findViewById(R.id.boolax_boo_name);
            viewHolder.boolax_boo_age = (TextView) convertView.findViewById(R.id.boolax_boo_age);
            viewHolder.boolax_boo_location_text = (TextView) convertView.findViewById(R.id.boolax_boo_location_text);
            viewHolder.boo_add_stream = (TextView) convertView.findViewById(R.id.boo_add_stream);
            //-----Use glide to load images--
            convertView.setTag(viewHolder);
            convertView.setTag(R.id.boolax_boo_name, viewHolder.boolax_boo_name);
            convertView.setTag(R.id.boolax_boo_age, viewHolder.boolax_boo_age);
            convertView.setTag(R.id.boolax_boo_location_text, viewHolder.boolax_boo_location_text);
            convertView.setTag(R.id.boo_add_stream, viewHolder.boo_add_stream);
            convertView.setTag(R.id.boolax_boo_avatar, viewHolder.thumbNail);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }
    static class ViewHolder {
        protected TextView boolax_boo_name;
        protected TextView boolax_boo_age;
        protected TextView boolax_boo_location_text;
        protected TextView boo_add_stream;
        protected CircleImageView thumbNail;
    }

}
