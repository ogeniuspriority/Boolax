package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_get_the_string_avatar extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String myRemoteId;
    String theRemoteUrl;
    public Boolax_get_the_string_avatar(Context c, String theRemoteUrl,String myRemoteId) {
        this.c = c;
        this.myRemoteId = myRemoteId;
        this.theRemoteUrl = theRemoteUrl;

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



            //-------------
        } else {

        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_get_the_string_avatar_connect.connect(theRemoteUrl, myRemoteId);
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
