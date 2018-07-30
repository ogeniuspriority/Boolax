package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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
public class Boolax_favorite_send_add_features_info extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String myRemoteId;
    String theRemoteUrl;
    //-------------
    String about_religious_affiliation_data_local;
    String how_attractive_data_local;
    String about_life_data_local;
    String about_love_data_local;
    String about_relationship_data_local;
    String about_lover_criteria_data_local;
    String about_hobbies_data_local;
    String about_academics_and_work_local;

    public Boolax_favorite_send_add_features_info(Context c, String theRemoteUrl, String myRemoteId,
                                                  String how_attractive_data,
                                                  String about_life_data,
                                                  String about_love_data,
                                                  String about_relationship_data,
                                                  String about_lover_criteria_data,
                                                  String about_hobbies_data, String about_religious_affiliation_data
            , String about_academics_and_work_data) {
        this.c = c;
        //---------------
        this.myRemoteId = myRemoteId;
        this.theRemoteUrl = theRemoteUrl;
        //---------------
        this.about_religious_affiliation_data_local = about_religious_affiliation_data;
        this.how_attractive_data_local = how_attractive_data;
        this.about_life_data_local = about_life_data;
        this.about_love_data_local = about_love_data;
        this.about_relationship_data_local = about_relationship_data;
        this.about_lover_criteria_data_local = about_lover_criteria_data;
        this.about_hobbies_data_local = about_hobbies_data;
        this.about_academics_and_work_local = about_academics_and_work_data;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

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
        if (jsonData == null) {

            Toasty.error(c, "No internet connection!", Toast.LENGTH_SHORT, true).show();
        } else {
            //parse the json--
            new Boolax_favorite_parse_user_creds_data_add_features_parse(c, jsonData).execute();
            Log.w("josn_", jsonData);


        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_favorite_send_add_features_info_connect.connect(theRemoteUrl, myRemoteId, about_religious_affiliation_data_local,
                how_attractive_data_local,
                about_life_data_local,
                about_love_data_local,
                about_relationship_data_local,
                about_lover_criteria_data_local,
                about_hobbies_data_local,about_academics_and_work_local);
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
