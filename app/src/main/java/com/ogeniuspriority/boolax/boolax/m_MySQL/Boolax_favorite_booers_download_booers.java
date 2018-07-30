package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_booers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import es.dmoral.toasty.Toasty;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_favorite_booers_download_booers extends AsyncTask<Void, Void, String> {
    Context c;
    ListView boolax_boos_list;
    SwipeRefreshLayout pull_to_refresh;
    //----------------
    String myRemoteId;
    String streamOfMyAcknowledgesBoos;
    String theRemoteUrl;
    String UserGender;

    public Boolax_favorite_booers_download_booers(Context c, String theRemoteUrl, String UserGender, String myRemoteId, ListView boolax_boos_list, SwipeRefreshLayout pull_to_refresh, String streamOfMyAcknowledgesBoos) {
        this.c = c;
        this.boolax_boos_list = boolax_boos_list;
        this.pull_to_refresh = pull_to_refresh;
        //---------------
        this.myRemoteId = myRemoteId;
        this.streamOfMyAcknowledgesBoos = streamOfMyAcknowledgesBoos;
        this.theRemoteUrl = theRemoteUrl;
        this.UserGender = UserGender;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (!pull_to_refresh.isRefreshing()) {
            pull_to_refresh.setRefreshing(true);
        }
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            return this.downloadData();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        pull_to_refresh.setRefreshing(false);


        if (jsonData == null) {

            Toasty.error(c, "No internet connection!", Toast.LENGTH_SHORT, true).show();
            NDS_boolax_db_adapter thDb;
            thDb = new NDS_boolax_db_adapter(c);
            thDb.openToWrite();
            Cursor allUsersSaved = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOERS();
            //----------the arrays--
            if (allUsersSaved.moveToLast()) {
                //----------the arrays--
                String[] fname = new String[allUsersSaved.getCount()];
                String[] lname = new String[allUsersSaved.getCount()];
                String[] gender = new String[allUsersSaved.getCount()];
                String[] email = new String[allUsersSaved.getCount()];
                String[] username = new String[allUsersSaved.getCount()];
                String[] regdate = new String[allUsersSaved.getCount()];
                String[] age = new String[allUsersSaved.getCount()];
                String[] birthdate = new String[allUsersSaved.getCount()];
                String[] country = new String[allUsersSaved.getCount()];
                String[] province = new String[allUsersSaved.getCount()];
                String[] district = new String[allUsersSaved.getCount()];
                String[] how_attractive = new String[allUsersSaved.getCount()];
                String[] like_status = new String[allUsersSaved.getCount()];
                String[] about_life = new String[allUsersSaved.getCount()];
                String[] about_love = new String[allUsersSaved.getCount()];
                String[] about_relationships = new String[allUsersSaved.getCount()];
                String[] about_lover_criteria = new String[allUsersSaved.getCount()];
                String[] about_hobbies = new String[allUsersSaved.getCount()];
                String[] about_religious_affiliation = new String[allUsersSaved.getCount()];
                String[] about_academics_and_work = new String[allUsersSaved.getCount()];
                String[] avatar_image = new String[allUsersSaved.getCount()];
                String[] remote_id = new String[allUsersSaved.getCount()];

                String[] interested_in = new String[allUsersSaved.getCount()];
                String[] your_height = new String[allUsersSaved.getCount()];
                String[] your_weight = new String[allUsersSaved.getCount()];
                String[] skin_color = new String[allUsersSaved.getCount()];

                for (int i = 0; i < allUsersSaved.getCount(); i++) {
                    fname[i] = allUsersSaved.getString(0);
                    lname[i] = allUsersSaved.getString(1);
                    gender[i] = allUsersSaved.getString(2);
                    email[i] = allUsersSaved.getString(3);
                    username[i] = allUsersSaved.getString(4);
                    regdate[i] = allUsersSaved.getString(5);
                    age[i] = allUsersSaved.getString(6);
                    birthdate[i] = allUsersSaved.getString(7);
                    country[i] = allUsersSaved.getString(8);
                    province[i] = allUsersSaved.getString(9);
                    district[i] = allUsersSaved.getString(10);
                    how_attractive[i] = allUsersSaved.getString(11);
                    like_status[i] = allUsersSaved.getString(21);
                    about_life[i] = allUsersSaved.getString(12);
                    about_love[i] = allUsersSaved.getString(13);
                    about_relationships[i] = allUsersSaved.getString(14);
                    about_lover_criteria[i] = allUsersSaved.getString(15);
                    about_hobbies[i] = allUsersSaved.getString(16);
                    about_religious_affiliation[i] = allUsersSaved.getString(17);
                    about_academics_and_work[i] = allUsersSaved.getString(18);
                    avatar_image[i] = allUsersSaved.getString(19);
                    remote_id[i] = allUsersSaved.getString(20);

                    interested_in[i] = allUsersSaved.getString(22);
                    your_height[i] = allUsersSaved.getString(24);
                    your_weight[i] = allUsersSaved.getString(23);
                    skin_color[i] = allUsersSaved.getString(25);

                    allUsersSaved.moveToPrevious();

                }
                //------------open list adapter
                //--------Display on the canvas---------
                //--------Display on the canvas---------
                boolax_boos_list.setAdapter(new custom_adapter_for_booers(c, fname, lname, gender, email,
                        username, regdate, age, birthdate,
                        country, province, district, how_attractive,
                        like_status, about_life, about_love, about_relationships,
                        about_lover_criteria, about_hobbies, about_religious_affiliation, about_academics_and_work, avatar_image, remote_id,
                        interested_in, your_height, your_weight, skin_color));


            }
        } else {
            Log.w("booers_",""+jsonData);

            //parse the json--

            new Boolax_favorite_booers_parse_booers_save_local(c, jsonData, boolax_boos_list).execute();

        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_favorite_booers_connect_to_remote.connect(theRemoteUrl, myRemoteId, UserGender, streamOfMyAcknowledgesBoos);
        if (con == null) {
            return null;
        }
        try {
            InputStream is = new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuffer jsonData = new StringBuffer();
            while ((line = br.readLine()) != null) {
                jsonData.append(line + "\n");
            }
            // Send post request

            br.close();
            is.close();


            return jsonData.toString();


        } catch (IOException e) {
            e.printStackTrace();


        }


        return null;
    }
}
