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
public class Boolax_favorite_send_add_passwords extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String remoteUrl_local;
    //-------------
    String remoteId_local;
    String boolax_user_email_local;
    String boolax_password_local;
    String boolax_user_phone_local;

    public Boolax_favorite_send_add_passwords(Context c, String remoteUrl, String remoteId, String boolax_user_email,
                                              String boolax_password,
                                              String boolax_user_phone
                                              ) {
        this.c = c;
        //---------------
        this.remoteUrl_local = remoteUrl;
        this.remoteId_local = remoteId;
        //---------------
        this.boolax_user_email_local = boolax_user_email;
        this.boolax_password_local = boolax_password;
        this.boolax_user_phone_local = boolax_user_phone;

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
            if(jsonData.contains("1010-cyuma")){
                Toasty.info(c, "Email Is  Already Registered, use Another one!", Toast.LENGTH_SHORT, true).show();

            }else if(jsonData.contains("1110-cyuma")){
                Toasty.info(c, "Phone Number Is  Already Registered, use Another one!", Toast.LENGTH_SHORT, true).show();

            }else {
                new Boolax_favorite_add_passwords_parse(c, jsonData).execute();
            }
            Log.w("josn_", jsonData);


        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_favorite_send_add_passwords_connect.connect( remoteUrl_local,
         remoteId_local,
         boolax_user_email_local,
         boolax_password_local,
         boolax_user_phone_local);
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
