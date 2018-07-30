package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.ogeniuspriority.boolax.boolax.Boolax_favorite_Boo_Booers_chats;
import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.m_DataObject.Boolax_favorite_booers_boos_objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_favorite_search_through_chatties extends AsyncTask<Void, Void, Boolean> {
    Context c;
    String searchKeyword;

    String[] Boolax_favorite_booers_boos_remoteIds;
    //-----------
    String[] fname , lname,
            gender, email, username,regdate,age,
            birthdate,country,province,district,
            how_attractive,about_life,
            about_love,about_relationships,about_lover_criteria,
            about_hobbies,about_religious_affiliation, about_academics_and_work,
            avatar_image,remote_id,interested_in,your_weight,
            your_height, skin_color;

    //----------------
    ListView boolax_boos_list;

    NDS_boolax_db_adapter thDb;


    public Boolax_favorite_search_through_chatties(Context c, String searchKeyword, ListView boolax_boos_list) {
        this.c = c;
        this.searchKeyword = searchKeyword;
        this.boolax_boos_list = boolax_boos_list;
        thDb = new NDS_boolax_db_adapter(c);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);
        // swipe_view.setRefreshing(false);
        if (isParsed) {
            //-----------

        } else {


        }
    }

    private Boolean parseData() {
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

            return true;
        }
        return true;
    }
}
