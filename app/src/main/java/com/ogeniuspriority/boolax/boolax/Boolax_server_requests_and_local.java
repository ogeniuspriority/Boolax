package com.ogeniuspriority.boolax.boolax;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_favorite_parse_user_creds_data;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_request_user_creds_connect;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

/**
 * Created by USER on 2/19/2018.
 */

public class Boolax_server_requests_and_local extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String theRemoteUrl_local;
    String names_local;
    String email_local;
    String userid_local;
    String login_type_local;
    String gender_local;
    String birthday_local;
    String photo_local;
    String login_api_local;

    public Boolax_server_requests_and_local(Context c, String theRemoteUrl, String names, String email, String userid, String login_type, String gender, String birthday, String photo, String login_api) {
        this.c = c;
        this.names_local = names;
        this.email_local = email;
        //---------------
        this.userid_local = userid;
        this.login_type_local = login_type;
        this.theRemoteUrl_local = theRemoteUrl;
        this.gender_local = gender;
        this.birthday_local = birthday;
        this.photo_local = photo;
        this.login_api_local = login_api;

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
        //-----Json response--
        Log.w("jsonData", (jsonData != null) ? jsonData : "");
        new Boolax_favorite_parse_user_creds_data(c, jsonData).execute();

    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_request_user_creds_connect.connect(theRemoteUrl_local, names_local, email_local, userid_local, login_type_local, gender_local, (birthday_local != null) ? birthday_local : "", photo_local, login_api_local);
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
