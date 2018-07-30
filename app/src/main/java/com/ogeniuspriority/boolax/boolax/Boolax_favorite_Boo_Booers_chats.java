package com.ogeniuspriority.boolax.boolax;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.libizo.CustomEditText;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_actual_lovers;

import de.hdodenhof.circleimageview.CircleImageView;
import android.text.TextWatcher;
import android.widget.Toast;

public class Boolax_favorite_Boo_Booers_chats extends AppCompatActivity {
    boolean search_enbled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_favorite__boo__booers_chats);
        ListView boolax_boos_list = (ListView) findViewById(R.id.boolax_boos_list);
        // Initilization
        getSupportActionBar().hide();
        NDS_boolax_db_adapter thDb;
        thDb = new NDS_boolax_db_adapter(Boolax_favorite_Boo_Booers_chats.this);
        thDb.openToWrite();
        Cursor actual_lovers = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_ACTUAL_LOVERS();
        //--------------------
        String[] fname = new String[actual_lovers.getCount()], lname = new String[actual_lovers.getCount()],
                gender = new String[actual_lovers.getCount()], email = new String[actual_lovers.getCount()], username = new String[actual_lovers.getCount()], regdate = new String[actual_lovers.getCount()], age = new String[actual_lovers.getCount()],
                birthdate = new String[actual_lovers.getCount()], country = new String[actual_lovers.getCount()], province = new String[actual_lovers.getCount()], district = new String[actual_lovers.getCount()],
                how_attractive = new String[actual_lovers.getCount()], about_life = new String[actual_lovers.getCount()],
                about_love = new String[actual_lovers.getCount()], about_relationships = new String[actual_lovers.getCount()], about_lover_criteria = new String[actual_lovers.getCount()],
                about_hobbies = new String[actual_lovers.getCount()], about_religious_affiliation = new String[actual_lovers.getCount()], about_academics_and_work = new String[actual_lovers.getCount()],
                avatar_image = new String[actual_lovers.getCount()], remote_id = new String[actual_lovers.getCount()], interested_in = new String[actual_lovers.getCount()], your_weight = new String[actual_lovers.getCount()],
                your_height = new String[actual_lovers.getCount()], skin_color = new String[actual_lovers.getCount()];
        //-----------------------------------
        if (actual_lovers.moveToLast()) {
            for (int i = 0; i < actual_lovers.getCount(); i++) {
                fname[i] = actual_lovers.getString(0);
                lname[i] = actual_lovers.getString(1);
                gender[i] = actual_lovers.getString(2);
                email[i] = actual_lovers.getString(3);
                username[i] = actual_lovers.getString(4);
                regdate[i] = actual_lovers.getString(5);
                age[i] = actual_lovers.getString(6);
                birthdate[i] = actual_lovers.getString(7);
                country[i] = actual_lovers.getString(8);
                province[i] = actual_lovers.getString(9);
                district[i] = actual_lovers.getString(10);
                how_attractive[i] = actual_lovers.getString(11);
                about_life[i] = actual_lovers.getString(12);
                about_love[i] = actual_lovers.getString(13);
                about_relationships[i] = actual_lovers.getString(14);
                about_lover_criteria[i] = actual_lovers.getString(15);
                about_hobbies[i] = actual_lovers.getString(16);
                about_religious_affiliation[i] = actual_lovers.getString(17);
                about_academics_and_work[i] = actual_lovers.getString(18);
                avatar_image[i] = actual_lovers.getString(19);
                remote_id[i] = actual_lovers.getString(20);

                interested_in[i] = actual_lovers.getString(22);
                your_height[i] = actual_lovers.getString(24);
                your_weight[i] = actual_lovers.getString(23);
                skin_color[i] = actual_lovers.getString(25);


                actual_lovers.moveToPrevious();

            }
            //---------
            boolax_boos_list.setAdapter(new custom_adapter_for_actual_lovers(Boolax_favorite_Boo_Booers_chats.this, fname, lname, gender, email,
                    username, regdate, age, birthdate,
                    country, province, district, how_attractive,
                    about_life, about_love, about_relationships,
                    about_lover_criteria, about_hobbies, about_religious_affiliation, about_academics_and_work, avatar_image, remote_id, interested_in, your_height, your_weight, skin_color));

        }


        //------------The actual lovers chats------------

        boolax_boos_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //---------------------------------
                CircleImageView boolax_boo_avatar = (CircleImageView) view.findViewById(R.id.boolax_boo_avatar);
                TextView boolax_boo_name = (TextView) view.findViewById(R.id.boolax_boo_name);
                TextView boolax_boo_age = (TextView) view.findViewById(R.id.boolax_boo_age);
                TextView boolax_boo_location_text = (TextView) view.findViewById(R.id.boolax_boo_location_text);
                TextView boo_add_stream = (TextView) view.findViewById(R.id.boo_add_stream);
                //---------------------------
                //------------Java split function---
                String Str = boo_add_stream.getText().toString();
                //---------------------String value="Hello world";
                Intent i_i = new Intent(Boolax_favorite_Boo_Booers_chats.this, boolax_booers_chats_chatroom.class);
                i_i.putExtra("key", Str);
                startActivity(i_i);

            }
        });
        //------------------Search through the messages---
        search_through_chatties = findViewById(R.id.search_through_chatties);
        ImageView trigger_search_field = findViewById(R.id.trigger_search_field);
        search_enbled = false;
        //------------
        trigger_search_field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (search_enbled) {
                    search_through_chatties.setVisibility(View.INVISIBLE);
                    search_enbled = false;
                } else {
                    search_through_chatties.setVisibility(View.VISIBLE);
                    search_through_chatties.requestFocus();
                    search_enbled = true;
                }

            }
        });
        //-----keyup event on the edittext---
        search_through_chatties.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence cs, int s, int b, int c) {
                //Toast.makeText(Boolax_favorite_Boo_Booers_chats.this,"Typed ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });

    }

    CustomEditText search_through_chatties;

}
