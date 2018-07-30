package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;

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
public class Boolax_favorite_booers_download_actual_lovers extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String myRemoteId;
    String streamOfActualLovers;
    String theRemoteUrl;
    String UserGender;

    public Boolax_favorite_booers_download_actual_lovers(Context c, String theRemoteUrl, String myRemoteId, String streamOfActualLovers) {
        this.c = c;
        //---------------
        this.myRemoteId = myRemoteId;
        this.streamOfActualLovers = streamOfActualLovers;
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

            //Toasty.error(c, "No internet connection!", Toast.LENGTH_SHORT, true).show();
            //----------Get the temporary boos-----

            //-------------
        } else {
            final NDS_boolax_db_adapter thDb;
            thDb = new NDS_boolax_db_adapter(c);
            thDb.openToWrite();

            Cursor allUsersSaved = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_ACTUAL_LOVERS();
            Log.w("json_00", jsonData+" the actual boos  "+allUsersSaved.getCount());

            //parse the json--
            new Boolax_favorite_booers_download_actual_lovers_parse(c, jsonData).execute();

        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_favorite_download_actual_lovers_connect.connect(theRemoteUrl, myRemoteId, streamOfActualLovers);
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
