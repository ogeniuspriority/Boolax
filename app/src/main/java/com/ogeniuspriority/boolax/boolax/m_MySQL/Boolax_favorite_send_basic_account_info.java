package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.os.AsyncTask;
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
public class Boolax_favorite_send_basic_account_info extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String myRemoteId;
    String theRemoteUrl;
    //-------------
    String fname_local;
    String lname_local;
    String username_local;
    String birthday_local;
    String country_local;
    String province_local;
    String gender_local;

    public Boolax_favorite_send_basic_account_info(Context c, String theRemoteUrl, String myRemoteId,
                                                   String fname,
                                                   String lname,
                                                   String username,
                                                   String birthday,
                                                   String country,
                                                   String province, String gender) {
        this.c = c;
        //---------------
        this.myRemoteId = myRemoteId;
        this.theRemoteUrl = theRemoteUrl;
        //---------------
        this.fname_local = fname;
        this.lname_local = lname;
        this.username_local = username;
        this.birthday_local = birthday;
        this.country_local = country;
        this.province_local = province;
        this.gender_local = gender;

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
            new Boolax_favorite_parse_user_creds_data_Profile_ini_add_info(c, jsonData).execute();


        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_favorite_send_basic_account_info_connect.connect(theRemoteUrl, myRemoteId, fname_local,
                lname_local,
                username_local,
                birthday_local,
                country_local,
                province_local, gender_local);
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
